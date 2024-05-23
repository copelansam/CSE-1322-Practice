import java.util.Scanner;
public class Assignment1 {

    public static class Coins{
        private int quantityOnHand;
        private float denomination;
        private float weight;

        Coins(float a, float b){
            denomination = a;
            weight = b;

        }

        float getTotalWeight(){
            float totalWeight = weight * quantityOnHand;
            return totalWeight;
        }

        float getTotalValue(){
            float totalValue = denomination * quantityOnHand;
            return totalValue;
        }

        void increaseQuantity(int a){
            quantityOnHand += a;
        }

        void decreaseQuantity(int a){
            quantityOnHand -= a;
            if (quantityOnHand < 0){
                quantityOnHand = 0;
            }
        }

        int getQuantityOnHand(){
            return quantityOnHand;
        }

        String printPretty(float amount){
            return("$"+String.format("%4.2f",amount));
        }

        public String toString(){
            return printPretty(getTotalValue()) + " in " + printPretty(denomination) +" coins.";
        }


    }

    public static class Notes{
        private int quantityOnHand;
        private int denomination;

        Notes(int a){
            this.denomination = a;
        }

        int getTotalValue(){
            return quantityOnHand * denomination;
        }

        void increaseQuantity(int a){
            this.quantityOnHand += a;
        }

        void decreaseQuantity(int a){
            this.quantityOnHand -= a;
            if (quantityOnHand < 0){
                this.quantityOnHand = 0;
            }
        }

        int getQuantityOnHand(){
            return this.quantityOnHand;
        }

        String printPretty(float amount){
            return("$"+String.format("%4.2f",amount));
        }

        public String toString(){
            int totalValue = getTotalValue();
            float denominationF = (float) this.denomination;
            return printPretty(totalValue) + " in " + printPretty(denominationF) +" notes.";
        }

    }

    public static void main (String[] args){
        Notes twenties = new Notes(20);
        Notes tens = new Notes(10);
        Notes fives = new Notes(5);
        Notes ones = new Notes(1);
        Coins quarters = new Coins(0.25f,0.2f);
        Coins dimes = new Coins(0.10f,0.08f);
        Coins nickels = new Coins(0.05f,0.176f);
        Coins pennies = new Coins(0.01f,0.088f);
        dimes.increaseQuantity(41);
        nickels.increaseQuantity(17);
        pennies.increaseQuantity(132);
        ones.increaseQuantity(33);
        fives.increaseQuantity(12);
        tens.increaseQuantity(2);
        twenties.increaseQuantity(5);

        System.out.println(twenties.toString());
        System.out.println(tens.toString());
        System.out.println(fives.toString());
        System.out.println(ones.toString());
        System.out.println(pennies.toString());
        System.out.println(nickels.toString());
        System.out.println(dimes.toString());
        System.out.println(quarters.toString());
        float totalValue = twenties.getTotalValue() + tens.getTotalValue() + fives.getTotalValue() + ones.getTotalValue() + pennies.getTotalValue() + nickels.getTotalValue() + dimes.getTotalValue() + quarters.getTotalValue();
        float totalWeight = pennies.getTotalWeight() + nickels.getTotalWeight() + dimes.getTotalWeight() + quarters.getTotalWeight();
        System.out.println("Total money is $" + (Math.round(totalValue *100.0)/100.0) + " total weight is " + totalWeight + "oz");
        System.out.println("How much do you need?");
        Scanner sc= new Scanner (System.in);
        float target = sc.nextFloat();
        float withdrawal = 0f;


            while (twenties.getQuantityOnHand() > 0 && ((target - withdrawal) >= 20)) {
                System.out.println("Give them a $20 note");
                twenties.decreaseQuantity(1);
                withdrawal += 20;
            }

            while (tens.getQuantityOnHand() > 0 && ((target - withdrawal) >= 10)) {
                System.out.println("Give them a $10 note");
                tens.decreaseQuantity(1);
                withdrawal += 10;
            }

            while (fives.getQuantityOnHand() > 0 && ((target - withdrawal) >= 5)) {
                System.out.println("Give them a $5 note");
                fives.decreaseQuantity(1);
                withdrawal += 5;
            }

            while (ones.getQuantityOnHand() > 0 && ((target - withdrawal) >= 1)) {
                System.out.println("Give them a $1 note");
                ones.decreaseQuantity(1);
                withdrawal += 1;
            }

            while (quarters.getQuantityOnHand() > 0 && ((target - withdrawal) >= 0.25f)) {
                System.out.println("Give them a quarter");
                quarters.decreaseQuantity(1);
                withdrawal += 0.25f;
            }

            while (dimes.getQuantityOnHand() > 0 && ((target - withdrawal) >= 0.1f)) {
                System.out.println("Give them a dime");
                dimes.decreaseQuantity(1);
                withdrawal += 0.1f;
            }

            while (nickels.getQuantityOnHand() > 0 && ((target - withdrawal) >= 0.05f)) {
                System.out.println("Give them a nickel");
                nickels.decreaseQuantity(1);
                withdrawal += 0.05f;
            }

            while (pennies.getQuantityOnHand() > 0 && ((target - withdrawal) >= 0.001)) {
                System.out.println("Give them a penny");
                pennies.decreaseQuantity(1);
                withdrawal += 0.01f;
            }
            totalValue = twenties.getTotalValue() + tens.getTotalValue() + fives.getTotalValue() + ones.getTotalValue() + pennies.getTotalValue() + nickels.getTotalValue() + dimes.getTotalValue() + quarters.getTotalValue();
            totalWeight = pennies.getTotalWeight() + nickels.getTotalWeight() + dimes.getTotalWeight() + quarters.getTotalWeight();

            if (withdrawal > 0 && totalValue <= 0) {
                System.out.println("I don't have enough money. I still owe you $" + (target-withdrawal));
            }
            System.out.println("I have $" + (Math.round(totalValue *100.0)/100.0) + " left, it's total weight is " + totalWeight + "oz");


    }
}
