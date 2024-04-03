package org.hamcrest.core;

import org.hamcrest.Factory;
import org.hamcrest.Matcher;

public class StringEndsWith extends SubstringMatcher {
    public StringEndsWith(String str) {
        super(str);
    }

    @Factory
    public static Matcher<String> endsWith(String str) {
        return new StringEndsWith(str);
    }

    public boolean a(String str) {
        return str.endsWith(this.f27965b);
    }

    public String b() {
        return "ending with";
    }
}
