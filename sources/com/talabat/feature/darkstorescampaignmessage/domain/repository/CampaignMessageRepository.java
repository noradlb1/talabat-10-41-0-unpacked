package com.talabat.feature.darkstorescampaignmessage.domain.repository;

import com.talabat.feature.darkstorescampaignmessage.domain.model.CampaignMessageParams;
import com.talabat.feature.darkstorescampaignmessage.domain.model.CampaignProgressResponse;
import io.reactivex.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/darkstorescampaignmessage/domain/repository/CampaignMessageRepository;", "", "getCampaignMessage", "Lio/reactivex/Single;", "Lcom/talabat/feature/darkstorescampaignmessage/domain/model/CampaignProgressResponse;", "params", "Lcom/talabat/feature/darkstorescampaignmessage/domain/model/CampaignMessageParams;", "com_talabat_feature_darkstores-campaign-message_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CampaignMessageRepository {
    @NotNull
    Single<CampaignProgressResponse> getCampaignMessage(@NotNull CampaignMessageParams campaignMessageParams);
}
