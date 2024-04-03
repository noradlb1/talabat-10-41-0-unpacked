package com.talabat.feature.tmart.growth.data.di;

import android.content.Context;
import com.integration.IntegrationGlobalDataModel;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.country.Country;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.context.domain.ApplicationContext;
import com.talabat.core.ui.di.AndroidComponentsKt;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\bH\u0007J\b\u0010\r\u001a\u00020\u000eH\u0007¨\u0006\u000f"}, d2 = {"Lcom/talabat/feature/tmart/growth/data/di/TMartGrowthUserDataModule;", "", "()V", "provideConfigurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "context", "Landroid/content/Context;", "provideCountry", "Lcom/talabat/configuration/country/Country;", "configurationLocalRepository", "provideCountryCode", "", "country", "provideGlobalDataModel", "Lcom/integration/IntegrationGlobalDataModel$Companion;", "com_talabat_feature_tmartGrowth_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class TMartGrowthUserDataModule {
    @NotNull
    public static final TMartGrowthUserDataModule INSTANCE = new TMartGrowthUserDataModule();

    private TMartGrowthUserDataModule() {
    }

    @NotNull
    @Provides
    public final ConfigurationLocalRepository provideConfigurationLocalRepository(@NotNull @ApplicationContext Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return ((ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer(context).getFeature(ConfigurationLocalCoreLibApi.class)).getRepository();
    }

    @NotNull
    @Provides
    public final Country provideCountry(@NotNull ConfigurationLocalRepository configurationLocalRepository) {
        Intrinsics.checkNotNullParameter(configurationLocalRepository, "configurationLocalRepository");
        return configurationLocalRepository.selectedCountry();
    }

    @NotNull
    @Provides
    @Named("countryCode")
    public final String provideCountryCode(@NotNull Country country) {
        Intrinsics.checkNotNullParameter(country, "country");
        return country.getTwoLetterCode();
    }

    @NotNull
    @Provides
    public final IntegrationGlobalDataModel.Companion provideGlobalDataModel() {
        return IntegrationGlobalDataModel.Companion;
    }
}
