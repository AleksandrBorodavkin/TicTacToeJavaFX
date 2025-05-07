package org.example.tictactoejavafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;

public class TicTacToeApplication extends Application {
    @Override
    public void start(Stage stage) {
        GameController controller = new GameController();
        GridPane board = controller.createBoard();

        Scene scene = new Scene(board, 300, 300);
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        stage.setTitle("Крестики-нолики");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
