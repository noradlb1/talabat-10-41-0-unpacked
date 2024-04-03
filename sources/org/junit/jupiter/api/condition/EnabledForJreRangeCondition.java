package org.junit.jupiter.api.condition;

import org.junit.platform.commons.util.Preconditions;
import y20.i;

class EnabledForJreRangeCondition extends BooleanExecutionCondition<EnabledForJreRange> {
    public EnabledForJreRangeCondition() {
        super(EnabledForJreRange.class, EnabledOnJreCondition.f57111a, EnabledOnJreCondition.f57112b, new i());
    }

    /* renamed from: d */
    public boolean c(EnabledForJreRange enabledForJreRange) {
        boolean z11;
        JRE min = enabledForJreRange.min();
        JRE max = enabledForJreRange.max();
        boolean z12 = false;
        if (min == JRE.JAVA_8 && max == JRE.OTHER) {
            z11 = false;
        } else {
            z11 = true;
        }
        Preconditions.condition(z11, "You must declare a non-default value for min or max in @EnabledForJreRange");
        if (max.compareTo(min) >= 0) {
            z12 = true;
        }
        Preconditions.condition(z12, "@EnabledForJreRange.min must be less than or equal to @EnabledForJreRange.max");
        return JRE.c(min, max);
    }
}
