package com.lukashman.starter;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lukashman.config.AppContext;
import com.lukashman.dao.EventDAO;
import com.lukashman.dao.EventDAOImpl;
import com.lukashman.model.Event;
import com.lukashman.model.EventType;

import javafx.application.Application;
import javafx.stage.Stage;

public class Start extends Application {
	
	ApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
	EventDAO dao = ctx.getBean(EventDAOImpl.class);
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Event ev = new Event("sdsdsds", new Date(), EventType.BIRTH_DAY);
		dao.addEvent(ev);
		List<Event> events = dao.getAllEvents();
		events.forEach(event -> System.out.println(event.getName()));
		events.forEach(event -> dao.deleteEvent(event.getId()));
	}
	
}
