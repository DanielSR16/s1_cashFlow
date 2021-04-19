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
            String sql = "insert into utilidad (totalingresos,totalegresos,semana,monto,margen,totalVentas,totalIngresosClas,numMes) values (?,?,?,?,?,?,?,?);";
            try {
                PreparedStatement statement = connection.prepareStatement(sql);

                statement.setFloat(1,utilidad.getIngresoTotal());
                statement.setFloat(2,utilidad.getEgresoTotal());
                statement.setInt(3,utilidad.getSemana());
                statement.setFloat(4,utilidad.getMonto());
                statement.setInt(5,utilidad.getMargen());
                statement.setFloat(6,utilidad.getTotalVenta());
                statement.setFloat(7,utilidad.getTotalIngresoClas());
                statement.setInt(8,utilidad.getNumMes());
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
