import java.util.Scanner;

public class Player {
    private String name;
    private String color;
    private boolean isHuman;

    public Player(String name, String color, boolean isHuman) {
        this.name = name;
        this.color = color;
        this.isHuman = isHuman;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public Move makeMove() {
        if (isHuman) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter move (format: fromRow fromCol toRow toCol): ");
            int fromRow = scanner.nextInt();
            int fromCol = scanner.nextInt();
            int toRow = scanner.nextInt();
            int toCol = scanner.nextInt();
            return new Move(new Square(fromRow, fromCol, null), new Square(toRow, toCol, null), null);
//        } else {
//            // AI logic for move
//            return new Move();
//        }
    }
}