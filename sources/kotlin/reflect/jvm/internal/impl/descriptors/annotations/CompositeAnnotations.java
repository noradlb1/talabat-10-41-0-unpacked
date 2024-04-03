package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CompositeAnnotations implements Annotations {
    @NotNull
    private final List<Annotations> delegates;

    public CompositeAnnotations(@NotNull List<? extends Annotations> list) {
        Intrinsics.checkNotNullParameter(list, "delegates");
        this.delegates = list;
    }

    @Nullable
    public AnnotationDescriptor findAnnotation(@NotNull FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        return (AnnotationDescriptor) SequencesKt___SequencesKt.firstOrNull(SequencesKt___SequencesKt.mapNotNull(CollectionsKt___CollectionsKt.asSequence(this.delegates), new CompositeAnnotations$findAnnotation$1(fqName)));
    }

    public boolean hasAnnotation(@NotNull FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        for (Annotations hasAnnotation : CollectionsKt___CollectionsKt.asSequence(this.delegates)) {
            if (hasAnnotation.hasAnnotation(fqName)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        Iterable<Annotations> iterable = this.delegates;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return true;
        }
        for (Annotations isEmpty : iterable) {
            if (!isEmpty.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public Iterator<AnnotationDescriptor> iterator() {
        return SequencesKt___SequencesKt.flatMap(CollectionsKt___CollectionsKt.asSequence(this.delegates), CompositeAnnotations$iterator$1.INSTANCE).iterator();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CompositeAnnotations(@NotNull Annotations... annotationsArr) {
        this((List<? extends Annotations>) ArraysKt___ArraysKt.toList((T[]) annotationsArr));
        Intrinsics.checkNotNullParameter(annotationsArr, "delegates");
    }
}
