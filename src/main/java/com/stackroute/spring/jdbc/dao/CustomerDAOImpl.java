package com.stackroute.spring.jdbc.dao;

import javax.sql.DataSource;

import com.stackroute.spring.jdbc.model.Movie;
import com.stackroute.spring.jdbc.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;

public class CustomerDAOImpl implements CustomerDAO {

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void create(Movie movie) {
		String queryMovie = "insert into movie (id, name,year,rating) values (?,?,?,?)";
		String queryActor = "insert into actor (id, name) values (?,?)";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(queryMovie, new Object[] { movie.getId(),
				movie.getName(),movie.getYear(),movie.getRating() });
		System.out.println("Inserted into Customer Table Successfully");
		jdbcTemplate.update(queryActor, new Object[] { movie.getId(),
				movie.getActor().getActorname() });
		System.out.println("Inserted into Address Table Successfully");
	}

}
