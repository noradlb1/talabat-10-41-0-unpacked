package com.talabat.core.network.network;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\"\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\"\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\"\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\"\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\"\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0007\"\u0004\b\u001f\u0010\tR \u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0007\"\u0004\b#\u0010\tR \u0010$\u001a\b\u0012\u0004\u0012\u00020!0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0007\"\u0004\b&\u0010\t¨\u0006'"}, d2 = {"Lcom/talabat/core/network/network/TalabatNetworkModuleIntegrator;", "", "()V", "deviceId", "Lkotlin/Function0;", "", "getDeviceId", "()Lkotlin/jvm/functions/Function0;", "setDeviceId", "(Lkotlin/jvm/functions/Function0;)V", "getAccessToken", "getGetAccessToken", "setGetAccessToken", "getMyClientId", "getGetMyClientId", "setGetMyClientId", "getMySessionId", "getGetMySessionId", "setGetMySessionId", "getSelectedLanguage", "getGetSelectedLanguage", "setGetSelectedLanguage", "getTokenType", "getGetTokenType", "setGetTokenType", "getVersion", "getGetVersion", "setGetVersion", "logout", "", "getLogout", "setLogout", "shouldStopUseOwinToken", "", "getShouldStopUseOwinToken", "setShouldStopUseOwinToken", "tokenAvailable", "getTokenAvailable", "setTokenAvailable", "com_talabat_core_network_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TalabatNetworkModuleIntegrator {
    @NotNull
    public static final TalabatNetworkModuleIntegrator INSTANCE = new TalabatNetworkModuleIntegrator();
    @NotNull
    private static Function0<String> deviceId = TalabatNetworkModuleIntegrator$deviceId$1.INSTANCE;
    @NotNull
    private static Function0<String> getAccessToken = TalabatNetworkModuleIntegrator$getAccessToken$1.INSTANCE;
    @NotNull
    private static Function0<String> getMyClientId = TalabatNetworkModuleIntegrator$getMyClientId$1.INSTANCE;
    @NotNull
    private static Function0<String> getMySessionId = TalabatNetworkModuleIntegrator$getMySessionId$1.INSTANCE;
    @NotNull
    private static Function0<String> getSelectedLanguage = TalabatNetworkModuleIntegrator$getSelectedLanguage$1.INSTANCE;
    @NotNull
    private static Function0<String> getTokenType = TalabatNetworkModuleIntegrator$getTokenType$1.INSTANCE;
    @NotNull
    private static Function0<String> getVersion = TalabatNetworkModuleIntegrator$getVersion$1.INSTANCE;
    @NotNull
    private static Function0<Unit> logout = TalabatNetworkModuleIntegrator$logout$1.INSTANCE;
    @NotNull
    private static Function0<Boolean> shouldStopUseOwinToken = TalabatNetworkModuleIntegrator$shouldStopUseOwinToken$1.INSTANCE;
    @NotNull
    private static Function0<Boolean> tokenAvailable = TalabatNetworkModuleIntegrator$tokenAvailable$1.INSTANCE;

    private TalabatNetworkModuleIntegrator() {
    }

    @NotNull
    public final Function0<String> getDeviceId() {
        return deviceId;
    }

    @NotNull
    public final Function0<String> getGetAccessToken() {
        return getAccessToken;
    }

    @NotNull
    public final Function0<String> getGetMyClientId() {
        return getMyClientId;
    }

    @NotNull
    public final Function0<String> getGetMySessionId() {
        return getMySessionId;
    }

    @NotNull
    public final Function0<String> getGetSelectedLanguage() {
        return getSelectedLanguage;
    }

    @NotNull
    public final Function0<String> getGetTokenType() {
        return getTokenType;
    }

    @NotNull
    public final Function0<String> getGetVersion() {
        return getVersion;
    }

    @NotNull
    public final Function0<Unit> getLogout() {
        return logout;
    }

    @NotNull
    public final Function0<Boolean> getShouldStopUseOwinToken() {
        return shouldStopUseOwinToken;
    }

    @NotNull
    public final Function0<Boolean> getTokenAvailable() {
        return tokenAvailable;
    }

    public final void setDeviceId(@NotNull Function0<String> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        deviceId = function0;
    }

    public final void setGetAccessToken(@NotNull Function0<String> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        getAccessToken = function0;
    }

    public final void setGetMyClientId(@NotNull Function0<String> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        getMyClientId = function0;
    }

    public final void setGetMySessionId(@NotNull Function0<String> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        getMySessionId = function0;
    }

    public final void setGetSelectedLanguage(@NotNull Function0<String> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        getSelectedLanguage = function0;
    }

    public final void setGetTokenType(@NotNull Function0<String> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        getTokenType = function0;
    }

    public final void setGetVersion(@NotNull Function0<String> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        getVersion = function0;
    }

    public final void setLogout(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        logout = function0;
    }

    public final void setShouldStopUseOwinToken(@NotNull Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        shouldStopUseOwinToken = function0;
    }

    public final void setTokenAvailable(@NotNull Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        tokenAvailable = function0;
    }
}
