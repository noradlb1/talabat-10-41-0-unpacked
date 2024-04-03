package net.bytebuddy.matcher;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.ByteCodeElement;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.matcher.ElementMatcher;

@HashCodeAndEqualsPlugin.Enhance
public class VisibilityMatcher<T extends ByteCodeElement> extends ElementMatcher.Junction.AbstractBase<T> {
    private final TypeDescription typeDescription;

    public VisibilityMatcher(TypeDescription typeDescription2) {
        this.typeDescription = typeDescription2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.typeDescription.equals(((VisibilityMatcher) obj).typeDescription);
    }

    public int hashCode() {
        return (getClass().hashCode() * 31) + this.typeDescription.hashCode();
    }

    public String toString() {
        return "isVisibleTo(" + this.typeDescription + ")";
    }

    public boolean matches(T t11) {
        return t11.isVisibleTo(this.typeDescription);
    }
}
