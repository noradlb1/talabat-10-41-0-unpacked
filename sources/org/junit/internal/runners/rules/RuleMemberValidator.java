package org.junit.internal.runners.rules;

import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.rules.MethodRule;
import org.junit.rules.TestRule;
import org.junit.runners.model.FrameworkMember;
import org.junit.runners.model.TestClass;

public class RuleMemberValidator {
    public static final RuleMemberValidator CLASS_RULE_METHOD_VALIDATOR = classRuleValidatorBuilder().e().f(new DeclaringClassMustBePublic()).f(new MemberMustBeStatic()).f(new MemberMustBePublic()).f(new MethodMustBeATestRule()).d();
    public static final RuleMemberValidator CLASS_RULE_VALIDATOR = classRuleValidatorBuilder().f(new DeclaringClassMustBePublic()).f(new MemberMustBeStatic()).f(new MemberMustBePublic()).f(new FieldMustBeATestRule()).d();
    public static final RuleMemberValidator RULE_METHOD_VALIDATOR = testRuleValidatorBuilder().e().f(new MemberMustBeNonStaticOrAlsoClassRule()).f(new MemberMustBePublic()).f(new MethodMustBeARule()).d();
    public static final RuleMemberValidator RULE_VALIDATOR = testRuleValidatorBuilder().f(new MemberMustBeNonStaticOrAlsoClassRule()).f(new MemberMustBePublic()).f(new FieldMustBeARule()).d();
    private final Class<? extends Annotation> annotation;
    private final boolean methods;
    private final List<RuleValidator> validatorStrategies;

    public static class Builder {
        /* access modifiers changed from: private */
        public final Class<? extends Annotation> annotation;
        /* access modifiers changed from: private */
        public boolean methods;
        /* access modifiers changed from: private */
        public final List<RuleValidator> validators;

        public RuleMemberValidator d() {
            return new RuleMemberValidator(this);
        }

        public Builder e() {
            this.methods = true;
            return this;
        }

        public Builder f(RuleValidator ruleValidator) {
            this.validators.add(ruleValidator);
            return this;
        }

        private Builder(Class<? extends Annotation> cls) {
            this.annotation = cls;
            this.methods = false;
            this.validators = new ArrayList();
        }
    }

    public static final class DeclaringClassMustBePublic implements RuleValidator {
        private DeclaringClassMustBePublic() {
        }

        private boolean isDeclaringClassPublic(FrameworkMember<?> frameworkMember) {
            return Modifier.isPublic(frameworkMember.getDeclaringClass().getModifiers());
        }

        public void validate(FrameworkMember<?> frameworkMember, Class<? extends Annotation> cls, List<Throwable> list) {
            if (!isDeclaringClassPublic(frameworkMember)) {
                list.add(new ValidationError(frameworkMember, cls, "must be declared in a public class."));
            }
        }
    }

    public static final class FieldMustBeARule implements RuleValidator {
        private FieldMustBeARule() {
        }

        public void validate(FrameworkMember<?> frameworkMember, Class<? extends Annotation> cls, List<Throwable> list) {
            if (!RuleMemberValidator.isRuleType(frameworkMember)) {
                list.add(new ValidationError(frameworkMember, cls, "must implement MethodRule or TestRule."));
            }
        }
    }

    public static final class FieldMustBeATestRule implements RuleValidator {
        private FieldMustBeATestRule() {
        }

        public void validate(FrameworkMember<?> frameworkMember, Class<? extends Annotation> cls, List<Throwable> list) {
            if (!RuleMemberValidator.isTestRule(frameworkMember)) {
                list.add(new ValidationError(frameworkMember, cls, "must implement TestRule."));
            }
        }
    }

    public static final class MemberMustBeNonStaticOrAlsoClassRule implements RuleValidator {
        private MemberMustBeNonStaticOrAlsoClassRule() {
        }

        public void validate(FrameworkMember<?> frameworkMember, Class<? extends Annotation> cls, List<Throwable> list) {
            boolean z11;
            String str;
            boolean a11 = RuleMemberValidator.isMethodRule(frameworkMember);
            if (frameworkMember.getAnnotation(ClassRule.class) != null) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!frameworkMember.isStatic()) {
                return;
            }
            if (a11 || !z11) {
                if (RuleMemberValidator.isMethodRule(frameworkMember)) {
                    str = "must not be static.";
                } else {
                    str = "must not be static or it must be annotated with @ClassRule.";
                }
                list.add(new ValidationError(frameworkMember, cls, str));
            }
        }
    }

    public static final class MemberMustBePublic implements RuleValidator {
        private MemberMustBePublic() {
        }

        public void validate(FrameworkMember<?> frameworkMember, Class<? extends Annotation> cls, List<Throwable> list) {
            if (!frameworkMember.isPublic()) {
                list.add(new ValidationError(frameworkMember, cls, "must be public."));
            }
        }
    }

    public static final class MemberMustBeStatic implements RuleValidator {
        private MemberMustBeStatic() {
        }

        public void validate(FrameworkMember<?> frameworkMember, Class<? extends Annotation> cls, List<Throwable> list) {
            if (!frameworkMember.isStatic()) {
                list.add(new ValidationError(frameworkMember, cls, "must be static."));
            }
        }
    }

    public static final class MethodMustBeARule implements RuleValidator {
        private MethodMustBeARule() {
        }

        public void validate(FrameworkMember<?> frameworkMember, Class<? extends Annotation> cls, List<Throwable> list) {
            if (!RuleMemberValidator.isRuleType(frameworkMember)) {
                list.add(new ValidationError(frameworkMember, cls, "must return an implementation of MethodRule or TestRule."));
            }
        }
    }

    public static final class MethodMustBeATestRule implements RuleValidator {
        private MethodMustBeATestRule() {
        }

        public void validate(FrameworkMember<?> frameworkMember, Class<? extends Annotation> cls, List<Throwable> list) {
            if (!RuleMemberValidator.isTestRule(frameworkMember)) {
                list.add(new ValidationError(frameworkMember, cls, "must return an implementation of TestRule."));
            }
        }
    }

    public interface RuleValidator {
        void validate(FrameworkMember<?> frameworkMember, Class<? extends Annotation> cls, List<Throwable> list);
    }

    public RuleMemberValidator(Builder builder) {
        this.annotation = builder.annotation;
        this.methods = builder.methods;
        this.validatorStrategies = builder.validators;
    }

    private static Builder classRuleValidatorBuilder() {
        return new Builder(ClassRule.class);
    }

    /* access modifiers changed from: private */
    public static boolean isMethodRule(FrameworkMember<?> frameworkMember) {
        return MethodRule.class.isAssignableFrom(frameworkMember.getType());
    }

    /* access modifiers changed from: private */
    public static boolean isRuleType(FrameworkMember<?> frameworkMember) {
        return isMethodRule(frameworkMember) || isTestRule(frameworkMember);
    }

    /* access modifiers changed from: private */
    public static boolean isTestRule(FrameworkMember<?> frameworkMember) {
        return TestRule.class.isAssignableFrom(frameworkMember.getType());
    }

    private static Builder testRuleValidatorBuilder() {
        return new Builder(Rule.class);
    }

    private void validateMember(FrameworkMember<?> frameworkMember, List<Throwable> list) {
        for (RuleValidator validate : this.validatorStrategies) {
            validate.validate(frameworkMember, this.annotation, list);
        }
    }

    public void validate(TestClass testClass, List<Throwable> list) {
        List<FrameworkMember> list2;
        if (this.methods) {
            list2 = testClass.getAnnotatedMethods(this.annotation);
        } else {
            list2 = testClass.getAnnotatedFields(this.annotation);
        }
        for (FrameworkMember validateMember : list2) {
            validateMember(validateMember, list);
        }
    }
}
