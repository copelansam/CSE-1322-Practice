import java.util.Scanner;
public class Lab2 {

    static class StockItem {
        String description;
        static int itemCounter = 0;
        private int id;
        float price;
        int quantity;

        StockItem() {
            id = itemCounter++;
        }

        StockItem(String a, float b, int c) {
            description = a;
            price = b;
            quantity = c;
            id = itemCounter++;
        }

        public String toString() {
            return "Item number:" + id + " is " + description + " has price " +  price + " we currently have " + quantity + " in stock";
        }

        String getDescription() {
            return description;
        }

        float getPrice() {
            return price;
        }

        int getId() {
            return id;
        }

        int getQuantity() {
            return quantity;
        }

        void newPrice(float a) {
            if (a >= 0) {
                price = a;
            } else {
                System.out.println("Error");
            }
        }

        void decreaseQuantity(int a) {
            if (quantity - a >= 0) {
                quantity -= a;
            } else {
                System.out.println("Error");
            }
        }

        void increaseQuantity(int a) {
            quantity += a;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StockItem milk = new StockItem("1 Gallon of Milk", 3.60f, 15);
        StockItem bread = new StockItem("1 Loaf of Bread", 1.98f, 30);
        int selection = 0;
        float price = 0f;
        int quantity;

        while (selection != 8) {
            System.out.println("1.Sold One Milk");
            System.out.println("2.Sold One Bread");
            System.out.println("3.Change Price of Milk");
            System.out.println("4.Change Price of Bread");
            System.out.println("5.Add Milk to Inventory");
            System.out.println("6.Add Bread to Inventory");
            System.out.println("7.See Inventory");
            System.out.println("8.Quit");
            selection = sc.nextInt();

            if (selection == 1) {
                milk.decreaseQuantity(1);
            } else if (selection == 2) {
                bread.decreaseQuantity(1);
            } else if (selection == 3) {
                System.out.println("What is the new price for Milk?");
                price = sc.nextFloat();
                milk.newPrice(price);
            } else if (selection == 4) {
                System.out.println("What is the new price for Bread?");
                price = sc.nextFloat();
                bread.newPrice(price);
            } else if (selection == 5) {
                System.out.println("How many milk did we get?");
                quantity = sc.nextInt();
                milk.increaseQuantity(quantity);
            } else if (selection == 6) {
                System.out.println("How many bread did we get?");
                quantity = sc.nextInt();
                bread.increaseQuantity(quantity);
            } else if (selection == 7) {
                System.out.println();
                System.out.println(milk.toString());
                System.out.println(bread.toString());
            }
            System.out.println();

        }

    }
}

