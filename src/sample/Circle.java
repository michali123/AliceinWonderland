package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.ArcType;

public class Circle extends MyShape {
    private double radius;
    private double angle_starting_position;
    private double angle_ending_position;

    public Circle(MyPoint point, MyColor color, double radius, double angle_starting_position, double angle_ending_position) {
        super(point, color);
        this.radius = radius;
        this.angle_starting_position = angle_starting_position;
        this.angle_ending_position = angle_ending_position;
    }

    public double getAngle_starting_position() {
        return angle_starting_position;
    }

    public void setAngle_starting_position(double angle_starting_position) {
        this.angle_starting_position = angle_starting_position;
    }

    public double getAngle_ending_position() {
        return angle_ending_position;
    }

    public void setAngle_ending_position(double angle_ending_position) {
        this.angle_ending_position = angle_ending_position;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }

    public void draw (GraphicsContext gc){
        double centerX = getPoint().getX();
        double centerY = getPoint().getY();
        gc.fillArc(centerX-radius,centerY-radius, 200,200,getAngle_starting_position(),getAngle_ending_position(),
                ArcType.ROUND);

    }
}
