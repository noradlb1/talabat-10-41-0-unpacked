package net.bytebuddy.matcher;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.matcher.ElementMatcher;

@HashCodeAndEqualsPlugin.Enhance
public class MethodParameterTypeMatcher<T extends ParameterDescription> extends ElementMatcher.Junction.AbstractBase<T> {
    private final ElementMatcher<? super TypeDescription.Generic> matcher;

    public MethodParameterTypeMatcher(ElementMatcher<? super TypeDescription.Generic> elementMatcher) {
        this.matcher = elementMatcher;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.matcher.equals(((MethodParameterTypeMatcher) obj).matcher);
    }

    public int hashCode() {
        return (getClass().hashCode() * 31) + this.matcher.hashCode();
    }

    public String toString() {
        return "hasType(" + this.matcher + ")";
    }

    public boolean matches(T t11) {
        return this.matcher.matches(t11.getType());
    }
}
