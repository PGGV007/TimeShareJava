package dados;
import java.io.IOException;

import exceptions.EmptyArchiveException;
import exceptions.ObjectOutsideArrayException; 

public interface IRepositorio  {
	
	public void atualizar (Object obj) throws ObjectOutsideArrayException, IOException ; //Atualiza o objeto em questão por sua versão mais nova
	
	public void retirar(Object obj) throws ObjectOutsideArrayException, IOException; //Retira o Objeto em questão 
	
	public void listar() throws ClassNotFoundException, IOException, EmptyArchiveException; //lista todos os objetos que estão dentro do repositório 
	
	public void adicionar(Object obj ) throws IOException; //adiciona ao repositorio um objeto 
	
	public Object procurar(String id) throws ObjectOutsideArrayException, ClassNotFoundException, IOException, EmptyArchiveException ; //procura um objeto a partir de sua ID 
	
	public boolean existe(String id) throws ClassNotFoundException, IOException, EmptyArchiveException; //verifica a existência de um objeto a partir de sua ID 
	
	
	
}
