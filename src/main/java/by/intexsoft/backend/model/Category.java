package by.intexsoft.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.util.List;

/**
 * Category model for category entities
 */
@Entity
@Table(name = "category")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Category extends AbstractEntity {

    private static final long serialVersionUID = -7036463004146365704L;

    @Column(name = "name")
    public String name;

    @OneToMany(mappedBy = "category")
    public List<Theme> themes;
}
