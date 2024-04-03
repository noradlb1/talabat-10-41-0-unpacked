package wq;

import com.talabat.gem.domain.usecases.GemCounterBusinessRulesKt;
import com.talabat.gem.ports.presentation.GemCounterViewPort;
import io.reactivex.functions.Function;
import kotlin.Pair;

public final /* synthetic */ class f implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GemCounterViewPort f63002b;

    public /* synthetic */ f(GemCounterViewPort gemCounterViewPort) {
        this.f63002b = gemCounterViewPort;
    }

    public final Object apply(Object obj) {
        return GemCounterBusinessRulesKt.m10553countdownTimerSubscription$lambda1(this.f63002b, (Pair) obj);
    }
}
