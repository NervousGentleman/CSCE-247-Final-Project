import java.util.Scanner;

public class UI {

    private boolean quit;
    private int userChoice;
    private Scanner kb;
    public UI() {
        this.quit = false;
        this.userChoice = -1;
        this.kb = new Scanner(System.in);

    }

    public void run() {
        do{ 
            System.out.println("Welcome to our Flight and Hotel booking Program!\n");
            mainPrompt();
            this.userChoice = checkValidInputInt();
            System.out.println(this.userChoice);

        } while(!quit);
    }
    
    public static void main(String[] args) {
        UI ui = new UI();
        ui.run();
    }

    public boolean loginPrompt(){
        boolean loginSuccessful = false;
        String tempUserInput = "";
        String tempUsername = "";
        String tempPassword = "";
        
        System.out.print("Do you have an account? (Y/N): ");
        tempUserInput = kb.nextLine();
        if(tempUserInput.equalsIgnoreCase("y")){
            System.out.print("Please enter your username: ");
            tempUsername = kb.nextLine();
             // if account user is found, prompt for password and check against the stored password.
             // if they match, log the user in, set return value to true, and show them the main prompt
             // if they dont, then notify user and prompt again
        } else if(tempUserInput.equalsIgnoreCase("n")){
            createAccountPrompt();
        }
            // ending bracket of if else statement checking if user input is y or n
        return loginSuccessful;
    } // ending bracket of method loginPrompt

    public void mainPrompt(){
        System.out.println("******************* Main Menu *******************");
        System.out.println("1. View Account Info\n2. Find Flight\n3. Find Hotel\n4. Cancel Flight\n5. Cancel Hotel\n6. Create Account \n7. View Itinerary\n8. End Program\n");
    }

    public int checkValidInputInt() {

        while(!kb.hasNextInt()) {
            System.out.println("Invalid Option! Please enter a number in range!");
            kb.next();
        } // ending bracket of while loop checking if valid input
       
        int rv = kb.nextInt();
        return rv;
    } // ending bracket of method checkValidInputInt

    public boolean createAccountPrompt(){
        boolean createSuccessful = false;
        
        String tempEmail = "";
        String tempPassword = "";
        System.out.println("******************* Create Account *******************");
        System.out.print("Please enter your email address: ");
        tempEmail = kb.nextLine();
        System.out.print("Please enter your desired password: ");
        tempPassword = kb.nextLine();

        // if else statement here to notify user if their account was successfully created or not
        // we could make this createAccount method return a boolean value if we want to loop them back
        // through if the creation is unsuccessful. If successful, save account to json.

        return createSuccessful;
    } // ending bracket of createAccountPrompt
    
    public void mainOptionDecider(int choice){

        switch(choice){

            case 1: 
                viewAccountPrompt();
                userChoice = checkValidInputInt();
                viewAccountDecider(userChoice);
                break;
            case 2: 
                
                break;
            case 3: 
                
                break;
            case 4: 
                
                break;
            case 5: 
                
                break;
            case 6: 
                
                break;
            case 7: 
                
                break;
            case 8: 
                quit = false;
                System.out.println("Thanks for using our program!");
                break;
            default:
                System.out.println("Option out of bounds! Choose an option 1 - 8");
                break;

        } // ending of switch case for mainPrompt

    } // ending bracket of method mainOptionDecider

    public void viewAccountPrompt(){
        System.out.println("******************* Account *******************");
        System.out.println("1. View Booked Flights\n2. View Flight History\n3. View Booked Rooms\n4. View Hotel History\n5. Main Menu");
        
    }

    public void viewAccountDecider(int choice){
       
        switch(choice){
            case 1:

                break;
            case 2: 
                
                break;
            case 3: 
                
                break;
            case 4: 
                
                break;
            case 5: 
                break;
            default:
                System.out.println("Option out of bounds! Choose an option 1 - 5");
                break;
        }

    }// ending bracket of method viewAccountDecider
    

} // ending bracket of class UI
