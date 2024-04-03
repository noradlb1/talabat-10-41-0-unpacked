package com.talabat.feature.ulcampaign.data;

import com.talabat.core.di.Api;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005H&J\u001c\u0010\u0007\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005H&¨\u0006\b"}, d2 = {"Lcom/talabat/feature/ulcampaign/data/CampaignMigratorObservability;", "Lcom/talabat/core/di/Api;", "observeVoucherCampaignFailed", "", "attributes", "", "", "observeVoucherCampaignLoaded", "com_talabat_feature_ul-campaign_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CampaignMigratorObservability extends Api {
    void observeVoucherCampaignFailed(@NotNull Map<String, String> map);

    void observeVoucherCampaignLoaded(@NotNull Map<String, String> map);
}
