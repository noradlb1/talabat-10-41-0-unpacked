package com.talabat.feature.darkstorestooltip.presentation.di;

import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.ui.di.ViewModelFactoryModule;
import com.talabat.feature.darkstorestooltip.domain.di.DarkstoresTooltipApi;
import com.talabat.feature.darkstorestooltip.presentation.TooltipView;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/darkstorestooltip/presentation/di/DarkstoresTooltipComponent;", "Lcom/talabat/feature/darkstorestooltip/domain/di/DarkstoresTooltipApi;", "inject", "", "tooltipView", "Lcom/talabat/feature/darkstorestooltip/presentation/TooltipView;", "Factory", "com_talabat_feature_darkstores-tooltip_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {ContextCoreLibApi.class, DispatcherCoreLibApi.class}, modules = {DarkstoresTooltipDataModule.class, DarkstoresTooltipUseCaseModule.class, ViewModelFactoryModule.class})
public interface DarkstoresTooltipComponent extends DarkstoresTooltipApi {

    @Component.Factory
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/talabat/feature/darkstorestooltip/presentation/di/DarkstoresTooltipComponent$Factory;", "", "create", "Lcom/talabat/feature/darkstorestooltip/presentation/di/DarkstoresTooltipComponent;", "contextCoreLibApi", "Lcom/talabat/core/context/domain/ContextCoreLibApi;", "dispatcherCoreLibApi", "Lcom/talabat/core/dispatcher/domain/DispatcherCoreLibApi;", "com_talabat_feature_darkstores-tooltip_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        DarkstoresTooltipComponent create(@NotNull ContextCoreLibApi contextCoreLibApi, @NotNull DispatcherCoreLibApi dispatcherCoreLibApi);
    }

    void inject(@NotNull TooltipView tooltipView);
}
