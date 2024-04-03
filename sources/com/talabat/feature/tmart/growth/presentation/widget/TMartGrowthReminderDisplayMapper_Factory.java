package com.talabat.feature.tmart.growth.presentation.widget;

import com.talabat.feature.tmart.growth.domain.files.ITMartGrowthFileManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class TMartGrowthReminderDisplayMapper_Factory implements Factory<TMartGrowthReminderDisplayMapper> {
    private final Provider<ITMartGrowthFileManager> imageFileManagerProvider;

    public TMartGrowthReminderDisplayMapper_Factory(Provider<ITMartGrowthFileManager> provider) {
        this.imageFileManagerProvider = provider;
    }

    public static TMartGrowthReminderDisplayMapper_Factory create(Provider<ITMartGrowthFileManager> provider) {
        return new TMartGrowthReminderDisplayMapper_Factory(provider);
    }

    public static TMartGrowthReminderDisplayMapper newInstance(ITMartGrowthFileManager iTMartGrowthFileManager) {
        return new TMartGrowthReminderDisplayMapper(iTMartGrowthFileManager);
    }

    public TMartGrowthReminderDisplayMapper get() {
        return newInstance(this.imageFileManagerProvider.get());
    }
}
