package Entities;


import java.sql.Date;

public class FlujoEfectivo {
    
    private int id;
    private float monto;
    private String descripcion;
    private Date fecha;
    private String Categoria;
    private String subCategoria;
    private int idClasificacion;
    private int numSemana;

    public FlujoEfectivo(float monto, int idClasificacion, int numSemana) {
        this.monto = monto;
        this.idClasificacion = idClasificacion;
        this.numSemana = numSemana;
    }

    public FlujoEfectivo() {}

    public FlujoEfectivo(float monto, String descripcion, Date fecha, String categoria, String subCategoria) {
        this.monto = monto;
        this.descripcion = descripcion;
        this.fecha = fecha;
        Categoria = categoria;
        this.subCategoria = subCategoria;
    }

    public int getId() {return id;}
  
    public void setId(int id) {this.id = id;}

    public float getMonto() {return monto;}

    public void setMonto(float monto) {this.monto = monto;}
 
    public Date getFecha() {return fecha;}
        
    public void setFecha(Date fecha) {this.fecha = fecha;}

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public String getSubCategoria() {
        return subCategoria;
    }

    public void setSubCategoria(String subCategoria) {
        this.subCategoria = subCategoria;
    }

    public int getIdClasificacion() {
        return idClasificacion;
    }

    public void setIdClasificacion(int idClasificacion) {
        this.idClasificacion = idClasificacion;
    }

    public int getNumSemana() {
        return numSemana;
    }

    public void setNumSemana(int numSemana) {
        this.numSemana = numSemana;
    }

    @Override
    public String toString() {
        return "FlujoEfectivo{" +
                "monto=" + monto +
                ", idClasificacion=" + idClasificacion +
                ", numSemana=" + numSemana +
                '}';
    }
}
