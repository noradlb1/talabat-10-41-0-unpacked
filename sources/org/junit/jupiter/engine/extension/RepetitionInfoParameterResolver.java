package org.junit.jupiter.engine.extension;

import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.junit.platform.commons.util.ToStringBuilder;

class RepetitionInfoParameterResolver implements ParameterResolver {
    private final int currentRepetition;
    private final int totalRepetitions;

    public static class DefaultRepetitionInfo implements RepetitionInfo {
        private final int currentRepetition;
        private final int totalRepetitions;

        public DefaultRepetitionInfo(int i11, int i12) {
            this.currentRepetition = i11;
            this.totalRepetitions = i12;
        }

        public int getCurrentRepetition() {
            return this.currentRepetition;
        }

        public int getTotalRepetitions() {
            return this.totalRepetitions;
        }

        public String toString() {
            return new ToStringBuilder((Object) this).append("currentRepetition", Integer.valueOf(this.currentRepetition)).append("totalRepetitions", Integer.valueOf(this.totalRepetitions)).toString();
        }
    }

    public RepetitionInfoParameterResolver(int i11, int i12) {
        this.currentRepetition = i11;
        this.totalRepetitions = i12;
    }

    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
        return parameterContext.getParameter().getType() == RepetitionInfo.class;
    }

    public RepetitionInfo resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
        return new DefaultRepetitionInfo(this.currentRepetition, this.totalRepetitions);
    }
}
