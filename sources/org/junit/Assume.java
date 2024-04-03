package org.junit;

import java.util.Arrays;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;

public class Assume {
    public static void assumeFalse(boolean z11) {
        assumeTrue(!z11);
    }

    public static void assumeNoException(Throwable th2) {
        assumeThat(th2, CoreMatchers.nullValue());
    }

    public static void assumeNotNull(Object... objArr) {
        assumeThat(Arrays.asList(objArr), CoreMatchers.everyItem(CoreMatchers.notNullValue()));
    }

    public static <T> void assumeThat(T t11, Matcher<T> matcher) {
        if (!matcher.matches(t11)) {
            throw new AssumptionViolatedException(t11, matcher);
        }
    }

    public static void assumeTrue(boolean z11) {
        assumeThat(Boolean.valueOf(z11), CoreMatchers.is(Boolean.TRUE));
    }

    public static void assumeFalse(String str, boolean z11) {
        assumeTrue(str, !z11);
    }

    public static void assumeNoException(String str, Throwable th2) {
        assumeThat(str, th2, CoreMatchers.nullValue());
    }

    public static void assumeTrue(String str, boolean z11) {
        if (!z11) {
            throw new AssumptionViolatedException(str);
        }
    }

    public static <T> void assumeThat(String str, T t11, Matcher<T> matcher) {
        if (!matcher.matches(t11)) {
            throw new AssumptionViolatedException(str, t11, matcher);
        }
    }
}
