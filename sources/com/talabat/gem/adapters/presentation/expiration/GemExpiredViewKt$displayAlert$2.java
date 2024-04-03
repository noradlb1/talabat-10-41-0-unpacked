package com.talabat.gem.adapters.presentation.expiration;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemExpiredViewKt$displayAlert$2 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Context f60054g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f60055h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f60056i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemExpiredViewKt$displayAlert$2(Context context, Function0<Unit> function0, boolean z11) {
        super(0);
        this.f60054g = context;
        this.f60055h = function0;
        this.f60056i = z11;
    }

    public final void invoke() {
        GemExpiredViewKt.buildAlertDialog(this.f60054g, this.f60055h, this.f60056i);
    }
}
