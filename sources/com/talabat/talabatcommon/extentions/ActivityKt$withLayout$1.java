package com.talabat.talabatcommon.extentions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import d2.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/talabat/talabatcommon/extentions/ActivityKt$withLayout$1", "Landroidx/lifecycle/DefaultLifecycleObserver;", "onCreate", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ActivityKt$withLayout$1 implements DefaultLifecycleObserver {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AppCompatActivity f46879b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f46880c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Function1<AppCompatActivity, Unit> f46881d;

    public ActivityKt$withLayout$1(AppCompatActivity appCompatActivity, int i11, Function1<? super AppCompatActivity, Unit> function1) {
        this.f46879b = appCompatActivity;
        this.f46880c = i11;
        this.f46881d = function1;
    }

    public void onCreate(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        a.a(this, lifecycleOwner);
        this.f46879b.setContentView(this.f46880c);
        this.f46881d.invoke(this.f46879b);
    }

    public /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner) {
        a.b(this, lifecycleOwner);
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
