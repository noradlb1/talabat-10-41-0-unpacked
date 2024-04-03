package di;

import com.talabat.darkstores.data.darkstores.DarkstoresRepo;
import com.talabat.feature.darkstoresvendor.domain.model.Vendor;
import io.reactivex.functions.Function;

public final /* synthetic */ class x implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DarkstoresRepo f56724b;

    public /* synthetic */ x(DarkstoresRepo darkstoresRepo) {
        this.f56724b = darkstoresRepo;
    }

    public final Object apply(Object obj) {
        return DarkstoresRepo.m9678vendorCampaigns$lambda15(this.f56724b, (Vendor) obj);
    }
}
