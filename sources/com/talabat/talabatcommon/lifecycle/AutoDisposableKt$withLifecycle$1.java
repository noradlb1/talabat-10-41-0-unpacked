package com.talabat.talabatcommon.lifecycle;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import d2.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/talabat/talabatcommon/lifecycle/AutoDisposableKt$withLifecycle$1", "Landroidx/lifecycle/DefaultLifecycleObserver;", "onCreate", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onDestroy", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AutoDisposableKt$withLifecycle$1 implements DefaultLifecycleObserver {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1<T, Unit> f61764b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ T f61765c;

    public AutoDisposableKt$withLifecycle$1(Function1<? super T, Unit> function1, T t11) {
        this.f61764b = function1;
        this.f61765c = t11;
    }

    public void onCreate(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        this.f61764b.invoke(this.f61765c);
    }

    public void onDestroy(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        this.f61765c.onCleared();
    }

    public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
        a.c(this, lifecycleOwner);
    }

    public /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
        a.d(this, lifecycleOwner);
    }

    public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
        a.e(this, lifecycleOwner);
    }

    public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
        a.f(this, lifecycleOwner);
    }
}
