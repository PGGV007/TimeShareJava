package main; 

import business.CadastroGerente;
import classesBasicas.Gerente;
import exceptions.GerenteAlreadyExistsException;
import dados.IRepositorio;
import dados.RepositorioGerenteSet;

public class TestCadastroGerente {

    public static void main(String[] args) {
        // Criar um repositório simples em memória (você pode usar um repositório real depois)
        IRepositorio repositorio = new RepositorioGerenteSet();  // Supondo que já tenha esse repositório
        CadastroGerente cadastroGerente = new CadastroGerente(repositorio);

        // Criar um gerente
        Gerente gerente = new Gerente("123","joshua");

        try {
            // Testar cadastro do gerente
            cadastroGerente.cadastrar(gerente);
            System.out.println("Gerente cadastrado com sucesso!");

            // Tentar cadastrar o mesmo gerente novamente
            cadastroGerente.cadastrar(gerente);  // Isso deve gerar uma exceção
        } catch (GerenteAlreadyExistsException e) {
        	System.out.println("Rodou Catch"); 
            System.out.println("Erro: Gerente já existe!");
        } catch (IllegalArgumentException e) {
        	System.out.println("Rodou Catch"); 
            System.out.println("Erro: Gerente inválido!");
        }
        
        repositorio.listar();
        
    }
}
