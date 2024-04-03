package ri;

import com.talabat.darkstores.feature.cart.CartFragmentViewModel;
import com.talabat.feature.darkstorescart.data.model.Product;
import com.talabat.feature.darkstoresvendor.domain.model.Vendor;
import io.reactivex.functions.Function;

public final /* synthetic */ class s0 implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartFragmentViewModel f57352b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Product f57353c;

    public /* synthetic */ s0(CartFragmentViewModel cartFragmentViewModel, Product product) {
        this.f57352b = cartFragmentViewModel;
        this.f57353c = product;
    }

    public final Object apply(Object obj) {
        return CartFragmentViewModel.m9820initViewModel$lambda35$lambda34(this.f57352b, this.f57353c, (Vendor) obj);
    }
}
