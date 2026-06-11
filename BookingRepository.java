package dao;

import model.Booking;
import java.util.List;

public interface BookingRepository {

    Booking findById(int id);

    List<Booking> findAll();

    void save(Booking booking);

    void delete(int id);
}