package x5;

import com.deliveryhero.perseus.hits.usecase.PerseusSaveHitUseCase;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class g implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f34826b;

    public /* synthetic */ g(Function1 function1) {
        this.f34826b = function1;
    }

    public final void accept(Object obj) {
        PerseusSaveHitUseCase.runWithBatchDispatch$lambda$6(this.f34826b, obj);
    }
}
