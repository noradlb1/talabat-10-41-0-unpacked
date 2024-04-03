package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010'\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004B)\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00028\u0000\u0012\u0006\u0010\b\u001a\u00028\u0001¢\u0006\u0002\u0010\tJ\u0015\u0010\f\u001a\u00028\u00012\u0006\u0010\u000f\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0010R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u00028\u0001X\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/MutableMapEntry;", "K", "V", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/MapEntry;", "", "parentIterator", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilderEntriesIterator;", "key", "value", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilderEntriesIterator;Ljava/lang/Object;Ljava/lang/Object;)V", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "newValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class MutableMapEntry<K, V> extends MapEntry<K, V> implements KMutableMap.Entry {
    @NotNull
    private final PersistentHashMapBuilderEntriesIterator<K, V> parentIterator;
    private V value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MutableMapEntry(@NotNull PersistentHashMapBuilderEntriesIterator<K, V> persistentHashMapBuilderEntriesIterator, K k11, V v11) {
        super(k11, v11);
        Intrinsics.checkNotNullParameter(persistentHashMapBuilderEntriesIterator, "parentIterator");
        this.parentIterator = persistentHashMapBuilderEntriesIterator;
        this.value = v11;
    }

    public V getValue() {
        return this.value;
    }

    /* renamed from: setValue  reason: collision with other method in class */
    public void m2548setValue(V v11) {
        this.value = v11;
    }

    public V setValue(V v11) {
        V value2 = getValue();
        setValue(v11);
        this.parentIterator.setValue(getKey(), v11);
        return value2;
    }
}
