package main; 

import java.io.IOException;

import business.CadastroGerente;
import classesBasicas.Gerente;
import exceptions.EmptyArchiveException;
import exceptions.GerenteAlreadyExistsException;
import exceptions.ObjectOutsideArrayException;
import exceptions.UnregisteredGerenteException;
import dados.IRepositorio;
import dados.RepositorioGerenteSet;

public class TestCadastroGerente {

    public static void main(String[] args) throws ClassNotFoundException, IOException {
      
        IRepositorio repositorio = new RepositorioGerenteSet("arquivo_gerente.dat");  
        CadastroGerente cadastroGerente = new CadastroGerente(repositorio);
        
       
        Gerente gerente = new Gerente("123","joshua","321");

        try {
            
            
			
        	cadastroGerente.cadastrar(gerente);
				
			
            System.out.println("Gerente cadastrado com sucesso!");
            System.out.println("Deu bom");
           
            //cadastroGerente.cadastrar(gerente);  
        } catch (GerenteAlreadyExistsException e) {
        	System.out.println("Rodou Catch"); 
            System.out.println("Erro: Gerente já existe!");
        } catch (IllegalArgumentException e) {
        	System.out.println("Rodou Catch"); 
            System.out.println("Erro: Gerente inválido!");
        } catch (EmptyArchiveException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
       }
        gerente.setNome("Mark");
        
        try {
        	cadastroGerente.atualizar(gerente);
        }catch(ObjectOutsideArrayException| UnregisteredGerenteException| ClassNotFoundException| IOException| EmptyArchiveException e) {
        	System.out.println("Problema de arquivamento");
        	e.printStackTrace();
        }
        
        try {
			repositorio.listar();
		} catch (ClassNotFoundException | IOException | EmptyArchiveException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        try {
        	cadastroGerente.descadastrar(gerente.getIdGerente());
        	System.out.println("Gerente removido com sucesso");
        }catch(ObjectOutsideArrayException| UnregisteredGerenteException| ClassNotFoundException| IOException| EmptyArchiveException e){
        	System.out.println("Problema de arquivamento");
        	e.printStackTrace();
        }
        
        try {
			repositorio.listar();
		} catch (ClassNotFoundException | IOException | EmptyArchiveException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        
    }
}
