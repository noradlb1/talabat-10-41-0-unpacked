package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader;
import org.jetbrains.annotations.NotNull;

public final class AbstractBinaryClassAnnotationAndConstantLoader$storage$1 extends Lambda implements Function1<KotlinJvmBinaryClass, AbstractBinaryClassAnnotationAndConstantLoader.AnnotationsContainerWithConstants<? extends A, ? extends C>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ AbstractBinaryClassAnnotationAndConstantLoader<A, C> f24713g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AbstractBinaryClassAnnotationAndConstantLoader$storage$1(AbstractBinaryClassAnnotationAndConstantLoader<A, C> abstractBinaryClassAnnotationAndConstantLoader) {
        super(1);
        this.f24713g = abstractBinaryClassAnnotationAndConstantLoader;
    }

    @NotNull
    public final AbstractBinaryClassAnnotationAndConstantLoader.AnnotationsContainerWithConstants<A, C> invoke(@NotNull KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        Intrinsics.checkNotNullParameter(kotlinJvmBinaryClass, "kotlinClass");
        return this.f24713g.loadAnnotationsAndInitializers(kotlinJvmBinaryClass);
    }
}
