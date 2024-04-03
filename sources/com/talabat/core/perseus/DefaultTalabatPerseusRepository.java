package com.talabat.core.perseus;

import android.content.Context;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.talabat.configuration.country.Country;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.context.domain.ApplicationContext;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.perseus.domain.TalabatPerseusRepository;
import com.talabat.core.tracking.data.constant.ConstantsKt;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.perseus.TalabatPerseus;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\b\u0018\u00002\u00020\u0001B!\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJh\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\u001e\u0010\"\u001a\u00020\u00142\u0014\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020%\u0018\u00010$H\u0016J\b\u0010&\u001a\u00020\fH\u0016J\b\u0010'\u001a\u00020\fH\u0017J\b\u0010(\u001a\u00020\fH\u0016J\b\u0010)\u001a\u00020\fH\u0016J\b\u0010*\u001a\u00020\fH\u0016J$\u0010+\u001a\u00020\u00142\u0006\u0010,\u001a\u00020\f2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0.H\u0016J\u0010\u0010/\u001a\u00020\u00142\u0006\u00100\u001a\u00020\fH\u0016J\u0010\u00101\u001a\u00020\u00142\u0006\u00102\u001a\u00020\fH\u0016J\u0010\u00103\u001a\u00020\u00142\u0006\u00104\u001a\u00020 H\u0016J\u0010\u00105\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\fXD¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\fXD¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\fXD¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u00066"}, d2 = {"Lcom/talabat/core/perseus/DefaultTalabatPerseusRepository;", "Lcom/talabat/core/perseus/domain/TalabatPerseusRepository;", "context", "Landroid/content/Context;", "appVersionProvider", "Lcom/talabat/configuration/discovery/AppVersionProvider;", "dispatchersFactory", "Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;", "(Landroid/content/Context;Lcom/talabat/configuration/discovery/AppVersionProvider;Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;)V", "getContext", "()Landroid/content/Context;", "perseusClientIdKey", "", "getPerseusClientIdKey", "()Ljava/lang/String;", "perseusHitMatchIdKey", "getPerseusHitMatchIdKey", "perseusSessionIdKey", "getPerseusSessionIdKey", "configurePerseus", "", "appName", "appId", "entity", "appVersionName", "debuggable", "", "baseUrl", "uaId", "advertisingId", "adjustId", "country", "Lcom/talabat/configuration/country/Country;", "userId", "dispatchPerseusEvent", "eventVarsJsonObj", "", "", "generateHitMatchId", "generateSessionId", "getMyClientId", "getMySessionId", "getPerseusHitMatchId", "sendEvent", "perseusEventName", "finalAttributes", "", "setAdjustId", "adId", "setAdvertisingId", "googleAdId", "setCountry", "selectedCountry", "setUserId", "com_talabat_core_perseus_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DefaultTalabatPerseusRepository implements TalabatPerseusRepository {
    @NotNull
    private final AppVersionProvider appVersionProvider;
    @NotNull
    private final Context context;
    @NotNull
    private final CoroutineDispatchersFactory dispatchersFactory;
    @NotNull
    private final String perseusClientIdKey = "perseusClientId";
    @NotNull
    private final String perseusHitMatchIdKey = "perseusHitMatchId";
    @NotNull
    private final String perseusSessionIdKey = "perseusSessionId";

    @Inject
    public DefaultTalabatPerseusRepository(@NotNull @ApplicationContext Context context2, @NotNull AppVersionProvider appVersionProvider2, @NotNull CoroutineDispatchersFactory coroutineDispatchersFactory) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(appVersionProvider2, "appVersionProvider");
        Intrinsics.checkNotNullParameter(coroutineDispatchersFactory, "dispatchersFactory");
        this.context = context2;
        this.appVersionProvider = appVersionProvider2;
        this.dispatchersFactory = coroutineDispatchersFactory;
    }

    public void configurePerseus(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, boolean z11, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull Country country, @NotNull String str9, @NotNull Context context2) {
        String str10 = str;
        Intrinsics.checkNotNullParameter(str10, AnalyticsAttribute.APP_NAME_ATTRIBUTE);
        String str11 = str2;
        Intrinsics.checkNotNullParameter(str11, "appId");
        String str12 = str3;
        Intrinsics.checkNotNullParameter(str12, "entity");
        String str13 = str4;
        Intrinsics.checkNotNullParameter(str13, "appVersionName");
        String str14 = str5;
        Intrinsics.checkNotNullParameter(str14, "baseUrl");
        String str15 = str6;
        Intrinsics.checkNotNullParameter(str15, "uaId");
        String str16 = str7;
        Intrinsics.checkNotNullParameter(str16, ConstantsKt.GOOGLE_AD_ID);
        String str17 = str8;
        Intrinsics.checkNotNullParameter(str17, "adjustId");
        Country country2 = country;
        Intrinsics.checkNotNullParameter(country2, "country");
        String str18 = str9;
        Intrinsics.checkNotNullParameter(str18, "userId");
        Context context3 = context2;
        Intrinsics.checkNotNullParameter(context3, "context");
        TalabatPerseus.Companion.configurePerseus(str10, str11, str12, str13, z11, str14, str15, str16, str17, country2, str18, this.dispatchersFactory, context3);
    }

    public void dispatchPerseusEvent(@Nullable Map<String, Object> map) {
        String appVersion = this.appVersionProvider.appVersion();
        if (appVersion == null) {
            appVersion = "";
        }
        TalabatPerseus.Companion.dispatchPerseusEvent(this.context, appVersion, map);
    }

    @NotNull
    public String generateHitMatchId() {
        return TalabatPerseus.Companion.getHitMatchId();
    }

    @NotNull
    @Deprecated(message = "Generation of Id is on Perseus SDK side now", replaceWith = @ReplaceWith(expression = "getMySessionId()", imports = {"tracking.perseus.TalabatPerseus.Companion.getMySessionId"}))
    public String generateSessionId() {
        return TalabatPerseus.Companion.generateSessionId();
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @NotNull
    public String getMyClientId() {
        return TalabatPerseus.Companion.getMyClientId(this.context);
    }

    @NotNull
    public String getMySessionId() {
        return TalabatPerseus.Companion.getMySessionId();
    }

    @NotNull
    public String getPerseusClientIdKey() {
        return this.perseusClientIdKey;
    }

    @NotNull
    public String getPerseusHitMatchId() {
        return TalabatPerseus.Companion.getHitMatchId();
    }

    @NotNull
    public String getPerseusHitMatchIdKey() {
        return this.perseusHitMatchIdKey;
    }

    @NotNull
    public String getPerseusSessionIdKey() {
        return this.perseusSessionIdKey;
    }

    public void sendEvent(@NotNull String str, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "perseusEventName");
        Intrinsics.checkNotNullParameter(map, "finalAttributes");
        TalabatPerseus.Companion.sendEvent(str, map);
    }

    public void setAdjustId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "adId");
        TalabatPerseus.Companion.setAdjustId(str);
    }

    public void setAdvertisingId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "googleAdId");
        TalabatPerseus.Companion.setAdvertisingId(str);
    }

    public void setCountry(@NotNull Country country) {
        Intrinsics.checkNotNullParameter(country, "selectedCountry");
        TalabatPerseus.Companion.setCountry(country);
    }

    public void setUserId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "userId");
        TalabatPerseus.Companion.setUserId(str);
    }
}
