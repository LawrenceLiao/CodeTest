package com.lawrence.test;

import com.lawrence.bundlescalculator.algorithm.Calculator;
import com.lawrence.bundlescalculator.algorithm.ComboOfBundles;
import com.lawrence.bundlescalculator.algorithm.ElementsOfCal;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CalculatorTest {

    @Test
    void calculateBundles() {
        Calculator calculator = new Calculator();
        List<Integer> typeOfBundles = new ArrayList<Integer>(){
            {
                add(5);
                add(10);
            }
        };
        ElementsOfCal elements = ElementsOfCal.builder().numOfPost(15).typeOfBundles(typeOfBundles).build();

        ComboOfBundles combo = calculator.calculateBundles(elements);

        assertTrue(combo.getNumOfBundles().size() == 2);
        //assertEquals(2,quotationItem.getDetailsOfBundles().get(10));
    }
}