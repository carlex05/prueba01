package co.carlex.item.audit.interceptors;

import co.carlex.item.audit.daos.AuditDAO;
import co.carlex.item.dtos.LogDTO;
import java.time.LocalDateTime;
import java.util.UUID;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Carlex
 */
@Aspect
@Configuration
public class RestItemInterceptor {
    
    @Autowired
    AuditDAO logger;
    
    @Before("execution(* co.carlex.item.controllers.TravelCalculatorController.*(..))")
    public void before(JoinPoint jp){
        LogDTO dto = new LogDTO();
        dto.setDate(LocalDateTime.now());
        dto.setDocument(jp.getArgs()[0] + "");
        dto.setId(UUID.randomUUID().toString());
        logger.insert(dto);
    }
    
}
