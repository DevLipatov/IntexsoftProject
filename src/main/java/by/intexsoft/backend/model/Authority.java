package by.intexsoft.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.security.core.GrantedAuthority;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * Simple blueprint for authority entity. Corresponding table holds information
 * about access granted to the users
 */
@Entity
@Table(name = "authorities")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Authority extends AbstractEntity implements GrantedAuthority {

    private static final long serialVersionUID = 7346118302006431092L;

    @Column(name = "authority")
    public String authority;

    @Override
    public String getAuthority() {
        return this.authority;
    }

    @ManyToMany(mappedBy = "authorities")
    @JsonBackReference
    public List<User> users;
}
