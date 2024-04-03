package jj;

import com.talabat.darkstores.feature.product.ProductFragmentViewModel;
import io.reactivex.functions.Function;

public final /* synthetic */ class k implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ProductFragmentViewModel f56936b;

    public /* synthetic */ k(ProductFragmentViewModel productFragmentViewModel) {
        this.f56936b = productFragmentViewModel;
    }

    public final Object apply(Object obj) {
        return ProductFragmentViewModel.m10021checkAndShowBasketLifetimeTooltip$lambda24(this.f56936b, (Boolean) obj);
    }
}
