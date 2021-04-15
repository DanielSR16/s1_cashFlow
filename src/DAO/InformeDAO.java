package DAO;

import DB.Connector;
import Entities.IndicadoresDinero;
import Entities.Informe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InformeDAO {

    private final int ACCEPT = 1;
    Connector dataAdapter= new Connector();
    private Connection connection = dataAdapter.getConnectionMySql();

    public boolean insert(Informe informe) {
        boolean resultado = false;
        if (connection != null) {
            String sql = "insert into informe (fecha,idallutilidad,idallindicadores) values (?,?,?)";

            try {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setDate(1, informe.getFecha());
                statement.setString(2, informe.getIdAllUtilidad());
                statement.setString(3,informe.getIdAllIncadores());
                if (statement.executeUpdate() == ACCEPT)
                    resultado = true;
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return resultado;
    }
}
