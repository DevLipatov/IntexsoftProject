package by.intexsoft.backend.model;

/**
 * Class that represent object to response after login
 */
public class TokenObject {

    /**
     * Name of logged user
     */
    public String username;

    /**
     * Role of logged user
     */
    public String role;

    /**
     * Created token for current user
     */
    public String token;
}
