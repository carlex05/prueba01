package co.carlex.item.readers.impls;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Carlex
 */
public class ItemWeightReaderImplTest {
    
    public ItemWeightReaderImplTest() {
    }

    @Test
    public void testGetItemWeights() {
        
        String data = "4\n30\n30\n1\n1\n3\n20\n20\n20\n11\n1\n2\n3\n4\n5\n6\n7\n8\n9\n10\n11\n6\n9\n19\n29\n39\n49\n59\n10\n32\n56\n76\n8\n44\n60\n47\n85\n71\n91";
        Queue<String> qlines = new ArrayDeque<>(Arrays.asList(data.split("\n")));
        List<Short[]> itemWeights = new ItemWeightReaderImpl().getItemWeights(qlines);
        List<Short[]> items = new ArrayList<>();
        items.add(new Short[]{30, 30, 1, 1});
        items.add(new Short[]{20, 20, 20});
        items.add(new Short[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11});
        items.add(new Short[]{9, 19, 29, 39, 49, 59});
        items.add(new Short[]{32, 56, 76, 8, 44, 60, 47, 85, 71, 91});
        if(items.size() != itemWeights.size()){
            fail("La cantidad de registros es diferentes se esperaba " + items.size() + " pero fue " + itemWeights.size());
        }
        for(int i = 0; i < itemWeights.size(); i++){
            assertArrayEquals(items.get(i), itemWeights.get(i));
        }
    }
    
    @Test
    public void testReadItems() {
        String data = "5\n4\n30\n30\n1\n1\n3\n20\n20\n20\n11\n1\n2\n3\n4\n5\n6\n7\n8\n9\n10\n11\n6\n9\n19\n29\n39\n49\n59\n10\n32\n56\n76\n8\n44\n60\n47\n85\n71\n91";
        List<Short[]> itemWeights = new ItemWeightReaderImpl().readItems(data);
        List<Short[]> items = new ArrayList<>();
        items.add(new Short[]{30, 30, 1, 1});
        items.add(new Short[]{20, 20, 20});
        items.add(new Short[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11});
        items.add(new Short[]{9, 19, 29, 39, 49, 59});
        items.add(new Short[]{32, 56, 76, 8, 44, 60, 47, 85, 71, 91});
        if(items.size() != itemWeights.size()){
            fail("La cantidad de registros es diferentes se esperaba " + items.size() + " pero fue " + itemWeights.size());
        }
        for(int i = 0; i < itemWeights.size(); i++){
            assertArrayEquals(items.get(i), itemWeights.get(i));
        }
    }
    
    @Test
    public void testReadItems_incorrectDays() {
        String data = "6\n4\n30\n30\n1\n1\n3\n20\n20\n20\n11\n1\n2\n3\n4\n5\n6\n7\n8\n9\n10\n11\n6\n9\n19\n29\n39\n49\n59\n10\n32\n56\n76\n8\n44\n60\n47\n85\n71\n91";
        assertThrows(IllegalArgumentException.class, () -> { new ItemWeightReaderImpl().readItems(data);});
    }
    
    @Test
    public void testReadItems_null() {
        String data = null;
        assertThrows(IllegalArgumentException.class, () -> { new ItemWeightReaderImpl().readItems(data);});
    }
    
}
