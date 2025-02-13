package main;

import java.time.LocalDate;

import business.Reserva;
import classesBasicas.Propriedade;
import classesBasicas.Registro;
import classesBasicas.User;
import dados.IRepositorio;
import dados.RepositorioRegistroSet;
import dados.RepositorioUserSet;
import exceptions.PaymentNotCompletedException;
import exceptions.WeekAlreadyReservedException;
import exceptions.WeekNotAvailableException;


public class TesteReserva {
	
public static void main(String[] args) {
		
		IRepositorio repositorioRegi = new RepositorioRegistroSet();
		IRepositorio repositorioUser = new RepositorioUserSet();
		
		LocalDate date = LocalDate.now(); 
		Reserva reserva = new Reserva(); 
		Propriedade propriedade = new Propriedade("Praia","bonita","Rural",100,20, date); 
		
		User u = new User("123", "jonh");
		User j = new User("321", "joshua");
		Registro r = new Registro(((byte)1), propriedade, u);
		
		repositorioRegi.adicionar(r);
		repositorioUser.adicionar(j);
		repositorioUser.adicionar(u);
		//r.setReservado(true);
		r.setAvailabe(true);
		try {
			reserva.reservar(r, j);
			System.out.println("Reserva realizada"); 
		} catch (WeekAlreadyReservedException | PaymentNotCompletedException | WeekNotAvailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		

	}
	
}
