package com.example;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CatTest {

    private Predator mockPredator;
    private Cat cat;

    @Before
    public void setUp() throws Exception {
        // Создаем мок для IPredator
        mockPredator = mock(Predator.class);

        // Настройка ожидаемого поведения мока
        when(mockPredator.eatMeat()).thenReturn(Arrays.asList("Говядина", "Рыба"));

        // Создаем экземпляр Cat с моком в качестве аргумента
        cat = new Cat(mockPredator);
    }

    @Test
    public void testGetSound() {
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> food = cat.getFood();
        assertEquals(food.size(), 2);
        assertTrue(food.contains("Говядина"));
        assertTrue(food.contains("Рыба"));
    }
}






