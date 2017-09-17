package by.intexsoft.backend.model;

import javax.persistence.*;

/**
 * Comment model for comment entities
 */
@Entity
@Table(name = "comment")
public class Comment extends AbstractEntity {

    private static final long serialVersionUID = 762236959358141738L;

    @Column(name = "content")
    public String content;

    @ManyToOne
    @JoinTable(name = "theme_comments",
            joinColumns = @JoinColumn(name = "comment_id"),
            inverseJoinColumns = @JoinColumn(name = "theme_id"))
    public Theme theme;

    @ManyToOne
    @JoinTable(name = "user_comments",
            joinColumns = @JoinColumn(name = "comment_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    public User user;
}
