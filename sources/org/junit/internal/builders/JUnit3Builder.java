package org.junit.internal.builders;

import junit.framework.TestCase;
import org.junit.internal.runners.JUnit38ClassRunner;
import org.junit.runner.Runner;
import org.junit.runners.model.RunnerBuilder;

public class JUnit3Builder extends RunnerBuilder {
    public boolean c(Class<?> cls) {
        return TestCase.class.isAssignableFrom(cls);
    }

    public Runner runnerForClass(Class<?> cls) throws Throwable {
        if (c(cls)) {
            return new JUnit38ClassRunner(cls);
        }
        return null;
    }
}
