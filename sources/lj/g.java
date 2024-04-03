package lj;

import com.talabat.darkstores.feature.product.views.CampaignProgressState;
import com.talabat.darkstores.feature.product.views.CampaignProgressView;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class g implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CampaignProgressView f57014b;

    public /* synthetic */ g(CampaignProgressView campaignProgressView) {
        this.f57014b = campaignProgressView;
    }

    public final void accept(Object obj) {
        this.f57014b.handleState((CampaignProgressState) obj);
    }
}
