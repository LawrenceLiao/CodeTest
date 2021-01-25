package com.lawrence.test;

import com.lawrence.bundlescalculator.algorithm.Calculator;
import com.lawrence.bundlescalculator.model.OrderItem;
import com.lawrence.bundlescalculator.algorithm.QuotationItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CalculatorTest {

    @Test
    void calculateBundles() {
        OrderItem orderItem = OrderItem.builder().codeOfMedia("IMG").numOfPost(25).build();

        QuotationItem quotationItem = Calculator.calculateBundles(orderItem);

        assertTrue(quotationItem.getDetailsOfBundles().size() == 2);
        //assertEquals(2,quotationItem.getDetailsOfBundles().get(10));
    }
}