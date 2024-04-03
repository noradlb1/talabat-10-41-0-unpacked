package com.talabat.darkstores.feature.campaigns;

import com.talabat.darkstores.feature.campaigns.CampaignProgressState;
import com.talabat.feature.darkstorescampaignmessage.domain.model.CampaignProgress;
import com.talabat.feature.darkstorescampaignmessage.domain.model.CampaignProgressResponse;
import com.talabat.feature.darkstorescampaignmessage.domain.model.CampaignSource;
import com.talabat.feature.darkstorescampaignmessage.domain.model.CampaignState;
import com.talabat.mapper.ModelMapper;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000eB\u001b\b\u0007\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0001¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/talabat/darkstores/feature/campaigns/CampaignProgressStateMapper;", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/feature/darkstorescampaignmessage/domain/model/CampaignProgressResponse;", "Lcom/talabat/darkstores/feature/campaigns/CampaignProgressVisualisation;", "campaignSourceMapper", "Lcom/talabat/feature/darkstorescampaignmessage/domain/model/CampaignSource;", "Lcom/talabat/darkstores/feature/campaigns/CampaignProgressStateSource;", "(Lcom/talabat/mapper/ModelMapper;)V", "apply", "source", "mapToCampaignProgress", "Lcom/talabat/darkstores/feature/campaigns/CampaignProgressState;", "campaignProgress", "Lcom/talabat/feature/darkstorescampaignmessage/domain/model/CampaignProgress;", "Companion", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CampaignProgressStateMapper implements ModelMapper<CampaignProgressResponse, CampaignProgressVisualisation> {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int MILLIS_MULTIPLIER = 1000;
    @NotNull
    private final ModelMapper<CampaignSource, CampaignProgressStateSource> campaignSourceMapper;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/darkstores/feature/campaigns/CampaignProgressStateMapper$Companion;", "", "()V", "MILLIS_MULTIPLIER", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CampaignState.values().length];
            iArr[CampaignState.HIDDEN.ordinal()] = 1;
            iArr[CampaignState.IN_PROGRESS.ordinal()] = 2;
            iArr[CampaignState.SUCCESS.ordinal()] = 3;
            iArr[CampaignState.BELOW_THRESHOLD.ordinal()] = 4;
            iArr[CampaignState.TRANSIENT.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Inject
    public CampaignProgressStateMapper(@NotNull ModelMapper<CampaignSource, CampaignProgressStateSource> modelMapper) {
        Intrinsics.checkNotNullParameter(modelMapper, "campaignSourceMapper");
        this.campaignSourceMapper = modelMapper;
    }

    private final CampaignProgressState mapToCampaignProgress(CampaignProgress campaignProgress) {
        int i11 = WhenMappings.$EnumSwitchMapping$0[campaignProgress.getState().ordinal()];
        if (i11 == 1) {
            return CampaignProgressState.Hidden.INSTANCE;
        }
        Long l11 = null;
        if (i11 == 2) {
            String message = campaignProgress.getMessage();
            Integer valueOf = Integer.valueOf(MathKt__MathJVMKt.roundToInt(campaignProgress.getProgressValue()));
            Long showForSeconds = campaignProgress.getShowForSeconds();
            if (showForSeconds != null) {
                l11 = Long.valueOf(showForSeconds.longValue() * ((long) 1000));
            }
            boolean isTPro = campaignProgress.isTPro();
            CampaignProgressStateSource apply = this.campaignSourceMapper.apply(campaignProgress.getSource());
            Intrinsics.checkNotNullExpressionValue(apply, "campaignSourceMapper.app…(campaignProgress.source)");
            return new CampaignProgressState.InProgress(message, valueOf, l11, isTPro, apply);
        } else if (i11 == 3) {
            String message2 = campaignProgress.getMessage();
            Long showForSeconds2 = campaignProgress.getShowForSeconds();
            if (showForSeconds2 != null) {
                l11 = Long.valueOf(showForSeconds2.longValue() * ((long) 1000));
            }
            boolean isTPro2 = campaignProgress.isTPro();
            Integer valueOf2 = Integer.valueOf(MathKt__MathJVMKt.roundToInt(campaignProgress.getProgressValue()));
            CampaignProgressStateSource apply2 = this.campaignSourceMapper.apply(campaignProgress.getSource());
            Intrinsics.checkNotNullExpressionValue(apply2, "campaignSourceMapper.app…(campaignProgress.source)");
            return new CampaignProgressState.Success(message2, l11, isTPro2, valueOf2, apply2);
        } else if (i11 == 4) {
            String message3 = campaignProgress.getMessage();
            Integer valueOf3 = Integer.valueOf(MathKt__MathJVMKt.roundToInt(campaignProgress.getProgressValue()));
            Long showForSeconds3 = campaignProgress.getShowForSeconds();
            if (showForSeconds3 != null) {
                l11 = Long.valueOf(showForSeconds3.longValue() * ((long) 1000));
            }
            Long l12 = l11;
            boolean isTPro3 = campaignProgress.isTPro();
            CampaignProgressStateSource apply3 = this.campaignSourceMapper.apply(campaignProgress.getSource());
            Intrinsics.checkNotNullExpressionValue(apply3, "campaignSourceMapper.app…(campaignProgress.source)");
            return new CampaignProgressState.BelowThreshold(message3, valueOf3, l12, isTPro3, apply3);
        } else if (i11 == 5) {
            String message4 = campaignProgress.getMessage();
            Long showForSeconds4 = campaignProgress.getShowForSeconds();
            if (showForSeconds4 != null) {
                l11 = Long.valueOf(showForSeconds4.longValue() * ((long) 1000));
            }
            boolean isTPro4 = campaignProgress.isTPro();
            CampaignProgressStateSource apply4 = this.campaignSourceMapper.apply(campaignProgress.getSource());
            Intrinsics.checkNotNullExpressionValue(apply4, "campaignSourceMapper.app…(campaignProgress.source)");
            return new CampaignProgressState.Transient(message4, l11, isTPro4, apply4);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    @NotNull
    public CampaignProgressVisualisation apply(@NotNull CampaignProgressResponse campaignProgressResponse) {
        Intrinsics.checkNotNullParameter(campaignProgressResponse, "source");
        CampaignProgress campaignProgress = campaignProgressResponse.getTransient();
        return new CampaignProgressVisualisation(campaignProgress != null ? mapToCampaignProgress(campaignProgress) : null, mapToCampaignProgress(campaignProgressResponse.getPermanent()));
    }
}
