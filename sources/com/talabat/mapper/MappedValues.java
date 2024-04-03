package com.talabat.mapper;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import rs.a;

public class MappedValues {
    private final HashMap<Object, Object> items = new HashMap<>();

    public MappedValues(Collection<Map.Entry<Object, Object>> collection) {
        Observable.fromIterable(collection).blockingForEach(new a(this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(Map.Entry entry) throws Exception {
        this.items.put(entry.getKey(), entry.getValue());
    }

    public <T> T b() {
        return this.items.values().toArray()[0];
    }

    public boolean c() {
        return this.items.size() == 1;
    }

    public <T> T get(@NonNull Object obj) throws ClassCastException, IllegalArgumentException {
        if (this.items.containsKey(obj)) {
            return this.items.get(obj);
        }
        throw new IllegalArgumentException("name not available");
    }

    public String toString() {
        return this.items.toString();
    }
}
