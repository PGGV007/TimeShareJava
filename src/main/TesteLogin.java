package main;
import classesBasicas.User;
import dados.IRepositorio;
import dados.RepositorioUserSet;
import exceptions.ObjectOutsideArrayException;
import exceptions.UnregisteredUserException;
import exceptions.WrongPasswordException;
import business.LoginUser;

public class TesteLogin {

	public static void main(String[] args) {
		
		User u = new User("123","Jonh","321");
		IRepositorio repositorio = new RepositorioUserSet(); 
		repositorio.adicionar(u);
		LoginUser login = new LoginUser(repositorio);
		
		try {
			login.efetuarLogin("Jonh", u.getIdUser(), "0");
			System.out.println("Sucesso");
			System.out.println(u.getIdUser());
		} catch (WrongPasswordException e) {
			
			e.printStackTrace();
			System.out.println("Senha errada");
		} catch (UnregisteredUserException e) {
			
			e.printStackTrace();
			System.out.println("User não registrado");
		} catch (ObjectOutsideArrayException e) {
			
			e.printStackTrace();
			System.out.println("Objeto fora do repositorio");
		}
		
	}

}
