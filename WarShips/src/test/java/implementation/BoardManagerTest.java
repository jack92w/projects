package implementation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.HashSet;
import java.util.Set;

class BoardManagerTest {

    private BoardManager boardManager;

    @BeforeEach
    void setUp(){
        boardManager = new BoardManager();
    }

    @Test
    void shouldCreateBoard_andPrint(){
        boardManager.initBoard();
        boardManager.printBoard();
        System.out.println();
    }

    @Test
    void shouldReturnProperSetOfHorizontalCoordinate(){
        //given
        Coordinate coordinate = new Coordinate(4,5);
        Set<Coordinate> expectedSet = new HashSet<>();
        expectedSet.add(new Coordinate(4,5));
        expectedSet.add(new Coordinate(5,5));
        expectedSet.add(new Coordinate(6,5));
        //when
        Set<Coordinate> actualSet =  boardManager.createCoordinateSetHorizontal(coordinate, 3);
        //then
        Assertions.assertTrue(expectedSet.containsAll(actualSet));
        Assertions.assertEquals(3, actualSet.size());
    }

    @Test
    void shouldThrowIllegalArgumentExceptionIfMastQuantityLessThanOne(){
        //given
        Coordinate coordinate = new Coordinate(4,5);
        Set<Coordinate> expectedSet = new HashSet<>();
        //when
        //then
        Assertions.assertThrows(IllegalArgumentException.class, ()-> boardManager.createCoordinateSetHorizontal(coordinate, -2));
    }

    @Test
    void shouldChangeFieldsNumericValue(){
        //given
        int mastQuantity = 3;
        Coordinate coordinate = new Coordinate(4,5);
        Set<Coordinate> expectedSet = new HashSet<>();
        expectedSet.add(coordinate);
        boardManager.board.setElementAt(0, coordinate);
        //when
        boardManager.changeFields(expectedSet, mastQuantity);
        //then
        Assertions.assertEquals(mastQuantity, boardManager.board.getElementAt(coordinate));
    }

    @Test
    void shouldReturnTruIfCanMoveRight(){
        //given
        Coordinate coordinate = new Coordinate(4,5);
        //when
        boolean actual = boardManager.baseOnMastQuantityConfirmIfCanInsertShipRight(coordinate,4);
        //then
        Assertions.assertTrue(actual);
    }

    @Test
    void shouldReturnFalseIfCanNotMoveRight(){
        //given
        Coordinate coordinate = new Coordinate(7,5);
        //when
        boolean actual = boardManager.baseOnMastQuantityConfirmIfCanInsertShipRight(coordinate,4);
        //then
        Assertions.assertFalse(actual);
    }



}