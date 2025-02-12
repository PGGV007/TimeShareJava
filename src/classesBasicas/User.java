package classesBasicas;

import java.util.Objects;

public class User extends Pessoa{
    private final String idUser;
    
    private Registro ownedRegistros;

     User(String cpf, String nome, Registro ownedRegistros) {
        super(cpf, nome);
        this.idUser = GeradorId.geradorHexId(16);
        this.ownedRegistros = ownedRegistros;
     }

    public String getIdUser() {
        return idUser;
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
