package jj;

import com.talabat.darkstores.feature.product.ProductFragmentViewModel;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

public final /* synthetic */ class t implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ProductFragmentViewModel f56945b;

    public /* synthetic */ t(ProductFragmentViewModel productFragmentViewModel) {
        this.f56945b = productFragmentViewModel;
    }

    public final Object apply(Object obj) {
        return ProductFragmentViewModel.m10019_init_$lambda9(this.f56945b, (Observable) obj);
    }
}
