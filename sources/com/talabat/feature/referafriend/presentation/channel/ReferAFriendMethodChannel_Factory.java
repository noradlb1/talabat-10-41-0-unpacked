package com.talabat.feature.referafriend.presentation.channel;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class ReferAFriendMethodChannel_Factory implements Factory<ReferAFriendMethodChannel> {
    private final Provider<ReferAFriendMethodChannelCallback> callbackProvider;

    public ReferAFriendMethodChannel_Factory(Provider<ReferAFriendMethodChannelCallback> provider) {
        this.callbackProvider = provider;
    }

    public static ReferAFriendMethodChannel_Factory create(Provider<ReferAFriendMethodChannelCallback> provider) {
        return new ReferAFriendMethodChannel_Factory(provider);
    }

    public static ReferAFriendMethodChannel newInstance(ReferAFriendMethodChannelCallback referAFriendMethodChannelCallback) {
        return new ReferAFriendMethodChannel(referAFriendMethodChannelCallback);
    }

    public ReferAFriendMethodChannel get() {
        return newInstance(this.callbackProvider.get());
    }
}
