package ar.com.educacionit.desafios.java5.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import ar.com.educacionit.desafios.java5.domain.Entity;
import ar.com.educacionit.desafios.java5.repository.db.ConnectionManager;

public abstract class BaseCrud <T extends Entity> implements BaseRepository<T>{
	private Class<T> type;
	protected String table;
	
	public BaseCrud(Class<T> type, String table) {
		super();
		this.type = type;
		this.table = table;
	}
	
	@Override
	public void save(T entity) {
		String sql ="INSERT INTO " + this.table + this.getSaveSQL();
		System.out.println(sql);
		try(Connection connection = ConnectionManager.getConnection()){
			PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			saveEntity(entity, statement);
			ResultSet resKey = statement.getGeneratedKeys();
			
			if(resKey.next()) {
				entity.setId(resKey.getLong(1));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} 
	}
	
	public Optional<T> getById(Long id){
		String sql = "SELECT * FROM "+ this.table + " WHERE json_record->'$.id' = " + id;
		System.out.println(sql);
		T entity = null;
		
		//JDBC: par poder consultar a la tabla via java
		
		try(Connection connection =  ConnectionManager.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()) {//hay registro que mirar
				entity = this.fromResultSetToEntity(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Optional.ofNullable(entity);
	}
	
	protected String getSaveSQL() {
		return "(json_record) values (?)";
	}
	protected void saveEntity(T entidad,PreparedStatement pst) throws SQLException {
		pst.setString(1, "'"+entidad.getJson()+"'");
	}
	protected abstract T fromResultSetToEntity(ResultSet res) throws SQLException;
	
	
	
	
}
