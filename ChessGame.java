// ChessGame.java
public class ChessGame {
    private Board board;
    private Player[] players;
    private Player currentPlayer;

    public ChessGame(Player player1, Player player2) {
        this.board = new Board();
        this.players = new Player[]{player1, player2};
        this.currentPlayer = player1;
    }

    public void startGame() {
        board.initializeBoard();
        while (!isGameOver()) {
            board.displayBoard();
            System.out.println(currentPlayer.getName() + "'s turn");
            Move move = currentPlayer.makeMove();
            if (board.isMoveValid(move, currentPlayer.getColor())) {
                board.movePiece(move);
                switchTurn();
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
        System.out.println("Game over!");
    }

    private boolean isGameOver() {
        return GameRules.isCheckmate(board, currentPlayer.getColor()) ||
                GameRules.isStalemate(board, currentPlayer.getColor());
    }

    private void switchTurn() {
        currentPlayer = (currentPlayer == players[0]) ? players[1] : players[0];
    }
}
