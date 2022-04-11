

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
import org.junit.jupiter.api.Test;


public class EthanCoarrSortTests {

   public ArrayList<Flight> flights = new ArrayList<Flight>();
    Flight F1;
    Flight F2;
    Flight F3;

    @Test
    public void testSortFlightName()
    {
        ArrayList<Flight> flights = new ArrayList<Flight>();

        UUID flightID = UUID.randomUUID();
        Airline airline = Airline.AMTRACK;
        String departureLocation = "Bad Choices";
        String destinationLocation = "Hell";
        boolean isConnecting = false;
        Flight previousFlight = null;
        Flight nextFlight = null;
        long longdepartureTime = (long) 1652224593;
        longdepartureTime *= 1000;
        Date departureTime = new Date(longdepartureTime);
        long longarrivalTime = (long) 1657494993;
        longarrivalTime *= 1000;
        Date arrivalTime = new Date(longarrivalTime);
        double flightDuration = 2.0;
        int numRows = 3;
        int numSeatsPerRow = 3;
        ArrayList<ArrayList<Seat>> seats = new ArrayList<ArrayList<Seat>>();
        for(int i = 0;i < numRows;i++)
        {
            ArrayList<Seat> Row = new ArrayList<Seat>();
            for(int j = 0;j < numSeatsPerRow;j++)
            {
                Passenger passenger = new Passenger("null", new Date(0), -1);
                double cost = 50;
                SeatClass seatClass = SeatClass.BUSINESS;
                int seatRow = i+1;
                String seatLettrer = Character.toString((char) (j+65));
                boolean seatTaken = false;
                Row.add(new Seat(passenger, cost, seatClass, seatRow, seatLettrer, seatTaken));
            }
            seats.add(Row);
        }
        F1 = new Flight(flightID, airline, departureLocation, destinationLocation, isConnecting, previousFlight, nextFlight,
         departureTime, arrivalTime, flightDuration, numRows, numSeatsPerRow, seats);
         flights.add(F1);

        flightID = UUID.randomUUID();
        airline = Airline.DISUNITED_AIRLINES;
        departureLocation = "Bad Choices";
        destinationLocation = "Hell";
        isConnecting = false;
        previousFlight = null;
        nextFlight = null;
        longdepartureTime = (long) 1652224593;
        longdepartureTime *= 1000;
        departureTime = new Date(longdepartureTime);
        longarrivalTime = (long) 1657494993;
        longarrivalTime *= 1000;
        arrivalTime = new Date(longarrivalTime);
        flightDuration = 2.0;
        numRows = 3;
        numSeatsPerRow = 3;
        seats = new ArrayList<ArrayList<Seat>>();
         for(int i = 0;i < numRows;i++)
         {
             ArrayList<Seat> Row = new ArrayList<Seat>();
             for(int j = 0;j < numSeatsPerRow;j++)
             {
                 Passenger passenger = new Passenger("null", new Date(0), -1);
                 double cost = 75;
                 SeatClass seatClass = SeatClass.BUSINESS;
                 int seatRow = i+1;
                 String seatLettrer = Character.toString((char) (j+65));
                 boolean seatTaken = false;
                 Row.add(new Seat(passenger, cost, seatClass, seatRow, seatLettrer, seatTaken));
             }
             seats.add(Row);
         }
         F2 = new Flight(flightID, airline, departureLocation, destinationLocation, isConnecting, previousFlight, nextFlight,
          departureTime, arrivalTime, flightDuration, numRows, numSeatsPerRow, seats);
          flights.add(F2);

        flightID = UUID.randomUUID();
        airline = Airline.NORTHEAST;
        departureLocation = "Bad Choices";
        destinationLocation = "Hell";
        isConnecting = false;
        previousFlight = null;
        nextFlight = null;
        longdepartureTime = (long) 1652224593;
        longdepartureTime *= 1000;
        departureTime = new Date(longdepartureTime);
        longarrivalTime = (long) 1657494993;
        longarrivalTime *= 1000;
        arrivalTime = new Date(longarrivalTime);
        flightDuration = 2.0;
        numRows = 3;
        numSeatsPerRow = 3;
        seats = new ArrayList<ArrayList<Seat>>();
          for(int i = 0;i < numRows;i++)
          {
              ArrayList<Seat> Row = new ArrayList<Seat>();
              for(int j = 0;j < numSeatsPerRow;j++)
              {
                  Passenger passenger = new Passenger("null", new Date(0), -1);
                  double cost = 100;
                  SeatClass seatClass = SeatClass.BUSINESS;
                  int seatRow = i+1;
                  String seatLettrer = Character.toString((char) (j+65));
                  boolean seatTaken = false;
                  Row.add(new Seat(passenger, cost, seatClass, seatRow, seatLettrer, seatTaken));
              }
              seats.add(Row);
          }
          F3 = new Flight(flightID, airline, departureLocation, destinationLocation, isConnecting, previousFlight, nextFlight,
           departureTime, arrivalTime, flightDuration, numRows, numSeatsPerRow, seats);
          
           flights.add(F3);

       FlightSort fs = new FlightSort(flights);
       ArrayList<Flight> SF = fs.sortNames();
       assertEquals(F1.getAirline().toString(), SF.get(0).getAirline().toString());
    }

    @Test
    public void testSortFlightPrice()
    {
        ArrayList<Flight> flights = new ArrayList<Flight>();

        UUID flightID = UUID.randomUUID();
        Airline airline = Airline.AMTRACK;
        String departureLocation = "Bad Choices";
        String destinationLocation = "Hell";
        boolean isConnecting = false;
        Flight previousFlight = null;
        Flight nextFlight = null;
        long longdepartureTime = (long) 1652224593;
        longdepartureTime *= 1000;
        Date departureTime = new Date(longdepartureTime);
        long longarrivalTime = (long) 1657494993;
        longarrivalTime *= 1000;
        Date arrivalTime = new Date(longarrivalTime);
        double flightDuration = 2.0;
        int numRows = 3;
        int numSeatsPerRow = 3;
        ArrayList<ArrayList<Seat>> seats = new ArrayList<ArrayList<Seat>>();
        for(int i = 0;i < numRows;i++)
        {
            ArrayList<Seat> Row = new ArrayList<Seat>();
            for(int j = 0;j < numSeatsPerRow;j++)
            {
                Passenger passenger = new Passenger("null", new Date(0), -1);
                double cost = 50;
                SeatClass seatClass = SeatClass.BUSINESS;
                int seatRow = i+1;
                String seatLettrer = Character.toString((char) (j+65));
                boolean seatTaken = false;
                Row.add(new Seat(passenger, cost, seatClass, seatRow, seatLettrer, seatTaken));
            }
            seats.add(Row);
        }
        F1 = new Flight(flightID, airline, departureLocation, destinationLocation, isConnecting, previousFlight, nextFlight,
         departureTime, arrivalTime, flightDuration, numRows, numSeatsPerRow, seats);
         flights.add(F1);

        flightID = UUID.randomUUID();
        airline = Airline.DISUNITED_AIRLINES;
        departureLocation = "Bad Choices";
        destinationLocation = "Hell";
        isConnecting = false;
        previousFlight = null;
        nextFlight = null;
        longdepartureTime = (long) 1652224593;
        longdepartureTime *= 1000;
        departureTime = new Date(longdepartureTime);
        longarrivalTime = (long) 1657494993;
        longarrivalTime *= 1000;
        arrivalTime = new Date(longarrivalTime);
        flightDuration = 2.0;
        numRows = 3;
        numSeatsPerRow = 3;
        seats = new ArrayList<ArrayList<Seat>>();
         for(int i = 0;i < numRows;i++)
         {
             ArrayList<Seat> Row = new ArrayList<Seat>();
             for(int j = 0;j < numSeatsPerRow;j++)
             {
                 Passenger passenger = new Passenger("null", new Date(0), -1);
                 double cost = 75;
                 SeatClass seatClass = SeatClass.BUSINESS;
                 int seatRow = i+1;
                 String seatLettrer = Character.toString((char) (j+65));
                 boolean seatTaken = false;
                 Row.add(new Seat(passenger, cost, seatClass, seatRow, seatLettrer, seatTaken));
             }
             seats.add(Row);
         }
         F2 = new Flight(flightID, airline, departureLocation, destinationLocation, isConnecting, previousFlight, nextFlight,
          departureTime, arrivalTime, flightDuration, numRows, numSeatsPerRow, seats);
          flights.add(F2);

        flightID = UUID.randomUUID();
        airline = Airline.NORTHEAST;
        departureLocation = "Bad Choices";
        destinationLocation = "Hell";
        isConnecting = false;
        previousFlight = null;
        nextFlight = null;
        longdepartureTime = (long) 1652224593;
        longdepartureTime *= 1000;
        departureTime = new Date(longdepartureTime);
        longarrivalTime = (long) 1657494993;
        longarrivalTime *= 1000;
        arrivalTime = new Date(longarrivalTime);
        flightDuration = 2.0;
        numRows = 3;
        numSeatsPerRow = 3;
        seats = new ArrayList<ArrayList<Seat>>();
          for(int i = 0;i < numRows;i++)
          {
              ArrayList<Seat> Row = new ArrayList<Seat>();
              for(int j = 0;j < numSeatsPerRow;j++)
              {
                  Passenger passenger = new Passenger("null", new Date(0), -1);
                  double cost = 100;
                  SeatClass seatClass = SeatClass.BUSINESS;
                  int seatRow = i+1;
                  String seatLettrer = Character.toString((char) (j+65));
                  boolean seatTaken = false;
                  Row.add(new Seat(passenger, cost, seatClass, seatRow, seatLettrer, seatTaken));
              }
              seats.add(Row);
          }
          F3 = new Flight(flightID, airline, departureLocation, destinationLocation, isConnecting, previousFlight, nextFlight,
           departureTime, arrivalTime, flightDuration, numRows, numSeatsPerRow, seats);
          
           flights.add(F3);
        ArrayList<Flight> tempFlight = flights;
        FlightSort fs = new FlightSort(tempFlight);
        ArrayList<Flight> SF = fs.sortPrices();
        assertEquals(F1.getFlightID(), SF.get(0).getFlightID());
        
    }
}