package com.talabat.talabatcommon.views;

import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u0007\b\u0000¢\u0006\u0002\u0010\u0003J!\u0010\u0004\u001a\u00020\u00152\u0016\u0010\u0016\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0005H\u0004J\u0017\u0010\u000f\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010H\u0004R*\u0010\u0004\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00008\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\u0003\u001a\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/talabat/talabatcommon/views/StartForResultBuilder;", "T", "", "()V", "resultRetriever", "Lkotlin/Function1;", "Landroid/content/Intent;", "getResultRetriever$com_talabat_NewArchi_TalabatCommon_TalabatCommon", "()Lkotlin/jvm/functions/Function1;", "setResultRetriever$com_talabat_NewArchi_TalabatCommon_TalabatCommon", "(Lkotlin/jvm/functions/Function1;)V", "set", "getSet$annotations", "getSet", "()Lcom/talabat/talabatcommon/views/StartForResultBuilder;", "startingIntent", "Lkotlin/Function0;", "getStartingIntent$com_talabat_NewArchi_TalabatCommon_TalabatCommon", "()Lkotlin/jvm/functions/Function0;", "setStartingIntent$com_talabat_NewArchi_TalabatCommon_TalabatCommon", "(Lkotlin/jvm/functions/Function0;)V", "", "block", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class StartForResultBuilder<T> {
    public Function1<? super Intent, ? extends T> resultRetriever;
    @NotNull
    private final StartForResultBuilder<T> set = this;
    public Function0<? extends Intent> startingIntent;

    @StartForResultDsl
    public static /* synthetic */ void getSet$annotations() {
    }

    @NotNull
    public final Function1<Intent, T> getResultRetriever$com_talabat_NewArchi_TalabatCommon_TalabatCommon() {
        Function1<? super Intent, ? extends T> function1 = this.resultRetriever;
        if (function1 != null) {
            return function1;
        }
        Intrinsics.throwUninitializedPropertyAccessException("resultRetriever");
        return null;
    }

    @NotNull
    public final StartForResultBuilder<T> getSet() {
        return this.set;
    }

    @NotNull
    public final Function0<Intent> getStartingIntent$com_talabat_NewArchi_TalabatCommon_TalabatCommon() {
        Function0<? extends Intent> function0 = this.startingIntent;
        if (function0 != null) {
            return function0;
        }
        Intrinsics.throwUninitializedPropertyAccessException("startingIntent");
        return null;
    }

    @StartForResultDsl
    public final void resultRetriever(@NotNull Function1<? super Intent, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        setResultRetriever$com_talabat_NewArchi_TalabatCommon_TalabatCommon(function1);
    }

    public final void setResultRetriever$com_talabat_NewArchi_TalabatCommon_TalabatCommon(@NotNull Function1<? super Intent, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.resultRetriever = function1;
    }

    public final void setStartingIntent$com_talabat_NewArchi_TalabatCommon_TalabatCommon(@NotNull Function0<? extends Intent> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.startingIntent = function0;
    }

    @StartForResultDsl
    public final void startingIntent(@NotNull Function0<? extends Intent> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        setStartingIntent$com_talabat_NewArchi_TalabatCommon_TalabatCommon(function0);
    }
}
