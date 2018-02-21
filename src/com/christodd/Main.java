package com.christodd;
//Car Class
class Car {
    private String name;
    private boolean engine;
    protected boolean isEngineOn;
    private int cylinders;
    private int wheels;
    private int speed;

    public Car(String name, int cylinders) {
        this.name = name;
        this.engine = true;
        this.cylinders = cylinders;
        this.wheels = 4;
        this.isEngineOn = false;
        this.speed = 0;
    }

    public void startEngine() {
        isEngineOn = true;
        System.out.println("Car.startEngine() called: isEngineOn is set to true");
    }

    public void turnOffEngine() {
        isEngineOn = false;
        System.out.println("Car.turnOffEngine() called: isEngineOn is set to false");
    }

    public void accelerate(int speed) {
        if (!isEngineOn) {
            System.out.println("Car.accelerate() called: Cannot accelerate because engine is off");
            return;
        } else {
            this.speed += speed;
            System.out.println("Car.accelerate() called: Current speed of car is " + this.speed);
        }
    }

    public void brake(int speed) {
        if (!isEngineOn) {
            System.out.println("Car.brake() called: Brake applied, however car is off and therefore not in motion");
            return;
        } else {
            if (this.speed - speed < 0) {
                this.speed = 0;
                System.out.println("Car.brake() called: Brake applied bringing the car to a stop");
                return;
            } else {
                this.speed -= speed;
                System.out.println("Car.brake() called: Brake applied bringing the car's speed to " + this.speed);
            }
        }
    }

    public boolean isEngineOn() {
        return isEngineOn;
    }

    public int getSpeed() {
        return speed;
    }
}

//Toyota Camry
class toyotaCamry extends Car {
    public toyotaCamry(int cylinders) {
        super("Toyota Camry", cylinders);
    }

    public void startEngine() {
        isEngineOn = true;
        System.out.println("toyotaCamry.startEngine() called: Vroom Vroom");
    }
}

//Honda Civic
class hondaCivic extends Car {
    public hondaCivic(int cylinders) {
        super("Honda Civic", cylinders);
    }

    public void startEngine() {
        isEngineOn = true;
        System.out.println("hondaCivic.startEngine() called: bahhh bahhh");
    }
}

    public class Main {

    public static void main(String[] args) {
        Car car = new Car("Generic Car",2);
        toyotaCamry camry = new toyotaCamry(6);
        hondaCivic civic = new hondaCivic(4);
        car.startEngine();
        camry.startEngine();
        civic.startEngine();

        for(int i = 0; i < 20; i++) {
            int x = (int) (Math.random() * 6) + 1;
            int y = (int) (Math.random() * 10) + 1;
            switch(x) {
                case 1:
                    car.accelerate(y*3);
                    break;
                case 2:
                    car.brake(y*3);
                    break;
                case 3:
                    camry.accelerate(y*3);
                    break;
                case 4:
                    camry.brake(y*3);
                    break;
                case 5:
                    civic.accelerate(y*3);
                    break;
                case 6:
                    civic.brake(y*3);
                    break;
            }
        }

        System.out.println("Generic Cars speed is:   " + car.getSpeed());
        System.out.println("Toyota Camry's speed is: " + camry.getSpeed());
        System.out.println("Honda Civic's speed is:  " + civic.getSpeed());
    }



}
