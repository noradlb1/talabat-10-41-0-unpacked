package com.talabat.filters.navigation;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class FiltersView$updateBubbleVisibility$1$onResume$1 extends FunctionReferenceImpl implements Function1<Throwable, Unit> {
    public FiltersView$updateBubbleVisibility$1$onResume$1(Object obj) {
        super(1, obj, FiltersLogger.class, "displayErrorMessage", "displayErrorMessage(Ljava/lang/Throwable;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "p0");
        ((FiltersLogger) this.receiver).displayErrorMessage(th2);
    }
}
