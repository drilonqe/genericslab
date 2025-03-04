/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.grinnell.csc207.genericslab;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

/**
 *
 * @author qerimidr
 */
public class LinkedListTests {

    @Test
    public void emptyListTest() {
        LinkedList l = new LinkedList<>();
        assertEquals(0, l.size());
    }

    @Test
    public void listGetSeveral() {
        LinkedList<String> l = new LinkedList<>();
        String[] elements = new String[]{"a", "b", "c", "d", "e", "f", "g"};
        for (int i = 0; i < elements.length; i++) {
            l.add(elements[i]);
        }
        for (int i = 0; i < elements.length; i++) {
            assertEquals(elements[i], l.get(i));
        }

        LinkedList<Integer> l2 = new LinkedList<>();
        Integer[] nums = {3, 8, 7, 2, 6, 5, 0};
        for (int i = 0; i < nums.length; i++) {
            l2.add(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            assertEquals(nums[i], l2.get(i));
        }
    }

    @Test
    public void listGetOOB() {
        LinkedList<String> l = new LinkedList<>();
        l.add("hello!");
        l.add("goodbye!");
        l.add("huh?");
        assertThrows(IndexOutOfBoundsException.class, () -> {
            l.get(-1);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            l.get(3);
        });

        LinkedList<Integer> l2 = new LinkedList<>();
        l2.add(3);
        l2.add(2);
        l2.add(7);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            l2.get(-1);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            l2.get(3);
        });
    }

    @Test
    public void listRemoveSome() {
        LinkedList<String> l = new LinkedList<>();
        l.add("!");
        l.add("@");
        l.add(".");
        l.add("#");
        l.add("&");

        // @ #
        assertEquals(".", l.remove(2));
        assertEquals("@", l.get(1));
        assertEquals("#", l.get(2));

        assertEquals("!", l.remove(0));
        assertEquals("@", l.get(0));

        assertEquals("&", l.remove(2));
        assertEquals("#", l.get(1));

        LinkedList<Integer> l2 = new LinkedList<>();
        l2.add(5);
        l2.add(8);
        l2.add(7);
        l2.add(1);
        l2.add(9);

        assertEquals(7, l2.remove(2));
        assertEquals(8, l2.get(1));
        assertEquals(1, l2.get(2));

        assertEquals(5, l2.remove(0));
        assertEquals(8, l2.get(0));

        assertEquals(9, l2.remove(2));
        assertEquals(1, l2.get(1));
    }

    @Test
    public void listRemoveOOB() {
        LinkedList <String> l = new LinkedList<>();
        l.add("A");
        l.add("B");
        l.add("C");
        assertThrows(IndexOutOfBoundsException.class, () -> {
            l.remove(-1);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            l.remove(3);
        });
        
         LinkedList<Integer> l2 = new LinkedList<>();
        l2.add(5);
        l2.add(8);
        l2.add(7);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            l2.remove(-1);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            l2.remove(3);
        });
        
    }
}
