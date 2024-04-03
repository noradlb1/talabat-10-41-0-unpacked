package di;

import com.talabat.darkstores.data.darkstores.DarkstoresRepo;
import com.talabat.feature.darkstoresvendor.domain.model.Vendor;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class p implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DarkstoresRepo f56712b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Vendor f56713c;

    public /* synthetic */ p(DarkstoresRepo darkstoresRepo, Vendor vendor) {
        this.f56712b = darkstoresRepo;
        this.f56713c = vendor;
    }

    public final void accept(Object obj) {
        DarkstoresRepo.m9679vendorCampaigns$lambda15$lambda14(this.f56712b, this.f56713c, (Throwable) obj);
    }
}
