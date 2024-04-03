package com.instabug.apm.fragment;

import androidx.fragment.app.Fragment;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.instabug.apm.fragment.FragmentEventDispatcher;
import com.instabug.apm.model.e;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

public final class n implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Fragment f45341b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ e f45342c;

    public n(Fragment fragment, e eVar) {
        this.f45341b = fragment;
        this.f45342c = eVar;
    }

    public final void run() {
        FragmentEventDispatcher.a aVar = FragmentEventDispatcher.f45306a;
        Set a11 = aVar.a();
        Intrinsics.checkNotNullExpressionValue(a11, "listeners");
        Fragment fragment = this.f45341b;
        e eVar = this.f45342c;
        synchronized (a11) {
            Set<s> a12 = aVar.a();
            Intrinsics.checkNotNullExpressionValue(a12, "listeners");
            for (s sVar : a12) {
                Intrinsics.checkNotNullExpressionValue(sVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
                sVar.a(fragment, eVar);
            }
        }
    }
}
