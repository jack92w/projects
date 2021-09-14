package implementation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

class BoardManagerTest {

    private BoardManager boardManager;

    @BeforeEach
    void setUp() {
        boardManager = new BoardManager();
    }

    @Test
    void shouldCreateBoard_andPrint() {
        boardManager.initBoard();
        boardManager.printBoard();
        System.out.println();
    }

    @Test
    void shouldReturnProperSetOfHorizontalCoordinate() {
        //given
        Coordinate coordinate = new Coordinate(4, 5);
        Set<Coordinate> expectedSet = new HashSet<>();
        expectedSet.add(new Coordinate(4, 5));
        expectedSet.add(new Coordinate(5, 5));
        expectedSet.add(new Coordinate(6, 5));
        //when
        Set<Coordinate> actualSet = boardManager.createCoordinateSet(coordinate, 3, Plane.HORIZONTAL);
        //then
        Assertions.assertTrue(expectedSet.containsAll(actualSet));
        Assertions.assertEquals(3, actualSet.size());
    }

    @Test
    void shouldThrowIllegalArgumentExceptionIfMastQuantityLessThanOne() {
        //given
        Coordinate coordinate = new Coordinate(4, 5);
        Set<Coordinate> expectedSet = new HashSet<>();
        //when
        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> boardManager.createCoordinateSet(coordinate, -2, Plane.HORIZONTAL));
    }

    @Test
    void shouldChangeFieldsNumericValue() {
        //given
        int mastQuantity = 3;
        Coordinate coordinate = new Coordinate(4, 5);
        Set<Coordinate> expectedSet = new HashSet<>();
        expectedSet.add(coordinate);
        boardManager.board.setNumberAt(0, coordinate);
        //when
        boardManager.changeFields(expectedSet, mastQuantity);
        //then
        Assertions.assertEquals(mastQuantity, boardManager.board.getNumberAt(coordinate));
    }

    @Test
    void shouldReturnTruIfCanMoveRight() {
        //given
        Coordinate coordinate = new Coordinate(4, 5);
        //when
        boolean actual = boardManager.baseOnMastQuantityConfirmIfCanInsertShip(coordinate, 4, Plane.HORIZONTAL);
        //then
        Assertions.assertTrue(actual);
    }

    @Test
    void shouldReturnFalseIfCanNotMoveRight() {
        //given
        Coordinate coordinate = new Coordinate(7, 5);
        //when
        boolean actual = boardManager.baseOnMastQuantityConfirmIfCanInsertShip(coordinate, 4, Plane.HORIZONTAL);
        //then
        Assertions.assertFalse(actual);
    }

    @Test
    void shouldReturnFalseIfInCoordinateSetIsNumberDifferentThanZero() {
        //given
        Set<Coordinate> set = new HashSet<>();
        Coordinate coordinate1 = new Coordinate(7, 5);
        Coordinate coordinate2 = new Coordinate(8, 5);
        Coordinate coordinate3 = new Coordinate(9, 5);
        set.add(coordinate1);
        set.add(coordinate2);
        set.add(coordinate3);
        for (Coordinate coord : set) {
            boardManager.board.setNumberAt(0, coord);
        }
        boardManager.board.setNumberAt(3, coordinate1);
        //when
        boolean actual = boardManager.confirmIfFieldsAreZero(set);
        //then
        Assertions.assertFalse(actual);
    }

    @Test
    void shouldReturnTrueIfInCoordinateSetAreOnlyZeros() {
        //given
        Set<Coordinate> set = new HashSet<>();
        Coordinate coordinate1 = new Coordinate(7, 5);
        Coordinate coordinate2 = new Coordinate(8, 5);
        Coordinate coordinate3 = new Coordinate(9, 5);
        set.add(coordinate1);
        set.add(coordinate2);
        set.add(coordinate3);
        //when
        boolean actual = boardManager.confirmIfFieldsAreZero(set);
        //then
        Assertions.assertTrue(actual);
    }

}