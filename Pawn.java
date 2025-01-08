public class Pawn extends Piece {
    public Pawn(String color) {
        super(color);
    }

    @Override
    public boolean isValidMove(Move move, Board board) {
        int fromRow = move.getFrom().getRow();
        int fromCol = move.getFrom().getColumn();
        int toRow = move.getTo().getRow();
        int toCol = move.getTo().getColumn();

        int direction = color.equals("white") ? -1 : 1;
        if (fromCol == toCol) {
            if (toRow == fromRow + direction && board.getSquare(toRow, toCol).getPiece() == null) {
                return true; // Move forward one square
            }
            if (fromRow == (color.equals("white") ? 6 : 1) && toRow == fromRow + 2 * direction &&
                    board.getSquare(toRow, toCol).getPiece() == null &&
                    board.getSquare(fromRow + direction, fromCol).getPiece() == null) {
                return true; // Move forward two squares
            }
        } else if (Math.abs(fromCol - toCol) == 1 && toRow == fromRow
