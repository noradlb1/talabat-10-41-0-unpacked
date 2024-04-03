package com.talabat.feature.ulcampaign.data;

import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.common.VoucherCampaignStatus;
import com.talabat.fluttercore.channels.AnalyticsMethodChannel;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bH\u0016J\u001c\u0010\n\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/talabat/feature/ulcampaign/data/CampaignMigratorObservabilityImpl;", "Lcom/talabat/feature/ulcampaign/data/CampaignMigratorObservability;", "observability", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "(Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "observeVoucherCampaignFailed", "", "attributes", "", "", "observeVoucherCampaignLoaded", "com_talabat_feature_ul-campaign_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CampaignMigratorObservabilityImpl implements CampaignMigratorObservability {
    @NotNull
    private final IObservabilityManager observability;

    @Inject
    public CampaignMigratorObservabilityImpl(@NotNull IObservabilityManager iObservabilityManager) {
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observability");
        this.observability = iObservabilityManager;
    }

    public void observeVoucherCampaignFailed(@NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        this.observability.trackVoucherCampaign(VoucherCampaignStatus.VOUCHER_CAMPAIGN_DEEPLINK_FAILED, map);
    }

    public void observeVoucherCampaignLoaded(@NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        this.observability.trackVoucherCampaign(VoucherCampaignStatus.VOUCHER_CAMPAIGN_DEEPLINK_LOADED, map);
    }
}
