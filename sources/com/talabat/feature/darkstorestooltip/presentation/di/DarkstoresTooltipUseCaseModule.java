package com.talabat.feature.darkstorestooltip.presentation.di;

import com.talabat.feature.darkstorestooltip.domain.usecase.SetTooltipShown;
import com.talabat.feature.darkstorestooltip.domain.usecase.SetTooltipShownImpl;
import com.talabat.feature.darkstorestooltip.domain.usecase.WasTooltipAlreadyShown;
import com.talabat.feature.darkstorestooltip.domain.usecase.WasTooltipAlreadyShownImpl;
import dagger.Binds;
import dagger.Module;
import dagger.Reusable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\bH'¨\u0006\t"}, d2 = {"Lcom/talabat/feature/darkstorestooltip/presentation/di/DarkstoresTooltipUseCaseModule;", "", "bindIsTooltipShown", "Lcom/talabat/feature/darkstorestooltip/domain/usecase/WasTooltipAlreadyShown;", "impl", "Lcom/talabat/feature/darkstorestooltip/domain/usecase/WasTooltipAlreadyShownImpl;", "bindSetTooltipShown", "Lcom/talabat/feature/darkstorestooltip/domain/usecase/SetTooltipShown;", "Lcom/talabat/feature/darkstorestooltip/domain/usecase/SetTooltipShownImpl;", "com_talabat_feature_darkstores-tooltip_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public interface DarkstoresTooltipUseCaseModule {
    @NotNull
    @Binds
    @Reusable
    WasTooltipAlreadyShown bindIsTooltipShown(@NotNull WasTooltipAlreadyShownImpl wasTooltipAlreadyShownImpl);

    @NotNull
    @Binds
    @Reusable
    SetTooltipShown bindSetTooltipShown(@NotNull SetTooltipShownImpl setTooltipShownImpl);
}
