package net.bytebuddy.matcher;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.matcher.ElementMatcher;

@HashCodeAndEqualsPlugin.Enhance
public class InstanceTypeMatcher<T> extends ElementMatcher.Junction.AbstractBase<T> {
    private final ElementMatcher<? super TypeDescription> matcher;

    public InstanceTypeMatcher(ElementMatcher<? super TypeDescription> elementMatcher) {
        this.matcher = elementMatcher;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.matcher.equals(((InstanceTypeMatcher) obj).matcher);
    }

    public int hashCode() {
        return (getClass().hashCode() * 31) + this.matcher.hashCode();
    }

    public boolean matches(T t11) {
        return t11 != null && this.matcher.matches(TypeDescription.ForLoadedType.of(t11.getClass()));
    }

    public String toString() {
        return "ofType(" + this.matcher + ")";
    }
}
