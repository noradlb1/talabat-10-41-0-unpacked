package di;

import com.talabat.darkstores.data.darkstores.DarkstoresRepo;
import com.talabat.feature.darkstoresvendor.domain.model.Vendor;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class v implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DarkstoresRepo f56722b;

    public /* synthetic */ v(DarkstoresRepo darkstoresRepo) {
        this.f56722b = darkstoresRepo;
    }

    public final void accept(Object obj) {
        DarkstoresRepo.m9680vendorSingle$lambda0(this.f56722b, (Vendor) obj);
    }
}
