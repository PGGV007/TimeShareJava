package dados;

public abstract class RepositorioGenerico implements IRepositorio {
	
	private int freeSpace = 0; 
	private Object[] objeto;  	
	private int tam; 
	
	public RepositorioGenerico(int num) {
		this.tam = num ; 
		this.objeto = new Object[tam]; 
	}
	
	

	@Override 
	public void atualizar(Object obj) {
		

	}

	@Override
	public void retirar(Object obj) {
		

	}

	@Override
	public void listar() {
		

	}

	@Override
	public void adicionar(Object obj) {
		

	}

	@Override
	public Object procurar(String id) {
		
		return null;
	}

}
