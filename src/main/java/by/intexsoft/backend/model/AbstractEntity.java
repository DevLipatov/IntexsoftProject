package by.intexsoft.backend.model;

import org.springframework.data.jpa.domain.AbstractPersistable;
import javax.persistence.*;

/**
 * Abstract entity, including same fields from subclasses
 */
@MappedSuperclass
public class AbstractEntity extends AbstractPersistable<Long> {

    private static final long serialVersionUID = 7219127246357342388L;
}
