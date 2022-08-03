import java.util.ArrayList;
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
    public Home(int sf, String addy, String city, String state, int zc, String model, String status){
        this.square_feet = sf;
        this.address = addy;
        this.city = city;
        this.state = state;
        this.zip_code = zc;
        this.model_name = model;
        this.sale_status = status;
    }
    
    // Getters
    public int getSquareFeet(){
        return this.square_feet;
    }

    public String getAddress(){
        return this.address;
    }

    public String getCity(){
        return this.city;
    }

    public String getState(){
        return this.state;
    }

    public int getZipCode(){
        return this.zip_code;
    }

    public String getModelName(){
        return this.model_name;
    }

    public String getSaleStatus(){
        return this.sale_status;
    }

    // Setters
    public void setSquareFeet(int sf){
        this.square_feet = sf;
    }

    public void setAddress(String addy){
        this.address = addy;
    }

    public void setCity(String city){
        this.city = city;
    }

    public void setState(String state){
        this.state = state;
    }

    public void setZipCode(int zc){
        this.zip_code = zc;
    }

    public void setModelName(String model){
        this.model_name = model;
    }

    public void setSaleStatus(String status){
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
    public HomeInventory(){
        homes = new ArrayList<Home>(); 
    }

    public String addHome(){
        /*
         * This method gathers info from user about home being added
         * to inventory. If all input is correct, then it is added to the 
         * ArrayList.
         */
        try{
            int square_feet = 0;
            int zip_code = 0;
            System.out.println("Enter the square footage: ");
            square_feet = keyboard.nextInt();
            keyboard.nextLine();

            System.out.println("Enter the address: ");
            String address = keyboard.nextLine();

            System.out.println("Enter the city: ");
            String city = keyboard.nextLine();

            System.out.println("Enter the state: ");
            String state = keyboard.nextLine();

            System.out.println("Enter the zip code: ");
            zip_code = keyboard.nextInt();
            keyboard.nextLine();

            System.out.println("Enter the model name: ");
            String model_name = keyboard.nextLine();

            System.out.println("Enter the sale status: ");
            String sale_status = keyboard.nextLine();
            
            // Check for errors
            if(zip_code == 0 || square_feet == 0 || address.isEmpty() || city.isEmpty() || state.isEmpty() || model_name.isEmpty() || sale_status.isEmpty()) {
                throw new Exception("You must have an input value for each prompt!");
            }

            if(city.matches(".*\\d.*") || state.matches(".*\\d.*") || model_name.matches(".*\\d.*") || sale_status.matches(".*\\d.*")){
                throw new Exception("Make sure you are putting in the correct information!");
            }
            this.homes.add(new Home(square_feet, address, city, state, zip_code, model_name, sale_status));
            return "Success! Home was added to inventory.";
            
        } catch(Exception e){
            // If any user input is incorrect (wrong data type/no input)
            System.out.println(e.getMessage());
            return "Failure.... Home was not added to inventory";
        }
    }

    public String removeHome(){
        /*
         * This method takes in the address of the home the user wants removed from the inventory. 
         * It checks to see if the address given is in the inventory and if it is, then it removes it
         * if not then it lets the user know that the address does not exsist.
         */
        try{
            System.out.println("Please enter the address of the home you want to remove from inventory:");
            String rm_addy = keyboard.nextLine();

            boolean addy_exsists = false;

        } // ------------------------------------------------STOPPED WORKING HERE
        // CONTINUE TO FINISH REMOVEHOME() (FOR LOOP TO CHECK IF ADDRESS EXISTS AND OTHER STUFF)
    }

    public void displayHomes() {
        /*
         * Displays all homes currently in ArrayList.
         * Formatted to be more readable.
         */
        System.out.println("The inventory holds the following homes:");
        System.out.printf("\n%15s %15s %15s %15s %15s %15s %15s", "Square Feet", "Address", "City", "State", "Zip Code", "Model", "Sale Status");

        // Iterate over ArrayList containing all homes.
        for(Home home: this.homes){
            System.out.printf("\n%15s %15s %15s %15s %15s %15s %15s", home.getSquareFeet(), home.getAddress(), home.getCity(), home.getState(), home.getZipCode(), home.getModelName(), home.getSaleStatus());

        }
    }
}