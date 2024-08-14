//package HotelManagement;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class RoomDAO {
//    public void addRoom(String roomType, double roomPrice, String status) {
//        String sql = "INSERT INTO rooms (room_type, room_price, status) VALUES (?, ?, ?)";
//        try (Connection conn = DatabaseConnection.getConnection();
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            pstmt.setString(1, roomType);
//            pstmt.setDouble(2, roomPrice);
//            pstmt.setString(3, status);
//            pstmt.executeUpdate();
//            System.out.println("Room added successfully!");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//    public void listRooms() {
//        String sql = "SELECT * FROM rooms";
//        try (Connection conn = DatabaseConnection.getConnection();
//             PreparedStatement pstmt = conn.prepareStatement(sql);
//             ResultSet rs = pstmt.executeQuery()) {
//            while (rs.next()) {
//                int roomId = rs.getInt("room_id");
//                String roomType = rs.getString("room_type");
//                double roomPrice = rs.getDouble("room_price");
//                String status = rs.getString("status");
//                System.out.println("Room ID: " + roomId + ", Type: " + roomType + ", Price: " + roomPrice + ", Status: " + status);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//    public void updateRoom(int roomId, String roomType, double roomPrice, String status) {
//        String sql = "UPDATE rooms SET room_type = ?, room_price = ?, status = ? WHERE room_id = ?";
//        try (Connection conn = DatabaseConnection.getConnection();
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            pstmt.setString(1, roomType);
//            pstmt.setDouble(2, roomPrice);
//            pstmt.setString(3, status);
//            pstmt.setInt(4, roomId);
//            pstmt.executeUpdate();
//            System.out.println("Room updated successfully!");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//    public void deleteRoom(int roomId) {
//        String sql = "DELETE FROM rooms WHERE room_id = ?";
//        try (Connection conn = DatabaseConnection.getConnection();
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            pstmt.setInt(1, roomId);
//            pstmt.executeUpdate();
//            System.out.println("Room deleted successfully!");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}
//
