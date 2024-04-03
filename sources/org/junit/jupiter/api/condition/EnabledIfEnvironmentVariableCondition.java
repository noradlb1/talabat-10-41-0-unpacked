package org.junit.jupiter.api.condition;

import j$.util.function.Supplier;
import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.platform.commons.util.Preconditions;

class EnabledIfEnvironmentVariableCondition extends AbstractRepeatableAnnotationCondition<EnabledIfEnvironmentVariable> {
    private static final ConditionEvaluationResult ENABLED = ConditionEvaluationResult.enabled("No @EnabledIfEnvironmentVariable conditions resulting in 'disabled' execution encountered");

    public EnabledIfEnvironmentVariableCondition() {
        super(EnabledIfEnvironmentVariable.class);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ String lambda$evaluate$0(EnabledIfEnvironmentVariable enabledIfEnvironmentVariable) {
        return "The 'named' attribute must not be blank in " + enabledIfEnvironmentVariable;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ String lambda$evaluate$1(EnabledIfEnvironmentVariable enabledIfEnvironmentVariable) {
        return "The 'matches' attribute must not be blank in " + enabledIfEnvironmentVariable;
    }

    public ConditionEvaluationResult d() {
        return ENABLED;
    }

    /* renamed from: g */
    public ConditionEvaluationResult c(EnabledIfEnvironmentVariable enabledIfEnvironmentVariable) {
        String trim = enabledIfEnvironmentVariable.named().trim();
        String matches = enabledIfEnvironmentVariable.matches();
        Preconditions.notBlank(trim, (Supplier<String>) new k(enabledIfEnvironmentVariable));
        Preconditions.notBlank(matches, (Supplier<String>) new l(enabledIfEnvironmentVariable));
        String h11 = h(trim);
        if (h11 == null) {
            return ConditionEvaluationResult.disabled(String.format("Environment variable [%s] does not exist", new Object[]{trim}), enabledIfEnvironmentVariable.disabledReason());
        } else if (h11.matches(matches)) {
            return ConditionEvaluationResult.enabled(String.format("Environment variable [%s] with value [%s] matches regular expression [%s]", new Object[]{trim, h11, matches}));
        } else {
            return ConditionEvaluationResult.disabled(String.format("Environment variable [%s] with value [%s] does not match regular expression [%s]", new Object[]{trim, h11, matches}), enabledIfEnvironmentVariable.disabledReason());
        }
    }

    public String h(String str) {
        return System.getenv(str);
    }
}
