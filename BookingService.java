package service;

import dao.BookingRepository;
import model.Booking;

import java.util.List;

public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public void createBooking(Booking booking) {
        bookingRepository.save(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public void deleteBooking(int id) {
        bookingRepository.delete(id);
    }
}