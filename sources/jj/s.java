package jj;

import com.talabat.darkstores.data.SearchResultData;
import com.talabat.darkstores.feature.product.ProductFragmentViewModel;
import io.reactivex.functions.Function;

public final /* synthetic */ class s implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ProductFragmentViewModel f56944b;

    public /* synthetic */ s(ProductFragmentViewModel productFragmentViewModel) {
        this.f56944b = productFragmentViewModel;
    }

    public final Object apply(Object obj) {
        return ProductFragmentViewModel.m10018_init_$lambda7(this.f56944b, (SearchResultData) obj);
    }
}
