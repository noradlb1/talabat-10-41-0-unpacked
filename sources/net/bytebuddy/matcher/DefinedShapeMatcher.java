package net.bytebuddy.matcher;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.ByteCodeElement;
import net.bytebuddy.description.ByteCodeElement.TypeDependant;
import net.bytebuddy.matcher.ElementMatcher;

@HashCodeAndEqualsPlugin.Enhance
public class DefinedShapeMatcher<T extends ByteCodeElement.TypeDependant<S, ?>, S extends ByteCodeElement.TypeDependant<?, ?>> extends ElementMatcher.Junction.AbstractBase<T> {
    private final ElementMatcher<? super S> matcher;

    public DefinedShapeMatcher(ElementMatcher<? super S> elementMatcher) {
        this.matcher = elementMatcher;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.matcher.equals(((DefinedShapeMatcher) obj).matcher);
    }

    public int hashCode() {
        return (getClass().hashCode() * 31) + this.matcher.hashCode();
    }

    public String toString() {
        return "isDefinedAs(" + this.matcher + ')';
    }

    public boolean matches(T t11) {
        return this.matcher.matches(t11.asDefined());
    }
}
