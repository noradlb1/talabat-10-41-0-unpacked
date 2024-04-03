package com.newrelic.agent.android.payload;

import java.util.List;

public interface PayloadStore<T> {
    void clear();

    int count();

    void delete(T t11);

    List<T> fetchAll();

    boolean store(T t11);
}
