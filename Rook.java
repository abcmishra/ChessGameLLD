public class Rook extends Piece {
    public Rook(String color) {
        super(color);
    }

    @Override
    public boolean isValidMove(Move move, Board board) {
        int fromRow = move.getFrom().getRow();
        int fromCol = move.getFrom().getColumn();
        int toRow = move.getTo().getRow();
        int toCol = move.getTo().getColumn();

        if (fromRow != toRow && fromCol != toCol) {
            return false; // Not a straight line move
        }

        int rowDirection = (toRow > fromRow) ? 1 : (toRow < fromRow) ? -1 : 0;
        int colDirection = (toCol > fromCol) ? 1 : (toCol < fromCol) ? -1 : 0;
        int currentRow = fromRow + rowDirection;
        int currentCol = fromCol + colDirection;

        while (currentRow != toRow || currentCol != toCol) {
            if (board.getSquare(currentRow, currentCol).getPiece() != null) {
                return false; // Path is blocked
            }
            currentRow += rowDirection;
            currentCol += colDirection;
        }

        Piece destinationPiece = board.getSquare(toRow, toCol).getPiece();
        return destinationPiece == null || !destinationPiece.getColor().equals(this.color);
    }
}