package DAO;

import DB.Connector;
import Entities.Categoria;
import Entities.IndicadoresDinero;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class IndicadoresDineroDAO {

    private final int ACCEPT = 1;
    Connector dataAdapter= new Connector();
    private Connection connection = dataAdapter.getConnectionMySql();

    public boolean insert(IndicadoresDinero indicadoresdinero) {
        boolean resultado = false;
        if (connection != null) {
            String sql = "insert into indicadoresdinero (numsemana,monto,asunto,idtipoindicador) values (?,?,?,?)";

            try {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, indicadoresdinero.getNumSemana());
                statement.setFloat(2, indicadoresdinero.getMonto());
                statement.setString(3,indicadoresdinero.getAsunto());
                statement.setInt(4,indicadoresdinero.getIdTipoIndicador());
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
