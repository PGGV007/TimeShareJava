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
import exceptions.GerenteAlreadyExistsException;
import exceptions.PropriedadeAlreadyExistsException;
import exceptions.UnregisteredGerenteException;

import java.time.LocalDate; 

public class TestCadastroPropriedade {

	public static void main(String[] args) {
		
		  // Criar um repositório simples em memória (você pode usar um repositório real depois)
        IRepositorio repositorioProp = new RepositorioPropriedadeSet();  // Supondo que já tenha esse repositório
        IRepositorio repositorioGer = new RepositorioGerenteSet();
        IRepositorio repositorioRegi = new RepositorioRegistroSet();
        CadastroPropriedade cadastroPropriedade = new CadastroPropriedade(repositorioProp,repositorioGer,repositorioRegi );
        CadastroGerente cadastroGerente = new CadastroGerente(repositorioGer); 

        LocalDate date = LocalDate.now(); 
        // Criar um gerente
        Propriedade propriedade = new Propriedade("Praia","bonita","Rural",100,20, date); 
        Gerente gerente = new Gerente("123","joshua");
        

        try {
        	cadastroGerente.cadastrar(gerente); 
            // Testar cadastro do gerente
            cadastroPropriedade.cadastrar(gerente.getIdGerente(),propriedade);
            System.out.println("Propriedade cadastrada com sucesso!");

        } catch (PropriedadeAlreadyExistsException e) {
        	System.out.println("Rodou Catch"); 
            System.out.println("Erro: Gerente já existe!");
        } catch (IllegalArgumentException e) {
        	System.out.println("Rodou Catch"); 
            System.out.println("Erro: Gerente inválido!");
        } catch (GerenteAlreadyExistsException e) {
			e.printStackTrace();
		} catch (UnregisteredGerenteException e) {
			e.printStackTrace();
		}
        
        Registro[] registros =propriedade.getRegistros();
		
        for(Registro registro: registros) {
        	String a = registro.toString();
        	System.out.println(a); 
        }
        
	}

}
