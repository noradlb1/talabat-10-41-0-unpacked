package kotlinx.serialization.internal;

import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012*\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u00050\u0002B\u0015\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0005H\u0014J\u001c\u0010\b\u001a\u00020\u0007*\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0005H\u0014J\"\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003*\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0005H\u0014J\"\u0010\n\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0005*\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0014J$\u0010\r\u001a\u00020\f*\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u00052\u0006\u0010\u000b\u001a\u00020\u0007H\u0014J3\u0010\u0010\u001a\u00020\f*\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u00052\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0013\u001a\u00020\u00128\u0016X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001b"}, d2 = {"Lkotlinx/serialization/internal/HashSetSerializer;", "E", "Lkotlinx/serialization/internal/CollectionSerializer;", "", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "c", "", "d", "h", "g", "size", "", "e", "index", "element", "f", "(Ljava/util/HashSet;ILjava/lang/Object;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "Lkotlinx/serialization/KSerializer;", "eSerializer", "<init>", "(Lkotlinx/serialization/KSerializer;)V", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0})
@PublishedApi
public final class HashSetSerializer<E> extends CollectionSerializer<E, Set<? extends E>, HashSet<E>> {
    @NotNull
    private final SerialDescriptor descriptor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HashSetSerializer(@NotNull KSerializer<E> kSerializer) {
        super(kSerializer);
        Intrinsics.checkNotNullParameter(kSerializer, "eSerializer");
        this.descriptor = new HashSetClassDesc(kSerializer.getDescriptor());
    }

    @NotNull
    /* renamed from: c */
    public HashSet<E> builder() {
        return new HashSet<>();
    }

    /* renamed from: d */
    public int builderSize(@NotNull HashSet<E> hashSet) {
        Intrinsics.checkNotNullParameter(hashSet, "<this>");
        return hashSet.size();
    }

    /* renamed from: e */
    public void checkCapacity(@NotNull HashSet<E> hashSet, int i11) {
        Intrinsics.checkNotNullParameter(hashSet, "<this>");
    }

    /* renamed from: f */
    public void insert(@NotNull HashSet<E> hashSet, int i11, E e11) {
        Intrinsics.checkNotNullParameter(hashSet, "<this>");
        hashSet.add(e11);
    }

    @NotNull
    /* renamed from: g */
    public HashSet<E> toBuilder(@NotNull Set<? extends E> set) {
        HashSet<E> hashSet;
        Intrinsics.checkNotNullParameter(set, "<this>");
        if (set instanceof HashSet) {
            hashSet = (HashSet) set;
        } else {
            hashSet = null;
        }
        if (hashSet == null) {
            return new HashSet<>(set);
        }
        return hashSet;
    }

    @NotNull
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    @NotNull
    /* renamed from: h */
    public Set<E> toResult(@NotNull HashSet<E> hashSet) {
        Intrinsics.checkNotNullParameter(hashSet, "<this>");
        return hashSet;
    }
}
