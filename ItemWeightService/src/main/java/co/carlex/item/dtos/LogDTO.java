package co.carlex.item.dtos;

import java.time.LocalDateTime;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Carlex
 */
@Data
@Document(collection = "logs")
@TypeAlias("log")
public class LogDTO {
    
    /**
     * Fecha del registro de auditoria
     */
    private LocalDateTime date;
    
    @Id
    private String id;
    
    /**
     * Número de documento de la persona que ejecutó
     */
    private String document;
    
}
