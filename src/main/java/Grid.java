public class Grid {

    public Square[][] board;
    int width;
    int height;

    public void nextGeneration() {
        Square[][] newBoard = null;

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Square square = board[x][y];
                assert false;
                newBoard[x][y] = setSquare(square);
            }
        }

        this.board = newBoard;
    }

    private Square setSquare(Square square) {
        int numAliveNeighbours = countAliveNeighbours(square);

        if (square.isAlive()) { //current square is alive
            if (numAliveNeighbours == 2 || numAliveNeighbours == 3) {
                square.setAlive();
            } else {
                square.setDead();
            }
        } else { //current square is dead
            if (numAliveNeighbours == 3) {
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
        Square[] neighbors = new Square[8];


        return neighbors;
    }

}

//Don't forget Test