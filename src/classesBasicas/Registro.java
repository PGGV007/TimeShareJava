package classesBasicas;

public class Registro {
	
	
      private byte fraction; //semana correspondente 
      private final String idRegistro; //id pelo qual o registro deve ser identificado (uma vez estabelecido, assim ficará)
      private Propriedade propriedade; //propriedade vinculada 
      private User owner; //proprietário do registro 
      private boolean reservado; //indicativo se está reservado ou não
      private boolean available; //proprietário do registro deve ser capaz de pôr à disposição
      private double price; // preço por share 


        Registro(byte fraction, Propriedade propriedade, User owner){
            this.fraction = fraction;
            this.idRegistro = GeradorId.geradorHexId(16); ;
            this.propriedade = propriedade; 
            this.owner = owner; 
            this.reservado = false; 
            this.available = false; 
            this.price = propriedade.getPrice();
            }
        
        Registro(byte fraction, Propriedade propriedade){
            this.fraction = fraction;
            this.idRegistro = GeradorId.geradorHexId(16); ;
            this.propriedade = propriedade; 
            this.owner = null; 
            this.reservado = false; 
            this.available = false; 
            this.price = propriedade.getPrice();
            }
        
        
        

    public boolean getAvailable() {
    	return this.available; 
    }
    
    public void setAvailable(boolean a) {
    	this.available = a; 
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
