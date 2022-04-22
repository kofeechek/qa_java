package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class LionTest {


    @Mock
    static Feline feline;

    final String sex;
    final boolean expected;

    public LionTest(String sex, boolean expected) {
        this.sex = sex;
        this.expected = expected;
    }

    @Test
    public void shouldHasMane(){
        try {
            Lion lion = new Lion(sex, feline);
            assertTrue(lion.doesHaveMane() == expected);
        } catch (Exception e){
            String actual = e.getMessage();
            String expected = "Используйте допустимые значения пола животного - самей или самка";
            assertEquals(actual, expected);
        }
    }

    @Test
    public void shouldReturnKittens() throws Exception {
        try {
            Lion lion = new Lion(sex, feline);
            Mockito.when(lion.getKittens()).thenReturn(1);
            int actual = lion.getKittens();
            int expected = 1;
            assertEquals(actual, expected);
        }
        catch (Exception e){
            String actual = e.getMessage();
            String expected = "Используйте допустимые значения пола животного - самей или самка";
            assertEquals(actual, expected);
        }
    }

    @Test
    public void shouldReturnFood() throws Exception {
        try {
            Lion lion = new Lion(sex, feline);

            List<String> expected = List.of("Животные", "Птицы", "Рыба");
            Mockito.when(lion.getFood()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
            List<String> actual = lion.getFood();
            Assert.assertArrayEquals(expected.toArray(), actual.toArray());
        } catch (Exception e){
            String actual = e.getMessage();
            String expected = "Используйте допустимые значения пола животного - самей или самка";
            assertEquals(actual, expected);
        }
    }

    @Parameterized.Parameters
    public static Object[][] getParaData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
                {"Самциха", false}
        };
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

}
