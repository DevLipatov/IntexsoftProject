package by.intexsoft.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

/**
 * Category model for category entities
 */
@Entity
@Table(name = "category")
public class Category extends AbstractEntity {

    private static final long serialVersionUID = -7036463004146365704L;

    /**
     * Maps field to the column "name" in database. Name of the category
     */
    @Column(name = "name")
    public String name;

    /**
     * One-to-many relationship with table "theme" in database
     */
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("category")
    public List<Theme> themes;
}
