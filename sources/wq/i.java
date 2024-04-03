package wq;

import com.talabat.gem.domain.entities.GemOffer;
import com.talabat.gem.domain.usecases.GemCounterBusinessRulesKt;
import io.reactivex.functions.Function;

public final /* synthetic */ class i implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GemOffer f63005b;

    public /* synthetic */ i(GemOffer gemOffer) {
        this.f63005b = gemOffer;
    }

    public final Object apply(Object obj) {
        return GemCounterBusinessRulesKt.m10557toRemainingMillis$lambda5(this.f63005b, (Long) obj);
    }
}
