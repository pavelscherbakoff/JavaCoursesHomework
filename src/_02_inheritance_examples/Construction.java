package _02_inheritance_examples;

public class Construction {

    static class Game {

        int score;

        public Game() {
            score = 0;
        }

        public void goal() {
            System.out.println("Goal");
            score++;
        }

        public void getScore() {
            System.out.println("Score = " + score);
        }
    }

    static class Basketball extends Game {

        @Override
        public void goal() {
            System.out.println("Goal");
            score+=2;
        }

    }

    public static void main(String[] args) {
        Game basketball = new Basketball();
        basketball.goal();
        basketball.getScore();
    }

}