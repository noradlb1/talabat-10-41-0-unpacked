package com.instabug.library.model.session;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.Map;

@Keep
public class SessionRemoteEntity {

    /* renamed from: id  reason: collision with root package name */
    private final String f51584id;
    @NonNull
    private final Map<String, Object> map;

    public SessionRemoteEntity(String str, @NonNull Map<String, Object> map2) {
        this.f51584id = str;
        this.map = map2;
    }

    @NonNull
    public String getId() {
        return this.f51584id;
    }

    @NonNull
    public Map<String, Object> getMap() {
        return Collections.unmodifiableMap(this.map);
    }
}
