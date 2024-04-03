package wq;

import com.talabat.gem.domain.usecases.GemCounterBusinessRulesKt;
import com.talabat.gem.ports.presentation.GemCounterViewPort;
import io.reactivex.functions.Action;

public final /* synthetic */ class h implements Action {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GemCounterViewPort f63004b;

    public /* synthetic */ h(GemCounterViewPort gemCounterViewPort) {
        this.f63004b = gemCounterViewPort;
    }

    public final void run() {
        GemCounterBusinessRulesKt.m10555countdownTimerSubscription$lambda3(this.f63004b);
    }
}
