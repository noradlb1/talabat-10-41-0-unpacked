package com.talabat.helpers;

import com.talabat.configuration.discovery.AppVersionProvider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TalabatApplication$initialiseTalabatNetworkModuleIntegrator$1$6 extends Lambda implements Function0<String> {
    final /* synthetic */ AppVersionProvider $appVersionProvider;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TalabatApplication$initialiseTalabatNetworkModuleIntegrator$1$6(AppVersionProvider appVersionProvider) {
        super(0);
        this.$appVersionProvider = appVersionProvider;
    }

    @NotNull
    public final String invoke() {
        String appVersion = this.$appVersionProvider.appVersion();
        return appVersion == null ? "" : appVersion;
    }
}
