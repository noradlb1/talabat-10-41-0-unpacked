package com.talabat.core.flutter.binding.data.ordertrackingdependencies;

import com.talabat.core.flutter.channels.domain.ordertrackingdependencies.OrderTrackingDependenciesFlutterDomain;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class OrderTrackingDependenciesFlutterEngineBinding_Factory implements Factory<OrderTrackingDependenciesFlutterEngineBinding> {
    private final Provider<OrderTrackingDependenciesFlutterDomain> orderTrackingDependenciesFlutterDomainProvider;

    public OrderTrackingDependenciesFlutterEngineBinding_Factory(Provider<OrderTrackingDependenciesFlutterDomain> provider) {
        this.orderTrackingDependenciesFlutterDomainProvider = provider;
    }

    public static OrderTrackingDependenciesFlutterEngineBinding_Factory create(Provider<OrderTrackingDependenciesFlutterDomain> provider) {
        return new OrderTrackingDependenciesFlutterEngineBinding_Factory(provider);
    }

    public static OrderTrackingDependenciesFlutterEngineBinding newInstance(OrderTrackingDependenciesFlutterDomain orderTrackingDependenciesFlutterDomain) {
        return new OrderTrackingDependenciesFlutterEngineBinding(orderTrackingDependenciesFlutterDomain);
    }

    public OrderTrackingDependenciesFlutterEngineBinding get() {
        return newInstance(this.orderTrackingDependenciesFlutterDomainProvider.get());
    }
}
