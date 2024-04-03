package com.talabat.feature.tmart.growth.presentation.di;

import com.talabat.core.ui.di.ViewModelFactoryModule;
import com.talabat.feature.tmart.growth.domain.TMartGrowthFeatureApi;
import com.talabat.feature.tmart.growth.presentation.sheet.TMartGrowthBottomSheet;
import com.talabat.feature.tmart.growth.presentation.widget.TMartGrowthWidgetView;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\ba\u0018\u00002\u00020\u0001:\u0001\u0007J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0006H&¨\u0006\b"}, d2 = {"Lcom/talabat/feature/tmart/growth/presentation/di/TMartGrowthViewComponent;", "", "inject", "", "target", "Lcom/talabat/feature/tmart/growth/presentation/sheet/TMartGrowthBottomSheet;", "Lcom/talabat/feature/tmart/growth/presentation/widget/TMartGrowthWidgetView;", "Factory", "com_talabat_feature_tmartGrowth_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {TMartGrowthFeatureApi.class}, modules = {ViewModelFactoryModule.class, TMartGrowthViewModelsModule.class})
public interface TMartGrowthViewComponent {

    @Component.Factory
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/talabat/feature/tmart/growth/presentation/di/TMartGrowthViewComponent$Factory;", "", "create", "Lcom/talabat/feature/tmart/growth/presentation/di/TMartGrowthViewComponent;", "featureApi", "Lcom/talabat/feature/tmart/growth/domain/TMartGrowthFeatureApi;", "com_talabat_feature_tmartGrowth_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        TMartGrowthViewComponent create(@NotNull TMartGrowthFeatureApi tMartGrowthFeatureApi);
    }

    void inject(@NotNull TMartGrowthBottomSheet tMartGrowthBottomSheet);

    void inject(@NotNull TMartGrowthWidgetView tMartGrowthWidgetView);
}
