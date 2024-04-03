package com.talabat.core.flutter.binding.data.search;

import com.talabat.core.flutter.channels.domain.search.SearchChannelFlutterDomain;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class SearchFlutterEngineBinding_Factory implements Factory<SearchFlutterEngineBinding> {
    private final Provider<SearchChannelFlutterDomain> searchChannelFlutterDomainProvider;

    public SearchFlutterEngineBinding_Factory(Provider<SearchChannelFlutterDomain> provider) {
        this.searchChannelFlutterDomainProvider = provider;
    }

    public static SearchFlutterEngineBinding_Factory create(Provider<SearchChannelFlutterDomain> provider) {
        return new SearchFlutterEngineBinding_Factory(provider);
    }

    public static SearchFlutterEngineBinding newInstance(SearchChannelFlutterDomain searchChannelFlutterDomain) {
        return new SearchFlutterEngineBinding(searchChannelFlutterDomain);
    }

    public SearchFlutterEngineBinding get() {
        return newInstance(this.searchChannelFlutterDomainProvider.get());
    }
}
