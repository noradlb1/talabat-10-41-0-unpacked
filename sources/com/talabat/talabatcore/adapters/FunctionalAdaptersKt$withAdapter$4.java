package com.talabat.talabatcore.adapters;

import com.talabat.talabatcore.logger.LogManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "I", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class FunctionalAdaptersKt$withAdapter$4 extends Lambda implements Function1<Throwable, Unit> {
    public static final FunctionalAdaptersKt$withAdapter$4 INSTANCE = new FunctionalAdaptersKt$withAdapter$4();

    public FunctionalAdaptersKt$withAdapter$4() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "it");
        LogManager.logException(th2);
    }
}
