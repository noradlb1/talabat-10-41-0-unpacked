package com.instabug.library.logging.listeners.networklogs;

import com.instabug.library.model.NetworkLog;
import com.instabug.library.util.extenstions.d;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Instrumented
public final class NetworkLogSnapshotHelper {
    @NotNull
    public static final NetworkLogSnapshotHelper INSTANCE = new NetworkLogSnapshotHelper();

    private NetworkLogSnapshotHelper() {
    }

    public final void applyNetworkLogChanges(@NotNull NetworkLog networkLog, @Nullable NetworkLogSnapshot networkLogSnapshot) {
        String str;
        JSONObject a11;
        JSONObject a12;
        Intrinsics.checkNotNullParameter(networkLog, "networkLog");
        if (networkLogSnapshot != null) {
            if (!Intrinsics.areEqual((Object) networkLogSnapshot, (Object) getNetworkLogSnapshot(networkLog))) {
                Map<String, Object> requestHeaders = networkLogSnapshot.getRequestHeaders();
                String str2 = null;
                if (requestHeaders == null || (a12 = d.a((Map) requestHeaders)) == null) {
                    str = null;
                } else {
                    str = JSONObjectInstrumentation.toString(a12);
                }
                Map<String, Object> responseHeaders = networkLogSnapshot.getResponseHeaders();
                if (!(responseHeaders == null || (a11 = d.a((Map) responseHeaders)) == null)) {
                    str2 = JSONObjectInstrumentation.toString(a11);
                }
                networkLog.setUserModified(true);
                networkLog.setUrl(networkLogSnapshot.getUrl());
                networkLog.setRequestHeaders(str);
                networkLog.setRequest(networkLogSnapshot.getRequestBody());
                networkLog.setResponseHeaders(str2);
                networkLog.setResponse(networkLogSnapshot.getResponse());
            }
            networkLog.insert();
        }
    }

    @NotNull
    public final NetworkLogSnapshot getNetworkLogSnapshot(@NotNull NetworkLog networkLog) {
        Map map;
        Intrinsics.checkNotNullParameter(networkLog, "networkLog");
        String requestHeaders = networkLog.getRequestHeaders();
        Map map2 = null;
        if (requestHeaders == null) {
            map = null;
        } else {
            map = d.a(new JSONObject(requestHeaders));
        }
        String responseHeaders = networkLog.getResponseHeaders();
        if (responseHeaders != null) {
            map2 = d.a(new JSONObject(responseHeaders));
        }
        return new NetworkLogSnapshot(networkLog.getUrl(), map, networkLog.getRequest(), map2, networkLog.getResponse());
    }
}
