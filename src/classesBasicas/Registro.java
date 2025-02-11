package classesBasicas;

public class Registro {
	
	
      private byte numShares;
      private String idRegistro;
      private Propriedade propriedade; 
      private User user; 


        Registro(byte numShares, String idRegistro, Propriedade propriedade, User user){
            this.numShares = numShares;
            this.idRegistro = idRegistro;
            this.propriedade = propriedade; 
            this.user = user; 
        }
        
        

    public byte getNumShares() {
        return numShares;
    }
    
    public void setNumShares(byte numShares) {
        this.numShares = numShares;
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
