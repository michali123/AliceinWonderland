package sample;

import javafx.scene.canvas.GraphicsContext;

public abstract class MyShape {
    private MyPoint point;
    private MyColor color;

    public MyShape(MyPoint point, MyColor color) {
        this.point = point;
        this.color = color;
    }

    public MyPoint getPoint() {
        return point;
    }

    public void setPoint(MyPoint point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "MyShape{" +
                "point=" + point +
                '}';
    }

    public void draw (GraphicsContext gc){

    };

}
