package com.instabug.library.diagnostics;

import com.instabug.library.diagnostics.network.a;
import com.instabug.library.diagnostics.nonfatals.e;
import com.instabug.library.diagnostics.sdkEvents.f;
import com.instabug.library.networkv2.request.RequestParameter;
import com.instabug.library.util.InstabugSDKLogger;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public final class h implements a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ i f34288a;

    public h(i iVar) {
        this.f34288a = iVar;
    }

    public void a(@NotNull List list) {
        Object obj;
        Object obj2;
        JSONObject jSONObject;
        Intrinsics.checkNotNullParameter(list, "requestParameters");
        InstabugSDKLogger.d("IBG-Core", "Diagnostics synced successfully");
        this.f34288a.e().setDiagnosticsLastSyncTime(System.currentTimeMillis());
        e b11 = this.f34288a.d();
        if (b11 != null) {
            b11.clearCache();
        }
        List list2 = null;
        com.instabug.library.diagnostics.sdkEvents.a.a(list, (f) null, 2, (Object) null);
        com.instabug.library.diagnostics.customtraces.a a11 = this.f34288a.b();
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((Object) ((RequestParameter) obj).getKey(), (Object) "custom_traces")) {
                break;
            }
        }
        RequestParameter requestParameter = (RequestParameter) obj;
        if (requestParameter == null) {
            obj2 = null;
        } else {
            obj2 = requestParameter.getValue();
        }
        if (obj2 instanceof JSONObject) {
            jSONObject = (JSONObject) obj2;
        } else {
            jSONObject = null;
        }
        if (jSONObject != null) {
            list2 = com.instabug.library.diagnostics.customtraces.utils.a.b(jSONObject);
        }
        a11.clearSyncedTraces(list2);
    }

    public void onFailed(@NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "throwable");
        InstabugSDKLogger.e("IBG-Core", "Something went wrong while syncing Diagnostics", th2);
    }
}
