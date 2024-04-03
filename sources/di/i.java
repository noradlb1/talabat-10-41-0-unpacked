package di;

import com.talabat.darkstores.data.darkstores.DarkstoresRepo;
import com.talabat.feature.darkstoresvendor.domain.model.Vendor;
import io.reactivex.functions.Function;

public final /* synthetic */ class i implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DarkstoresRepo f56705b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f56706c;

    public /* synthetic */ i(DarkstoresRepo darkstoresRepo, String str) {
        this.f56705b = darkstoresRepo;
        this.f56706c = str;
    }

    public final Object apply(Object obj) {
        return DarkstoresRepo.m9664getCampaignForProduct$lambda11(this.f56705b, this.f56706c, (Vendor) obj);
    }
}
