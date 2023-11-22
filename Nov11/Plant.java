package Nov11;

public class Plant {
    public void print() {
        System.out.println("Plant is blooming");
    }
}

public class Flower extends Plant {
    public void print() {
        System.out.println("Flower is blooming");
    }
}

public class Fruit extends Plant {
    public void print() {
        System.out.println("Fruit is blooming");
    }
}
