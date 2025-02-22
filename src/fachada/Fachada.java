package fachada;

import dados.IRepositorio;
import dados.RepositorioUserSet;
import dados.RepositorioRegistroSet;
import dados.RepositorioReservaSet;
import dados.RepositorioGerenteSet;
import dados.RepositorioPropriedadeSet;
import classesBasicas.User;
import classesBasicas.Gerente;
import classesBasicas.Propriedade;
import classesBasicas.Registro;
import business.LoginUser;

import java.io.IOException;

import business.CadastroGerente;
import business.CadastroPropriedade;
import business.CadastroUser;
import business.LoginGerente;
import business.Reserva;
import business.Transfer;
import exceptions.UnregisteredUserException;
import exceptions.WrongPasswordException;
import exceptions.PaymentNotCompletedException;
import exceptions.WeekAlreadyReservedException;
import exceptions.WeekNotAvailableException;
import exceptions.EmptyArchiveException;
import exceptions.GerenteAlreadyExistsException;
import exceptions.UserAlreadyExistsException;
import exceptions.UnregisteredPropriedadeException;
import exceptions.UnregisteredGerenteException;
import exceptions.PropriedadeAlreadyExistsException;
import exceptions.ObjectOutsideArrayException;


public class Fachada {
	
private IRepositorio repUser = new RepositorioUserSet("arquivo_user.dat");
	private IRepositorio repRegis = new RepositorioRegistroSet("arquivo_registro.dat");
	private IRepositorio repPropriedade = new RepositorioRegistroSet("arquivo_propriedade.dat"); 
	private IRepositorio repGerente = new RepositorioGerenteSet("arquivo_gerente.dat"); 
	private IRepositorio repReserva = new RepositorioReservaSet("arquivo_reserva.dat"); 
	private LoginGerente loginGerente = new LoginGerente(repGerente); 
	private LoginUser loginUser = new LoginUser(repUser,(RepositorioReservaSet)repReserva) ; 
	
	private CadastroUser cadUser= new CadastroUser(repUser); 
	private CadastroPropriedade cadProp = new CadastroPropriedade(repPropriedade,repGerente,repRegis);
	private CadastroGerente cadGer = new CadastroGerente(repGerente);
	
	public Fachada() {
		
	}
	
	public void existeGerente(Gerente g) throws ClassNotFoundException, IOException, EmptyArchiveException {
		cadGer.existe(g); 
	}
	public void existeProrpriedade(Propriedade p, Gerente g) throws ClassNotFoundException, IOException, EmptyArchiveException {
		cadProp.existe(p); 
	}
	
	public void existeUser(User g) throws ClassNotFoundException, IOException, EmptyArchiveException {
		cadUser.existe(g); 
	}
	
	public void cadastrarUser(User a) throws UserAlreadyExistsException, ClassNotFoundException, IOException, EmptyArchiveException {
		cadUser.cadastrar(a);
	}
	
	public void cadastrarGerente(Gerente a) throws  GerenteAlreadyExistsException, ClassNotFoundException, IOException, EmptyArchiveException {
		cadGer.cadastrar(a);
	}
	
	public void cadastrarPropriedade(Propriedade a, String idGerente) throws  UnregisteredGerenteException, PropriedadeAlreadyExistsException, ClassNotFoundException, IOException, EmptyArchiveException {
		cadProp.cadastrar(idGerente,a);
	}
	
	public void descadastrarUser(String idUser) throws ObjectOutsideArrayException, UnregisteredUserException, ClassNotFoundException, IOException, EmptyArchiveException {
		cadUser.descadastrar(idUser);
	}
	public void descadastrarPropriedade(String idPropriedade, String idGerente) throws ObjectOutsideArrayException,UnregisteredGerenteException, UnregisteredPropriedadeException, ClassNotFoundException, IOException, EmptyArchiveException {
		cadProp.descadastrar(idGerente, idPropriedade);
	}
	public void descadastrarGerente(String idGerente ) throws ObjectOutsideArrayException, UnregisteredGerenteException, ClassNotFoundException, IOException, EmptyArchiveException {
		cadGer.descadastrar(idGerente);
	}
	
	public void loginGerente( String id, String senha) throws WrongPasswordException, UnregisteredGerenteException, ObjectOutsideArrayException, ClassNotFoundException, IOException, EmptyArchiveException {
		loginGerente.efetuarLogin(id, senha);
	}
	
	public void loginUser( String id, String senha) throws WrongPasswordException, UnregisteredUserException, ObjectOutsideArrayException, ClassNotFoundException, IOException, EmptyArchiveException {
		loginUser.efetuarLogin(id, senha);
	}
	
	
	
	
	
	
	
	
}
