import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class SILab2Test {

    @Test
    public void testEveryStatement() {
        List<Item> items = List.of(new Item("Milk", 2, 100, 0));
        String cardNumber = "1234567890123456";
        double expected = 200.0;
        assertEquals(expected, SILab2.checkCart(items, cardNumber), 0.001);
    }

    @Test
    public void testMultipleCondition_priceOver300() {
        List<Item> items = List.of(new Item("Laptop", 1, 350, 0));
        String cardNumber = "1234567890123456";
        assertEquals(385.0, SILab2.checkCart(items, cardNumber), 0.001);
    }

    @Test
    public void testMultipleCondition_discountOver0() {
        List<Item> items = List.of(new Item("Phone", 1, 100, 20));
        String cardNumber = "1234567890123456";
        assertEquals(88.0, SILab2.checkCart(items, cardNumber), 0.001);
    }

    @Test
    public void testMultipleCondition_quantityOver10() {
        List<Item> items = List.of(new Item("Pen", 11, 10, 0));
        String cardNumber = "1234567890123456";
        assertEquals(121.0, SILab2.checkCart(items, cardNumber), 0.001);
    }

    @Test
    public void testInvalidItemName() {
        List<Item> items = List.of(new Item(null, 1, 100, 0));
        String cardNumber = "1234567890123456";
        try {
            SILab2.checkCart(items, cardNumber);
            fail("Expected RuntimeException for invalid item name.");
        } catch (RuntimeException e) {
            assertEquals("No name for item!", e.getMessage());
        }
    }
}