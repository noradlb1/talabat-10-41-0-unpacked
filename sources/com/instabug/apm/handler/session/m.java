package com.instabug.apm.handler.session;

import androidx.annotation.NonNull;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

public class m implements l {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final Set f45409a = Collections.newSetFromMap(new ConcurrentHashMap());

    @NonNull
    public Collection a() {
        return Collections.unmodifiableCollection(this.f45409a);
    }

    public void a(@NonNull a aVar) {
        this.f45409a.add(aVar);
    }
}
