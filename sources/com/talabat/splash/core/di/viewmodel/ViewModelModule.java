package com.talabat.splash.core.di.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.talabat.splash.presentation.ui.SplashActivitySharedViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H'J\u0015\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH!¢\u0006\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/talabat/splash/core/di/viewmodel/ViewModelModule;", "", "()V", "bindSplashActivityViewModel", "Landroidx/lifecycle/ViewModel;", "splashActivityViewModel", "Lcom/talabat/splash/presentation/ui/SplashActivitySharedViewModel;", "bindViewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "factory", "Lcom/talabat/splash/core/di/viewmodel/ViewModelFactory;", "bindViewModelFactory$com_talabat_talabat_talabat", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public abstract class ViewModelModule {
    @Binds
    @ViewModelKey(SplashActivitySharedViewModel.class)
    @IntoMap
    @NotNull
    public abstract ViewModel bindSplashActivityViewModel(@NotNull SplashActivitySharedViewModel splashActivitySharedViewModel);

    @NotNull
    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory$com_talabat_talabat_talabat(@NotNull ViewModelFactory viewModelFactory);
}
