package rj;

import com.talabat.darkstores.interactor.DarkstoresBridgeInteractor;
import io.reactivex.functions.Consumer;
import kotlin.Pair;

public final /* synthetic */ class h implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DarkstoresBridgeInteractor f57377b;

    public /* synthetic */ h(DarkstoresBridgeInteractor darkstoresBridgeInteractor) {
        this.f57377b = darkstoresBridgeInteractor;
    }

    public final void accept(Object obj) {
        this.f57377b.handleMergedResult((Pair) obj);
    }
}
