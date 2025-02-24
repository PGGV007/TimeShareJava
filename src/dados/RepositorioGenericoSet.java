package dados;

import java.util.HashSet;
import java.util.Set; 
import java.io.*;

import exceptions.ObjectOutsideArrayException;
import exceptions.EmptyArchiveException;
public abstract class RepositorioGenericoSet implements IRepositorio, Serializable  {
	
	
	
	
	private final String arquivo;
	private static final long serialVersionUID = 8270543749004816682L;
	protected Set<Object> repositorio = new HashSet<>(); 
	
	public RepositorioGenericoSet(String arquivo) {
		this.arquivo = arquivo;
		
	}

	@Override
	public void atualizar(Object obj) 	throws ObjectOutsideArrayException, IOException {
		
	
			System.out.println(repositorio.remove(obj));
			System.out.println(repositorio.add(obj));
			 
			salvarDados(repositorio,getArquivo()); 
		
	}
	
	@Override
	public void retirar(Object obj) throws ObjectOutsideArrayException, IOException {

		if(repositorio.contains(obj)) {
			repositorio.remove(obj); 
			salvarDados(repositorio,getArquivo()); 
		}else {
			throw new ObjectOutsideArrayException(); 
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void listar() throws ClassNotFoundException, IOException, EmptyArchiveException {
		Set<Object> clone  = (Set<Object>) carregarDados(getArquivo());
		for(Object obj : clone) {
			System.out.println(obj); 
		}

	}

	@Override
	public void adicionar(Object obj) throws IOException {
		
		repositorio.add(obj);
		salvarDados(repositorio,getArquivo()); 
		
		

	}

	@Override
	public Object procurar(String id) throws ObjectOutsideArrayException, ClassNotFoundException, IOException, EmptyArchiveException {
		
		//terá que ser feito em específico para todas as classe que lidaremos 
		
		return null;
	}

	@Override
	public boolean existe(String id) throws ClassNotFoundException, IOException, EmptyArchiveException {
		
		//terá que ser feito em específico para todas as classe que lidaremos 
		
		return false;
	}
	
    protected void salvarDados(Object objeto, String arquivo) throws IOException {
    	  File file = new File(arquivo);

    	    // Verifica se o arquivo existe; se não, cria um novo
    	    if (!file.exists()) {
    	        file.createNewFile();
    	    }

    	    // Escreve o objeto no arquivo
    	    try (FileOutputStream fileOut = new FileOutputStream(file);
    	         ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
    	        objectOut.writeObject(objeto);
    	    }
    }

    protected Object carregarDados(String arquivo) throws IOException, ClassNotFoundException, EmptyArchiveException {
    	File file = new File(arquivo);

        
        if (!file.exists()) {
            file.createNewFile();
            
        }

        
        try (FileInputStream fileIn = new FileInputStream(file);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
        	
            return objectIn.readObject();
        } catch (EOFException e) { 
        	
            throw new EmptyArchiveException(); 
        }
    }

	public String getArquivo() {	
		return arquivo;
	}

}
