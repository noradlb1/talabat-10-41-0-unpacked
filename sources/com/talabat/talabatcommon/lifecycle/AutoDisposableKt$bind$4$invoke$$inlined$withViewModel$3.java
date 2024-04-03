package com.talabat.talabatcommon.lifecycle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "", "VM", "Landroidx/lifecycle/ViewModel;", "invoke", "com/talabat/talabatcommon/lifecycle/AutoDisposableKt$withViewModel$3"}, k = 3, mv = {1, 6, 0}, xi = 176)
public final class AutoDisposableKt$bind$4$invoke$$inlined$withViewModel$3 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ AutoDisposable f61747g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1 f61748h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AutoDisposableKt$bind$4$invoke$$inlined$withViewModel$3(AutoDisposable autoDisposable, Function1 function1) {
        super(0);
        this.f61747g = autoDisposable;
        this.f61748h = function1;
    }

    public final void invoke() {
        ViewModelProvider of2 = ViewModelProviders.of((Fragment) this.f61747g);
        Intrinsics.reifiedOperationMarker(4, "VM");
        this.f61748h.invoke(of2.get(ViewModel.class));
    }
}
