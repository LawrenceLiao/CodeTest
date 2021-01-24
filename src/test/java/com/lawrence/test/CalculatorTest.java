package com.lawrence.test;

import com.lawrence.bundlescalculator.Bundle;
import com.lawrence.bundlescalculator.Calculator;
import com.lawrence.bundlescalculator.Image;
import com.lawrence.bundlescalculator.Post;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void calculateBundles() {
        Post post = Image.builder().code("IMG").number(25).build();
        List<Bundle> bundleList = Calculator.calculateBundles(post);

        Bundle bundleExample = bundleList.stream().filter(bundle -> bundle.getNumOfPosts() == 10).findFirst().get();

        assertTrue(bundleList.size()==2);
        assertEquals(2,bundleExample.getNumOfBundles());

    }
}