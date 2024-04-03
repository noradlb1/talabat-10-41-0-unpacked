package com.talabat.core.ui.di;

import androidx.lifecycle.ViewModel;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.Map;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class ViewModelGenericFactory_Factory implements Factory<ViewModelGenericFactory> {
    private final Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> viewModelsProvider;

    public ViewModelGenericFactory_Factory(Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> provider) {
        this.viewModelsProvider = provider;
    }

    public static ViewModelGenericFactory_Factory create(Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> provider) {
        return new ViewModelGenericFactory_Factory(provider);
    }

    public static ViewModelGenericFactory newInstance(Map<Class<? extends ViewModel>, Provider<ViewModel>> map) {
        return new ViewModelGenericFactory(map);
    }

    public ViewModelGenericFactory get() {
        return newInstance(this.viewModelsProvider.get());
    }
}
