package net.bytebuddy.matcher;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.matcher.ElementMatcher;

@HashCodeAndEqualsPlugin.Enhance
public class BooleanMatcher<T> extends ElementMatcher.Junction.AbstractBase<T> {
    private static final BooleanMatcher<?> FALSE = new BooleanMatcher<>(false);
    private static final BooleanMatcher<?> TRUE = new BooleanMatcher<>(true);

    /* renamed from: b  reason: collision with root package name */
    public final boolean f27425b;

    public BooleanMatcher(boolean z11) {
        this.f27425b = z11;
    }

    public static <T> ElementMatcher.Junction<T> of(boolean z11) {
        return z11 ? TRUE : FALSE;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.f27425b == ((BooleanMatcher) obj).f27425b;
    }

    public int hashCode() {
        return (getClass().hashCode() * 31) + (this.f27425b ? 1 : 0);
    }

    public boolean matches(T t11) {
        return this.f27425b;
    }

    public String toString() {
        return Boolean.toString(this.f27425b);
    }
}
