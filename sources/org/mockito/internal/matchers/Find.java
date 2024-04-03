package org.mockito.internal.matchers;

import java.io.Serializable;
import java.util.regex.Pattern;
import org.mockito.ArgumentMatcher;

public class Find implements ArgumentMatcher<String>, Serializable {
    private final String regex;

    public Find(String str) {
        this.regex = str;
    }

    public String toString() {
        return "find(\"" + this.regex.replace("\\", "\\\\") + "\")";
    }

    public boolean matches(String str) {
        return str != null && Pattern.compile(this.regex).matcher(str).find();
    }
}
