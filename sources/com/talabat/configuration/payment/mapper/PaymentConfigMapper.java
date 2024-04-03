package com.talabat.configuration.payment.mapper;

import com.talabat.configuration.country.Country;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.configuration.payment.PaymentConfig;
import com.talabat.configuration.payment.model.VisaCheckoutPublicKeyFwfRemoteConfig;
import com.talabat.configuration.remote.model.AppInfoEntity;
import com.talabat.configuration.remote.model.AppInfoResultEntity;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.fwfprojectskeys.domain.projects.ordering.OrderingRemoteConfigurationsKeys;
import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.core.network.domain.endpoint.EndpointEnvironment;
import com.talabat.mapper.ModelMapper;
import com.talabat.talabatremoteconfiguration.RemoteConfiguration;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00132\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0013B\u001f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0012\u001a\u00020\u000eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/talabat/configuration/payment/mapper/PaymentConfigMapper;", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/configuration/remote/model/AppInfoEntity;", "Lcom/talabat/configuration/payment/PaymentConfig;", "baseUrlFactory", "Lcom/talabat/core/network/domain/endpoint/BaseUrlFactory;", "featureFlags", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "(Lcom/talabat/core/network/domain/endpoint/BaseUrlFactory;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;Lcom/talabat/configuration/location/LocationConfigurationRepository;)V", "apply", "source", "mapCheckoutBaseUrl", "", "mapIsBinCampaignAvailable", "", "mapSelectedCountryForDefaultIsBinCampaignAvailable", "mapVisaCheckoutPublicKey", "Companion", "com_talabat_core_configuration_remote_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PaymentConfigMapper implements ModelMapper<AppInfoEntity, PaymentConfig> {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String PROD_VISA_CHECKOUT_PUBLIC_KEY = "HZR4AG3ZNVGPML9XD29H14_8rPWyH2sk_vSZIJjerZI-C1fO4";
    @NotNull
    private static final String QA_VISA_CHECKOUT_PUBLIC_KEY = "JIR58AFEIRFKCMRHTXH513mod8nlbFSCD9VGY4KfKGcyh-Y0s";
    @NotNull
    private final BaseUrlFactory baseUrlFactory;
    @NotNull
    private final ITalabatFeatureFlag featureFlags;
    @NotNull
    private final LocationConfigurationRepository locationConfigurationRepository;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/talabat/configuration/payment/mapper/PaymentConfigMapper$Companion;", "", "()V", "PROD_VISA_CHECKOUT_PUBLIC_KEY", "", "QA_VISA_CHECKOUT_PUBLIC_KEY", "com_talabat_core_configuration_remote_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[EndpointEnvironment.values().length];
            iArr[EndpointEnvironment.MOCK.ordinal()] = 1;
            iArr[EndpointEnvironment.PRODUCTION.ordinal()] = 2;
            iArr[EndpointEnvironment.QA.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[Country.values().length];
            iArr2[Country.UAE.ordinal()] = 1;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    @Inject
    public PaymentConfigMapper(@NotNull BaseUrlFactory baseUrlFactory2, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull LocationConfigurationRepository locationConfigurationRepository2) {
        Intrinsics.checkNotNullParameter(baseUrlFactory2, "baseUrlFactory");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "featureFlags");
        Intrinsics.checkNotNullParameter(locationConfigurationRepository2, "locationConfigurationRepository");
        this.baseUrlFactory = baseUrlFactory2;
        this.featureFlags = iTalabatFeatureFlag;
        this.locationConfigurationRepository = locationConfigurationRepository2;
    }

    private final String mapCheckoutBaseUrl() {
        if (Intrinsics.areEqual((Object) "release", (Object) "release")) {
            return "https://api.talabat.com/";
        }
        int i11 = WhenMappings.$EnumSwitchMapping$0[this.baseUrlFactory.currentEnvironment().ordinal()];
        if (i11 == 1) {
            return "http://localhost:8000/";
        }
        if (i11 == 2) {
            return "https://api.talabat.com/";
        }
        if (i11 == 3) {
            return "https://qa.talabat.com/";
        }
        throw new NoWhenBranchMatchedException();
    }

    private final boolean mapIsBinCampaignAvailable() {
        return this.featureFlags.getFeatureFlag(OrderingRemoteConfigurationsKeys.PAY_CONFIG_IS_BIN_CAMPAIGN_AVAILABLE, mapSelectedCountryForDefaultIsBinCampaignAvailable());
    }

    private final boolean mapSelectedCountryForDefaultIsBinCampaignAvailable() {
        Country country;
        com.talabat.configuration.location.Country selectedCountry = this.locationConfigurationRepository.selectedCountry();
        if (selectedCountry == null || (country = selectedCountry.getCountry()) == null || WhenMappings.$EnumSwitchMapping$1[country.ordinal()] != 1) {
            return false;
        }
        return true;
    }

    private final String mapVisaCheckoutPublicKey() {
        String visaCheckoutPublicKey;
        VisaCheckoutPublicKeyFwfRemoteConfig visaCheckoutPublicKeyFwfRemoteConfig = (VisaCheckoutPublicKeyFwfRemoteConfig) RemoteConfiguration.INSTANCE.getRemoteConfiguration(OrderingRemoteConfigurationsKeys.PAY_CONFIG_VISA_CHECKOUT_PUBLIC_KEY, new VisaCheckoutPublicKeyFwfRemoteConfig((String) null), VisaCheckoutPublicKeyFwfRemoteConfig.class);
        if (Intrinsics.areEqual((Object) "release", (Object) "release")) {
            visaCheckoutPublicKey = visaCheckoutPublicKeyFwfRemoteConfig.getVisaCheckoutPublicKey();
            if (visaCheckoutPublicKey == null) {
                return PROD_VISA_CHECKOUT_PUBLIC_KEY;
            }
        } else {
            int i11 = WhenMappings.$EnumSwitchMapping$0[this.baseUrlFactory.currentEnvironment().ordinal()];
            if (i11 != 1) {
                if (i11 == 2) {
                    visaCheckoutPublicKey = visaCheckoutPublicKeyFwfRemoteConfig.getVisaCheckoutPublicKey();
                    if (visaCheckoutPublicKey == null) {
                        return PROD_VISA_CHECKOUT_PUBLIC_KEY;
                    }
                } else if (i11 == 3) {
                    String visaCheckoutPublicKey2 = visaCheckoutPublicKeyFwfRemoteConfig.getVisaCheckoutPublicKey();
                    if (visaCheckoutPublicKey2 != null) {
                        return visaCheckoutPublicKey2;
                    }
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
            return QA_VISA_CHECKOUT_PUBLIC_KEY;
        }
        return visaCheckoutPublicKey;
    }

    @NotNull
    public PaymentConfig apply(@NotNull AppInfoEntity appInfoEntity) {
        String str;
        Intrinsics.checkNotNullParameter(appInfoEntity, "source");
        String mapCheckoutBaseUrl = mapCheckoutBaseUrl();
        boolean mapIsBinCampaignAvailable = mapIsBinCampaignAvailable();
        AppInfoResultEntity result = appInfoEntity.getResult();
        if (result == null || (str = result.getPublicKey()) == null) {
            str = PaymentConfig.Companion.getDEFAULT().getPublicKey();
        }
        return new PaymentConfig(mapCheckoutBaseUrl, (String) null, (String) null, mapIsBinCampaignAvailable, str, mapVisaCheckoutPublicKey(), 6, (DefaultConstructorMarker) null);
    }
}
