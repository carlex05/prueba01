package co.carlex.item.services;

import java.util.List;
import org.springframework.stereotype.Service;

/**
 * Construye la información de salida (presentación)
 * @author Carlex
 */
@Service
public class DataPresentationService {
    
    /**
     * Con los datos de los viajes por día se contruye la salida en el formato
     * requerido
     * @param travelsByDay
     * @return 
     */
    public String getResponse(List<Short> travelsByDay){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < travelsByDay.size(); i++){
            sb.append("Case #")
                    .append((i+1))
                    .append(": ")
                    .append(travelsByDay.get(i))
                    .append("\n");
        }
        return sb.toString().trim();
    }
    
}
