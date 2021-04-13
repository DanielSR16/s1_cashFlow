package Entities;


import java.sql.Date;

public class FlujoEfectivo {
    
    private int id;
    private float monto;
    private String descripcion;
    private Date fecha;
    private String Categoria;
    private String subCategoria;
    
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
}
