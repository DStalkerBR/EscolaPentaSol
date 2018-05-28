
package escolapentasol;

public class Material {
    private int idMaterial;
    private String instrumento;
    private String tipoInstrumento;
    private int qtdInstrumentos;
    
    //Construtor
    public Material(){
        
    }
    
    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    public String getInstrumento() {
        return instrumento;
    }

    public void setInstrumento(String instrumento) {
        this.instrumento = instrumento;
    }

    public String getTipoInstrumento() {
        return tipoInstrumento;
    }

    public void setTipoInstrumento(String tipoInstrumento) {
        this.tipoInstrumento = tipoInstrumento;
    }

    public int getQtdInstrumentos() {
        return qtdInstrumentos;
    }

    public void setQtdInstrumentos(int qtdInstrumentos) {
        this.qtdInstrumentos = qtdInstrumentos;
    }
}
