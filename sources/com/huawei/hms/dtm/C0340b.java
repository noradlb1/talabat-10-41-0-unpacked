package com.huawei.hms.dtm;

import android.os.Bundle;

/* renamed from: com.huawei.hms.dtm.b  reason: case insensitive filesystem */
public class C0340b implements C0472d {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EventFilter f48255a;

    public C0340b(EventFilter eventFilter) {
        this.f48255a = eventFilter;
    }

    public String getUserProfile(String str) {
        return this.f48255a.getUserProfile(str);
    }

    public void onFiltered(String str, Bundle bundle) {
        this.f48255a.logFilteredEvent(str, bundle);
    }
}
