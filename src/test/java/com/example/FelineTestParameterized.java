package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineTestParameterized {

    final int expected;
    final int actual;

    public FelineTestParameterized(int expected, int actual){
        this.expected = expected;
        this.actual = actual;
    }

    @Test
    public void shouldReturnCustomKittens(){
        Feline feline = new Feline();
        assertEquals(feline.getKittens(actual), expected);
    }

    @Parameterized.Parameters
    public static  Object getParaData(){
        return new Object[][]{
                {0, 0},
                {1, 1},
                {15, 15}
        };
    }

}
