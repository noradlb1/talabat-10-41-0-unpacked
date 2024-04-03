package com.deliveryhero.impression.compose;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n"}, d2 = {"Lkotlin/Function0;", "", "block", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class ComposeImpressionTracker$runIfEnabled$1 extends Lambda implements Function1<Function0<? extends Unit>, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ComposeImpressionTracker f30318g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ComposeImpressionTracker$runIfEnabled$1(ComposeImpressionTracker composeImpressionTracker) {
        super(1);
        this.f30318g = composeImpressionTracker;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Function0<Unit>) (Function0) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        if (((Boolean) this.f30318g.isEnabled.invoke()).booleanValue()) {
            function0.invoke();
        }
    }
}
