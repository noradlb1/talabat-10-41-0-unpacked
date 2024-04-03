package com.talabat.talabatcommon.lifecycle;

import android.content.Context;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 176)
public final class AutoDisposableKt$withViewModel$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ AutoDisposable f61770g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<VM, Unit> f61771h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AutoDisposableKt$withViewModel$1(AutoDisposable autoDisposable, Function1<? super VM, Unit> function1) {
        super(0);
        this.f61770g = autoDisposable;
        this.f61771h = function1;
    }

    public final void invoke() {
        Context context = ((View) this.f61770g).getContext();
        Class<ViewModel> cls = ViewModel.class;
        if (context instanceof AppCompatActivity) {
            Function1<VM, Unit> function1 = this.f61771h;
            ViewModelProvider of2 = ViewModelProviders.of((FragmentActivity) context);
            Intrinsics.reifiedOperationMarker(4, "VM");
            function1.invoke(of2.get(cls));
        } else if (context instanceof FragmentActivity) {
            Function1<VM, Unit> function12 = this.f61771h;
            ViewModelProvider of3 = ViewModelProviders.of((FragmentActivity) context);
            Intrinsics.reifiedOperationMarker(4, "VM");
            function12.invoke(of3.get(cls));
        } else if (context instanceof Fragment) {
            Function1<VM, Unit> function13 = this.f61771h;
            ViewModelProvider of4 = ViewModelProviders.of((Fragment) context);
            Intrinsics.reifiedOperationMarker(4, "VM");
            function13.invoke(of4.get(cls));
        } else {
            throw new UnsupportedOperationException("ViewModelProviders works with Activities and Fragment hosts only");
        }
    }
}
