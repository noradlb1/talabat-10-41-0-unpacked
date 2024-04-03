package com.deliveryhero.perseus.hits.usecase;

import android.os.Build;
import com.deliveryhero.perseus.Consent;
import com.deliveryhero.perseus.PerseusParamsConfig;
import com.deliveryhero.perseus.core.config.PerseusConfigProvider;
import com.deliveryhero.perseus.core.deviceinfo.DeviceInfoProvider;
import com.deliveryhero.perseus.core.session.AppSessionManager;
import com.deliveryhero.perseus.core.session.ClientIdProvider;
import com.deliveryhero.perseus.data.local.db.entity.HitEvent;
import com.deliveryhero.perseus.data.local.db.entity.HitEventFactory;
import com.deliveryhero.perseus.data.remote.api.model.HitDetails;
import com.deliveryhero.perseus.data.remote.api.model.HitsRequest;
import com.deliveryhero.perseus.utils.EventVariablesJsonSerializer;
import com.deliveryhero.perseus.utils.TimeHelperKt;
import com.facebook.internal.NativeProtocol;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ$\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\u0016\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00120\u0019H\u0016J\u001c\u0010\u0016\u001a\u00020\u00172\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u0014H\u0016J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001c*\u0004\u0018\u00010\u0015H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/deliveryhero/perseus/hits/usecase/PerseusHitsRequestProviderImpl;", "Lcom/deliveryhero/perseus/hits/usecase/PerseusHitsRequestProvider;", "appSessionManager", "Lcom/deliveryhero/perseus/core/session/AppSessionManager;", "clientIdProvider", "Lcom/deliveryhero/perseus/core/session/ClientIdProvider;", "perseusConfigProvider", "Lcom/deliveryhero/perseus/core/config/PerseusConfigProvider;", "factory", "Lcom/deliveryhero/perseus/data/local/db/entity/HitEventFactory;", "deviceInfoProvider", "Lcom/deliveryhero/perseus/core/deviceinfo/DeviceInfoProvider;", "clock", "Ljava/util/Calendar;", "(Lcom/deliveryhero/perseus/core/session/AppSessionManager;Lcom/deliveryhero/perseus/core/session/ClientIdProvider;Lcom/deliveryhero/perseus/core/config/PerseusConfigProvider;Lcom/deliveryhero/perseus/data/local/db/entity/HitEventFactory;Lcom/deliveryhero/perseus/core/deviceinfo/DeviceInfoProvider;Ljava/util/Calendar;)V", "createHitDetails", "Lcom/deliveryhero/perseus/data/remote/api/model/HitDetails;", "hitEvent", "Lcom/deliveryhero/perseus/data/local/db/entity/HitEvent;", "eventVariables", "", "", "provideRequestParams", "Lcom/deliveryhero/perseus/data/remote/api/model/HitsRequest;", "hits", "", "params", "fromStringRepresentation", "Lcom/deliveryhero/perseus/Consent;", "perseus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PerseusHitsRequestProviderImpl implements PerseusHitsRequestProvider {
    @NotNull
    private final AppSessionManager appSessionManager;
    @NotNull
    private final ClientIdProvider clientIdProvider;
    @NotNull
    private final Calendar clock;
    @NotNull
    private final DeviceInfoProvider deviceInfoProvider;
    @NotNull
    private final HitEventFactory factory;
    @NotNull
    private final PerseusConfigProvider perseusConfigProvider;

    public PerseusHitsRequestProviderImpl(@NotNull AppSessionManager appSessionManager2, @NotNull ClientIdProvider clientIdProvider2, @NotNull PerseusConfigProvider perseusConfigProvider2, @NotNull HitEventFactory hitEventFactory, @NotNull DeviceInfoProvider deviceInfoProvider2, @NotNull Calendar calendar) {
        Intrinsics.checkNotNullParameter(appSessionManager2, "appSessionManager");
        Intrinsics.checkNotNullParameter(clientIdProvider2, "clientIdProvider");
        Intrinsics.checkNotNullParameter(perseusConfigProvider2, "perseusConfigProvider");
        Intrinsics.checkNotNullParameter(hitEventFactory, "factory");
        Intrinsics.checkNotNullParameter(deviceInfoProvider2, "deviceInfoProvider");
        Intrinsics.checkNotNullParameter(calendar, "clock");
        this.appSessionManager = appSessionManager2;
        this.clientIdProvider = clientIdProvider2;
        this.perseusConfigProvider = perseusConfigProvider2;
        this.factory = hitEventFactory;
        this.deviceInfoProvider = deviceInfoProvider2;
        this.clock = calendar;
    }

    private final HitDetails createHitDetails(HitEvent hitEvent, Map<String, String> map) {
        boolean z11;
        String str;
        Consent consent;
        Long l11;
        String payloadTimeStamp = hitEvent.getPayloadTimeStamp();
        String createTimeStamp = TimeHelperKt.createTimeStamp(this.clock);
        String country = hitEvent.getCountry();
        String advertisingId = hitEvent.getAdvertisingId();
        String appId = hitEvent.getAppId();
        String appName = hitEvent.getAppName();
        String appVersionCode = hitEvent.getAppVersionCode();
        String adjustId = hitEvent.getAdjustId();
        String str2 = Build.VERSION.SDK_INT + '.' + Build.BRAND + '.' + Build.MANUFACTURER + '.' + Build.MODEL;
        String userId = hitEvent.getUserId();
        String uaId = hitEvent.getUaId();
        String clientId = hitEvent.getClientId();
        String sessionId = hitEvent.getSessionId();
        String sdkVersionName = hitEvent.getSdkVersionName();
        String globalEntityId = hitEvent.getGlobalEntityId();
        if (globalEntityId == null || globalEntityId.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            str = null;
        } else {
            str = hitEvent.getGlobalEntityId();
        }
        String consent2 = hitEvent.getConsent();
        if (consent2 != null) {
            consent = fromStringRepresentation(consent2);
        } else {
            consent = null;
        }
        if (hitEvent.getSessionOffset() == 0) {
            l11 = null;
        } else {
            l11 = Long.valueOf(hitEvent.getSessionOffset());
        }
        return new HitDetails("Android", payloadTimeStamp, createTimeStamp, country, advertisingId, appId, appName, appVersionCode, adjustId, str2, userId, uaId, clientId, sessionId, sdkVersionName, str, consent, l11, this.deviceInfoProvider.getDeviceInfo(), this.deviceInfoProvider.getOperatingSystemVersion(), this.deviceInfoProvider.getScreenResolution(), this.deviceInfoProvider.getMarketingName(), this.deviceInfoProvider.getDeviceModel(), this.deviceInfoProvider.getDeviceBrand(), map);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: com.deliveryhero.perseus.Consent} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: com.deliveryhero.perseus.Consent} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.deliveryhero.perseus.Consent} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: com.deliveryhero.perseus.Consent} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.deliveryhero.perseus.Consent fromStringRepresentation(java.lang.String r5) {
        /*
            r4 = this;
            r0 = 0
            if (r5 != 0) goto L_0x0004
            goto L_0x002c
        L_0x0004:
            com.deliveryhero.perseus.Consent[] r1 = com.deliveryhero.perseus.Consent.values()
            java.util.List r1 = kotlin.collections.ArraysKt___ArraysJvmKt.asList((T[]) r1)
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L_0x0012:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x002a
            java.lang.Object r2 = r1.next()
            r3 = r2
            com.deliveryhero.perseus.Consent r3 = (com.deliveryhero.perseus.Consent) r3
            java.lang.String r3 = r3.getStringRepresentation()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r3 == 0) goto L_0x0012
            r0 = r2
        L_0x002a:
            com.deliveryhero.perseus.Consent r0 = (com.deliveryhero.perseus.Consent) r0
        L_0x002c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.perseus.hits.usecase.PerseusHitsRequestProviderImpl.fromStringRepresentation(java.lang.String):com.deliveryhero.perseus.Consent");
    }

    @NotNull
    public HitsRequest provideRequestParams(@NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, NativeProtocol.WEB_DIALOG_PARAMS);
        long timeInMillis = this.clock.getTimeInMillis();
        ArrayList arrayList = new ArrayList();
        PerseusParamsConfig provideConfig = this.perseusConfigProvider.provideConfig();
        HitEventFactory hitEventFactory = this.factory;
        Date time = this.clock.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "clock.time");
        arrayList.add(createHitDetails(hitEventFactory.createEventHit(time, timeInMillis, provideConfig, this.appSessionManager, this.clientIdProvider, map), map));
        return new HitsRequest(arrayList);
    }

    @NotNull
    public HitsRequest provideRequestParams(@NotNull List<HitEvent> list) {
        Intrinsics.checkNotNullParameter(list, "hits");
        ArrayList arrayList = new ArrayList();
        for (HitEvent hitEvent : list) {
            arrayList.add(createHitDetails(hitEvent, EventVariablesJsonSerializer.INSTANCE.fromJson(hitEvent.getEventVariables())));
        }
        return new HitsRequest(arrayList);
    }
}
