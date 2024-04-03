package com.talabat.core.network.network;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0016\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R5\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013R \u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\t0\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0011\"\u0004\b\u001e\u0010\u0013R5\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u000b\"\u0004\b!\u0010\rR5\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u000b\"\u0004\b$\u0010\r¨\u0006%"}, d2 = {"Lcom/talabat/core/network/network/TalabatNetworkModuleJWTTokenIntegrator;", "", "()V", "JWTFeatureEnable", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "path", "", "getJWTFeatureEnable", "()Lkotlin/jvm/functions/Function1;", "setJWTFeatureEnable", "(Lkotlin/jvm/functions/Function1;)V", "getAccessToken", "Lkotlin/Function0;", "getGetAccessToken", "()Lkotlin/jvm/functions/Function0;", "setGetAccessToken", "(Lkotlin/jvm/functions/Function0;)V", "getDeviceToken", "getGetDeviceToken", "setGetDeviceToken", "getTokenType", "getGetTokenType", "setGetTokenType", "globalEntityId", "getGlobalEntityId", "setGlobalEntityId", "isTokenAvailable", "setTokenAvailable", "obtainAccessToken", "getObtainAccessToken", "setObtainAccessToken", "refreshAndObtainAccessToken", "getRefreshAndObtainAccessToken", "setRefreshAndObtainAccessToken", "com_talabat_core_network_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TalabatNetworkModuleJWTTokenIntegrator {
    @NotNull
    public static final TalabatNetworkModuleJWTTokenIntegrator INSTANCE = new TalabatNetworkModuleJWTTokenIntegrator();
    @NotNull
    private static Function1<? super String, Boolean> JWTFeatureEnable = TalabatNetworkModuleJWTTokenIntegrator$JWTFeatureEnable$1.INSTANCE;
    @NotNull
    private static Function0<String> getAccessToken = TalabatNetworkModuleJWTTokenIntegrator$getAccessToken$1.INSTANCE;
    @NotNull
    private static Function0<String> getDeviceToken = TalabatNetworkModuleJWTTokenIntegrator$getDeviceToken$1.INSTANCE;
    @NotNull
    private static Function0<String> getTokenType = TalabatNetworkModuleJWTTokenIntegrator$getTokenType$1.INSTANCE;
    @NotNull
    private static Function0<String> globalEntityId = TalabatNetworkModuleJWTTokenIntegrator$globalEntityId$1.INSTANCE;
    @NotNull
    private static Function0<Boolean> isTokenAvailable = TalabatNetworkModuleJWTTokenIntegrator$isTokenAvailable$1.INSTANCE;
    @NotNull
    private static Function1<? super String, String> obtainAccessToken = TalabatNetworkModuleJWTTokenIntegrator$obtainAccessToken$1.INSTANCE;
    @NotNull
    private static Function1<? super String, String> refreshAndObtainAccessToken = TalabatNetworkModuleJWTTokenIntegrator$refreshAndObtainAccessToken$1.INSTANCE;

    private TalabatNetworkModuleJWTTokenIntegrator() {
    }

    @NotNull
    public final Function0<String> getGetAccessToken() {
        return getAccessToken;
    }

    @NotNull
    public final Function0<String> getGetDeviceToken() {
        return getDeviceToken;
    }

    @NotNull
    public final Function0<String> getGetTokenType() {
        return getTokenType;
    }

    @NotNull
    public final Function0<String> getGlobalEntityId() {
        return globalEntityId;
    }

    @NotNull
    public final Function1<String, Boolean> getJWTFeatureEnable() {
        return JWTFeatureEnable;
    }

    @NotNull
    public final Function1<String, String> getObtainAccessToken() {
        return obtainAccessToken;
    }

    @NotNull
    public final Function1<String, String> getRefreshAndObtainAccessToken() {
        return refreshAndObtainAccessToken;
    }

    @NotNull
    public final Function0<Boolean> isTokenAvailable() {
        return isTokenAvailable;
    }

    public final void setGetAccessToken(@NotNull Function0<String> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        getAccessToken = function0;
    }

    public final void setGetDeviceToken(@NotNull Function0<String> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        getDeviceToken = function0;
    }

    public final void setGetTokenType(@NotNull Function0<String> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        getTokenType = function0;
    }

    public final void setGlobalEntityId(@NotNull Function0<String> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        globalEntityId = function0;
    }

    public final void setJWTFeatureEnable(@NotNull Function1<? super String, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        JWTFeatureEnable = function1;
    }

    public final void setObtainAccessToken(@NotNull Function1<? super String, String> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        obtainAccessToken = function1;
    }

    public final void setRefreshAndObtainAccessToken(@NotNull Function1<? super String, String> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        refreshAndObtainAccessToken = function1;
    }

    public final void setTokenAvailable(@NotNull Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        isTokenAvailable = function0;
    }
}
