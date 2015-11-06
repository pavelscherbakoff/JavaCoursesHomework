package _07_dog_moods;

public class Dog {

    BrainState brainState = new BadMood();

    public void feed() {
        System.out.println("--> feed dog");
        brainState.feed(this);
    }

    public void stroke() {
        System.out.println("--> stroke dog");
        brainState.stroke(this);
    }

    public void bite() {
        System.out.println("bites");
    }

    public void bark() {
        System.out.println("barks");
    }

    public void eat() {
        System.out.println("eats");
    }

    public void wag() {
        System.out.println("wags");
    }


}