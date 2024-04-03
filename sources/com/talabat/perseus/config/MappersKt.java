package com.talabat.perseus.config;

import com.deliveryhero.perseus.Consent;
import com.deliveryhero.perseus.PerseusParamsConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"convert", "Lcom/deliveryhero/perseus/PerseusParamsConfig;", "Lcom/talabat/perseus/config/PerseusConfig;", "perseus_analytics_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class MappersKt {
    @NotNull
    public static final PerseusParamsConfig convert(@NotNull PerseusConfig perseusConfig) {
        Intrinsics.checkNotNullParameter(perseusConfig, "<this>");
        String adjustId = perseusConfig.getAdjustId();
        String advertisingId = perseusConfig.getAdvertisingId();
        String appId = perseusConfig.getAppId();
        String appName = perseusConfig.getAppName();
        String appVersionName = perseusConfig.getAppVersionName();
        String baseUrl = perseusConfig.getBaseUrl();
        String countryCode = perseusConfig.getCountryCode();
        boolean debuggable = perseusConfig.getDebuggable();
        return new PerseusParamsConfig(advertisingId, appId, appName, appVersionName, adjustId, perseusConfig.getUaId(), perseusConfig.getEntity(), debuggable, 0, 0, countryCode, perseusConfig.getUserId(), baseUrl, perseusConfig.getGlobalEntityId(), (Consent) null, 17152, (DefaultConstructorMarker) null);
    }
}
