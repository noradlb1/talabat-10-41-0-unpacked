package com.instabug.library.util.threading;

import android.util.Log;
import com.facebook.internal.NativeProtocol;
import com.instabug.library.diagnostics.IBGDiagnostics;
import com.instabug.library.util.InstabugSDKLogger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class DefensiveRunnableKt {

    public static final class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Function0 f52092b;

        public a(Function0 function0) {
            this.f52092b = function0;
        }

        public final void run() {
            try {
                this.f52092b.invoke();
            } catch (Throwable th2) {
                th = th2;
                DefensiveRunnableKt.defensiveLog$default(th, (String) null, 2, (Object) null);
                if (!(th instanceof OutOfMemoryError)) {
                    th = null;
                }
                if (th != null) {
                    DefensiveRunnableKt.reportOOM(th);
                }
            }
        }
    }

    public static final class b extends Lambda implements Function1 {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f52093g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(String str) {
            super(1);
            this.f52093g = str;
        }

        public final void a(@NotNull Throwable th2) {
            Intrinsics.checkNotNullParameter(th2, "it");
            Log.e("IBG-Core", this.f52093g + ". cause: " + th2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return Unit.INSTANCE;
        }
    }

    public static final void defensiveLog(@NotNull Throwable th2, @NotNull String str) {
        Object obj;
        Intrinsics.checkNotNullParameter(th2, "error");
        Intrinsics.checkNotNullParameter(str, "msg");
        try {
            Result.Companion companion = Result.Companion;
            InstabugSDKLogger.e("IBG-Core", str + ". cause: " + th2);
            obj = Result.m6329constructorimpl(Unit.INSTANCE);
        } catch (Throwable th3) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th3));
        }
        if (Result.m6332exceptionOrNullimpl(obj) != null) {
            Log.e("IBG-Core", "Failed to log Throwable: " + th2 + ". Log msg: " + str);
        }
    }

    public static /* synthetic */ void defensiveLog$default(Throwable th2, String str, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = "Error in Single Thread Executor(" + Thread.currentThread().getName() + ')';
        }
        defensiveLog(th2, str);
    }

    @NotNull
    public static final String errorMsgOf(@NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "e");
        if (th2 instanceof OutOfMemoryError) {
            return "OOM in Single Thread Executor(" + Thread.currentThread().getName() + "). cause: " + th2;
        }
        return "Error in Single Thread Executor(" + Thread.currentThread().getName() + "). cause: " + th2;
    }

    public static final void nonFatal(@NotNull OutOfMemoryError outOfMemoryError) {
        Object obj;
        Intrinsics.checkNotNullParameter(outOfMemoryError, "oom");
        try {
            Result.Companion companion = Result.Companion;
            IBGDiagnostics.reportNonFatal(outOfMemoryError, errorMsgOf(outOfMemoryError));
            obj = Result.m6329constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable r22 = Result.m6332exceptionOrNullimpl(obj);
        if (r22 != null) {
            defensiveLog$default(r22, (String) null, 2, (Object) null);
        }
    }

    public static final void reportOOM(@NotNull OutOfMemoryError outOfMemoryError) {
        Intrinsics.checkNotNullParameter(outOfMemoryError, "oom");
        try {
            nonFatal(outOfMemoryError);
        } catch (Throwable th2) {
            defensiveLog(th2, "Failed to report non-fatal in Single Thread Executor(" + Thread.currentThread().getName() + "), cause: " + th2);
        }
    }

    @NotNull
    public static final <T> Runnable runDefensive(@NotNull Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, NativeProtocol.WEB_DIALOG_ACTION);
        return new a(function0);
    }

    public static final void runGracefully(@NotNull String str, @NotNull Function1<? super Throwable, Unit> function1, @NotNull Function0<Unit> function0) {
        Object obj;
        Intrinsics.checkNotNullParameter(str, "logMsg");
        Intrinsics.checkNotNullParameter(function1, "expecting");
        Intrinsics.checkNotNullParameter(function0, "explosive");
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m6329constructorimpl(function0.invoke());
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable r12 = Result.m6332exceptionOrNullimpl(obj);
        if (r12 != null) {
            function1.invoke(r12);
        }
    }

    public static /* synthetic */ void runGracefully$default(String str, Function1 function1, Function0 function0, int i11, Object obj) {
        Object obj2;
        if ((i11 & 1) != 0) {
            str = "Encountered error in running action";
        }
        if ((i11 & 2) != 0) {
            function1 = new b(str);
        }
        Intrinsics.checkNotNullParameter(str, "logMsg");
        Intrinsics.checkNotNullParameter(function1, "expecting");
        Intrinsics.checkNotNullParameter(function0, "explosive");
        try {
            Result.Companion companion = Result.Companion;
            obj2 = Result.m6329constructorimpl(function0.invoke());
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj2 = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable r02 = Result.m6332exceptionOrNullimpl(obj2);
        if (r02 != null) {
            function1.invoke(r02);
        }
    }

    @NotNull
    public static final Runnable runDefensive(@Nullable Runnable runnable) {
        return new a(runnable);
    }
}
