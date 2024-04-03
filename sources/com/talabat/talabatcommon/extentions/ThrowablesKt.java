package com.talabat.talabatcommon.extentions;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0002\u001a\u00020\u0003*\u00020\u0004\u001aX\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00012\"\b\u0002\u0010\u0007\u001a\u001c\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00030\b2\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00030\n\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"TAG", "", "log", "", "", "tag", "message", "androidLogger", "Lkotlin/Function3;", "systemLogger", "Lkotlin/Function1;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ThrowablesKt {
    @NotNull
    private static final String TAG = "EXCEPTION";

    public static final void log(@NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "<this>");
        log$default(th2, TAG, th2.getMessage(), (Function3) null, (Function1) null, 12, (Object) null);
    }

    public static /* synthetic */ void log$default(Throwable th2, String str, String str2, Function3 function3, Function1 function1, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = th2.getMessage();
        }
        if ((i11 & 4) != 0) {
            function3 = ThrowablesKt$log$1.INSTANCE;
        }
        if ((i11 & 8) != 0) {
            function1 = ThrowablesKt$log$2.INSTANCE;
        }
        log(th2, str, str2, function3, function1);
    }

    public static final void log(@NotNull Throwable th2, @NotNull String str, @Nullable String str2, @NotNull Function3<? super String, ? super String, ? super Throwable, Unit> function3, @NotNull Function1<? super Throwable, Unit> function1) {
        Object obj;
        Intrinsics.checkNotNullParameter(th2, "<this>");
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(function3, "androidLogger");
        Intrinsics.checkNotNullParameter(function1, "systemLogger");
        try {
            Result.Companion companion = Result.Companion;
            function3.invoke(str, str2, th2);
            obj = Result.m6329constructorimpl(Unit.INSTANCE);
        } catch (Throwable th3) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th3));
        }
        if (Result.m6332exceptionOrNullimpl(obj) != null) {
            function1.invoke(th2);
        }
    }
}
