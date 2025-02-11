package dados;
import exceptions.ObjectOutsideArrayException; 
import exceptions.UserAlreadyExists;

public interface IRepositorio {
	
	public void atualizar (Object obj) throws ObjectOutsideArrayException ;
	
	public void retirar(Object obj) throws ObjectOutsideArrayException;
	
	public void listar(); 
	
	public void adicionar(Object obj );
	
	public Object procurar(String id) throws ObjectOutsideArrayException ; 
	
	public boolean existe(String id); 
	
}
