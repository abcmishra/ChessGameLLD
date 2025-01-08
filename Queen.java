public class Queen extends Piece {
    public Queen(String color) {
        super(color);
    }

    @Override
    public boolean isValidMove(Move move, Board board) {
        Rook rook = new Rook(color);
        Bishop bishop = new Bishop(color);
        return rook.isValidMove(move, board) || bishop.isValidMove(move, board);
    }
}