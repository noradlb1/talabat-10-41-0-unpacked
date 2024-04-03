package org.mockito.internal.stubbing;

import org.mockito.quality.Strictness;
import org.mockito.stubbing.Stubbing;

public final class UnusedStubbingReporting {
    private UnusedStubbingReporting() {
    }

    public static boolean shouldBeReported(Stubbing stubbing) {
        return !stubbing.wasUsed() && stubbing.getStrictness() != Strictness.LENIENT;
    }
}
