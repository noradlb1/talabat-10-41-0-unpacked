package com.talabat.feature.uladdressform.data.di;

import com.talabat.core.experiment.domain.ExperimentCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.feature.uladdressform.domain.AddressFormFeatureApi;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/feature/uladdressform/data/di/AddressFormFeatureComponent;", "Lcom/talabat/feature/uladdressform/domain/AddressFormFeatureApi;", "Factory", "com_talabat_feature_ul-address-form_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {ExperimentCoreLibApi.class, FeatureFlagCoreLibApi.class}, modules = {AddressFormFeatureModule.class})
public interface AddressFormFeatureComponent extends AddressFormFeatureApi {

    @Component.Factory
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/talabat/feature/uladdressform/data/di/AddressFormFeatureComponent$Factory;", "", "create", "Lcom/talabat/feature/uladdressform/data/di/AddressFormFeatureComponent;", "experimentCoreLibApi", "Lcom/talabat/core/experiment/domain/ExperimentCoreLibApi;", "featureFlagCoreLibApi", "Lcom/talabat/core/featureflag/domain/FeatureFlagCoreLibApi;", "com_talabat_feature_ul-address-form_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        AddressFormFeatureComponent create(@NotNull ExperimentCoreLibApi experimentCoreLibApi, @NotNull FeatureFlagCoreLibApi featureFlagCoreLibApi);
    }
}
