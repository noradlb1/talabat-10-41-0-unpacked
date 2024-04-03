package net.bytebuddy.matcher;

import java.lang.annotation.ElementType;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.matcher.ElementMatcher;

@HashCodeAndEqualsPlugin.Enhance
public class AnnotationTargetMatcher<T extends AnnotationDescription> extends ElementMatcher.Junction.AbstractBase<T> {
    private final ElementType elementType;

    public AnnotationTargetMatcher(ElementType elementType2) {
        this.elementType = elementType2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.elementType.equals(((AnnotationTargetMatcher) obj).elementType);
    }

    public int hashCode() {
        return (getClass().hashCode() * 31) + this.elementType.hashCode();
    }

    public String toString() {
        return "targetsElement(" + this.elementType + ")";
    }

    public boolean matches(T t11) {
        return t11.getElementTypes().contains(this.elementType);
    }
}
