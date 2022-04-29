package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.List;
import static org.junit.Assert.assertEquals;

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
    public void shouldHasMane() throws Exception{
        Lion lion = new Lion(sex, feline);
        assertEquals(lion.doesHaveMane(), expected);
    }

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
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actual = lion.getFood();
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
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
