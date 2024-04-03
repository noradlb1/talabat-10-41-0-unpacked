package jj;

import com.talabat.darkstores.data.SearchResultData;
import com.talabat.darkstores.feature.product.ProductFragmentViewModel;
import com.talabat.darkstores.feature.product.models.ProductCampaign;
import io.reactivex.functions.Function;

public final /* synthetic */ class n implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ProductFragmentViewModel f56938b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ProductCampaign f56939c;

    public /* synthetic */ n(ProductFragmentViewModel productFragmentViewModel, ProductCampaign productCampaign) {
        this.f56938b = productFragmentViewModel;
        this.f56939c = productCampaign;
    }

    public final Object apply(Object obj) {
        return ProductFragmentViewModel.m10028lambda6$lambda5(this.f56938b, this.f56939c, (SearchResultData) obj);
    }
}
