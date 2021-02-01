package com.pvt.helloworld;

public class IntegerCalculator {
    private Integer a;

    public IntegerCalculator(Integer a) {
        this.a = a;
    }

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    public int add(int b) {
        return a + b;
    }

    public int strangeMethod(Integer c) throws BadAException {
//        if (c > 700)
//            return -1;
        if (a < 0 || a > 900)
            throw new BadAException();
        if (a < 5 || a > 895)
            return -1;
//        if (c > 895 || c < 5)
//            return -1;
        if (c == -40)
            return c + a;
        if (a > 90 && c < 90) {
            if (a < 120)
                return a + c;
            return a - c;
        }

//        if (c > 900 || c < 0)
//            throw new BadAException();


        if (c > 250 && a > 250)
            return c / a;
        return Math.abs(c * a);
    }
}
