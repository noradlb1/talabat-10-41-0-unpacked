package jj;

import com.talabat.darkstores.feature.product.ProductFragmentViewModel;
import io.reactivex.Maybe;
import io.reactivex.functions.Function;

public final /* synthetic */ class u implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Maybe f56946b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ProductFragmentViewModel f56947c;

    public /* synthetic */ u(Maybe maybe, ProductFragmentViewModel productFragmentViewModel) {
        this.f56946b = maybe;
        this.f56947c = productFragmentViewModel;
    }

    public final Object apply(Object obj) {
        return ProductFragmentViewModel.m10013_init_$lambda11(this.f56946b, this.f56947c, (Boolean) obj);
    }
}
