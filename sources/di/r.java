package di;

import com.talabat.darkstores.data.darkstores.DarkstoresRepo;
import com.talabat.feature.darkstoresvendor.domain.model.Vendor;
import io.reactivex.functions.Function;

public final /* synthetic */ class r implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DarkstoresRepo f56716b;

    public /* synthetic */ r(DarkstoresRepo darkstoresRepo) {
        this.f56716b = darkstoresRepo;
    }

    public final Object apply(Object obj) {
        return DarkstoresRepo.m9671getDiscounts$lambda5(this.f56716b, (Vendor) obj);
    }
}
