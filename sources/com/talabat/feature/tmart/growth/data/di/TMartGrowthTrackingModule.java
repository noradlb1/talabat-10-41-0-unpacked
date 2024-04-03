package com.talabat.feature.tmart.growth.data.di;

import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tracking.gtm.ITalabatFirebase;
import tracking.gtm.TalabatFirebase;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/talabat/feature/tmart/growth/data/di/TMartGrowthTrackingModule;", "", "()V", "provideFirebaseTracking", "Ltracking/gtm/ITalabatFirebase;", "com_talabat_feature_tmartGrowth_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class TMartGrowthTrackingModule {
    @NotNull
    public static final TMartGrowthTrackingModule INSTANCE = new TMartGrowthTrackingModule();

    private TMartGrowthTrackingModule() {
    }

    @NotNull
    @Provides
    public final ITalabatFirebase provideFirebaseTracking() {
        return new TalabatFirebase();
    }
}
