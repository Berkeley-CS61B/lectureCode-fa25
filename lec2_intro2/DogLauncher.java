package lec2_intro2;

public class DogLauncher {
    public static void main(String[] args) {
        Dog maya = new Dog(100);

        Dog lilDog = new Dog(5);

        // use the non-static maxDog
        maya.maxDog(lilDog);
        lilDog.maxDog(maya);
        Dog.maxDog(lilDog, maya);

    }
}
