package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {




    @Test
    public void shouldReturnFamily(){
        Feline feline = new Feline();
        String expected = "Кошачьи";
        String actual = feline.getFamily();
        assertEquals(expected, actual);
    }



    @Test
    public void shouldReturnOneKitten(){
        Feline feline = new Feline();

        int expected = 1;
        int actual = feline.getKittens();
        assertEquals(expected, actual);
    }


    @Test
    public void shouldReturnFood() throws Exception{
        Feline feline = new Feline();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> actual = feline.eatMeat();
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }
}
