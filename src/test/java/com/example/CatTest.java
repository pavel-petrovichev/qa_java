package com.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class CatTest {

    Feline feline;
    Cat cat;

    @Before
    public void setup() {
        feline = Mockito.mock(Feline.class);
        this.cat = new Cat(feline);
    }

    @Test
    public void getSound() {
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void getFood() throws Exception {
        when(feline.eatMeat())
                .thenReturn(List.of("Животные", "Птицы", "Рыба"));
        assertEquals(
                List.of("Животные", "Птицы", "Рыба"),
                cat.getFood());
    }
}