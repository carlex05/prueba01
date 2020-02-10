package co.carlex.item.business;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Contiene la logica de negocio para calcular la cantidad máxima de viajes de 
 * acuerdo al peso de cada elemento y cantidad de los mismos
 * @author Carlex
 */
public class ItemWeightCalculator {
    
    static final short MIN_WEIGHT = 50;
    
    /**
     * Retorna una lista con la cantidad máxima de viajes disponibles para los 
     * conjuntos (arrays) de elementos (pesos) por día.
     * @param itemWeights Lista de pesos en diferentes dias
     * @return Lista de cantidad máxima de viajes en cada día
     */
    public static List<Short> getMaxTravels(List<Short[]> itemWeights){
        List<Short> response = itemWeights.stream()
                .map(ItemWeightCalculator::getMaxTravelsByDay)
                .collect(Collectors.toList());
        return response;
    }
    
    /**
     * Calcula la cantiad máxima de viajes en un día para un conjunto de objetos
     * por peso
     * @param items peso de los objetos a distribuir en un día
     * @return cantidad máxima de viajes de acuerdo al peso y cantidad de 
     * objetos
     */
    static Short getMaxTravelsByDay(Short[] items){
        List<Short> litems = Stream.of(items).sorted().collect(Collectors.toList());
        short travels = 0;
        int i0 = 0;
        for(int i1 = litems.size()-1 ; i1 > i0; i1--){
            short weight = litems.get(i1);
            while(weight < MIN_WEIGHT){
                if(i0++ >= i1){
                    return travels;
                }
                weight += litems.get(i1);
            }
            travels++;
        }
        return travels;
    }
    
}
