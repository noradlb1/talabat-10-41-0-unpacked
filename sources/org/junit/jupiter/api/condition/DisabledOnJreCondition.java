package org.junit.jupiter.api.condition;

import j$.util.DesugarArrays;
import org.junit.platform.commons.util.Preconditions;
import y20.e;
import y20.f;

class DisabledOnJreCondition extends BooleanExecutionCondition<DisabledOnJre> {
    public DisabledOnJreCondition() {
        super(DisabledOnJre.class, EnabledOnJreCondition.f57111a, EnabledOnJreCondition.f57112b, new e());
    }

    /* renamed from: d */
    public boolean c(DisabledOnJre disabledOnJre) {
        boolean z11;
        JRE[] value = disabledOnJre.value();
        if (value.length > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.condition(z11, "You must declare at least one JRE in @DisabledOnJre");
        return DesugarArrays.stream((T[]) value).noneMatch(new f());
    }
}
