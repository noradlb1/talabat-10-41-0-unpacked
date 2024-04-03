package com.talabat.feature.darkstorescarrierbag.presentation.di;

import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.experiment.domain.ExperimentCoreLibApi;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.core.ui.di.ViewModelFactoryModule;
import com.talabat.feature.darkstorescarrierbag.domain.di.DarkstoresCarrierBagApi;
import com.talabat.feature.darkstorescarrierbag.presentation.DarkstoresCarrierBagManager;
import dagger.BindsInstance;
import dagger.Component;
import javax.inject.Named;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/darkstorescarrierbag/presentation/di/DarkstoresCarrierBagComponent;", "Lcom/talabat/feature/darkstorescarrierbag/domain/di/DarkstoresCarrierBagApi;", "inject", "", "darkstoresCarrierBagManager", "Lcom/talabat/feature/darkstorescarrierbag/presentation/DarkstoresCarrierBagManager;", "Factory", "com_talabat_feature_darkstores-carrier-bag_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {ContextCoreLibApi.class, DispatcherCoreLibApi.class, ExperimentCoreLibApi.class, TrackingCoreLibApi.class}, modules = {DarkstoresTooltipDataModule.class, DarkstoresCarrierBagPresentationModule.class, DarkstoresCarrierBagUseCaseModule.class, ViewModelFactoryModule.class})
public interface DarkstoresCarrierBagComponent extends DarkstoresCarrierBagApi {

    @Component.Factory
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&¨\u0006\u000e"}, d2 = {"Lcom/talabat/feature/darkstorescarrierbag/presentation/di/DarkstoresCarrierBagComponent$Factory;", "", "create", "Lcom/talabat/feature/darkstorescarrierbag/presentation/di/DarkstoresCarrierBagComponent;", "vendorCode", "", "contextCoreLibApi", "Lcom/talabat/core/context/domain/ContextCoreLibApi;", "dispatcherCoreLibApi", "Lcom/talabat/core/dispatcher/domain/DispatcherCoreLibApi;", "experimentCoreLibApi", "Lcom/talabat/core/experiment/domain/ExperimentCoreLibApi;", "trackingCoreLibApi", "Lcom/talabat/core/tracking/domain/TrackingCoreLibApi;", "com_talabat_feature_darkstores-carrier-bag_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        DarkstoresCarrierBagComponent create(@NotNull @BindsInstance @Named("vendor_code") String str, @NotNull ContextCoreLibApi contextCoreLibApi, @NotNull DispatcherCoreLibApi dispatcherCoreLibApi, @NotNull ExperimentCoreLibApi experimentCoreLibApi, @NotNull TrackingCoreLibApi trackingCoreLibApi);
    }

    void inject(@NotNull DarkstoresCarrierBagManager darkstoresCarrierBagManager);
}
