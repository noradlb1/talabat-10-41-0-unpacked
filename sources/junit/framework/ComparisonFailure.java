package junit.framework;

public class ComparisonFailure extends AssertionFailedError {
    private static final int MAX_CONTEXT_LENGTH = 20;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ int f23716b = 0;
    private static final long serialVersionUID = 1;
    private String fActual;
    private String fExpected;

    public ComparisonFailure(String str, String str2, String str3) {
        super(str);
        this.fExpected = str2;
        this.fActual = str3;
    }

    public String getActual() {
        return this.fActual;
    }

    public String getExpected() {
        return this.fExpected;
    }

    public String getMessage() {
        return new ComparisonCompactor(20, this.fExpected, this.fActual).compact(super.getMessage());
    }
}
