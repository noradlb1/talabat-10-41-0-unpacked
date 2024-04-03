package com.talabat.feature.ridertips.data.di;

import buisnessmodels.Cart;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.feature.ridertips.data.observability.RiderTipObservability;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\t\u001a\u00020\u0004H\u0007¨\u0006\n"}, d2 = {"Lcom/talabat/feature/ridertips/data/di/RiderTipUserDataModule;", "", "()V", "provideCountryId", "", "configurationLocalCoreLibApi", "Lcom/talabat/configuration/di/ConfigurationLocalCoreLibApi;", "provideRiderTipObservability", "Lcom/talabat/feature/ridertips/data/observability/RiderTipObservability;", "provideShopId", "com_talabat_feature_ridertips_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class RiderTipUserDataModule {
    @NotNull
    public static final RiderTipUserDataModule INSTANCE = new RiderTipUserDataModule();

    private RiderTipUserDataModule() {
    }

    @Provides
    @Named("countryId")
    public final int provideCountryId(@NotNull ConfigurationLocalCoreLibApi configurationLocalCoreLibApi) {
        Intrinsics.checkNotNullParameter(configurationLocalCoreLibApi, "configurationLocalCoreLibApi");
        return configurationLocalCoreLibApi.getRepository().selectedCountry().getCountryId();
    }

    @NotNull
    @Provides
    public final RiderTipObservability provideRiderTipObservability() {
        return new RiderTipObservability();
    }

    @Provides
    @Named("shopId")
    public final int provideShopId() {
        return Cart.getInstance().getRestaurant().f13872id;
    }
}
