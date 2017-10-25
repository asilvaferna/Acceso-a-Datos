/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializacion1;



/**
 *
 * @author oracle
 */
public class MClase implements java.io.Serializable {
    
    private String name;
    private transient int number1;
    private double number2;

    public MClase() {
    }

    public MClase(String name, int number1, double number2) {
        this.name = name;
        this.number1 = number1;
        this.number2 = number2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber1() {
        return number1;
    }

    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public double getNumber2() {
        return number2;
    }

    public void setNumber2(double number2) {
        this.number2 = number2;
    }

    @Override
    public String toString() {
        return "MClase{" + "name=" + name + ", number1=" + number1 + ", number2=" + number2 + '}';
    }
    
    
    
}
