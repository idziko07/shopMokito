package pl.shop.demo;

public class ShopController {

    private Shop shop;

    public ShopController(ShopRepository shopRepository) {
        shop = shopRepository.findShop();

    }

    public void sellItem(Human human, String itemName) {

        if (shop.hasItem(itemName)) {
            Item item = shop.findItemByName(itemName);
            if (item.getAgeRestriction() > human.getAge()) {
                throw new TooYoungException();
            }
            if(!(item.isLegal()) && human.getJob().equals("policjant") ){
                throw new OutOfStockExceprion();
            }
            if(human.getMoney() < item.getPrice()) {
                throw new LackOfMoneyException();
            }

             shop.addMoney(item);
             human.moneyAfterShopping(item);
             shop.playCashSound();

        } else {
            // TODO sklep nie ma danego przedmiotu, wyrzuć wyjątek OutOfStockException
            throw new OutOfStockExceprion();
        }

    }

}
