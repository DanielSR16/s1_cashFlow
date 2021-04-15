package DAO;

import DB.Connector;
import Entities.TipoIndicador;
import Entities.Utilidad;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UtilidadDAO {

    private final int ACCEPT = 1;
    Connector dataAdapter= new Connector();
    private Connection connection = dataAdapter.getConnectionMySql();

    public boolean insert(Utilidad utilidad) {
        boolean resultado = false;
        if (connection != null) {
            String sql = "insert into utilidad (idallingresos,idallegresos,totalingresos,totalegresos,semana,monto,margen) values (?,?,?,?,?,?,?);";
            try {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, utilidad.getIdallingresos());
                statement.setString(2, utilidad.getIdallegresos());
                statement.setFloat(3, utilidad.getIngresoTotal());
                statement.setFloat(4, utilidad.getEgresoTotal());
                statement.setInt(5,utilidad.getSemana());
                statement.setFloat(6, utilidad.getMonto());
                statement.setFloat(7, utilidad.getMargen());
                
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
