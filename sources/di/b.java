package di;

import com.talabat.darkstores.data.darkstores.DarkstoresRepo;
import com.talabat.feature.darkstoresvendor.domain.model.Vendor;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class b implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DarkstoresRepo f56698b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Vendor f56699c;

    public /* synthetic */ b(DarkstoresRepo darkstoresRepo, Vendor vendor) {
        this.f56698b = darkstoresRepo;
        this.f56699c = vendor;
    }

    public final void accept(Object obj) {
        DarkstoresRepo.m9669getCart$lambda23$lambda22(this.f56698b, this.f56699c, (Throwable) obj);
    }
}
