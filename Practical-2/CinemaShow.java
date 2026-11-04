
public class CinemaShow {

    private String title;
    private int seatsAvailable;
    private final int capacity;

    private static int totalBooked = 0;

    // Constructor with title and capacity
    public CinemaShow(String title, int capacity) {

        this.title = title;
        this.capacity = capacity;
        this.seatsAvailable = capacity;
    }

    // Constructor chaining
    public CinemaShow(String title) {
        this(title, 100);
    }

    // Book seats
    public boolean book(int n) {

        if (n <= 0) {
            return false;
        }

        if (n <= seatsAvailable) {
            seatsAvailable -= n;
            totalBooked += n;
            return true;
        } else {
            return false;
        }
    }

    // Cancel booking
    public boolean cancel(int n) {

        if (n <= 0) {
            return false;
        }

        if (seatsAvailable + n <= capacity) {
            seatsAvailable += n;
            return true;
        } else {
            return false;
        }
    }

    // Return available seats
    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    // Return total booked seats
    public static int getTotalBooked() {
        return totalBooked;
    }

    // Main method
    public static void main(String[] args) {

        CinemaShow show = new CinemaShow("Avengers", 50);

        System.out.println("Movie: Avengers");
        System.out.println("Initial available seats: "
                + show.getSeatsAvailable());

        // Book 10 seats
        System.out.println("Booking 10 seats: " + show.book(10));
        System.out.println("Available seats: "
                + show.getSeatsAvailable());

        // Book 30 seats
        System.out.println("Booking 30 seats: " + show.book(30));
        System.out.println("Available seats: "
                + show.getSeatsAvailable());

        // Attempt to book 20 more seats
        System.out.println("Booking 20 seats: " + show.book(20));
        System.out.println("Available seats: "
                + show.getSeatsAvailable());

        // Cancel 5 seats
        System.out.println("Cancelling 5 seats: " + show.cancel(5));
        System.out.println("Available seats: "
                + show.getSeatsAvailable());

        // Attempt excessive cancellation
        System.out.println("Cancelling 20 seats: " + show.cancel(20));
        System.out.println("Available seats: "
                + show.getSeatsAvailable());

        System.out.println("Total booked: "
                + CinemaShow.getTotalBooked());
    }
}
