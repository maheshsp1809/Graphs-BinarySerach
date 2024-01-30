import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class Solution2 {
    static class Booking {
        String passengerName;
        String ticketClass;
        Date travelDate;
        int numSeats;

        Booking(String passengerName, String ticketClass, Date travelDate, int numSeats) {
            this.passengerName = passengerName;
            this.ticketClass = ticketClass;
            this.travelDate = travelDate;
            this.numSeats = numSeats;
        }
    }

    static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    static List<Booking> bookings = new ArrayList<>();
    static List<Booking> waitingList = new ArrayList<>();

    static void bookTicket(String passengerName, String ticketClass, Date travelDate, int numSeats) {
        Booking newBooking = new Booking(passengerName, ticketClass, travelDate, numSeats);
        if (canAccommodate(numSeats)) {
            bookings.add(newBooking);
            System.out.println("Booking confirmed for " + passengerName);
        } else {
            waitingList.add(newBooking);
            System.out.println("Booking added to waiting list for " + passengerName);
        }
    }

    static void cancelTicket(String passengerName, String ticketClass, Date travelDate, int numSeats) {
        Booking cancelBooking = new Booking(passengerName, ticketClass, travelDate, numSeats);
        if (bookings.remove(cancelBooking)) {
            System.out.println("Booking canceled for " + passengerName);
            tryToAllocateFromWaitingList();
        } else {
            System.out.println("Booking not found for passenger name: " + passengerName);
        }
    }

    static int checkStatus(String passengerName, String ticketClass, Date travelDate) {
        for (int i = 0; i < bookings.size(); i++) {
            Booking booking = bookings.get(i);
            if (booking.passengerName.equals(passengerName)
                    && booking.ticketClass.equals(ticketClass)
                    && booking.travelDate.equals(travelDate)) {
                return i + 1; // 1-indexed position
            }
        }
        return -1; // Not found
    }

    static void addToWaitingList(Booking booking) {
        waitingList.add(booking);
    }

    static boolean canAccommodate(int numSeats) {
        int availableSeats = 50; // Assuming a total of 50 seats for simplicity
        for (Booking booking : bookings) {
            availableSeats -= booking.numSeats;
        }
        return availableSeats >= numSeats;
    }

    static void tryToAllocateFromWaitingList() {
        if (!waitingList.isEmpty() && canAccommodate(waitingList.get(0).numSeats)) {
            bookings.add(waitingList.remove(0));
            System.out.println("Booking allocated from waiting list");
        }
    }

    public static void main(String[] args) {
        // Test Case 1
        bookTicket("Alice", "SL", parseDate("01/12/2023"), 1); // Booking confirmed for Alice
        bookTicket("Bob", "1AC", parseDate("01/12/2023"), 3); // Booking confirmed for Bob
        bookTicket("Carol", "SL", parseDate("01/12/2023"), 2); // Booking confirmed for Carol
        bookTicket("David", "2AC", parseDate("01/12/2023"), 2); // Booking confirmed for David
        checkStatus("Emma", "3AC", parseDate("01/12/2023")); // Position in waiting list: 1
        cancelTicket("John", "1AC", parseDate("01/12/2023"), 2); // Booking not found for passenger name: John

        // Test Case 2
        // bookTicket("John", "IAC", parseDate("01/12/2023"), 2); // Booking confirmed
        // for John
        // bookTicket("Alice", "2AC", parseDate("01/12/2023"), 3); // Booking confirmed
        // for Alice
        // bookTicket("Bob", "SL", parseDate("01/12/2023"), 1); // Booking confirmed for
        // Bob
        // bookTicket("David", "SL", parseDate("01/12/2023"), 2); // Booking confirmed
        // for David
        // checkStatus("Emma", "3AC", parseDate("01/12/2023")); // Position in waiting
        // list: 1
        // bookTicket("Frank", "2AC", parseDate("01/12/2023"), 2); // Booking added to
        // waiting list for Frank
        // checkStatus("John", "IAC", parseDate("01/12/2023")); // Booking not found for
        // passenger name: John
    }

    // Helper method to parse date string
    private static Date parseDate(String dateString) {
        try {
            return new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
