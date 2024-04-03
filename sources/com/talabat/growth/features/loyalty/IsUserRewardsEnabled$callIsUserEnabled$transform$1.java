package com.talabat.growth.features.loyalty;

import com.talabat.growth.features.loyalty.models.responses.isUserEnabled.IsUserEnabledRootResponse;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/talabat/growth/features/loyalty/models/responses/isUserEnabled/IsUserEnabledRootResponse;", "invoke", "(Lcom/talabat/growth/features/loyalty/models/responses/isUserEnabled/IsUserEnabledRootResponse;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class IsUserRewardsEnabled$callIsUserEnabled$transform$1 extends Lambda implements Function1<IsUserEnabledRootResponse, Boolean> {
    public static final IsUserRewardsEnabled$callIsUserEnabled$transform$1 INSTANCE = new IsUserRewardsEnabled$callIsUserEnabled$transform$1();

    public IsUserRewardsEnabled$callIsUserEnabled$transform$1() {
        super(1);
    }

    @NotNull
    public final Boolean invoke(@NotNull IsUserEnabledRootResponse isUserEnabledRootResponse) {
        Intrinsics.checkNotNullParameter(isUserEnabledRootResponse, "it");
        Boolean bool = (Boolean) isUserEnabledRootResponse.getResult();
        return Boolean.valueOf(bool != null ? bool.booleanValue() : false);
    }
}
