package co.carlex.item.audit.daos;

import co.carlex.item.dtos.LogDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Carlex
 */
public interface AuditDAO extends MongoRepository<LogDTO, String> {
    
}
