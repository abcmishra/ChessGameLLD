public class GameRules {
    public static boolean isCheck(Board board, String playerColor) {
        Square kingSquare = findKing(board, playerColor);
        if (kingSquare == null) {
            return false;
        }
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Piece piece = board.getSquare(row, col).getPiece();
                if (piece != null && !piece.getColor().equals(playerColor)) {
                    Move move = new Move(board.getSquare(row, col), kingSquare, null);
                    if (piece.isValidMove(move, board)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean isCheckmate(Board board, String playerColor) {
        if (!isCheck(board, playerColor)) {
            return false;
        }
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Piece piece = board.getSquare(row, col).getPiece();
                if (piece != null && piece.getColor().equals(playerColor)) {
                    for (int toRow = 0; toRow < 8; toRow++) {
                        for (int toCol = 0; toCol < 8; toCol++) {
                            Move move = new Move(board.getSquare(row, col), board.getSquare(toRow, toCol), null);
                            if (piece.isValidMove(move, board)) {
                                Piece capturedPiece = board.getSquare(toRow, toCol).getPiece();
                                board.movePiece(move);
                                if (!isCheck(board, playerColor)) {
                                    undoMove(board, move, capturedPiece);
                                    return false;
                                }
                                undoMove(board, move, capturedPiece);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    public static boolean isStalemate(Board board, String playerColor) {
        if (isCheck(board, playerColor)) {
            return false;
        }
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Piece piece = board.getSquare(row, col).getPiece();
                if (piece != null && piece.getColor().equals(playerColor)) {
                    for (int toRow = 0; toRow < 8; toRow++) {
                        for (int toCol = 0; toCol < 8; toCol++) {
                            Move move = new Move(board.getSquare(row, col), board.getSquare(toRow, toCol), null);
                            if (piece.isValidMove(move, board)) {
                                Piece capturedPiece = board.getSquare(toRow, toCol).getPiece();
                                board.movePiece(move);
                                if (!isCheck(board, playerColor)) {
                                    undoMove(board, move, capturedPiece);
                                    return false;
                                }
                                undoMove(board, move, capturedPiece);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    private static Square findKing(Board board, String playerColor) {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Piece piece = board.getSquare(row, col).getPiece();
                if (piece instanceof King && piece.getColor().equals(playerColor)) {
                    return board.getSquare(row, col);
                }
            }
        }
        return null;
    }

    private static void undoMove(Board board, Move move, Piece capturedPiece) {
        move.getFrom().setPiece(move.getTo().getPiece());
        move.getTo().setPiece(capturedPiece);
    }
}