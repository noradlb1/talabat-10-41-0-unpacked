package net.bytebuddy.matcher;

import java.lang.ClassLoader;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.matcher.ElementMatcher;

@HashCodeAndEqualsPlugin.Enhance
public class ClassLoaderHierarchyMatcher<T extends ClassLoader> extends ElementMatcher.Junction.AbstractBase<T> {
    private final ElementMatcher<? super ClassLoader> matcher;

    public ClassLoaderHierarchyMatcher(ElementMatcher<? super ClassLoader> elementMatcher) {
        this.matcher = elementMatcher;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.matcher.equals(((ClassLoaderHierarchyMatcher) obj).matcher);
    }

    public int hashCode() {
        return (getClass().hashCode() * 31) + this.matcher.hashCode();
    }

    public String toString() {
        return "hasChild(" + this.matcher + ')';
    }

    public boolean matches(T t11) {
        while (t11 != null) {
            if (this.matcher.matches(t11)) {
                return true;
            }
            t11 = t11.getParent();
        }
        return this.matcher.matches(null);
    }
}
