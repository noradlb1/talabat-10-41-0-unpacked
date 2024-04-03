package com.talabat.feature.darkstores.swimlanes.data.di;

import com.talabat.configuration.country.Country;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/darkstores/swimlanes/data/di/SwimlanesUserDataModule;", "", "()V", "provideSleectedCountry", "Lcom/talabat/configuration/country/Country;", "configurationLocalCoreLibApi", "Lcom/talabat/configuration/di/ConfigurationLocalCoreLibApi;", "com_talabat_feature_darkstores-swimlanes_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class SwimlanesUserDataModule {
    @NotNull
    public static final SwimlanesUserDataModule INSTANCE = new SwimlanesUserDataModule();

    private SwimlanesUserDataModule() {
    }

    @NotNull
    @Provides
    @Named("selectedCountry")
    public final Country provideSleectedCountry(@NotNull ConfigurationLocalCoreLibApi configurationLocalCoreLibApi) {
        Intrinsics.checkNotNullParameter(configurationLocalCoreLibApi, "configurationLocalCoreLibApi");
        return configurationLocalCoreLibApi.getRepository().selectedCountry();
    }
}
