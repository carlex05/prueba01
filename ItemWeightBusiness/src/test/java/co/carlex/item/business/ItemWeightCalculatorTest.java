package co.carlex.item.business;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Carlex
 */
public class ItemWeightCalculatorTest {
    
    public ItemWeightCalculatorTest() {
    }

    @Test
    public void testGetMaxTravelsByDay_data1() {
        Short[] items = {30, 30, 1, 1};
        Short travels = ItemWeightCalculator.getMaxTravelsByDay(items);
        assertEquals((int)2, (int)travels);
    }
    
    @Test
    public void testGetMaxTravelsByDay_data2() {
        Short[] items = {20, 20, 20};
        Short travels = ItemWeightCalculator.getMaxTravelsByDay(items);
        assertEquals((int)1, (int)travels);
    }
    
    @Test
    public void testGetMaxTravelsByDay_data3() {
        Short[] items = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        Short travels = ItemWeightCalculator.getMaxTravelsByDay(items);
        assertEquals((int)2, (int)travels);
    } 
    
    @Test
    public void testGetMaxTravelsByDay_data4() {
        Short[] items = {9, 19, 29, 39, 49, 59};
        Short travels = ItemWeightCalculator.getMaxTravelsByDay(items);
        assertEquals((int)3, (int)travels);
    }
    
    @Test
    public void testGetMaxTravelsByDay_data5() {
        Short[] items = {32, 56, 76, 8, 44, 60, 47, 85, 71, 91};
        Short travels = ItemWeightCalculator.getMaxTravelsByDay(items);
        assertEquals((int)8, (int)travels);
    }
    
    @Test
    public void testGetMaxTravels(){
        List<Short[]> items = new ArrayList<>();
        items.add(new Short[]{30, 30, 1, 1});
        items.add(new Short[]{20, 20, 20});
        items.add(new Short[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11});
        items.add(new Short[]{9, 19, 29, 39, 49, 59});
        items.add(new Short[]{32, 56, 76, 8, 44, 60, 47, 85, 71, 91});
        List<Short> days = new ArrayList<>();
        days.add((short)2);
        days.add((short)1);
        days.add((short)2);
        days.add((short)3);
        days.add((short)8);
        assertIterableEquals(days, ItemWeightCalculator.getMaxTravels(items));
    }
    
}
