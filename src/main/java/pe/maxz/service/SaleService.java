package pe.maxz.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository

public class SaleService {
    private JdbcTemplate jdbcTemplate;
    public SaleService(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    public void save () throws Exception{
        String id ="xxxxxx0002";
        Connection con = jdbcTemplate.getDataSource().getConnection();

        con.setAutoCommit(false);
        try {
            //
            PreparedStatement pst = con.prepareStatement("insert into JOKR_ORDER_JSON_hdr(id) values (?)");
            pst.setString(1, id);
            pst.executeUpdate();
            pst.close();
            //Insert details
            for (int i = 0; i < 5; i++) {
                PreparedStatement pstDet = con.prepareStatement("insert into JOKR_ORDER_JSON_dtl(id,seque) values (?,1)");
                pstDet.setString(1, id);
                pstDet.setInt(2, i+1);
                pstDet.executeUpdate();
                pstDet.close();
            }
            con.commit();
            con.close();
        } catch (SQLException e) {
            con.rollback();
            con.close();
            throw new Exception(e.getMessage());
        }
    }
}
