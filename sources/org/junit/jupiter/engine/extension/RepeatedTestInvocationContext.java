package org.junit.jupiter.engine.extension;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.extension.Extension;
import org.junit.jupiter.api.extension.TestTemplateInvocationContext;

class RepeatedTestInvocationContext implements TestTemplateInvocationContext {
    private final int currentRepetition;
    private final RepeatedTestDisplayNameFormatter formatter;
    private final int totalRepetitions;

    public RepeatedTestInvocationContext(int i11, int i12, RepeatedTestDisplayNameFormatter repeatedTestDisplayNameFormatter) {
        this.currentRepetition = i11;
        this.totalRepetitions = i12;
        this.formatter = repeatedTestDisplayNameFormatter;
    }

    public List<Extension> getAdditionalExtensions() {
        return Collections.singletonList(new RepetitionInfoParameterResolver(this.currentRepetition, this.totalRepetitions));
    }

    public String getDisplayName(int i11) {
        return this.formatter.a(this.currentRepetition, this.totalRepetitions);
    }
}
