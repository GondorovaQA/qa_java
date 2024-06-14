package com.example;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LionTest {

    private IFeline mockFeline;
    private Lion lion;

    @Before
    public void setUp() throws Exception {
        mockFeline = mock(IFeline.class);
        when(mockFeline.getKittens()).thenReturn(5);
        when(mockFeline.getFood(anyString())).thenReturn(List.of("Мясо", "Рыба"));

        lion = new Lion(mockFeline, "Самец");
    }

    @Test
    public void testConstructorMale() {
        assertTrue(lion.doesHaveMane());
    }

    @Test(expected = Exception.class)
    public void testConstructorInvalidSex() throws Exception {
        lion = new Lion(mockFeline, "Неверный");
    }

    @Test
    public void testGetKittens() {
        assertEquals(5, lion.getKittens());
    }

    @Test
    public void testDoesHaveManeFemale() throws Exception {
        try {
            lion = new Lion(mockFeline, "Самка");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assertFalse(lion.doesHaveMane());
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> food = lion.getFood();
        assertEquals(food.size(), 2);
        assertTrue(food.containsAll(List.of("Мясо", "Рыба")));
    }
}

