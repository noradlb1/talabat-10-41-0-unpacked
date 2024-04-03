package com.talabat.helpers;

import com.talabat.talabatcore.logger.LogManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class TalabatApplication$startAppTracking$1 extends FunctionReferenceImpl implements Function2<Throwable, String, Unit> {
    public TalabatApplication$startAppTracking$1(Object obj) {
        super(2, obj, LogManager.class, "error", "error(Ljava/lang/Throwable;Ljava/lang/String;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Throwable) obj, (String) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Throwable th2, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "p1");
        LogManager.error(th2, str);
    }
}
