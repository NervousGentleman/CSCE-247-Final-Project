import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FacadeTest {
    
    private Facade testFacade;

    @BeforeClass
	public void oneTimeSetup() {
	    
	}
	
	@AfterClass
	public void oneTimeTearDown() {
		
	}
	
	@BeforeEach
	public void setup() {
		testFacade = new Facade();
        //runs before each test
	}
	
	@AfterEach
	public void tearDown() {
        //runs after each test
	}

    @Test

    public void testDateConverter(){
        long unixTime = 1649736000 * 1000;
        Date date = new Date(unixTime);
        String dateString = "04/12/2022";
        assertEquals(date, testFacade.dateConverter(dateString));
    }

    @Test

    public void testDateAndTimeConverter(){
        long unixTime = 1649743200 * 1000;
        Date date = new Date(unixTime);
        String dateString = "04/12/2022 02:00";
        assertEquals(date, testFacade.dateConverter(dateString));
    }

    @Test

    public void testLoginValidation(){
        String email = "jimmyjohn@gmail.com";
        String password = "subsYum";
        assertEquals(true, testFacade.loginValidation(email, password));
    }

    @Test

    public void testLoginValidationIncorrect(){
        String email = "jimmyjohn123@gmail.com";
        String password = "subsYum";
        assertEquals(false, testFacade.loginValidation(email, password));
    }

    @Test

    public void testCreateAccount(){
        String email = "johnnyappleseed@coolmail.com";
        String password = "japple123";
        String name = "Johnny";
        Date dob = new Date(12222314);
        int passportNumber = 126784;
        assertEquals(true, testFacade.createAccount(email, password, name, dob, passportNumber));
    }

    @Test

    public void testCreateAccountTaken(){
        String email = "jimmyjohn@gmail.com";
        String password = "subsYum";
        String name = "Jimmy";
        Date dob = new Date(12222314);
        int passportNumber = 126784;
        assertEquals(false, testFacade.createAccount(email, password, name, dob, passportNumber));
    }


}
