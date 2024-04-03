package a10;

import io.reactivex.functions.Predicate;
import library.talabat.mvp.cart.CartPresenter;

public final /* synthetic */ class d implements Predicate {
    public final boolean test(Object obj) {
        return CartPresenter.lambda$subscribeToSubtotalChanges$0((Float) obj);
    }
}
