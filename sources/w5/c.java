package w5;

import com.deliveryhero.perseus.hits.PerseusWorker;
import io.reactivex.functions.Function;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class c implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f34770b;

    public /* synthetic */ c(Function1 function1) {
        this.f34770b = function1;
    }

    public final Object apply(Object obj) {
        return PerseusWorker.triggerJob$lambda$2(this.f34770b, obj);
    }
}
