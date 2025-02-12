package classesBasicas;

import java.util.Objects; 


public class User extends Pessoa{
	
    private final String idUser;
    

     User(String cpf, String nome) {
        super(cpf, nome);
        this.idUser = GeradorId.geradorHexId(16);
     }

    public String getIdUser() {
        return idUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getIdUser(), user.getIdUser());
    }
    

}
