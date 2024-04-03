package org.mockito.internal.junit;

import org.apache.commons.lang3.StringUtils;

class StubbingHint {
    private final StringBuilder hint;

    public StubbingHint(String str) {
        StringBuilder sb2 = new StringBuilder("[MockitoHint] ");
        sb2.append(str);
        sb2.append(" (see javadoc for MockitoHint):");
        this.hint = sb2;
    }

    public void a(Object... objArr) {
        this.hint.append("\n[MockitoHint] ");
        for (Object append : objArr) {
            this.hint.append(append);
        }
    }

    public String toString() {
        return this.hint + StringUtils.LF;
    }
}
