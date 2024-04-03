package com.talabat.core.advertisement.google.data;

import android.content.Context;
import com.talabat.core.advertisement.google.data.datasource.GoogleAidDataSource;
import com.talabat.core.advertisement.google.domain.GoogleAdvertisementRepository;
import com.talabat.core.context.domain.ApplicationContext;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/talabat/core/advertisement/google/data/AdMobRepository;", "Lcom/talabat/core/advertisement/google/domain/GoogleAdvertisementRepository;", "context", "Landroid/content/Context;", "googleAidDataSource", "Lcom/talabat/core/advertisement/google/data/datasource/GoogleAidDataSource;", "(Landroid/content/Context;Lcom/talabat/core/advertisement/google/data/datasource/GoogleAidDataSource;)V", "fetchCachedGoogleAdvertisementId", "", "fetchGoogleAdvertisementIdAndSave", "", "com_talabat_core_advertisement_google_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AdMobRepository implements GoogleAdvertisementRepository {
    @NotNull
    private final Context context;
    @NotNull
    private final GoogleAidDataSource googleAidDataSource;

    @Inject
    public AdMobRepository(@NotNull @ApplicationContext Context context2, @NotNull GoogleAidDataSource googleAidDataSource2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(googleAidDataSource2, "googleAidDataSource");
        this.context = context2;
        this.googleAidDataSource = googleAidDataSource2;
    }

    @NotNull
    public String fetchCachedGoogleAdvertisementId() {
        return this.googleAidDataSource.fetchCachedGoogleAid(this.context);
    }

    public void fetchGoogleAdvertisementIdAndSave() {
        this.googleAidDataSource.fetchGoogleAidAndSave(this.context);
    }
}
