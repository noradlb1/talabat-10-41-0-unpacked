package com.instabug.apm.fragment;

import androidx.fragment.app.Fragment;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.instabug.apm.fragment.FragmentEventDispatcher;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

public final class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Fragment f45316b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ com.instabug.apm.model.e f45317c;

    public e(Fragment fragment, com.instabug.apm.model.e eVar) {
        this.f45316b = fragment;
        this.f45317c = eVar;
    }

    public final void run() {
        FragmentEventDispatcher.a aVar = FragmentEventDispatcher.f45306a;
        Set a11 = aVar.a();
        Intrinsics.checkNotNullExpressionValue(a11, "listeners");
        Fragment fragment = this.f45316b;
        com.instabug.apm.model.e eVar = this.f45317c;
        synchronized (a11) {
            Set<s> a12 = aVar.a();
            Intrinsics.checkNotNullExpressionValue(a12, "listeners");
            for (s sVar : a12) {
                Intrinsics.checkNotNullExpressionValue(sVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
                sVar.r(fragment, eVar);
            }
        }
    }
}
