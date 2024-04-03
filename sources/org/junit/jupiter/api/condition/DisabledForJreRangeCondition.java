package org.junit.jupiter.api.condition;

import org.junit.platform.commons.util.Preconditions;
import y20.b;

class DisabledForJreRangeCondition extends BooleanExecutionCondition<DisabledForJreRange> {
    public DisabledForJreRangeCondition() {
        super(DisabledForJreRange.class, EnabledOnJreCondition.f57111a, EnabledOnJreCondition.f57112b, new b());
    }

    /* renamed from: d */
    public boolean c(DisabledForJreRange disabledForJreRange) {
        boolean z11;
        JRE min = disabledForJreRange.min();
        JRE max = disabledForJreRange.max();
        boolean z12 = false;
        if (min == JRE.JAVA_8 && max == JRE.OTHER) {
            z11 = false;
        } else {
            z11 = true;
        }
        Preconditions.condition(z11, "You must declare a non-default value for min or max in @DisabledForJreRange");
        if (max.compareTo(min) >= 0) {
            z12 = true;
        }
        Preconditions.condition(z12, "@DisabledForJreRange.min must be less than or equal to @DisabledForJreRange.max");
        return !JRE.c(min, max);
    }
}
