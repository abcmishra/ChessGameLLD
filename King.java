public class King extends Piece {
    public King(String color) {
        super(color);
    }

    @Override
    public boolean isValidMove(Move move, Board board) {
        int fromRow = move.getFrom().getRow();
        int fromCol = move.getFrom().getColumn();
        int toRow = move.getTo().getRow();
        int toCol = move.getTo().getColumn();
        return Math.abs(fromRow - toRow) <= 1 && Math.abs(fromCol - toCol) <= 1;
    }
}