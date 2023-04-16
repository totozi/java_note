package spring.di;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.function.Predicate;

class Car{}
class SportsCar extends  Car {}
class Truck extends Car{}
class Engine {
    @Override
    public String toString(){
        return this.getClass().toString();
    }
}

public class Main1 {
    public static void main(String[] args) throws Exception {
//        Car car = new SportsCar();
        Car car = getCar();
        System.out.println("car = " + car);

        Engine engine = (Engine) getObject("engine");
        System.out.println("engine = " + engine.toString());
    }

    static Car getCar() throws Exception {
        Properties p = new Properties();
        p.load(new FileReader("configDi.txt"));

        Class clazz = Class.forName(p.getProperty("car"));

        return (Car)clazz.newInstance();

    }

    // 위 메소드보다 더 general
    static Object getObject(String key) throws Exception {
        Properties p = new Properties();
        p.load(new FileReader("configDi.txt"));

        Class clazz = Class.forName(p.getProperty(key));

        return clazz.newInstance();



    }
}
