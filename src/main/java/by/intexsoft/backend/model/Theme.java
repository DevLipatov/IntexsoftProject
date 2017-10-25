package by.intexsoft.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.util.List;

/**
 * Theme model for theme entities
 */
@Entity
@Table(name = "theme")
public class Theme extends AbstractEntity {

    private static final long serialVersionUID = 8268457375860410019L;

    /**
     * Maps field to the column "title" in database. Title of the theme
     */
    @Column(name = "title")
    public String title;

    /**
     * Maps field to the column "content" in database. Content of the theme
     */
    @Column(name = "content")
    public String content;

    /**
     * Maps field to the column "status" in database. Status of the theme.
     * Available: "new", "published", "deleted"
     */
    @Column(name = "status")
    public String status;

    /**
     * Maps field to the column "category_id" in database.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    @JsonIgnoreProperties("themes")
    public Category category;

    /**
     * Back reference to the field "theme" in "comment" table
     */
    @OneToMany(mappedBy = "theme", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("theme")
    public List<Comment> comments;
}
