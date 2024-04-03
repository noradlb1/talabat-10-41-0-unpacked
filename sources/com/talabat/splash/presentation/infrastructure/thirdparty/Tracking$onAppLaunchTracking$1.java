package com.talabat.splash.presentation.infrastructure.thirdparty;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import tracking.AppTracker;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class Tracking$onAppLaunchTracking$1 extends Lambda implements Function1<Boolean, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Uri f61514g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f61515h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f61516i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Tracking$onAppLaunchTracking$1(Uri uri, boolean z11, String str) {
        super(1);
        this.f61514g = uri;
        this.f61515h = z11;
        this.f61516i = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z11) {
        if (z11) {
            Uri uri = this.f61514g;
            AppTracker.observeAppLaunchEvent(uri != null ? uri.getQuery() : null, this.f61515h, this.f61516i);
        }
    }
}
