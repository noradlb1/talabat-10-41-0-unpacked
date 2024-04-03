package net.bytebuddy.matcher;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.matcher.ElementMatcher;

@HashCodeAndEqualsPlugin.Enhance
public class TypeSortMatcher<T extends TypeDefinition> extends ElementMatcher.Junction.AbstractBase<T> {
    private final ElementMatcher<? super TypeDefinition.Sort> matcher;

    public TypeSortMatcher(ElementMatcher<? super TypeDefinition.Sort> elementMatcher) {
        this.matcher = elementMatcher;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.matcher.equals(((TypeSortMatcher) obj).matcher);
    }

    public int hashCode() {
        return (getClass().hashCode() * 31) + this.matcher.hashCode();
    }

    public String toString() {
        return "ofSort(" + this.matcher + ')';
    }

    public boolean matches(T t11) {
        return this.matcher.matches(t11.getSort());
    }
}
