package co.carlex.item.services;

import co.carlex.item.business.ItemWeightCalculator;
import co.carlex.item.readers.ItemWeightReader;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Carlex
 */
@Service
public class ItemWeightService {
    
    @Autowired
    ItemWeightReader reader;
    
    /**
     * Retorna la cantidad máxima de viajes para cada día de acuerdo a la 
     * información suministrada
     * @param data
     * @return 
     */
    public List<Short> getMaxTravels(String data){
        List<Short[]> itemWrights = reader.readItems(data);
        return ItemWeightCalculator.getMaxTravels(itemWrights);
    }
    
}
