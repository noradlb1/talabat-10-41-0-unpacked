package com.talabat.talabatlife.ui.onBoarding.di;

import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.talabatlife.ui.onBoarding.TLifeOnBoardingFragment;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/talabat/talabatlife/ui/onBoarding/di/TLifeOnBoardingFragmentComponent;", "", "inject", "", "tLifeOnBoardingFragment", "Lcom/talabat/talabatlife/ui/onBoarding/TLifeOnBoardingFragment;", "Factory", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {ConfigurationLocalCoreLibApi.class, FeatureFlagCoreLibApi.class})
public interface TLifeOnBoardingFragmentComponent {

    @Component.Factory
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/talabat/talabatlife/ui/onBoarding/di/TLifeOnBoardingFragmentComponent$Factory;", "", "create", "Lcom/talabat/talabatlife/ui/onBoarding/di/TLifeOnBoardingFragmentComponent;", "configurationLocalCoreLibApi", "Lcom/talabat/configuration/di/ConfigurationLocalCoreLibApi;", "featureFlagCoreLibApi", "Lcom/talabat/core/featureflag/domain/FeatureFlagCoreLibApi;", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        TLifeOnBoardingFragmentComponent create(@NotNull ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, @NotNull FeatureFlagCoreLibApi featureFlagCoreLibApi);
    }

    void inject(@NotNull TLifeOnBoardingFragment tLifeOnBoardingFragment);
}
