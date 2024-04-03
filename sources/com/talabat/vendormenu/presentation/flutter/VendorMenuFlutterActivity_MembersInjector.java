package com.talabat.vendormenu.presentation.flutter;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.observabilityNew.domain.IScreenTracker;
import com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository;
import com.talabat.feature.subscriptions.domain.wrapper.ProCentralizationStatusWrapper;
import com.talabat.feature.tpro.presentation.helperview.mov.VendorMovViewModelFactory;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class VendorMenuFlutterActivity_MembersInjector implements MembersInjector<VendorMenuFlutterActivity> {
    private final Provider<ProCentralizationStatusWrapper> proCentralizationStatusWrapperProvider;
    private final Provider<IScreenTracker> screenTrackerProvider;
    private final Provider<ISubscriptionStatusRepository> subscriptionStatusRepositoryProvider;
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;
    private final Provider<VendorMovViewModelFactory> vendorMovViewModelFactoryProvider;

    public VendorMenuFlutterActivity_MembersInjector(Provider<ITalabatFeatureFlag> provider, Provider<IScreenTracker> provider2, Provider<VendorMovViewModelFactory> provider3, Provider<ISubscriptionStatusRepository> provider4, Provider<ProCentralizationStatusWrapper> provider5) {
        this.talabatFeatureFlagProvider = provider;
        this.screenTrackerProvider = provider2;
        this.vendorMovViewModelFactoryProvider = provider3;
        this.subscriptionStatusRepositoryProvider = provider4;
        this.proCentralizationStatusWrapperProvider = provider5;
    }

    public static MembersInjector<VendorMenuFlutterActivity> create(Provider<ITalabatFeatureFlag> provider, Provider<IScreenTracker> provider2, Provider<VendorMovViewModelFactory> provider3, Provider<ISubscriptionStatusRepository> provider4, Provider<ProCentralizationStatusWrapper> provider5) {
        return new VendorMenuFlutterActivity_MembersInjector(provider, provider2, provider3, provider4, provider5);
    }

    @InjectedFieldSignature("com.talabat.vendormenu.presentation.flutter.VendorMenuFlutterActivity.proCentralizationStatusWrapper")
    public static void injectProCentralizationStatusWrapper(VendorMenuFlutterActivity vendorMenuFlutterActivity, ProCentralizationStatusWrapper proCentralizationStatusWrapper) {
        vendorMenuFlutterActivity.proCentralizationStatusWrapper = proCentralizationStatusWrapper;
    }

    @InjectedFieldSignature("com.talabat.vendormenu.presentation.flutter.VendorMenuFlutterActivity.screenTracker")
    public static void injectScreenTracker(VendorMenuFlutterActivity vendorMenuFlutterActivity, IScreenTracker iScreenTracker) {
        vendorMenuFlutterActivity.screenTracker = iScreenTracker;
    }

    @InjectedFieldSignature("com.talabat.vendormenu.presentation.flutter.VendorMenuFlutterActivity.subscriptionStatusRepository")
    public static void injectSubscriptionStatusRepository(VendorMenuFlutterActivity vendorMenuFlutterActivity, ISubscriptionStatusRepository iSubscriptionStatusRepository) {
        vendorMenuFlutterActivity.subscriptionStatusRepository = iSubscriptionStatusRepository;
    }

    @InjectedFieldSignature("com.talabat.vendormenu.presentation.flutter.VendorMenuFlutterActivity.talabatFeatureFlag")
    public static void injectTalabatFeatureFlag(VendorMenuFlutterActivity vendorMenuFlutterActivity, ITalabatFeatureFlag iTalabatFeatureFlag) {
        vendorMenuFlutterActivity.talabatFeatureFlag = iTalabatFeatureFlag;
    }

    @InjectedFieldSignature("com.talabat.vendormenu.presentation.flutter.VendorMenuFlutterActivity.vendorMovViewModelFactory")
    public static void injectVendorMovViewModelFactory(VendorMenuFlutterActivity vendorMenuFlutterActivity, VendorMovViewModelFactory vendorMovViewModelFactory) {
        vendorMenuFlutterActivity.vendorMovViewModelFactory = vendorMovViewModelFactory;
    }

    public void injectMembers(VendorMenuFlutterActivity vendorMenuFlutterActivity) {
        injectTalabatFeatureFlag(vendorMenuFlutterActivity, this.talabatFeatureFlagProvider.get());
        injectScreenTracker(vendorMenuFlutterActivity, this.screenTrackerProvider.get());
        injectVendorMovViewModelFactory(vendorMenuFlutterActivity, this.vendorMovViewModelFactoryProvider.get());
        injectSubscriptionStatusRepository(vendorMenuFlutterActivity, this.subscriptionStatusRepositoryProvider.get());
        injectProCentralizationStatusWrapper(vendorMenuFlutterActivity, this.proCentralizationStatusWrapperProvider.get());
    }
}
