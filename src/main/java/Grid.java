import java.util.List;

public class Grid {

    private Square[][] board;
    private List<Square> aliveSquares;
    private List<Square> deadSquares;

    int WIDTH = 30;
    int HEIGHT = 30;

    /**
     * for GardenView
     */
    public List<Square> getAliveSquares() {
        return aliveSquares;
    }

    /**
     * for GardenView
     */
    public List<Square> getDeadSquares() {
        return deadSquares;
    }

    /**
     * for the MouseKeyListener
     */
    public void toggleSquare(int x, int y) {
        this.board[x][y].toggleSquare();
    }

    /**
     * for the "next generation" button.
     */
    public void nextGeneration() {
        Square[][] newBoard = new Square[WIDTH][HEIGHT];
        aliveSquares.clear();
        deadSquares.clear();

        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                Square square = board[x][y];
                newBoard[x][y] = setSquare(square);
            }
        }

        this.board = newBoard;
    }

    private Square setSquare(Square square) {
        int numAliveNeighbours = countAliveNeighbours(square);

        if (square.isAlive()) { //if current square is alive
            if (numAliveNeighbours == 2 || numAliveNeighbours == 3) {
                aliveSquares.add(square);
                square.setAlive();
            } else {
                deadSquares.add(square);
                square.setDead();
            }
        } else { //if current square is dead
            if (numAliveNeighbours == 3) {
                aliveSquares.add(square);
                square.setAlive();
            }
        }

        return square;
    }

    private int countAliveNeighbours(Square square) {
        int numNeighborsAlive = 0;
        Square[] neighborsToCheck = getNeighbors(square);
        for ( Square s : neighborsToCheck) {
            if (s.isAlive()) {
                numNeighborsAlive++;
            }
        }
        return numNeighborsAlive;
    }

    private Square[] getNeighbors(Square square) {
        return new Square[] {this.board[square.getX()][square.getY() - 1], //North
                this.board[square.getX() + 1][square.getY() - 1], //NorthEast
                this.board[square.getX() + 1][square.getY()], //East
                this.board[square.getX() + 1][square.getY() + 1], //SouthEast
                this.board[square.getX()][square.getY() + 1], //South
                this.board[square.getX() - 1][square.getY() + 1], //SouthWest
                this.board[square.getX() - 1][square.getY()], //West
                this.board[square.getX() + 1][square.getY() - 1]}; //NorthWest
    }

}

//Don't forget Test