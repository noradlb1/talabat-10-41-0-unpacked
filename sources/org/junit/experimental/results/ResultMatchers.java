package org.junit.experimental.results;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class ResultMatchers {
    public static Matcher<PrintableResult> failureCountIs(final int i11) {
        return new TypeSafeMatcher<PrintableResult>() {
            public void describeTo(Description description) {
                description.appendText("has " + i11 + " failures");
            }

            public boolean matchesSafely(PrintableResult printableResult) {
                return printableResult.failureCount() == i11;
            }
        };
    }

    public static Matcher<PrintableResult> hasFailureContaining(final String str) {
        return new BaseMatcher<PrintableResult>() {
            public void describeTo(Description description) {
                description.appendText("has failure containing " + str);
            }

            public boolean matches(Object obj) {
                return obj.toString().contains(str);
            }
        };
    }

    public static Matcher<Object> hasSingleFailureContaining(final String str) {
        return new BaseMatcher<Object>() {
            public void describeTo(Description description) {
                description.appendText("has single failure containing " + str);
            }

            public boolean matches(Object obj) {
                return obj.toString().contains(str) && ResultMatchers.failureCountIs(1).matches(obj);
            }
        };
    }

    public static Matcher<PrintableResult> isSuccessful() {
        return failureCountIs(0);
    }
}
