package net.bytebuddy.matcher;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.matcher.ElementMatcher;

@HashCodeAndEqualsPlugin.Enhance
public class FailSafeMatcher<T> extends ElementMatcher.Junction.AbstractBase<T> {
    private final boolean fallback;
    private final ElementMatcher<? super T> matcher;

    public FailSafeMatcher(ElementMatcher<? super T> elementMatcher, boolean z11) {
        this.matcher = elementMatcher;
        this.fallback = z11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FailSafeMatcher failSafeMatcher = (FailSafeMatcher) obj;
        return this.fallback == failSafeMatcher.fallback && this.matcher.equals(failSafeMatcher.matcher);
    }

    public int hashCode() {
        return (((getClass().hashCode() * 31) + this.matcher.hashCode()) * 31) + (this.fallback ? 1 : 0);
    }

    public boolean matches(T t11) {
        try {
            return this.matcher.matches(t11);
        } catch (Exception unused) {
            return this.fallback;
        }
    }

    public String toString() {
        return "failSafe(try(" + this.matcher + ") or " + this.fallback + ")";
    }
}
