package pl.shop.demo;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;

public class ShopControllerTest {
    @Mock
    ShopRepository shopRepository;

    private ShopController shopController;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);

        Map<Item, Integer> stock = new HashMap<>();
        stock.put(new Item("Piwo", 18, 4, true), 5);
        stock.put(new Item("Marysia",18,30,false),3);

        Shop shop = new Shop(0, stock);

        when(shopRepository.findShop()).thenReturn(shop);

        shopController = new ShopController(shopRepository);
    }

    @Test(expected = TooYoungException.class)
    public void shouldNotSellBeerToYoungling() {
        // given
        Human human = new Human();

        // when
        shopController.sellItem(human, "Piwo");
    }

    @Test(expected = OutOfStockExceprion.class)
    public void shouldOutOfStockException() {
        // given
        Human human = new Human();

        // when
        shopController.sellItem(human, "Milka");
    }


    @Test(expected = OutOfStockExceprion.class)
    public void shouldNotForPoliceman() {
        // given
        Human human = new Human("Jarek",21,"policjant",100);

        // when
        shopController.sellItem(human, "Marysia");
    }


    @Test(expected = LackOfMoneyException.class)
    public void shouldLackOfMoney() {
        // given
        Human human = new Human("Jarek",21,"barman",1);
        // when
        shopController.sellItem(human, "Marysia");
    }

}
