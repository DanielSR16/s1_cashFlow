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

    public  float calcularIngresoTotal(List<FlujoEfectivo> ingresos){
        float total=0;

        for (int i = 0; i < ingresos.size(); i++) {
            total = ingresos.get(i).getMonto()+total;
        }

        return total;
    }


}
