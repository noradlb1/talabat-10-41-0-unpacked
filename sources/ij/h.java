package ij;

import com.talabat.darkstores.domain.common.ApplyDiscountsAndCampaignsUseCase;
import com.talabat.darkstores.domain.model.MissionControlProducts;
import io.reactivex.functions.Function;

public final /* synthetic */ class h implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ApplyDiscountsAndCampaignsUseCase f56913b;

    public /* synthetic */ h(ApplyDiscountsAndCampaignsUseCase applyDiscountsAndCampaignsUseCase) {
        this.f56913b = applyDiscountsAndCampaignsUseCase;
    }

    public final Object apply(Object obj) {
        return this.f56913b.invoke((MissionControlProducts) obj);
    }
}
