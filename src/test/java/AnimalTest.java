package com.example;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class AnimalTest {

    private Animal animal;

    @Before
    public void setUp() {
        animal = new Animal();
    }

    @Test
    public void testGetFoodForHerbivore() throws Exception {
        List<String> expectedFood = List.of("Трава", "Различные растения");
        assertArrayEquals(expectedFood.toArray(), animal.getFood("Травоядное").toArray());
    }

    @Test
    public void testGetFoodForCarnivore() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        assertArrayEquals(expectedFood.toArray(), animal.getFood("Хищник").toArray());
    }

    @Test(expected = Exception.class)
    public void testGetFoodUnknownType() throws Exception {
        animal.getFood("Другое");
    }

    @Test
    public void testGetFamily() {
        assertEquals("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи", animal.getFamily());
    }
}
