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
        for(int i = 0 ; i < 2 ; i++){
            insertShip(2);
        }
        for(int i = 0 ; i < 2 ; i++){
            insertShip(3);
        }
        for(int i = 0 ; i < 2 ; i++){
            insertShip(4);
        }
        insertShip(5);
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

    protected void insertShip(int mastQuantity) {
        Plane plane = Plane.randomPlane();
        int x = chooseNum();
        int y = chooseNum();
        Set<Coordinate> coordinateSet;
        Coordinate coordinate = new Coordinate(x, y);
        if (plane.equals(Plane.HORIZONTAL)) {
            if (baseOnMastQuantityConfirmIfCanMoveHorizontal(coordinate, mastQuantity)) {
                coordinateSet = createCoordinateSetHorizontal(coordinate, mastQuantity);
                confirmIfFieldIsZero(coordinateSet, mastQuantity);
                changeFields(coordinateSet, mastQuantity);
            } else insertShip(mastQuantity);
        } else {
            if (baseOnMastQuantityConfirmIfCanMoveVertical(coordinate, mastQuantity)) {
                coordinateSet = createCoordinateSetHorizontal(coordinate, mastQuantity);
                confirmIfFieldIsZero(coordinateSet, mastQuantity);
                changeFields(coordinateSet, mastQuantity);
            } else insertShip(mastQuantity);
        }
    }

    /**
     * creates set of horizontal coordinate
     *
     * @param coordinate   - starting point
     * @param mastQuantity of ship
     * @return set of coordinate
     */
    Set<Coordinate> createCoordinateSetHorizontal(Coordinate coordinate, int mastQuantity) {
        Set<Coordinate> coordinateSet = new HashSet<>();
        coordinateSet.add(coordinate);
        for (int i = 0; i < mastQuantity; i++) {
            coordinateSet.add(new Coordinate(coordinate.getX() + i, coordinate.getY()));
        }
        return coordinateSet;
    }

    /**
     * creates set of vertical coordinate
     *
     * @param coordinate-  starting point
     * @param mastQuantity of ship
     * @return set of coordinate
     */
    Set<Coordinate> createCoordinateSetVertical(Coordinate coordinate, int mastQuantity) {
        Set<Coordinate> coordinateSet = new HashSet<>();
        coordinateSet.add(coordinate);
        for (int i = 0; i < mastQuantity; i++) {
            coordinateSet.add(new Coordinate(coordinate.getX(), coordinate.getY() + i));
        }
        return coordinateSet;
    }

    /**
     * if field on coordinate is not zero method insertShip will be call again
     *
     * @param coordinateSet fields on coordinates to be changed
     * @param mastQuantity  of ship
     */
    protected void confirmIfFieldIsZero(Set<Coordinate> coordinateSet, int mastQuantity) {
        for (Coordinate coord : coordinateSet) {
            if (board.getElementAt(coord) != 0) {
                insertShip(mastQuantity);
            }
        }
    }

    /**
     * inserts number of mast quantity in coordinate fields
     *
     * @param coordinateSet fields on coordinates to be changed
     * @param mastQuantity  of ship
     */
    void changeFields(Set<Coordinate> coordinateSet, int mastQuantity) {
        for (Coordinate coord : coordinateSet) {
            board.setElementAt(mastQuantity, coord);
        }
    }

    protected boolean baseOnMastQuantityConfirmIfCanMoveHorizontal(Coordinate coordinate, int mastQuantity) {
        switch (mastQuantity) {
            case 2 -> {
                return coordinate.canMoveRight();
            }
            case 3 -> {
                return coordinate.canMoveTwoRight();
            }
            case 4 -> {
                return coordinate.canMoveThreeRight();
            }
            case 5 -> {
                return coordinate.canMoveFourRight();
            }
            default -> {
                return false;
            }
        }
    }

    protected boolean baseOnMastQuantityConfirmIfCanMoveVertical(Coordinate coordinate, int mastQuantity) {
        switch (mastQuantity) {
            case 2 -> {
                return coordinate.canMoveDown();
            }
            case 3 -> {
                return coordinate.canMoveTwoDown();
            }
            case 4 -> {
                return coordinate.canMoveThreeDown();
            }
            case 5 -> {
                return coordinate.canMoveFourDown();
            }
            default -> {
                return false;
            }
        }
    }

}
