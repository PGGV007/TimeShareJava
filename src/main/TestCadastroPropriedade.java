package main;

import business.CadastroPropriedade;
import business.HistoryQuery;
import business.Reserva;
import business.CadastroGerente;
import classesBasicas.Propriedade;
import classesBasicas.Gerente;
import classesBasicas.Registro;
import classesBasicas.User;
import dados.IRepositorio;
import dados.RepositorioPropriedadeSet;
import dados.RepositorioRegistroSet;
import dados.RepositorioReservaSet;
import dados.RepositorioGerenteSet;
import exceptions.EmptyArchiveException;
import exceptions.GerenteAlreadyExistsException;
import exceptions.ObjectOutsideArrayException;
import exceptions.PaymentNotCompletedException;
import exceptions.PropriedadeAlreadyExistsException;
import exceptions.UnregisteredGerenteException;
import exceptions.UnregisteredPropriedadeException;
import exceptions.WeekAlreadyReservedException;
import exceptions.WeekNotAvailableException;
import business.AvailabilityReport;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Map;


public class TestCadastroPropriedade {

	public static void main(String[] args) {
		
		  // Criar um repositório simples em memória (você pode usar um repositório real depois)
        IRepositorio repositorioProp = new RepositorioPropriedadeSet("arquivo_propriedade.dat");  // Supondo que já tenha esse repositório
        IRepositorio repositorioGer = new RepositorioGerenteSet("arquivo_gerente.dat");
        IRepositorio repositorioRegi = new RepositorioRegistroSet("arquivo_registro.dat");
        IRepositorio repositorioReserva = new RepositorioReservaSet("arquivo_reserva.dat");
        CadastroPropriedade cadastroPropriedade = new CadastroPropriedade(repositorioProp,repositorioGer,repositorioRegi );
        CadastroGerente cadastroGerente = new CadastroGerente(repositorioGer); 
        RepositorioReservaSet repositorioReservaSet = (RepositorioReservaSet) repositorioReserva; 

        LocalDate date = LocalDate.now(); 
        // Criar um gerente
        Propriedade propriedade = new Propriedade("Praia","bonita","Rural",100,20, date); 
        Propriedade propriedade2 = new Propriedade("Praia","bonita","Rural",100,20, date); 
        Propriedade propriedade3 = new Propriedade("Praia","bonita","Rural",100,20, date);
        Gerente gerente = new Gerente("123","joshua","321");
        
      //cadastramento do gerente
       try {
		cadastroGerente.cadastrar(gerente); 
		System.out.println("Gerente registrado com sucesso"); 
       } catch (ClassNotFoundException | IOException | EmptyArchiveException e) {
    	   System.out.println("Problema de arquivamento");
			e.printStackTrace();
       } catch (GerenteAlreadyExistsException e) {
    	   System.out.println("Gerente já está registrado"); 
       }
       
       //teste existe
       try {
    	   cadastroPropriedade.existe(propriedade);
       }catch(ClassNotFoundException| IOException| EmptyArchiveException e) {
    	   System.out.println("Problema de arquivamento");
    	   e.printStackTrace();
       }
       
       //cadastramento de propriedade 
       try {
    	   cadastroPropriedade.cadastrar(gerente.getIdGerente(), propriedade);
    	 //  cadastroPropriedade.cadastrar(gerente.getIdGerente(), propriedade2);
    	  // cadastroPropriedade.cadastrar(gerente.getIdGerente(), propriedade3);
       }catch (ClassNotFoundException| IOException | EmptyArchiveException e){
    	   System.out.println("Problema de arquivamento");
    	   e.printStackTrace();
       }catch(UnregisteredGerenteException e){
    	   System.out.println("Gerente não regsitrado (problema de arquivamento)"); 
       }catch(PropriedadeAlreadyExistsException e) {
    	   System.out.println("Propriedade já registrada "); 
       }
       
       propriedade.setCapacidade(500);
       //teste atualização
       try {
    	   cadastroPropriedade.atualizar(gerente.getIdGerente(), propriedade);
       }catch(UnregisteredGerenteException| UnregisteredPropriedadeException | ObjectOutsideArrayException| ClassNotFoundException| IOException| EmptyArchiveException e) {
    	   System.out.println("Problema de arquivamento");
    	   e.printStackTrace();
       }
       

       try {
		repositorioProp.listar();
	} catch (ClassNotFoundException | IOException | EmptyArchiveException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
       //teste do descadastramento 
       try {
    	   cadastroPropriedade.descadastrar(gerente.getIdGerente(), propriedade.getIdPropriedade());//dado que ao descadastrar uma propriedade também se descadatram todos os seus regisro
    	   System.out.println("Propriedade removida do array");                                     //quando se descadastra uma propriedade corretamente, assim também se faz com seus registros
    	                                                                                            //com efeito, não é necessário um teste específico 
       }catch(ObjectOutsideArrayException | ClassNotFoundException| IOException| EmptyArchiveException | UnregisteredGerenteException |  UnregisteredPropriedadeException e) {
    	   System.out.println("Problema de arquivamento"); 
    	   e.printStackTrace();
       }
       
       try {
		repositorioProp.listar();
	} catch (ClassNotFoundException | IOException | EmptyArchiveException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
       
       try {
    	   repositorioRegi.listar(); //prova de que o método remover funciona para os registros
    	   System.out.println("\nListagem dos registros feita"); 
    	   System.out.println("\n\n------Teste AvailabilityReport------\n\n"); 
       }catch(ClassNotFoundException| IOException| EmptyArchiveException e) {
    	  
    	   e.printStackTrace();
       }
       
       Registro[] regProp2 = propriedade2.getRegistros();
       User demanda = new User("963", "romeu", "741");
       
       for(Registro r : regProp2) {
    	   r.setForSale(true);
    	   r.setAvailabe(true);
    	   r.setUser(demanda);
    	   
    	   if(r.getFraction() == 3) {
    		   try {
				Reserva re = new Reserva(r,demanda, 2025);
				repositorioReserva.adicionar(re);//reserva da fração 3 do ano de 2025 da intância propriedade2 
			} catch (WeekAlreadyReservedException | PaymentNotCompletedException | WeekNotAvailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
    	   }
       }
       
       //Teste AvailabilityReport
       AvailabilityReport ar = new AvailabilityReport((RepositorioReservaSet)repositorioReserva); 
       
       // ar.occupiedDates(propriedade, 2025);
       HashSet<Registro> available=(HashSet<Registro>) ar.selling(propriedade2);
       HashSet<Registro> availableReserve=(HashSet<Registro>) ar.availableForReserve(propriedade2);
       
        for(Registro r : available) { 
        	System.out.println(r + "  " +"Disponibilidade de compra");
        }
        System.out.println("\n------Teste Reserva------\n"); 
        for(Registro r : availableReserve) { 
        	System.out.println(r + "  " +"Disponibilidade de reserva");
        }
        
        
        
        HashSet<Map<LocalDate,LocalDate>> datasOcupadas = (HashSet<Map<LocalDate,LocalDate>>)ar.occupiedDates(propriedade2);
        System.out.println("\n------Teste datas ocupadas------\n"); 
        for(Map<LocalDate,LocalDate> m : datasOcupadas) {
        	System.out.println(m); 
        }
        
        
        //teste HistoryQuery
        System.out.println("\n\n-----Teste HistoryQuery------\n\n");
        HistoryQuery hq = new HistoryQuery(repositorioReservaSet); 
        HashSet<User> teste = (HashSet<User>) hq.consultaPropriedade(propriedade2); //a funcionalidade desde método implica na funcionalidade do outro método da classe
        for(User u :teste) {
        	System.out.println(u); 
        }
		
     /*   Registro[] registros =propriedade.getRegistros(); //teste da alocação dos registros dentro do array interno de propriedade 	
        for(Registro registro: registros) {
        	String a = registro.toString();
        	System.out.println(a); 
        }
       */
	}

}
