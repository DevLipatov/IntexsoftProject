package by.intexsoft.backend.repository;

import by.intexsoft.backend.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface for CRUD operations with {@link Comment} entities
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
