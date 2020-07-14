package ByteDance;

public class ByteDanceTest {
    public static void main(String[] args) {
        ByteDance test = new ByteDance();

        String formula = "K4(ON(SO3)2)2";

        String res = test.countOfAtoms(formula);
        System.out.println(res);
    }
}
