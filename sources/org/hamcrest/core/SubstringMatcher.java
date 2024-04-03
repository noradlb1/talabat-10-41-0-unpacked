package org.hamcrest.core;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public abstract class SubstringMatcher extends TypeSafeMatcher<String> {

    /* renamed from: b  reason: collision with root package name */
    public final String f27965b;

    public SubstringMatcher(String str) {
        this.f27965b = str;
    }

    public abstract boolean a(String str);

    public abstract String b();

    public void describeTo(Description description) {
        description.appendText("a string ").appendText(b()).appendText(" ").appendValue(this.f27965b);
    }

    public void describeMismatchSafely(String str, Description description) {
        description.appendText("was \"").appendText(str).appendText("\"");
    }

    public boolean matchesSafely(String str) {
        return a(str);
    }
}
