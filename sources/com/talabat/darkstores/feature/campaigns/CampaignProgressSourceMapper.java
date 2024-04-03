package com.talabat.darkstores.feature.campaigns;

import com.talabat.feature.darkstorescampaignmessage.domain.model.CampaignSource;
import com.talabat.mapper.ModelMapper;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/talabat/darkstores/feature/campaigns/CampaignProgressSourceMapper;", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/feature/darkstorescampaignmessage/domain/model/CampaignSource;", "Lcom/talabat/darkstores/feature/campaigns/CampaignProgressStateSource;", "()V", "apply", "source", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CampaignProgressSourceMapper implements ModelMapper<CampaignSource, CampaignProgressStateSource> {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CampaignSource.values().length];
            iArr[CampaignSource.INITIAL.ordinal()] = 1;
            iArr[CampaignSource.BASKET_CAMPAIGN.ordinal()] = 2;
            iArr[CampaignSource.DELIVERY_FEE_CAMPAIGN.ordinal()] = 3;
            iArr[CampaignSource.LEGACY_DELIVERY_FEE_CAMPAIGN.ordinal()] = 4;
            iArr[CampaignSource.MOV.ordinal()] = 5;
            iArr[CampaignSource.NO_CAMPAIGN.ordinal()] = 6;
            iArr[CampaignSource.TPRO.ordinal()] = 7;
            iArr[CampaignSource.VOUCHER_MOV.ordinal()] = 8;
            iArr[CampaignSource.FINAL.ordinal()] = 9;
            iArr[CampaignSource.UNKNOWN.ordinal()] = 10;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @NotNull
    public CampaignProgressStateSource apply(@NotNull CampaignSource campaignSource) {
        Intrinsics.checkNotNullParameter(campaignSource, "source");
        switch (WhenMappings.$EnumSwitchMapping$0[campaignSource.ordinal()]) {
            case 1:
                return CampaignProgressStateSource.INITIAL;
            case 2:
                return CampaignProgressStateSource.BASKET_CAMPAIGN;
            case 3:
                return CampaignProgressStateSource.DELIVERY_FEE_CAMPAIGN;
            case 4:
                return CampaignProgressStateSource.LEGACY_DELIVERY_FEE_CAMPAIGN;
            case 5:
                return CampaignProgressStateSource.MOV;
            case 6:
                return CampaignProgressStateSource.NO_CAMPAIGN;
            case 7:
                return CampaignProgressStateSource.TPRO;
            case 8:
                return CampaignProgressStateSource.VOUCHER_MOV;
            case 9:
                return CampaignProgressStateSource.FINAL;
            case 10:
                return CampaignProgressStateSource.UNKNOWN;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
