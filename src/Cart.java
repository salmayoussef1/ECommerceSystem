import java.util.ArrayList;

import java.util.List;

public class Cart {

	
	
	private List<CartItem> items = new ArrayList<>();
	
	
	
	public boolean addItem(Product product, int quantity) {
		
        if (quantity > product.getQuantity()) {
        	System.out.println("Quantity is not avilable.");
        return false;	
        
        } 
        
        if (product.isExpireable()&&product.isExpired()) {
        	System.out.println(product.getName()+" expired , We cant add");
        	return false;
        }
        
        items.add(new CartItem(product, quantity));
        System.out.println(product.getName()+" Added sucessfully.");
        return true;
    }
        
        public boolean isEmpty() {
            return items.isEmpty();
        }

        public List<CartItem> getItems() {
            return items;
        }

        public double calculateSubtotal() {
            double sum = 0;
            for (CartItem item : items) {
                sum += item.getTotalPrice();
            }
            return sum;
        }
	
        public double calculateShipping() {
            for (CartItem item : items) {
                if (item.getProduct().isShippable() && item.getProduct().getWeight() > 0) {
                    return 80;
                }
            }
            return 0;
        }
	
        public double calculateTotal() {
            return calculateSubtotal() + calculateShipping();
        }
        
        public void checkout(Customer customer) {
            if (isEmpty()) {
                System.out.println("cart is empty.");
                return;
            }

            double subtotal = calculateSubtotal();
            double shipping = calculateShipping();
            double Amount = subtotal + shipping;

            if (customer.getBalance() < Amount) {
                System.out.println("Not enough balance to complete");
                return;
            }
            double totalWeight = 0;
            boolean hasShippable = false;

            for (CartItem item : items) {
                Product p = item.getProduct();
                if (p.isShippable() && p.getWeight() > 0) {
                    if (!hasShippable) {
                        System.out.println("** Shipment notice **");
                        hasShippable = true;
                    }

                    int quantity = item.getQuantity();
                    String name = p.getName();
                    double weightPerItem = p.getWeight();
                    double itemWeight = quantity * weightPerItem;
                    totalWeight += itemWeight;

                    System.out.print(quantity + "x  " + name + "   ");
                    if (itemWeight >= 1.0) {
                        System.out.printf("%.2fkg\n", itemWeight);
                    } else {
                        System.out.println((int)(itemWeight * 1000) + "g");
                    }

                }
            }

            if (hasShippable) {
                System.out.print("Total package weight: ");
                if (totalWeight >= 1.0) {
                    System.out.printf("%.2fkg\n", totalWeight);
                } else {
                    System.out.println((int)(totalWeight * 1000) + "g");
                }
                System.out.println();
            }
            
            System.out.println();
            customer.setBalance(customer.getBalance() - Amount);
            System.out.println("** Checkout receipt **");

            for (CartItem item : items) {
                Product p = item.getProduct();
                System.out.println(item.getQuantity() + "x\t" + p.getName() + "\t" + item.getTotalPrice());
                p.setQuantity(p.getQuantity() - item.getQuantity());
            }
            System.out.println("------------------------");
            System.out.println("Subtotal\t" + subtotal);
            System.out.println("Shipping\t" + shipping);
            System.out.println("Amount  \t" + Amount);

            System.out.println("current balance after payment : " + customer.getBalance() + " EGP");

            items.clear();
        }
}
