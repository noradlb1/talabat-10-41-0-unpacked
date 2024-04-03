package net.bytebuddy.matcher;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.matcher.ElementMatcher;

@HashCodeAndEqualsPlugin.Enhance
public class SubTypeMatcher<T extends TypeDescription> extends ElementMatcher.Junction.AbstractBase<T> {
    private final TypeDescription typeDescription;

    public SubTypeMatcher(TypeDescription typeDescription2) {
        this.typeDescription = typeDescription2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.typeDescription.equals(((SubTypeMatcher) obj).typeDescription);
    }

    public int hashCode() {
        return (getClass().hashCode() * 31) + this.typeDescription.hashCode();
    }

    public String toString() {
        return "isSubTypeOf(" + this.typeDescription + ')';
    }

    public boolean matches(T t11) {
        return t11.isAssignableTo(this.typeDescription);
    }
}
