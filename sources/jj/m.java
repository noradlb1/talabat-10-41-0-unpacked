package jj;

import com.talabat.darkstores.feature.product.ProductFragmentViewModel;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class m implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ProductFragmentViewModel f56937b;

    public /* synthetic */ m(ProductFragmentViewModel productFragmentViewModel) {
        this.f56937b = productFragmentViewModel;
    }

    public final void accept(Object obj) {
        ProductFragmentViewModel.m10023checkAndShowBasketLifetimeTooltip$lambda26(this.f56937b, (Integer) obj);
    }
}
