package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

@RunWith(Parameterized.class)
public class BurgerTestParameterized {

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    private final String bunName;
    private final float bunPrice;
    private final IngredientType type;
    private final String ingredientName;
    private final float ingredientPrice;
    private final float expectedPrice;

    public BurgerTestParameterized(String bunName, float bunPrice, IngredientType type, String ingredientName, float ingredientPrice, float expectedPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
        this.type = type;
        this.ingredientName = ingredientName;
        this.ingredientPrice = ingredientPrice;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Object[][] getPriceOfBurger() {
        return new Object[][]{
                {"black bun", 100, IngredientType.SAUCE, "hot sauce", 100, 300},
                {"white bun", 200, IngredientType.FILLING, "sour cream", 200, 600},
        };
    }

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    @Test
    public void burgerTestShouldGetPrice() {
        Burger burger = new Burger();
        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        burger.setBuns(bun);
        Mockito.when(ingredient.getType()).thenReturn(type);
        Mockito.when(ingredient.getName()).thenReturn(ingredientName);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);
        burger.addIngredient(ingredient);
        Assert.assertEquals(expectedPrice, burger.getPrice(), 0.1);
    }
}

