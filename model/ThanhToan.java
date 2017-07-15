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

public class ThanhToan {
    
    public List<entities.ThanhToan> getThanhToan() {
        List<entities.ThanhToan> list = new ArrayList<>();
        try (Connection connection = new JDBC_Connect().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM nhom3.ThanhToan");
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    list.add(
                            getThanhToanByID(resultSet.getString("idthanhtoan"))
                    );
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThanhToan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public entities.ThanhToan getThanhToanByID(String idphieu) {
        entities.ThanhToan item = new entities.ThanhToan();
        try (Connection connection = new JDBC_Connect().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM nhom3.ThanhToan WHERE idthanhtoan=?");
            preparedStatement.setString(1, idphieu);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    item = new entities.ThanhToan(
                            resultSet.getString("idthanhtoan"),
                            new model.PhieuDat().getPhieuDatByID(resultSet.getString("idphieu")),
                            resultSet.getFloat("ThanhTien")
                    );
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThanhToan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return item;
    }

    public boolean saveOrUpdate(entities.ThanhToan item) throws SQLException {
        try (Connection connection = new JDBC_Connect().getConnection()) {
            String sql = "UPDATE nhom3.ThanhToan "
                    + "SET idphieu=?, ThanhTien=? WHERE idthanhtoan=?";
            if (item.getIdthanhtoan() == null) {
                sql = "INSERT INTO nhom3.ThanhToan(idphieu, ThanhTien) "
                        + "values (?,?)";
            }
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, item.getPhieuDat().getIdphieu());
            preparedStatement.setFloat(2, item.getThanhTien());
            if (item.getIdthanhtoan() != null) {
                preparedStatement.setString(3, item.getIdthanhtoan());
            }
            return preparedStatement.executeUpdate() != 0;
        }
    }

    public boolean delete(String idphieu) throws SQLException {
        try (Connection connection = new JDBC_Connect().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM nhom3.ThanhToan WHERE idthanhtoan=?");
            preparedStatement.setString(1, idphieu);
            return preparedStatement.executeUpdate() != 0;
        }
    }
}
