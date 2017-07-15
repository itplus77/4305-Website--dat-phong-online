package model;

import connection.JDBC_Connect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;

public class Room {
    
    public static void main(String[] args) {
        List<entities.Room> rooms = new Room().getRoom();
        System.out.println(rooms.size());
    }
    
    public List<entities.Room> getRoom() {
        List<entities.Room> rooms = new ArrayList<>();
        try (Connection connection = new JDBC_Connect().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from nhom3.Room");
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    rooms.add(
                            getRoomById(resultSet.getString("idroom"))
                    );
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Room.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rooms;
    }
    
    public entities.Room getRoomById(String id) {
        entities.Room room = new entities.Room();
        try (Connection connection = new JDBC_Connect().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from nhom3.Room Where idroom=?");
            preparedStatement.setString(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    room = new entities.Room(
                            resultSet.getString("idroom"),
                            resultSet.getString("nameP"),
                            resultSet.getString("type")
                    );
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Room.class.getName()).log(Level.SEVERE, null, ex);
        }
        return room;
    }
}
