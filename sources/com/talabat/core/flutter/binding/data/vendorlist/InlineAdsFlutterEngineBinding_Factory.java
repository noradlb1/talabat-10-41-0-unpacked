package com.talabat.core.flutter.binding.data.vendorlist;

import com.talabat.core.flutter.channels.domain.vendorlist.InlineAdsChannelFlutterDomain;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class InlineAdsFlutterEngineBinding_Factory implements Factory<InlineAdsFlutterEngineBinding> {
    private final Provider<InlineAdsChannelFlutterDomain> inlineAdsChannelFlutterDomainProvider;

    public InlineAdsFlutterEngineBinding_Factory(Provider<InlineAdsChannelFlutterDomain> provider) {
        this.inlineAdsChannelFlutterDomainProvider = provider;
    }

    public static InlineAdsFlutterEngineBinding_Factory create(Provider<InlineAdsChannelFlutterDomain> provider) {
        return new InlineAdsFlutterEngineBinding_Factory(provider);
    }

    public static InlineAdsFlutterEngineBinding newInstance(InlineAdsChannelFlutterDomain inlineAdsChannelFlutterDomain) {
        return new InlineAdsFlutterEngineBinding(inlineAdsChannelFlutterDomain);
    }

    public InlineAdsFlutterEngineBinding get() {
        return newInstance(this.inlineAdsChannelFlutterDomainProvider.get());
    }
}
