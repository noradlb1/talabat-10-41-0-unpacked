package di;

import com.talabat.darkstores.data.darkstores.DarkstoresRepo;
import com.talabat.feature.darkstoresvendor.domain.model.Vendor;
import io.reactivex.functions.Function;

public final /* synthetic */ class l implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DarkstoresRepo f56709b;

    public /* synthetic */ l(DarkstoresRepo darkstoresRepo) {
        this.f56709b = darkstoresRepo;
    }

    public final Object apply(Object obj) {
        return DarkstoresRepo.m9670getCustomerVouchers$lambda6(this.f56709b, (Vendor) obj);
    }
}
