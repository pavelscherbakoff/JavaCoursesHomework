package _07_dog_moods;

public class BadMood implements BrainState {

    @Override
    public void feed(Dog dog) {
        dog.eat();
        dog.brainState = new GoodMood();
    }

    @Override
    public void stroke(Dog dog) {
        dog.bite();
    }

}