package classesBasicas;

public class Registro {
	
	
      private byte fraction;
      private String idRegistro;
      private Propriedade propriedade; 
      private User user; 


        Registro(byte fraction, String idRegistro, Propriedade propriedade, User user){
            this.fraction = fraction;
            this.idRegistro = idRegistro;
            this.propriedade = propriedade; 
            this.user = user; 
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
    
    public User getUser() {
    	return this.user; 
    }
    
    public void setUser(User user) {
    	this.user = user; 
    }
    
  
    
}
