package Model;

import Entities.FlujoEfectivo;

import java.util.List;

public class Contador {


    public Contador() {
    }


    public  float calcularEgresoTotal(List<FlujoEfectivo> egresos){
            float total=0;

        for (int i = 0; i < egresos.size(); i++) {
            total = egresos.get(i).getMonto()+total;
        }

        return total;
    }

    public float calcularTotalVentas(List<FlujoEfectivo> ventas){
        float total =0;

        for (int i = 0; i < ventas.size(); i++) {
            total = ventas.get(i).getMonto()+total;
        }

        return total;
    }

    public float calcularTotalIngresosClas(List<FlujoEfectivo> ingresos){
        float total =0;

        for (int i = 0; i < ingresos.size(); i++) {
            total = ingresos.get(i).getMonto()+total;
        }

        return total;
    }

    public float calcularGanancia(float egresosTotales,float ingresosTotales){
        return ingresosTotales-egresosTotales;
    }

    public int calcularMargen(float ganancias,float ingresosTotales){

        if(ingresosTotales==0){
            return 0;
        }

        return (int) ((ganancias/ingresosTotales) *100);
    }


}
