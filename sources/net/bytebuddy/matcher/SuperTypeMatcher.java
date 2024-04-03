package net.bytebuddy.matcher;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.matcher.ElementMatcher;

@HashCodeAndEqualsPlugin.Enhance
public class SuperTypeMatcher<T extends TypeDescription> extends ElementMatcher.Junction.AbstractBase<T> {
    private final TypeDescription typeDescription;

    public SuperTypeMatcher(TypeDescription typeDescription2) {
        this.typeDescription = typeDescription2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.typeDescription.equals(((SuperTypeMatcher) obj).typeDescription);
    }

    public int hashCode() {
        return (getClass().hashCode() * 31) + this.typeDescription.hashCode();
    }

    public String toString() {
        return "isSuperTypeOf(" + this.typeDescription + ')';
    }

    public boolean matches(T t11) {
        return t11.isAssignableFrom(this.typeDescription);
    }
}
