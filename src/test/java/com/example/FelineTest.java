package com.example;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FelineTest {

    Feline feline;

    @Before
    public void setup() {
        this.feline = new Feline();
    }

    @Test
    public void eatMeat() throws Exception {
        assertEquals(
                List.of("Животные", "Птицы", "Рыба"),
                feline.eatMeat());
    }

    @Test
    public void getFamily() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensDefault() {
        assertEquals(1, feline.getKittens());
    }
}