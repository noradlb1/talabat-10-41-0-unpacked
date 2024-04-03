package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;

public class AnnotatedImpl implements Annotated {
    private final Annotations annotations;

    private static /* synthetic */ void $$$reportNull$$$0(int i11) {
        String str = i11 != 1 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[(i11 != 1 ? 3 : 2)];
        if (i11 != 1) {
            objArr[0] = "annotations";
        } else {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotatedImpl";
        }
        if (i11 != 1) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotatedImpl";
        } else {
            objArr[1] = "getAnnotations";
        }
        if (i11 != 1) {
            objArr[2] = MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
        }
        String format = String.format(str, objArr);
        throw (i11 != 1 ? new IllegalArgumentException(format) : new IllegalStateException(format));
    }

    public AnnotatedImpl(@NotNull Annotations annotations2) {
        if (annotations2 == null) {
            $$$reportNull$$$0(0);
        }
        this.annotations = annotations2;
    }

    @NotNull
    public Annotations getAnnotations() {
        Annotations annotations2 = this.annotations;
        if (annotations2 == null) {
            $$$reportNull$$$0(1);
        }
        return annotations2;
    }
}
