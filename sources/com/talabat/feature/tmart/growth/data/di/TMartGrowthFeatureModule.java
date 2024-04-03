package com.talabat.feature.tmart.growth.data.di;

import com.talabat.feature.tmart.growth.data.TMartGrowthReminderRepository;
import com.talabat.feature.tmart.growth.data.TMartGrowthRepository;
import com.talabat.feature.tmart.growth.data.files.TMartGrowthFileManager;
import com.talabat.feature.tmart.growth.data.tracking.TMartGrowthTracker;
import com.talabat.feature.tmart.growth.domain.ITMartGrowthReminderRepository;
import com.talabat.feature.tmart.growth.domain.ITMartGrowthRepository;
import com.talabat.feature.tmart.growth.domain.ITMartGrowthTracker;
import com.talabat.feature.tmart.growth.domain.files.ITMartGrowthFileManager;
import dagger.Binds;
import dagger.Module;
import dagger.Reusable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\ba\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\bH'J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u000bH'J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u000eH'¨\u0006\u000f"}, d2 = {"Lcom/talabat/feature/tmart/growth/data/di/TMartGrowthFeatureModule;", "", "fileManager", "Lcom/talabat/feature/tmart/growth/domain/files/ITMartGrowthFileManager;", "impl", "Lcom/talabat/feature/tmart/growth/data/files/TMartGrowthFileManager;", "reminderRepository", "Lcom/talabat/feature/tmart/growth/domain/ITMartGrowthReminderRepository;", "Lcom/talabat/feature/tmart/growth/data/TMartGrowthReminderRepository;", "repository", "Lcom/talabat/feature/tmart/growth/domain/ITMartGrowthRepository;", "Lcom/talabat/feature/tmart/growth/data/TMartGrowthRepository;", "tracker", "Lcom/talabat/feature/tmart/growth/domain/ITMartGrowthTracker;", "Lcom/talabat/feature/tmart/growth/data/tracking/TMartGrowthTracker;", "com_talabat_feature_tmartGrowth_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module(includes = {TMartGrowthCacheModule.class, TMartGrowthExperimentsModule.class, TMartGrowthNetworkModule.class, TMartGrowthTrackingModule.class, TMartGrowthUserDataModule.class})
public interface TMartGrowthFeatureModule {
    @NotNull
    @Binds
    @Reusable
    ITMartGrowthFileManager fileManager(@NotNull TMartGrowthFileManager tMartGrowthFileManager);

    @NotNull
    @Binds
    @Reusable
    ITMartGrowthReminderRepository reminderRepository(@NotNull TMartGrowthReminderRepository tMartGrowthReminderRepository);

    @NotNull
    @Binds
    @Reusable
    ITMartGrowthRepository repository(@NotNull TMartGrowthRepository tMartGrowthRepository);

    @NotNull
    @Binds
    @Reusable
    ITMartGrowthTracker tracker(@NotNull TMartGrowthTracker tMartGrowthTracker);
}
