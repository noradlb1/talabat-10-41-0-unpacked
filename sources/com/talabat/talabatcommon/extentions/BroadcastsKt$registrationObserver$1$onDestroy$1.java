package com.talabat.talabatcommon.extentions;

import android.content.BroadcastReceiver;
import android.content.Context;
import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class BroadcastsKt$registrationObserver$1$onDestroy$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Lifecycle.State f46901g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Context f46902h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ BroadcastReceiver f46903i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BroadcastsKt$registrationObserver$1$onDestroy$1(Lifecycle.State state, Context context, BroadcastReceiver broadcastReceiver) {
        super(0);
        this.f46901g = state;
        this.f46902h = context;
        this.f46903i = broadcastReceiver;
    }

    public final void invoke() {
        Context context;
        if (this.f46901g == Lifecycle.State.CREATED && (context = this.f46902h) != null) {
            context.unregisterReceiver(this.f46903i);
        }
    }
}
