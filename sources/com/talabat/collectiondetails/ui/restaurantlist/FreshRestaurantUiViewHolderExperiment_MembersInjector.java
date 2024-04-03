package com.talabat.collectiondetails.ui.restaurantlist;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.tracking.domain.TalabatTracker;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class FreshRestaurantUiViewHolderExperiment_MembersInjector implements MembersInjector<FreshRestaurantUiViewHolderExperiment> {
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;
    private final Provider<TalabatTracker> trackerProvider;

    public FreshRestaurantUiViewHolderExperiment_MembersInjector(Provider<TalabatTracker> provider, Provider<ITalabatFeatureFlag> provider2) {
        this.trackerProvider = provider;
        this.talabatFeatureFlagProvider = provider2;
    }

    public static MembersInjector<FreshRestaurantUiViewHolderExperiment> create(Provider<TalabatTracker> provider, Provider<ITalabatFeatureFlag> provider2) {
        return new FreshRestaurantUiViewHolderExperiment_MembersInjector(provider, provider2);
    }

    @InjectedFieldSignature("com.talabat.collectiondetails.ui.restaurantlist.FreshRestaurantUiViewHolderExperiment.talabatFeatureFlag")
    public static void injectTalabatFeatureFlag(FreshRestaurantUiViewHolderExperiment freshRestaurantUiViewHolderExperiment, ITalabatFeatureFlag iTalabatFeatureFlag) {
        freshRestaurantUiViewHolderExperiment.talabatFeatureFlag = iTalabatFeatureFlag;
    }

    @InjectedFieldSignature("com.talabat.collectiondetails.ui.restaurantlist.FreshRestaurantUiViewHolderExperiment.tracker")
    public static void injectTracker(FreshRestaurantUiViewHolderExperiment freshRestaurantUiViewHolderExperiment, TalabatTracker talabatTracker) {
        freshRestaurantUiViewHolderExperiment.tracker = talabatTracker;
    }

    public void injectMembers(FreshRestaurantUiViewHolderExperiment freshRestaurantUiViewHolderExperiment) {
        injectTracker(freshRestaurantUiViewHolderExperiment, this.trackerProvider.get());
        injectTalabatFeatureFlag(freshRestaurantUiViewHolderExperiment, this.talabatFeatureFlagProvider.get());
    }
}
