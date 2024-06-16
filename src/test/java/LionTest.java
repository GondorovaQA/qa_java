package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class LionTest {

    private IFeline mockFeline;
    private Lion lion;
    private String sex;
    private boolean expectedHasMane;

    @Mock
    private IFeline mockFelineInstance;

    public LionTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        mockFeline = mock(IFeline.class);
        when(mockFeline.getKittens()).thenReturn(5);
        when(mockFeline.getFood(anyString())).thenReturn(List.of("Мясо", "Рыба"));
        lion = new Lion(mockFeline, sex);
    }

    @Parameters(name = "{index}: sex={0}, expectedHasMane={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Самец", true},
                {"Самка", false}
        });
    }

    @Test
    public void testDoesHaveMane() throws Exception {
        boolean actualHasMane = lion.doesHaveMane();
        if (lion.getSex().equals("Самец")) {
            assertTrue("Не соответствует ожидаемому результату. Фактический: " + actualHasMane + ", Ожидаемый: true", actualHasMane);
        } else if (lion.getSex().equals("Самка")) {
            assertTrue("Не соответствует ожидаемому результату. Фактический: " + actualHasMane + ", Ожидаемый: false",!actualHasMane);
        } else {
            fail("Unexpected sex value: " + lion.getSex());
        }
    }
    @Before
    public void setUp4() throws Exception {
        mockFeline = mock(IFeline.class);
        when(mockFeline.getKittens()).thenReturn(5);
        when(mockFeline.getFood(anyString())).thenReturn(List.of("Мясо", "Рыба"));

        lion = new Lion(mockFeline, "Самец");
    }

    @Test
    public void testConstructorMale() {
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void testConstructorInvalidSex() {
        try {
            lion = new Lion(mockFeline, "Неверный");
            fail("Expected an exception to be thrown");
        } catch (Exception e) {
            assertEquals("Используй допустимые значения пола животного - смец или самка", e.getMessage());
        }
    }

    @Test
    public void testGetKittens() {
        assertEquals(5, lion.getKittens());
    }

    @Test
    public void testDoesHaveManeFemale() throws Exception {
        lion = new Lion(mockFeline, "Самка");
        assertFalse(lion.doesHaveMane());
    }


    @Test
    public void testGetFood() throws Exception {
        List<String> food = lion.getFood();
        assertEquals(food.size(), 2);
        assertTrue(food.containsAll(List.of("Мясо", "Рыба")));
    }
}