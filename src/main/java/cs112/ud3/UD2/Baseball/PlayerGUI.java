package cs112.ud3.UD2.Baseball;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PlayerGUI extends Application {

    @Override
    public void start(Stage primaryStage) {

        // INPUT FIELDS
        TextField firstNameField = new TextField();
        firstNameField.setPromptText("First Name");

        TextField lastNameField = new TextField();
        lastNameField.setPromptText("Last Name");

        TextField numberField = new TextField();
        numberField.setPromptText("Number");

        ComboBox<Integer> positionBox = new ComboBox<>();
        for (int i = 0; i <= 9; i++) positionBox.getItems().add(i);
        positionBox.setPromptText("Position");

        // BUTTON
        Button addPlayerButton = new Button("Add Player");

        // DISPLAY AREA
        TextArea playersTextArea = new TextArea();
        playersTextArea.setEditable(false);

        // EVENT HANDLER
        addPlayerButton.setOnAction(e -> {
            try {
                String first = firstNameField.getText();
                String last = lastNameField.getText();
                int number = Integer.parseInt(numberField.getText());
                int position = positionBox.getValue();

                Player newPlayer = new Player(first, last, number, position, 0);
                playersTextArea.appendText(newPlayer.toString() + "\n");

                // Clear fields after adding
                firstNameField.clear();
                lastNameField.clear();
                numberField.clear();
                positionBox.getSelectionModel().clearSelection();

            } catch (Exception ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Please fill out all fields correctly!");
                alert.showAndWait();
            }
        });

        // LAYOUT
        VBox layout = new VBox(10, firstNameField, lastNameField, numberField, positionBox, addPlayerButton, playersTextArea);
        layout.setStyle("-fx-padding: 10;");

        Scene scene = new Scene(layout, 400, 400);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Player Creator");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}