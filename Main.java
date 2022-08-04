public class Main {
    public static void main(String[] args){
        HomeInventory inventory = new HomeInventory();
        System.out.println(inventory.addHome());

        inventory.displayHomes();

        System.out.println(inventory.updateHome());
        inventory.displayHomes();
    }
}

