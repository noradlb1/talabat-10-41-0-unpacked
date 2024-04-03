package com.talabat.feature.ulaccountinfo.data.di;

import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.feature.ulaccountinfo.domain.AccountInfoFeatureApi;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/feature/ulaccountinfo/data/di/AccountInfoFeatureComponent;", "Lcom/talabat/feature/ulaccountinfo/domain/AccountInfoFeatureApi;", "Factory", "com_talabat_feature_ul-account-info_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {FeatureFlagCoreLibApi.class}, modules = {AccountInfoFeatureModule.class})
public interface AccountInfoFeatureComponent extends AccountInfoFeatureApi {

    @Component.Factory
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/talabat/feature/ulaccountinfo/data/di/AccountInfoFeatureComponent$Factory;", "", "create", "Lcom/talabat/feature/ulaccountinfo/data/di/AccountInfoFeatureComponent;", "featureFlagCoreLibApi", "Lcom/talabat/core/featureflag/domain/FeatureFlagCoreLibApi;", "com_talabat_feature_ul-account-info_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        AccountInfoFeatureComponent create(@NotNull FeatureFlagCoreLibApi featureFlagCoreLibApi);
    }
}
