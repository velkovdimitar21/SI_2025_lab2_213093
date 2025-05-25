import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {

    @Test
    public void testValidCart() {
        Item item1 = new Item("Apple", 2, 100, 0.1); // valid
        Item item2 = new Item("Banana", 1, 350, 0);  // triggers penalty
        List<Item> items = List.of(item1, item2);

        double result = SILab2.checkCart(items, "1234567812345678");

        // item1 = 100 * (1 - 0.1) * 2 = 180
        // item2 = 350 * 1 = 350, with -30 penalty → 180 + 350 - 30 = 500
        assertEquals(500.0, result);
    }

    @Test
    public void testInvalidCardCharacters() {
        Item item = new Item("Milk", 1, 50, 0);
        List<Item> items = List.of(item);

        RuntimeException ex = assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(items, "1234A67812345678"));

        assertEquals("Invalid character in card number!", ex.getMessage());
    }
}