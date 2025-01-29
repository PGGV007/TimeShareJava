package dados;

public interface IRepositorio {
	
	public void atualizar(Object obj);
	
	public void retirar(Object obj);
	
	public void listar(); 
	
	public void adicionar(Object obj );
	
	public Object procurar(String id); 
	
}
