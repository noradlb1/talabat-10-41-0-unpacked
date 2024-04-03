package net.bytebuddy.matcher;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.matcher.ElementMatcher;

@HashCodeAndEqualsPlugin.Enhance
public class EqualityMatcher<T> extends ElementMatcher.Junction.AbstractBase<T> {
    private final Object value;

    public EqualityMatcher(Object obj) {
        this.value = obj;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.value.equals(((EqualityMatcher) obj).value);
    }

    public int hashCode() {
        return (getClass().hashCode() * 31) + this.value.hashCode();
    }

    public boolean matches(T t11) {
        return this.value.equals(t11);
    }

    public String toString() {
        return "is(" + this.value + ")";
    }
}
