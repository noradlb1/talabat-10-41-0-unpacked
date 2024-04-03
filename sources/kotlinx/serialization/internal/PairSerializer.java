package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022 \u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u0003B#\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0011¢\u0006\u0004\b\u0014\u0010\u0015J+\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00028\u0001H\u0014¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\u00020\t8\u0016X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR$\u0010\u0005\u001a\u00028\u0000*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00048TX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR$\u0010\u0006\u001a\u00028\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00048TX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u0016"}, d2 = {"Lkotlinx/serialization/internal/PairSerializer;", "K", "V", "Lkotlinx/serialization/internal/KeyValueSerializer;", "Lkotlin/Pair;", "key", "value", "c", "(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "a", "(Lkotlin/Pair;)Ljava/lang/Object;", "b", "Lkotlinx/serialization/KSerializer;", "keySerializer", "valueSerializer", "<init>", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)V", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0})
@PublishedApi
public final class PairSerializer<K, V> extends KeyValueSerializer<K, V, Pair<? extends K, ? extends V>> {
    @NotNull
    private final SerialDescriptor descriptor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PairSerializer(@NotNull KSerializer<K> kSerializer, @NotNull KSerializer<V> kSerializer2) {
        super(kSerializer, kSerializer2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(kSerializer, "keySerializer");
        Intrinsics.checkNotNullParameter(kSerializer2, "valueSerializer");
        this.descriptor = SerialDescriptorsKt.buildClassSerialDescriptor("kotlin.Pair", new SerialDescriptor[0], new PairSerializer$descriptor$1(kSerializer, kSerializer2));
    }

    /* renamed from: a */
    public K getKey(@NotNull Pair<? extends K, ? extends V> pair) {
        Intrinsics.checkNotNullParameter(pair, "<this>");
        return pair.getFirst();
    }

    /* renamed from: b */
    public V getValue(@NotNull Pair<? extends K, ? extends V> pair) {
        Intrinsics.checkNotNullParameter(pair, "<this>");
        return pair.getSecond();
    }

    @NotNull
    /* renamed from: c */
    public Pair<K, V> toResult(K k11, V v11) {
        return TuplesKt.to(k11, v11);
    }

    @NotNull
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }
}
