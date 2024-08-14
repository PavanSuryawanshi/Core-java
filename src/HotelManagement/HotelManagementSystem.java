package HotelManagement;

import java.sql.*;
import java.util.Scanner;

public class HotelManagementSystem {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Add Guest");
            System.out.println("2. View Guests");
            System.out.println("3. Add Room");
            System.out.println("4. View Rooms");
            System.out.println("5. Book Room");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addGuest();
                    break;
                case 2:
                    viewGuests();
                    break;
                case 3:
                    addRoom();
                    break;
                case 4:
                    viewRooms();
                    break;
                case 5:
                    bookRoom();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void addGuest() {
        System.out.print("Enter guest name: ");
        String name = scanner.nextLine();
        System.out.print("Enter contact number: ");
        String contactNumber = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        String sql = "INSERT INTO guests (name, contact_number, email) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.setString(2, contactNumber);
            pstmt.setString(3, email);
            pstmt.executeUpdate();
            System.out.println("Guest added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void viewGuests() {
        String sql = "SELECT * FROM guests";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("guest_id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Contact Number: " + rs.getString("contact_number"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("--------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void addRoom() {
        System.out.print("Enter room number: ");
        String roomNumber = scanner.nextLine();
        System.out.print("Enter room type: ");
        String roomType = scanner.nextLine();
        System.out.print("Enter room status (Available/Occupied): ");
        String status = scanner.nextLine();

        String sql = "INSERT INTO rooms (room_number, room_type, status) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, roomNumber);
            pstmt.setString(2, roomType);
            pstmt.setString(3, status);
            pstmt.executeUpdate();
            System.out.println("Room added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void viewRooms() {
        String sql = "SELECT * FROM rooms";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("room_id"));
                System.out.println("Room Number: " + rs.getString("room_number"));
                System.out.println("Room Type: " + rs.getString("room_type"));
                System.out.println("Status: " + rs.getString("status"));
                System.out.println("--------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void bookRoom() {
        System.out.print("Enter guest ID: ");
        int guestId = scanner.nextInt();
        System.out.print("Enter room ID: ");
        int roomId = scanner.nextInt();
        System.out.print("Enter check-in date (YYYY-MM-DD): ");
        String checkIn = scanner.next();
        System.out.print("Enter check-out date (YYYY-MM-DD): ");
        String checkOut = scanner.next();

        String sql = "INSERT INTO bookings (guest_id, room_id, check_in, check_out) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, guestId);
            pstmt.setInt(2, roomId);
            pstmt.setDate(3, Date.valueOf(checkIn));
            pstmt.setDate(4, Date.valueOf(checkOut));
            pstmt.executeUpdate();
            System.out.println("Room booked successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
