package com.talabat.checkoutdotcom;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.pay.PayFeatureFlagConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/talabat/checkoutdotcom/AddCardPresenterImpl;", "Lcom/talabat/checkoutdotcom/AddCardPresenter;", "featureFlagRepo", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "getSelectedCountryId", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;Lcom/talabat/configuration/ConfigurationLocalRepository;)V", "getCardHolderName", "", "enteredHolderName", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AddCardPresenterImpl implements AddCardPresenter {
    @NotNull
    private final ITalabatFeatureFlag featureFlagRepo;
    @NotNull
    private final ConfigurationLocalRepository getSelectedCountryId;

    public AddCardPresenterImpl(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull ConfigurationLocalRepository configurationLocalRepository) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "featureFlagRepo");
        Intrinsics.checkNotNullParameter(configurationLocalRepository, "getSelectedCountryId");
        this.featureFlagRepo = iTalabatFeatureFlag;
        this.getSelectedCountryId = configurationLocalRepository;
    }

    @NotNull
    public String getCardHolderName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "enteredHolderName");
        if (this.featureFlagRepo.getFeatureFlag(PayFeatureFlagConstants.INSTANCE.getWalletFeatureFwfKey(Integer.valueOf(this.getSelectedCountryId.selectedCountry().getCountryId()), PayFeatureFlagConstants.CARD_HOLDER_NAME), false)) {
            return "Talabat";
        }
        return str;
    }
}
