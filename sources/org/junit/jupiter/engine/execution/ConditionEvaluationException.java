package org.junit.jupiter.engine.execution;

import org.junit.platform.commons.JUnitException;

class ConditionEvaluationException extends JUnitException {
    private static final long serialVersionUID = 1;

    public ConditionEvaluationException(String str, Throwable th2) {
        super(str, th2);
    }
}
