package by.intexsoft.backend.service.impl;

import by.intexsoft.backend.model.User;
import by.intexsoft.backend.service.AuthenticationService;
import by.intexsoft.backend.service.UserService;
import ch.qos.logback.classic.Logger;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(AuthenticationServiceImpl.class);
    private static final int EXPIRATION_HOURS = 24;
    private static final String KEY_WORD = "key";
    private static final String HEADER = "Authorization";

    @Autowired
    private UserService userService;

    //TODO clean logs
    @Override
    public String generateToken(User user, String password) {
        LOGGER.info("Start generate token for " + user.username);
        if (user == null || password == null)
            return null;
        if (!password.equals(user.password)) return null;
        Map<String, Object> tokenData = new HashMap<>();
        tokenData.put("scopes", AuthorityUtils.authorityListToSet(user.authorities));
        tokenData.put("username", user.username);
        tokenData.put("password", user.password);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, EXPIRATION_HOURS);
        tokenData.put("expiration_time", calendar.getTime());
        JwtBuilder jwtBuilder = Jwts.builder();
        jwtBuilder.setExpiration(calendar.getTime());
        jwtBuilder.setClaims(tokenData);
        String token = "TOKEN";
        return token;
    }

    @Override
    public Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(HEADER);
        if (token == null) return null;
        Jws<Claims> tokenData = Jwts.parser().setSigningKey(KEY_WORD).parseClaimsJws(token);
        String username = tokenData.getBody().get("username").toString();
        User user = userService.findByUsername(username);
        String password = tokenData.getBody().get("password").toString();
        List authorities = tokenData.getBody().get("scopes", List.class);
        return new UsernamePasswordAuthenticationToken(username, password,
                AuthorityUtils.commaSeparatedStringToAuthorityList(String.join(",", authorities)));
    }

    @Override
    public Authentication getAuthentication(String token) {
        if (token == null) return null;
        Jws<Claims> tokenData = Jwts.parser().setSigningKey(KEY_WORD).parseClaimsJws(token);
        String username = tokenData.getBody().get("username").toString();
        String password = tokenData.getBody().get("password").toString();
        List authorities = tokenData.getBody().get("scopes", List.class);
        return new UsernamePasswordAuthenticationToken(username, password,
                AuthorityUtils.commaSeparatedStringToAuthorityList(String.join(",", authorities)));
    }
}
