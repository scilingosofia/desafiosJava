package ar.com.educacionit.desafios.java5.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import ar.com.educacionit.desafios.java5.domain.Entity;
import ar.com.educacionit.desafios.java5.repository.db.ConnectionManager;

public class CovidRecordRepositoryImpl extends BaseCrud<Entity> {

	public CovidRecordRepositoryImpl() {
		super(Entity.class, "covid_records");
	}

	@Override
	public Optional<Entity> getById(Long id) {
		String sql = "SELECT * FROM " + super.table + " WHERE json_record->'$.date' = "+ id;
		System.out.println(sql);
		Entity entity = null;
		
		//JDBC: par poder consultar a la tabla via java
		
		try(Connection connection =  ConnectionManager.getConnection()) {
			
			//armar el sql
			PreparedStatement statement = connection.prepareStatement(sql);
			
			//recibir los datos
			ResultSet resultSet = statement.executeQuery();
			
			//id|col2|colmN
			//procesar los registro
			if(resultSet.next()) {//hay registro que mirar
				//extraigo los datos
				entity = this.fromResultSetToEntity(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Optional.ofNullable(entity);
	}


	@Override
	protected Entity fromResultSetToEntity(ResultSet res) throws SQLException {
		Long id = res.getLong(1);
		String json = res.getString(2);
		return new Entity(id,json);
	}

}
