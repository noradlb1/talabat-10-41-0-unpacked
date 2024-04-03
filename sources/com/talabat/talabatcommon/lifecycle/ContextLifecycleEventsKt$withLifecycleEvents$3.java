package com.talabat.talabatcommon.lifecycle;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u000b"}, d2 = {"com/talabat/talabatcommon/lifecycle/ContextLifecycleEventsKt$withLifecycleEvents$3", "Landroidx/lifecycle/DefaultLifecycleObserver;", "onCreate", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onDestroy", "onPause", "onResume", "onStart", "onStop", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ContextLifecycleEventsKt$withLifecycleEvents$3 implements DefaultLifecycleObserver {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ContextLifecycleEvents f61777b;

    public ContextLifecycleEventsKt$withLifecycleEvents$3(ContextLifecycleEvents contextLifecycleEvents) {
        this.f61777b = contextLifecycleEvents;
    }

    public void onCreate(@NotNull LifecycleOwner lifecycleOwner) {
        Object obj;
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        ContextLifecycleEvents contextLifecycleEvents = this.f61777b;
        try {
            Result.Companion companion = Result.Companion;
            for (Function0 invoke : contextLifecycleEvents.getOnCreate$com_talabat_NewArchi_TalabatCommon_TalabatCommon()) {
                invoke.invoke();
            }
            obj = Result.m6329constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        ContextLifecycleEvents contextLifecycleEvents2 = this.f61777b;
        Throwable r22 = Result.m6332exceptionOrNullimpl(obj);
        if (r22 != null) {
            contextLifecycleEvents2.getOnError$com_talabat_NewArchi_TalabatCommon_TalabatCommon().invoke(r22);
        }
    }

    public void onDestroy(@NotNull LifecycleOwner lifecycleOwner) {
        Object obj;
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        ContextLifecycleEvents contextLifecycleEvents = this.f61777b;
        try {
            Result.Companion companion = Result.Companion;
            for (Function0 invoke : contextLifecycleEvents.getOnDestroy$com_talabat_NewArchi_TalabatCommon_TalabatCommon()) {
                invoke.invoke();
            }
            obj = Result.m6329constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        ContextLifecycleEvents contextLifecycleEvents2 = this.f61777b;
        Throwable r22 = Result.m6332exceptionOrNullimpl(obj);
        if (r22 != null) {
            contextLifecycleEvents2.getOnError$com_talabat_NewArchi_TalabatCommon_TalabatCommon().invoke(r22);
        }
    }

    public void onPause(@NotNull LifecycleOwner lifecycleOwner) {
        Object obj;
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        ContextLifecycleEvents contextLifecycleEvents = this.f61777b;
        try {
            Result.Companion companion = Result.Companion;
            for (Function0 invoke : contextLifecycleEvents.getOnPause$com_talabat_NewArchi_TalabatCommon_TalabatCommon()) {
                invoke.invoke();
            }
            obj = Result.m6329constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        ContextLifecycleEvents contextLifecycleEvents2 = this.f61777b;
        Throwable r22 = Result.m6332exceptionOrNullimpl(obj);
        if (r22 != null) {
            contextLifecycleEvents2.getOnError$com_talabat_NewArchi_TalabatCommon_TalabatCommon().invoke(r22);
        }
    }

    public void onResume(@NotNull LifecycleOwner lifecycleOwner) {
        Object obj;
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        ContextLifecycleEvents contextLifecycleEvents = this.f61777b;
        try {
            Result.Companion companion = Result.Companion;
            for (Function0 invoke : contextLifecycleEvents.getOnResume$com_talabat_NewArchi_TalabatCommon_TalabatCommon()) {
                invoke.invoke();
            }
            obj = Result.m6329constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        ContextLifecycleEvents contextLifecycleEvents2 = this.f61777b;
        Throwable r22 = Result.m6332exceptionOrNullimpl(obj);
        if (r22 != null) {
            contextLifecycleEvents2.getOnError$com_talabat_NewArchi_TalabatCommon_TalabatCommon().invoke(r22);
        }
    }

    public void onStart(@NotNull LifecycleOwner lifecycleOwner) {
        Object obj;
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        ContextLifecycleEvents contextLifecycleEvents = this.f61777b;
        try {
            Result.Companion companion = Result.Companion;
            for (Function0 invoke : contextLifecycleEvents.getOnStart$com_talabat_NewArchi_TalabatCommon_TalabatCommon()) {
                invoke.invoke();
            }
            obj = Result.m6329constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        ContextLifecycleEvents contextLifecycleEvents2 = this.f61777b;
        Throwable r22 = Result.m6332exceptionOrNullimpl(obj);
        if (r22 != null) {
            contextLifecycleEvents2.getOnError$com_talabat_NewArchi_TalabatCommon_TalabatCommon().invoke(r22);
        }
    }

    public void onStop(@NotNull LifecycleOwner lifecycleOwner) {
        Object obj;
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        ContextLifecycleEvents contextLifecycleEvents = this.f61777b;
        try {
            Result.Companion companion = Result.Companion;
            for (Function0 invoke : contextLifecycleEvents.getOnStop$com_talabat_NewArchi_TalabatCommon_TalabatCommon()) {
                invoke.invoke();
            }
            obj = Result.m6329constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        ContextLifecycleEvents contextLifecycleEvents2 = this.f61777b;
        Throwable r22 = Result.m6332exceptionOrNullimpl(obj);
        if (r22 != null) {
            contextLifecycleEvents2.getOnError$com_talabat_NewArchi_TalabatCommon_TalabatCommon().invoke(r22);
        }
    }
}
