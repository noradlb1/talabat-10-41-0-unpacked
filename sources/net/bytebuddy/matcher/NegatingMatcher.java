package net.bytebuddy.matcher;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.matcher.ElementMatcher;

@HashCodeAndEqualsPlugin.Enhance
public class NegatingMatcher<T> extends ElementMatcher.Junction.AbstractBase<T> {
    private final ElementMatcher<? super T> matcher;

    public NegatingMatcher(ElementMatcher<? super T> elementMatcher) {
        this.matcher = elementMatcher;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.matcher.equals(((NegatingMatcher) obj).matcher);
    }

    public int hashCode() {
        return (getClass().hashCode() * 31) + this.matcher.hashCode();
    }

    public boolean matches(T t11) {
        return !this.matcher.matches(t11);
    }

    public String toString() {
        return "not(" + this.matcher + ')';
    }
}
