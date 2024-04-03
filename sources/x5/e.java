package x5;

import com.deliveryhero.perseus.hits.usecase.PerseusSaveHitUseCase;
import io.reactivex.functions.Action;
import java.util.Map;

public final /* synthetic */ class e implements Action {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PerseusSaveHitUseCase f34823b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Map f34824c;

    public /* synthetic */ e(PerseusSaveHitUseCase perseusSaveHitUseCase, Map map) {
        this.f34823b = perseusSaveHitUseCase;
        this.f34824c = map;
    }

    public final void run() {
        PerseusSaveHitUseCase.runWithBatchDispatch$lambda$4(this.f34823b, this.f34824c);
    }
}
