package com.talabat.helpers;

import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.fwfprojectskeys.domain.projects.user.UserFeatureFlagsKeys;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TalabatApplication$initialiseTalabatNetworkModuleIntegrator$1$10 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ TalabatApplication this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TalabatApplication$initialiseTalabatNetworkModuleIntegrator$1$10(TalabatApplication talabatApplication) {
        super(0);
        this.this$0 = talabatApplication;
    }

    @NotNull
    public final Boolean invoke() {
        return Boolean.valueOf(((FeatureFlagCoreLibApi) this.this$0.getFeature(FeatureFlagCoreLibApi.class)).getTalabatFeatureFlag().getFeatureFlag(UserFeatureFlagsKeys.FF_USER_STOP_USING_OWIN_TOKEN, false));
    }
}
