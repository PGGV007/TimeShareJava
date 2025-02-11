package classesBasicas;

import java.util.Objects;

public class User extends Pessoa{
    private String idUser;
    
    private Registro ownedRegistros;

     User(String cpf, String nome, String idUser, Registro ownedRegistros) {
        super(cpf, nome);
        this.idUser = idUser;
        this.ownedRegistros = ownedRegistros;
     }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public Registro getOwnedRegistros() {
        return ownedRegistros;
    }

    public void setOwnedRegistros(Registro ownedRegistros) {
        this.ownedRegistros = ownedRegistros;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getIdUser(), user.getIdUser()) && Objects.equals(getOwnedRegistros(), user.getOwnedRegistros());
    }

}
