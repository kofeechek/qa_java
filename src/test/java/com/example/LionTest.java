package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {


    @Mock
    Feline feline;

    String sex = "Самец";



    @Test
    public void shouldReturnKittens() throws Exception {
        Lion lion = new Lion(sex, feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int actual = lion.getKittens();
        int expected = 1;
        assertEquals(actual, expected);
    }

    @Test
    public void shouldReturnFood() throws Exception {
        Lion lion = new Lion(sex, feline);

        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expected);
        List<String> actual = lion.getFood();
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

}
