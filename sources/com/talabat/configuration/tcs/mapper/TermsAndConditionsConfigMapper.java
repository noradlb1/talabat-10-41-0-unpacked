package com.talabat.configuration.tcs.mapper;

import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.configuration.remote.model.AppInfoEntity;
import com.talabat.configuration.remote.model.AppInfoResultEntity;
import com.talabat.configuration.tcs.TermsAndConditionsConfig;
import com.talabat.configuration.tcs.model.TermsAndConditionsFwfRemoteConfig;
import com.talabat.core.fwfprojectskeys.domain.projects.home.HomePageRemoteConfigurationsKeys;
import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.core.network.domain.endpoint.EndpointEnvironment;
import com.talabat.mapper.ModelMapper;
import com.talabat.talabatremoteconfiguration.RemoteConfiguration;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/talabat/configuration/tcs/mapper/TermsAndConditionsConfigMapper;", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/configuration/remote/model/AppInfoEntity;", "Lcom/talabat/configuration/tcs/TermsAndConditionsConfig;", "baseUrlFactory", "Lcom/talabat/core/network/domain/endpoint/BaseUrlFactory;", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "(Lcom/talabat/core/network/domain/endpoint/BaseUrlFactory;Lcom/talabat/configuration/location/LocationConfigurationRepository;)V", "apply", "source", "getRemoteConfiguration", "Lcom/talabat/configuration/tcs/model/TermsAndConditionsFwfRemoteConfig;", "mapCheckoutBaseUrl", "", "selectedCountryShortName", "com_talabat_core_configuration_remote_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TermsAndConditionsConfigMapper implements ModelMapper<AppInfoEntity, TermsAndConditionsConfig> {
    @NotNull
    private final BaseUrlFactory baseUrlFactory;
    @NotNull
    private final LocationConfigurationRepository locationConfigurationRepository;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EndpointEnvironment.values().length];
            iArr[EndpointEnvironment.MOCK.ordinal()] = 1;
            iArr[EndpointEnvironment.PRODUCTION.ordinal()] = 2;
            iArr[EndpointEnvironment.QA.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Inject
    public TermsAndConditionsConfigMapper(@NotNull BaseUrlFactory baseUrlFactory2, @NotNull LocationConfigurationRepository locationConfigurationRepository2) {
        Intrinsics.checkNotNullParameter(baseUrlFactory2, "baseUrlFactory");
        Intrinsics.checkNotNullParameter(locationConfigurationRepository2, "locationConfigurationRepository");
        this.baseUrlFactory = baseUrlFactory2;
        this.locationConfigurationRepository = locationConfigurationRepository2;
    }

    private final TermsAndConditionsFwfRemoteConfig getRemoteConfiguration() {
        return (TermsAndConditionsFwfRemoteConfig) RemoteConfiguration.INSTANCE.getRemoteConfiguration(HomePageRemoteConfigurationsKeys.TCS_CONFIG_TERMS_AND_CONDITIONS_URL, new TermsAndConditionsFwfRemoteConfig((String) null), TermsAndConditionsFwfRemoteConfig.class);
    }

    private final String mapCheckoutBaseUrl() {
        if (Intrinsics.areEqual((Object) "release", (Object) "release")) {
            return "https://talabat.com/";
        }
        int i11 = WhenMappings.$EnumSwitchMapping$0[this.baseUrlFactory.currentEnvironment().ordinal()];
        if (i11 == 1) {
            return "http://localhost:8000/";
        }
        if (i11 == 2) {
            return "https://talabat.com/";
        }
        if (i11 == 3) {
            return "https://qa.talabat.com/";
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = r0.getCountry();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String selectedCountryShortName() {
        /*
            r1 = this;
            com.talabat.configuration.location.LocationConfigurationRepository r0 = r1.locationConfigurationRepository
            com.talabat.configuration.location.Country r0 = r0.selectedCountry()
            if (r0 == 0) goto L_0x0013
            com.talabat.configuration.country.Country r0 = r0.getCountry()
            if (r0 == 0) goto L_0x0013
            java.lang.String r0 = r0.getShortCountryName()
            goto L_0x0014
        L_0x0013:
            r0 = 0
        L_0x0014:
            if (r0 != 0) goto L_0x0018
            java.lang.String r0 = ""
        L_0x0018:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.configuration.tcs.mapper.TermsAndConditionsConfigMapper.selectedCountryShortName():java.lang.String");
    }

    @NotNull
    public TermsAndConditionsConfig apply(@NotNull AppInfoEntity appInfoEntity) {
        String str;
        Intrinsics.checkNotNullParameter(appInfoEntity, "source");
        AppInfoResultEntity result = appInfoEntity.getResult();
        if ((result == null || (str = result.getUrl()) == null) && (str = getRemoteConfiguration().getTermsAndConditionsUrl()) == null) {
            str = mapCheckoutBaseUrl() + "/" + selectedCountryShortName();
        }
        return new TermsAndConditionsConfig(str);
    }
}
