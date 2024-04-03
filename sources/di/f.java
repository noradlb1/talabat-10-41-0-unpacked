package di;

import com.talabat.darkstores.data.darkstores.DarkstoresRepo;
import com.talabat.feature.darkstoresvendor.domain.model.Vendor;
import io.reactivex.functions.Function;

public final /* synthetic */ class f implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DarkstoresRepo f56703b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f56704c;

    public /* synthetic */ f(DarkstoresRepo darkstoresRepo, String str) {
        this.f56703b = darkstoresRepo;
        this.f56704c = str;
    }

    public final Object apply(Object obj) {
        return DarkstoresRepo.m9672getProductBySku$lambda7(this.f56703b, this.f56704c, (Vendor) obj);
    }
}
