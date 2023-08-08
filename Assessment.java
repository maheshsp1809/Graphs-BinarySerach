interface Calculate {
    void cal(int item);
}

class DispA implements Calculate {
    int z;

    public void cal(int item) {
        z = item / item;
    }
}

class DispB implements Calculate {
    int z;

    public void cal(int item) {
        z = item - item;
    }
}

public class Assessment {
    public static void main(String args[]) {
        DispA a1 = new DispA();
        DispB a2 = new DispB();

        a2.cal(0);
        a1.cal(1);

        System.out.print(a2.z + "*" + 22);
    }
}
