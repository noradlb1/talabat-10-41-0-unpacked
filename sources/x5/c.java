package x5;

import com.deliveryhero.perseus.hits.usecase.PerseusSaveHitUseCase;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class c implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f34821b;

    public /* synthetic */ c(Function1 function1) {
        this.f34821b = function1;
    }

    public final void accept(Object obj) {
        PerseusSaveHitUseCase.runWithImmediateDispatch$lambda$2(this.f34821b, obj);
    }
}
