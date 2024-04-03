package com.talabat.hms.maps.data;

import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class DefaultHmsSupportMapFragment_MembersInjector implements MembersInjector<DefaultHmsSupportMapFragment> {
    private final Provider<IObservabilityManager> observabilityManagerProvider;

    public DefaultHmsSupportMapFragment_MembersInjector(Provider<IObservabilityManager> provider) {
        this.observabilityManagerProvider = provider;
    }

    public static MembersInjector<DefaultHmsSupportMapFragment> create(Provider<IObservabilityManager> provider) {
        return new DefaultHmsSupportMapFragment_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.talabat.hms.maps.data.DefaultHmsSupportMapFragment.observabilityManager")
    public static void injectObservabilityManager(DefaultHmsSupportMapFragment defaultHmsSupportMapFragment, IObservabilityManager iObservabilityManager) {
        defaultHmsSupportMapFragment.observabilityManager = iObservabilityManager;
    }

    public void injectMembers(DefaultHmsSupportMapFragment defaultHmsSupportMapFragment) {
        injectObservabilityManager(defaultHmsSupportMapFragment, this.observabilityManagerProvider.get());
    }
}
