package co.carlex.item.readers;

import java.util.List;

/**
 * Lector de la información del peso de los ítems de diferentes días
 * @author Carlex
 */
public interface ItemWeightReader {
    
    /**
     * Recibe un texto con la información del peso de los ítems en diferentes 
     * días, y retorna la lista en Objeto List<Short[]>
     * @param data
     * @return Cada elementos de la lista de un array de los pesos de cada 
     * elemento de ese día
     */
    List<Short[]> readItems(String data);
    
}
