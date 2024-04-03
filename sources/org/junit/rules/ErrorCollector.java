package org.junit.rules;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.runners.model.MultipleFailureException;

public class ErrorCollector extends Verifier {
    private List<Throwable> errors = new ArrayList();

    public void a() throws Throwable {
        MultipleFailureException.assertEmpty(this.errors);
    }

    public void addError(Throwable th2) {
        this.errors.add(th2);
    }

    public <T> T checkSucceeds(Callable<T> callable) {
        try {
            return callable.call();
        } catch (Throwable th2) {
            addError(th2);
            return null;
        }
    }

    public <T> void checkThat(T t11, Matcher<T> matcher) {
        checkThat("", t11, matcher);
    }

    public <T> void checkThat(final String str, final T t11, final Matcher<T> matcher) {
        checkSucceeds(new Callable<Object>() {
            public Object call() throws Exception {
                Assert.assertThat(str, t11, matcher);
                return t11;
            }
        });
    }
}
