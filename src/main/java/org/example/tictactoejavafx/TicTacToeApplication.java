package org.example.tictactoejavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;

import java.util.Objects;

public class TicTacToeApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(
                TicTacToeApplication.class.getResource("game-view.fxml")
        );

        Scene scene = new Scene(fxmlLoader.load(), 400, 400);
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());

        stage.setTitle("Крестики-нолики");
        stage.getIcons().add(new Image(Objects.requireNonNull(
                TicTacToeApplication.class.getResource("icon.png")
        ).toExternalForm()));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}