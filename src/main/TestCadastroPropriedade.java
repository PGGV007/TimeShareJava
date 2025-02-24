package main;

import business.CadastroPropriedade;
import business.CadastroGerente;
import classesBasicas.Propriedade;
import classesBasicas.Gerente;
import classesBasicas.Registro;
import dados.IRepositorio;
import dados.RepositorioPropriedadeSet;
import dados.RepositorioRegistroSet;
import dados.RepositorioGerenteSet;
import exceptions.EmptyArchiveException;
import exceptions.GerenteAlreadyExistsException;
import exceptions.ObjectOutsideArrayException;
import exceptions.PropriedadeAlreadyExistsException;
import exceptions.UnregisteredGerenteException;
import exceptions.UnregisteredPropriedadeException;

import java.io.IOException;
import java.time.LocalDate; 

public class TestCadastroPropriedade {

	public static void main(String[] args) {
		
		  // Criar um repositório simples em memória (você pode usar um repositório real depois)
        IRepositorio repositorioProp = new RepositorioPropriedadeSet("arquivo_propriedade.dat");  // Supondo que já tenha esse repositório
        IRepositorio repositorioGer = new RepositorioGerenteSet("arquivo_gerente.dat");
        IRepositorio repositorioRegi = new RepositorioRegistroSet("arquivo_registro.dat");
        CadastroPropriedade cadastroPropriedade = new CadastroPropriedade(repositorioProp,repositorioGer,repositorioRegi );
        CadastroGerente cadastroGerente = new CadastroGerente(repositorioGer); 

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
    	   cadastroPropriedade.atualizar(gerente.getIdGerente(), propriedade.getIdPropriedade());
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
       
		
     /*   Registro[] registros =propriedade.getRegistros(); //teste da alocação dos registros dentro do array interno de propriedade 	
        for(Registro registro: registros) {
        	String a = registro.toString();
        	System.out.println(a); 
        }
       */
	}

}
