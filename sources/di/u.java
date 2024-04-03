package di;

import com.talabat.darkstores.data.darkstores.DarkstoresRepo;
import com.talabat.feature.darkstoresvendor.domain.model.Vendor;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class u implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DarkstoresRepo f56720b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Vendor f56721c;

    public /* synthetic */ u(DarkstoresRepo darkstoresRepo, Vendor vendor) {
        this.f56720b = darkstoresRepo;
        this.f56721c = vendor;
    }

    public final void accept(Object obj) {
        DarkstoresRepo.m9677postCartByVendorId$lambda21$lambda20(this.f56720b, this.f56721c, (Throwable) obj);
    }
}
