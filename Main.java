public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("Alice", "white", true);
        Player player2 = new Player("Bob", "black", true);

        ChessGame game = new ChessGame(player1, player2);
        game.startGame();
    }
}