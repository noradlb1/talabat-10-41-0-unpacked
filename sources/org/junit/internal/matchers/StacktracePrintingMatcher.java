package org.junit.internal.matchers;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Throwable;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class StacktracePrintingMatcher<T extends Throwable> extends TypeSafeMatcher<T> {
    private final Matcher<T> throwableMatcher;

    public StacktracePrintingMatcher(Matcher<T> matcher) {
        this.throwableMatcher = matcher;
    }

    @Factory
    public static <T extends Exception> Matcher<T> isException(Matcher<T> matcher) {
        return new StacktracePrintingMatcher(matcher);
    }

    @Factory
    public static <T extends Throwable> Matcher<T> isThrowable(Matcher<T> matcher) {
        return new StacktracePrintingMatcher(matcher);
    }

    private String readStacktrace(Throwable th2) {
        StringWriter stringWriter = new StringWriter();
        th2.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    /* renamed from: a */
    public void describeMismatchSafely(T t11, Description description) {
        this.throwableMatcher.describeMismatch(t11, description);
        description.appendText("\nStacktrace was: ");
        description.appendText(readStacktrace(t11));
    }

    /* renamed from: b */
    public boolean matchesSafely(T t11) {
        return this.throwableMatcher.matches(t11);
    }

    public void describeTo(Description description) {
        this.throwableMatcher.describeTo(description);
    }
}
