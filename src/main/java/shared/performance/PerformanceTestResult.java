package shared.performance;

import java.util.concurrent.TimeUnit;

public class PerformanceTestResult {

    private int execTimeSeconds;
    private long execTimeMillis, execTimeNano;

    public PerformanceTestResult(int execTimeSeconds, long execTimeMillis, long execTimeNano) {
        this.execTimeSeconds = execTimeSeconds;
        this.execTimeMillis = execTimeMillis;
        this.execTimeNano = execTimeNano;
    }

    public static PerformanceTestResult parse(long execStartTime, long execEndTime) {
        long execTimeNano = execEndTime - execStartTime;
        return new PerformanceTestResult((int)TimeUnit.NANOSECONDS.toSeconds(execTimeNano), TimeUnit.NANOSECONDS.toMillis(execTimeNano), execTimeNano);
    }

    public int getExecTimeSeconds() {
        return execTimeSeconds;
    }

    public long getExecTimeMillis() {
        return execTimeMillis;
    }

    public long getExecTimeNano() {
        return execTimeNano;
    }
}
