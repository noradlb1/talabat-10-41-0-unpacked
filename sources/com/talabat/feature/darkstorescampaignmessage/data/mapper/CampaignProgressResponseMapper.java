package com.talabat.feature.darkstorescampaignmessage.data.mapper;

import com.talabat.feature.darkstorescampaignmessage.data.model.NetworkCampaignProgress;
import com.talabat.feature.darkstorescampaignmessage.data.model.NetworkCampaignProgressResponse;
import com.talabat.feature.darkstorescampaignmessage.data.model.NetworkCampaignProgressState;
import com.talabat.feature.darkstorescampaignmessage.domain.model.CampaignProgress;
import com.talabat.feature.darkstorescampaignmessage.domain.model.CampaignProgressResponse;
import com.talabat.feature.darkstorescampaignmessage.domain.model.CampaignSource;
import com.talabat.feature.darkstorescampaignmessage.domain.model.CampaignState;
import com.talabat.mapper.ModelMapper;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B/\b\u0007\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0001\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0001¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0016J\f\u0010\r\u001a\u00020\u000e*\u00020\u000fH\u0002R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/talabat/feature/darkstorescampaignmessage/data/mapper/CampaignProgressResponseMapper;", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/feature/darkstorescampaignmessage/data/model/NetworkCampaignProgressResponse;", "Lcom/talabat/feature/darkstorescampaignmessage/domain/model/CampaignProgressResponse;", "stateMapper", "Lcom/talabat/feature/darkstorescampaignmessage/data/model/NetworkCampaignProgressState;", "Lcom/talabat/feature/darkstorescampaignmessage/domain/model/CampaignState;", "sourceMapper", "", "Lcom/talabat/feature/darkstorescampaignmessage/domain/model/CampaignSource;", "(Lcom/talabat/mapper/ModelMapper;Lcom/talabat/mapper/ModelMapper;)V", "apply", "source", "toCampaignProgress", "Lcom/talabat/feature/darkstorescampaignmessage/domain/model/CampaignProgress;", "Lcom/talabat/feature/darkstorescampaignmessage/data/model/NetworkCampaignProgress;", "com_talabat_feature_darkstores-campaign-message_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CampaignProgressResponseMapper implements ModelMapper<NetworkCampaignProgressResponse, CampaignProgressResponse> {
    @NotNull
    private final ModelMapper<String, CampaignSource> sourceMapper;
    @NotNull
    private final ModelMapper<NetworkCampaignProgressState, CampaignState> stateMapper;

    @Inject
    public CampaignProgressResponseMapper(@NotNull ModelMapper<NetworkCampaignProgressState, CampaignState> modelMapper, @NotNull ModelMapper<String, CampaignSource> modelMapper2) {
        Intrinsics.checkNotNullParameter(modelMapper, "stateMapper");
        Intrinsics.checkNotNullParameter(modelMapper2, "sourceMapper");
        this.stateMapper = modelMapper;
        this.sourceMapper = modelMapper2;
    }

    private final CampaignProgress toCampaignProgress(NetworkCampaignProgress networkCampaignProgress) {
        float f11;
        CampaignState campaignState;
        boolean z11;
        CampaignSource campaignSource;
        String iconImage = networkCampaignProgress.getIconImage();
        String message = networkCampaignProgress.getMessage();
        if (message == null) {
            message = "";
        }
        String str = message;
        Float progressValue = networkCampaignProgress.getProgressValue();
        if (progressValue != null) {
            f11 = progressValue.floatValue();
        } else {
            f11 = 0.0f;
        }
        float f12 = f11;
        Long showForSeconds = networkCampaignProgress.getShowForSeconds();
        NetworkCampaignProgressState state = networkCampaignProgress.getState();
        CampaignSource campaignSource2 = null;
        if (state != null) {
            campaignState = this.stateMapper.apply(state);
        } else {
            campaignState = null;
        }
        if (campaignState == null) {
            campaignState = CampaignState.HIDDEN;
        }
        CampaignState campaignState2 = campaignState;
        Boolean isTPro = networkCampaignProgress.isTPro();
        if (isTPro != null) {
            z11 = isTPro.booleanValue();
        } else {
            z11 = false;
        }
        boolean z12 = z11;
        String messageSource = networkCampaignProgress.getMessageSource();
        if (messageSource != null) {
            campaignSource2 = this.sourceMapper.apply(messageSource);
        }
        if (campaignSource2 == null) {
            campaignSource = CampaignSource.UNKNOWN;
        } else {
            campaignSource = campaignSource2;
        }
        return new CampaignProgress(iconImage, str, f12, showForSeconds, campaignState2, z12, campaignSource);
    }

    @NotNull
    public CampaignProgressResponse apply(@NotNull NetworkCampaignProgressResponse networkCampaignProgressResponse) {
        CampaignProgress campaignProgress;
        Intrinsics.checkNotNullParameter(networkCampaignProgressResponse, "source");
        NetworkCampaignProgress networkCampaignProgress = networkCampaignProgressResponse.getTransient();
        CampaignProgress campaignProgress2 = networkCampaignProgress != null ? toCampaignProgress(networkCampaignProgress) : null;
        NetworkCampaignProgress permanent = networkCampaignProgressResponse.getPermanent();
        if (permanent == null || (campaignProgress = toCampaignProgress(permanent)) == null) {
            campaignProgress = new CampaignProgress((String) null, "", 0.0f, (Long) null, CampaignState.HIDDEN, false, CampaignSource.UNKNOWN);
        }
        return new CampaignProgressResponse(campaignProgress, campaignProgress2);
    }
}
