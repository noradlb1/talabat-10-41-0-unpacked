package qi;

import com.talabat.darkstores.data.darkstores.DarkstoresRepo;
import com.talabat.darkstores.domain.common.ApplyDiscountsAndCampaignsUseCaseImpl;
import io.reactivex.functions.Function;
import kotlin.Unit;

public final /* synthetic */ class c implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DarkstoresRepo f57198b;

    public /* synthetic */ c(DarkstoresRepo darkstoresRepo) {
        this.f57198b = darkstoresRepo;
    }

    public final Object apply(Object obj) {
        return ApplyDiscountsAndCampaignsUseCaseImpl.m9745campaignTriggersByProduct$lambda3(this.f57198b, (Unit) obj);
    }
}
