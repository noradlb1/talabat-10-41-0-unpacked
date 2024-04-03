package com.talabat.talabatcommon.extentions;

import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class BroadcastsKt$registerToBroadcast$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Fragment f46885g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f46886h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Lifecycle.State f46887i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function1<Intent, Unit> f46888j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BroadcastsKt$registerToBroadcast$1(Fragment fragment, String str, Lifecycle.State state, Function1<? super Intent, Unit> function1) {
        super(0);
        this.f46885g = fragment;
        this.f46886h = str;
        this.f46887i = state;
        this.f46888j = function1;
    }

    public final void invoke() {
        this.f46885g.getLifecycle().addObserver(BroadcastsKt.registrationObserver(this.f46886h, this.f46887i, this.f46885g.getActivity(), BroadcastsKt.receiver(this.f46888j)));
    }
}
