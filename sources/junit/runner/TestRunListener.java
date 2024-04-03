package junit.runner;

public interface TestRunListener {
    public static final int STATUS_ERROR = 1;
    public static final int STATUS_FAILURE = 2;

    void testEnded(String str);

    void testFailed(int i11, String str, String str2);

    void testRunEnded(long j11);

    void testRunStarted(String str, int i11);

    void testRunStopped(long j11);

    void testStarted(String str);
}
