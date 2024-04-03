package net.bytebuddy.matcher;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.matcher.ElementMatcher;

@HashCodeAndEqualsPlugin.Enhance
public class AnnotationTypeMatcher<T extends AnnotationDescription> extends ElementMatcher.Junction.AbstractBase<T> {
    private final ElementMatcher<? super TypeDescription> matcher;

    public AnnotationTypeMatcher(ElementMatcher<? super TypeDescription> elementMatcher) {
        this.matcher = elementMatcher;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.matcher.equals(((AnnotationTypeMatcher) obj).matcher);
    }

    public int hashCode() {
        return (getClass().hashCode() * 31) + this.matcher.hashCode();
    }

    public String toString() {
        return "ofAnnotationType(" + this.matcher + ')';
    }

    public boolean matches(T t11) {
        return this.matcher.matches(t11.getAnnotationType());
    }
}
