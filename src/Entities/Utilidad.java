package Entities;

public class Utilidad {
    
    private int id;
    private float egresoTotal;
    private float ingresoTotal;
    private int margen;
    private float monto;
    private int semana;
    private float efectivo;
    private float depocito;
    private float gastoAOC;
    private float costoVenta;
    private int numMes;
   
    public Utilidad() {}

    public Utilidad(float egresoTotal, float ingresoTotal, int margen, float monto, int semana, float efectivo, float depocito, float gastoAOC, float costoVenta, int numMes) {
        this.egresoTotal = egresoTotal;
        this.ingresoTotal = ingresoTotal;
        this.margen = margen;
        this.monto = monto;
        this.semana = semana;
        this.efectivo = efectivo;
        this.depocito = depocito;
        this.gastoAOC = gastoAOC;
        this.costoVenta = costoVenta;
        this.numMes = numMes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public float getEfectivo() {
        return efectivo;
    }

    public void setEfectivo(float efectivo) {
        this.efectivo = efectivo;
    }

    public float getDepocito() {
        return depocito;
    }

    public void setDepocito(float depocito) {
        this.depocito = depocito;
    }

    public float getGastoAOC() {
        return gastoAOC;
    }

    public void setGastoAOC(float gastoAOC) {
        this.gastoAOC = gastoAOC;
    }

    public float getCostoVenta() {
        return costoVenta;
    }

    public void setCostoVenta(float costoVenta) {
        this.costoVenta = costoVenta;
    }

    public float getEgresoTotal() {return egresoTotal;}

    public void setEgresoTotal(float egresoTotal) {this.egresoTotal = egresoTotal;}
 
    public float getIngresoTotal() {return ingresoTotal;}
  
    public void setIngresoTotal(float ingresoTotal) {this.ingresoTotal = ingresoTotal;}
 
    public int getMargen() {return margen;}

    public void setMargen(int margen) {this.margen = margen;}
  
    public float getMonto() {return monto;}

    public void setMonto(float monto) {this.monto = monto;}

    public int getSemana() {return semana;}
 
    public void setSemana(int semana) {this.semana = semana;}

    public int getNumMes() {
        return numMes;
    }

    public void setNumMes(int numMes) {
        this.numMes = numMes;
    }

    @Override
    public String toString() {
        return "Utilidad{" +
                "egresoTotal=" + egresoTotal +
                ", ingresoTotal=" + ingresoTotal +
                ", margen=" + margen +
                ", monto=" + monto +
                ", semana=" + semana +

                '}';
    }
}
