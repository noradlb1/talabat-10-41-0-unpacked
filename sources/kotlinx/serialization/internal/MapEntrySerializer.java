package kotlinx.serialization.internal;

import java.util.Map;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.StructureKind;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@PublishedApi
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022 \u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u0003:\u0001\u0016B#\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0011¢\u0006\u0004\b\u0014\u0010\u0015J+\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00028\u0001H\u0014¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\u00020\t8\u0016X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR$\u0010\u0005\u001a\u00028\u0000*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00048TX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR$\u0010\u0006\u001a\u00028\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00048TX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u0017"}, d2 = {"Lkotlinx/serialization/internal/MapEntrySerializer;", "K", "V", "Lkotlinx/serialization/internal/KeyValueSerializer;", "", "key", "value", "c", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map$Entry;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "a", "(Ljava/util/Map$Entry;)Ljava/lang/Object;", "b", "Lkotlinx/serialization/KSerializer;", "keySerializer", "valueSerializer", "<init>", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)V", "MapEntry", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0})
public final class MapEntrySerializer<K, V> extends KeyValueSerializer<K, V, Map.Entry<? extends K, ? extends V>> {
    @NotNull
    private final SerialDescriptor descriptor;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010&\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00028\u0002\u0012\u0006\u0010\u0005\u001a\u00028\u0003¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000b\u001a\u00028\u0002HÆ\u0003¢\u0006\u0002\u0010\bJ\u000e\u0010\f\u001a\u00028\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ.\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00002\b\b\u0002\u0010\u0004\u001a\u00028\u00022\b\b\u0002\u0010\u0005\u001a\u00028\u0003HÆ\u0001¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0016\u0010\u0004\u001a\u00028\u0002X\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0005\u001a\u00028\u0003X\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b¨\u0006\u0017"}, d2 = {"Lkotlinx/serialization/internal/MapEntrySerializer$MapEntry;", "K", "V", "", "key", "value", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getKey", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getValue", "component1", "component2", "copy", "(Ljava/lang/Object;Ljava/lang/Object;)Lkotlinx/serialization/internal/MapEntrySerializer$MapEntry;", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class MapEntry<K, V> implements Map.Entry<K, V>, KMappedMarker {
        private final K key;
        private final V value;

        public MapEntry(K k11, V v11) {
            this.key = k11;
            this.value = v11;
        }

        public static /* synthetic */ MapEntry copy$default(MapEntry mapEntry, Object obj, Object obj2, int i11, Object obj3) {
            if ((i11 & 1) != 0) {
                obj = mapEntry.getKey();
            }
            if ((i11 & 2) != 0) {
                obj2 = mapEntry.getValue();
            }
            return mapEntry.copy(obj, obj2);
        }

        public final K component1() {
            return getKey();
        }

        public final V component2() {
            return getValue();
        }

        @NotNull
        public final MapEntry<K, V> copy(K k11, V v11) {
            return new MapEntry<>(k11, v11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MapEntry)) {
                return false;
            }
            MapEntry mapEntry = (MapEntry) obj;
            return Intrinsics.areEqual(getKey(), mapEntry.getKey()) && Intrinsics.areEqual(getValue(), mapEntry.getValue());
        }

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.value;
        }

        public int hashCode() {
            int i11 = 0;
            int hashCode = (getKey() == null ? 0 : getKey().hashCode()) * 31;
            if (getValue() != null) {
                i11 = getValue().hashCode();
            }
            return hashCode + i11;
        }

        public V setValue(V v11) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @NotNull
        public String toString() {
            return "MapEntry(key=" + getKey() + ", value=" + getValue() + ')';
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MapEntrySerializer(@NotNull KSerializer<K> kSerializer, @NotNull KSerializer<V> kSerializer2) {
        super(kSerializer, kSerializer2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(kSerializer, "keySerializer");
        Intrinsics.checkNotNullParameter(kSerializer2, "valueSerializer");
        this.descriptor = SerialDescriptorsKt.buildSerialDescriptor("kotlin.collections.Map.Entry", StructureKind.MAP.INSTANCE, new SerialDescriptor[0], new MapEntrySerializer$descriptor$1(kSerializer, kSerializer2));
    }

    /* renamed from: a */
    public K getKey(@NotNull Map.Entry<? extends K, ? extends V> entry) {
        Intrinsics.checkNotNullParameter(entry, "<this>");
        return entry.getKey();
    }

    /* renamed from: b */
    public V getValue(@NotNull Map.Entry<? extends K, ? extends V> entry) {
        Intrinsics.checkNotNullParameter(entry, "<this>");
        return entry.getValue();
    }

    @NotNull
    /* renamed from: c */
    public Map.Entry<K, V> toResult(K k11, V v11) {
        return new MapEntry(k11, v11);
    }

    @NotNull
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }
}
