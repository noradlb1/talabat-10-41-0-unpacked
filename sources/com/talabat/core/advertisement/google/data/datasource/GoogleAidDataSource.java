package com.talabat.core.advertisement.google.data.datasource;

import android.content.Context;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Lcom/talabat/core/advertisement/google/data/datasource/GoogleAidDataSource;", "", "fetchCachedGoogleAid", "", "context", "Landroid/content/Context;", "fetchGoogleAidAndSave", "", "com_talabat_core_advertisement_google_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface GoogleAidDataSource {
    @NotNull
    String fetchCachedGoogleAid(@NotNull Context context);

    void fetchGoogleAidAndSave(@NotNull Context context);
}
