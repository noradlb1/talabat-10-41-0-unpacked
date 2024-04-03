package com.talabat.feature.tmart.growth.domain;

import com.talabat.core.di.Api;
import com.talabat.feature.tmart.growth.domain.files.ITMartGrowthFileManager;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/talabat/feature/tmart/growth/domain/TMartGrowthFeatureApi;", "Lcom/talabat/core/di/Api;", "fileManager", "Lcom/talabat/feature/tmart/growth/domain/files/ITMartGrowthFileManager;", "getFileManager", "()Lcom/talabat/feature/tmart/growth/domain/files/ITMartGrowthFileManager;", "reminderRepository", "Lcom/talabat/feature/tmart/growth/domain/ITMartGrowthReminderRepository;", "getReminderRepository", "()Lcom/talabat/feature/tmart/growth/domain/ITMartGrowthReminderRepository;", "repository", "Lcom/talabat/feature/tmart/growth/domain/ITMartGrowthRepository;", "getRepository", "()Lcom/talabat/feature/tmart/growth/domain/ITMartGrowthRepository;", "tracker", "Lcom/talabat/feature/tmart/growth/domain/ITMartGrowthTracker;", "getTracker", "()Lcom/talabat/feature/tmart/growth/domain/ITMartGrowthTracker;", "com_talabat_feature_tmartGrowth_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface TMartGrowthFeatureApi extends Api {
    @NotNull
    ITMartGrowthFileManager getFileManager();

    @NotNull
    ITMartGrowthReminderRepository getReminderRepository();

    @NotNull
    ITMartGrowthRepository getRepository();

    @NotNull
    ITMartGrowthTracker getTracker();
}
