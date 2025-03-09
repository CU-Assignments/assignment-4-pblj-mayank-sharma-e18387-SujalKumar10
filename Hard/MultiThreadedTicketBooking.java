import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class TicketBookingSystem {
    private boolean[] seats;
    private Lock lock;

    public TicketBookingSystem(int totalSeats) {
        seats = new boolean[totalSeats];
        lock = new ReentrantLock();
    }

    public void bookSeat(String customerType, int seatNumber) {
        lock.lock();
        try {
            if (seatNumber < 1 || seatNumber > seats.length) {
                System.out.println(customerType + " Booking: Invalid seat number.");
                return;
            }
            if (seats[seatNumber - 1]) {
                System.out.println(customerType + " Booking: Seat " + seatNumber + " is already booked.");
            } else {
                seats[seatNumber - 1] = true;
                System.out.println(customerType + " Booking: Seat " + seatNumber + " confirmed.");
            }
        } finally {
            lock.unlock();
        }
    }
}

class BookingThread extends Thread {
    private TicketBookingSystem system;
    private String customerType;
    private int seatNumber;

    public BookingThread(TicketBookingSystem system, String customerType, int seatNumber) {
        this.system = system;
        this.customerType = customerType;
        this.seatNumber = seatNumber;
    }

    @Override
    public void run() {
        system.bookSeat(customerType, seatNumber);
    }
}

public class MultiThreadedTicketBooking {
    public static void main(String[] args) {
        TicketBookingSystem system = new TicketBookingSystem(5);

        BookingThread vip1 = new BookingThread(system, "VIP", 1);
        BookingThread regular1 = new BookingThread(system, "Regular", 1);
        BookingThread vip2 = new BookingThread(system, "VIP", 2);
        BookingThread regular2 = new BookingThread(system, "Regular", 3);

        vip1.setPriority(Thread.MAX_PRIORITY);
        regular1.setPriority(Thread.NORM_PRIORITY);
        vip2.setPriority(Thread.MAX_PRIORITY);
        regular2.setPriority(Thread.NORM_PRIORITY);

        vip1.start();
        regular1.start();
        vip2.start();
        regular2.start();
    }
}
