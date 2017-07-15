package model;

import connection.JDBC_Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PhieuDat {

    public List<entities.PhieuDat> getPhieuDatByActive() {
        List<entities.PhieuDat> list = new ArrayList<>();
        try (Connection connection = new JDBC_Connect().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM nhom3.PhieuDat WHERE kichhoat=1");
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    list.add(
                            getPhieuDatByID(resultSet.getString("idphieu"))
                    );
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhieuDat.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public boolean checkPhongByPhieuDat(entities.PhieuDat phieuDat) {
        List<entities.PhieuDat> list = new ArrayList<>();
        try (Connection connection = new JDBC_Connect().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from nhom3.PhieuDat where idroom = ? AND kichhoat=1 "
                    + "AND datein BETWEEN ? AND ? "
                    + "AND dateout BETWEEN ? AND ?");
            preparedStatement.setString(1, phieuDat.getRoom().getIdroom());
            preparedStatement.setString(2, phieuDat.getDatein());
            preparedStatement.setString(3, phieuDat.getDateout());
            preparedStatement.setString(4, phieuDat.getDatein());
            preparedStatement.setString(5, phieuDat.getDateout());
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    list.add(
                            getPhieuDatByID(resultSet.getString("idphieu"))
                    );
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhieuDat.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list.isEmpty();
    }

    public List<entities.PhieuDat> getPhieuDat() {
        List<entities.PhieuDat> list = new ArrayList<>();
        try (Connection connection = new JDBC_Connect().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM nhom3.PhieuDat");
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    list.add(
                            getPhieuDatByID(resultSet.getString("idphieu"))
                    );
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhieuDat.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public entities.PhieuDat getPhieuDatByID(String idphieu) {
        entities.PhieuDat item = new entities.PhieuDat();
        try (Connection connection = new JDBC_Connect().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT *, VARCHAR_FORMAT(datein, 'DD/MM/YYYY') AS dateinf, VARCHAR_FORMAT(dateout, 'DD/MM/YYYY') AS dateoutf FROM nhom3.PhieuDat WHERE idphieu=?");
            preparedStatement.setString(1, idphieu);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    item = new entities.PhieuDat(
                            resultSet.getString("idphieu"),
                            new model.Room().getRoomById(resultSet.getString("idroom")),
                            resultSet.getString("dateinf"),
                            resultSet.getString("dateoutf"),
                            new model.Khach().getKhachByCmnd(resultSet.getString("khach")),
                            resultSet.getBoolean("kichhoat")
                    );
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhieuDat.class.getName()).log(Level.SEVERE, null, ex);
        }
        return item;
    }

    public boolean saveOrUpdate(entities.PhieuDat phieu) throws SQLException {
        try (Connection connection = new JDBC_Connect().getConnection()) {
            String sql = "UPDATE nhom3.PhieuDat "
                    + "SET idroom=?, datein=?, dateout=?, khach=? WHERE idphieu=?";
            if (phieu.getIdphieu() == null) {
                sql = "INSERT INTO nhom3.PhieuDat(idroom, datein, dateout, khach) "
                        + "values (?,?,?,?)";
            }
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, phieu.getRoom().getIdroom());
            preparedStatement.setString(2, phieu.getDatein());
            preparedStatement.setString(3, phieu.getDateout());
            preparedStatement.setString(4, phieu.getKhach().getCmnd());
            if (phieu.getIdphieu() != null) {
                preparedStatement.setString(5, phieu.getIdphieu());
            }
            return preparedStatement.executeUpdate() != 0;
        }
    }

    public boolean delete(String idphieu) throws SQLException {
        try (Connection connection = new JDBC_Connect().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM nhom3.PhieuDat WHERE idphieu=?");
            preparedStatement.setString(1, idphieu);
            return preparedStatement.executeUpdate() != 0;
        }
    }

    public boolean updateActive(entities.PhieuDat phieu, boolean kichhoat) throws SQLException {
        try (Connection connection = new JDBC_Connect().getConnection()) {
            String sql = "UPDATE nhom3.PhieuDat "
                    + "SET kichhoat=? WHERE idphieu=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setBoolean(1, kichhoat);
            preparedStatement.setString(2, phieu.getIdphieu());
            return preparedStatement.executeUpdate() != 0;
        }
    }
}
