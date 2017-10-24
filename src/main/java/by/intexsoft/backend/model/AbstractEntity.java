package by.intexsoft.backend.model;

import org.springframework.data.jpa.domain.AbstractPersistable;
import javax.persistence.*;

/**
 * Abstract entity, including same fields from subclasses
 */
@MappedSuperclass
public class AbstractEntity extends AbstractPersistable<Long> {
}
