package com.stackroute.spring.jdbc.main;

import com.stackroute.spring.jdbc.model.Actor;
import com.stackroute.spring.jdbc.model.Movie;
import com.stackroute.spring.jdbc.service.CustomerManagerImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.stackroute.spring.jdbc.model.Movie;
import com.stackroute.spring.jdbc.service.CustomerManager;

public class TransactionManagerMain {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring.xml");

		CustomerManager customerManager = ctx.getBean("customerManager",
				CustomerManagerImpl.class);

		Movie movie = createDummyMovie();
		customerManager.createMovie(movie);

		ctx.close();
	}

	private static Movie createDummyMovie() {
		Movie movie = new Movie();
		movie.setId(3);
		movie.setName("Temper");
		movie.setYear(2016);
		movie.setRating(4);
		Actor actor = new Actor();

		actor.setActorname("NTR");
		// setting value more than 20 chars, so that SQLException occurs
		actor.setActorid(movie.getId());
		movie.setActor(actor);
		return movie;
	}

}
