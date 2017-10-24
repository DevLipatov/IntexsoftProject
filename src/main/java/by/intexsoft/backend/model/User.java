package by.intexsoft.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.util.List;
import static javax.persistence.FetchType.EAGER;

/**
 * User model for user entities
 */
@Entity
@Table(name = "users")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User extends AbstractEntity {

    private static final long serialVersionUID = 6015196365539799130L;

    public User() {
    }

    /**
     * Constructor for the purposes of authentication
     *
     * @param user to get details of
     */
    public User(User user) {
        this.username = user.username;
        this.password = user.password;
        this.authorities = user.authorities;
    }

    @Column(name = "username")
    public String username;

    @Column(name = "password")
    public String password;

    @ManyToMany(fetch = EAGER)
    @JoinTable(name = "users_authorities",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id"))
    @JsonIgnoreProperties("users")
    public List<Authority> authorities;
}
