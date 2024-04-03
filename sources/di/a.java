package di;

import com.talabat.darkstores.data.darkstores.DarkstoresRepo;
import com.talabat.feature.darkstoresvendor.domain.model.Vendor;
import io.reactivex.functions.Function;

public final /* synthetic */ class a implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DarkstoresRepo f56697b;

    public /* synthetic */ a(DarkstoresRepo darkstoresRepo) {
        this.f56697b = darkstoresRepo;
    }

    public final Object apply(Object obj) {
        return DarkstoresRepo.m9668getCart$lambda23(this.f56697b, (Vendor) obj);
    }
}
