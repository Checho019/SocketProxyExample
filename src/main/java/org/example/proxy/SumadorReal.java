package org.example.proxy;

import java.util.List;

public class SumadorReal implements Sumador{
    @Override
    public int sumar(List<Integer> sumandos) {
        int resultado = 0;
        for (int sumando: sumandos){
            resultado += sumando;
        }
        return resultado;
    }

}
