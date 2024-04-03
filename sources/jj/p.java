package jj;

import com.talabat.darkstores.data.darkstores.DarkstoresRepo;
import com.talabat.darkstores.feature.product.ProductFragmentViewModel;
import com.talabat.feature.darkstorescart.data.model.Product;
import io.reactivex.functions.Function;

public final /* synthetic */ class p implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DarkstoresRepo f56941b;

    public /* synthetic */ p(DarkstoresRepo darkstoresRepo) {
        this.f56941b = darkstoresRepo;
    }

    public final Object apply(Object obj) {
        return ProductFragmentViewModel.m10012_init_$lambda1(this.f56941b, (Product) obj);
    }
}
