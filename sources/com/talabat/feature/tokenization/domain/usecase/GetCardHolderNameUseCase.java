package com.talabat.feature.tokenization.domain.usecase;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.fwfprojectskeys.domain.projects.ordering.OrderingFeatureFlagsKeys;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/talabat/feature/tokenization/domain/usecase/GetCardHolderNameUseCase;", "", "featureFlagRepo", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "invoke", "", "enteredHolderName", "com_talabat_feature_tokenization_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetCardHolderNameUseCase {
    @NotNull
    private final ITalabatFeatureFlag featureFlagRepo;

    @Inject
    public GetCardHolderNameUseCase(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "featureFlagRepo");
        this.featureFlagRepo = iTalabatFeatureFlag;
    }

    public static /* synthetic */ String invoke$default(GetCardHolderNameUseCase getCardHolderNameUseCase, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = "";
        }
        return getCardHolderNameUseCase.invoke(str);
    }

    @NotNull
    public final String invoke(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "enteredHolderName");
        if (ITalabatFeatureFlag.DefaultImpls.getFeatureFlag$default(this.featureFlagRepo, OrderingFeatureFlagsKeys.ADD_CARD_HOLDER_NAME_ENABLED, false, 2, (Object) null)) {
            return "Talabat";
        }
        return str;
    }
}
