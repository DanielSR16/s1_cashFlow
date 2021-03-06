package Entities;

public class IndicadoresDinero {

    private int id;
    private int numSemana;
    private float monto;
    private String asunto;
    private int idTipoIndicador;
    private int numMes;
    
    public IndicadoresDinero() {}

    public IndicadoresDinero( int numSemana, float monto, String asunto, int idTipoIndicador,int numMes) {
       
        this.numSemana = numSemana;
        this.monto = monto;
        this.asunto = asunto;
        this.idTipoIndicador = idTipoIndicador;
        this.numMes=numMes;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public int getNumSemana() {return numSemana;}
        
    public void setNumSemana(int numSemana) {this.numSemana = numSemana;}
        
    public float getMonto() {return monto;}
        
    public void setMonto(float monto) {this.monto = monto;}
        
    public String getAsunto() {return asunto;}
        
    public void setAsunto(String asunto) {this.asunto = asunto;}
 
    public int getIdTipoIndicador() {return idTipoIndicador;}

    public void setIdTipoIndicador(int idTipoIndicador) {this.idTipoIndicador = idTipoIndicador;}

    public int getNumMes() {
        return numMes;
    }

    public void setNumMes(int numMes) {
        this.numMes = numMes;
    }
}
