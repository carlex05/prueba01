/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.carlex.item.services;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Carlex
 */
public class DataPresentationServiceTest {
    
    public DataPresentationServiceTest() {
    }

    @Test
    public void testGetResponse_data1() {
        List<Short> travels = new ArrayList<>();
        travels.add((short)6);
        travels.add((short)1);
        travels.add((short)1);
        travels.add((short)5);
        travels.add((short)6);
        travels.add((short)1);
        travels.add((short)2);
        String expected = "Case #1: 6\nCase #2: 1\nCase #3: 1\nCase #4: 5\nCase #5: 6\nCase #6: 1\nCase #7: 2";
        String actual = new DataPresentationService().getResponse(travels);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testGetResponse_data2() {
        List<Short> travels = new ArrayList<>();
        travels.add((short)4);
        String expected = "Case #1: 4";
        String actual = new DataPresentationService().getResponse(travels);
        assertEquals(expected, actual);
    }
    
}
