package shared.performance;

public class PerformanceTest<T extends Runnable> {

    private T testTarget;

    public PerformanceTest(T testTarget) {
        this.testTarget = testTarget;
    }
}
