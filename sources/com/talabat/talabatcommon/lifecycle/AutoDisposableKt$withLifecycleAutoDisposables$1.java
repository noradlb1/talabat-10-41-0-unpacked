package com.talabat.talabatcommon.lifecycle;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0002\u0000\u0003\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0010"}, d2 = {"com/talabat/talabatcommon/lifecycle/AutoDisposableKt$withLifecycleAutoDisposables$1", "Landroidx/lifecycle/DefaultLifecycleObserver;", "autoDisposable", "com/talabat/talabatcommon/lifecycle/AutoDisposableKt$withLifecycleAutoDisposables$1$autoDisposable$1", "getAutoDisposable", "()Lcom/talabat/talabatcommon/lifecycle/AutoDisposableKt$withLifecycleAutoDisposables$1$autoDisposable$1;", "Lcom/talabat/talabatcommon/lifecycle/AutoDisposableKt$withLifecycleAutoDisposables$1$autoDisposable$1;", "onCreate", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onDestroy", "onPause", "onResume", "onStart", "onStop", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AutoDisposableKt$withLifecycleAutoDisposables$1 implements DefaultLifecycleObserver {
    @NotNull
    private final AutoDisposableKt$withLifecycleAutoDisposables$1$autoDisposable$1 autoDisposable = new AutoDisposableKt$withLifecycleAutoDisposables$1$autoDisposable$1();

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Lifecycle.Event f61766b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function1<AutoDisposable, Unit> f61767c;

    public AutoDisposableKt$withLifecycleAutoDisposables$1(Lifecycle.Event event, Function1<? super AutoDisposable, Unit> function1) {
        this.f61766b = event;
        this.f61767c = function1;
    }

    @NotNull
    public final AutoDisposableKt$withLifecycleAutoDisposables$1$autoDisposable$1 getAutoDisposable() {
        return this.autoDisposable;
    }

    public void onCreate(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        if (this.f61766b == Lifecycle.Event.ON_CREATE) {
            this.f61767c.invoke(this.autoDisposable);
        }
    }

    public void onDestroy(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        if (this.f61766b == Lifecycle.Event.ON_CREATE) {
            this.autoDisposable.onCleared();
        }
    }

    public void onPause(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        if (this.f61766b == Lifecycle.Event.ON_RESUME) {
            this.autoDisposable.onCleared();
        }
    }

    public void onResume(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        if (this.f61766b == Lifecycle.Event.ON_RESUME) {
            this.f61767c.invoke(this.autoDisposable);
        }
    }

    public void onStart(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        if (this.f61766b == Lifecycle.Event.ON_START) {
            this.f61767c.invoke(this.autoDisposable);
        }
    }

    public void onStop(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        if (this.f61766b == Lifecycle.Event.ON_START) {
            this.autoDisposable.onCleared();
        }
    }
}
