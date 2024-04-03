package library.talabat.mvp.cart;

import io.reactivex.functions.Consumer;
import kotlin.Pair;

public final /* synthetic */ class l implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartInteractor f26650b;

    public /* synthetic */ l(CartInteractor cartInteractor) {
        this.f26650b = cartInteractor;
    }

    public final void accept(Object obj) {
        this.f26650b.handleMergedResultForLoadCustomer((Pair) obj);
    }
}
