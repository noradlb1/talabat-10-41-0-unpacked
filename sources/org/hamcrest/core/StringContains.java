package org.hamcrest.core;

import org.hamcrest.Factory;
import org.hamcrest.Matcher;

public class StringContains extends SubstringMatcher {
    public StringContains(String str) {
        super(str);
    }

    @Factory
    public static Matcher<String> containsString(String str) {
        return new StringContains(str);
    }

    public boolean a(String str) {
        return str.indexOf(this.f27965b) >= 0;
    }

    public String b() {
        return "containing";
    }
}
