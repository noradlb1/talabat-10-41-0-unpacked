package com.instabug.commons.session;

import com.instabug.commons.di.CommonsLocator;
import com.instabug.commons.logging.a;
import com.instabug.commons.models.Incident;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.sessionV3.configurations.IBGSessionCrashesConfigurations;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class d implements g {
    private final f a() {
        return CommonsLocator.INSTANCE.getSessionIncidentCachingHandler();
    }

    private final IBGSessionCrashesConfigurations b() {
        return CommonsLocator.INSTANCE.getSessionCrashesConfigurations();
    }

    public void a(@NotNull Incident incident, int i11) {
        Intrinsics.checkNotNullParameter(incident, "incident");
        String uuid = incident.getMetadata().getUuid();
        if (uuid == null) {
            a.b("Session-Incident linking failed, incident doesn't have uuid");
            return;
        }
        String latestV3SessionId = InstabugCore.getLatestV3SessionId();
        if (latestV3SessionId == null) {
            a.b("Session-Incident linking failed, v3 session is not available");
            return;
        }
        e eVar = new e(latestV3SessionId, uuid, incident.getType(), i11, 0, 16, (DefaultConstructorMarker) null);
        a().a(eVar);
        a(eVar);
    }

    public void a(@NotNull String str, @NotNull Incident.Type type) {
        Intrinsics.checkNotNullParameter(str, "sessionId");
        Intrinsics.checkNotNullParameter(type, "type");
        String latestV3SessionId = InstabugCore.getLatestV3SessionId();
        if (latestV3SessionId == null) {
            a.b("Session-Incident linking failed, v3 session is not available");
        } else if (!Intrinsics.areEqual((Object) str, (Object) latestV3SessionId)) {
            a.b("Session id provided for weak link doesn't match latest v3 session id, aborting ..");
        } else {
            e eVar = new e(latestV3SessionId, (String) null, type, 0, 0, 16, (DefaultConstructorMarker) null);
            a().a(eVar);
            a(eVar);
            a.b(Intrinsics.stringPlus("Trm weak link created for session ", str));
        }
    }

    public void a(@Nullable String str, @Nullable String str2, @NotNull Incident.Type type) {
        Intrinsics.checkNotNullParameter(type, "incidentType");
        if (str == null) {
            a.b("Session-Incident linking failed, v3 session is not available");
        } else {
            a().a(str, str2, type, 1);
        }
    }

    @NotNull
    public Map a(@NotNull List list) {
        boolean z11;
        Intrinsics.checkNotNullParameter(list, "sessionIds");
        List b11 = a().b(list);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object next : b11) {
            String d11 = ((e) next).d();
            Object obj = linkedHashMap.get(d11);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(d11, obj);
            }
            ((List) obj).add(next);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt__MapsJVMKt.mapCapacity(linkedHashMap.size()));
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            Object key = entry.getKey();
            Iterator it = ((Iterable) entry.getValue()).iterator();
            while (true) {
                z11 = true;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    e eVar = (e) it.next();
                    if (!z11 || !eVar.f()) {
                        z11 = false;
                    }
                }
            }
            linkedHashMap2.put(key, Boolean.valueOf(z11));
        }
        Map mutableMap = MapsKt__MapsKt.toMutableMap(linkedHashMap2);
        List minus = CollectionsKt___CollectionsKt.minus(list, (List) mutableMap.keySet());
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(minus, 10)), 16));
        for (Object next2 : minus) {
            String str = (String) next2;
            linkedHashMap3.put(next2, Boolean.TRUE);
        }
        mutableMap.putAll(linkedHashMap3);
        return mutableMap;
    }

    private final void a(e eVar) {
        Incident.Type c11 = eVar.c();
        int i11 = c.f46334a[c11.ordinal()];
        if (i11 == 1) {
            a().a(eVar.d(), c11, b().getNonFatalStoreLimit());
        } else if (i11 == 2) {
            a().a(eVar.d(), c11, b().getAnrStoreLimit());
        } else if (i11 == 3) {
            a().a(eVar.d(), c11, b().getFatalHangStoreLimit());
        }
    }
}
