package org.hamcrest;

import org.hamcrest.internal.ReflectiveTypeFinder;

public abstract class FeatureMatcher<T, U> extends TypeSafeDiagnosingMatcher<T> {
    private static final ReflectiveTypeFinder TYPE_FINDER = new ReflectiveTypeFinder("featureValueOf", 1, 0);
    private final String featureDescription;
    private final String featureName;
    private final Matcher<? super U> subMatcher;

    public FeatureMatcher(Matcher<? super U> matcher, String str, String str2) {
        super(TYPE_FINDER);
        this.subMatcher = matcher;
        this.featureDescription = str;
        this.featureName = str2;
    }

    public abstract U a(T t11);

    public final void describeTo(Description description) {
        description.appendText(this.featureDescription).appendText(" ").appendDescriptionOf(this.subMatcher);
    }

    public boolean matchesSafely(T t11, Description description) {
        Object a11 = a(t11);
        if (this.subMatcher.matches(a11)) {
            return true;
        }
        description.appendText(this.featureName).appendText(" ");
        this.subMatcher.describeMismatch(a11, description);
        return false;
    }
}
