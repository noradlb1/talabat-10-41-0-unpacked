package com.talabat.feature.ulcampaign.data;

import android.content.Context;
import android.content.SharedPreferences;
import com.talabat.core.context.domain.ApplicationContext;
import com.talabat.feature.ulcampaign.domain.CampaignMigratorSharedPreferences;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0016J \u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/talabat/feature/ulcampaign/data/CampaignMigratorSharedPreferencesImpl;", "Lcom/talabat/feature/ulcampaign/domain/CampaignMigratorSharedPreferences;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "campaignMigratorSharedPrefsName", "", "prefCampaignName", "prefExternalUserId", "prefVoucher", "sharedPreferences", "Landroid/content/SharedPreferences;", "sharedPreferencesEditor", "Landroid/content/SharedPreferences$Editor;", "kotlin.jvm.PlatformType", "clear", "", "getPrefCampaignName", "getPrefExternalUserId", "getPrefVoucher", "storeCampaignParams", "voucherCode", "userId", "campaignName", "com_talabat_feature_ul-campaign_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CampaignMigratorSharedPreferencesImpl implements CampaignMigratorSharedPreferences {
    @NotNull
    private final String campaignMigratorSharedPrefsName = "campaign_migrator_shared_prefs_name";
    @NotNull
    private final String prefCampaignName = "pref_campaign_name";
    @NotNull
    private final String prefExternalUserId = "pref_external_user_id";
    @NotNull
    private final String prefVoucher = "pref_voucher";
    @NotNull
    private final SharedPreferences sharedPreferences;
    private final SharedPreferences.Editor sharedPreferencesEditor;

    @Inject
    public CampaignMigratorSharedPreferencesImpl(@NotNull @ApplicationContext Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences sharedPreferences2 = context.getApplicationContext().getSharedPreferences("campaign_migrator_shared_prefs_name", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences2, "context.applicationConte…xt.MODE_PRIVATE\n        )");
        this.sharedPreferences = sharedPreferences2;
        this.sharedPreferencesEditor = sharedPreferences2.edit();
    }

    public void clear() {
        this.sharedPreferencesEditor.clear().apply();
    }

    @NotNull
    public String getPrefCampaignName() {
        return String.valueOf(this.sharedPreferences.getString(this.prefCampaignName, ""));
    }

    @NotNull
    public String getPrefExternalUserId() {
        return String.valueOf(this.sharedPreferences.getString(this.prefExternalUserId, ""));
    }

    @NotNull
    public String getPrefVoucher() {
        return String.valueOf(this.sharedPreferences.getString(this.prefVoucher, ""));
    }

    public void storeCampaignParams(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "voucherCode");
        Intrinsics.checkNotNullParameter(str2, "userId");
        Intrinsics.checkNotNullParameter(str3, "campaignName");
        this.sharedPreferencesEditor.putString(this.prefVoucher, str);
        this.sharedPreferencesEditor.putString(this.prefExternalUserId, str2);
        this.sharedPreferencesEditor.putString(this.prefCampaignName, str3);
        this.sharedPreferencesEditor.apply();
    }
}
