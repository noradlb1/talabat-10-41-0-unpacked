package org.junit.platform.commons.util;

import java.util.LinkedHashMap;
import java.util.Map;
import org.apiguardian.api.API;

@API(since = "1.6", status = API.Status.INTERNAL)
public class LruCache<K, V> extends LinkedHashMap<K, V> {
    private static final long serialVersionUID = 1;
    private final int maxSize;

    public LruCache(int i11) {
        super(i11 + 1, 1.0f, true);
        this.maxSize = i11;
    }

    public boolean removeEldestEntry(Map.Entry<K, V> entry) {
        return size() > this.maxSize;
    }
}
