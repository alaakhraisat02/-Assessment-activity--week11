package dao.impl;

import dao.BookingRepository;
import db.DatabaseConnection;
import model.Booking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookingDaoImpl implements BookingRepository {

    @Override
    public Booking findById(int id) {
        return null;
    }

    @Override
    public List<Booking> findAll() {

        List<Booking> list = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection()) {

            String sql = "SELECT * FROM booking";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Booking b = new Booking();
                b.setBookingId(rs.getInt("booking_id"));
                list.add(b);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public void save(Booking booking) {

        try (Connection conn = DatabaseConnection.getConnection()) {

            String sql = "INSERT INTO booking (booking_id) VALUES (?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, booking.getBookingId());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {

        try (Connection conn = DatabaseConnection.getConnection()) {

            String sql = "DELETE FROM booking WHERE booking_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
