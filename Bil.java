import java.awt.*;

public class Bil implements Movable {
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private double xPosition, yPosition = 0;
    private String direction = new String("right");

    public Bil(int nrDoors, double enginePower, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        stopEngine();
    }

    public int getNrDoors(){
        return nrDoors;
    }

    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

    public double speedFactor(){
        return enginePower * 0.01;
    }

    public void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }

    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }

    public void move(){
        // Switch?
        if (direction.equals("right")) {
            xPosition += getCurrentSpeed();
        }
        else if (direction.equals("left")) {
            xPosition -= getCurrentSpeed();
        }
        else if (direction.equals("up")) {
            yPosition += getCurrentSpeed();
        }
        else if (direction.equals("down")) {
            yPosition -= getCurrentSpeed();
        }
    }

    public void turnLeft(){
        if (direction.equals("right")) {
            direction = "up";
        }
        else if (direction.equals("left")) {
            direction = "down";
        }
        else if (direction.equals("up")) {
            direction = "left";
        }
        else if (direction.equals("down")) {
            direction = "right";
        }
    }

    public void turnRight(){
        if (direction.equals("right")) {
            direction = "down";
        }
        else if (direction.equals("left")) {
            direction = "up";
        }
        else if (direction.equals("up")) {
            direction = "right";
        }
        else if (direction.equals("down")) {
            direction = "left";
        }
    }


    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }
}
