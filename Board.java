public class Board {
    int pieces;
    int randomInt = 51;

    public Board () {
        displayPieces();
    }

    public void populate (){
        while (randomInt > 50) {
            randomInt = (int) (((Math.random()/2) + .1) * 100);
        }
        pieces = randomInt;
    }

    public void subtractPieces(int piecesTakenAway) {
        pieces -= piecesTakenAway;
    }

    public String displayPieces() {
        return "There are " + pieces + " on the board";
    }

}
