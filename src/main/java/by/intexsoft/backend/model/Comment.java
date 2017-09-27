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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "theme_id")
    public Theme theme;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    public User user;
}
