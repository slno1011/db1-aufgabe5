package de.hska.iwii.db1.jpa;

import java.sql.Time;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAApplication {
	private EntityManagerFactory entityManagerFactory;

	public JPAApplication() {
		Logger.getLogger("org.hibernate").setLevel(Level.ALL);
		entityManagerFactory = Persistence.createEntityManagerFactory("DB1");
	}
	
	public void testFlights() {
		EntityManager man = entityManagerFactory.createEntityManager();
		man.getTransaction().begin();

		Kunde kunde1 = new Kunde("Max", "Mustermann", "max.mustermann@gmail.com");
		Kunde kunde2 = new Kunde("Rainer", "Zufall", "rainer.zufall@gmx.de");

		Flug flug1 = new Flug("DE199", "FRA", new Time(System.currentTimeMillis()));
		Flug flug2 = new Flug("LOT100", "LCJ", new Time(System.currentTimeMillis()));
		Flug flug3 = new Flug("XD49", "ARN", new Time(System.currentTimeMillis()));

		Buchung kunde1buchung1 = new Buchung();
		kunde1buchung1.setKunde(kunde1);
		kunde1buchung1.setFlug(flug1);
		kunde1buchung1.setSeats(2);
		kunde1buchung1.setDate(new Date(System.currentTimeMillis()));

		Buchung kunde1buchung2 = new Buchung();
		kunde1buchung2.setKunde(kunde1);
		kunde1buchung2.setFlug(flug2);
		kunde1buchung2.setSeats(2);
		kunde1buchung2.setDate(new Date(System.currentTimeMillis()));

		Buchung kunde2buchung1 = new Buchung();
		kunde2buchung1.setKunde(kunde2);
		kunde2buchung1.setFlug(flug2);
		kunde2buchung1.setSeats(2);
		kunde2buchung1.setDate(new Date(System.currentTimeMillis()));

		Buchung kunde2buchung2 = new Buchung();
		kunde2buchung2.setKunde(kunde2);
		kunde2buchung2.setFlug(flug3);
		kunde2buchung2.setSeats(2);
		kunde2buchung2.setDate(new Date(System.currentTimeMillis()));

		man.persist(kunde1);
		man.persist(kunde2);
		man.persist(flug1);
		man.persist(flug2);
		man.persist(flug3);
		man.persist(kunde1buchung1);
		man.persist(kunde1buchung2);
		man.persist(kunde2buchung1);
		man.persist(kunde2buchung2);

		// Bis hier Aufgabe 5.2

		man.getTransaction().commit();
		man.close();
	}
	
	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}
	
	public static void main(String[] args) {
		JPAApplication app = new JPAApplication();
		app.testFlights();
	}
}
