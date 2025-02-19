package classesBasicas;

import java.util.Objects; 


public class User extends Pessoa{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 31606448599822120L;
	private final String idUser;
    private final String senha; 
    

    public User(String cpf, String nome, String senha) {
        super(cpf, nome);
        this.idUser = GeradorId.geradorHexId(6);
        this.senha = senha;
     }

    public String getIdUser() {
        return idUser;
    }
    
    public String getSenha() {
		return senha;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getIdUser(), user.getIdUser());
    }

	
    

}
