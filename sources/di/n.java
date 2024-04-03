package di;

import com.talabat.darkstores.data.darkstores.DarkstoresRepo;
import com.talabat.feature.darkstoresvendor.domain.model.Vendor;
import io.reactivex.functions.Function;

public final /* synthetic */ class n implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DarkstoresRepo f56711b;

    public /* synthetic */ n(DarkstoresRepo darkstoresRepo) {
        this.f56711b = darkstoresRepo;
    }

    public final Object apply(Object obj) {
        return DarkstoresRepo.m9662getBanners$lambda1(this.f56711b, (Vendor) obj);
    }
}
