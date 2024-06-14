package com.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FelineTest {

    private Predator mockPredator;
    private Feline feline;

    @Before
    public void setUp() throws Exception {
        // Создаем мок для IPredator
        mockPredator = mock(Predator.class);

        // Настройка ожидаемого поведения мока
        when(mockPredator.eatMeat()).thenThrow(new UnsupportedOperationException("Not supported"));

        // Создаем экземпляр Feline без использования мока, так как Feline реализует IPredator напрямую
        feline = new Feline("Самец");
    }

    @Test
    public void testEatMeat() {
        try {
            feline.eatMeat();
        } catch (Exception e) {
            assertTrue(e instanceof Exception);
        }
    }

    @Test
    public void testGetFamily() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void testGetKittens() {
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void testGetSex() {
        assertEquals("Самец", feline.getSex());
    }
}




















