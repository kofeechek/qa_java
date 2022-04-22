package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;
import java.util.List;

@RunWith(Parameterized.class)
public class FelineTest {

    final int expected;
    final int actual;

    public FelineTest(int expected, int actual){
        this.expected = expected;
        this.actual = actual;
    }

    @Test
    public void shouldReturnFamily(){
        Feline feline = new Feline();
        String expected = "Кошачьи";
        String actual = feline.getFamily();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnCustomKittens(){
        Feline feline = new Feline();
        assertEquals(feline.getKittens(actual), expected);
    }

    @Test
    public void shouldReturnOneKitten(){
        Feline feline = new Feline();
        int expected = 1;
        int actual = feline.getKittens();
        assertEquals(expected, actual);
    }

    @Parameterized.Parameters
    public static  Object getParaData(){
        return new Object[][]{
                {0, 0},
                {1, 1},
                {15, 15}
        };
    }

    @Test
    public void shouldReturnFood() throws Exception{
        Feline feline = new Feline();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> actual = feline.eatMeat();
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }
}
