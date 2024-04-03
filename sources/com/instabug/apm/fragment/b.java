package com.instabug.apm.fragment;

import androidx.fragment.app.Fragment;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.instabug.apm.fragment.FragmentEventDispatcher;
import com.instabug.apm.model.e;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

public final class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Fragment f45310b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ e f45311c;

    public b(Fragment fragment, e eVar) {
        this.f45310b = fragment;
        this.f45311c = eVar;
    }

    public final void run() {
        FragmentEventDispatcher.a aVar = FragmentEventDispatcher.f45306a;
        Set a11 = aVar.a();
        Intrinsics.checkNotNullExpressionValue(a11, "listeners");
        Fragment fragment = this.f45310b;
        e eVar = this.f45311c;
        synchronized (a11) {
            Set<s> a12 = aVar.a();
            Intrinsics.checkNotNullExpressionValue(a12, "listeners");
            for (s sVar : a12) {
                Intrinsics.checkNotNullExpressionValue(sVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
                sVar.f(fragment, eVar);
            }
        }
    }
}
