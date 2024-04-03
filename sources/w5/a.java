package w5;

import com.deliveryhero.perseus.hits.PerseusWorker;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class a implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f34768b;

    public /* synthetic */ a(Function1 function1) {
        this.f34768b = function1;
    }

    public final void accept(Object obj) {
        PerseusWorker.triggerJob$lambda$0(this.f34768b, obj);
    }
}
