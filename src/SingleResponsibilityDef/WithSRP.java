package SingleResponsibilityDef;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*                      Single Responsibility Definition
   Do one thing and do it well , A class should have one and only one reason to change , meaning that
                                 A class should have only one job
 */
class ChoppingCartSRB {
    List<Item> cartItems = new ArrayList<Item>();

    public void removeFromCart(Item item) {
        if (cartItems.equals(item)) {
            cartItems.remove(cartItems.indexOf(item));
        }
    }

    public boolean addToCart(Item item) {

        if (StockSRB.quantityIsInStock(item)) {
            cartItems.add(item);
            return true;
        }
        return false;
    }

    public int getItemCount() {
        return cartItems.size();
    }


}

class createInvoice{
    public void createInvoice(ChoppingCartSRB choppingCartSRB){
        int sum = 0;
        for (int i = 0; i < choppingCartSRB.cartItems.size(); i++) {
            sum = (int) +choppingCartSRB.cartItems.get(i).getPrice();
        }
        int total = sum;
    }
}

class StockSRB {
    public static List<Item> items = Arrays.asList(
            new Item("0123", 10, 20), new Item("123", 20, 5)
            , new Item("01234", 10, 20)
    );

    public static boolean quantityIsInStock(Item item){
        int indexItem=items.indexOf(item);
        return  Stock.items.get(indexItem).getQuantity() >=item.getQuantity() ?true : false;
    }
}

class ItemSRB {
    private String code;
    private double price;
    private double quantity;

    public String getCode() {
        return code;
    }

    public ItemSRB(String code, double price, double quantity) {
        this.code = code;
        this.price = price;
        this.quantity = quantity;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }


}

public class WithSRP {
    public static int main(String args) {
        return 0;
    }
}
