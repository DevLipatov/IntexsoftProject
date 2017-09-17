package by.intexsoft.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.util.List;

/**
 * Theme model for theme entities
 */
@Entity
@Table(name = "theme")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Theme extends AbstractEntity {

    private static final long serialVersionUID = 4321421752167640912L;

    @Column(name = "title")
    public String title;

    @Column(name = "content")
    public String content;

    @ManyToOne
    @JoinTable(name = "category_themes",
            joinColumns = @JoinColumn(name = "theme_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    public Category category;

    @ManyToOne
    @JoinTable(name = "user_themes",
            joinColumns = @JoinColumn(name = "theme_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    public User user;

    @OneToMany(mappedBy = "theme", fetch = FetchType.LAZY)
    public List<Comment> comments;
}
