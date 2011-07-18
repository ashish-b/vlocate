package org.cloudfoundry.samples;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ReferenceDataRepository {
	
	private JdbcTemplate jdbcTemplate;
	
	@Inject
	public void init(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public String getDbInfo() {
		DataSource dataSource = jdbcTemplate.getDataSource();
		if (dataSource instanceof BasicDataSource) {
			return ((BasicDataSource) dataSource).getUrl();
		}
		else if (dataSource instanceof SimpleDriverDataSource) {
			return ((SimpleDriverDataSource) dataSource).getUrl();
		}
		return dataSource.toString();
	}
	
	public List<State> findAll() {
		return this.jdbcTemplate.query("select * from current_states", new RowMapper<State>() {
				public State mapRow(ResultSet rs, int rowNum) throws SQLException {
					State s = new State();
					s.setId(rs.getLong("id"));
					s.setStateCode(rs.getString("state_code"));
					s.setName(rs.getString("name"));
					return s;
				}
			});
	}

	public void insertOne(){
		this.jdbcTemplate.execute("insert into current_states(id, state_code, name) values(5, 'CA', 'California') ON DUPLICATE KEY UPDATE id=id;");
	}
	
	public void insertCheckOutInfo(String user_email, String car_type, String destination){
		//eid, car_id, source, destination , checkin_time time, checkout_time time
		
		this.jdbcTemplate.execute("insert into trip(eid, car_id, source, destination, checkin_time) values(" + user_email + ", "+ car_type +"," + destination  +", "+ destination  +", now()) ON DUPLICATE KEY UPDATE id=id;");
	}
	
	public List<Trip> findAllTrips() {
		return this.jdbcTemplate.query("select * from trip", new RowMapper<Trip>() {
				public Trip mapRow(ResultSet rs, int rowNum) throws SQLException {
					Trip t = new Trip();
					t.setId(rs.getLong("id"));
					t.setEid(rs.getLong("eid"));
					t.setCar_id(rs.getLong("car_id"));
					t.setSource(rs.getLong("source"));
					t.setDestination(rs.getLong("destination"));
					t.setCheckin_time(rs.getLong("checkin_time"));
					t.setCheckout_time(rs.getLong("checkout_time"));
					return t;
				}
			});
	}

}
