package net.bytebuddy.matcher;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.DeclaredByType;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.matcher.ElementMatcher;

@HashCodeAndEqualsPlugin.Enhance
public class DeclaringTypeMatcher<T extends DeclaredByType> extends ElementMatcher.Junction.AbstractBase<T> {
    private final ElementMatcher<? super TypeDescription.Generic> matcher;

    public DeclaringTypeMatcher(ElementMatcher<? super TypeDescription.Generic> elementMatcher) {
        this.matcher = elementMatcher;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.matcher.equals(((DeclaringTypeMatcher) obj).matcher);
    }

    public int hashCode() {
        return (getClass().hashCode() * 31) + this.matcher.hashCode();
    }

    public String toString() {
        return "declaredBy(" + this.matcher + ")";
    }

    public boolean matches(T t11) {
        TypeDefinition declaringType = t11.getDeclaringType();
        return declaringType != null && this.matcher.matches(declaringType.asGenericType());
    }
}
