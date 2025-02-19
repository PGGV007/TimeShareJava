package classesBasicas;

import java.io.Serializable;

public class Registro implements Serializable {
	
	
      private byte fraction; //semana correspondente 
      private final String idRegistro; //id pelo qual o registro deve ser identificado (uma vez estabelecido, assim ficará)
      private Propriedade propriedade; //propriedade vinculada 
      private User owner; //proprietário do registro 
      private boolean reservado; //indicativo se está reservado ou não
      private boolean availabe; //prorprietário indica se está disponível ou não para ser reservado 
      private boolean forSale; //proprietário do registro deve ser capaz de pôr à disposição
      private double priceReserva; // preço da reserva  


       public  Registro(byte fraction, Propriedade propriedade, User owner){
            this.fraction = fraction;
            this.idRegistro = GeradorId.geradorHexId(16); ;
            this.propriedade = propriedade; 
            this.owner = owner; 
            this.reservado = false; 
            this.forSale = false; 
            }
        
       public Registro(byte fraction, Propriedade propriedade){
            this.fraction = fraction;
            this.idRegistro = GeradorId.geradorHexId(16); ;
            this.propriedade = propriedade; 
            this.owner = null; 
            this.reservado = false; 
            this.forSale = false; 
            this.priceReserva = propriedade.getPrice();
            }
        
        
        

    public boolean getForSale() {
    	return this.forSale; 
    }
    
    public void setForSale(boolean a) {
    	this.forSale = a; 
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
    
    public void setPriceReserva(double price) {
    	this.priceReserva = price; 
    }
    
    public double getPriceReserva() {
    	return this.priceReserva; 
    }

	public boolean getAvailabe() {
		return availabe;
	}

	public void setAvailabe(boolean availabe) {
		this.availabe = availabe;
	}
    
	
	@Override
	public String toString() {
		return  ((Byte)this.fraction).toString() +"  " +idRegistro;  
	}
  
    
}
