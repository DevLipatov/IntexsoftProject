package by.intexsoft.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;
import java.util.List;
import static javax.persistence.FetchType.LAZY;

/**
 * User model for user entities
 */
@Entity
@Table(name = "users")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User extends AbstractEntity {

    private static final long serialVersionUID = 6015196365539799130L;

    @Column(name = "username")
    public String username;

    @Column(name = "password")
    public String password;

    @ManyToMany
    @JsonManagedReference
    @JoinTable(name = "users_authorities",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id"))
    public List<Authority> authorities;

    @OneToMany(mappedBy = "user", fetch = LAZY)
    public List<Theme> themes;

    @OneToMany(mappedBy = "user", fetch = LAZY)
    public List<Comment> comments;
}
