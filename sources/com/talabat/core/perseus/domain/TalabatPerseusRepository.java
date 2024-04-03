package com.talabat.core.perseus.domain;

import android.content.Context;
import com.talabat.configuration.country.Country;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\b\bf\u0018\u00002\u00020\u0001Jh\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001aH&J\u001e\u0010\u001b\u001a\u00020\u000b2\u0014\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001dH&J\b\u0010\u001e\u001a\u00020\u0003H&J\b\u0010\u001f\u001a\u00020\u0003H&J\b\u0010 \u001a\u00020\u0003H&J\b\u0010!\u001a\u00020\u0003H&J\b\u0010\"\u001a\u00020\u0003H&J$\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u00032\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030&H&J\u0010\u0010'\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u0003H&J\u0010\u0010)\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u0003H&J\u0010\u0010+\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u0017H&J\u0010\u0010-\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0003H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005¨\u0006."}, d2 = {"Lcom/talabat/core/perseus/domain/TalabatPerseusRepository;", "", "perseusClientIdKey", "", "getPerseusClientIdKey", "()Ljava/lang/String;", "perseusHitMatchIdKey", "getPerseusHitMatchIdKey", "perseusSessionIdKey", "getPerseusSessionIdKey", "configurePerseus", "", "appName", "appId", "entity", "appVersionName", "debuggable", "", "baseUrl", "uaId", "advertisingId", "adjustId", "country", "Lcom/talabat/configuration/country/Country;", "userId", "context", "Landroid/content/Context;", "dispatchPerseusEvent", "eventVarsJsonObj", "", "generateHitMatchId", "generateSessionId", "getMyClientId", "getMySessionId", "getPerseusHitMatchId", "sendEvent", "perseusEventName", "finalAttributes", "", "setAdjustId", "adId", "setAdvertisingId", "googleAdId", "setCountry", "selectedCountry", "setUserId", "com_talabat_core_perseus_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface TalabatPerseusRepository {
    void configurePerseus(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, boolean z11, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull Country country, @NotNull String str9, @NotNull Context context);

    void dispatchPerseusEvent(@Nullable Map<String, Object> map);

    @NotNull
    String generateHitMatchId();

    @NotNull
    String generateSessionId();

    @NotNull
    String getMyClientId();

    @NotNull
    String getMySessionId();

    @NotNull
    String getPerseusClientIdKey();

    @NotNull
    String getPerseusHitMatchId();

    @NotNull
    String getPerseusHitMatchIdKey();

    @NotNull
    String getPerseusSessionIdKey();

    void sendEvent(@NotNull String str, @NotNull Map<String, String> map);

    void setAdjustId(@NotNull String str);

    void setAdvertisingId(@NotNull String str);

    void setCountry(@NotNull Country country);

    void setUserId(@NotNull String str);
}
