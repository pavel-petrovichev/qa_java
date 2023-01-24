package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;

public class LionTest {

    Feline feline;

    @Before
    public void setup() {
        feline = Mockito.mock(Feline.class);
    }

    @Test
    public void maleLionHasMane() throws Exception{
        Lion lion = new Lion("Самец", feline);
        assertEquals(lion.doesHaveMane(), TRUE);
    }

    @Test
    public void femaleLionHasNoMane() throws Exception {
        Lion lion = new Lion("Самка", feline);
        assertEquals(lion.doesHaveMane(), FALSE);
    }

    @Test
    public void sexMustExist() {
        Exception e = assertThrows(
                Exception.class,
                () -> new Lion("ЫЫ", feline));
        assertEquals(
                "Используйте допустимые значения пола животного - 'Самец' или 'Самка'",
                e.getMessage());
    }

    @Test
    public void getFood() throws Exception {
        when(feline.getFood(Mockito.eq("Хищник")))
                .thenReturn(List.of("Животные", "Птицы", "Рыба"));

        Lion lion = new Lion("Самец", feline);
        assertEquals(
                List.of("Животные", "Птицы", "Рыба"),
                lion.getFood());
    }

    @Test
    public void getKittens() throws Exception {
        when(feline.getKittens())
                .thenReturn(1);

        Lion lion = new Lion("Самец", feline);
        assertEquals(1, lion.getKittens());
    }
}