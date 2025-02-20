package main;

import java.io.IOException;
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
		
		IRepositorio repositorioRegi = new RepositorioRegistroSet("arquivo_registro.dat");
		IRepositorio repositorioUser = new RepositorioUserSet("arquivo_user.dat");
		
		LocalDate date = LocalDate.now(); 
		Reserva reserva = new Reserva(); 
		Propriedade propriedade = new Propriedade("Praia","bonita","Rural",100,20, date); 
		
		User u = new User("123", "jonh","123");
		User j = new User("321", "joshua","123");
		Registro r = new Registro(((byte)1), propriedade, u);
		
		try {
			repositorioRegi.adicionar(r);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			repositorioUser.adicionar(j);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			repositorioUser.adicionar(u);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
