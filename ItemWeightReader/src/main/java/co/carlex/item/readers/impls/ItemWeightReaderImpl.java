package co.carlex.item.readers.impls;

import co.carlex.item.readers.ItemWeightReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author Carlex
 */
public class ItemWeightReaderImpl implements ItemWeightReader{

    
    /**
     * Recibe los datos de días, cantidad de elementos y sus pesos en formato de 
     * línea por linea
     * @param data
     * @return Una lista donde cada elemento es un array de los pesos de cada 
     * elemento de cada día. Cada array representa un día
     */
    @Override
    public List<Short[]> readItems(final String data) {
        if(data == null || data.isEmpty()){
            throw new IllegalArgumentException("Error en el formato del archivo");
        }
        Queue<String> qlines = new ArrayDeque<>(Arrays.asList(data.split("\n")));
        Short days = Short.valueOf(qlines.poll().trim());
        List<Short[]> itemWeights = getItemWeights(qlines);
        if(days != itemWeights.size()){
            throw new IllegalArgumentException("Error en el formato del archivo");
        }
        return itemWeights;
    }
    
    
    /**
     * Recorre una cola de String con los datos de los pesos y cantidad de 
     * elementos por día
     * @param qlines
     * @return 
     */
    List<Short[]> getItemWeights(final Queue<String> qlines){
        List<Short[]> itemWeights = new ArrayList<>();
        String sitems;
        while((sitems = qlines.poll()) != null ){
            Short items = Short.valueOf(sitems);
            Short[] weights = new Short[items];
            for(int i = 0; i < items; i++){
                weights[i] = Short.valueOf(qlines.poll().trim());
            }
            itemWeights.add(weights);
        }
        return itemWeights;
    }
    
}
