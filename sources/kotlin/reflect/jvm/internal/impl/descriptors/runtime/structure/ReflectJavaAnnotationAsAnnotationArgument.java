package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationAsAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ReflectJavaAnnotationAsAnnotationArgument extends ReflectJavaAnnotationArgument implements JavaAnnotationAsAnnotationArgument {
    @NotNull
    private final Annotation annotation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReflectJavaAnnotationAsAnnotationArgument(@Nullable Name name2, @NotNull Annotation annotation2) {
        super(name2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(annotation2, "annotation");
        this.annotation = annotation2;
    }

    @NotNull
    public JavaAnnotation getAnnotation() {
        return new ReflectJavaAnnotation(this.annotation);
    }
}
