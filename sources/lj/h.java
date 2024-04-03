package lj;

import com.talabat.darkstores.feature.product.models.ProductCampaign;
import io.reactivex.Observer;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class h implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Observer f57015b;

    public /* synthetic */ h(Observer observer) {
        this.f57015b = observer;
    }

    public final void accept(Object obj) {
        this.f57015b.onNext((ProductCampaign.Free) obj);
    }
}
