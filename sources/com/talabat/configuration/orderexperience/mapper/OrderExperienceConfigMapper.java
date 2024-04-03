package com.talabat.configuration.orderexperience.mapper;

import com.talabat.configuration.country.Country;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.configuration.orderexperience.OrderExperienceConfig;
import com.talabat.configuration.remote.model.AppInfoEntity;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.fwfprojectskeys.domain.projects.ordering.OrderingRemoteConfigurationsKeys;
import com.talabat.mapper.ModelMapper;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/talabat/configuration/orderexperience/mapper/OrderExperienceConfigMapper;", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/configuration/remote/model/AppInfoEntity;", "Lcom/talabat/configuration/orderexperience/OrderExperienceConfig;", "featureFlags", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;Lcom/talabat/configuration/location/LocationConfigurationRepository;)V", "apply", "source", "defaultMapIsGoGreen", "", "mapIsGoGreen", "com_talabat_core_configuration_remote_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderExperienceConfigMapper implements ModelMapper<AppInfoEntity, OrderExperienceConfig> {
    @NotNull
    private final ITalabatFeatureFlag featureFlags;
    @NotNull
    private final LocationConfigurationRepository locationConfigurationRepository;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Country.values().length];
            iArr[Country.LEBANON.ordinal()] = 1;
            iArr[Country.IRAQ.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Inject
    public OrderExperienceConfigMapper(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull LocationConfigurationRepository locationConfigurationRepository2) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "featureFlags");
        Intrinsics.checkNotNullParameter(locationConfigurationRepository2, "locationConfigurationRepository");
        this.featureFlags = iTalabatFeatureFlag;
        this.locationConfigurationRepository = locationConfigurationRepository2;
    }

    private final boolean defaultMapIsGoGreen() {
        Country country;
        com.talabat.configuration.location.Country selectedCountry = this.locationConfigurationRepository.selectedCountry();
        if (selectedCountry == null || (country = selectedCountry.getCountry()) == null) {
            return true;
        }
        int i11 = WhenMappings.$EnumSwitchMapping$0[country.ordinal()];
        if (i11 == 1 || i11 == 2) {
            return false;
        }
        return true;
    }

    private final boolean mapIsGoGreen() {
        return this.featureFlags.getFeatureFlag(OrderingRemoteConfigurationsKeys.ORDER_EXPERIENCE_CONFIG_IS_GO_GREEN, defaultMapIsGoGreen());
    }

    @NotNull
    public OrderExperienceConfig apply(@NotNull AppInfoEntity appInfoEntity) {
        Intrinsics.checkNotNullParameter(appInfoEntity, "source");
        return new OrderExperienceConfig(mapIsGoGreen());
    }
}
