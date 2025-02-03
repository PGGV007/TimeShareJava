package dados;
import exceptions.ObjectOutsideArrayException; 

public abstract class RepositorioGenerico implements IRepositorio {
	
	private int freeSpace = 0; 
	private Object[] objeto;  	
	private int tam; 
	
	public RepositorioGenerico(int num) {
		this.tam = num ; 
		this.objeto = new Object[tam]; 
	}
	
	private int procurarIndice(Object obj) throws ObjectOutsideArrayException {
		boolean teste = false ; 
		for(int i =0; i<freeSpace;i++) {
			
			if(obj.equals(objeto[i])){
				teste = true; 
				return i; 
			}
		}
		if(teste == false) {
			throw new ObjectOutsideArrayException(); 
		}
		return 1; 
	}
	

	@Override 
	public void atualizar(Object obj) throws ObjectOutsideArrayException   {
		int i; 
		i = procurarIndice(obj); 
		this.objeto[i] = obj; 

	}

	@Override
	public void retirar(Object obj) throws ObjectOutsideArrayException {
		int i = procurarIndice(obj); 
		
		for(int j = i; j<freeSpace;j++) {
			objeto[j] = objeto[j+1]; 
		}
		this.freeSpace--; 
	}

	@Override
	public void listar() {
		for(int i = 0; i<freeSpace; i++) {
			System.out.println(objeto[i]); 
		}

	}

	@Override
	public void adicionar(Object obj) {
		this.objeto[freeSpace] = obj; 
		this.freeSpace++; 

	}

	@Override
	public Object procurar(String id) throws ObjectOutsideArrayException {
		
		return null;
	}

}
