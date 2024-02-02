package exercises;

/**
 * Classes calculating distance and eye radius, positions for storms via inheritance.
 *
 * @author vjafarov
 */
public class Storm {
    protected double eyeRadius;
    protected double eyePositionX;
    protected double eyePositionY;

    /**
     * Calculates if storm is visible with eyes.
     *
     * @param positionX
     * @param positionY
     * @return boolean
     */
    public boolean isInEyeOfTheStorm(double positionX, double positionY) {
        double distance = Math.sqrt(Math.pow(positionX - eyePositionX, 2) +
                Math.pow(positionY - eyePositionY, 2));
        return distance < eyeRadius;
    }

    public double getEyeRadius() {
        return eyeRadius;
    }

    public double getEyePositionX() {
        return eyePositionX;
    }

    public double getEyePositionY() {
        return eyePositionY;
    }

    public void setStorm(double eyeRadius, double eyePositionX, double eyePositionY) {
        this.eyeRadius = eyeRadius;
        this.eyePositionX = eyePositionX;
        this.eyePositionY = eyePositionY;
    }
}

class RainStorm extends Storm {

    public RainStorm(double eyeRadius, double eyePositionX, double eyePositionY) {
        this.setStorm(eyeRadius, eyePositionX, eyePositionY);
    }

    public double amountOfRain() {
        return eyeRadius * 20;
    }
}

class SnowStorm extends Storm {
    private double amountOfSnow;

    public SnowStorm(double eyeRadius, double eyePositionX, double eyePositionY, double amountOfSnow) {
        this.setStorm(eyeRadius, eyePositionX, eyePositionY);
        this.amountOfSnow = amountOfSnow;
    }

    public double getAmountOfSnow() {
        return amountOfSnow;
    }
}