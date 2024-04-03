package of;

import com.talabat.authentication.token.data.model.SwapTokenData;
import io.reactivex.SingleEmitter;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class e implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SingleEmitter f57073b;

    public /* synthetic */ e(SingleEmitter singleEmitter) {
        this.f57073b = singleEmitter;
    }

    public final void accept(Object obj) {
        this.f57073b.onSuccess((SwapTokenData) obj);
    }
}
