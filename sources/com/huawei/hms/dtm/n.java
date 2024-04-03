package com.huawei.hms.dtm;

import android.os.Bundle;
import com.huawei.hms.dtm.provider.api.IDtmFilter;

public class n extends IDtmFilter.Stub {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0472d f48663a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ o f48664b;

    public n(o oVar, C0472d dVar) {
        this.f48664b = oVar;
        this.f48663a = dVar;
    }

    public String getUserProfile(String str) {
        return this.f48663a.getUserProfile(str);
    }

    public void onFiltered(String str, Bundle bundle) {
        this.f48663a.onFiltered(str, bundle);
    }
}
