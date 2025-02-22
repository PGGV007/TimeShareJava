package business;
import java.io.IOException;

import classesBasicas.Registro;
import classesBasicas.User;
import dados.IRepositorio;
import exceptions.EmptyArchiveException;
import exceptions.ObjectOutsideArrayException;
import exceptions.UnregisteredUserException;
import exceptions.WrongPasswordException;
import java.time.LocalDate;
import java.util.HashSet;
import java.time.temporal.ChronoUnit;
import dados.RepositorioRegistroSet;
import dados.RepositorioReservaSet;


public class LoginUser {
	
	IRepositorio repositorioUser; 
	RepositorioReservaSet repositorioReserva; 
	
	
	public LoginUser(IRepositorio repositorioUser, RepositorioReservaSet repositorioReserva) {
		this.repositorioUser = repositorioUser; 
		this.repositorioReserva = repositorioReserva; 
		 
	}
	
	public boolean efetuarLogin( String id, String senha) throws WrongPasswordException, UnregisteredUserException, ObjectOutsideArrayException, ClassNotFoundException, IOException, EmptyArchiveException  {
		
		HashSet<Reserva> reservas = (HashSet<Reserva>) repositorioReserva.procurarUser((User)repositorioUser.procurar(id)); 
		
		if(repositorioUser.existe(id)) { 
			
			LocalDate dataLocal = LocalDate.now();
			
			long distanceDate;
			
			for(Reserva r : reservas) {//checa a data do dia inicial da reserva e comprara com a data do sistema, se o prazo passou, a reserva é cancelada
				 distanceDate = ChronoUnit.DAYS.between(dataLocal,r.getDataInicial()) ;
				if( distanceDate >= 6) {
					r.setAtivo(false);
				}
			}
			
			if(((User)repositorioUser.procurar(id)).getSenha().equals(senha)) {
				return true; 
			}else {
				throw new WrongPasswordException(); 
			}
			
		}else {
			throw new UnregisteredUserException(); 
		}
		
		
	}
	
}
