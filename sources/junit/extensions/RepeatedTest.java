package junit.extensions;

import junit.framework.Test;
import junit.framework.TestResult;

public class RepeatedTest extends TestDecorator {
    private int fTimesRepeat;

    public RepeatedTest(Test test, int i11) {
        super(test);
        if (i11 >= 0) {
            this.fTimesRepeat = i11;
            return;
        }
        throw new IllegalArgumentException("Repetition count must be >= 0");
    }

    public int countTestCases() {
        return super.countTestCases() * this.fTimesRepeat;
    }

    public void run(TestResult testResult) {
        for (int i11 = 0; i11 < this.fTimesRepeat && !testResult.shouldStop(); i11++) {
            super.run(testResult);
        }
    }

    public String toString() {
        return super.toString() + "(repeated)";
    }
}
