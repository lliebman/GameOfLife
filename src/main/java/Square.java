public class Square {
        private final int x;
        private final int y;
        private boolean alive;

        public Square(Square square) {
            this.x = square.x;
            this.y = square.y;
        }

        public Square(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void setAlive(){
            alive = true;
        }

        public void setDead(){
            alive = false;
        }

        public boolean aliveStatus() {
            return alive;
        }

}
