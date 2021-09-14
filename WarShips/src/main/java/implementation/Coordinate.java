package implementation;

import java.util.Objects;

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

    protected boolean canMoveTwoDown() {
        return y < Board.SIZE - 2;
    }

    protected boolean canMoveThreeDown() {
        return y < Board.SIZE - 3;
    }

    protected boolean canMoveFourDown() {
        return y < Board.SIZE - 4;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordinate)) return false;
        Coordinate that = (Coordinate) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
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
