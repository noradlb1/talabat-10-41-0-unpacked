package org.mockito.internal.matchers;

import java.io.Serializable;
import org.mockito.ArgumentMatcher;

public class EndsWith implements ArgumentMatcher<String>, Serializable {
    private final String suffix;

    public EndsWith(String str) {
        this.suffix = str;
    }

    public String toString() {
        return "endsWith(\"" + this.suffix + "\")";
    }

    public boolean matches(String str) {
        return str != null && str.endsWith(this.suffix);
    }
}
