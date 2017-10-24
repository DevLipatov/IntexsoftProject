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

    @Column(name = "title")
    public String title;

    @Column(name = "content")
    public String content;

    @Column(name = "status")
    public String status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    @JsonIgnoreProperties("themes")
    public Category category;

    @OneToMany(mappedBy = "theme", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("theme")
    public List<Comment> comments;
}
