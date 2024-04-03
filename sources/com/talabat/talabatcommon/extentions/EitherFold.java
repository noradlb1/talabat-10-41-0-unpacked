package com.talabat.talabatcommon.extentions;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SuspendEitherVersion(version = 2)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007\b\u0000¢\u0006\u0002\u0010\u0003J5\u0010\u0015\u001a\u00020\f2\"\u0010\u0016\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00020\tH\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u0010J5\u0010\u0017\u001a\u00020\f2\"\u0010\u0016\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00020\tH\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u0010R\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00008\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0003\u001a\u0004\b\u0006\u0010\u0007R=\u0010\b\u001a \b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\tX\u000eø\u0001\u0000¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R=\u0010\u0012\u001a \b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\tX\u000eø\u0001\u0000¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Lcom/talabat/talabatcommon/extentions/EitherFold;", "T", "", "()V", "on", "getOn$annotations", "getOn", "()Lcom/talabat/talabatcommon/extentions/EitherFold;", "onFailure", "Lkotlin/Function2;", "", "Lkotlin/coroutines/Continuation;", "", "getOnFailure$com_talabat_NewArchi_TalabatCommon_TalabatCommon", "()Lkotlin/jvm/functions/Function2;", "setOnFailure$com_talabat_NewArchi_TalabatCommon_TalabatCommon", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "onSuccess", "getOnSuccess$com_talabat_NewArchi_TalabatCommon_TalabatCommon", "setOnSuccess$com_talabat_NewArchi_TalabatCommon_TalabatCommon", "failure", "callback", "success", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class EitherFold<T> {
    @NotNull

    /* renamed from: on  reason: collision with root package name */
    private final EitherFold<T> f46995on = this;
    @Nullable
    private Function2<? super Throwable, ? super Continuation<? super Unit>, ? extends Object> onFailure = new EitherFold$onFailure$1((Continuation<? super EitherFold$onFailure$1>) null);
    @Nullable
    private Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> onSuccess;

    @SuspendEitherVersion(version = 2)
    public static /* synthetic */ void getOn$annotations() {
    }

    @SuspendEitherVersion(version = 2)
    public final void failure(@NotNull Function2<? super Throwable, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter(function2, "callback");
        this.onFailure = function2;
    }

    @NotNull
    public final EitherFold<T> getOn() {
        return this.f46995on;
    }

    @Nullable
    public final Function2<Throwable, Continuation<? super Unit>, Object> getOnFailure$com_talabat_NewArchi_TalabatCommon_TalabatCommon() {
        return this.onFailure;
    }

    @Nullable
    public final Function2<T, Continuation<? super Unit>, Object> getOnSuccess$com_talabat_NewArchi_TalabatCommon_TalabatCommon() {
        return this.onSuccess;
    }

    public final void setOnFailure$com_talabat_NewArchi_TalabatCommon_TalabatCommon(@Nullable Function2<? super Throwable, ? super Continuation<? super Unit>, ? extends Object> function2) {
        this.onFailure = function2;
    }

    public final void setOnSuccess$com_talabat_NewArchi_TalabatCommon_TalabatCommon(@Nullable Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2) {
        this.onSuccess = function2;
    }

    @SuspendEitherVersion(version = 2)
    public final void success(@NotNull Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter(function2, "callback");
        this.onSuccess = function2;
    }
}
