package wq;

import com.talabat.gem.domain.usecases.GemCounterBusinessRulesKt;
import io.reactivex.functions.Function;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class d implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f62998b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function1 f62999c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Function1 f63000d;

    public /* synthetic */ d(Function1 function1, Function1 function12, Function1 function13) {
        this.f62998b = function1;
        this.f62999c = function12;
        this.f63000d = function13;
    }

    public final Object apply(Object obj) {
        return GemCounterBusinessRulesKt.m10551countDownTimer$lambda8(this.f62998b, this.f62999c, this.f63000d, (Long) obj);
    }
}
