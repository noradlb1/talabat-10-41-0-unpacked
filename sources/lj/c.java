package lj;

import com.talabat.darkstores.feature.product.views.CartButtonEvent;
import io.reactivex.Observer;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class c implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Observer f57011b;

    public /* synthetic */ c(Observer observer) {
        this.f57011b = observer;
    }

    public final void accept(Object obj) {
        this.f57011b.onNext((CartButtonEvent) obj);
    }
}
