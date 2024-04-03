package w5;

import com.deliveryhero.perseus.hits.PerseusWorker;
import io.reactivex.functions.Predicate;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class b implements Predicate {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f34769b;

    public /* synthetic */ b(Function1 function1) {
        this.f34769b = function1;
    }

    public final boolean test(Object obj) {
        return PerseusWorker.triggerJob$lambda$1(this.f34769b, obj);
    }
}
