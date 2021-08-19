package implementation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

}