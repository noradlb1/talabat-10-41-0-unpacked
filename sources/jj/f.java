package jj;

import com.talabat.darkstores.feature.product.ProductFragmentViewModel;
import com.talabat.darkstores.feature.product.models.ProductCampaign;
import io.reactivex.functions.Function;

public final /* synthetic */ class f implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Boolean f56931b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ProductFragmentViewModel f56932c;

    public /* synthetic */ f(Boolean bool, ProductFragmentViewModel productFragmentViewModel) {
        this.f56931b = bool;
        this.f56932c = productFragmentViewModel;
    }

    public final Object apply(Object obj) {
        return ProductFragmentViewModel.m10026lambda11$lambda10(this.f56931b, this.f56932c, (ProductCampaign) obj);
    }
}
