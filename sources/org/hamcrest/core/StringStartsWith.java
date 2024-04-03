package org.hamcrest.core;

import org.hamcrest.Factory;
import org.hamcrest.Matcher;

public class StringStartsWith extends SubstringMatcher {
    public StringStartsWith(String str) {
        super(str);
    }

    @Factory
    public static Matcher<String> startsWith(String str) {
        return new StringStartsWith(str);
    }

    public boolean a(String str) {
        return str.startsWith(this.f27965b);
    }

    public String b() {
        return "starting with";
    }
}
