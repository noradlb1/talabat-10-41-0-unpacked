package com.talabat.feature.ulaccountinfo.data;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.fwfprojectskeys.domain.projects.user.UserFeatureFlagsKeys;
import com.talabat.feature.ulaccountinfo.domain.IAccountInfoFeatureFlag;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/ulaccountinfo/data/AccountInfoFeatureFlag;", "Lcom/talabat/feature/ulaccountinfo/domain/IAccountInfoFeatureFlag;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "isAccountInfoEnabled", "", "com_talabat_feature_ul-account-info_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AccountInfoFeatureFlag implements IAccountInfoFeatureFlag {
    @NotNull
    private final ITalabatFeatureFlag talabatFeatureFlag;

    @Inject
    public AccountInfoFeatureFlag(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        this.talabatFeatureFlag = iTalabatFeatureFlag;
    }

    public boolean isAccountInfoEnabled() {
        return this.talabatFeatureFlag.getFeatureFlag(UserFeatureFlagsKeys.FF_USER_FLUTTER_ACCOUNT_INFO, false);
    }
}
