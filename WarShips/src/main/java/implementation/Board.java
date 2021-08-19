package implementation;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Board {

    private int[][] tab;

    static final int SIZE = 10;

    Coordinate coordinate;

    public Board() {
        tab = new int[SIZE][SIZE];
    }
    public BoardIterator createIterator(){
        return new BoardIterator();
    }

    public void setElementAt(int i, Coordinate coordinate){
        tab[coordinate.getX()][coordinate.getY()] = i;
    }

    public int getElementAt(Coordinate coordinate){
        return tab[coordinate.getX()][coordinate.getY()];
    }

    class BoardIterator implements Iterator<Coordinate> {

        Coordinate currentCoordinate = new Coordinate(-1, 0);

        @Override
        public boolean hasNext() {
            return currentCoordinate.canMoveRight() || currentCoordinate.canMoveDown();
        }

        @Override
        public Coordinate next() {
            if(hasNext()){
                if (currentCoordinate.canMoveRight()) {
                    currentCoordinate.setX(currentCoordinate.getX()+1);
                }
                else{
                    if(currentCoordinate.canMoveDown()) {
                        currentCoordinate.setX(0);
                        currentCoordinate.setY(currentCoordinate.getY() + 1);
                    }
                }
                return currentCoordinate;
            }
            throw new NoSuchElementException("end of board");
        }
    }


}
