package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineKittensTest {

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {0},
                {1},
                {5},
        };
    }

    int kittens;

    public FelineKittensTest(int kittens) {
        this.kittens = kittens;
    }

    Feline feline = new Feline();

    @Test
    public void kittens() {
        assertEquals(kittens, feline.getKittens(kittens));
    }
}