package org.junit.rules;

import java.util.ArrayList;
import java.util.List;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.junit.matchers.JUnitMatchers;

class ExpectedExceptionMatcherBuilder {
    private final List<Matcher<?>> matchers = new ArrayList();

    private Matcher<Throwable> allOfTheMatchers() {
        if (this.matchers.size() == 1) {
            return cast(this.matchers.get(0));
        }
        return CoreMatchers.allOf(castedMatchers());
    }

    private Matcher<Throwable> cast(Matcher<?> matcher) {
        return matcher;
    }

    private List<Matcher<? super Throwable>> castedMatchers() {
        return new ArrayList(this.matchers);
    }

    public void a(Matcher<?> matcher) {
        this.matchers.add(matcher);
    }

    public Matcher<Throwable> b() {
        return JUnitMatchers.isThrowable(allOfTheMatchers());
    }

    public boolean c() {
        return !this.matchers.isEmpty();
    }
}
