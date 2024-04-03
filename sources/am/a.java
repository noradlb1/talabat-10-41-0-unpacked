package am;

import com.talabat.feature.darkstorescampaignmessage.data.model.NetworkCampaignProgressResponse;
import com.talabat.feature.darkstorescampaignmessage.data.repository.CampaignMessageRepositoryImpl;
import io.reactivex.functions.Function;

public final /* synthetic */ class a implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CampaignMessageRepositoryImpl f58115b;

    public /* synthetic */ a(CampaignMessageRepositoryImpl campaignMessageRepositoryImpl) {
        this.f58115b = campaignMessageRepositoryImpl;
    }

    public final Object apply(Object obj) {
        return CampaignMessageRepositoryImpl.m10152getCampaignMessage$lambda0(this.f58115b, (NetworkCampaignProgressResponse) obj);
    }
}
