import java.awt.*;

public class Saab95 extends Bil {

    private boolean turboOn = false;

    private Saab95() {
        super(2, 125, Color.red, "Saab95");
    }

    private void setTurboOn(){
        turboOn = true;
    }

    private void setTurboOff(){
        turboOn = false;
    }

    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

    public static void main(String[] args) {
        Saab95 car = new Saab95();
        System.out.println("Dörrar: " + car.getNrDoors());
        System.out.println("Motor: " + car.getEnginePower());
        System.out.println("Current Speed: " + car.getCurrentSpeed());
        car.startEngine();
        car.incrementSpeed(140);
        System.out.println("Current Speed: " + car.getCurrentSpeed());
    }
}
