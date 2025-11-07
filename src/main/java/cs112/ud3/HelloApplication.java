package cs112.ud2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    public static void main(String[] args) {
        launch();
    }

    // VARIABLES //

    private Label label;
    private Button button;

    @Override
    public void start(Stage stage) throws Exception {

        label = new Label("Test!");
        button = new Button("Click Me!");
        button.setOnAction(this::handle);

        VBox layout = new VBox();
        layout.getChildren().setAll(label, button);


        Scene scene = new Scene(layout, 320, 240);
        stage.setTitle("Hello World!");
        stage.setScene(scene);
        stage.show();
    }

    public void handle(ActionEvent event) {

        //When the button is clicked...
        if (event.getSource() == button) {
            label.setText("You clicked the button!");
        }
    }
}