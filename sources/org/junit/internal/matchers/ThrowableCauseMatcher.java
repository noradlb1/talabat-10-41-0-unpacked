package org.junit.internal.matchers;

import java.lang.Throwable;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class ThrowableCauseMatcher<T extends Throwable> extends TypeSafeMatcher<T> {
    private final Matcher<? extends Throwable> causeMatcher;

    public ThrowableCauseMatcher(Matcher<? extends Throwable> matcher) {
        this.causeMatcher = matcher;
    }

    @Factory
    public static <T extends Throwable> Matcher<T> hasCause(Matcher<? extends Throwable> matcher) {
        return new ThrowableCauseMatcher(matcher);
    }

    /* renamed from: a */
    public void describeMismatchSafely(T t11, Description description) {
        description.appendText("cause ");
        this.causeMatcher.describeMismatch(t11.getCause(), description);
    }

    /* renamed from: b */
    public boolean matchesSafely(T t11) {
        return this.causeMatcher.matches(t11.getCause());
    }

    public void describeTo(Description description) {
        description.appendText("exception with cause ");
        description.appendDescriptionOf(this.causeMatcher);
    }
}
