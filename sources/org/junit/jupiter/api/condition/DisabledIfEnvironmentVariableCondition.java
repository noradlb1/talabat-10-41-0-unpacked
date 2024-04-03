package org.junit.jupiter.api.condition;

import j$.util.function.Supplier;
import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.platform.commons.util.Preconditions;

class DisabledIfEnvironmentVariableCondition extends AbstractRepeatableAnnotationCondition<DisabledIfEnvironmentVariable> {
    private static final ConditionEvaluationResult ENABLED = ConditionEvaluationResult.enabled("No @DisabledIfEnvironmentVariable conditions resulting in 'disabled' execution encountered");

    public DisabledIfEnvironmentVariableCondition() {
        super(DisabledIfEnvironmentVariable.class);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ String lambda$evaluate$0(DisabledIfEnvironmentVariable disabledIfEnvironmentVariable) {
        return "The 'named' attribute must not be blank in " + disabledIfEnvironmentVariable;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ String lambda$evaluate$1(DisabledIfEnvironmentVariable disabledIfEnvironmentVariable) {
        return "The 'matches' attribute must not be blank in " + disabledIfEnvironmentVariable;
    }

    public ConditionEvaluationResult d() {
        return ENABLED;
    }

    /* renamed from: g */
    public ConditionEvaluationResult c(DisabledIfEnvironmentVariable disabledIfEnvironmentVariable) {
        String trim = disabledIfEnvironmentVariable.named().trim();
        String matches = disabledIfEnvironmentVariable.matches();
        Preconditions.notBlank(trim, (Supplier<String>) new g(disabledIfEnvironmentVariable));
        Preconditions.notBlank(matches, (Supplier<String>) new h(disabledIfEnvironmentVariable));
        String h11 = h(trim);
        if (h11 == null) {
            return ConditionEvaluationResult.enabled(String.format("Environment variable [%s] does not exist", new Object[]{trim}));
        } else if (h11.matches(matches)) {
            return ConditionEvaluationResult.disabled(String.format("Environment variable [%s] with value [%s] matches regular expression [%s]", new Object[]{trim, h11, matches}), disabledIfEnvironmentVariable.disabledReason());
        } else {
            return ConditionEvaluationResult.enabled(String.format("Environment variable [%s] with value [%s] does not match regular expression [%s]", new Object[]{trim, h11, matches}));
        }
    }

    public String h(String str) {
        return System.getenv(str);
    }
}
