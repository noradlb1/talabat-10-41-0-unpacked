package ri;

import com.talabat.darkstores.data.grocery.model.CampaignProgressResponse;
import com.talabat.darkstores.feature.campaigns.CampaignProgressVisualisation;
import io.reactivex.functions.Function;

public final /* synthetic */ class f implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CampaignProgressVisualisation.Companion f57302b;

    public /* synthetic */ f(CampaignProgressVisualisation.Companion companion) {
        this.f57302b = companion;
    }

    public final Object apply(Object obj) {
        return this.f57302b.fromResponse((CampaignProgressResponse) obj);
    }
}
