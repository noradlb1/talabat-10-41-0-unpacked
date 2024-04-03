package di;

import com.talabat.darkstores.data.darkstores.DarkstoresRepo;
import com.talabat.feature.darkstoresvendor.domain.model.Vendor;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class k implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DarkstoresRepo f56707b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Vendor f56708c;

    public /* synthetic */ k(DarkstoresRepo darkstoresRepo, Vendor vendor) {
        this.f56707b = darkstoresRepo;
        this.f56708c = vendor;
    }

    public final void accept(Object obj) {
        DarkstoresRepo.m9665getCampaignForProduct$lambda11$lambda10(this.f56707b, this.f56708c, (Throwable) obj);
    }
}
