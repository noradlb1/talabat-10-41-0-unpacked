package androidx.compose.runtime.snapshots;

import java.util.ConcurrentModificationException;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;

@Metadata(d1 = {"\u0000\r\n\u0000\n\u0002\u0010'\n\u0002\b\u000b*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001J\u0015\u0010\b\u001a\u00028\u00012\u0006\u0010\n\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u000bR\u0016\u0010\u0002\u001a\u00028\u0000X\u0004¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\u0006\u001a\u00028\u0001X\u000e¢\u0006\u0010\n\u0002\u0010\u0005\u001a\u0004\b\u0007\u0010\u0004\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"androidx/compose/runtime/snapshots/StateMapMutableEntriesIterator$next$1", "", "key", "getKey", "()Ljava/lang/Object;", "Ljava/lang/Object;", "value", "getValue", "setValue", "(Ljava/lang/Object;)V", "newValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class StateMapMutableEntriesIterator$next$1 implements Map.Entry<K, V>, KMutableMap.Entry {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ StateMapMutableEntriesIterator<K, V> f9547b;
    private final K key;
    private V value;

    public StateMapMutableEntriesIterator$next$1(StateMapMutableEntriesIterator<K, V> stateMapMutableEntriesIterator) {
        this.f9547b = stateMapMutableEntriesIterator;
        Map.Entry<K, V> b11 = stateMapMutableEntriesIterator.b();
        Intrinsics.checkNotNull(b11);
        this.key = b11.getKey();
        Map.Entry<K, V> b12 = stateMapMutableEntriesIterator.b();
        Intrinsics.checkNotNull(b12);
        this.value = b12.getValue();
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

    /* renamed from: setValue  reason: collision with other method in class */
    public void m2553setValue(V v11) {
        this.value = v11;
    }

    public V setValue(V v11) {
        StateMapMutableEntriesIterator<K, V> stateMapMutableEntriesIterator = this.f9547b;
        if (stateMapMutableEntriesIterator.getMap().getModification$runtime_release() == stateMapMutableEntriesIterator.modification) {
            V value2 = getValue();
            stateMapMutableEntriesIterator.getMap().put(getKey(), v11);
            setValue(v11);
            return value2;
        }
        throw new ConcurrentModificationException();
    }
}
