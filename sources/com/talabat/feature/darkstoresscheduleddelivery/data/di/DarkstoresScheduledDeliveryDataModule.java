package com.talabat.feature.darkstoresscheduleddelivery.data.di;

import com.talabat.feature.darkstoresscheduleddelivery.data.repository.DarkstoresScheduledDeliveryRepositoryImpl;
import com.talabat.feature.darkstoresscheduleddelivery.domain.repository.DarkstoresScheduledDeliveryRepository;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/darkstoresscheduleddelivery/data/di/DarkstoresScheduledDeliveryDataModule;", "", "()V", "provideDarkstoresScheduledDeliveryRepository", "Lcom/talabat/feature/darkstoresscheduleddelivery/domain/repository/DarkstoresScheduledDeliveryRepository;", "darkstoresScheduledDeliveryRepository", "Lcom/talabat/feature/darkstoresscheduleddelivery/data/repository/DarkstoresScheduledDeliveryRepositoryImpl;", "com_talabat_feature_darkstores-scheduled-delivery_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class DarkstoresScheduledDeliveryDataModule {
    @NotNull
    @Reusable
    @Provides
    public final DarkstoresScheduledDeliveryRepository provideDarkstoresScheduledDeliveryRepository(@NotNull DarkstoresScheduledDeliveryRepositoryImpl darkstoresScheduledDeliveryRepositoryImpl) {
        Intrinsics.checkNotNullParameter(darkstoresScheduledDeliveryRepositoryImpl, "darkstoresScheduledDeliveryRepository");
        return darkstoresScheduledDeliveryRepositoryImpl;
    }
}
