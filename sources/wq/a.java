package wq;

import com.talabat.gem.domain.usecases.GemCounterBusinessRulesKt;
import io.reactivex.functions.Function;
import kotlin.Pair;

public final /* synthetic */ class a implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Pair f62994b;

    public /* synthetic */ a(Pair pair) {
        this.f62994b = pair;
    }

    public final Object apply(Object obj) {
        return GemCounterBusinessRulesKt.m10556toCountdownTimer$lambda4(this.f62994b, (String) obj);
    }
}
