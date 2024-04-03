package com.talabat.wallet.checkoutpaymentmanager.di.module;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.di.ApiContainer;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\t"}, d2 = {"Lcom/talabat/wallet/checkoutpaymentmanager/di/module/DomainModule;", "", "()V", "provideFeatureFlagRepository", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "apiContainer", "Lcom/talabat/core/di/ApiContainer;", "provideSelectedCountryRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DomainModule {
    @NotNull
    public static final DomainModule INSTANCE = new DomainModule();

    private DomainModule() {
    }

    @NotNull
    public final ITalabatFeatureFlag provideFeatureFlagRepository(@NotNull ApiContainer apiContainer) {
        Intrinsics.checkNotNullParameter(apiContainer, "apiContainer");
        return ((FeatureFlagCoreLibApi) apiContainer.getFeature(FeatureFlagCoreLibApi.class)).getTalabatFeatureFlag();
    }

    @NotNull
    public final ConfigurationLocalRepository provideSelectedCountryRepository(@NotNull ApiContainer apiContainer) {
        Intrinsics.checkNotNullParameter(apiContainer, "apiContainer");
        return ((ConfigurationLocalCoreLibApi) apiContainer.getFeature(ConfigurationLocalCoreLibApi.class)).getRepository();
    }
}
