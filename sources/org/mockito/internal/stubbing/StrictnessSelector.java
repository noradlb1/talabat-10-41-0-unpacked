package org.mockito.internal.stubbing;

import org.mockito.mock.MockCreationSettings;
import org.mockito.quality.Strictness;
import org.mockito.stubbing.Stubbing;

public final class StrictnessSelector {
    private StrictnessSelector() {
    }

    public static Strictness determineStrictness(Stubbing stubbing, MockCreationSettings mockCreationSettings, Strictness strictness) {
        if (stubbing != null && stubbing.getStrictness() != null) {
            return stubbing.getStrictness();
        }
        if (mockCreationSettings.isLenient()) {
            return Strictness.LENIENT;
        }
        return strictness;
    }
}
