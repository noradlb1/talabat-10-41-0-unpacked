package com.talabat.core.advertisement.google.data.di;

import com.talabat.core.advertisement.google.data.AdMobRepository;
import com.talabat.core.advertisement.google.data.datasource.GoogleAidDataSource;
import com.talabat.core.advertisement.google.data.datasource.legacy.LegacyGoogleAidDataSource;
import com.talabat.core.advertisement.google.domain.GoogleAdvertisementRepository;
import dagger.Binds;
import dagger.Module;
import dagger.Reusable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\bH'¨\u0006\t"}, d2 = {"Lcom/talabat/core/advertisement/google/data/di/GoogleAdvertisementModule;", "", "adMobRepository", "Lcom/talabat/core/advertisement/google/domain/GoogleAdvertisementRepository;", "real", "Lcom/talabat/core/advertisement/google/data/AdMobRepository;", "legacyDataSource", "Lcom/talabat/core/advertisement/google/data/datasource/GoogleAidDataSource;", "Lcom/talabat/core/advertisement/google/data/datasource/legacy/LegacyGoogleAidDataSource;", "com_talabat_core_advertisement_google_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public interface GoogleAdvertisementModule {
    @NotNull
    @Binds
    @Reusable
    GoogleAdvertisementRepository adMobRepository(@NotNull AdMobRepository adMobRepository);

    @NotNull
    @Binds
    @Reusable
    GoogleAidDataSource legacyDataSource(@NotNull LegacyGoogleAidDataSource legacyGoogleAidDataSource);
}
