package library.talabat.mvp.cart;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function0;

public final /* synthetic */ class f implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function0 f26639b;

    public /* synthetic */ f(Function0 function0) {
        this.f26639b = function0;
    }

    public final void accept(Object obj) {
        CartInteractor.lambda$checkForSelectedAddressAreaUpdate$10(this.f26639b, (Throwable) obj);
    }
}
