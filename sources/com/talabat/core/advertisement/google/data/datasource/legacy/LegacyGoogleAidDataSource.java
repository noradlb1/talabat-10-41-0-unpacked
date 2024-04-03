package com.talabat.core.advertisement.google.data.datasource.legacy;

import android.content.Context;
import com.talabat.core.advertisement.google.data.datasource.GoogleAidDataSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tracking.GoogleAdvertisingIdClientHelper;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\t"}, d2 = {"Lcom/talabat/core/advertisement/google/data/datasource/legacy/LegacyGoogleAidDataSource;", "Lcom/talabat/core/advertisement/google/data/datasource/GoogleAidDataSource;", "()V", "fetchCachedGoogleAid", "", "context", "Landroid/content/Context;", "fetchGoogleAidAndSave", "", "com_talabat_core_advertisement_google_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LegacyGoogleAidDataSource implements GoogleAidDataSource {
    @NotNull
    public String fetchCachedGoogleAid(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String googleAdvertId = GoogleAdvertisingIdClientHelper.getInstance().googleAdvertId(context);
        Intrinsics.checkNotNullExpressionValue(googleAdvertId, "getInstance().googleAdvertId(context)");
        return googleAdvertId;
    }

    public void fetchGoogleAidAndSave(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        GoogleAdvertisingIdClientHelper.getInstance().getAdvertisingId(context);
    }
}
