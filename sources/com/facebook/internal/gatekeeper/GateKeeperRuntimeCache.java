package com.facebook.internal.gatekeeper;

import com.facebook.FacebookSdk;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\"\u0010\t\u001a\u00020\b2\f\b\u0002\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u001c\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\f\b\u0002\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003J$\u0010\u000e\u001a\u00020\f2\f\b\u0002\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fJ$\u0010\u0010\u001a\u00020\b2\f\b\u0002\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\fJ\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00062\f\b\u0002\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u000b\u001a\u00020\u0002J\u001c\u0010\u0013\u001a\u00020\b2\f\b\u0002\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0012\u001a\u00020\u0006J\u0014\u0010\u0014\u001a\u00020\b2\f\b\u0002\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003R0\u0010\u0016\u001a\u001e\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00150\u00158\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/facebook/internal/gatekeeper/GateKeeperRuntimeCache;", "", "", "Lcom/facebook/internal/gatekeeper/AppID;", "appId", "", "Lcom/facebook/internal/gatekeeper/GateKeeper;", "gateKeeperList", "", "setGateKeepers", "dumpGateKeepers", "name", "", "defaultValue", "getGateKeeperValue", "value", "setGateKeeperValue", "getGateKeeper", "gateKeeper", "setGateKeeper", "resetCache", "j$/util/concurrent/ConcurrentHashMap", "gateKeepers", "Lj$/util/concurrent/ConcurrentHashMap;", "<init>", "()V", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class GateKeeperRuntimeCache {
    @NotNull
    private final ConcurrentHashMap<String, ConcurrentHashMap<String, GateKeeper>> gateKeepers = new ConcurrentHashMap<>();

    public static /* synthetic */ List dumpGateKeepers$default(GateKeeperRuntimeCache gateKeeperRuntimeCache, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = FacebookSdk.getApplicationId();
        }
        return gateKeeperRuntimeCache.dumpGateKeepers(str);
    }

    public static /* synthetic */ GateKeeper getGateKeeper$default(GateKeeperRuntimeCache gateKeeperRuntimeCache, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = FacebookSdk.getApplicationId();
        }
        return gateKeeperRuntimeCache.getGateKeeper(str, str2);
    }

    public static /* synthetic */ boolean getGateKeeperValue$default(GateKeeperRuntimeCache gateKeeperRuntimeCache, String str, String str2, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = FacebookSdk.getApplicationId();
        }
        return gateKeeperRuntimeCache.getGateKeeperValue(str, str2, z11);
    }

    public static /* synthetic */ void resetCache$default(GateKeeperRuntimeCache gateKeeperRuntimeCache, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = FacebookSdk.getApplicationId();
        }
        gateKeeperRuntimeCache.resetCache(str);
    }

    public static /* synthetic */ void setGateKeeper$default(GateKeeperRuntimeCache gateKeeperRuntimeCache, String str, GateKeeper gateKeeper, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = FacebookSdk.getApplicationId();
        }
        gateKeeperRuntimeCache.setGateKeeper(str, gateKeeper);
    }

    public static /* synthetic */ void setGateKeeperValue$default(GateKeeperRuntimeCache gateKeeperRuntimeCache, String str, String str2, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = FacebookSdk.getApplicationId();
        }
        gateKeeperRuntimeCache.setGateKeeperValue(str, str2, z11);
    }

    public static /* synthetic */ void setGateKeepers$default(GateKeeperRuntimeCache gateKeeperRuntimeCache, String str, List list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = FacebookSdk.getApplicationId();
        }
        gateKeeperRuntimeCache.setGateKeepers(str, list);
    }

    @Nullable
    public final List<GateKeeper> dumpGateKeepers(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "appId");
        ConcurrentHashMap concurrentHashMap = this.gateKeepers.get(str);
        if (concurrentHashMap == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(concurrentHashMap.size());
        for (Map.Entry value : concurrentHashMap.entrySet()) {
            arrayList.add((GateKeeper) value.getValue());
        }
        return arrayList;
    }

    @Nullable
    public final GateKeeper getGateKeeper(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "appId");
        Intrinsics.checkNotNullParameter(str2, "name");
        ConcurrentHashMap concurrentHashMap = this.gateKeepers.get(str);
        if (concurrentHashMap == null) {
            return null;
        }
        return (GateKeeper) concurrentHashMap.get(str2);
    }

    public final boolean getGateKeeperValue(@NotNull String str, @NotNull String str2, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "appId");
        Intrinsics.checkNotNullParameter(str2, "name");
        GateKeeper gateKeeper = getGateKeeper(str, str2);
        if (gateKeeper == null) {
            return z11;
        }
        return gateKeeper.getValue();
    }

    public final void resetCache(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "appId");
        this.gateKeepers.remove(str);
    }

    public final void setGateKeeper(@NotNull String str, @NotNull GateKeeper gateKeeper) {
        Intrinsics.checkNotNullParameter(str, "appId");
        Intrinsics.checkNotNullParameter(gateKeeper, "gateKeeper");
        if (!this.gateKeepers.containsKey(str)) {
            this.gateKeepers.put(str, new ConcurrentHashMap());
        }
        ConcurrentHashMap concurrentHashMap = this.gateKeepers.get(str);
        if (concurrentHashMap != null) {
            concurrentHashMap.put(gateKeeper.getName(), gateKeeper);
        }
    }

    public final void setGateKeeperValue(@NotNull String str, @NotNull String str2, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "appId");
        Intrinsics.checkNotNullParameter(str2, "name");
        setGateKeeper(str, new GateKeeper(str2, z11));
    }

    public final void setGateKeepers(@NotNull String str, @NotNull List<GateKeeper> list) {
        Intrinsics.checkNotNullParameter(str, "appId");
        Intrinsics.checkNotNullParameter(list, "gateKeeperList");
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (GateKeeper gateKeeper : list) {
            concurrentHashMap.put(gateKeeper.getName(), gateKeeper);
        }
        this.gateKeepers.put(str, concurrentHashMap);
    }
}
