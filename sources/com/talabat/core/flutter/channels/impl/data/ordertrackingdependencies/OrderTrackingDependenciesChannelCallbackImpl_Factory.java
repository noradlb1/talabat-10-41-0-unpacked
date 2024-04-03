package com.talabat.core.flutter.channels.impl.data.ordertrackingdependencies;

import com.talabat.core.navigation.domain.Navigator;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class OrderTrackingDependenciesChannelCallbackImpl_Factory implements Factory<OrderTrackingDependenciesChannelCallbackImpl> {
    private final Provider<Navigator> navigatorProvider;

    public OrderTrackingDependenciesChannelCallbackImpl_Factory(Provider<Navigator> provider) {
        this.navigatorProvider = provider;
    }

    public static OrderTrackingDependenciesChannelCallbackImpl_Factory create(Provider<Navigator> provider) {
        return new OrderTrackingDependenciesChannelCallbackImpl_Factory(provider);
    }

    public static OrderTrackingDependenciesChannelCallbackImpl newInstance(Navigator navigator) {
        return new OrderTrackingDependenciesChannelCallbackImpl(navigator);
    }

    public OrderTrackingDependenciesChannelCallbackImpl get() {
        return newInstance(this.navigatorProvider.get());
    }
}
