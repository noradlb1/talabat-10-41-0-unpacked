package wq;

import com.talabat.gem.domain.usecases.GemCounterBusinessRulesKt;
import io.reactivex.functions.Function;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class b implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f62995b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f62996c;

    public /* synthetic */ b(Function1 function1, long j11) {
        this.f62995b = function1;
        this.f62996c = j11;
    }

    public final Object apply(Object obj) {
        return GemCounterBusinessRulesKt.m10549countDownTimer$lambda6(this.f62995b, this.f62996c, (Long) obj);
    }
}
