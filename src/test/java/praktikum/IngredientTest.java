package praktikum;

import org.junit.Assert;
import org.junit.Test;


public class IngredientTest {

    @Test
    public void ingredientTestShouldGetType() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        Assert.assertEquals(IngredientType.SAUCE, ingredient.getType());
    }

    @Test
    public void ingredientTestShouldGetName() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        Assert.assertEquals("hot sauce", ingredient.getName());
    }

    @Test
    public void ingredientTestShouldGetPrice() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        Assert.assertEquals(100, ingredient.getPrice(), 0.1);
    }
}
