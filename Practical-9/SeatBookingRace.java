
class SeatBookingRace {

    static class BookingSystem {
        int seatsLeft = 5;
        int successfulBookings = 0;

        // Booking without synchronization
        void bookSeat() {
            if (seatsLeft > 0) {
                seatsLeft--;
                successfulBookings++;
                System.out.println(Thread.currentThread().getName()
                        + " booked a seat. Seats left: " + seatsLeft);
            } else {
                System.out.println(Thread.currentThread().getName()
                        + " could not book. No seats available.");
            }
        }

        // Booking with synchronization
        synchronized void bookSeatSync() {
            if (seatsLeft > 0) {
                seatsLeft--;
                successfulBookings++;
                System.out.println(Thread.currentThread().getName()
                        + " booked a seat. Seats left: " + seatsLeft);
            } else {
                System.out.println(Thread.currentThread().getName()
                        + " could not book. No seats available.");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        final int THREADS = 10;

        // Without synchronization
        System.out.println("=== Without Synchronization ===");

        BookingSystem system1 = new BookingSystem();
        Thread[] threads = new Thread[THREADS];

        for (int i = 0; i < THREADS; i++) {
            threads[i] = new Thread(() -> system1.bookSeat(),
                    "Customer-" + (i + 1));
            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }

        System.out.println("Successful Bookings: "
                + system1.successfulBookings);
        System.out.println("Seats Remaining: " + system1.seatsLeft);

        // With synchronization
        System.out.println("\n=== With Synchronization ===");

        BookingSystem system2 = new BookingSystem();

        for (int i = 0; i < THREADS; i++) {
            threads[i] = new Thread(() -> system2.bookSeatSync(),
                    "Customer-" + (i + 1));
            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }

        System.out.println("Successful Bookings: "
                + system2.successfulBookings);
        System.out.println("Seats Remaining: " + system2.seatsLeft);
    }
}
