package com.talabat.trackorder.presentation;

import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.observabilityNew.domain.IScreenTracker;
import com.talabat.feature.cancellationpolicy.domain.IHelpCenterDeeplinkBuilder;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class OrderTrackingFlutterActivity_MembersInjector implements MembersInjector<OrderTrackingFlutterActivity> {
    private final Provider<DeepLinkNavigator> deepLinkNavigatorProvider;
    private final Provider<ITalabatExperiment> experimentProvider;
    private final Provider<IHelpCenterDeeplinkBuilder> helpCenterDeeplinkBuilderProvider;
    private final Provider<Navigator> navigatorProvider;
    private final Provider<IScreenTracker> screenTrackerProvider;
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagsProvider;

    public OrderTrackingFlutterActivity_MembersInjector(Provider<IScreenTracker> provider, Provider<ITalabatFeatureFlag> provider2, Provider<ITalabatExperiment> provider3, Provider<Navigator> provider4, Provider<IHelpCenterDeeplinkBuilder> provider5, Provider<DeepLinkNavigator> provider6) {
        this.screenTrackerProvider = provider;
        this.talabatFeatureFlagsProvider = provider2;
        this.experimentProvider = provider3;
        this.navigatorProvider = provider4;
        this.helpCenterDeeplinkBuilderProvider = provider5;
        this.deepLinkNavigatorProvider = provider6;
    }

    public static MembersInjector<OrderTrackingFlutterActivity> create(Provider<IScreenTracker> provider, Provider<ITalabatFeatureFlag> provider2, Provider<ITalabatExperiment> provider3, Provider<Navigator> provider4, Provider<IHelpCenterDeeplinkBuilder> provider5, Provider<DeepLinkNavigator> provider6) {
        return new OrderTrackingFlutterActivity_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @InjectedFieldSignature("com.talabat.trackorder.presentation.OrderTrackingFlutterActivity.deepLinkNavigator")
    public static void injectDeepLinkNavigator(OrderTrackingFlutterActivity orderTrackingFlutterActivity, DeepLinkNavigator deepLinkNavigator) {
        orderTrackingFlutterActivity.deepLinkNavigator = deepLinkNavigator;
    }

    @InjectedFieldSignature("com.talabat.trackorder.presentation.OrderTrackingFlutterActivity.experiment")
    public static void injectExperiment(OrderTrackingFlutterActivity orderTrackingFlutterActivity, ITalabatExperiment iTalabatExperiment) {
        orderTrackingFlutterActivity.experiment = iTalabatExperiment;
    }

    @InjectedFieldSignature("com.talabat.trackorder.presentation.OrderTrackingFlutterActivity.helpCenterDeeplinkBuilder")
    public static void injectHelpCenterDeeplinkBuilder(OrderTrackingFlutterActivity orderTrackingFlutterActivity, IHelpCenterDeeplinkBuilder iHelpCenterDeeplinkBuilder) {
        orderTrackingFlutterActivity.helpCenterDeeplinkBuilder = iHelpCenterDeeplinkBuilder;
    }

    @InjectedFieldSignature("com.talabat.trackorder.presentation.OrderTrackingFlutterActivity.navigator")
    public static void injectNavigator(OrderTrackingFlutterActivity orderTrackingFlutterActivity, Navigator navigator) {
        orderTrackingFlutterActivity.navigator = navigator;
    }

    @InjectedFieldSignature("com.talabat.trackorder.presentation.OrderTrackingFlutterActivity.screenTracker")
    public static void injectScreenTracker(OrderTrackingFlutterActivity orderTrackingFlutterActivity, IScreenTracker iScreenTracker) {
        orderTrackingFlutterActivity.screenTracker = iScreenTracker;
    }

    @InjectedFieldSignature("com.talabat.trackorder.presentation.OrderTrackingFlutterActivity.talabatFeatureFlags")
    public static void injectTalabatFeatureFlags(OrderTrackingFlutterActivity orderTrackingFlutterActivity, ITalabatFeatureFlag iTalabatFeatureFlag) {
        orderTrackingFlutterActivity.talabatFeatureFlags = iTalabatFeatureFlag;
    }

    public void injectMembers(OrderTrackingFlutterActivity orderTrackingFlutterActivity) {
        injectScreenTracker(orderTrackingFlutterActivity, this.screenTrackerProvider.get());
        injectTalabatFeatureFlags(orderTrackingFlutterActivity, this.talabatFeatureFlagsProvider.get());
        injectExperiment(orderTrackingFlutterActivity, this.experimentProvider.get());
        injectNavigator(orderTrackingFlutterActivity, this.navigatorProvider.get());
        injectHelpCenterDeeplinkBuilder(orderTrackingFlutterActivity, this.helpCenterDeeplinkBuilderProvider.get());
        injectDeepLinkNavigator(orderTrackingFlutterActivity, this.deepLinkNavigatorProvider.get());
    }
}
