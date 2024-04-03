package com.talabat.perseus;

import android.content.Context;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.talabat.core.fwf.data.FunWithFlagsConstants;
import com.talabat.core.tracking.data.constant.ConstantsKt;
import com.talabat.perseus.config.PerseusConfigProvider;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010$\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jn\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006J\b\u0010\u0015\u001a\u00020\u0006H\u0007J\b\u0010\u0016\u001a\u00020\u0006H\u0007J\b\u0010\u0017\u001a\u00020\u0006H\u0007J$\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00062\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u001bH\u0007J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0006H\u0007J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0006H\u0007J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0006H\u0007¨\u0006\""}, d2 = {"Lcom/talabat/perseus/Perseus;", "", "()V", "configurePerseus", "", "adjustId", "", "advertisingId", "appId", "appName", "appVersionName", "baseUrl", "context", "Landroid/content/Context;", "countryCode", "debuggable", "", "globalEntityId", "entity", "uaId", "userId", "getPerseusClientId", "getPerseusHitMatchId", "getPerseusSessionId", "sendEvent", "perseusEventName", "perseusParams", "", "setAdjustId", "setAdvertisingId", "setCountry", "selectedCountryIso", "setGlobalEntityId", "setUserId", "com_talabat_ThirdPartyLibs_Perseus_Perseus"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Perseus {
    @NotNull
    public static final Perseus INSTANCE = new Perseus();

    private Perseus() {
    }

    @JvmStatic
    @NotNull
    public static final String getPerseusClientId() {
        if (PerseusFacade.isSdkInitialized()) {
            return PerseusFacade.getPerseusClientId();
        }
        throw new PerseusNotConfiguredException();
    }

    @JvmStatic
    @NotNull
    public static final String getPerseusHitMatchId() {
        if (PerseusFacade.isSdkInitialized()) {
            return PerseusFacade.generatePerseusHitMatchId();
        }
        throw new PerseusNotConfiguredException();
    }

    @JvmStatic
    @NotNull
    public static final String getPerseusSessionId() {
        if (PerseusFacade.isSdkInitialized()) {
            return PerseusFacade.getPerseusSessionId();
        }
        throw new PerseusNotConfiguredException();
    }

    @JvmStatic
    public static final void sendEvent(@NotNull String str, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "perseusEventName");
        Intrinsics.checkNotNullParameter(map, "perseusParams");
        if (PerseusFacade.isSdkInitialized()) {
            PerseusFacade.sendEvent(str, map);
            return;
        }
        throw new PerseusNotConfiguredException();
    }

    @JvmStatic
    public static final void setAdjustId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "adjustId");
        if (PerseusFacade.isSdkInitialized()) {
            PerseusFacade.setAdjustId(str);
            return;
        }
        throw new PerseusNotConfiguredException();
    }

    @JvmStatic
    public static final void setAdvertisingId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, ConstantsKt.GOOGLE_AD_ID);
        if (PerseusFacade.isSdkInitialized()) {
            PerseusFacade.setAdvertisingId(str);
            return;
        }
        throw new PerseusNotConfiguredException();
    }

    @JvmStatic
    public static final void setCountry(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "selectedCountryIso");
        if (PerseusFacade.isSdkInitialized()) {
            PerseusFacade.setCountry(str);
            return;
        }
        throw new PerseusNotConfiguredException();
    }

    @JvmStatic
    public static final void setGlobalEntityId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, FunWithFlagsConstants.ATTRIBUTE_GLOBAL_ENTITY_ID);
        if (PerseusFacade.isSdkInitialized()) {
            PerseusFacade.setGlobalEntityId(str);
            return;
        }
        throw new PerseusNotConfiguredException();
    }

    @JvmStatic
    public static final void setUserId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "userId");
        if (PerseusFacade.isSdkInitialized()) {
            PerseusFacade.setUserId(str);
            return;
        }
        throw new PerseusNotConfiguredException();
    }

    public final void configurePerseus(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull Context context, @NotNull String str7, boolean z11, @NotNull String str8, @NotNull String str9, @NotNull String str10, @NotNull String str11) {
        String str12 = str;
        String str13 = str2;
        Context context2 = context;
        String str14 = str7;
        String str15 = str11;
        Intrinsics.checkNotNullParameter(str12, "adjustId");
        Intrinsics.checkNotNullParameter(str13, ConstantsKt.GOOGLE_AD_ID);
        String str16 = str3;
        Intrinsics.checkNotNullParameter(str16, "appId");
        String str17 = str4;
        Intrinsics.checkNotNullParameter(str17, AnalyticsAttribute.APP_NAME_ATTRIBUTE);
        String str18 = str5;
        Intrinsics.checkNotNullParameter(str18, "appVersionName");
        String str19 = str6;
        Intrinsics.checkNotNullParameter(str19, "baseUrl");
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(str14, "countryCode");
        String str20 = str8;
        Intrinsics.checkNotNullParameter(str20, FunWithFlagsConstants.ATTRIBUTE_GLOBAL_ENTITY_ID);
        String str21 = str9;
        Intrinsics.checkNotNullParameter(str21, "entity");
        String str22 = str10;
        Intrinsics.checkNotNullParameter(str22, "uaId");
        Intrinsics.checkNotNullParameter(str15, "userId");
        PerseusFacade.configurePerseus(new PerseusConfigProvider(str16, str17, str18, str19, z11, str21, str20, str22).create(str12, str13, str14, str15), context2);
    }
}
