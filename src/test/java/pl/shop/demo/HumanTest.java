package pl.shop.demo;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class HumanTest {
    /*-- test metody moneyAfterShopping*/
    @Test
    public void shouldMoneyAfterShopping(){
        //given
        Human human = new Human("Mateusz",38,"barman",100);
        Item item = new Item("Czekolada",0,3,true);
        //when
        human.moneyAfterShopping(item);
        //then
        assertThat(human.getMoney(), is(97));
    }

}