package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredientFirst;
    @Mock
    Ingredient ingredientSecond;

    @Test
    public void burgerTestShouldAddIngredient() {
        Burger burger = new Burger();
        Mockito.when(ingredientFirst.getName()).thenReturn("chili sauce");
        burger.addIngredient(ingredientFirst);
        String actualIngredient = burger.ingredients.get(0).getName();
        Assert.assertEquals("chili sauce", actualIngredient);
    }

    @Test
    public void burgerTestShouldMoveIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredientFirst);
        Mockito.when(ingredientSecond.getName()).thenReturn("cutlet");
        burger.addIngredient(ingredientSecond);
        burger.moveIngredient(1, 0);
        String actualIngredient = burger.ingredients.get(0).getName();
        Assert.assertEquals("cutlet", actualIngredient);
    }

    @Test
    public void burgerTestShouldRemoveIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredientFirst);
        burger.removeIngredient(0);
        Boolean actualResult = burger.ingredients.isEmpty();
        Assert.assertEquals(true, actualResult);
    }

    @Test
    public void burgerTestShouldGetReceipt() {
        Burger burger = new Burger();
        Mockito.when(bun.getName()).thenReturn("red bun");
        Mockito.when(bun.getPrice()).thenReturn(300f);
        burger.setBuns(bun);
        Mockito.when(ingredientFirst.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredientFirst.getName()).thenReturn("chili sauce");
        Mockito.when(ingredientFirst.getPrice()).thenReturn(300f);
        burger.addIngredient(ingredientFirst);
        String actualReceipt = burger.getReceipt();
        Assert.assertEquals("(==== red bun ====)\n"
                + "= sauce chili sauce =\n"
                + "(==== red bun ====)\n"
                + "\n" + "Price: 900,000000\n", actualReceipt);
    }
}
