package com.talabat.feature.darkstorescampaignmessage.data.mapper;

import com.talabat.feature.darkstorescampaignmessage.domain.model.CampaignSource;
import com.talabat.mapper.ModelMapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/darkstorescampaignmessage/data/mapper/CampaignProgressSourceMapper;", "Lcom/talabat/mapper/ModelMapper;", "", "Lcom/talabat/feature/darkstorescampaignmessage/domain/model/CampaignSource;", "()V", "apply", "source", "com_talabat_feature_darkstores-campaign-message_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CampaignProgressSourceMapper implements ModelMapper<String, CampaignSource> {
    @NotNull
    public CampaignSource apply(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "source");
        switch (str.hashCode()) {
            case -2038367367:
                if (str.equals("LegacyDeliveryFeeCampaign")) {
                    return CampaignSource.LEGACY_DELIVERY_FEE_CAMPAIGN;
                }
                break;
            case -1371070974:
                if (str.equals("DeliveryFeeCampaign")) {
                    return CampaignSource.DELIVERY_FEE_CAMPAIGN;
                }
                break;
            case -1282408943:
                if (str.equals("NoCampaign")) {
                    return CampaignSource.NO_CAMPAIGN;
                }
                break;
            case -692665066:
                if (str.equals("BasketCampaign")) {
                    return CampaignSource.BASKET_CAMPAIGN;
                }
                break;
            case -681971932:
                if (str.equals("Initial")) {
                    return CampaignSource.INITIAL;
                }
                break;
            case 77556:
                if (str.equals("Mov")) {
                    return CampaignSource.MOV;
                }
                break;
            case 2582969:
                if (str.equals("TPro")) {
                    return CampaignSource.TPRO;
                }
                break;
            case 8836518:
                if (str.equals("VoucherMov")) {
                    return CampaignSource.VOUCHER_MOV;
                }
                break;
            case 67883350:
                if (str.equals("Final")) {
                    return CampaignSource.FINAL;
                }
                break;
        }
        return CampaignSource.UNKNOWN;
    }
}
