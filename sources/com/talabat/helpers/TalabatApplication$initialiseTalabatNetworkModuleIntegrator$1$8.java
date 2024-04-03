package com.talabat.helpers;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TalabatApplication$initialiseTalabatNetworkModuleIntegrator$1$8 extends Lambda implements Function0<String> {
    final /* synthetic */ TalabatApplication this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TalabatApplication$initialiseTalabatNetworkModuleIntegrator$1$8(TalabatApplication talabatApplication) {
        super(0);
        this.this$0 = talabatApplication;
    }

    public final String invoke() {
        String deviceId = TalabatUtils.getDeviceId(this.this$0);
        Intrinsics.checkNotNullExpressionValue(deviceId, "getDeviceId(this@TalabatApplication)");
        return deviceId;
    }
}
