package org.junit.jupiter.api.condition;

import j$.util.DesugarArrays;
import j$.util.stream.Stream;
import java.util.Objects;
import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.platform.commons.util.Preconditions;
import y20.g;
import y20.h;

class EnabledOnOsCondition extends AbstractOsBasedExecutionCondition<EnabledOnOs> {
    public EnabledOnOsCondition() {
        super(EnabledOnOs.class);
    }

    private boolean isEnabledBasedOnArchitecture(EnabledOnOs enabledOnOs) {
        String[] architectures = enabledOnOs.architectures();
        if (architectures.length == 0) {
            return true;
        }
        Stream stream = DesugarArrays.stream((T[]) architectures);
        String str = AbstractOsBasedExecutionCondition.f57109a;
        Objects.requireNonNull(str);
        return stream.anyMatch(new h(str));
    }

    private boolean isEnabledBasedOnOs(EnabledOnOs enabledOnOs) {
        OS[] value = enabledOnOs.value();
        if (value.length == 0) {
            return true;
        }
        return DesugarArrays.stream((T[]) value).anyMatch(new g());
    }

    /* renamed from: d */
    public ConditionEvaluationResult c(EnabledOnOs enabledOnOs) {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14 = true;
        if (enabledOnOs.value().length > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (enabledOnOs.architectures().length > 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z11 || z12) {
            z13 = true;
        } else {
            z13 = false;
        }
        Preconditions.condition(z13, "You must declare at least one OS or architecture in @EnabledOnOs");
        if (!isEnabledBasedOnOs(enabledOnOs) || !isEnabledBasedOnArchitecture(enabledOnOs)) {
            z14 = false;
        }
        String b11 = b(z14, z11, z12);
        if (z14) {
            return ConditionEvaluationResult.enabled(b11);
        }
        return ConditionEvaluationResult.disabled(b11, enabledOnOs.disabledReason());
    }
}
