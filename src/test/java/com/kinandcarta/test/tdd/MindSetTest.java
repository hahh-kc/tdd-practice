package com.kinandcarta.test.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MindSetTest {
    MindSet mindSet;

    @BeforeEach
    public void beforeMindSetTest() {
        mindSet = new MindSet();
    }

    @Test
    public void testIsEmpty() {
        assertEquals(0,mindSet.size());
        assertTrue(mindSet.isEmpty());
    }

    @Test
    public void testNotIsEmpty() {
        mindSet.add("Test");
        assertEquals(1,mindSet.size());
        assertFalse(mindSet.isEmpty());
        Object[] expectedObjs = new Object[]{"Test"};
        assertArrayEquals(expectedObjs, mindSet.items);
    }

    @Test
    public void testExcessArraySize() {
        mindSet.add("Test 1");
        mindSet.add("Test 2");
        mindSet.add("Test 3");
        mindSet.add("Test 4");
        Object[] expectedObjs = new Object[]{"Test 1", "Test 2", "Test 3","Test 4"};
        assertArrayEquals(expectedObjs, mindSet.items);
    }


    @Test
    public void testUniqueElements() {
        mindSet.add("Test 1");
        mindSet.add("Test 2");
        mindSet.add("Test 1");
        mindSet.add("Test 2");
        Object[] expectedObjs = new Object[]{"Test 1", "Test 2"};
        assertArrayEquals(expectedObjs, mindSet.items);
    }

    @Test
    public void testContainElement() {
        mindSet.add("Test 1");
        mindSet.add("Test 2");
        assertTrue(mindSet.contains("Test 1"));
        assertTrue(mindSet.contains("Test 2"));
    }


    @Test
    public void testIndexOf() {
        mindSet.add("Test 1");
        mindSet.add("Test 2");
        assertEquals(0, mindSet.indexOf("Test 1"));
        assertEquals(1, mindSet.indexOf("Test 2"));
        assertEquals(-1, mindSet.indexOf("Test 3"));
    }



    @Test
    public void testRemoveElements() {
        mindSet.add("Test 1");
        mindSet.add("Test 2");
        mindSet.remove("Test 1");
        Object[] expectedObjs = new Object[]{"Test 2"};
        assertArrayEquals(expectedObjs, mindSet.items);
    }
}
