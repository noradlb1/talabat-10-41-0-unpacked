package org.junit.jupiter.api.condition;

import j$.util.function.Supplier;
import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.platform.commons.util.Preconditions;

class DisabledIfSystemPropertyCondition extends AbstractRepeatableAnnotationCondition<DisabledIfSystemProperty> {
    private static final ConditionEvaluationResult ENABLED = ConditionEvaluationResult.enabled("No @DisabledIfSystemProperty conditions resulting in 'disabled' execution encountered");

    public DisabledIfSystemPropertyCondition() {
        super(DisabledIfSystemProperty.class);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ String lambda$evaluate$0(DisabledIfSystemProperty disabledIfSystemProperty) {
        return "The 'named' attribute must not be blank in " + disabledIfSystemProperty;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ String lambda$evaluate$1(DisabledIfSystemProperty disabledIfSystemProperty) {
        return "The 'matches' attribute must not be blank in " + disabledIfSystemProperty;
    }

    public ConditionEvaluationResult d() {
        return ENABLED;
    }

    /* renamed from: g */
    public ConditionEvaluationResult c(DisabledIfSystemProperty disabledIfSystemProperty) {
        String trim = disabledIfSystemProperty.named().trim();
        String matches = disabledIfSystemProperty.matches();
        Preconditions.notBlank(trim, (Supplier<String>) new i(disabledIfSystemProperty));
        Preconditions.notBlank(matches, (Supplier<String>) new j(disabledIfSystemProperty));
        String property = System.getProperty(trim);
        if (property == null) {
            return ConditionEvaluationResult.enabled(String.format("System property [%s] does not exist", new Object[]{trim}));
        } else if (property.matches(matches)) {
            return ConditionEvaluationResult.disabled(String.format("System property [%s] with value [%s] matches regular expression [%s]", new Object[]{trim, property, matches}), disabledIfSystemProperty.disabledReason());
        } else {
            return ConditionEvaluationResult.enabled(String.format("System property [%s] with value [%s] does not match regular expression [%s]", new Object[]{trim, property, matches}));
        }
    }
}
