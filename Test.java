public class Test {
    public static void main(String args[]) {
        int hitVal = 30;

        switch (hitVal) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                hitVal = 9;
                System.out.println("Single");
                System.out.println("hi");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("Double");
                break;
            case 15:
            case 16:
                System.out.println("Triple");
                break;
            default:
                System.out.println("Home Run");
                break;
        }
    }
}
