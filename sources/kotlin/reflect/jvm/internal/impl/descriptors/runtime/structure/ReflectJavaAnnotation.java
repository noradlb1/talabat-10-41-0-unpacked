package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ReflectJavaAnnotation extends ReflectJavaElement implements JavaAnnotation {
    @NotNull
    private final Annotation annotation;

    public ReflectJavaAnnotation(@NotNull Annotation annotation2) {
        Intrinsics.checkNotNullParameter(annotation2, "annotation");
        this.annotation = annotation2;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof ReflectJavaAnnotation) && this.annotation == ((ReflectJavaAnnotation) obj).annotation;
    }

    @NotNull
    public final Annotation getAnnotation() {
        return this.annotation;
    }

    @NotNull
    public Collection<JavaAnnotationArgument> getArguments() {
        Method[] declaredMethods = JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(this.annotation)).getDeclaredMethods();
        Intrinsics.checkNotNullExpressionValue(declaredMethods, "annotation.annotationClass.java.declaredMethods");
        ArrayList arrayList = new ArrayList(declaredMethods.length);
        for (Method method : declaredMethods) {
            ReflectJavaAnnotationArgument.Factory factory = ReflectJavaAnnotationArgument.Factory;
            Object invoke = method.invoke(this.annotation, new Object[0]);
            Intrinsics.checkNotNullExpressionValue(invoke, "method.invoke(annotation)");
            arrayList.add(factory.create(invoke, Name.identifier(method.getName())));
        }
        return arrayList;
    }

    @NotNull
    public ClassId getClassId() {
        return ReflectClassUtilKt.getClassId(JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(this.annotation)));
    }

    public int hashCode() {
        return System.identityHashCode(this.annotation);
    }

    public boolean isFreshlySupportedTypeUseAnnotation() {
        return JavaAnnotation.DefaultImpls.isFreshlySupportedTypeUseAnnotation(this);
    }

    public boolean isIdeExternalAnnotation() {
        return JavaAnnotation.DefaultImpls.isIdeExternalAnnotation(this);
    }

    @NotNull
    public String toString() {
        return ReflectJavaAnnotation.class.getName() + ": " + this.annotation;
    }

    @NotNull
    public ReflectJavaClass resolve() {
        return new ReflectJavaClass(JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(this.annotation)));
    }
}
