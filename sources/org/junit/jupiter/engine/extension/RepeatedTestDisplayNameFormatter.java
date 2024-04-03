package org.junit.jupiter.engine.extension;

import org.junit.jupiter.api.RepeatedTest;

class RepeatedTestDisplayNameFormatter {
    private final String displayName;
    private final String pattern;

    public RepeatedTestDisplayNameFormatter(String str, String str2) {
        this.pattern = str;
        this.displayName = str2;
    }

    public String a(int i11, int i12) {
        return this.pattern.replace(RepeatedTest.DISPLAY_NAME_PLACEHOLDER, this.displayName).replace(RepeatedTest.CURRENT_REPETITION_PLACEHOLDER, String.valueOf(i11)).replace(RepeatedTest.TOTAL_REPETITIONS_PLACEHOLDER, String.valueOf(i12));
    }
}
