import java.util.Scanner;
  
public class UI {

    private Facade facade;
    private boolean quit;
    private boolean quitAccount; // allows us to exit account sub menu
    private int userChoice;
    private Scanner kb;
    private boolean loggedIn;
    public UI() {
        this.facade = new Facade();
        this.quit = false;
        this.quitAccount = false;
        this.userChoice = -1;
        this.kb = new Scanner(System.in);
        loggedIn = false;
    }

    /**
     * Runs the program
     */
    public void run() {
        do{ 
            System.out.println("Welcome to our Flight and Hotel booking Program!\n");
            while (!loggedIn) {
                loggedIn = loginPrompt();
            }
            mainPrompt();
            this.userChoice = checkValidInputInt();
            mainOptionDecider(userChoice);

        } while(!quit);

        kb.close();
    }
    
    public static void main(String[] args) {
        UI ui = new UI();
        ui.run();
    }

    /**
     * Asks for the users login information
     * @return boolean
     */
    public boolean loginPrompt(){
        boolean loginSuccessful = false;
        String tempUserInput = "";
        String tempEmail = "";
        String tempPassword = "";
        
        System.out.print("Do you have an account? (Y/N): ");
        tempUserInput = kb.nextLine();
        if(tempUserInput.equalsIgnoreCase("y")){
            System.out.print("Please enter your email: ");
            tempEmail = kb.nextLine();
            System.out.print("Please enter your password: ");
            tempPassword = kb.nextLine();
            loginSuccessful = facade.loginValidation(tempEmail, tempPassword); 
            // if account user is found, prompt for password and check against the stored password.
             // if they match, log the user in, set return value to true, and show them the main prompt
             // if they dont, then notify user and prompt again
        } else if(tempUserInput.equalsIgnoreCase("n")){
            while(!createAccountPrompt());
            loginSuccessful = true;
        }
            // ending bracket of if else statement checking if user input is y or n
        return loginSuccessful;
    } // ending bracket of method loginPrompt

    public void mainPrompt(){
        System.out.println("******************* Main Menu *******************");
        System.out.println("1. View Account Info\n2. Find/Book Flight\n3. Find/Book Hotel\n4. Cancel Flight\n5. Cancel Hotel\n6. Print Itinerary\n7. End Program\n");
    }

    /**
     * Checks to see if the user input is valid
     * @return
     */
    public int checkValidInputInt() {
        int rv = kb.nextInt();
        kb.nextLine();
        return rv;
    } // ending bracket of method checkValidInputInt

    /**
     * Creates an account page for the user
     * @return
     */
    public boolean createAccountPrompt(){
        boolean createSuccessful = false;
        
        String tempEmail = "";
        String tempPassword = "";
        String name = "";
        String dateOfBirth = "";
        int passportNumber = -1;
        System.out.println("******************* Create Account *******************");
        System.out.print("Please enter your email address: ");
        tempEmail = kb.nextLine();
        System.out.print("Please enter your desired password: ");
        tempPassword = kb.nextLine();
        System.out.print("Please enter your full name: ");
        name = kb.nextLine();
        System.out.print("Please enter your date of birth (MM/dd/yyyy): ");
        dateOfBirth = kb.nextLine();
        System.out.print("Please enter your passport number: ");
        passportNumber = checkValidInputInt();

        createSuccessful = facade.createAccount(tempEmail, tempPassword, name, facade.dateConverter(dateOfBirth), passportNumber);


        // if else statement here to notify user if their account was successfully created or not
        // we could make this createAccount method return a boolean value if we want to loop them back
        // through if the creation is unsuccessful. If successful, save account to json.

        return createSuccessful;
    } // ending bracket of createAccountPrompt
    
    /**
     * Main menu options for the user
     * @param choice
     */
    public void mainOptionDecider(int choice){

        switch(choice){

            case 1: 
                do {
                    viewAccountPrompt();
                    userChoice = checkValidInputInt();
                    viewAccountDecider(userChoice);
                } while(!quitAccount);
                break;
            case 2: 
                findFlightPrompt();
                break;
            case 3: 
                findHotelPrompt();
                break;
            case 4: 
                cancelFlightPrompt();
                break;
            case 5: 
                cancelHotelPrompt();
                break;
            case 6: 
                facade.printItinerary();
                break;
            case 7: 
                quit = true;
                System.out.println("Thanks for using our program!");
                break;
            default:
                System.out.println("Option out of bounds! Choose an option 1 - 7");
                break;

        } // ending of switch case for mainPrompt

    } // ending bracket of method mainOptionDecider

    /**
     * Views the account prompt
     */
    public void viewAccountPrompt(){
        System.out.println("******************* Account *******************");
        System.out.println("1. View Booked Flights\n2. View Flight History\n3. View Booked Rooms\n4. View Hotel History\n5. Main Menu");
        
    }

    /**
     * Gives options for the user
     * @param choice
     */
    public void viewAccountDecider(int choice){
        
        switch(choice){
            case 1:
                System.out.println("******************* Booked Flights *******************");
                facade.displayBookedFlights();
                break;
            case 2: 
                System.out.println("******************* Flight History *******************");
                facade.displayFlightHistory();
                break;
            case 3: 
                System.out.println("******************* Booked Hotels *******************");
                facade.displayBookedHotels();
                break;
            case 4: 
                System.out.println("******************* Hotel History *******************");
                facade.displayHotelHistory();
                break;
            case 5: 
                quitAccount = true;
                break;
            default:
                System.out.println("Option out of bounds! Choose an option 1 - 5");
                break;
        }

    }// ending bracket of method viewAccountDecider
    
    /**
     * Finds the flight prompt
     */
    public void findFlightPrompt(){
        String startingCode = "";
        String destinationCode = "";
        String seatCode = "";
        int flightChoiceInt = -1;
        int guestAmount = 0;
        boolean validFlight = false;
        System.out.println("******************* Find Flight *******************");
        System.out.print("Enter the Airport Code of your starting airport:");
        startingCode = kb.nextLine();
        System.out.print("Enter the Airport Code of your destination:");
        destinationCode = kb.nextLine();
        if(guestPrompt()){
            System.out.print("Enter the amount of guests: ");
            guestAmount = checkValidInputInt();
            guestCreator(guestAmount);
        } // ending bracket of if statement
        facade.searchFlights(startingCode, destinationCode);
        sortFlightsPrompt();
        
        while(!validFlight){
            System.out.print("\nEnter the number of the flight you want to book: ");
            flightChoiceInt = checkValidInputInt();
            validFlight = facade.chooseFlight(flightChoiceInt);
        } // ending bracket of while loop
        facade.displaySeats();
        System.out.print("Enter the seat code you wish to book: ");
        chooseSeatPrompt(guestAmount);
        // display seats and choose for self and guests
    }

    /**
     * Finds the prompt for hotel
     */
    public void findHotelPrompt(){
        String hotelLocation = "";
        int hotelChoiceInt = -1;
        System.out.println("******************* Find Hotel *******************");
        System.out.print("\nEnter the city you wish to stay in: ");
        hotelLocation = kb.nextLine();
        facade.searchHotels(hotelLocation);
        sortHotelsPrompt();
        System.out.print("Enter the number of the hotel you wish to book: ");
        hotelChoiceInt = checkValidInputInt();
        facade.chooseHotel(hotelChoiceInt);
        hotelDatePrompt();
    }

    /**
     * Gives the user an option of when they will be staying
     */
    public void hotelDatePrompt(){
        String checkInDate = "";
        String checkOutDate = "";
        int tempRoomNumber = -1;
        String checkInTime = "";
        String checkOutTime = "";
        System.out.print("What date will you check in? (MM/dd/yyyy): ");
        checkInDate = kb.nextLine();
        System.out.print("What time will you check in? (hh:mm): "); // will automatically add ss
        checkInTime = kb.nextLine();
        System.out.print("What date will you check out? (MM/dd/yyyy): ");
        checkOutDate = kb.nextLine();
        System.out.print("What time will you check out? (hh:mm): "); // will automatically add ss
        checkOutTime = kb.nextLine();
        String formattedCheckIn = checkInDate + " " + checkInTime;
        String formattedCheckOut = checkOutDate + " " + checkOutTime;
        System.out.println("Rooms open during your times: ");
        facade.displayRooms(facade.dateAndTimeConverter(formattedCheckIn), facade.dateAndTimeConverter(formattedCheckOut));
        System.out.print("\nEnter the room number you wish to stay in: ");
        tempRoomNumber = checkValidInputInt();
        facade.chooseHotel(tempRoomNumber);
        System.out.println(tempRoomNumber + " room booked from " + checkInDate + " through " + checkOutDate);
    }

    /**
     * Allows the user to cancel their flight
     */
    public void cancelFlightPrompt(){
        System.out.println("******************* Cancel Flight *******************");
        facade.displayBookedFlights();
        System.out.print("Enter the number of the flight you wish to cancel: ");
        if(facade.deleteUserFlight(checkValidInputInt())){
            System.out.println("\nFlight Successfully Cancelled");
        }
    }

    /**
     * Allows the user to cancel their hotel
     */
    public void cancelHotelPrompt(){
        System.out.println("******************* Cancel Hotel *******************");
        facade.displayBookedHotels();
        System.out.print("Enter the number of the hotel you wish to cancel: ");
        if(facade.deleteUserHotel(checkValidInputInt())){
            System.out.println("\nHotel Successfully Cancelled");
        }
    }

    /**
     * Allows the user to add a guest
     * @return
     */
    public boolean guestPrompt(){
        boolean hasGuests = false;
        String guestResponse = "";
        System.out.println("Do you have guest you want to book for? (Y/N)");
        guestResponse = kb.nextLine();
        if(guestResponse.contains("y") || guestResponse.contains("Y")){
            hasGuests = true;
        } else if(guestResponse.contains("n") || guestResponse.contains("N")){
            hasGuests = false;
        } else {
            hasGuests = false;
        }

        return hasGuests;
    }

    /**
     * Allows the user to enter their guests information
     * @param amountOfGuests
     */
    public void guestCreator(int amountOfGuests){
        String tempGuestName = "";
        String tempDateOfBirth = "";
        int tempPassportNumber = -1;

        for(int i = 0; i < amountOfGuests; i++){
            System.out.println("Enter the full name of guest #" + i+1 + ": ");
            tempGuestName = kb.nextLine();
            System.out.print("Enter their date of birth (MM/dd/yyyy): "); // maybe add valid bday format check
            tempDateOfBirth = kb.nextLine();
            System.out.print("Enter their passport number: ");
            tempPassportNumber = checkValidInputInt();
            facade.addGuest(tempGuestName, facade.dateConverter(tempDateOfBirth), tempPassportNumber);
        }
    }

    /**
     * Allows the user to choose their seat
     * @param guestAmount
     */
    public void chooseSeatPrompt(int guestAmount){
        String userSeat = "";
        String guestSeat = "";
        userSeat = kb.nextLine();
        facade.chooseSeat(userSeat);
        for(int i = 0; i < guestAmount; i++){
            System.out.print("Enter the seat code for Guest " + facade.getGuests().get(i).getName() + ": ");
            guestSeat = kb.nextLine();
            facade.chooseSeatForGuest(guestSeat, facade.getGuests().get(i));
            // need to add passenger to seat
        }
        System.out.println("Seats booked. Purchase complete.");
    }

    /**
     * Allows the user to sort the flights
     */
    public void sortFlightsPrompt(){
        System.out.println("Enter the way you would like to sort: ");
        System.out.println("1. Name\n2. Price");
        sortFlightsDecider(checkValidInputInt());
    }
    
    /**
     * Allows the user to sort hotels
     */
    public void sortHotelsPrompt(){
        System.out.println("Enter the way you would like to sort: ");
        System.out.println("1. Name\n2. Price");
        sortHotelsDecider(checkValidInputInt());
    }

    /**
     * Allows the user to choose the flight they want
     * @param choice
     */
    public void sortFlightsDecider(int choice){
        switch(choice){
            case 1:
            facade.displayFlights(facade.sortFlightByName());
            break;
            case 2:
            facade.displayFlights(facade.sortFlightByPrice());
            break;
        }
    }
    
    /**
     * Allows the user to choose the hotel they want
     * @param choice
     */
    public void sortHotelsDecider(int choice){
        switch(choice){
            case 1:
            facade.displayHotels(facade.sortHotelByName());
            break;
            case 2:
            facade.displayHotels(facade.sortHotelByPrice());
            break;
        }
    }
} // ending bracket of class UI