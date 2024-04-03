package w5;

import com.deliveryhero.perseus.hits.PerseusWorker;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class e implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f34772b;

    public /* synthetic */ e(Function1 function1) {
        this.f34772b = function1;
    }

    public final void accept(Object obj) {
        PerseusWorker.triggerJob$lambda$4(this.f34772b, obj);
    }
}
