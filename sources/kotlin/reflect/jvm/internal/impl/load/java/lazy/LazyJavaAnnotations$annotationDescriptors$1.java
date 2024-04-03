package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationMapper;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class LazyJavaAnnotations$annotationDescriptors$1 extends Lambda implements Function1<JavaAnnotation, AnnotationDescriptor> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LazyJavaAnnotations f24588g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyJavaAnnotations$annotationDescriptors$1(LazyJavaAnnotations lazyJavaAnnotations) {
        super(1);
        this.f24588g = lazyJavaAnnotations;
    }

    @Nullable
    public final AnnotationDescriptor invoke(@NotNull JavaAnnotation javaAnnotation) {
        Intrinsics.checkNotNullParameter(javaAnnotation, "annotation");
        return JavaAnnotationMapper.INSTANCE.mapOrResolveJavaAnnotation(javaAnnotation, this.f24588g.f24587c, this.f24588g.areAnnotationsFreshlySupported);
    }
}
