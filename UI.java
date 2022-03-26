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
            mainPrompt();
            this.userChoice = checkValidInputInt();
            System.out.println(this.userChoice);

        } while(!quit);
    }
    
    public static void main(String[] args) {
        UI ui = new UI();
        ui.run();
    }

    public void mainPrompt(){
        System.out.println("Welcome to our Flight and Hotel booking Program!\n");
        System.out.println("******************* Main Menu *******************");
        System.out.println("1. Access account\n2. Find Flight\n3. Find Hotel\n4. Cancel Flight\n5. Cancel Hotel\n6. End Program\n");
    }

    public int checkValidInputInt() {

        while(!kb.hasNextInt()) {
            System.out.println("Invalid Option! Please enter a number in range!");
            kb.next();
        } // ending bracket of while loop checking if valid input
       
        int rv = kb.nextInt();
        return rv;
    } // ending bracket of method checkValidInputInt
} // ending bracket of class UI
