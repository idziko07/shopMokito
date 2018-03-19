package pl.shop.demo;


import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class ShopTest {

    @Test
    public void shouldRunMethodPlayCashSound(){
        //given
        Shop shop = mock(Shop.class);

        //when
        shop.playCashSound();

        //then
        verify(shop);

    }

    @Test
    public void shouldHaveItem(){
        //given
        Map<Item,Integer> stock = new HashMap<>();
        Item czekolada = new Item("Milka",0,2,true);
        Item  baton = new Item("Mars",0,3,true);
        stock.put(czekolada,4);
        stock.put(baton,3);
        Shop shop  = new Shop(0,stock);
        //when
        boolean results = shop.hasItem("Milka");

        //then
        assertThat(results, is(true));
    }

    @Test
    public void shouldNotHaveItem(){
        //given
        Map<Item,Integer> stock = new HashMap<>();
        Item czekolada = new Item("Milka",0,2,true);
        Item  baton = new Item("Mars",0,3,true);
        stock.put(czekolada,4);
        stock.put(baton,3);
        Shop shop  = new Shop(0,stock);

        //when
        boolean results = shop.hasItem("Wedel");

        //then
        assertThat(results, is(false));
    }

    @Test
    public void shoulFfindItemByName(){
        //given
        Map<Item,Integer> stock = new HashMap<>();
        Item czekolada = new Item("Milka",0,2,true);
        Item  baton = new Item("Mars",0,3,true);
        stock.put(czekolada,4);
        stock.put(baton,3);
        Shop shop  = new Shop(0,stock);
        //when
        Item results = shop.findItemByName("Milka");

        //then
        assertThat(results.getName(), is("Milka"));
    }

    @Test
    public void shouldNotFindItemByName(){
        //given
        Map<Item,Integer> stock = new HashMap<>();
        Item czekolada = new Item("Milka",0,2,true);
        Item  baton = new Item("Mars",0,3,true);
        stock.put(czekolada,4);
        stock.put(baton,3);
        Shop shop  = new Shop(0,stock);

        //when
        Item results = shop.findItemByName("Wedel");

        //then
        assertThat(results, is(nullValue()));
    }

    @Test
    public void shoulAddMoney(){
        //given
        Map<Item,Integer> stock = new HashMap<>();
        Item czekolada = new Item("Milka",0,2,true);
        Item  baton = new Item("Mars",0,3,true);
        stock.put(czekolada,4);
        stock.put(baton,3);
        Shop shop  = new Shop(0,stock);


        //when
        shop.addMoney(czekolada);
        //then
        assertThat(shop.getMoney(),is(2));
    }

}