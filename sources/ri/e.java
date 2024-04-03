package ri;

import com.talabat.darkstores.feature.cart.CampaignProgressUseCase;
import com.talabat.feature.darkstorescampaignmessage.domain.model.CampaignProgressResponse;
import io.reactivex.functions.Function;

public final /* synthetic */ class e implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CampaignProgressUseCase f57299b;

    public /* synthetic */ e(CampaignProgressUseCase campaignProgressUseCase) {
        this.f57299b = campaignProgressUseCase;
    }

    public final Object apply(Object obj) {
        return CampaignProgressUseCase.m9773getCampaignProgress$lambda2(this.f57299b, (CampaignProgressResponse) obj);
    }
}
