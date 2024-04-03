package com.bumptech.glide.load.engine.bitmap_recycle;

import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.Preconditions;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public final class LruArrayPool implements ArrayPool {
    private static final int DEFAULT_SIZE = 4194304;
    @VisibleForTesting
    static final int MAX_OVER_SIZE_MULTIPLE = 8;
    private static final int SINGLE_ARRAY_MAX_SIZE_DIVISOR = 2;
    private final Map<Class<?>, ArrayAdapterInterface<?>> adapters;
    private int currentSize;
    private final GroupedLinkedMap<Key, Object> groupedMap;
    private final KeyPool keyPool;
    private final int maxSize;
    private final Map<Class<?>, NavigableMap<Integer, Integer>> sortedSizes;

    public static final class Key implements Poolable {
        private Class<?> arrayClass;
        private final KeyPool pool;
        int size;

        public Key(KeyPool keyPool) {
            this.pool = keyPool;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Key)) {
                return false;
            }
            Key key = (Key) obj;
            if (this.size == key.size && this.arrayClass == key.arrayClass) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i11;
            int i12 = this.size * 31;
            Class<?> cls = this.arrayClass;
            if (cls != null) {
                i11 = cls.hashCode();
            } else {
                i11 = 0;
            }
            return i12 + i11;
        }

        public void init(int i11, Class<?> cls) {
            this.size = i11;
            this.arrayClass = cls;
        }

        public void offer() {
            this.pool.offer(this);
        }

        public String toString() {
            return "Key{size=" + this.size + "array=" + this.arrayClass + AbstractJsonLexerKt.END_OBJ;
        }
    }

    public static final class KeyPool extends BaseKeyPool<Key> {
        public Key get(int i11, Class<?> cls) {
            Key key = (Key) get();
            key.init(i11, cls);
            return key;
        }

        public Key create() {
            return new Key(this);
        }
    }

    @VisibleForTesting
    public LruArrayPool() {
        this.groupedMap = new GroupedLinkedMap<>();
        this.keyPool = new KeyPool();
        this.sortedSizes = new HashMap();
        this.adapters = new HashMap();
        this.maxSize = 4194304;
    }

    private void decrementArrayOfSize(int i11, Class<?> cls) {
        NavigableMap<Integer, Integer> sizesForAdapter = getSizesForAdapter(cls);
        Integer num = sizesForAdapter.get(Integer.valueOf(i11));
        if (num == null) {
            throw new NullPointerException("Tried to decrement empty size, size: " + i11 + ", this: " + this);
        } else if (num.intValue() == 1) {
            sizesForAdapter.remove(Integer.valueOf(i11));
        } else {
            sizesForAdapter.put(Integer.valueOf(i11), Integer.valueOf(num.intValue() - 1));
        }
    }

    private void evict() {
        evictToSize(this.maxSize);
    }

    private void evictToSize(int i11) {
        while (this.currentSize > i11) {
            Object removeLast = this.groupedMap.removeLast();
            Preconditions.checkNotNull(removeLast);
            ArrayAdapterInterface adapterFromObject = getAdapterFromObject(removeLast);
            this.currentSize -= adapterFromObject.getArrayLength(removeLast) * adapterFromObject.getElementSizeInBytes();
            decrementArrayOfSize(adapterFromObject.getArrayLength(removeLast), removeLast.getClass());
            if (Log.isLoggable(adapterFromObject.getTag(), 2)) {
                adapterFromObject.getTag();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("evicted: ");
                sb2.append(adapterFromObject.getArrayLength(removeLast));
            }
        }
    }

    private <T> ArrayAdapterInterface<T> getAdapterFromObject(T t11) {
        return getAdapterFromType(t11.getClass());
    }

    private <T> ArrayAdapterInterface<T> getAdapterFromType(Class<T> cls) {
        ArrayAdapterInterface<T> arrayAdapterInterface = this.adapters.get(cls);
        if (arrayAdapterInterface == null) {
            if (cls.equals(int[].class)) {
                arrayAdapterInterface = new IntegerArrayAdapter();
            } else if (cls.equals(byte[].class)) {
                arrayAdapterInterface = new ByteArrayAdapter();
            } else {
                throw new IllegalArgumentException("No array pool found for: " + cls.getSimpleName());
            }
            this.adapters.put(cls, arrayAdapterInterface);
        }
        return arrayAdapterInterface;
    }

    @Nullable
    private <T> T getArrayForKey(Key key) {
        return this.groupedMap.get(key);
    }

    private <T> T getForKey(Key key, Class<T> cls) {
        ArrayAdapterInterface<T> adapterFromType = getAdapterFromType(cls);
        T arrayForKey = getArrayForKey(key);
        if (arrayForKey != null) {
            this.currentSize -= adapterFromType.getArrayLength(arrayForKey) * adapterFromType.getElementSizeInBytes();
            decrementArrayOfSize(adapterFromType.getArrayLength(arrayForKey), cls);
        }
        if (arrayForKey != null) {
            return arrayForKey;
        }
        if (Log.isLoggable(adapterFromType.getTag(), 2)) {
            adapterFromType.getTag();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Allocated ");
            sb2.append(key.size);
            sb2.append(" bytes");
        }
        return adapterFromType.newArray(key.size);
    }

    private NavigableMap<Integer, Integer> getSizesForAdapter(Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMap = this.sortedSizes.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.sortedSizes.put(cls, treeMap);
        return treeMap;
    }

    private boolean isNoMoreThanHalfFull() {
        int i11 = this.currentSize;
        return i11 == 0 || this.maxSize / i11 >= 2;
    }

    private boolean isSmallEnoughForReuse(int i11) {
        return i11 <= this.maxSize / 2;
    }

    private boolean mayFillRequest(int i11, Integer num) {
        return num != null && (isNoMoreThanHalfFull() || num.intValue() <= i11 * 8);
    }

    public synchronized void clearMemory() {
        evictToSize(0);
    }

    public synchronized <T> T get(int i11, Class<T> cls) {
        Key key;
        Integer ceilingKey = getSizesForAdapter(cls).ceilingKey(Integer.valueOf(i11));
        if (mayFillRequest(i11, ceilingKey)) {
            key = this.keyPool.get(ceilingKey.intValue(), cls);
        } else {
            key = this.keyPool.get(i11, cls);
        }
        return getForKey(key, cls);
    }

    public int getCurrentSize() {
        int i11 = 0;
        for (Class next : this.sortedSizes.keySet()) {
            for (Integer num : this.sortedSizes.get(next).keySet()) {
                i11 += num.intValue() * ((Integer) this.sortedSizes.get(next).get(num)).intValue() * getAdapterFromType(next).getElementSizeInBytes();
            }
        }
        return i11;
    }

    public synchronized <T> T getExact(int i11, Class<T> cls) {
        return getForKey(this.keyPool.get(i11, cls), cls);
    }

    @Deprecated
    public <T> void put(T t11, Class<T> cls) {
        put(t11);
    }

    public synchronized void trimMemory(int i11) {
        if (i11 >= 40) {
            try {
                clearMemory();
            } catch (Throwable th2) {
                throw th2;
            }
        } else if (i11 >= 20 || i11 == 15) {
            evictToSize(this.maxSize / 2);
        }
    }

    public synchronized <T> void put(T t11) {
        Class<?> cls = t11.getClass();
        ArrayAdapterInterface<?> adapterFromType = getAdapterFromType(cls);
        int arrayLength = adapterFromType.getArrayLength(t11);
        int elementSizeInBytes = adapterFromType.getElementSizeInBytes() * arrayLength;
        if (isSmallEnoughForReuse(elementSizeInBytes)) {
            Key key = this.keyPool.get(arrayLength, cls);
            this.groupedMap.put(key, t11);
            NavigableMap<Integer, Integer> sizesForAdapter = getSizesForAdapter(cls);
            Integer num = sizesForAdapter.get(Integer.valueOf(key.size));
            Integer valueOf = Integer.valueOf(key.size);
            int i11 = 1;
            if (num != null) {
                i11 = 1 + num.intValue();
            }
            sizesForAdapter.put(valueOf, Integer.valueOf(i11));
            this.currentSize += elementSizeInBytes;
            evict();
        }
    }

    public LruArrayPool(int i11) {
        this.groupedMap = new GroupedLinkedMap<>();
        this.keyPool = new KeyPool();
        this.sortedSizes = new HashMap();
        this.adapters = new HashMap();
        this.maxSize = i11;
    }
}
