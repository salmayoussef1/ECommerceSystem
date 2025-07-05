public class Main {
	
    public static void main(String[] args) {
    	
    	//Products
        Product milk = new Product("Milk", 25.0, 10, true, false, true, 1.0);
        Product cheese = new Product("Cheese", 40.0, 5, true, true, true, 1.2);   //expired
        Product soap = new Product("Soap", 15.0, 2, false, false, false, 0);     //not shippable
        Product sugar = new Product("Sugar", 20.0, 3, false, false, true, 0.5);  //valid
        Product oil = new Product("Oil", 50.0, 1, false, false, true, 1.5);      //valid
        Product scratchcard = new Product("Scratch Card", 10.0, 2, false, false, false, 0); //valid but not shippable

        //Customer
        Customer salma = new Customer("Salma", 100.0);  //balance not enough

        //Cart
        Cart cart = new Cart();

        //Add items
        cart.addItem(milk, 3);     
        cart.addItem(cheese, 1);   //expired
        cart.addItem(soap, 3);     //quantity > available
        cart.addItem(scratchcard, 2); //add but not shippable
        cart.addItem(sugar, 1);    
        cart.addItem(oil, 1);      

        cart.checkout(salma);

        //Recharge balance
        salma.setBalance(300.0);
        System.out.println("\n-- balance recharged --\n");

        //Checkout again
        cart.checkout(salma);
    }
}
