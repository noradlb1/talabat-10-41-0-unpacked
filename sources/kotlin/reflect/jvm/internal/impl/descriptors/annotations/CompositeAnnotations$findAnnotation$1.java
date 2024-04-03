package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CompositeAnnotations$findAnnotation$1 extends Lambda implements Function1<Annotations, AnnotationDescriptor> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ FqName f24495g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CompositeAnnotations$findAnnotation$1(FqName fqName) {
        super(1);
        this.f24495g = fqName;
    }

    @Nullable
    public final AnnotationDescriptor invoke(@NotNull Annotations annotations) {
        Intrinsics.checkNotNullParameter(annotations, "it");
        return annotations.findAnnotation(this.f24495g);
    }
}
