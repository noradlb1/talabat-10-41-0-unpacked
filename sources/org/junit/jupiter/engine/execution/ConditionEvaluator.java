package org.junit.jupiter.engine.execution;

import f30.a;
import f30.b;
import org.apiguardian.api.API;
import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.engine.config.JupiterConfiguration;
import org.junit.jupiter.engine.extension.ExtensionRegistry;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.junit.platform.commons.util.StringUtils;

@API(since = "5.0", status = API.Status.INTERNAL)
public class ConditionEvaluator {
    private static final ConditionEvaluationResult ENABLED = ConditionEvaluationResult.enabled("No 'disabled' conditions encountered");
    private static final Logger logger = LoggerFactory.getLogger(ConditionEvaluator.class);

    private ConditionEvaluationException evaluationException(Class<?> cls, Exception exc) {
        String str;
        if (StringUtils.isNotBlank(exc.getMessage())) {
            str = ": " + exc.getMessage();
        } else {
            str = "";
        }
        return new ConditionEvaluationException(String.format("Failed to evaluate condition [%s]%s", new Object[]{cls.getName(), str}), exc);
    }

    private void logResult(Class<?> cls, ConditionEvaluationResult conditionEvaluationResult, ExtensionContext extensionContext) {
        logger.trace(new a(cls, extensionContext, conditionEvaluationResult));
    }

    public ConditionEvaluationResult evaluate(ExtensionRegistry extensionRegistry, JupiterConfiguration jupiterConfiguration, ExtensionContext extensionContext) {
        return (ConditionEvaluationResult) extensionRegistry.stream(ExecutionCondition.class).filter(jupiterConfiguration.getExecutionConditionFilter()).map(new b(this, extensionContext)).filter(new y20.a()).findFirst().orElse(ENABLED);
    }

    /* access modifiers changed from: private */
    /* renamed from: evaluate */
    public ConditionEvaluationResult lambda$evaluate$0(ExecutionCondition executionCondition, ExtensionContext extensionContext) {
        try {
            ConditionEvaluationResult evaluateExecutionCondition = executionCondition.evaluateExecutionCondition(extensionContext);
            logResult(executionCondition.getClass(), evaluateExecutionCondition, extensionContext);
            return evaluateExecutionCondition;
        } catch (Exception e11) {
            throw evaluationException(executionCondition.getClass(), e11);
        }
    }
}
