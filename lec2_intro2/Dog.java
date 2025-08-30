package lec2_intro2;

public class Dog {
    public int weightInPounds;
    public static String binomen = "Canis familiaris";

    /* constructor for Dogs, similar to __init__
       in Python
     */
    public Dog(int weight) {
        this.weightInPounds = weight;
    }

    public void makeNoise() {
        if (weightInPounds < 10) {
            System.out.println("yip yip");
        } else if (weightInPounds < 30) {
            System.out.println("bark");
        } else {
            System.out.println("arooooooooooooo");
        }
    }

    /** Returns the bigger dog of two dogs d1 and d2 */
    public static Dog maxDog(Dog d1, Dog d2) {
        if (d1.weightInPounds > d2.weightInPounds){
            return d1;
        }
        return d2;
    }

    /* Compare other dog to me and return the larger. */
    public Dog maxDog(Dog otherDog) {
        if (weightInPounds > otherDog.weightInPounds) {
            return this;
        }
        return otherDog;
    }
}
