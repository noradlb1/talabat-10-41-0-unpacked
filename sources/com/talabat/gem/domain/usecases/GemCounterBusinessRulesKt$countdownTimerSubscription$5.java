package com.talabat.gem.domain.usecases;

import io.reactivex.subjects.Subject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class GemCounterBusinessRulesKt$countdownTimerSubscription$5 extends FunctionReferenceImpl implements Function1<Throwable, Unit> {
    public GemCounterBusinessRulesKt$countdownTimerSubscription$5(Object obj) {
        super(1, obj, Subject.class, "onNext", "onNext(Ljava/lang/Object;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "p0");
        ((Subject) this.receiver).onNext(th2);
    }
}
