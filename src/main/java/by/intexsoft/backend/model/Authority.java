package by.intexsoft.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.security.core.GrantedAuthority;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Simple blueprint for authority entity. Corresponding table holds information
 * about access granted to the users
 */
@Entity
@Table(name = "authorities")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Authority extends AbstractEntity implements GrantedAuthority {

    private static final long serialVersionUID = 7258273500531914075L;

    /**
     * Maps field to the column "authority" in database. Name of the authority
     */
    @Column(name = "authority")
    public String authority;

    @Override
    public String getAuthority() {
        return this.authority;
    }
}
