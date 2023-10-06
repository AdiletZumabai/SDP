import java.util.Scanner;

public class ShoppingCartDemo {
    //  объявление класса
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        // корзина для товаров
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // бесконечный цикл
            System.out.println("1. Add Product");
            System.out.println("2. View Cart Contents");
            System.out.println("3. Checkout");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            // считывание выбора
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Product Name: ");
                    String productName = scanner.nextLine();
                    System.out.print("Enter Price: $");
                    double price = scanner.nextDouble();
                    System.out.print("Enter Quantity: ");
                    int quantity = scanner.nextInt();
                    Product product = new Product(productName, price, quantity);
                    cart.addProduct(product);
                    break;
                case 2:
                    cart.displayCartContents();
                    break;
                case 3:
                    System.out.print("Select Payment Method (1 for Credit Card): ");
                    int paymentChoice = scanner.nextInt();
                    scanner.nextLine();

                    PaymentStrategy paymentStrategy;
                    if (paymentChoice == 1) {
                        System.out.print("Enter Credit Card Number: ");
                        String cardNumber = scanner.nextLine();
                        System.out.print("Enter Cardholder Name: ");
                        String cardHolder = scanner.nextLine();
                        paymentStrategy = new CreditCardPayment(cardNumber, cardHolder);
                    }  else {
                        System.out.println("Invalid Payment Method");
                        continue;
                    }

                    cart.checkout(paymentStrategy);
                    System.exit(0);  // программа завершается
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }
}
