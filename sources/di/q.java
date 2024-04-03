package di;

import com.talabat.darkstores.data.darkstores.DarkstoresRepo;
import com.talabat.darkstores.feature.cart.model.PostCartData;
import com.talabat.feature.darkstoresvendor.domain.model.Vendor;
import io.reactivex.functions.Function;

public final /* synthetic */ class q implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DarkstoresRepo f56714b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ PostCartData f56715c;

    public /* synthetic */ q(DarkstoresRepo darkstoresRepo, PostCartData postCartData) {
        this.f56714b = darkstoresRepo;
        this.f56715c = postCartData;
    }

    public final Object apply(Object obj) {
        return DarkstoresRepo.m9675postCartByCartId$lambda19(this.f56714b, this.f56715c, (Vendor) obj);
    }
}
