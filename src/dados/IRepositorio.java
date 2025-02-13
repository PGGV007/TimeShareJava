package dados;
import exceptions.ObjectOutsideArrayException; 

public interface IRepositorio {
	
	public void atualizar (Object obj) throws ObjectOutsideArrayException ; //Atualiza o objeto em questão por sua versão mais nova
	
	public void retirar(Object obj) throws ObjectOutsideArrayException; //Retira o Objeto em questão 
	
	public void listar(); //lista todos os objetos que estão dentro do repositório 
	
	public void adicionar(Object obj ); //adiciona ao repositorio um objeto 
	
	public Object procurar(String id) throws ObjectOutsideArrayException ; //procura um objeto a partir de sua ID 
	
	public boolean existe(String id); //verifica a existência de um objeto a partir de sua ID 
	
}
