package org.example.tictactoejavafx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class TicTacToeController {

    @FXML private Button button00;
    @FXML private Button button01;
    @FXML private Button button02;
    @FXML private Button button10;
    @FXML private Button button11;
    @FXML private Button button12;
    @FXML private Button button20;
    @FXML private Button button21;
    @FXML private Button button22;
    @FXML private Label statusLabel;

    private boolean isXTurn = true; // Начинает игрок X
    private String[][] board = new String[3][3]; // Игровое поле

    @FXML
    private void handleButtonClick() {
        Button clickedButton = (Button) event.getSource(); // Получаем нажатую кнопку
        int row = GridPane.getRowIndex(clickedButton);
        int col = GridPane.getColumnIndex(clickedButton);

        // Если ячейка пуста, то обновляем её
        if (board[row][col] == null) {
            board[row][col] = isXTurn ? "X" : "O";
            clickedButton.setText(board[row][col]);

            // Проверяем на победу
            if (checkForWinner()) {
                statusLabel.setText((isXTurn ? "X" : "O") + " выиграл!");
                return;
            }

            // Переключаем ход
            isXTurn = !isXTurn;
            statusLabel.setText("Игрок " + (isXTurn ? "X" : "O") + " ходит");
        }
    }

    private boolean checkForWinner() {
        // Проверка по строкам
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != null && board[i][0].equals(board[i][1]) && board[i][0].equals(board[i][2])) {
                return true;
            }
        }

        // Проверка по столбцам
        for (int i = 0; i < 3; i++) {
            if (board[0][i] != null && board[0][i].equals(board[1][i]) && board[0][i].equals(board[2][i])) {
                return true;
            }
        }

        // Проверка по диагоналям
        if (board[0][0] != null && board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2])) {
            return true;
        }
        if (board[0][2] != null && board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][0])) {
            return true;
        }

        return false;
    }
}
