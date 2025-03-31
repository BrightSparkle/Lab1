import org.example.Container.Container;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class ContainerTest {

    private Container container;

    @BeforeEach
    void setUp() {
        container = new Container();
    }

    @Test
    void testAddAndGet() {
        container.add(10);
        container.add(20);
        container.add(30);

        assertEquals(3, container.size());
        assertEquals(10, container.get(0));
        assertEquals(20, container.get(1));
        assertEquals(30, container.get(2));
    }

    @Test
    void testRemove() {
        container.add(10);
        container.add(20);
        container.add(30);

        container.remove(1);

        assertEquals(2, container.size());
        assertEquals(10, container.get(0));
        assertEquals(30, container.get(1));
    }

    @Test
    void testAddNull() {
        assertThrows(IllegalArgumentException.class, () -> container.add(null));
    }

    @Test
    void testGetInvalidIndex() {
        container.add(5);
        assertThrows(IndexOutOfBoundsException.class, () -> container.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> container.get(1));
    }

    @Test
    void testRemoveInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> container.remove(0));
        container.add(100);
        assertThrows(IndexOutOfBoundsException.class, () -> container.remove(1));
    }

    @Test
    void testIterator() {
        container.add(1);
        container.add(2);
        container.add(3);

        StringBuilder sb = new StringBuilder();
        for (Integer num : container) {
            sb.append(num);
        }

        assertEquals("123", sb.toString());
    }

    @Test
    void testCapacityExpansion() {
        for (int i = 0; i < 15; i++) {
            container.add(i);
        }

        assertEquals(15, container.size());
        assertEquals(14, container.get(14));
    }

    @Test
    void testEmptyContainer() {
        assertEquals(0, container.size());
        assertThrows(IndexOutOfBoundsException.class, () -> container.get(0));
    }

    @Test
    void testIteratorNextOnEmptyContainer() {
        Iterator<Integer> it = container.iterator();
        assertFalse(it.hasNext());
        assertThrows(NoSuchElementException.class, it::next);
    }
}
