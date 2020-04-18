package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;


public class MyPieChart extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        // setting up the stage
        primaryStage.setTitle("Geometric Configuration");
        Group root = new Group();
        Scene scene = new Scene(root);
        Canvas canvas = new Canvas(800, 400);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        MyPoint center = new MyPoint(canvas.getWidth() / 2, canvas.getHeight() / 2);
        // setting a fixed radius and center of the pie
        double radius = 100;


        Circle slice1 = new Circle(center, MyColor.PURPLE, radius, 0,360*0.7918);
        gc.setFill(MyColor.PURPLE.getColor());
        slice1.draw(gc);

        Circle slice2 = new Circle(center, MyColor.PINK, radius, 360*0.791843, 360*0.6234);
        gc.setFill(MyColor.PINK.getColor());
        slice2.draw(gc);

        Circle slice3 = new Circle(center, MyColor.BLUE, radius, 360*0.623442,  360*0.5127);
        gc.setFill(MyColor.BLUE.getColor());
        slice3.draw(gc);

        Circle slice4 = new Circle(center, MyColor.YELLOW, radius, 360*0.5127,360* (0.6));
        gc.setFill(MyColor.YELLOW.getColor());
        slice4.draw(gc);

            gc.setFill(MyColor.BLACK.getColor());

        gc.fillText("Legend", 70, 100);
        gc.fillText("Purple 'e' = 0.1260 ", 70, 120);
        gc.fillText("PINK 't' = 0.0992 ", 70, 140);
        gc.fillText("BLUE 'a' = 0.0816 ", 70, 160);
        gc.fillText("YELLOW = 0.6931 ", 70, 180);
        // Displaying final canvas on screen
        root.getChildren().add(canvas);
        primaryStage.setTitle("Pie Chart for \"ALICE IN WONDERLAND\" ");
        primaryStage.setScene(scene);
        primaryStage.show();
}
    public static void main(String[] args) {
        launch(args);
    }
}




