package com.huawei.wearengine;

import com.huawei.wearengine.c;
import com.huawei.wearengine.common.a;
import com.huawei.wearengine.d;
import java.lang.ref.WeakReference;

public class b<T extends c> implements d.b {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<T> f35125a;

    public b(WeakReference<T> weakReference) {
        this.f35125a = weakReference;
    }

    public void a() {
        WeakReference<T> weakReference = this.f35125a;
        if (weakReference == null) {
            a.a("WearEngineReleaseConnectCallback", "onReleaseConnection mWeakReference is null");
            return;
        }
        c cVar = (c) weakReference.get();
        if (cVar != null) {
            cVar.clearBinderProxy();
        }
    }
}
