package com.google.i18n.phonenumbers.internal;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class RegexCache {
    private LRUCache<String, Pattern> cache;

    public static class LRUCache<K, V> {
        private LinkedHashMap<K, V> map;
        /* access modifiers changed from: private */
        public int size;

        public LRUCache(int i11) {
            this.size = i11;
            this.map = new LinkedHashMap<K, V>(((i11 * 4) / 3) + 1, 0.75f, true) {
                public boolean removeEldestEntry(Map.Entry<K, V> entry) {
                    return size() > LRUCache.this.size;
                }
            };
        }

        public synchronized boolean containsKey(K k11) {
            return this.map.containsKey(k11);
        }

        public synchronized V get(K k11) {
            return this.map.get(k11);
        }

        public synchronized void put(K k11, V v11) {
            this.map.put(k11, v11);
        }
    }

    public RegexCache(int i11) {
        this.cache = new LRUCache<>(i11);
    }

    public boolean containsRegex(String str) {
        return this.cache.containsKey(str);
    }

    public Pattern getPatternForRegex(String str) {
        Pattern pattern = this.cache.get(str);
        if (pattern != null) {
            return pattern;
        }
        Pattern compile = Pattern.compile(str);
        this.cache.put(str, compile);
        return compile;
    }
}
