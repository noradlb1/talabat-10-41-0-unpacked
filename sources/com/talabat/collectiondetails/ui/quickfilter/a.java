package com.talabat.collectiondetails.ui.quickfilter;

import com.google.android.material.appbar.AppBarLayout;
import com.talabat.collectiondetails.ui.quickfilter.UnsubscribeCollectionActivity;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UnsubscribeCollectionActivity.AnonymousClass1 f55677b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AppBarLayout f55678c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f55679d;

    public /* synthetic */ a(UnsubscribeCollectionActivity.AnonymousClass1 r12, AppBarLayout appBarLayout, int i11) {
        this.f55677b = r12;
        this.f55678c = appBarLayout;
        this.f55679d = i11;
    }

    public final void run() {
        this.f55677b.lambda$onOffsetChanged$0(this.f55678c, this.f55679d);
    }
}
