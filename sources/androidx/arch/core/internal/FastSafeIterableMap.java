package androidx.arch.core.internal;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.arch.core.internal.SafeIterableMap;
import java.util.HashMap;
import java.util.Map;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class FastSafeIterableMap<K, V> extends SafeIterableMap<K, V> {
    private HashMap<K, SafeIterableMap.Entry<K, V>> mHashMap = new HashMap<>();

    public SafeIterableMap.Entry<K, V> a(K k11) {
        return this.mHashMap.get(k11);
    }

    public Map.Entry<K, V> ceil(K k11) {
        if (contains(k11)) {
            return this.mHashMap.get(k11).f944e;
        }
        return null;
    }

    public boolean contains(K k11) {
        return this.mHashMap.containsKey(k11);
    }

    public V putIfAbsent(@NonNull K k11, @NonNull V v11) {
        SafeIterableMap.Entry a11 = a(k11);
        if (a11 != null) {
            return a11.f942c;
        }
        this.mHashMap.put(k11, b(k11, v11));
        return null;
    }

    public V remove(@NonNull K k11) {
        V remove = super.remove(k11);
        this.mHashMap.remove(k11);
        return remove;
    }
}
