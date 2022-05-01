package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionTestParameterized {

    final String sex;
    final boolean expected;

    @Mock
    Feline feline;

    public LionTestParameterized(String sex, boolean expected) {
        this.sex = sex;
        this.expected = expected;
    }



    @Test
    public void shouldHasMane() throws Exception{
        Lion lion = new Lion(sex, feline);
        assertEquals(lion.doesHaveMane(), expected);
    }

    @Parameterized.Parameters
    public static Object[][] getParaData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

}
