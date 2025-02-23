package business;
import java.util.HashSet;
import java.util.Set;
import business.Reserva;
import classesBasicas.Propriedade;
import classesBasicas.Registro;
import classesBasicas.User;
import dados.IRepositorio;

@SuppressWarnings("unused")
public class HistoryQuery {
	
	private IRepositorio repositorio; //repositorio de reservas
	
	public HistoryQuery(IRepositorio repositorio) {
		this.repositorio = repositorio; 
	}
	
	public Set<User> consultaPeriodo(Registro registro){ //método retorna um set de users que em algum momento já reservaram um determiando perído de uma propriedade
		
		@SuppressWarnings("unchecked")
		HashSet<Object> reservas = (HashSet<Object>)repositorio; 
		HashSet<User> users = new HashSet<User>(); 
		
		for(Object obj : reservas) {
			Reserva r = (Reserva) obj;
			if(r.getRegistro().equals(registro)) {
				users.add(r.getRenter()); 
			}
		}
		return users;
	}
	
	public Set<User> consultaPropriedade(Propriedade propriedade){ //usa o método acima para observar todos os usuários que em algum momento usaram uma determinada proprieade
		
		Registro[] registros = propriedade.getRegistros();	
		HashSet<User> usersProp = new HashSet<User>(); 
		for(Registro r : registros) {
			usersProp.addAll(consultaPeriodo(r));
		}
		
		return usersProp; 
	}
	
	
}
