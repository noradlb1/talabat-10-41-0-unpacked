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
public final class BuildSwimlanesSearchResultNavigationActionUseCaseImpl_Factory implements Factory<BuildSwimlanesSearchResultNavigationActionUseCaseImpl> {
    private final Provider<CheckFlutterSwimlanesSearchResultEnabledUseCase> checkFlutterSwimlanesSearchResultEnabledUseCaseProvider;
    private final Provider<GetFlutterConfigurationParamsUseCase> getFlutterConfigurationParamsProvider;

    public BuildSwimlanesSearchResultNavigationActionUseCaseImpl_Factory(Provider<CheckFlutterSwimlanesSearchResultEnabledUseCase> provider, Provider<GetFlutterConfigurationParamsUseCase> provider2) {
        this.checkFlutterSwimlanesSearchResultEnabledUseCaseProvider = provider;
        this.getFlutterConfigurationParamsProvider = provider2;
    }

    public static BuildSwimlanesSearchResultNavigationActionUseCaseImpl_Factory create(Provider<CheckFlutterSwimlanesSearchResultEnabledUseCase> provider, Provider<GetFlutterConfigurationParamsUseCase> provider2) {
        return new BuildSwimlanesSearchResultNavigationActionUseCaseImpl_Factory(provider, provider2);
    }

    public static BuildSwimlanesSearchResultNavigationActionUseCaseImpl newInstance(CheckFlutterSwimlanesSearchResultEnabledUseCase checkFlutterSwimlanesSearchResultEnabledUseCase, GetFlutterConfigurationParamsUseCase getFlutterConfigurationParamsUseCase) {
        return new BuildSwimlanesSearchResultNavigationActionUseCaseImpl(checkFlutterSwimlanesSearchResultEnabledUseCase, getFlutterConfigurationParamsUseCase);
    }

    public BuildSwimlanesSearchResultNavigationActionUseCaseImpl get() {
        return newInstance(this.checkFlutterSwimlanesSearchResultEnabledUseCaseProvider.get(), this.getFlutterConfigurationParamsProvider.get());
    }
}
