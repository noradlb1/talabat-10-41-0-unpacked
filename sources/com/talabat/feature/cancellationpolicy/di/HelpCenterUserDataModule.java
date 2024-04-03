package com.talabat.feature.cancellationpolicy.di;

import buisnessmodels.Cart;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import dagger.Module;
import dagger.Provides;
import datamodels.Restaurant;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\b\u0010\n\u001a\u00020\u0007H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/talabat/feature/cancellationpolicy/di/HelpCenterUserDataModule;", "", "()V", "COUNTRY_ID", "", "VERTICAL_TYPE", "provideCountryId", "", "configurationLocalCoreLibApi", "Lcom/talabat/configuration/di/ConfigurationLocalCoreLibApi;", "provideVerticalType", "com_talabat_feature_helpcenter_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class HelpCenterUserDataModule {
    @NotNull
    public static final String COUNTRY_ID = "countryId";
    @NotNull
    public static final HelpCenterUserDataModule INSTANCE = new HelpCenterUserDataModule();
    @NotNull
    public static final String VERTICAL_TYPE = "verticalType";

    private HelpCenterUserDataModule() {
    }

    @Provides
    @Named("countryId")
    public final int provideCountryId(@NotNull ConfigurationLocalCoreLibApi configurationLocalCoreLibApi) {
        Intrinsics.checkNotNullParameter(configurationLocalCoreLibApi, "configurationLocalCoreLibApi");
        return configurationLocalCoreLibApi.getRepository().selectedCountry().getCountryId();
    }

    @Provides
    @Named("verticalType")
    public final int provideVerticalType() {
        Restaurant restaurant = Cart.getInstance().getRestaurant();
        if (restaurant != null) {
            return restaurant.shopType;
        }
        return 0;
    }
}
