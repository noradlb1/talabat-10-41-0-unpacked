package net.bytebuddy.matcher;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.NamedElement;
import net.bytebuddy.description.NamedElement.WithOptionalName;
import net.bytebuddy.matcher.ElementMatcher;

@HashCodeAndEqualsPlugin.Enhance
public class IsNamedMatcher<T extends NamedElement.WithOptionalName> extends ElementMatcher.Junction.AbstractBase<T> {
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass();
    }

    public int hashCode() {
        return getClass().hashCode();
    }

    public String toString() {
        return "isNamed()";
    }

    public boolean matches(T t11) {
        return t11.isNamed();
    }
}
