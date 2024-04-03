package net.bytebuddy.matcher;

import java.util.Iterator;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.matcher.ElementMatcher;

@HashCodeAndEqualsPlugin.Enhance
public class HasSuperClassMatcher<T extends TypeDescription> extends ElementMatcher.Junction.AbstractBase<T> {
    private final ElementMatcher<? super TypeDescription.Generic> matcher;

    public HasSuperClassMatcher(ElementMatcher<? super TypeDescription.Generic> elementMatcher) {
        this.matcher = elementMatcher;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.matcher.equals(((HasSuperClassMatcher) obj).matcher);
    }

    public int hashCode() {
        return (getClass().hashCode() * 31) + this.matcher.hashCode();
    }

    public String toString() {
        return "hasSuperClass(" + this.matcher + ")";
    }

    public boolean matches(T t11) {
        if (t11.isInterface()) {
            return this.matcher.matches(TypeDescription.Generic.OBJECT);
        }
        Iterator it = t11.iterator();
        while (it.hasNext()) {
            if (this.matcher.matches(((TypeDefinition) it.next()).asGenericType())) {
                return true;
            }
        }
        return false;
    }
}
