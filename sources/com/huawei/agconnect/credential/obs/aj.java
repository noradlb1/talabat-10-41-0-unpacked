package com.huawei.agconnect.credential.obs;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.hms.analytics.connector.ConnectorManager;
import java.util.HashMap;
import java.util.Map;

public final class aj implements ai {

    /* renamed from: a  reason: collision with root package name */
    al f47564a;

    /* renamed from: b  reason: collision with root package name */
    private ConnectorManager f47565b;

    public aj(Context context, al alVar) {
        a(context, alVar);
    }

    public final Map<String, String> a(boolean z11) {
        ConnectorManager connectorManager = this.f47565b;
        return connectorManager != null ? connectorManager.getUserProfiles(z11) : new HashMap();
    }

    public final void a() {
        ConnectorManager connectorManager = this.f47565b;
        if (connectorManager != null) {
            connectorManager.onReport();
        }
    }

    public final void a(Context context, al alVar) {
        this.f47564a = alVar;
        try {
            if (TextUtils.isEmpty(alVar.f47569c)) {
                this.f47565b = new ConnectorManager(context, alVar.f47567a, alVar.f47568b);
            } else {
                this.f47565b = new ConnectorManager(context, alVar.f47567a, alVar.f47568b, alVar.f47569c);
            }
        } catch (Exception | NoClassDefFoundError unused) {
            Log.e("BridgeInstance", "createInstance error");
            this.f47565b = null;
        }
    }

    public final void a(String str, Bundle bundle) {
        ConnectorManager connectorManager = this.f47565b;
        if (connectorManager != null) {
            connectorManager.onEvent(str, bundle);
        }
    }
}
