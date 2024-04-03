package com.talabat.gem.domain.usecases;

import io.reactivex.subjects.BehaviorSubject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class GemCounterBusinessRulesKt$countdownTimerSubscription$1$1 extends FunctionReferenceImpl implements Function1<Long, Unit> {
    public GemCounterBusinessRulesKt$countdownTimerSubscription$1$1(Object obj) {
        super(1, obj, BehaviorSubject.class, "onNext", "onNext(Ljava/lang/Object;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Long) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Long l11) {
        Intrinsics.checkNotNullParameter(l11, "p0");
        ((BehaviorSubject) this.receiver).onNext(l11);
    }
}
