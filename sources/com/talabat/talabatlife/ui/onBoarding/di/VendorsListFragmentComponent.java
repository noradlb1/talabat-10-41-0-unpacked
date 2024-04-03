package com.talabat.talabatlife.ui.onBoarding.di;

import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.feature.cancellationpolicy.domain.HelpCenterFeatureApi;
import com.talabat.talabatlife.ui.vendorList.VendorsListFragment;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/talabat/talabatlife/ui/onBoarding/di/VendorsListFragmentComponent;", "", "inject", "", "vendorsListFragment", "Lcom/talabat/talabatlife/ui/vendorList/VendorsListFragment;", "Factory", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {ConfigurationLocalCoreLibApi.class, FeatureFlagCoreLibApi.class, DeepLinkCoreLibApi.class, HelpCenterFeatureApi.class})
public interface VendorsListFragmentComponent {

    @Component.Factory
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/talabat/talabatlife/ui/onBoarding/di/VendorsListFragmentComponent$Factory;", "", "create", "Lcom/talabat/talabatlife/ui/onBoarding/di/VendorsListFragmentComponent;", "configurationLocalCoreLibApi", "Lcom/talabat/configuration/di/ConfigurationLocalCoreLibApi;", "featureFlagCoreLibApi", "Lcom/talabat/core/featureflag/domain/FeatureFlagCoreLibApi;", "deepLinkCoreLibApi", "Lcom/talabat/core/deeplink/domain/DeepLinkCoreLibApi;", "helpCenterFeatureApi", "Lcom/talabat/feature/cancellationpolicy/domain/HelpCenterFeatureApi;", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        VendorsListFragmentComponent create(@NotNull ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, @NotNull FeatureFlagCoreLibApi featureFlagCoreLibApi, @NotNull DeepLinkCoreLibApi deepLinkCoreLibApi, @NotNull HelpCenterFeatureApi helpCenterFeatureApi);
    }

    void inject(@NotNull VendorsListFragment vendorsListFragment);
}
