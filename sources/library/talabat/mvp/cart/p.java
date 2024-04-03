package library.talabat.mvp.cart;

import io.reactivex.functions.Consumer;
import kotlin.Pair;

public final /* synthetic */ class p implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartInteractor f26656b;

    public /* synthetic */ p(CartInteractor cartInteractor) {
        this.f26656b = cartInteractor;
    }

    public final void accept(Object obj) {
        this.f26656b.handleMergedResultForBackgroundUpdate((Pair) obj);
    }
}
