package implementation;

public class Coordinate {

    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    protected boolean canMoveRight() {
        return x < Board.SIZE - 1;
    }

    protected boolean canMoveTwoRight() {
        return x < Board.SIZE - 2;
    }

    protected boolean canMoveThreeRight() {
        return x < Board.SIZE - 3;
    }

    protected boolean canMoveFourRight() {
        return x < Board.SIZE - 4;
    }

    protected boolean canMoveDown() {
        return y < Board.SIZE - 1;
    }

    protected boolean canTwoMoveDown() {
        return y < Board.SIZE - 2;
    }

    protected boolean canThreeMoveDown() {
        return y < Board.SIZE - 3;
    }

    protected boolean canFourMoveDown() {
        return y < Board.SIZE - 4;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
