package com.talabat.feature.ulcampaign.data;

import com.talabat.feature.ulcampaign.data.tools.DeeplinkParser;
import com.talabat.feature.ulcampaign.domain.CampaignMigratorRepository;
import com.talabat.feature.ulcampaign.domain.CampaignMigratorSharedPreferences;
import com.talabat.homescreen.network.UrlConstantsKt;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001d\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0016¢\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/talabat/feature/ulcampaign/data/CampaignMigratorRepositoryImpl;", "Lcom/talabat/feature/ulcampaign/domain/CampaignMigratorRepository;", "observability", "Lcom/talabat/feature/ulcampaign/data/CampaignMigratorObservability;", "sharedPreferencesManager", "Lcom/talabat/feature/ulcampaign/domain/CampaignMigratorSharedPreferences;", "(Lcom/talabat/feature/ulcampaign/data/CampaignMigratorObservability;Lcom/talabat/feature/ulcampaign/domain/CampaignMigratorSharedPreferences;)V", "handleDeeplinkVoucherCampaign", "", "parts", "", "", "([Ljava/lang/String;)Z", "com_talabat_feature_ul-campaign_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CampaignMigratorRepositoryImpl implements CampaignMigratorRepository {
    @NotNull
    private final CampaignMigratorObservability observability;
    @NotNull
    private final CampaignMigratorSharedPreferences sharedPreferencesManager;

    @Inject
    public CampaignMigratorRepositoryImpl(@NotNull CampaignMigratorObservability campaignMigratorObservability, @NotNull CampaignMigratorSharedPreferences campaignMigratorSharedPreferences) {
        Intrinsics.checkNotNullParameter(campaignMigratorObservability, "observability");
        Intrinsics.checkNotNullParameter(campaignMigratorSharedPreferences, "sharedPreferencesManager");
        this.observability = campaignMigratorObservability;
        this.sharedPreferencesManager = campaignMigratorSharedPreferences;
    }

    public boolean handleDeeplinkVoucherCampaign(@Nullable String[] strArr) {
        boolean z11;
        boolean z12;
        if (strArr == null) {
            this.observability.observeVoucherCampaignFailed(MapsKt__MapsKt.mapOf(TuplesKt.to(UrlConstantsKt.HEADER_VOUCHER, ""), TuplesKt.to("external_user_id", ""), TuplesKt.to("campaign_name", "")));
        } else {
            DeeplinkParser deeplinkParser = DeeplinkParser.INSTANCE;
            if (deeplinkParser.getStringValue(strArr, "s").equals("voucher_campaign")) {
                String stringValue = deeplinkParser.getStringValue(strArr, UrlConstantsKt.HEADER_VOUCHER);
                String stringValue2 = deeplinkParser.getStringValue(strArr, "external_user_id");
                String stringValue3 = deeplinkParser.getStringValue(strArr, "campaign_name");
                Map mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(UrlConstantsKt.HEADER_VOUCHER, stringValue), TuplesKt.to("external_user_id", stringValue2), TuplesKt.to("campaign_name", stringValue3));
                if (stringValue.length() > 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    if (stringValue3.length() > 0) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    if (z12) {
                        this.sharedPreferencesManager.storeCampaignParams(stringValue, stringValue2, stringValue3);
                        this.observability.observeVoucherCampaignLoaded(mapOf);
                        return true;
                    }
                }
                this.observability.observeVoucherCampaignFailed(mapOf);
            }
        }
        return false;
    }
}
