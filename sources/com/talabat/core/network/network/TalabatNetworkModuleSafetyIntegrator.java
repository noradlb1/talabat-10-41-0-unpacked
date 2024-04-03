package com.talabat.core.network.network;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/talabat/core/network/network/TalabatNetworkModuleSafetyIntegrator;", "", "()V", "appInstallationPath", "Lkotlin/Function0;", "", "getAppInstallationPath", "()Lkotlin/jvm/functions/Function0;", "setAppInstallationPath", "(Lkotlin/jvm/functions/Function0;)V", "appPackageName", "getAppPackageName", "setAppPackageName", "com_talabat_core_network_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TalabatNetworkModuleSafetyIntegrator {
    @NotNull
    public static final TalabatNetworkModuleSafetyIntegrator INSTANCE = new TalabatNetworkModuleSafetyIntegrator();
    @NotNull
    private static Function0<String> appInstallationPath = TalabatNetworkModuleSafetyIntegrator$appInstallationPath$1.INSTANCE;
    @NotNull
    private static Function0<String> appPackageName = TalabatNetworkModuleSafetyIntegrator$appPackageName$1.INSTANCE;

    private TalabatNetworkModuleSafetyIntegrator() {
    }

    @NotNull
    public final Function0<String> getAppInstallationPath() {
        return appInstallationPath;
    }

    @NotNull
    public final Function0<String> getAppPackageName() {
        return appPackageName;
    }

    public final void setAppInstallationPath(@NotNull Function0<String> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        appInstallationPath = function0;
    }

    public final void setAppPackageName(@NotNull Function0<String> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        appPackageName = function0;
    }
}
