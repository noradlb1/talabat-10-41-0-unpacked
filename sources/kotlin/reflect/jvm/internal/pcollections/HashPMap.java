package kotlin.reflect.jvm.internal.pcollections;

import org.jetbrains.annotations.NotNull;

public final class HashPMap<K, V> {
    private static final HashPMap<Object, Object> EMPTY = new HashPMap<>(IntTreePMap.empty(), 0);
    private final IntTreePMap<ConsPStack<MapEntry<K, V>>> intMap;
    private final int size;

    private static /* synthetic */ void $$$reportNull$$$0(int i11) {
        Object[] objArr = new Object[2];
        objArr[0] = "kotlin/reflect/jvm/internal/pcollections/HashPMap";
        if (i11 != 1) {
            objArr[1] = "empty";
        } else {
            objArr[1] = "minus";
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", objArr));
    }

    private HashPMap(IntTreePMap<ConsPStack<MapEntry<K, V>>> intTreePMap, int i11) {
        this.intMap = intTreePMap;
        this.size = i11;
    }

    @NotNull
    public static <K, V> HashPMap<K, V> empty() {
        HashPMap<Object, Object> hashPMap = EMPTY;
        if (hashPMap == null) {
            $$$reportNull$$$0(0);
        }
        return hashPMap;
    }

    private ConsPStack<MapEntry<K, V>> getEntries(int i11) {
        ConsPStack<MapEntry<K, V>> consPStack = this.intMap.get(i11);
        if (consPStack == null) {
            return ConsPStack.empty();
        }
        return consPStack;
    }

    private static <K, V> int keyIndexIn(ConsPStack<MapEntry<K, V>> consPStack, Object obj) {
        int i11 = 0;
        ConsPStack<E> consPStack2 = consPStack;
        while (consPStack2 != null && consPStack2.size() > 0) {
            if (((MapEntry) consPStack2.f24985b).key.equals(obj)) {
                return i11;
            }
            i11++;
            consPStack2 = consPStack2.f24986c;
        }
        return -1;
    }

    public boolean containsKey(Object obj) {
        return keyIndexIn(getEntries(obj.hashCode()), obj) != -1;
    }

    public V get(Object obj) {
        ConsPStack<E> entries = getEntries(obj.hashCode());
        while (entries != null && entries.size() > 0) {
            MapEntry mapEntry = (MapEntry) entries.f24985b;
            if (mapEntry.key.equals(obj)) {
                return mapEntry.value;
            }
            entries = entries.f24986c;
        }
        return null;
    }

    @NotNull
    public HashPMap<K, V> minus(Object obj) {
        ConsPStack entries = getEntries(obj.hashCode());
        int keyIndexIn = keyIndexIn(entries, obj);
        if (keyIndexIn == -1) {
            return this;
        }
        ConsPStack minus = entries.minus(keyIndexIn);
        if (minus.size() == 0) {
            return new HashPMap<>(this.intMap.minus(obj.hashCode()), this.size - 1);
        }
        return new HashPMap<>(this.intMap.plus(obj.hashCode(), minus), this.size - 1);
    }

    @NotNull
    public HashPMap<K, V> plus(K k11, V v11) {
        ConsPStack entries = getEntries(k11.hashCode());
        int size2 = entries.size();
        int keyIndexIn = keyIndexIn(entries, k11);
        if (keyIndexIn != -1) {
            entries = entries.minus(keyIndexIn);
        }
        ConsPStack plus = entries.plus(new MapEntry(k11, v11));
        return new HashPMap<>(this.intMap.plus(k11.hashCode(), plus), (this.size - size2) + plus.size());
    }

    public int size() {
        return this.size;
    }
}
