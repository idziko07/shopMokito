package pl.shop.demo;

import java.util.Map;

public class Shop {

    private int money;
    private Map<Item, Integer> stock;
    private Play play;

    public Shop(int money, Map<Item, Integer> stock) {
        this.money = money;
        this.stock = stock;
    }

    void playCashSound() {
        /* zakładamy, że ta metoda odtwarza dźwięk https://www.youtube.com/watch?v=Wj_OmtqVLxY, nie musimy jej implementować,
        sprawdzamy tylko czy została uruchomiona */
        play.play();
    }

    public boolean hasItem(String itemName) {
        // TODO dodaj kod sprawdzający czy sklep na w asortymencie przedmot o danej nazwie
        for (Item item : stock.keySet()) {
            if(item.getName().equals(itemName)){
                return true;
            }
        }
        return false;
    }

    public Item findItemByName(String itemName) {
        // TODO dodaj kod wyszukujący przedmiot po jego nazwie
        for (Item item : stock.keySet()) {
            if (item.getName().equals(itemName)){
                return new Item(item.getName(),item.getAgeRestriction(),item.getPrice(),item.isLegal());
            }
        }
        return null;
    }

    public int getMoney() {
        return money;
    }

    public Map<Item, Integer> getStock() {
        return stock;
    }

    public void addMoney(Item item){
        money += item.getPrice();
    }

}
