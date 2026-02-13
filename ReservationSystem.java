import java.sql.*;

public class ReservationSystem {

    // Add Train
    public void addTrain(int trainId, String trainName, int totalSeats) {
        String query = "INSERT INTO trains VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, trainId);
            ps.setString(2, trainName);
            ps.setInt(3, totalSeats);
            ps.setInt(4, totalSeats);

            ps.executeUpdate();
            System.out.println("Train Added Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Book Ticket
    public void bookTicket(String name, int age, int trainId) {
        try (Connection conn = DBConnection.getConnection()) {

            String checkQuery = "SELECT available_seats FROM trains WHERE train_id = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
            checkStmt.setInt(1, trainId);
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                int availableSeats = rs.getInt("available_seats");

                if (availableSeats > 0) {
                    int seatNumber = availableSeats;

                    String insertTicket = "INSERT INTO tickets (passenger_name, passenger_age, train_id, seat_number, status) VALUES (?, ?, ?, ?, ?)";
                    PreparedStatement insertStmt = conn.prepareStatement(insertTicket);

                    insertStmt.setString(1, name);
                    insertStmt.setInt(2, age);
                    insertStmt.setInt(3, trainId);
                    insertStmt.setInt(4, seatNumber);
                    insertStmt.setString(5, "CONFIRMED");

                    insertStmt.executeUpdate();

                    String updateSeats = "UPDATE trains SET available_seats = available_seats - 1 WHERE train_id = ?";
                    PreparedStatement updateStmt = conn.prepareStatement(updateSeats);
                    updateStmt.setInt(1, trainId);
                    updateStmt.executeUpdate();

                    System.out.println("Ticket Booked Successfully! Seat No: " + seatNumber);
                } else {
                    System.out.println("No seats available!");
                }
            } else {
                System.out.println("Train not found!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Cancel Ticket
    public void cancelTicket(int ticketId) {
        try (Connection conn = DBConnection.getConnection()) {

            String getTrainQuery = "SELECT train_id FROM tickets WHERE ticket_id = ?";
            PreparedStatement getStmt = conn.prepareStatement(getTrainQuery);
            getStmt.setInt(1, ticketId);
            ResultSet rs = getStmt.executeQuery();

            if (rs.next()) {
                int trainId = rs.getInt("train_id");

                String deleteTicket = "DELETE FROM tickets WHERE ticket_id = ?";
                PreparedStatement deleteStmt = conn.prepareStatement(deleteTicket);
                deleteStmt.setInt(1, ticketId);
                deleteStmt.executeUpdate();

                String updateSeats = "UPDATE trains SET available_seats = available_seats + 1 WHERE train_id = ?";
                PreparedStatement updateStmt = conn.prepareStatement(updateSeats);
                updateStmt.setInt(1, trainId);
                updateStmt.executeUpdate();

                System.out.println("Ticket Cancelled Successfully!");
            } else {
                System.out.println("Ticket not found!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // View Train Details
    public void viewTrain(int trainId) {
        try (Connection conn = DBConnection.getConnection()) {

            String query = "SELECT * FROM trains WHERE train_id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, trainId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Train ID: " + rs.getInt("train_id"));
                System.out.println("Train Name: " + rs.getString("train_name"));
                System.out.println("Total Seats: " + rs.getInt("total_seats"));
                System.out.println("Available Seats: " + rs.getInt("available_seats"));
            } else {
                System.out.println("Train not found!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}