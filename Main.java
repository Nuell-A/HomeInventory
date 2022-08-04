import java.util.Scanner;

public class Main {
    /*
     * Portfolio project. Below is the requirements listed in the Portfolio Project in canvas.
     * - Create a separate class to call Home class.
     * - Call Home class (parameterized) and list home
     * - Call remove home to remove it.
     * - Call add home to add another. List home again.
     * - UPdate home added (sale status). List updated home.
     * - Ask user if they want information printed. If yes, then print. If no then end program.
     */

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        boolean active = true; // boolean to keep while loop active

        HomeInventory inventory = new HomeInventory();

        System.out.println("Iventory Initialized! Here is the home just added");
        inventory.displayHomes();

        while(active) {
            // while loop used to display menu

            System.out.println("-------------------");
            System.out.println("Menu:\n1. Add New Home\n2. Remove Home\n3. Update a Home\n4. Show all homes\n5. EXIT/Print File");
            System.out.println("Please make a selection.");
            System.out.println("-------------------\n");
            int choice = Integer.parseInt(keyboard.nextLine());

            switch(choice) {
                case 1:
                    System.out.println(inventory.addHome());
                    break;
                case 2:
                    System.out.println(inventory.removeHome());
                    break;
                case 3:
                    System.out.println(inventory.updateHome());
                    break;
                case 4: 
                    inventory.displayHomes();
                    break;
                case 5:
                    System.out.println("Would you like to print the inventory to a file? (y/n)");
                    String isPrint = keyboard.nextLine();

                    if(isPrint.equalsIgnoreCase("y")) {
                        System.out.println("Where would you want the file printed? (ENTER PATH)");
                        String filePath = keyboard.nextLine();
                        System.out.println(inventory.printFile(filePath));
                    }
                    keyboard.close();
                    active = false;

                    System.out.println("\nExiting program.....");
                default:
                    System.out.println("Invalid choice! Try again");
                    break;
            }

        }
    }
}

