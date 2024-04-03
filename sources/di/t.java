package di;

import com.talabat.darkstores.data.darkstores.DarkstoresRepo;
import com.talabat.feature.darkstoresvendor.domain.model.Vendor;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class t implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DarkstoresRepo f56718b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Vendor f56719c;

    public /* synthetic */ t(DarkstoresRepo darkstoresRepo, Vendor vendor) {
        this.f56718b = darkstoresRepo;
        this.f56719c = vendor;
    }

    public final void accept(Object obj) {
        DarkstoresRepo.m9660getAllCampaignsTriggers$lambda17$lambda16(this.f56718b, this.f56719c, (Throwable) obj);
    }
}
