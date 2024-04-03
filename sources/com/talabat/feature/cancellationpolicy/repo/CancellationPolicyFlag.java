package com.talabat.feature.cancellationpolicy.repo;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.TalabatFeatureFlagConstants;
import com.talabat.feature.cancellationpolicy.domain.ICancellationPolicyFlag;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/cancellationpolicy/repo/CancellationPolicyFlag;", "Lcom/talabat/feature/cancellationpolicy/domain/ICancellationPolicyFlag;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "isCancellationPolicyIsEnabled", "", "com_talabat_feature_helpcenter_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CancellationPolicyFlag implements ICancellationPolicyFlag {
    @NotNull
    private final ITalabatFeatureFlag talabatFeatureFlag;

    public CancellationPolicyFlag(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        this.talabatFeatureFlag = iTalabatFeatureFlag;
    }

    public boolean isCancellationPolicyIsEnabled() {
        return this.talabatFeatureFlag.getFeatureFlag(TalabatFeatureFlagConstants.ENABLE_CANCELLATION_POLICY, false);
    }
}
