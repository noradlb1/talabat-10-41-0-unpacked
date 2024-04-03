package com.talabat.darkstores.domain.common;

import com.talabat.darkstores.domain.swimlanes.CheckFlutterSwimlanesSearchResultEnabledUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class BuildLifestyleSearchResultNavigationActionUseCaseImpl_Factory implements Factory<BuildLifestyleSearchResultNavigationActionUseCaseImpl> {
    private final Provider<CheckFlutterSwimlanesSearchResultEnabledUseCase> checkFlutterSwimlanesSearchResultEnabledUseCaseProvider;
    private final Provider<GetFlutterConfigurationParamsUseCase> getFlutterConfigurationParamsProvider;

    public BuildLifestyleSearchResultNavigationActionUseCaseImpl_Factory(Provider<CheckFlutterSwimlanesSearchResultEnabledUseCase> provider, Provider<GetFlutterConfigurationParamsUseCase> provider2) {
        this.checkFlutterSwimlanesSearchResultEnabledUseCaseProvider = provider;
        this.getFlutterConfigurationParamsProvider = provider2;
    }

    public static BuildLifestyleSearchResultNavigationActionUseCaseImpl_Factory create(Provider<CheckFlutterSwimlanesSearchResultEnabledUseCase> provider, Provider<GetFlutterConfigurationParamsUseCase> provider2) {
        return new BuildLifestyleSearchResultNavigationActionUseCaseImpl_Factory(provider, provider2);
    }

    public static BuildLifestyleSearchResultNavigationActionUseCaseImpl newInstance(CheckFlutterSwimlanesSearchResultEnabledUseCase checkFlutterSwimlanesSearchResultEnabledUseCase, GetFlutterConfigurationParamsUseCase getFlutterConfigurationParamsUseCase) {
        return new BuildLifestyleSearchResultNavigationActionUseCaseImpl(checkFlutterSwimlanesSearchResultEnabledUseCase, getFlutterConfigurationParamsUseCase);
    }

    public BuildLifestyleSearchResultNavigationActionUseCaseImpl get() {
        return newInstance(this.checkFlutterSwimlanesSearchResultEnabledUseCaseProvider.get(), this.getFlutterConfigurationParamsProvider.get());
    }
}
