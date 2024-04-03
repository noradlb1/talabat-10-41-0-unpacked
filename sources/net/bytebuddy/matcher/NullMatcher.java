package net.bytebuddy.matcher;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.matcher.ElementMatcher;

@HashCodeAndEqualsPlugin.Enhance
public class NullMatcher<T> extends ElementMatcher.Junction.AbstractBase<T> {
    private static final NullMatcher<?> INSTANCE = new NullMatcher<>();

    public static <T> ElementMatcher.Junction<T> make() {
        return INSTANCE;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass();
    }

    public int hashCode() {
        return getClass().hashCode();
    }

    public boolean matches(T t11) {
        return t11 == null;
    }

    public String toString() {
        return "isNull()";
    }
}
