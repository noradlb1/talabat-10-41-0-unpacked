package com.talabat.darkstores.common.error;

import io.reactivex.exceptions.UndeliverableException;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b \u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0004¨\u0006\f"}, d2 = {"Lcom/talabat/darkstores/common/error/RxJavaErrorHandler;", "Lio/reactivex/functions/Consumer;", "", "throwable", "", "accept", "Lio/reactivex/exceptions/UndeliverableException;", "undeliverableException", "handleUndeliverableException", "a", "<init>", "()V", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0})
public abstract class RxJavaErrorHandler implements Consumer<Throwable> {
    public final void a(@NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "throwable");
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th2);
    }

    public abstract void handleUndeliverableException(@NotNull UndeliverableException undeliverableException);

    public void accept(@NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "throwable");
        if (th2 instanceof UndeliverableException) {
            handleUndeliverableException((UndeliverableException) th2);
            return;
        }
        th2.printStackTrace();
        a(th2);
    }
}
