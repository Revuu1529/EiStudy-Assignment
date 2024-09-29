//This is the Main class
public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();

        coffee = new MilkDecorator(coffee);
        
        coffee = new SugarDecorator(coffee);

        System.out.println(coffee.getDescription() + " costs $" + coffee.cost());
    }
}