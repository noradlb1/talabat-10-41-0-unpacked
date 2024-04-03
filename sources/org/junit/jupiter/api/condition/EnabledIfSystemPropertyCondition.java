package org.junit.jupiter.api.condition;

import j$.util.function.Supplier;
import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.platform.commons.util.Preconditions;

class EnabledIfSystemPropertyCondition extends AbstractRepeatableAnnotationCondition<EnabledIfSystemProperty> {
    private static final ConditionEvaluationResult ENABLED = ConditionEvaluationResult.enabled("No @EnabledIfSystemProperty conditions resulting in 'disabled' execution encountered");

    public EnabledIfSystemPropertyCondition() {
        super(EnabledIfSystemProperty.class);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ String lambda$evaluate$0(EnabledIfSystemProperty enabledIfSystemProperty) {
        return "The 'named' attribute must not be blank in " + enabledIfSystemProperty;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ String lambda$evaluate$1(EnabledIfSystemProperty enabledIfSystemProperty) {
        return "The 'matches' attribute must not be blank in " + enabledIfSystemProperty;
    }

    public ConditionEvaluationResult d() {
        return ENABLED;
    }

    /* renamed from: g */
    public ConditionEvaluationResult c(EnabledIfSystemProperty enabledIfSystemProperty) {
        String trim = enabledIfSystemProperty.named().trim();
        String matches = enabledIfSystemProperty.matches();
        Preconditions.notBlank(trim, (Supplier<String>) new m(enabledIfSystemProperty));
        Preconditions.notBlank(matches, (Supplier<String>) new n(enabledIfSystemProperty));
        String property = System.getProperty(trim);
        if (property == null) {
            return ConditionEvaluationResult.disabled(String.format("System property [%s] does not exist", new Object[]{trim}), enabledIfSystemProperty.disabledReason());
        } else if (property.matches(matches)) {
            return ConditionEvaluationResult.enabled(String.format("System property [%s] with value [%s] matches regular expression [%s]", new Object[]{trim, property, matches}));
        } else {
            return ConditionEvaluationResult.disabled(String.format("System property [%s] with value [%s] does not match regular expression [%s]", new Object[]{trim, property, matches}), enabledIfSystemProperty.disabledReason());
        }
    }
}
