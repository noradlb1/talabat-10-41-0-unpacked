package com.talabat.configuration;

import com.talabat.configuration.location.Country;
import com.talabat.configuration.location.LocationConfig;
import com.talabat.configuration.location.LocationConfigurationRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/talabat/configuration/MutableLocationConfigurationRepository;", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "setConfig", "", "config", "Lcom/talabat/configuration/location/LocationConfig;", "com_talabat_core_configuration_remote_domain-mutable_domain-mutable"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface MutableLocationConfigurationRepository extends LocationConfigurationRepository {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        @Nullable
        public static Country getCountryById(@NotNull MutableLocationConfigurationRepository mutableLocationConfigurationRepository, int i11) {
            return LocationConfigurationRepository.DefaultImpls.getCountryById(mutableLocationConfigurationRepository, i11);
        }

        public static boolean shouldEnableCountry(@NotNull MutableLocationConfigurationRepository mutableLocationConfigurationRepository, @NotNull com.talabat.configuration.country.Country country) {
            Intrinsics.checkNotNullParameter(country, "country");
            return LocationConfigurationRepository.DefaultImpls.shouldEnableCountry(mutableLocationConfigurationRepository, country);
        }
    }

    void setConfig(@NotNull LocationConfig locationConfig);
}
