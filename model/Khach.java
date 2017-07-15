package model;

import connection.JDBC_Connect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;

public class Khach {

    public List<entities.Khach> getKhach() {
        List<entities.Khach> list = new ArrayList<>();
        try (Connection connection = new JDBC_Connect().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM nhom3.Khach");
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    list.add(
                            getKhachByCmnd(resultSet.getString("cmnd"))
                    );
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Khach.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public entities.Khach getKhachByCmnd(String cmnd) {
        entities.Khach khach = new entities.Khach();
        try (Connection connection = new JDBC_Connect().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM nhom3.Khach WHERE cmnd=?");
            preparedStatement.setString(1, cmnd);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    khach = new entities.Khach(
                            resultSet.getString("cmnd"),
                            resultSet.getString("nameK"),
                            resultSet.getString("sdt"),
                            resultSet.getString("email")
                    );
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Khach.class.getName()).log(Level.SEVERE, null, ex);
        }
        return khach;
    }

    public boolean saveOrUpdate(entities.Khach khach) throws SQLException {
        try (Connection connection = new JDBC_Connect().getConnection()) {
            String sql = "UPDATE nhom3.Khach "
                    + "SET nameK=?, sdt=?, email=? WHERE cmnd=?";
            if (getKhachByCmnd(khach.getCmnd()) == null
                    || getKhachByCmnd(khach.getCmnd()).getCmnd() == null) {
                sql = "INSERT INTO nhom3.Khach(nameK, sdt, email, cmnd) "
                        + "values (?,?,?,?)";
            }
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, khach.getNameK());
            preparedStatement.setString(2, khach.getSdt());
            preparedStatement.setString(3, khach.getEmail());
            preparedStatement.setString(4, khach.getCmnd());
            return preparedStatement.executeUpdate() != 0;
        }
    }

    public boolean delete(String cmnd) throws SQLException {
        try (Connection connection = new JDBC_Connect().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM nhom3.Khach WHERE cmnd=?");
            preparedStatement.setString(1, cmnd);
            return preparedStatement.executeUpdate() != 0;
        }
    }
}
