package com.huawei.location.crowdsourcing;

import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.huawei.location.crowdsourcing.Config;
import com.huawei.location.crowdsourcing.common.util.dC;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.lite.common.util.PermissionUtil;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class yn implements com.huawei.location.crowdsourcing.common.yn {
    private List<com.huawei.location.crowdsourcing.common.entity.yn> Vw = new LinkedList();

    /* renamed from: yn  reason: collision with root package name */
    private long f50089yn;

    private static void yn(List<com.huawei.location.crowdsourcing.common.entity.yn> list) {
        c cVar = new c(SystemClock.elapsedRealtimeNanos(), Config.FB.f50027yn.n());
        Iterator<com.huawei.location.crowdsourcing.common.entity.yn> it = list.iterator();
        while (it.hasNext()) {
            if (cVar.yn(it.next())) {
                it.remove();
            }
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean yn(long j11, long j12, com.huawei.location.crowdsourcing.common.entity.yn ynVar) {
        long abs = Math.abs(ynVar.yn() - j11);
        if (abs <= j12) {
            return false;
        }
        LogConsole.d("CellCollector", "remove expired(ns). timeDiff:" + abs);
        return true;
    }

    @Nullable
    public List<com.huawei.location.crowdsourcing.common.entity.yn> b() {
        List<com.huawei.location.crowdsourcing.common.entity.yn> list;
        Config a11 = Config.FB.f50027yn;
        if (!a11.u()) {
            LogConsole.d("CellCollector", "no need get cell");
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.f50089yn) < a11.a()) {
            LogConsole.d("CellCollector", "collect interval check failed");
            return null;
        }
        if (!PermissionUtil.checkSelfPermission(Vw.b(), "android.permission.ACCESS_FINE_LOCATION")) {
            LogConsole.e("CellCollector", "check permission failed");
            list = new LinkedList<>();
        } else {
            list = com.huawei.location.crowdsourcing.common.entity.yn.yn(dC.yn(Vw.b()));
        }
        yn(list);
        if (list.isEmpty()) {
            LogConsole.d("CellCollector", "no available cell info");
            return null;
        }
        this.Vw = list;
        LogConsole.d("CellCollector", "cell list size." + list.size());
        this.f50089yn = currentTimeMillis;
        a11.i();
        return this.Vw;
    }

    public void yn() {
        LogConsole.w("CellCollector", "Stop");
    }
}
