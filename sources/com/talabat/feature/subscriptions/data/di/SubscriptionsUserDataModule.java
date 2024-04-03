package com.talabat.feature.subscriptions.data.di;

import com.integration.IntegrationGlobalDataModel;
import com.talabat.helpers.DateUtils;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/subscriptions/data/di/SubscriptionsUserDataModule;", "", "()V", "provideGlobalDataModel", "Lcom/integration/IntegrationGlobalDataModel$Companion;", "providesDateUtils", "Lcom/talabat/helpers/DateUtils;", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class SubscriptionsUserDataModule {
    @NotNull
    public static final SubscriptionsUserDataModule INSTANCE = new SubscriptionsUserDataModule();

    private SubscriptionsUserDataModule() {
    }

    @NotNull
    @Provides
    public final IntegrationGlobalDataModel.Companion provideGlobalDataModel() {
        return IntegrationGlobalDataModel.Companion;
    }

    @NotNull
    @Provides
    public final DateUtils providesDateUtils() {
        return new DateUtils();
    }
}
