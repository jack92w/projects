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

    /**
     * sets number at coordinate
     * @param i number to be set
     * @param coordinate for number to be set
     */
    public void setNumberAt(int i, Coordinate coordinate){
        this.tab[coordinate.getX()][coordinate.getY()] = i;
    }

    /**
     * gets number from coordinate
     * @param coordinate - number localization
     * @return number from coordinate
     */
    public int getNumberAt(Coordinate coordinate){
        return this.tab[coordinate.getX()][coordinate.getY()];
    }

    static class BoardIterator implements Iterator<Coordinate> {

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
