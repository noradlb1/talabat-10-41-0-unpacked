package jj;

import com.talabat.darkstores.feature.product.ProductFragmentViewModel;
import com.talabat.feature.darkstorescart.data.model.Product;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class o implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ProductFragmentViewModel f56940b;

    public /* synthetic */ o(ProductFragmentViewModel productFragmentViewModel) {
        this.f56940b = productFragmentViewModel;
    }

    public final void accept(Object obj) {
        ProductFragmentViewModel.m10011_init_$lambda0(this.f56940b, (Product) obj);
    }
}
