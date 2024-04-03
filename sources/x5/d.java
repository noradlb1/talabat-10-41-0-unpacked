package x5;

import com.deliveryhero.perseus.hits.usecase.PerseusSaveHitUseCase;
import io.reactivex.functions.Function;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class d implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f34822b;

    public /* synthetic */ d(Function1 function1) {
        this.f34822b = function1;
    }

    public final Object apply(Object obj) {
        return PerseusSaveHitUseCase.runWithImmediateDispatch$lambda$3(this.f34822b, obj);
    }
}
