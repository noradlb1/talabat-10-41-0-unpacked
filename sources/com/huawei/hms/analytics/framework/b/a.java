package com.huawei.hms.analytics.framework.b;

import com.huawei.hms.analytics.core.storage.IStorageHandler;
import com.huawei.hms.analytics.framework.config.ICollectorConfig;
import com.huawei.hms.analytics.framework.policy.IStoragePolicy;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    ICollectorConfig f47920a;

    /* renamed from: b  reason: collision with root package name */
    public IStoragePolicy f47921b;

    /* renamed from: c  reason: collision with root package name */
    c f47922c;

    public a(ICollectorConfig iCollectorConfig, IStorageHandler iStorageHandler, IStoragePolicy iStoragePolicy) {
        this.f47920a = iCollectorConfig;
        c cVar = new c();
        this.f47922c = cVar;
        cVar.f47927b = iStorageHandler;
        this.f47921b = iStoragePolicy;
    }
}
