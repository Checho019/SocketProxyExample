package org.example.proxy;

import java.util.List;

public class SumadorProxy implements Sumador{
    private SumadorReal sumadorReal;
    @Override
    public int sumar(List<Integer> sumandos) {
        if (sumadorReal == null){
            sumadorReal = new SumadorReal();
        }
        return sumadorReal.sumar(sumandos);
    }
}
