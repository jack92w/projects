package implementation;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static java.lang.System.*;

public class BoardManager {

    Board board = new Board();

    protected void initBoard() {
        Board.BoardIterator iterator = board.createIterator();
        while (iterator.hasNext()) {
            board.setElementAt(0, iterator.next());
        }
    }

    protected int chooseNum() {
        return new Random().nextInt(10);
    }

    protected void printBoard() {
        Board.BoardIterator iterator = board.createIterator();
        int count = 0;
        while (iterator.hasNext()) {
            out.print(board.getElementAt(iterator.next()) + "  ");
            count++;
            if (count == 10) {
                out.println();
                count = 0;
            }
        }
    }

    protected void insertTwoMasted() {
        Plane plane = Plane.randomPlane();
        int x = chooseNum();
        int y = chooseNum();
        final int mastQuantity = 2;
        Set<Coordinate> coordinateSet;
        Coordinate coordinate = new Coordinate(x, y);
        if (plane.equals(Plane.HORIZONTAL)) {
            if (coordinate.canMoveRight()) {
                coordinateSet = createCoordinateSetHorizontal(coordinate, mastQuantity);
                for (Coordinate coord : coordinateSet) {
                    if (board.getElementAt(coord) != 0) {
                        insertTwoMasted();
                    }
                }
                for (Coordinate coord : coordinateSet) {
                    board.setElementAt(2, coord);
                }
            } else insertTwoMasted();
        } else {
            if (coordinate.canMoveDown()) {
                Set<Coordinate> coordinateSet = new HashSet<>();
                coordinateSet.add(coordinate);
                coordinateSet.add(new Coordinate(coordinate.getX(), coordinate.getY() + 1));
                for (Coordinate coord : coordinateSet) {
                    if (board.getElementAt(coord) != 0) {
                        insertTwoMasted();
                    }
                }
                for (Coordinate coord : coordinateSet) {
                    board.setElementAt(2, coord);
                }
            } else insertTwoMasted();
        }
    }

    Set<Coordinate> createCoordinateSetHorizontal(Coordinate coordinate, int mastQuantity) {
        Set<Coordinate> coordinateSet = new HashSet<>();
        coordinateSet.add(coordinate);
        for (int i = 0; i < mastQuantity; i++) {
            coordinateSet.add(new Coordinate(coordinate.getX() + i, coordinate.getY()));
        }
        return coordinateSet;
    }

    Set<Coordinate> createCoordinateSetVertical(Coordinate coordinate, int mastQuantity) {
        Set<Coordinate> coordinateSet = new HashSet<>();
        coordinateSet.add(coordinate);
        for (int i = 0; i < mastQuantity; i++) {
            coordinateSet.add(new Coordinate(coordinate.getX(), coordinate.getY() + i));
        }
        return coordinateSet;
    }

    protected void confirmIfFieldIsZero(Set<Coordinate> coordinateSet) {
        for (Coordinate coord : coordinateSet) {
            if (board.getElementAt(coord) != 0) {
                insertTwoMasted();
            }
        }
    }

}
