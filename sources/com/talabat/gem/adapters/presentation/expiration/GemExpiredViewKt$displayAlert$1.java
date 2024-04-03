package com.talabat.gem.adapters.presentation.expiration;

import com.talabat.gem.ports.logging.LoggerPort;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class GemExpiredViewKt$displayAlert$1 extends FunctionReferenceImpl implements Function1<Throwable, Unit> {
    public GemExpiredViewKt$displayAlert$1(Object obj) {
        super(1, obj, LoggerPort.class, "logError", "logError(Ljava/lang/Throwable;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "p0");
        ((LoggerPort) this.receiver).logError(th2);
    }
}
