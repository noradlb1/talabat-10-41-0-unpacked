package kotlinx.serialization.internal;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010(\n\u0002\u0010&\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022B\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\u0012 \u0012\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u00060\u0003B#\u0012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d\u0012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010\u001d¢\u0006\u0004\b \u0010!J\u0018\u0010\b\u001a\u00020\u0007*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0014J*\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n0\t*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0014J$\u0010\f\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u0006H\u0014J(\u0010\r\u001a\u00020\u0007*\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u0006H\u0014J4\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004*\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u0006H\u0014J4\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u0006*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0014J0\u0010\u0012\u001a\u00020\u0011*\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u00062\u0006\u0010\u0010\u001a\u00020\u0007H\u0014JG\u0010\u0016\u001a\u00020\u0011*\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u00062\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00028\u0001H\u0014¢\u0006\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0019\u001a\u00020\u00188\u0016X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\""}, d2 = {"Lkotlinx/serialization/internal/HashMapSerializer;", "K", "V", "Lkotlinx/serialization/internal/MapLikeSerializer;", "", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "", "g", "", "", "f", "c", "d", "j", "i", "size", "", "e", "index", "key", "value", "h", "(Ljava/util/HashMap;ILjava/lang/Object;Ljava/lang/Object;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "Lkotlinx/serialization/KSerializer;", "kSerializer", "vSerializer", "<init>", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)V", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0})
@PublishedApi
public final class HashMapSerializer<K, V> extends MapLikeSerializer<K, V, Map<K, ? extends V>, HashMap<K, V>> {
    @NotNull
    private final SerialDescriptor descriptor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HashMapSerializer(@NotNull KSerializer<K> kSerializer, @NotNull KSerializer<V> kSerializer2) {
        super(kSerializer, kSerializer2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(kSerializer, "kSerializer");
        Intrinsics.checkNotNullParameter(kSerializer2, "vSerializer");
        this.descriptor = new HashMapClassDesc(kSerializer.getDescriptor(), kSerializer2.getDescriptor());
    }

    @NotNull
    /* renamed from: c */
    public HashMap<K, V> builder() {
        return new HashMap<>();
    }

    /* renamed from: d */
    public int builderSize(@NotNull HashMap<K, V> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "<this>");
        return hashMap.size() * 2;
    }

    /* renamed from: e */
    public void checkCapacity(@NotNull HashMap<K, V> hashMap, int i11) {
        Intrinsics.checkNotNullParameter(hashMap, "<this>");
    }

    @NotNull
    /* renamed from: f */
    public Iterator<Map.Entry<K, V>> collectionIterator(@NotNull Map<K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        return map.entrySet().iterator();
    }

    /* renamed from: g */
    public int collectionSize(@NotNull Map<K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        return map.size();
    }

    @NotNull
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    /* renamed from: h */
    public void insertKeyValuePair(@NotNull HashMap<K, V> hashMap, int i11, K k11, V v11) {
        Intrinsics.checkNotNullParameter(hashMap, "<this>");
        hashMap.put(k11, v11);
    }

    @NotNull
    /* renamed from: i */
    public HashMap<K, V> toBuilder(@NotNull Map<K, ? extends V> map) {
        HashMap<K, V> hashMap;
        Intrinsics.checkNotNullParameter(map, "<this>");
        if (map instanceof HashMap) {
            hashMap = (HashMap) map;
        } else {
            hashMap = null;
        }
        if (hashMap == null) {
            return new HashMap<>(map);
        }
        return hashMap;
    }

    @NotNull
    /* renamed from: j */
    public Map<K, V> toResult(@NotNull HashMap<K, V> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "<this>");
        return hashMap;
    }
}
