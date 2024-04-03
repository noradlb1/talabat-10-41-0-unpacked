package com.talabat.talabatcommon.lifecycle;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\u0017\u0010\u001e\u001a\u00020\n2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0004J\u0017\u0010 \u001a\u00020\n2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0004J\u001d\u0010!\u001a\u00020\n2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\n0\u0010H\u0004J\u0017\u0010\"\u001a\u00020\n2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0004J\u0017\u0010#\u001a\u00020\n2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0004J\u0017\u0010$\u001a\u00020\n2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0004J\u0017\u0010%\u001a\u00020\n2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0004R\u001c\u0010\u0003\u001a\u00020\u00008\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0004\u0010\u0002\u001a\u0004\b\u0005\u0010\u0006R \u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR \u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR&\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\n0\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\fR \u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\fR \u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\fR \u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\f¨\u0006&"}, d2 = {"Lcom/talabat/talabatcommon/lifecycle/ContextLifecycleEvents;", "", "()V", "on", "getOn$annotations", "getOn", "()Lcom/talabat/talabatcommon/lifecycle/ContextLifecycleEvents;", "onCreate", "", "Lkotlin/Function0;", "", "getOnCreate$com_talabat_NewArchi_TalabatCommon_TalabatCommon", "()Ljava/util/List;", "onDestroy", "getOnDestroy$com_talabat_NewArchi_TalabatCommon_TalabatCommon", "onError", "Lkotlin/Function1;", "", "getOnError$com_talabat_NewArchi_TalabatCommon_TalabatCommon", "()Lkotlin/jvm/functions/Function1;", "setOnError$com_talabat_NewArchi_TalabatCommon_TalabatCommon", "(Lkotlin/jvm/functions/Function1;)V", "onPause", "getOnPause$com_talabat_NewArchi_TalabatCommon_TalabatCommon", "onResume", "getOnResume$com_talabat_NewArchi_TalabatCommon_TalabatCommon", "onStart", "getOnStart$com_talabat_NewArchi_TalabatCommon_TalabatCommon", "onStop", "getOnStop$com_talabat_NewArchi_TalabatCommon_TalabatCommon", "create", "block", "destroy", "error", "pause", "resume", "start", "stop", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ContextLifecycleEvents {
    @NotNull

    /* renamed from: on  reason: collision with root package name */
    private final ContextLifecycleEvents f61776on = this;
    @NotNull
    private final List<Function0<Unit>> onCreate = new ArrayList();
    @NotNull
    private final List<Function0<Unit>> onDestroy = new ArrayList();
    @NotNull
    private Function1<? super Throwable, Unit> onError = ContextLifecycleEvents$onError$1.INSTANCE;
    @NotNull
    private final List<Function0<Unit>> onPause = new ArrayList();
    @NotNull
    private final List<Function0<Unit>> onResume = new ArrayList();
    @NotNull
    private final List<Function0<Unit>> onStart = new ArrayList();
    @NotNull
    private final List<Function0<Unit>> onStop = new ArrayList();

    @ContextsDsl
    public static /* synthetic */ void getOn$annotations() {
    }

    @ContextsDsl
    public final void create(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        this.onCreate.add(function0);
    }

    @ContextsDsl
    public final void destroy(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        this.onDestroy.add(function0);
    }

    @ContextsDsl
    public final void error(@NotNull Function1<? super Throwable, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        this.onError = function1;
    }

    @NotNull
    public final ContextLifecycleEvents getOn() {
        return this.f61776on;
    }

    @NotNull
    public final List<Function0<Unit>> getOnCreate$com_talabat_NewArchi_TalabatCommon_TalabatCommon() {
        return this.onCreate;
    }

    @NotNull
    public final List<Function0<Unit>> getOnDestroy$com_talabat_NewArchi_TalabatCommon_TalabatCommon() {
        return this.onDestroy;
    }

    @NotNull
    public final Function1<Throwable, Unit> getOnError$com_talabat_NewArchi_TalabatCommon_TalabatCommon() {
        return this.onError;
    }

    @NotNull
    public final List<Function0<Unit>> getOnPause$com_talabat_NewArchi_TalabatCommon_TalabatCommon() {
        return this.onPause;
    }

    @NotNull
    public final List<Function0<Unit>> getOnResume$com_talabat_NewArchi_TalabatCommon_TalabatCommon() {
        return this.onResume;
    }

    @NotNull
    public final List<Function0<Unit>> getOnStart$com_talabat_NewArchi_TalabatCommon_TalabatCommon() {
        return this.onStart;
    }

    @NotNull
    public final List<Function0<Unit>> getOnStop$com_talabat_NewArchi_TalabatCommon_TalabatCommon() {
        return this.onStop;
    }

    @ContextsDsl
    public final void pause(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        this.onPause.add(function0);
    }

    @ContextsDsl
    public final void resume(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        this.onResume.add(function0);
    }

    public final void setOnError$com_talabat_NewArchi_TalabatCommon_TalabatCommon(@NotNull Function1<? super Throwable, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onError = function1;
    }

    @ContextsDsl
    public final void start(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        this.onStart.add(function0);
    }

    @ContextsDsl
    public final void stop(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        this.onStop.add(function0);
    }
}
