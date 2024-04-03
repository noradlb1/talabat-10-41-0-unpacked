package wq;

import com.talabat.gem.domain.usecases.GemCounterBusinessRulesKt;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class c implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f62997b;

    public /* synthetic */ c(Function1 function1) {
        this.f62997b = function1;
    }

    public final void accept(Object obj) {
        GemCounterBusinessRulesKt.m10550countDownTimer$lambda7(this.f62997b, (Long) obj);
    }
}
