package _2_inheritance_examples.multiple_by_interfaces;

public class AutomationTesterImpl implements AutomationTester {

    @Override
    public void develop(String subj) {
        System.out.println("Developing " + subj);
    }

    @Override
    public void test(String subj) {
        System.out.println("Testing " + subj);
    }

    @Override
    public void debugTestScripts() {
        System.out.println("Debugging test scripts");
    }

    public static void main(String[] args) {
        AutomationTester autoTester = new AutomationTesterImpl();
        autoTester.test("feature");
        autoTester.develop("test scripts for feature");
        autoTester.debugTestScripts();
    }
}
