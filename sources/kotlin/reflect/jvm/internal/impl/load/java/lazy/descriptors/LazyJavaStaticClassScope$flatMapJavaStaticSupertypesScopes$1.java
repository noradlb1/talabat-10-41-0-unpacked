package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.utils.DFS;
import org.jetbrains.annotations.NotNull;

public final class LazyJavaStaticClassScope$flatMapJavaStaticSupertypesScopes$1<N> implements DFS.Neighbors {
    public static final LazyJavaStaticClassScope$flatMapJavaStaticSupertypesScopes$1<N> INSTANCE = new LazyJavaStaticClassScope$flatMapJavaStaticSupertypesScopes$1<>();

    @NotNull
    public final Iterable<ClassDescriptor> getNeighbors(ClassDescriptor classDescriptor) {
        Collection<KotlinType> supertypes = classDescriptor.getTypeConstructor().getSupertypes();
        Intrinsics.checkNotNullExpressionValue(supertypes, "it.typeConstructor.supertypes");
        return SequencesKt___SequencesKt.asIterable(SequencesKt___SequencesKt.mapNotNull(CollectionsKt___CollectionsKt.asSequence(supertypes), AnonymousClass1.INSTANCE));
    }
}
