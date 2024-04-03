package com.talabat.gms.maps.data;

import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class DefaultSupportMapFragment_MembersInjector implements MembersInjector<DefaultSupportMapFragment> {
    private final Provider<IObservabilityManager> observabilityManagerProvider;

    public DefaultSupportMapFragment_MembersInjector(Provider<IObservabilityManager> provider) {
        this.observabilityManagerProvider = provider;
    }

    public static MembersInjector<DefaultSupportMapFragment> create(Provider<IObservabilityManager> provider) {
        return new DefaultSupportMapFragment_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.talabat.gms.maps.data.DefaultSupportMapFragment.observabilityManager")
    public static void injectObservabilityManager(DefaultSupportMapFragment defaultSupportMapFragment, IObservabilityManager iObservabilityManager) {
        defaultSupportMapFragment.observabilityManager = iObservabilityManager;
    }

    public void injectMembers(DefaultSupportMapFragment defaultSupportMapFragment) {
        injectObservabilityManager(defaultSupportMapFragment, this.observabilityManagerProvider.get());
    }
}
