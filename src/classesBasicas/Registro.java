package classesBasicas;

public class Registro {
	
	
      private byte fraction;
      private String idRegistro;
      private Propriedade propriedade; 
      private User owner; 
      private boolean reservado; 


        Registro(byte fraction, String idRegistro, Propriedade propriedade, User owner){
            this.fraction = fraction;
            this.idRegistro = idRegistro;
            this.propriedade = propriedade; 
            this.owner = owner; 
            this.reservado = false; 
        }
        
        

    public boolean getReservado() {
    	return this.reservado;
    }
    
    public void setReservado(boolean reservado) {
    	this.reservado = reservado; 
    }
    
    public byte getFraction() {
        return fraction;
    }
    
    public void setFraction(byte fraction) {
        this.fraction = fraction;
    }

    public String getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(String idRegistro) {
        this.idRegistro = idRegistro;
    }
    
    public Propriedade getPropriedade() {
    	return this.propriedade; 
    }
    
    public void setPropriedade(Propriedade propriedade) {
    	this.propriedade = propriedade; 
    }
    
    public User getOwner() {
    	return this.owner; 
    }
    
    public void setUser(User owner) {
    	this.owner = owner; 
    }
    
  
    
}
