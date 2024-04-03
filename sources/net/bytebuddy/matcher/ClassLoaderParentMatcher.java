package net.bytebuddy.matcher;

import java.lang.ClassLoader;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.matcher.ElementMatcher;

@HashCodeAndEqualsPlugin.Enhance
public class ClassLoaderParentMatcher<T extends ClassLoader> extends ElementMatcher.Junction.AbstractBase<T> {
    private final ClassLoader classLoader;

    public ClassLoaderParentMatcher(ClassLoader classLoader2) {
        this.classLoader = classLoader2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.classLoader.equals(((ClassLoaderParentMatcher) obj).classLoader);
    }

    public int hashCode() {
        return (getClass().hashCode() * 31) + this.classLoader.hashCode();
    }

    public String toString() {
        return "isParentOf(" + this.classLoader + ')';
    }

    public boolean matches(T t11) {
        for (T t12 = this.classLoader; t12 != null; t12 = t12.getParent()) {
            if (t12 == t11) {
                return true;
            }
        }
        if (t11 == null) {
            return true;
        }
        return false;
    }
}
