package com.huawei.agconnect.common.network;

import android.content.Context;
import android.os.Bundle;
import com.huawei.agconnect.common.appinfo.SafeAppInfo;
import com.huawei.agconnect.common.network.AccessNetworkManager;
import com.huawei.agconnect.credential.obs.w;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class a extends AccessNetworkManager {

    /* renamed from: a  reason: collision with root package name */
    private final List<AccessNetworkManager.AccessNetworkCallback> f47467a = new CopyOnWriteArrayList();

    /* renamed from: b  reason: collision with root package name */
    private Context f47468b = w.a().b();

    private void a() {
        for (AccessNetworkManager.AccessNetworkCallback onNetWorkReady : this.f47467a) {
            onNetWorkReady.onNetWorkReady();
        }
    }

    private void a(AccessNetworkManager.AccessNetworkCallback accessNetworkCallback) {
        if (b()) {
            accessNetworkCallback.onNetWorkReady();
        }
    }

    private void a(boolean z11) {
        b.a().a(z11);
    }

    private boolean b() {
        Bundle bundle = SafeAppInfo.safeGetApplicationInfo(this.f47468b.getPackageManager(), this.f47468b.getPackageName(), 128).metaData;
        return bundle == null || !"false".equalsIgnoreCase(String.valueOf(bundle.get("com.huawei.agconnect.AccessNetwork"))) || b.a().b();
    }

    public void addCallback(AccessNetworkManager.AccessNetworkCallback accessNetworkCallback) {
        if (accessNetworkCallback != null) {
            this.f47467a.add(accessNetworkCallback);
            a(accessNetworkCallback);
        }
    }

    public void setAccessNetwork(boolean z11) {
        a(z11);
        if (z11) {
            a();
        }
    }
}
