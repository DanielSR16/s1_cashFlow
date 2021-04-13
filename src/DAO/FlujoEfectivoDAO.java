package DAO;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

import DB.Connector;
import Entities.Categoria;
import Entities.Clasificacion;
import Entities.FlujoEfectivo;

public class FlujoEfectivoDAO {
	private final int ACCEPT = 1;
	Connector dataAdapter= new Connector();
	private Connection connection = dataAdapter.getConnectionMySql();
	
	public boolean insertFlujo(FlujoEfectivo flujoefectivo) {
		boolean resultado = false;
	
		
		if (connection != null) {
			String sql = "insert into flujoefectivo(monto,fecha,descripcion,categoria,subcategoria) values(?,?,?,?,?)";
			
			try {
				PreparedStatement statement = connection.prepareStatement(sql);
			statement.setFloat(1, flujoefectivo.getMonto());
			statement.setDate(2, flujoefectivo.getFecha() );
			statement.setString(3, flujoefectivo.getDescripcion() );
			statement.setString(4, flujoefectivo.getCategoria() );
			statement.setString(5, flujoefectivo.getSubCategoria() );
				if (statement.executeUpdate() == ACCEPT)
					resultado = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return resultado;
	}

	public List<FlujoEfectivo> getAllFlujoEfectivo() { //retorna todos los registros
		List<FlujoEfectivo> flujos = new ArrayList<>();

		if (connection != null) {
			String sql = "select * from flujoefectivo";

			try {
				PreparedStatement statement = connection.prepareStatement(sql);
				ResultSet results = statement.executeQuery();
				while (results.next()) {

					float monto = results.getFloat(2);
					Date fecha = results.getDate(3);
					String descripcion = results.getString(4);
					String categoria = results.getString(5);
					String subcategoria = results.getString(6);

					FlujoEfectivo fluj = new FlujoEfectivo(monto,descripcion,fecha,categoria,subcategoria);


					flujos.add(fluj);

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return flujos;
	}
	
	
	
}
