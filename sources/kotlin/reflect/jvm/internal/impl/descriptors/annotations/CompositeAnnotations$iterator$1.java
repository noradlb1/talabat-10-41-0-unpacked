package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

public final class CompositeAnnotations$iterator$1 extends Lambda implements Function1<Annotations, Sequence<? extends AnnotationDescriptor>> {
    public static final CompositeAnnotations$iterator$1 INSTANCE = new CompositeAnnotations$iterator$1();

    public CompositeAnnotations$iterator$1() {
        super(1);
    }

    @NotNull
    public final Sequence<AnnotationDescriptor> invoke(@NotNull Annotations annotations) {
        Intrinsics.checkNotNullParameter(annotations, "it");
        return CollectionsKt___CollectionsKt.asSequence(annotations);
    }
}
