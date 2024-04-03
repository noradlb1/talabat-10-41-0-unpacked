package com.newrelic.agent.android.payload;

import java.util.ArrayList;
import java.util.List;

public class NullPayloadStore<T> implements PayloadStore<T> {
    public void clear() {
    }

    public int count() {
        return 0;
    }

    public void delete(T t11) {
    }

    public List<T> fetchAll() {
        return new ArrayList();
    }

    public boolean store(T t11) {
        return true;
    }
}
