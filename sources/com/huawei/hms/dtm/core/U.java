package com.huawei.hms.dtm.core;

import android.content.Context;
import android.os.Bundle;
import com.huawei.hms.dtm.core.safe.SafeBundle;
import com.huawei.hms.dtm.core.util.Logger;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

public class U {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f48421a;

    /* renamed from: b  reason: collision with root package name */
    private final K f48422b;

    /* renamed from: c  reason: collision with root package name */
    private final Nc f48423c;

    public U(K k11, Nc nc2) {
        this.f48421a = k11.getCoreExecutor();
        this.f48423c = nc2;
        this.f48422b = k11;
    }

    public static Bundle a(Bundle bundle) {
        if (bundle == null || !bundle.toString().contains("$DTM_VP_")) {
            return bundle;
        }
        Bundle bundle2 = new Bundle();
        for (String next : bundle.keySet()) {
            if (next != null) {
                String replace = next.startsWith("$DTM_VP_") ? next.replace("$DTM_VP_", "") : next;
                Object obj = bundle.get(next);
                if (C0343aa.a(obj)) {
                    bundle2.putSerializable(replace, (Serializable) obj);
                } else if (obj instanceof Bundle) {
                    bundle2.putParcelable(replace, (Bundle) obj);
                } else if (obj instanceof ArrayList) {
                    bundle2.putParcelableArrayList(replace, (ArrayList) obj);
                }
            }
        }
        return bundle2;
    }

    private List<Oc> a(X x11) {
        int i11;
        ArrayList arrayList = new ArrayList();
        Bundle b11 = x11.b();
        if (b11 != null && (i11 = b11.getInt("$DTM_AT_VP_CONDITION_INDEX", -1)) >= 0) {
            arrayList.add(this.f48423c.b().get(i11));
        }
        return arrayList;
    }

    private void a(X x11, Set<Qc<?>> set) {
        for (Qc next : set) {
            if (next != null) {
                String name2 = next.getName();
                try {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(" tag.execute tag = ");
                    sb2.append(name2);
                    Logger.info("DTM-Execute", sb2.toString());
                    next.a(x11.a());
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(name2);
                    sb3.append(" execute succeed.");
                    Logger.info("DTM-Execute", sb3.toString());
                } catch (V e11) {
                    Logger.error("DTM-Execute", name2 + " execute fail with exception: " + e11.getMessage());
                }
            }
        }
    }

    private void a(String str, Bundle bundle, boolean z11, X x11) {
        if (z11 && this.f48422b.isReportToHwAnalytics()) {
            C0435sc<?> a11 = x11.a("dtm.needSendToHA");
            if ((a11 instanceof C0430rc) && ((Boolean) ((C0430rc) a11).value()).booleanValue()) {
                Logger.debug("DTM-Execute", "log filtered to HA end");
                try {
                    x11.onEventExecuted(str, a(bundle));
                    Logger.debug("DTM-Execute", "Report original event to HA succeed.");
                    C0391jd.a().a(DynamicTagManager.getInstance().getConfigurationID()).e("HA").c("200").b();
                } catch (V e11) {
                    Logger.warn("DTM-Execute", "Report original event to HA failed: " + e11.getMessage());
                }
            }
        }
    }

    private void b(X x11) {
        Bundle b11 = x11 != null ? x11.b() : null;
        if (b11 != null) {
            Iterator<String> it = new SafeBundle(b11).keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next != null && next.startsWith("$DTM_AT_")) {
                    it.remove();
                }
            }
        }
    }

    private void b(X x11, Set<Qc<?>> set) {
        List<Oc> a11 = a(x11);
        if (a11.isEmpty()) {
            a11 = this.f48423c.b();
        }
        HashSet hashSet = new HashSet();
        for (Oc next : a11) {
            try {
                if (next.a(x11)) {
                    set.addAll(next.a());
                    hashSet.addAll(next.b());
                }
            } catch (V e11) {
                Logger.error("DTM-Execute", "Condition match exception#" + e11.getMessage());
            }
        }
        set.removeAll(hashSet);
    }

    /* access modifiers changed from: private */
    public void b(String str, Bundle bundle, boolean z11) {
        Context a11 = J.a();
        if (a11 == null) {
            Logger.error("DTM-Execute", "context is null#Before application.onCreate");
            return;
        }
        Logger.debug("DTM-Execute", "Start match event#" + str);
        X a12 = new X(this.f48422b).a(a11).a(bundle).a("dtm.eventName", new Cc(str)).a("dtm.needSendToHA", C0430rc.a(true));
        HashSet hashSet = new HashSet();
        boolean z12 = false;
        if (bundle != null) {
            z12 = bundle.getBoolean("$DTM_AT_VP_NO_TAG", false);
        }
        if (!z12) {
            b(a12, hashSet);
        }
        if (hashSet.isEmpty()) {
            Logger.debug("DTM-Execute", "no tag matched#" + str);
        }
        b(a12);
        a(a12, hashSet);
        a(str, bundle, z11, a12);
        Logger.debug("DTM-Execute", "End match event#" + str);
    }

    public void a(String str, Bundle bundle, boolean z11) {
        this.f48421a.execute(new T(this, str, bundle, z11));
    }
}
