package Project;

public class Registro {
        private byte numShares;
        private int periodoAno;
        private String idRegistro;


        Registro(byte numShares, int periodoAno, String idRegistro){
            this.numShares = numShares;
            this.periodoAno = periodoAno;
            this.idRegistro = idRegistro;
        }

    public byte getNumShares() {
        return numShares;
    }
    public int getPeriodoAno() {
        return periodoAno;
    }

    public String getIdRegistro() {
        return idRegistro;
    }

    public void setNumShares(byte numShares) {
        this.numShares = numShares;
    }
    public void setPeriodoAno(int periodoAno) {
        this.periodoAno = periodoAno;
    }
    public void setIdRegistro(String idRegistro) {
        this.idRegistro = idRegistro;
    }
}
