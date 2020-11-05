public class Square {
        private final int x;
        private final int y;
        private boolean isAlive;

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
            isAlive = true;
        }

        public void setDead(){
            isAlive = false;
        }

        public boolean isAlive() {
            return isAlive;
        }

}
