package x5;

import com.deliveryhero.perseus.hits.usecase.PerseusSaveHitUseCase;
import io.reactivex.functions.Action;

public final /* synthetic */ class f implements Action {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PerseusSaveHitUseCase f34825b;

    public /* synthetic */ f(PerseusSaveHitUseCase perseusSaveHitUseCase) {
        this.f34825b = perseusSaveHitUseCase;
    }

    public final void run() {
        PerseusSaveHitUseCase.runWithBatchDispatch$lambda$5(this.f34825b);
    }
}
