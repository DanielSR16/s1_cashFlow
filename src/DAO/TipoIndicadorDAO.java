package DAO;

import DB.Connector;
import Entities.Informe;
import Entities.TipoIndicador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TipoIndicadorDAO {
    private final int ACCEPT = 1;
    Connector dataAdapter= new Connector();
    private Connection connection = dataAdapter.getConnectionMySql();

    public boolean insert(TipoIndicador indicador) {
        boolean resultado = false;
        if (connection != null) {
            String sql = "insert tipoindicador informe (nombre) values (?)";

            try {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, indicador.getNombre());
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
