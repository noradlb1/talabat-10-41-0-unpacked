package wq;

import com.talabat.gem.domain.usecases.GemCounterBusinessRulesKt;
import com.talabat.gem.ports.presentation.GemCounterViewPort;
import io.reactivex.functions.Function;
import kotlin.Pair;

public final /* synthetic */ class e implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GemCounterViewPort f63001b;

    public /* synthetic */ e(GemCounterViewPort gemCounterViewPort) {
        this.f63001b = gemCounterViewPort;
    }

    public final Object apply(Object obj) {
        return GemCounterBusinessRulesKt.m10552countdownTimerSubscription$lambda0(this.f63001b, (Pair) obj);
    }
}
