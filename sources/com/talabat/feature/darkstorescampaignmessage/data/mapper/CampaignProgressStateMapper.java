package com.talabat.feature.darkstorescampaignmessage.data.mapper;

import com.talabat.feature.darkstorescampaignmessage.data.model.NetworkCampaignProgressState;
import com.talabat.feature.darkstorescampaignmessage.domain.model.CampaignState;
import com.talabat.mapper.ModelMapper;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/darkstorescampaignmessage/data/mapper/CampaignProgressStateMapper;", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/feature/darkstorescampaignmessage/data/model/NetworkCampaignProgressState;", "Lcom/talabat/feature/darkstorescampaignmessage/domain/model/CampaignState;", "()V", "apply", "source", "com_talabat_feature_darkstores-campaign-message_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CampaignProgressStateMapper implements ModelMapper<NetworkCampaignProgressState, CampaignState> {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[NetworkCampaignProgressState.values().length];
            iArr[NetworkCampaignProgressState.HIDDEN.ordinal()] = 1;
            iArr[NetworkCampaignProgressState.IN_PROGRESS.ordinal()] = 2;
            iArr[NetworkCampaignProgressState.SUCCESS.ordinal()] = 3;
            iArr[NetworkCampaignProgressState.BELOW_THRESHOLD.ordinal()] = 4;
            iArr[NetworkCampaignProgressState.TRANSIENT.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @NotNull
    public CampaignState apply(@NotNull NetworkCampaignProgressState networkCampaignProgressState) {
        Intrinsics.checkNotNullParameter(networkCampaignProgressState, "source");
        int i11 = WhenMappings.$EnumSwitchMapping$0[networkCampaignProgressState.ordinal()];
        if (i11 == 1) {
            return CampaignState.HIDDEN;
        }
        if (i11 == 2) {
            return CampaignState.IN_PROGRESS;
        }
        if (i11 == 3) {
            return CampaignState.SUCCESS;
        }
        if (i11 == 4) {
            return CampaignState.BELOW_THRESHOLD;
        }
        if (i11 == 5) {
            return CampaignState.TRANSIENT;
        }
        throw new NoWhenBranchMatchedException();
    }
}
