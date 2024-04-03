package di;

import com.talabat.darkstores.data.darkstores.DarkstoresRepo;
import com.talabat.feature.darkstoresvendor.domain.model.Vendor;
import io.reactivex.functions.Function;

public final /* synthetic */ class c implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DarkstoresRepo f56700b;

    public /* synthetic */ c(DarkstoresRepo darkstoresRepo) {
        this.f56700b = darkstoresRepo;
    }

    public final Object apply(Object obj) {
        return DarkstoresRepo.m9659getAllCampaignsTriggers$lambda17(this.f56700b, (Vendor) obj);
    }
}
