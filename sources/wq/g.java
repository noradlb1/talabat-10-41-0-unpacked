package wq;

import com.talabat.gem.domain.usecases.GemCounterBusinessRulesKt;
import com.talabat.gem.ports.presentation.GemCounterViewPort;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class g implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GemCounterViewPort f63003b;

    public /* synthetic */ g(GemCounterViewPort gemCounterViewPort) {
        this.f63003b = gemCounterViewPort;
    }

    public final void accept(Object obj) {
        GemCounterBusinessRulesKt.m10554countdownTimerSubscription$lambda2(this.f63003b, (Throwable) obj);
    }
}
