package com.talabat.talabatcommon.extentions;

import android.content.BroadcastReceiver;
import android.content.Context;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u000b"}, d2 = {"com/talabat/talabatcommon/extentions/BroadcastsKt$registrationObserver$1", "Landroidx/lifecycle/DefaultLifecycleObserver;", "onCreate", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onDestroy", "onPause", "onResume", "onStart", "onStop", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BroadcastsKt$registrationObserver$1 implements DefaultLifecycleObserver {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Lifecycle.State f46893b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f46894c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ BroadcastReceiver f46895d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f46896e;

    public BroadcastsKt$registrationObserver$1(Lifecycle.State state, Context context, BroadcastReceiver broadcastReceiver, String str) {
        this.f46893b = state;
        this.f46894c = context;
        this.f46895d = broadcastReceiver;
        this.f46896e = str;
    }

    public void onCreate(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        CoroutinesKt.runHandling$default((Function1) null, new BroadcastsKt$registrationObserver$1$onCreate$1(this.f46893b, this.f46894c, this.f46895d, this.f46896e), 1, (Object) null);
    }

    public void onDestroy(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        CoroutinesKt.runHandling$default((Function1) null, new BroadcastsKt$registrationObserver$1$onDestroy$1(this.f46893b, this.f46894c, this.f46895d), 1, (Object) null);
    }

    public void onPause(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        CoroutinesKt.runHandling$default((Function1) null, new BroadcastsKt$registrationObserver$1$onPause$1(this.f46893b, this.f46894c, this.f46895d), 1, (Object) null);
    }

    public void onResume(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        CoroutinesKt.runHandling$default((Function1) null, new BroadcastsKt$registrationObserver$1$onResume$1(this.f46893b, this.f46894c, this.f46895d, this.f46896e), 1, (Object) null);
    }

    public void onStart(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        CoroutinesKt.runHandling$default((Function1) null, new BroadcastsKt$registrationObserver$1$onStart$1(this.f46893b, this.f46894c, this.f46895d, this.f46896e), 1, (Object) null);
    }

    public void onStop(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        CoroutinesKt.runHandling$default((Function1) null, new BroadcastsKt$registrationObserver$1$onStop$1(this.f46893b, this.f46894c, this.f46895d), 1, (Object) null);
    }
}
