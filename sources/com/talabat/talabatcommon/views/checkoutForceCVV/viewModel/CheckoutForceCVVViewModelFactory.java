package com.talabat.talabatcommon.views.checkoutForceCVV.viewModel;

import com.talabat.core.di.ApiContainer;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.talabatcommon.feature.checkoutForceCVV.GetCheckoutCVVPopUpStatusUseCase;
import com.talabat.talabatcommon.feature.checkoutForceCVV.GetCheckoutForceCVVFeatureFlagUseCase;
import com.talabat.talabatcommon.feature.checkoutForceCVV.dao.CheckoutForceCVVRemoteDaoImpl;
import com.talabat.talabatcommon.feature.checkoutForceCVV.network.CheckoutForceCVVApiBuilder;
import com.talabat.talabatcommon.feature.checkoutForceCVV.repository.CheckoutForceCVVRepositoryImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/talabat/talabatcommon/views/checkoutForceCVV/viewModel/CheckoutForceCVVViewModelFactory;", "", "()V", "mockedCheckoutForceCVVVViewModel", "Lcom/talabat/talabatcommon/views/checkoutForceCVV/viewModel/CheckoutForceCVVVViewModel;", "getMockedCheckoutForceCVVVViewModel", "()Lcom/talabat/talabatcommon/views/checkoutForceCVV/viewModel/CheckoutForceCVVVViewModel;", "setMockedCheckoutForceCVVVViewModel", "(Lcom/talabat/talabatcommon/views/checkoutForceCVV/viewModel/CheckoutForceCVVVViewModel;)V", "getCheckoutForceCVVViewModel", "apiContainer", "Lcom/talabat/core/di/ApiContainer;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CheckoutForceCVVViewModelFactory {
    @NotNull
    public static final CheckoutForceCVVViewModelFactory INSTANCE = new CheckoutForceCVVViewModelFactory();
    @Nullable
    private static CheckoutForceCVVVViewModel mockedCheckoutForceCVVVViewModel;

    private CheckoutForceCVVViewModelFactory() {
    }

    @NotNull
    public final CheckoutForceCVVVViewModel getCheckoutForceCVVViewModel(@NotNull ApiContainer apiContainer) {
        Intrinsics.checkNotNullParameter(apiContainer, "apiContainer");
        ITalabatFeatureFlag talabatFeatureFlag = ((FeatureFlagCoreLibApi) apiContainer.getFeature(FeatureFlagCoreLibApi.class)).getTalabatFeatureFlag();
        CheckoutForceCVVVViewModel checkoutForceCVVVViewModel = mockedCheckoutForceCVVVViewModel;
        if (checkoutForceCVVVViewModel == null) {
            return new CheckoutForceCVVVViewModel(new GetCheckoutCVVPopUpStatusUseCase(new CheckoutForceCVVRepositoryImpl(new CheckoutForceCVVRemoteDaoImpl(CheckoutForceCVVApiBuilder.INSTANCE.getCheckoutCVVPopUpApi()))), new GetCheckoutForceCVVFeatureFlagUseCase(talabatFeatureFlag, CheckoutForceCVVViewModelFactory$getCheckoutForceCVVViewModel$1.INSTANCE));
        }
        return checkoutForceCVVVViewModel;
    }

    @Nullable
    public final CheckoutForceCVVVViewModel getMockedCheckoutForceCVVVViewModel() {
        return mockedCheckoutForceCVVVViewModel;
    }

    public final void setMockedCheckoutForceCVVVViewModel(@Nullable CheckoutForceCVVVViewModel checkoutForceCVVVViewModel) {
        mockedCheckoutForceCVVVViewModel = checkoutForceCVVVViewModel;
    }
}
