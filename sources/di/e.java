package di;

import com.talabat.darkstores.data.darkstores.DarkstoresRepo;
import com.talabat.darkstores.feature.cart.model.PostCartData;
import com.talabat.feature.darkstoresvendor.domain.model.Vendor;
import io.reactivex.functions.Function;

public final /* synthetic */ class e implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DarkstoresRepo f56701b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ PostCartData f56702c;

    public /* synthetic */ e(DarkstoresRepo darkstoresRepo, PostCartData postCartData) {
        this.f56701b = darkstoresRepo;
        this.f56702c = postCartData;
    }

    public final Object apply(Object obj) {
        return DarkstoresRepo.m9676postCartByVendorId$lambda21(this.f56701b, this.f56702c, (Vendor) obj);
    }
}
