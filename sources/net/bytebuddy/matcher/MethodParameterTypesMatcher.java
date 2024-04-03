package net.bytebuddy.matcher;

import java.util.List;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.method.ParameterList;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.matcher.ElementMatcher;

@HashCodeAndEqualsPlugin.Enhance
public class MethodParameterTypesMatcher<T extends ParameterList<?>> extends ElementMatcher.Junction.AbstractBase<T> {
    private final ElementMatcher<? super List<? extends TypeDescription.Generic>> matcher;

    public MethodParameterTypesMatcher(ElementMatcher<? super List<? extends TypeDescription.Generic>> elementMatcher) {
        this.matcher = elementMatcher;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.matcher.equals(((MethodParameterTypesMatcher) obj).matcher);
    }

    public int hashCode() {
        return (getClass().hashCode() * 31) + this.matcher.hashCode();
    }

    public String toString() {
        return "hasTypes(" + this.matcher + ")";
    }

    public boolean matches(T t11) {
        return this.matcher.matches(t11.asTypeList());
    }
}
