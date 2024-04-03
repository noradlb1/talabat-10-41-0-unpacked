package com.deliveryhero.perseus.data.local.db.entity;

import com.deliveryhero.perseus.Consent;
import com.deliveryhero.perseus.PerseusParamsConfig;
import com.deliveryhero.perseus.core.session.AppSessionManager;
import com.deliveryhero.perseus.core.session.ClientIdProvider;
import com.deliveryhero.perseus.utils.EventVariablesJsonSerializer;
import com.deliveryhero.perseus.utils.TimeHelperKt;
import com.talabat.darkstores.feature.main.DarkstoresMainActivity;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JB\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0010¨\u0006\u0012"}, d2 = {"Lcom/deliveryhero/perseus/data/local/db/entity/HitEventFactory;", "", "()V", "createEventHit", "Lcom/deliveryhero/perseus/data/local/db/entity/HitEvent;", "date", "Ljava/util/Date;", "timestamp", "", "config", "Lcom/deliveryhero/perseus/PerseusParamsConfig;", "appSessionManager", "Lcom/deliveryhero/perseus/core/session/AppSessionManager;", "clientIdProvider", "Lcom/deliveryhero/perseus/core/session/ClientIdProvider;", "eventVariables", "", "", "perseus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class HitEventFactory {
    @NotNull
    public final HitEvent createEventHit(@NotNull Date date, long j11, @NotNull PerseusParamsConfig perseusParamsConfig, @NotNull AppSessionManager appSessionManager, @NotNull ClientIdProvider clientIdProvider, @NotNull Map<String, String> map) {
        String str;
        Date date2 = date;
        Map<String, String> map2 = map;
        Intrinsics.checkNotNullParameter(date2, "date");
        Intrinsics.checkNotNullParameter(perseusParamsConfig, DarkstoresMainActivity.CONFIG_EXTRA_KEY);
        Intrinsics.checkNotNullParameter(appSessionManager, "appSessionManager");
        Intrinsics.checkNotNullParameter(clientIdProvider, "clientIdProvider");
        Intrinsics.checkNotNullParameter(map2, "eventVariables");
        String createTimeStamp$default = TimeHelperKt.createTimeStamp$default(date2, (TimeZone) null, 2, (Object) null);
        String countryCode = perseusParamsConfig.getCountryCode();
        String advertisingId = perseusParamsConfig.getAdvertisingId();
        String appId = perseusParamsConfig.getAppId();
        String appName = perseusParamsConfig.getAppName();
        String appVersionName = perseusParamsConfig.getAppVersionName();
        String adjustId = perseusParamsConfig.getAdjustId();
        String userId = perseusParamsConfig.getUserId();
        String uaId = perseusParamsConfig.getUaId();
        String clientId = clientIdProvider.getClientId();
        String userSessionId = appSessionManager.getUserSessionId();
        String sdkVersionName = perseusParamsConfig.getSdkVersionName();
        String globalEntityId = perseusParamsConfig.getGlobalEntityId();
        Consent consent = perseusParamsConfig.getConsent();
        if (consent != null) {
            str = consent.getStringRepresentation();
        } else {
            str = null;
        }
        return new HitEvent(0, j11, createTimeStamp$default, countryCode, advertisingId, appId, appName, appVersionName, adjustId, userId, uaId, clientId, userSessionId, sdkVersionName, globalEntityId, str, appSessionManager.getAndIncrementSessionOffset(), EventVariablesJsonSerializer.INSTANCE.toJson(map2), 1, (DefaultConstructorMarker) null);
    }
}
