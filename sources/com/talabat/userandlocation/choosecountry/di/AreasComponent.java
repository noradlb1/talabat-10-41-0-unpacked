package com.talabat.userandlocation.choosecountry.di;

import com.talabat.configuration.di.MutableConfigurationRemoteCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.userandlocation.choosecountry.di.module.AreasModule;
import com.talabat.userandlocation.choosecountry.domain.usecase.business.RequestAreasToCacheUseCase;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0006R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/talabat/userandlocation/choosecountry/di/AreasComponent;", "", "requestAreasToCacheUseCase", "Lcom/talabat/userandlocation/choosecountry/domain/usecase/business/RequestAreasToCacheUseCase;", "getRequestAreasToCacheUseCase", "()Lcom/talabat/userandlocation/choosecountry/domain/usecase/business/RequestAreasToCacheUseCase;", "Factory", "com_talabat_NewArchi_UserAndLocation_ChooseCountry_ChooseCountry"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {FeatureFlagCoreLibApi.class, MutableConfigurationRemoteCoreLibApi.class}, modules = {AreasModule.class})
public interface AreasComponent {

    @Component.Factory
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/talabat/userandlocation/choosecountry/di/AreasComponent$Factory;", "", "create", "Lcom/talabat/userandlocation/choosecountry/di/AreasComponent;", "featureFlagCoreLibApi", "Lcom/talabat/core/featureflag/domain/FeatureFlagCoreLibApi;", "mutableConfigurationRemoteCoreLibApi", "Lcom/talabat/configuration/di/MutableConfigurationRemoteCoreLibApi;", "com_talabat_NewArchi_UserAndLocation_ChooseCountry_ChooseCountry"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        AreasComponent create(@NotNull FeatureFlagCoreLibApi featureFlagCoreLibApi, @NotNull MutableConfigurationRemoteCoreLibApi mutableConfigurationRemoteCoreLibApi);
    }

    @NotNull
    RequestAreasToCacheUseCase getRequestAreasToCacheUseCase();
}
