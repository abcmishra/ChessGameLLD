public class Board {
    private Square[][] grid;

    public Board() {
        this.grid = new Square[8][8];
    }

    public void initializeBoard() {
        // Initialize pieces on the board
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                grid[i][j] = new Square(i, j, null);
            }
        }
        // Place initial pieces (example for pawns and kings)
        for (int i = 0; i < 8; i++) {
            grid[1][i].setPiece(new Pawn("black"));
            grid[6][i].setPiece(new Pawn("white"));
        }
        grid[0][4].setPiece(new King("black"));
        grid[7][4].setPiece(new King("white"));
    }

    public boolean isMoveValid(Move move, String playerColor) {
        Piece piece = move.getFrom().getPiece();
        if (piece == null || !piece.getColor().equals(playerColor)) {
            return false; // No piece to move or wrong player's piece
        }
        return piece.isValidMove(move, this);
    }

    public void movePiece(Move move) {
        Square from = move.getFrom();
        Square to = move.getTo();
        Piece piece = from.getPiece();
        to.setPiece(piece);
        from.setPiece(null);
    }

    public void displayBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece piece = grid[i][j].getPiece();
                System.out.print((piece == null ? "--" : piece.getClass().getSimpleName().charAt(0)) + " ");
            }
            System.out.println();
        }
    }

    public Square getSquare(int row, int col) {
        return grid[row][col];
    }
}