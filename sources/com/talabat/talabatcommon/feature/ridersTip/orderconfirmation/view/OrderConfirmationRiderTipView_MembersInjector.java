package com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.view;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class OrderConfirmationRiderTipView_MembersInjector implements MembersInjector<OrderConfirmationRiderTipView> {
    private final Provider<ITalabatFeatureFlag> featureFlagRepoProvider;

    public OrderConfirmationRiderTipView_MembersInjector(Provider<ITalabatFeatureFlag> provider) {
        this.featureFlagRepoProvider = provider;
    }

    public static MembersInjector<OrderConfirmationRiderTipView> create(Provider<ITalabatFeatureFlag> provider) {
        return new OrderConfirmationRiderTipView_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.view.OrderConfirmationRiderTipView.featureFlagRepo")
    public static void injectFeatureFlagRepo(OrderConfirmationRiderTipView orderConfirmationRiderTipView, ITalabatFeatureFlag iTalabatFeatureFlag) {
        orderConfirmationRiderTipView.featureFlagRepo = iTalabatFeatureFlag;
    }

    public void injectMembers(OrderConfirmationRiderTipView orderConfirmationRiderTipView) {
        injectFeatureFlagRepo(orderConfirmationRiderTipView, this.featureFlagRepoProvider.get());
    }
}
