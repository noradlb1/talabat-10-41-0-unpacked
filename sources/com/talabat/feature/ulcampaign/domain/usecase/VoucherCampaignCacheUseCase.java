package com.talabat.feature.ulcampaign.domain.usecase;

import com.talabat.feature.ulcampaign.domain.CampaignMigratorSharedPreferences;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/talabat/feature/ulcampaign/domain/usecase/VoucherCampaignCacheUseCase;", "", "campaignMigratorSharedPreferences", "Lcom/talabat/feature/ulcampaign/domain/CampaignMigratorSharedPreferences;", "(Lcom/talabat/feature/ulcampaign/domain/CampaignMigratorSharedPreferences;)V", "clear", "", "getPrefCampaignName", "", "getPrefExternalUserId", "getPrefVoucher", "com_talabat_feature_ul-campaign_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VoucherCampaignCacheUseCase {
    @NotNull
    private final CampaignMigratorSharedPreferences campaignMigratorSharedPreferences;

    @Inject
    public VoucherCampaignCacheUseCase(@NotNull CampaignMigratorSharedPreferences campaignMigratorSharedPreferences2) {
        Intrinsics.checkNotNullParameter(campaignMigratorSharedPreferences2, "campaignMigratorSharedPreferences");
        this.campaignMigratorSharedPreferences = campaignMigratorSharedPreferences2;
    }

    public final void clear() {
        this.campaignMigratorSharedPreferences.clear();
    }

    @NotNull
    public final String getPrefCampaignName() {
        return this.campaignMigratorSharedPreferences.getPrefCampaignName();
    }

    @NotNull
    public final String getPrefExternalUserId() {
        return this.campaignMigratorSharedPreferences.getPrefExternalUserId();
    }

    @NotNull
    public final String getPrefVoucher() {
        return this.campaignMigratorSharedPreferences.getPrefVoucher();
    }
}
