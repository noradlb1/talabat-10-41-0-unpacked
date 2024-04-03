package org.junit.internal.matchers;

import java.lang.Throwable;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class ThrowableMessageMatcher<T extends Throwable> extends TypeSafeMatcher<T> {
    private final Matcher<String> matcher;

    public ThrowableMessageMatcher(Matcher<String> matcher2) {
        this.matcher = matcher2;
    }

    @Factory
    public static <T extends Throwable> Matcher<T> hasMessage(Matcher<String> matcher2) {
        return new ThrowableMessageMatcher(matcher2);
    }

    /* renamed from: a */
    public void describeMismatchSafely(T t11, Description description) {
        description.appendText("message ");
        this.matcher.describeMismatch(t11.getMessage(), description);
    }

    /* renamed from: b */
    public boolean matchesSafely(T t11) {
        return this.matcher.matches(t11.getMessage());
    }

    public void describeTo(Description description) {
        description.appendText("exception with message ");
        description.appendDescriptionOf(this.matcher);
    }
}
