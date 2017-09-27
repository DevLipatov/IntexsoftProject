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

    private static final long serialVersionUID = 4321421752167640912L;

    @Column(name = "title")
    public String title;

    @Column(name = "content")
    public String content;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    @JsonIgnoreProperties("themes")
    public Category category;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    public User user;

    @OneToMany(mappedBy = "theme", fetch = FetchType.EAGER)
    public List<Comment> comments;
}
