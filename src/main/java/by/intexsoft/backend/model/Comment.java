package by.intexsoft.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;

/**
 * Comment model for comment entities
 */
@Entity
@Table(name = "comment")
public class Comment extends AbstractEntity {

    private static final long serialVersionUID = 7913592402361140214L;

    @Column(name = "content")
    public String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "theme_id")
    @JsonIgnoreProperties("comments")
    public Theme theme;
}
