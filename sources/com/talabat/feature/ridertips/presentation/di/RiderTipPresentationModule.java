package com.talabat.feature.ridertips.presentation.di;

import android.content.Context;
import android.content.res.Resources;
import com.talabat.configuration.location.Country;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.configuration.location.LocationExtensionsKt;
import com.talabat.feature.ridertips.presentation.IResourceProvider;
import com.talabat.feature.ridertips.presentation.ResourceProviderImpl;
import com.talabat.feature.ridertips.presentation.mapper.IRiderTipDisplayModelMapper;
import com.talabat.feature.ridertips.presentation.mapper.RiderTipDisplayModelMapperImpl;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0012\u0010\u000e\u001a\u00020\r2\b\b\u0001\u0010\u000f\u001a\u00020\u0010H\u0007J.\u0010\u0011\u001a\u00020\u00122\b\b\u0001\u0010\u0013\u001a\u00020\u00042\b\b\u0001\u0010\u0014\u001a\u00020\t2\b\b\u0001\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u000bH\u0007¨\u0006\u0017"}, d2 = {"Lcom/talabat/feature/ridertips/presentation/di/RiderTipPresentationModule;", "", "()V", "provideCurrencySymbol", "", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "provideDecimalPattern", "provideNumOfDecimalPlaces", "", "provideResourceProvider", "Lcom/talabat/feature/ridertips/presentation/IResourceProvider;", "resources", "Landroid/content/res/Resources;", "provideResources", "context", "Landroid/content/Context;", "provideRiderTipDisplayModelMapper", "Lcom/talabat/feature/ridertips/presentation/mapper/IRiderTipDisplayModelMapper;", "currencySymbol", "numOfDecimalPlaces", "decimalPattern", "resourceProvider", "com_talabat_feature_ridertips_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class RiderTipPresentationModule {
    @NotNull
    public static final RiderTipPresentationModule INSTANCE = new RiderTipPresentationModule();

    private RiderTipPresentationModule() {
    }

    @NotNull
    @Provides
    @Named("currencySymbol")
    public final String provideCurrencySymbol(@NotNull LocationConfigurationRepository locationConfigurationRepository) {
        String currencyCode;
        Intrinsics.checkNotNullParameter(locationConfigurationRepository, "locationConfigurationRepository");
        Country selectedCountry = locationConfigurationRepository.selectedCountry();
        if (selectedCountry == null || (currencyCode = selectedCountry.getCurrencyCode()) == null) {
            return "";
        }
        return currencyCode;
    }

    @NotNull
    @Provides
    @Named("decimalPattern")
    public final String provideDecimalPattern(@NotNull LocationConfigurationRepository locationConfigurationRepository) {
        String decimalPattern;
        Intrinsics.checkNotNullParameter(locationConfigurationRepository, "locationConfigurationRepository");
        Country selectedCountry = locationConfigurationRepository.selectedCountry();
        if (selectedCountry == null || (decimalPattern = LocationExtensionsKt.decimalPattern(selectedCountry)) == null) {
            return LocationExtensionsKt.DECIMAL_PATTERN_DEFAULT;
        }
        return decimalPattern;
    }

    @Provides
    @Named("numOfDecimalPlaces")
    public final int provideNumOfDecimalPlaces(@NotNull LocationConfigurationRepository locationConfigurationRepository) {
        Intrinsics.checkNotNullParameter(locationConfigurationRepository, "locationConfigurationRepository");
        Country selectedCountry = locationConfigurationRepository.selectedCountry();
        if (selectedCountry != null) {
            return selectedCountry.getNumberOfDecimalPlaces();
        }
        return 2;
    }

    @NotNull
    @Provides
    public final IResourceProvider provideResourceProvider(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        return new ResourceProviderImpl(resources);
    }

    @NotNull
    @Provides
    public final Resources provideResources(@NotNull @Named("context") Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
        return resources;
    }

    @NotNull
    @Provides
    public final IRiderTipDisplayModelMapper provideRiderTipDisplayModelMapper(@NotNull @Named("currencySymbol") String str, @Named("numOfDecimalPlaces") int i11, @NotNull @Named("decimalPattern") String str2, @NotNull IResourceProvider iResourceProvider) {
        Intrinsics.checkNotNullParameter(str, "currencySymbol");
        Intrinsics.checkNotNullParameter(str2, "decimalPattern");
        Intrinsics.checkNotNullParameter(iResourceProvider, "resourceProvider");
        return new RiderTipDisplayModelMapperImpl(str, i11, str2, iResourceProvider);
    }
}
