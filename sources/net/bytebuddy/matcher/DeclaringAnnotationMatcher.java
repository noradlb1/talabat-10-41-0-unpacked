package net.bytebuddy.matcher;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.annotation.AnnotationList;
import net.bytebuddy.description.annotation.AnnotationSource;
import net.bytebuddy.matcher.ElementMatcher;

@HashCodeAndEqualsPlugin.Enhance
public class DeclaringAnnotationMatcher<T extends AnnotationSource> extends ElementMatcher.Junction.AbstractBase<T> {
    private final ElementMatcher<? super AnnotationList> matcher;

    public DeclaringAnnotationMatcher(ElementMatcher<? super AnnotationList> elementMatcher) {
        this.matcher = elementMatcher;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.matcher.equals(((DeclaringAnnotationMatcher) obj).matcher);
    }

    public int hashCode() {
        return (getClass().hashCode() * 31) + this.matcher.hashCode();
    }

    public String toString() {
        return "declaresAnnotations(" + this.matcher + ")";
    }

    public boolean matches(T t11) {
        return this.matcher.matches(t11.getDeclaredAnnotations());
    }
}
