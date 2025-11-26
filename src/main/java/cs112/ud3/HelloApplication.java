package cs112.ud3;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox; // For ComboBox
import javafx.scene.control.TableView; // For TableView
import javafx.scene.control.TableColumn; // For TableColumn
import javafx.scene.control.TextField; // For TextField
import javafx.scene.control.Alert; //  For Alert (and AlertType)
import javafx.scene.control.Alert.AlertType; // For AlertType
import javafx.scene.control.cell.PropertyValueFactory; // For TableView column binding
import java.util.ArrayList;
import javafx.geometry.Insets;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import cs112.ud3.UD2.Baseball.RealStatistics;
import cs112.ud3.UD2.Baseball.Team;
import cs112.ud3.UD2.Baseball.Player;
import cs112.ud3.UD2.Baseball.Game;

/**
 * @author Mya B.
 * @version 1.0
 */

public class HelloApplication extends Application {

    // VARIABLES //
    private Team selectedTeam = RealStatistics.blueJays;
    private Label label;
    private Button button;
    private Label teamStatsLabel;
    private ComboBox<String> teamSelector;
    private TableView<Player> rosterTable;

    //for Adding Player
    private TextField firstNameField;
    private TextField jerseyNumberField;
    private Button addPlayerButton;

    //for Deleting Player
    private Button deletePlayerButton;

    private Button simulateGameButton;
    private Label gameResultLabel;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        teamSelector = createTeamSelector();
        teamStatsLabel = new Label();
        rosterTable = createRosterTable();

        deletePlayerButton = new Button("Remove Selected Player");
        deletePlayerButton.setOnAction(e -> deletePlayer());
        HBox rosterControls = new HBox(10, deletePlayerButton);
        rosterControls.setPadding(new Insets(0, 0, 10, 0));

        simulateGameButton = new Button("Simulate Game Against Random Opponent");
        simulateGameButton.setOnAction(e -> simulateGame());
        gameResultLabel = new Label("Ready to play ball!");
        VBox simulationLayout = new VBox(5, simulateGameButton, gameResultLabel);
        simulationLayout.setPadding(new Insets(10, 0, 10, 0));
        firstNameField = new TextField();
        firstNameField.setPromptText("First Name");
        jerseyNumberField = new TextField();
        jerseyNumberField.setPromptText("Jersey #");
        addPlayerButton = new Button("Add Player to Roster");
        addPlayerButton.setOnAction(e -> addPlayer());
        HBox addPlayerLayout = new HBox(10, new Label("Add:"), firstNameField, jerseyNumberField, addPlayerButton);
        addPlayerLayout.setPadding(new Insets(0, 0, 10, 0));
        // update the display
        updateDisplay();

        label = new Label("Test!");
        button = new Button("Click Me!");
        button.setOnAction(this::handle);

        VBox layout = new VBox(10);
        layout.setPadding(new javafx.geometry.Insets(20));

        layout.getChildren().setAll(teamSelector,
                teamStatsLabel,
                rosterTable,
                rosterControls,
                simulationLayout,
                addPlayerLayout,label, button);


        Scene scene = new Scene(layout, 320, 240);
        stage.setTitle("Baseball Team Management & Simulation");
        stage.setScene(scene);
        stage.show();
    }
    public void handle(ActionEvent event) {

        //When the button is clicked...
        if (event.getSource() == button) {
            label.setText("You clicked the button!");
        }
    }
    private TableView<Player> createRosterTable() {
        TableView<Player> table = new TableView<>();
        table.setPlaceholder(new Label("Select a team to view players."));

        TableColumn<Player, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        TableColumn<Player, Integer> posCol = new TableColumn<>("Pos");
        posCol.setCellValueFactory(new PropertyValueFactory<>("position"));

        TableColumn<Player, Integer> gpCol = new TableColumn<>("GP");
        gpCol.setCellValueFactory(new PropertyValueFactory<>("gamesPlayed"));

        table.getColumns().addAll(nameCol, posCol, gpCol);

        nameCol.prefWidthProperty().bind(table.widthProperty().multiply(0.5));
        posCol.prefWidthProperty().bind(table.widthProperty().multiply(0.2));
        gpCol.prefWidthProperty().bind(table.widthProperty().multiply(0.3));

        return table;
    }

    private ComboBox<String> createTeamSelector() {
        ComboBox<String> selector = new ComboBox<>();
        selector.setPromptText("Choose a Team...");

        ObservableList<String> teamNames = FXCollections.observableArrayList(RealStatistics.allTeams.getLeagueRosterNames());
        selector.setItems(teamNames);

        Team[] leagueRoster = RealStatistics.allTeams.getLeagueRoster();

        if (leagueRoster.length > 0) { // Check length instead of isEmpty()
            selector.getSelectionModel().select(0);
            // FIX: Use array brackets [] to access the Team object
            selectedTeam = leagueRoster[0];
        }

        selector.setOnAction(e -> {
            int index = selector.getSelectionModel().getSelectedIndex();
            if (index != -1) {
                // FIX: Use array brackets [] to access the Team object
                selectedTeam = leagueRoster[index];
                updateDisplay();
            }
        });
        return selector;
    }

    private void updateDisplay() {
        if (selectedTeam == null) return;

        ObservableList<Player> players = FXCollections.observableArrayList(selectedTeam.getRoster());
        rosterTable.setItems(players);

        teamStatsLabel.setText(String.format("%s %s W-L: (%d-%d) | WP: %s | Roster Size: %d",
                selectedTeam.getTeamCity(),
                selectedTeam.getTeamName(),
                selectedTeam.getWins(),
                selectedTeam.getLosses(),
                selectedTeam.getWinningPercentage(),
                players.size()));
    }
    /** Adds a new player to the selected team's roster. */
    private void addPlayer() {
        if (selectedTeam == null) {
            new Alert(AlertType.ERROR, "Please select a team first.").showAndWait();
            return;
        }

        try {
            String fName = firstNameField.getText().trim();
            String numText = jerseyNumberField.getText().trim();

            if (fName.isEmpty() || numText.isEmpty()) {
                throw new IllegalArgumentException("Name and Jersey number are required.");
            }

            int number = Integer.parseInt(numText);

            Player newPlayer = new Player(fName, "New", number, 9, 180);
            boolean added = selectedTeam.addPlayerToRoster(newPlayer);

            if (added) {
                new Alert(AlertType.INFORMATION, fName + " added successfully to " + selectedTeam.getTeamName()).showAndWait();
                firstNameField.clear();
                jerseyNumberField.clear();
                updateDisplay();
            } else {
                new Alert(AlertType.WARNING, fName + " could not be added (possibly already exists).").showAndWait();
            }

        } catch (NumberFormatException e) {
            new Alert(AlertType.ERROR, "Jersey number must be a valid integer.").showAndWait();
        } catch (IllegalArgumentException e) {
            new Alert(AlertType.ERROR, e.getMessage()).showAndWait();
        }
    }

    /** Removes the selected player from the roster. */
    private void deletePlayer() {
        if (selectedTeam == null) {
            new Alert(AlertType.ERROR, "Please select a team first.").showAndWait();
            return;
        }

        Player playerToRemove = rosterTable.getSelectionModel().getSelectedItem();

        if (playerToRemove == null) {
            new Alert(AlertType.WARNING, "Please select a player from the table to remove.").showAndWait();
            return;
        }

        boolean removed = selectedTeam.removePlayerFromRoster(playerToRemove);

        if (removed) {
            new Alert(AlertType.INFORMATION, playerToRemove.getFirstName() + " removed successfully.").showAndWait();
            updateDisplay();
        } else {
            new Alert(AlertType.ERROR, "Failed to remove player.").showAndWait();
        }
    }
    /** Runs a game simulation against a random opponent, updates stats, and refreshes the display.
     */
    private void simulateGame() {
        if (selectedTeam == null) {
            gameResultLabel.setText("Please select a team first!");
            return;
        }

        Team[] allTeams = RealStatistics.allTeams.getLeagueRoster();
        Team opponent = null;

        do {
            int randomIndex = (int) (java.lang.Math.random() * allTeams.length);
            opponent = allTeams[randomIndex];
        } while (opponent.equals(selectedTeam));

        if (opponent.equals(selectedTeam) && allTeams.length <= 1) {
            gameResultLabel.setText("Need more than one team to simulate a game!");
            return;
        }

        Game game = new Game(selectedTeam, opponent);
        Team winner = game.playGame();

        String winnerName = winner.getTeamCity() + " " + winner.getTeamName();
        gameResultLabel.setText("Game Complete! Winner: " + winnerName + "\n" + game.boxScore());

        updateDisplay();
    }
}