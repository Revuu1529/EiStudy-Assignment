public class StrategyPatternDemo {
    public static void main(String[] args) {
        ShoppingCart cart1 = new ShoppingCart(new CreditCardPayment());
        cart1.checkout(100);

        ShoppingCart cart2 = new ShoppingCart(new PayPalPayment());
        cart2.checkout(200);
    }
}