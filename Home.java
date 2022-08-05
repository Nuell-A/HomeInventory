import java.io.FileWriter;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Scanner;

class Home {
    /*
    * This class is responsible for holding the information of each individual home
    */

    // Attributes
    private int square_feet;
    private String address;
    private String city;
    private String state;
    private int zip_code;
    private String model_name;
    private String sale_status;

    // Constructor
    public Home(int sf, String addy, String city, String state, int zc, String model, String status) {
        try {
            this.square_feet = sf;
            this.address = addy;
            this.city = city;
            this.state = state;
            this.zip_code = zc;
            this.model_name = model;
            this.sale_status = status;

            System.out.println("Created home successfully.");
        } catch(Exception e) {
            System.out.println("Invalid input. Try again.");
        }
    }
    
    // Getters
    public int getSquareFeet() {
        return this.square_feet;
    }

    public String getAddress() {
        return this.address;
    }

    public String getCity() {
        return this.city;
    }

    public String getState() {
        return this.state;
    }

    public int getZipCode() {
        return this.zip_code;
    }

    public String getModelName() {
        return this.model_name;
    }

    public String getSaleStatus() {
        return this.sale_status;
    }

    // Setters
    public void setSquareFeet(int sf) {
        this.square_feet = sf;
    }

    public void setAddress(String addy) {
        this.address = addy;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZipCode(int zc) {
        this.zip_code = zc;
    }

    public void setModelName(String model) {
        this.model_name = model;
    }

    public void setSaleStatus(String status) {
        this.sale_status = status;
    }
}

class HomeInventory{
    /*
     * Main logic for the Java application.
     * Completes tasks such as adding, removing, updating, displaying, printing.
     * Also holds the actual inventory of all the Homes created through the Home class above.
     */

    // Attributes
    private ArrayList<Home> homes;
    public static Scanner keyboard = new Scanner(System.in);

    // Constructor to initate ArrayList
    public HomeInventory() {
        homes = new ArrayList<Home>(); 
    }

    public String addHome() {
        /*
         * This method gathers info from user about home being added
         * to inventory. If all input is correct, then it is added to the 
         * ArrayList.
         */
        try{
            System.out.println("\nEnter the square footage: ");
            int square_feet = Integer.parseInt(keyboard.nextLine());

            System.out.println("Enter the address: ");
            String address = keyboard.nextLine();

            System.out.println("Enter the city: ");
            String city = keyboard.nextLine();

            System.out.println("Enter the state: ");
            String state = keyboard.nextLine();

            System.out.println("Enter the zip code: ");
            int zip_code = Integer.parseInt(keyboard.nextLine());

            System.out.println("Enter the model name: ");
            String model_name = keyboard.nextLine();

            System.out.println("Enter the sale status: ");
            String sale_status = keyboard.nextLine();
            
            // Check for errors
            if(zip_code == 0 || square_feet == 0 || address.isEmpty() || city.isEmpty() || state.isEmpty() || model_name.isEmpty() || sale_status.isEmpty()) {
                throw new Exception("You must have an input value for each prompt!");
            }

            if(city.matches(".*\\d.*") || state.matches(".*\\d.*") || model_name.matches(".*\\d.*") || sale_status.matches(".*\\d.*")) {
                throw new Exception("Make sure you are putting in the correct information!");
            }
            this.homes.add(new Home(square_feet, address, city, state, zip_code, model_name, sale_status));
            return "Success! Home was added to inventory.";
            
        } catch(Exception e) {
            // If any user input is incorrect (wrong data type/no input)
            System.out.println(e.getMessage());
            return "\nFailure.... Home was not added to inventory";
        }
    }

    public String removeHome() {
        /*
         * This method takes in the address of the home the user wants removed from the inventory. 
         * It checks to see if the address given is in the inventory and if it is, then it removes it
         * if not then it lets the user know that the address does not exsist.
         */
        try {
            System.out.println("Please enter the address of the home you want to remove from inventory:");
            String rm_addy = keyboard.nextLine();
            // Flag set for home (if it is inventory or not)
            boolean addy_exsists = false;

            // for loop to iterate over list of homes
            for(Home home: this.homes) {
                if (home.getAddress().equals(rm_addy)){
                    // If address is in inventory then flag is set to true
                    addy_exsists = true;
                    // Removes home from ArrayList 
                    this.homes.remove(home);
                }
            }
            if(addy_exsists == true) {
                return "Success! The home was removed from inventory";
            }
            else {
                return "This address is not in our records";
            }
        } catch (ConcurrentModificationException e) {
            // This exception occurs when an ArrayList is modified while being iterated over. 
            // However, the program still works as intended, this is why the return message in a catch
            // block is a success. 
            return "Success... home removed!";
        } 
        catch(Exception e) {
            return "\nInvalid input provided. Inventory was not changed.";
        }
    }

    public String updateHome() {
        /*
         * This method accepts input from user for an address and tries to find a match in each Home in the
         * homes list. If one is found, then the user is prompted for new values to be set using the setters.
         */
        try {
            System.out.println("Enter the address of the home you want to update");
            String addy = keyboard.nextLine();
            boolean exsists = false;

            for(Home home: this.homes) {
                if(home.getAddress().equals(addy)) {
                    System.out.println("Enter the square footage: ");
                    int square_feet = Integer.parseInt(keyboard.nextLine());
                    home.setSquareFeet(square_feet);;

                    System.out.println("Enter the address: ");
                    String address = keyboard.nextLine();
                    home.setAddress(address);

                    System.out.println("Enter the city: ");
                    String city = keyboard.nextLine();
                    home.setCity(city);

                    System.out.println("Enter the state: ");
                    String state = keyboard.nextLine();
                    home.setState(state);

                    System.out.println("Enter the zip code: ");
                    int zip_code = Integer.parseInt(keyboard.nextLine());
                    home.setZipCode(zip_code);

                    System.out.println("Enter the model name: ");
                    String model_name = keyboard.nextLine();
                    home.setModelName(model_name);

                    System.out.println("Enter the sale status: ");
                    String sale_status = keyboard.nextLine();
                    home.setSaleStatus(sale_status);
                    exsists = true;
                }
            }
            if(exsists == true) {
                return "Success! Home has been updated.";            
            }
            else {
                return "\nThis address is not in our records.";
            }
        } catch(Exception e) {
            return "\nFailure... invalid input. Home not updated.";
        }
    }

    public String printFile(String path) {
        /*
         * Takes the path taken from the Main class and write all the homes
         * currently in the ArrayList to the file for the given path.
         */
        try {
            FileWriter myWriter = new FileWriter(path);
            myWriter.write(String.format("\n%15s %22s %15s %10s %15s %15s %15s", "Square Feet", "Address", "City", "State", "Zip Code", "Model", "Sale Status"));
            
            for(Home home: this.homes) {
                myWriter.write(String.format("\n%15s %22s %15s %10s %15s %15s %15s", home.getSquareFeet(), home.getAddress(), home.getCity(), home.getState(), home.getZipCode(), home.getModelName(), home.getSaleStatus()));
            }
            myWriter.close();

            return "File successfuly printed to computer";
        } catch (Exception e) {
            return "\nFailure.... double check your path to make sure it is correct";
        }
    }

    public void displayHomes() {
        /*
         * Displays all homes currently in ArrayList.
         * Formatted to be more readable.
         */
        System.out.println("The inventory holds the following homes:");
        System.out.printf("\n%15s %22s %15s %10s %15s %15s %15s", "Square Feet", "Address", "City", "State", "Zip Code", "Model", "Sale Status");

        // Iterate over ArrayList containing all homes.
        for(Home home: this.homes){
            System.out.printf("\n%15s %22s %15s %10s %15s %15s %15s", home.getSquareFeet(), home.getAddress(), home.getCity(), home.getState(), home.getZipCode(), home.getModelName(), home.getSaleStatus());

        }
    }
}