package es.ieslosmontecillos.controlcircle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class ControlCircle extends Application {

    Circle crcl = new Circle(30,30,30);

    @Override
    public void start(Stage stage) {
        // Creación del panel y la escena
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 320, 240);
        stage.setTitle("Control Circle");

        // Horizontal box para los botones
        HBox botones = new HBox();

        // Asignación de botones
        Button enlarge = new Button("Enlarge");
        Button shrink = new Button("Shrink");

        // Asignación de los botones y el círculo en el panel
        root.setBottom(botones);
        root.setCenter(crcl);

        // Adición de padding para el panel
        root.setPadding(new Insets(5));

        // Alineación de la HBox y espaciado entre los botones
        botones.setAlignment(Pos.CENTER);
        botones.setSpacing(20);

        // Asignación de los botones en la HBox
        botones.getChildren().add(enlarge);
        botones.getChildren().add(shrink);

        // Llamada de eventos InnerClass de los botones
        enlarge.setOnAction(new enlargeCircle());
        shrink.setOnAction(new shrinkCircle());


        stage.setScene(scene);
        stage.show();
    }

    class enlargeCircle implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e){
            // Aumenta el radio del circulo
            crcl.setRadius(crcl.getRadius() + 10);
        }
    }
    class shrinkCircle implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            // Disminuye el radio del círculo
            crcl.setRadius(crcl.getRadius() - 10);
        }
    }
    public static void main(String[] args) {
        launch();
    }
}