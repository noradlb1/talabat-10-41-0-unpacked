package com.talabat.feature.ulcampaign.domain;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0005H&J \u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H&¨\u0006\f"}, d2 = {"Lcom/talabat/feature/ulcampaign/domain/CampaignMigratorSharedPreferences;", "", "clear", "", "getPrefCampaignName", "", "getPrefExternalUserId", "getPrefVoucher", "storeCampaignParams", "voucherCode", "userId", "campaignName", "com_talabat_feature_ul-campaign_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CampaignMigratorSharedPreferences {
    void clear();

    @NotNull
    String getPrefCampaignName();

    @NotNull
    String getPrefExternalUserId();

    @NotNull
    String getPrefVoucher();

    void storeCampaignParams(@NotNull String str, @NotNull String str2, @NotNull String str3);
}
