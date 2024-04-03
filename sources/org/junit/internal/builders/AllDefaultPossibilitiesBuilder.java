package org.junit.internal.builders;

import java.util.Arrays;
import org.junit.runner.Runner;
import org.junit.runners.model.RunnerBuilder;

public class AllDefaultPossibilitiesBuilder extends RunnerBuilder {
    private final boolean canUseSuiteMethod;

    public AllDefaultPossibilitiesBuilder(boolean z11) {
        this.canUseSuiteMethod = z11;
    }

    public AnnotatedBuilder c() {
        return new AnnotatedBuilder(this);
    }

    public IgnoredBuilder d() {
        return new IgnoredBuilder();
    }

    public JUnit3Builder e() {
        return new JUnit3Builder();
    }

    public JUnit4Builder f() {
        return new JUnit4Builder();
    }

    public RunnerBuilder g() {
        if (this.canUseSuiteMethod) {
            return new SuiteMethodBuilder();
        }
        return new NullBuilder();
    }

    public Runner runnerForClass(Class<?> cls) throws Throwable {
        for (RunnerBuilder safeRunnerForClass : Arrays.asList(new RunnerBuilder[]{d(), c(), g(), e(), f()})) {
            Runner safeRunnerForClass2 = safeRunnerForClass.safeRunnerForClass(cls);
            if (safeRunnerForClass2 != null) {
                return safeRunnerForClass2;
            }
        }
        return null;
    }
}
