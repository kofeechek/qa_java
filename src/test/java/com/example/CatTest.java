package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;


import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {


    @Mock
    Feline feline;

    @Test
    public void shouldReturnMeow() {
        Cat cat = new Cat(feline);

        String actual = cat.getSound();
        String expected = "Мяу";

        assertEquals(expected, actual);
    }

    @Test
    public void shoudReturnFood() throws Exception{
        Cat cat = new Cat(feline);

        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actual = cat.getFood();

        assertArrayEquals(expected.toArray(), actual.toArray());
    }





}
