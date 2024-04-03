package com.talabat.feature.darkstorescampaignmessage.domain.usecase;

import com.facebook.internal.NativeProtocol;
import com.talabat.feature.darkstorescampaignmessage.domain.model.CampaignMessageParams;
import com.talabat.feature.darkstorescampaignmessage.domain.model.CampaignProgressResponse;
import com.talabat.feature.darkstorescampaignmessage.domain.repository.CampaignMessageRepository;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/talabat/feature/darkstorescampaignmessage/domain/usecase/GetCampaignMessageUseCase;", "", "campaignMessageRepository", "Lcom/talabat/feature/darkstorescampaignmessage/domain/repository/CampaignMessageRepository;", "(Lcom/talabat/feature/darkstorescampaignmessage/domain/repository/CampaignMessageRepository;)V", "invoke", "Lio/reactivex/Single;", "Lcom/talabat/feature/darkstorescampaignmessage/domain/model/CampaignProgressResponse;", "params", "Lcom/talabat/feature/darkstorescampaignmessage/domain/model/CampaignMessageParams;", "com_talabat_feature_darkstores-campaign-message_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetCampaignMessageUseCase {
    @NotNull
    private final CampaignMessageRepository campaignMessageRepository;

    @Inject
    public GetCampaignMessageUseCase(@NotNull CampaignMessageRepository campaignMessageRepository2) {
        Intrinsics.checkNotNullParameter(campaignMessageRepository2, "campaignMessageRepository");
        this.campaignMessageRepository = campaignMessageRepository2;
    }

    @NotNull
    public final Single<CampaignProgressResponse> invoke(@NotNull CampaignMessageParams campaignMessageParams) {
        Intrinsics.checkNotNullParameter(campaignMessageParams, NativeProtocol.WEB_DIALOG_PARAMS);
        return this.campaignMessageRepository.getCampaignMessage(campaignMessageParams);
    }
}
