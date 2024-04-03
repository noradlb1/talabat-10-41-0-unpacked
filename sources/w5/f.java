package w5;

import com.deliveryhero.perseus.hits.PerseusWorker;
import io.reactivex.functions.Function;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class f implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f34773b;

    public /* synthetic */ f(Function1 function1) {
        this.f34773b = function1;
    }

    public final Object apply(Object obj) {
        return PerseusWorker.triggerJob$lambda$5(this.f34773b, obj);
    }
}
