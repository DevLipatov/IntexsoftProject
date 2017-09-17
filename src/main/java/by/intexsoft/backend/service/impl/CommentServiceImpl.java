package by.intexsoft.backend.service.impl;

import by.intexsoft.backend.model.Comment;
import by.intexsoft.backend.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of {@link by.intexsoft.backend.service.CommentService} which provides CRUD operations
 * with {@link Comment} instances
 */
@Service
public class CommentServiceImpl extends AbstractEntityServiceImpl<Comment> {

    private CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }
}
