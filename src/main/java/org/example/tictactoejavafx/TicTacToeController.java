package org.example.tictactoejavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class TicTacToeController {
    @FXML private GridPane boardGrid;
    @FXML private Label statusLabel;

    private String[][] board = new String[3][3];
    private boolean isXTurn = true;




    final Button[][] buttons = new Button[3][3];


    @FXML
    public void initialize() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                Button button = new Button();
                button.setPrefSize(100, 100);
                button.getStyleClass().addAll("btn", "btn-primary");
                button.setOnAction(this::handleButtonClick);
                boardGrid.add(button, col, row);
                buttons[row][col] = button;
                board[row][col] = null;
            }
        }
        statusLabel.setText("Игрок X ходит");
    }


    @FXML
    private void handleButtonClick(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        int row = GridPane.getRowIndex(clickedButton);
        int col = GridPane.getColumnIndex(clickedButton);
        String mark = isXTurn ? "X" : "O";

        if (board[row][col] == null) {
            board[row][col] = isXTurn ? "X" : "O";
            clickedButton.setText(board[row][col]);
            clickedButton.setText(board[row][col]);
            clickedButton.getStyleClass().add(mark.equals("X") ? "btn-info" : "btn-danger");;

            if (checkForWinner()) {
                statusLabel.setText((isXTurn ? "X" : "O") + " выиграл!");
                disableBoard();
                return;
            }

            isXTurn = !isXTurn;
            statusLabel.setText("Игрок " + (isXTurn ? "X" : "O") + " ходит");
        }
    }


    @FXML
    private void handleRestartGame() {
        board = new String[3][3];
        isXTurn = true;
        statusLabel.setText("Игрок X ходит");

        for (var node : boardGrid.getChildren()) {
            if (node instanceof Button button) {
                button.setText("");
                button.getStyleClass().removeAll("btn-info", "btn-danger");
                node.setDisable(false);
            }
        }
    }

    private void disableBoard() {
        for (var node : boardGrid.getChildren()) {
            node.setDisable(true);
        }
    }

    private boolean checkForWinner() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != null && board[i][0].equals(board[i][1]) && board[i][0].equals(board[i][2])) return true;
            if (board[0][i] != null && board[0][i].equals(board[1][i]) && board[0][i].equals(board[2][i])) return true;
        }
        return board[0][0] != null && board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2]) ||
                board[0][2] != null && board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][0]);
    }
}

