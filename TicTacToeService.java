package com.game;

import org.springframework.stereotype.Service;

@Service
public class TicTacToeService {
    private char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    private char currentPlayer = 'X';

    public char[][] getBoard() { return board; }

    public String makeMove(int r, int c) {
        if (board[r][c] == ' ') {
            board[r][c] = currentPlayer;
            if (checkWin()) return "Player " + currentPlayer + " Wins!";
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            return "Turn: " + currentPlayer;
        }
        return "Invalid Move";
    }

    public void reset() {
        board = new char[][]{{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        currentPlayer = 'X';
    }

    private boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) return true;
            if (board[0][i] != ' ' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) return true;
        }
        return (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) ||
               (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]);
    }
}
