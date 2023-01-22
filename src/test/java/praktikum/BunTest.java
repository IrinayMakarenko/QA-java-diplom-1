package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class BunTest {

    @Test
    public void bunTestShouldGetName() {
        Bun bun = new Bun("white bun", 200);
        Assert.assertEquals("white bun", bun.getName());
    }

    @Test
    public void bunTestShouldGetPrice() {
        Bun bun = new Bun("white bun", 200);
        Assert.assertEquals(200, bun.getPrice(), 0.1);
    }
}
