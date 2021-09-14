package implementation;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static java.lang.System.out;

public class BoardManager {

    Board board = new Board();
    static final int TWO_MASTED = 2;
    static final int THREE_MASTED = 3;
    static final int FOUR_MASTED = 4;
    static final int FIVE_MASTED = 5;

    /**
     * initiates board with ships
     */
    protected void initBoard() {
        Board.BoardIterator iterator = board.createIterator();
        while (iterator.hasNext()) {
            board.setNumberAt(0, iterator.next());
        }
        for (int i = 0; i < 2; i++) {
            insertShip(TWO_MASTED);
        }
        for (int i = 0; i < 2; i++) {
            insertShip(THREE_MASTED);
        }
        for (int i = 0; i < 2; i++) {
            insertShip(FOUR_MASTED);
        }
        insertShip(FIVE_MASTED);
    }

    /**
     * @return random number from range 0-9
     */
    protected int chooseNum() {
        return new Random().nextInt(10);
    }

    /**
     * prints board
     */
    protected void printBoard() {
        Board.BoardIterator iterator = board.createIterator();
        int count = 0;
        while (iterator.hasNext()) {
            out.print(board.getNumberAt(iterator.next()) + "  ");
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
        if (baseOnMastQuantityConfirmIfCanInsertShip(coordinate, mastQuantity, plane)) {
            coordinateSet = createCoordinateSet(coordinate, mastQuantity, plane);
            if (confirmIfFieldsAreZero(coordinateSet)) {
                changeFields(coordinateSet, mastQuantity);
            } else {
                insertShip(mastQuantity);
            }
        } else {
            insertShip(mastQuantity);
        }
    }

    /**
     * creates coordinate set for ship insertion
     *
     * @param coordinate   of ship beginning
     * @param mastQuantity of ship
     * @param plane        of ship direction
     * @return ship coordinate
     */
    Set<Coordinate> createCoordinateSet(Coordinate coordinate, int mastQuantity, Plane plane) {
        if (mastQuantity > 1) {
            Set<Coordinate> coordinateSet = new HashSet<>();
            if (plane == Plane.HORIZONTAL) {
                for (int i = 0; i < mastQuantity; i++) {
                    coordinateSet.add(new Coordinate(coordinate.getX() + i, coordinate.getY()));
                }
            } else {
                for (int i = 0; i < mastQuantity; i++) {
                    coordinateSet.add(new Coordinate(coordinate.getX(), coordinate.getY() + i));
                }
            }
            return coordinateSet;
        } else throw new IllegalArgumentException();
    }

    /**
     * checks if fields on coordinates are zero
     * @param coordinateSet to be checked
     * @return true if all fields are zero
     */
    protected boolean confirmIfFieldsAreZero(Set<Coordinate> coordinateSet) {
        boolean isZero = true;
        for (Coordinate coord : coordinateSet) {
            int num = board.getNumberAt(coord);
            if (num != 0) {
                isZero = false;
            }
        }
        return isZero;
    }

    /**
     * inserts number of mast quantity in coordinate fields
     *
     * @param coordinateSet fields on coordinates to be changed
     * @param mastQuantity  of ship
     */
    void changeFields(Set<Coordinate> coordinateSet, int mastQuantity) {
        for (Coordinate coord : coordinateSet) {
            board.setNumberAt(mastQuantity, coord);
        }
    }

    /**
     * confirms if inserting ships is possible
     *
     * @param coordinate   of ship beginning
     * @param mastQuantity of ship
     * @param plane        of ship direction
     * @return true if insertion is possible
     */
    protected boolean baseOnMastQuantityConfirmIfCanInsertShip(Coordinate coordinate, int mastQuantity, Plane plane) {
        return switch (mastQuantity) {
            case TWO_MASTED -> {
                if (plane == Plane.VERTICAL) {
                    yield coordinate.canMoveDown();
                } else {
                    yield coordinate.canMoveRight();
                }
            }
            case THREE_MASTED -> {
                if (plane == Plane.VERTICAL) {
                    yield coordinate.canMoveTwoDown();
                } else {
                    yield coordinate.canMoveTwoRight();
                }
            }
            case FOUR_MASTED -> {
                if (plane == Plane.VERTICAL) {
                    yield coordinate.canMoveThreeDown();
                } else {
                    yield coordinate.canMoveThreeRight();
                }
            }

            case FIVE_MASTED -> {
                if
                (plane == Plane.VERTICAL) {
                    yield coordinate.canMoveFourDown();
                } else {
                    yield coordinate.canMoveFourRight();
                }
            }
            default -> false;
        };
    }
}
