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

public class ThongKe {

    public List<entities.ThongKe> getThongKe() {
        List<entities.ThongKe> list = new ArrayList<>();
        try (Connection connection = new JDBC_Connect().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT r.idroom "
                    + "FROM nhom3.ThanhToan as t JOIN nhom3.PhieuDat as p ON t.idphieu=p.idphieu JOIN nhom3.room as r ON p.idroom=r.idroom "
                    + "GROUP BY r.idroom");
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    list.add(
                            new entities.ThongKe(
                                    new model.Room().getRoomById(resultSet.getString("idroom")),
                                    getTongTienByPhieu(resultSet.getString("idroom"))
                            )
                    );
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public Float getTongTienByPhieu(String room) {
        try (Connection connection = new JDBC_Connect().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT SUM (ThanhTien) AS TongTien "
                    + "FROM nhom3.ThanhToan as t JOIN nhom3.PhieuDat as p ON t.idphieu=p.idphieu JOIN nhom3.room as r ON p.idroom=r.idroom "
                    + "WHERE r.idroom=? GROUP BY r.idroom");
            preparedStatement.setString(1, room);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getFloat("TongTien");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Float.NaN;
    }
}
