package net.bytebuddy.matcher;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.matcher.ElementMatcher;

@HashCodeAndEqualsPlugin.Enhance
public class MethodExceptionTypeMatcher<T extends MethodDescription> extends ElementMatcher.Junction.AbstractBase<T> {
    private final ElementMatcher<? super TypeList.Generic> matcher;

    public MethodExceptionTypeMatcher(ElementMatcher<? super TypeList.Generic> elementMatcher) {
        this.matcher = elementMatcher;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.matcher.equals(((MethodExceptionTypeMatcher) obj).matcher);
    }

    public int hashCode() {
        return (getClass().hashCode() * 31) + this.matcher.hashCode();
    }

    public String toString() {
        return "exceptions(" + this.matcher + ")";
    }

    public boolean matches(T t11) {
        return this.matcher.matches(t11.getExceptionTypes());
    }
}
