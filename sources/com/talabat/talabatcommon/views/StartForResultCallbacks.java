package com.talabat.talabatcommon.views;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0017\u0010\u0018\u001a\u00020\n2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0004J\u0017\u0010\u001a\u001a\u00020\n2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0004J\u001f\u0010\u001b\u001a\u00020\n2\u0014\u0010\u0019\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\n0\u0013H\u0004R\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00008\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0003\u001a\u0004\b\u0006\u0010\u0007R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR(\u0010\u0012\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\n0\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/talabat/talabatcommon/views/StartForResultCallbacks;", "T", "", "()V", "on", "getOn$annotations", "getOn", "()Lcom/talabat/talabatcommon/views/StartForResultCallbacks;", "onCancelled", "Lkotlin/Function0;", "", "getOnCancelled$com_talabat_NewArchi_TalabatCommon_TalabatCommon", "()Lkotlin/jvm/functions/Function0;", "setOnCancelled$com_talabat_NewArchi_TalabatCommon_TalabatCommon", "(Lkotlin/jvm/functions/Function0;)V", "onStart", "getOnStart$com_talabat_NewArchi_TalabatCommon_TalabatCommon", "setOnStart$com_talabat_NewArchi_TalabatCommon_TalabatCommon", "onSuccess", "Lkotlin/Function1;", "getOnSuccess$com_talabat_NewArchi_TalabatCommon_TalabatCommon", "()Lkotlin/jvm/functions/Function1;", "setOnSuccess$com_talabat_NewArchi_TalabatCommon_TalabatCommon", "(Lkotlin/jvm/functions/Function1;)V", "cancelled", "callback", "start", "success", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class StartForResultCallbacks<T> {
    @NotNull

    /* renamed from: on  reason: collision with root package name */
    private final StartForResultCallbacks<T> f11710on = this;
    @NotNull
    private Function0<Unit> onCancelled = StartForResultCallbacks$onCancelled$1.INSTANCE;
    @NotNull
    private Function0<Unit> onStart = StartForResultCallbacks$onStart$1.INSTANCE;
    @NotNull
    private Function1<? super T, Unit> onSuccess = StartForResultCallbacks$onSuccess$1.INSTANCE;

    @StartForResultDsl
    public static /* synthetic */ void getOn$annotations() {
    }

    @StartForResultDsl
    public final void cancelled(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "callback");
        this.onCancelled = function0;
    }

    @NotNull
    public final StartForResultCallbacks<T> getOn() {
        return this.f11710on;
    }

    @NotNull
    public final Function0<Unit> getOnCancelled$com_talabat_NewArchi_TalabatCommon_TalabatCommon() {
        return this.onCancelled;
    }

    @NotNull
    public final Function0<Unit> getOnStart$com_talabat_NewArchi_TalabatCommon_TalabatCommon() {
        return this.onStart;
    }

    @NotNull
    public final Function1<T, Unit> getOnSuccess$com_talabat_NewArchi_TalabatCommon_TalabatCommon() {
        return this.onSuccess;
    }

    public final void setOnCancelled$com_talabat_NewArchi_TalabatCommon_TalabatCommon(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.onCancelled = function0;
    }

    public final void setOnStart$com_talabat_NewArchi_TalabatCommon_TalabatCommon(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.onStart = function0;
    }

    public final void setOnSuccess$com_talabat_NewArchi_TalabatCommon_TalabatCommon(@NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onSuccess = function1;
    }

    @StartForResultDsl
    public final void start(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "callback");
        this.onStart = function0;
    }

    @StartForResultDsl
    public final void success(@NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "callback");
        this.onSuccess = function1;
    }
}
