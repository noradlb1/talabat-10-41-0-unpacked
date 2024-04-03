package com.facebook;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0000\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001b\u001cB\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u0004\u0018\u00010\tJ\u000e\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\tJ\b\u0010\u001a\u001a\u00020\u0016H\u0002R\u0016\u0010\b\u001a\u0004\u0018\u00010\t8BX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u0004\u0018\u00010\t8BX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000f8CX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/facebook/AccessTokenCache;", "", "()V", "sharedPreferences", "Landroid/content/SharedPreferences;", "tokenCachingStrategyFactory", "Lcom/facebook/AccessTokenCache$SharedPreferencesTokenCachingStrategyFactory;", "(Landroid/content/SharedPreferences;Lcom/facebook/AccessTokenCache$SharedPreferencesTokenCachingStrategyFactory;)V", "cachedAccessToken", "Lcom/facebook/AccessToken;", "getCachedAccessToken", "()Lcom/facebook/AccessToken;", "legacyAccessToken", "getLegacyAccessToken", "tokenCachingStrategy", "Lcom/facebook/LegacyTokenHelper;", "getTokenCachingStrategy", "()Lcom/facebook/LegacyTokenHelper;", "tokenCachingStrategyField", "clear", "", "hasCachedAccessToken", "", "load", "save", "accessToken", "shouldCheckLegacyToken", "Companion", "SharedPreferencesTokenCachingStrategyFactory", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class AccessTokenCache {
    @NotNull
    public static final String CACHED_ACCESS_TOKEN_KEY = "com.facebook.AccessTokenManager.CachedAccessToken";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final SharedPreferences sharedPreferences;
    @NotNull
    private final SharedPreferencesTokenCachingStrategyFactory tokenCachingStrategyFactory;
    @Nullable
    private LegacyTokenHelper tokenCachingStrategyField;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/facebook/AccessTokenCache$Companion;", "", "()V", "CACHED_ACCESS_TOKEN_KEY", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/facebook/AccessTokenCache$SharedPreferencesTokenCachingStrategyFactory;", "", "()V", "create", "Lcom/facebook/LegacyTokenHelper;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class SharedPreferencesTokenCachingStrategyFactory {
        @NotNull
        public final LegacyTokenHelper create() {
            return new LegacyTokenHelper(FacebookSdk.getApplicationContext(), (String) null, 2, (DefaultConstructorMarker) null);
        }
    }

    public AccessTokenCache(@NotNull SharedPreferences sharedPreferences2, @NotNull SharedPreferencesTokenCachingStrategyFactory sharedPreferencesTokenCachingStrategyFactory) {
        Intrinsics.checkNotNullParameter(sharedPreferences2, "sharedPreferences");
        Intrinsics.checkNotNullParameter(sharedPreferencesTokenCachingStrategyFactory, "tokenCachingStrategyFactory");
        this.sharedPreferences = sharedPreferences2;
        this.tokenCachingStrategyFactory = sharedPreferencesTokenCachingStrategyFactory;
    }

    private final AccessToken getCachedAccessToken() {
        String string = this.sharedPreferences.getString(CACHED_ACCESS_TOKEN_KEY, (String) null);
        if (string == null) {
            return null;
        }
        try {
            return AccessToken.Companion.createFromJSONObject$facebook_core_release(new JSONObject(string));
        } catch (JSONException unused) {
            return null;
        }
    }

    private final AccessToken getLegacyAccessToken() {
        Bundle load = getTokenCachingStrategy().load();
        if (load == null || !LegacyTokenHelper.Companion.hasTokenInformation(load)) {
            return null;
        }
        return AccessToken.Companion.createFromLegacyCache$facebook_core_release(load);
    }

    @AutoHandleExceptions
    private final LegacyTokenHelper getTokenCachingStrategy() {
        if (this.tokenCachingStrategyField == null) {
            synchronized (this) {
                if (this.tokenCachingStrategyField == null) {
                    this.tokenCachingStrategyField = this.tokenCachingStrategyFactory.create();
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        LegacyTokenHelper legacyTokenHelper = this.tokenCachingStrategyField;
        if (legacyTokenHelper != null) {
            return legacyTokenHelper;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    private final boolean hasCachedAccessToken() {
        return this.sharedPreferences.contains(CACHED_ACCESS_TOKEN_KEY);
    }

    private final boolean shouldCheckLegacyToken() {
        return FacebookSdk.isLegacyTokenUpgradeSupported();
    }

    public final void clear() {
        this.sharedPreferences.edit().remove(CACHED_ACCESS_TOKEN_KEY).apply();
        if (shouldCheckLegacyToken()) {
            getTokenCachingStrategy().clear();
        }
    }

    @Nullable
    public final AccessToken load() {
        if (hasCachedAccessToken()) {
            return getCachedAccessToken();
        }
        if (!shouldCheckLegacyToken()) {
            return null;
        }
        AccessToken legacyAccessToken = getLegacyAccessToken();
        if (legacyAccessToken == null) {
            return legacyAccessToken;
        }
        save(legacyAccessToken);
        getTokenCachingStrategy().clear();
        return legacyAccessToken;
    }

    public final void save(@NotNull AccessToken accessToken) {
        String str;
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        try {
            JSONObject jSONObject$facebook_core_release = accessToken.toJSONObject$facebook_core_release();
            SharedPreferences.Editor edit = this.sharedPreferences.edit();
            if (!(jSONObject$facebook_core_release instanceof JSONObject)) {
                str = jSONObject$facebook_core_release.toString();
            } else {
                str = JSONObjectInstrumentation.toString(jSONObject$facebook_core_release);
            }
            edit.putString(CACHED_ACCESS_TOKEN_KEY, str).apply();
        } catch (JSONException unused) {
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AccessTokenCache() {
        /*
            r3 = this;
            android.content.Context r0 = com.facebook.FacebookSdk.getApplicationContext()
            java.lang.String r1 = "com.facebook.AccessTokenManager.SharedPreferences"
            r2 = 0
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r1, r2)
            java.lang.String r1 = "FacebookSdk.getApplicationContext()\n              .getSharedPreferences(\n                  AccessTokenManager.SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            com.facebook.AccessTokenCache$SharedPreferencesTokenCachingStrategyFactory r1 = new com.facebook.AccessTokenCache$SharedPreferencesTokenCachingStrategyFactory
            r1.<init>()
            r3.<init>(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.AccessTokenCache.<init>():void");
    }
}
