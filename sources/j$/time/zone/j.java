package j$.time.zone;

import j$.util.concurrent.ConcurrentHashMap;
import java.security.AccessController;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class j {

    /* renamed from: a  reason: collision with root package name */
    private static final CopyOnWriteArrayList f28538a;

    /* renamed from: b  reason: collision with root package name */
    private static final ConcurrentHashMap f28539b = new ConcurrentHashMap(512, 0.75f, 2);

    static {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        f28538a = copyOnWriteArrayList;
        ArrayList arrayList = new ArrayList();
        AccessController.doPrivileged(new h(arrayList));
        copyOnWriteArrayList.addAll(arrayList);
    }

    protected j() {
    }

    public static f a(String str, boolean z11) {
        Objects.requireNonNull(str, "zoneId");
        ConcurrentHashMap concurrentHashMap = f28539b;
        j jVar = (j) concurrentHashMap.get(str);
        if (jVar != null) {
            return jVar.b(str);
        }
        if (concurrentHashMap.isEmpty()) {
            throw new g("No time-zone data files registered");
        }
        throw new g("Unknown time-zone ID: ".concat(str));
    }

    public static void d(j jVar) {
        Objects.requireNonNull(jVar, "provider");
        synchronized (j.class) {
            for (String str : jVar.c()) {
                Objects.requireNonNull(str, "zoneId");
                if (((j) f28539b.putIfAbsent(str, jVar)) != null) {
                    throw new g("Unable to register zone as one already registered with that ID: " + str + ", currently loading from provider: " + jVar);
                }
            }
            Collections.unmodifiableSet(new HashSet(f28539b.keySet()));
        }
        f28538a.add(jVar);
    }

    /* access modifiers changed from: protected */
    public abstract f b(String str);

    /* access modifiers changed from: protected */
    public abstract Set c();
}
