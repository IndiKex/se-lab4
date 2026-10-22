package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TorpedoStoreTest {

    @Test
    void fire_Success() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1);

        // Act
        boolean result = store.fire(1);

        // Assert
        assertEquals(true, result);

        assertEquals(0, store.getTorpedoCount());
    }

    @Test
    void fire_Fail() {
        TorpedoStore store = new TorpedoStore(1,1);

        boolean result = store.fire(1);
        
        assertEquals(false, result);
        assertEquals(1, store.getTorpedoCount());
    }

    @Test
    void fire_Empty() {
        TorpedoStore store = new TorpedoStore(0);
        assertThrows(IllegalArgumentException.class, () -> {
            store.fire(1);
        });
    }

    @Test 
    void fire_Negative() {
        TorpedoStore store = new TorpedoStore(1);
        assertThrows(IllegalArgumentException.class, () -> {
            store.fire(-1);
        });
    }

    @Test
    void fire_TooMuch() {
        TorpedoStore store = new TorpedoStore(1);
        assertThrows(IllegalArgumentException.class, () -> {
            store.fire(2);
        });
    }

}
