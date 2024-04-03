package com.talabat.feature.darkstorescarrierbag.presentation.di;

import androidx.lifecycle.ViewModel;
import com.talabat.feature.darkstorescarrierbag.presentation.DarkstoresCarrierBagViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'¨\u0006\u0006"}, d2 = {"Lcom/talabat/feature/darkstorescarrierbag/presentation/di/DarkstoresCarrierBagPresentationModule;", "", "providesDarkstoresCarrierBagViewModel", "Landroidx/lifecycle/ViewModel;", "viewModel", "Lcom/talabat/feature/darkstorescarrierbag/presentation/DarkstoresCarrierBagViewModel;", "com_talabat_feature_darkstores-carrier-bag_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public interface DarkstoresCarrierBagPresentationModule {
    @Binds
    @IntoMap
    @NotNull
    @ViewModelKey(DarkstoresCarrierBagViewModel.class)
    ViewModel providesDarkstoresCarrierBagViewModel(@NotNull DarkstoresCarrierBagViewModel darkstoresCarrierBagViewModel);
}
