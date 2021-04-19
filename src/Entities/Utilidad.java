package Entities;

public class Utilidad {
    
    private int id;
    private float egresoTotal;
    private float ingresoTotal;
    private int margen;
    private float monto;
    private int semana;
    private float totalVenta;
    private float totalIngresoClas;
    private int numMes;
   
    public Utilidad() {}

    public Utilidad(int id, float egresoTotal, float ingresoTotal, int margen, float monto, int semana, float totalVenta, float totalIngresoClas) {
        this.id = id;
        this.egresoTotal = egresoTotal;
        this.ingresoTotal = ingresoTotal;
        this.margen = margen;
        this.monto = monto;
        this.semana = semana;
        this.totalVenta = totalVenta;
        this.totalIngresoClas = totalIngresoClas;
    }

    public Utilidad(float egresoTotal, float ingresoTotal, int margen, float monto, int semana, float totalVenta, float totalIngresoClas, int numMes) {
        this.egresoTotal = egresoTotal;
        this.ingresoTotal = ingresoTotal;
        this.margen = margen;
        this.monto = monto;
        this.semana = semana;
        this.totalVenta = totalVenta;
        this.totalIngresoClas = totalIngresoClas;
        this.numMes = numMes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(float totalVenta) {
        this.totalVenta = totalVenta;
    }

    public float getTotalIngresoClas() {
        return totalIngresoClas;
    }

    public void setTotalIngresoClas(float totalIngresoClas) {
        this.totalIngresoClas = totalIngresoClas;
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
                ", totalVenta=" + totalVenta +
                ", totalIngresoClas=" + totalIngresoClas +
                '}';
    }
}
