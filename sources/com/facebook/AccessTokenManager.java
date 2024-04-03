package com.facebook;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.internal.Utility;
import com.huawei.hms.push.AttributionReporter;
import com.visa.checkout.Profile;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import k6.a;
import k6.b;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.time.DateUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 !2\u00020\u0001:\u0005!\"#$%B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0014J\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\u0012\u0010\u001b\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\u001c\u0010\u001c\u001a\u00020\u00142\b\u0010\u001d\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u001a\u0010\f\u001a\u00020\u00142\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001e\u001a\u00020\u0017H\u0002J\b\u0010\u001f\u001a\u00020\u0014H\u0002J\b\u0010 \u001a\u00020\u0017H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R(\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8F@FX\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/facebook/AccessTokenManager;", "", "localBroadcastManager", "Landroidx/localbroadcastmanager/content/LocalBroadcastManager;", "accessTokenCache", "Lcom/facebook/AccessTokenCache;", "(Landroidx/localbroadcastmanager/content/LocalBroadcastManager;Lcom/facebook/AccessTokenCache;)V", "value", "Lcom/facebook/AccessToken;", "currentAccessToken", "getCurrentAccessToken", "()Lcom/facebook/AccessToken;", "setCurrentAccessToken", "(Lcom/facebook/AccessToken;)V", "currentAccessTokenField", "lastAttemptedTokenExtendDate", "Ljava/util/Date;", "tokenRefreshInProgress", "Ljava/util/concurrent/atomic/AtomicBoolean;", "currentAccessTokenChanged", "", "extendAccessTokenIfNeeded", "loadCurrentAccessToken", "", "refreshCurrentAccessToken", "callback", "Lcom/facebook/AccessToken$AccessTokenRefreshCallback;", "refreshCurrentAccessTokenImpl", "sendCurrentAccessTokenChangedBroadcastIntent", "oldAccessToken", "saveToCache", "setTokenExpirationBroadcastAlarm", "shouldExtendAccessToken", "Companion", "FacebookRefreshTokenInfo", "InstagramRefreshTokenInfo", "RefreshResult", "RefreshTokenInfo", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class AccessTokenManager {
    @NotNull
    public static final String ACTION_CURRENT_ACCESS_TOKEN_CHANGED = "com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String EXTRA_NEW_ACCESS_TOKEN = "com.facebook.sdk.EXTRA_NEW_ACCESS_TOKEN";
    @NotNull
    public static final String EXTRA_OLD_ACCESS_TOKEN = "com.facebook.sdk.EXTRA_OLD_ACCESS_TOKEN";
    @NotNull
    private static final String ME_PERMISSIONS_GRAPH_PATH = "me/permissions";
    @NotNull
    public static final String SHARED_PREFERENCES_NAME = "com.facebook.AccessTokenManager.SharedPreferences";
    @NotNull
    public static final String TAG = "AccessTokenManager";
    private static final int TOKEN_EXTEND_RETRY_SECONDS = 3600;
    private static final int TOKEN_EXTEND_THRESHOLD_SECONDS = 86400;
    /* access modifiers changed from: private */
    @Nullable
    public static AccessTokenManager instanceField;
    @NotNull
    private final AccessTokenCache accessTokenCache;
    @Nullable
    private AccessToken currentAccessTokenField;
    @NotNull
    private Date lastAttemptedTokenExtendDate = new Date(0);
    @NotNull
    private final LocalBroadcastManager localBroadcastManager;
    @NotNull
    private final AtomicBoolean tokenRefreshInProgress = new AtomicBoolean(false);

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u000eH\u0007J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/facebook/AccessTokenManager$Companion;", "", "()V", "ACTION_CURRENT_ACCESS_TOKEN_CHANGED", "", "EXTRA_NEW_ACCESS_TOKEN", "EXTRA_OLD_ACCESS_TOKEN", "ME_PERMISSIONS_GRAPH_PATH", "SHARED_PREFERENCES_NAME", "TAG", "TOKEN_EXTEND_RETRY_SECONDS", "", "TOKEN_EXTEND_THRESHOLD_SECONDS", "instanceField", "Lcom/facebook/AccessTokenManager;", "createExtendAccessTokenRequest", "Lcom/facebook/GraphRequest;", "accessToken", "Lcom/facebook/AccessToken;", "callback", "Lcom/facebook/GraphRequest$Callback;", "createGrantedPermissionsRequest", "getInstance", "getRefreshTokenInfoForToken", "Lcom/facebook/AccessTokenManager$RefreshTokenInfo;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final GraphRequest createExtendAccessTokenRequest(AccessToken accessToken, GraphRequest.Callback callback) {
            RefreshTokenInfo refreshTokenInfoForToken = getRefreshTokenInfoForToken(accessToken);
            Bundle bundle = new Bundle();
            bundle.putString("grant_type", refreshTokenInfoForToken.getGrantType());
            bundle.putString("client_id", accessToken.getApplicationId());
            bundle.putString("fields", "access_token,expires_at,expires_in,data_access_expiration_time,graph_domain");
            GraphRequest newGraphPathRequest = GraphRequest.Companion.newGraphPathRequest(accessToken, refreshTokenInfoForToken.getGraphPath(), callback);
            newGraphPathRequest.setParameters(bundle);
            newGraphPathRequest.setHttpMethod(HttpMethod.GET);
            return newGraphPathRequest;
        }

        /* access modifiers changed from: private */
        public final GraphRequest createGrantedPermissionsRequest(AccessToken accessToken, GraphRequest.Callback callback) {
            Bundle bundle = new Bundle();
            bundle.putString("fields", "permission,status");
            GraphRequest newGraphPathRequest = GraphRequest.Companion.newGraphPathRequest(accessToken, AccessTokenManager.ME_PERMISSIONS_GRAPH_PATH, callback);
            newGraphPathRequest.setParameters(bundle);
            newGraphPathRequest.setHttpMethod(HttpMethod.GET);
            return newGraphPathRequest;
        }

        private final RefreshTokenInfo getRefreshTokenInfoForToken(AccessToken accessToken) {
            String graphDomain = accessToken.getGraphDomain();
            if (graphDomain == null) {
                graphDomain = AccessToken.DEFAULT_GRAPH_DOMAIN;
            }
            if (Intrinsics.areEqual((Object) graphDomain, (Object) FacebookSdk.INSTAGRAM)) {
                return new InstagramRefreshTokenInfo();
            }
            return new FacebookRefreshTokenInfo();
        }

        @JvmStatic
        @NotNull
        public final AccessTokenManager getInstance() {
            AccessTokenManager access$getInstanceField$cp;
            AccessTokenManager access$getInstanceField$cp2 = AccessTokenManager.instanceField;
            if (access$getInstanceField$cp2 != null) {
                return access$getInstanceField$cp2;
            }
            synchronized (this) {
                access$getInstanceField$cp = AccessTokenManager.instanceField;
                if (access$getInstanceField$cp == null) {
                    LocalBroadcastManager instance = LocalBroadcastManager.getInstance(FacebookSdk.getApplicationContext());
                    Intrinsics.checkNotNullExpressionValue(instance, "getInstance(applicationContext)");
                    AccessTokenManager accessTokenManager = new AccessTokenManager(instance, new AccessTokenCache());
                    AccessTokenManager.instanceField = accessTokenManager;
                    access$getInstanceField$cp = accessTokenManager;
                }
            }
            return access$getInstanceField$cp;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/facebook/AccessTokenManager$FacebookRefreshTokenInfo;", "Lcom/facebook/AccessTokenManager$RefreshTokenInfo;", "()V", "grantType", "", "getGrantType", "()Ljava/lang/String;", "graphPath", "getGraphPath", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class FacebookRefreshTokenInfo implements RefreshTokenInfo {
        @NotNull
        private final String grantType = "fb_extend_sso_token";
        @NotNull
        private final String graphPath = "oauth/access_token";

        @NotNull
        public String getGrantType() {
            return this.grantType;
        }

        @NotNull
        public String getGraphPath() {
            return this.graphPath;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/facebook/AccessTokenManager$InstagramRefreshTokenInfo;", "Lcom/facebook/AccessTokenManager$RefreshTokenInfo;", "()V", "grantType", "", "getGrantType", "()Ljava/lang/String;", "graphPath", "getGraphPath", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class InstagramRefreshTokenInfo implements RefreshTokenInfo {
        @NotNull
        private final String grantType = "ig_refresh_token";
        @NotNull
        private final String graphPath = "refresh_access_token";

        @NotNull
        public String getGrantType() {
            return this.grantType;
        }

        @NotNull
        public String getGraphPath() {
            return this.graphPath;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\b¨\u0006\u001c"}, d2 = {"Lcom/facebook/AccessTokenManager$RefreshResult;", "", "()V", "accessToken", "", "getAccessToken", "()Ljava/lang/String;", "setAccessToken", "(Ljava/lang/String;)V", "dataAccessExpirationTime", "", "getDataAccessExpirationTime", "()Ljava/lang/Long;", "setDataAccessExpirationTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "expiresAt", "", "getExpiresAt", "()I", "setExpiresAt", "(I)V", "expiresIn", "getExpiresIn", "setExpiresIn", "graphDomain", "getGraphDomain", "setGraphDomain", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class RefreshResult {
        @Nullable
        private String accessToken;
        @Nullable
        private Long dataAccessExpirationTime;
        private int expiresAt;
        private int expiresIn;
        @Nullable
        private String graphDomain;

        @Nullable
        public final String getAccessToken() {
            return this.accessToken;
        }

        @Nullable
        public final Long getDataAccessExpirationTime() {
            return this.dataAccessExpirationTime;
        }

        public final int getExpiresAt() {
            return this.expiresAt;
        }

        public final int getExpiresIn() {
            return this.expiresIn;
        }

        @Nullable
        public final String getGraphDomain() {
            return this.graphDomain;
        }

        public final void setAccessToken(@Nullable String str) {
            this.accessToken = str;
        }

        public final void setDataAccessExpirationTime(@Nullable Long l11) {
            this.dataAccessExpirationTime = l11;
        }

        public final void setExpiresAt(int i11) {
            this.expiresAt = i11;
        }

        public final void setExpiresIn(int i11) {
            this.expiresIn = i11;
        }

        public final void setGraphDomain(@Nullable String str) {
            this.graphDomain = str;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/facebook/AccessTokenManager$RefreshTokenInfo;", "", "grantType", "", "getGrantType", "()Ljava/lang/String;", "graphPath", "getGraphPath", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface RefreshTokenInfo {
        @NotNull
        String getGrantType();

        @NotNull
        String getGraphPath();
    }

    public AccessTokenManager(@NotNull LocalBroadcastManager localBroadcastManager2, @NotNull AccessTokenCache accessTokenCache2) {
        Intrinsics.checkNotNullParameter(localBroadcastManager2, "localBroadcastManager");
        Intrinsics.checkNotNullParameter(accessTokenCache2, "accessTokenCache");
        this.localBroadcastManager = localBroadcastManager2;
        this.accessTokenCache = accessTokenCache2;
    }

    @JvmStatic
    @NotNull
    public static final AccessTokenManager getInstance() {
        return Companion.getInstance();
    }

    /* access modifiers changed from: private */
    /* renamed from: refreshCurrentAccessToken$lambda-0  reason: not valid java name */
    public static final void m8855refreshCurrentAccessToken$lambda0(AccessTokenManager accessTokenManager, AccessToken.AccessTokenRefreshCallback accessTokenRefreshCallback) {
        Intrinsics.checkNotNullParameter(accessTokenManager, "this$0");
        accessTokenManager.refreshCurrentAccessTokenImpl(accessTokenRefreshCallback);
    }

    private final void refreshCurrentAccessTokenImpl(AccessToken.AccessTokenRefreshCallback accessTokenRefreshCallback) {
        AccessToken currentAccessToken = getCurrentAccessToken();
        if (currentAccessToken == null) {
            if (accessTokenRefreshCallback != null) {
                accessTokenRefreshCallback.OnTokenRefreshFailed(new FacebookException("No current access token to refresh"));
            }
        } else if (this.tokenRefreshInProgress.compareAndSet(false, true)) {
            this.lastAttemptedTokenExtendDate = new Date();
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            HashSet hashSet3 = new HashSet();
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            RefreshResult refreshResult = new RefreshResult();
            Companion companion = Companion;
            GraphRequestBatch graphRequestBatch = new GraphRequestBatch(companion.createGrantedPermissionsRequest(currentAccessToken, new b(atomicBoolean, hashSet, hashSet2, hashSet3)), companion.createExtendAccessTokenRequest(currentAccessToken, new a(refreshResult)));
            graphRequestBatch.addCallback(new b(refreshResult, currentAccessToken, accessTokenRefreshCallback, atomicBoolean, hashSet, hashSet2, hashSet3, this));
            graphRequestBatch.executeAsync();
        } else if (accessTokenRefreshCallback != null) {
            accessTokenRefreshCallback.OnTokenRefreshFailed(new FacebookException("Refresh already in progress"));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: refreshCurrentAccessTokenImpl$lambda-1  reason: not valid java name */
    public static final void m8856refreshCurrentAccessTokenImpl$lambda1(AtomicBoolean atomicBoolean, Set set, Set set2, Set set3, GraphResponse graphResponse) {
        JSONArray optJSONArray;
        Intrinsics.checkNotNullParameter(atomicBoolean, "$permissionsCallSucceeded");
        Intrinsics.checkNotNullParameter(set, "$permissions");
        Intrinsics.checkNotNullParameter(set2, "$declinedPermissions");
        Intrinsics.checkNotNullParameter(set3, "$expiredPermissions");
        Intrinsics.checkNotNullParameter(graphResponse, "response");
        JSONObject jsonObject = graphResponse.getJsonObject();
        if (jsonObject != null && (optJSONArray = jsonObject.optJSONArray("data")) != null) {
            atomicBoolean.set(true);
            int length = optJSONArray.length();
            if (length > 0) {
                int i11 = 0;
                while (true) {
                    int i12 = i11 + 1;
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i11);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString(AttributionReporter.SYSTEM_PERMISSION);
                        String optString2 = optJSONObject.optString("status");
                        if (!Utility.isNullOrEmpty(optString) && !Utility.isNullOrEmpty(optString2)) {
                            Intrinsics.checkNotNullExpressionValue(optString2, "status");
                            Locale locale = Locale.US;
                            Intrinsics.checkNotNullExpressionValue(locale, Profile.Country.US);
                            String lowerCase = optString2.toLowerCase(locale);
                            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                            Intrinsics.checkNotNullExpressionValue(lowerCase, "status");
                            int hashCode = lowerCase.hashCode();
                            if (hashCode != -1309235419) {
                                if (hashCode != 280295099) {
                                    if (hashCode == 568196142 && lowerCase.equals("declined")) {
                                        set2.add(optString);
                                    }
                                } else if (lowerCase.equals("granted")) {
                                    set.add(optString);
                                }
                            } else if (lowerCase.equals("expired")) {
                                set3.add(optString);
                            }
                            Log.w(TAG, Intrinsics.stringPlus("Unexpected status: ", lowerCase));
                        }
                    }
                    if (i12 < length) {
                        i11 = i12;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: refreshCurrentAccessTokenImpl$lambda-2  reason: not valid java name */
    public static final void m8857refreshCurrentAccessTokenImpl$lambda2(RefreshResult refreshResult, GraphResponse graphResponse) {
        Intrinsics.checkNotNullParameter(refreshResult, "$refreshResult");
        Intrinsics.checkNotNullParameter(graphResponse, "response");
        JSONObject jsonObject = graphResponse.getJsonObject();
        if (jsonObject != null) {
            refreshResult.setAccessToken(jsonObject.optString("access_token"));
            refreshResult.setExpiresAt(jsonObject.optInt("expires_at"));
            refreshResult.setExpiresIn(jsonObject.optInt(AccessToken.EXPIRES_IN_KEY));
            refreshResult.setDataAccessExpirationTime(Long.valueOf(jsonObject.optLong(AccessToken.DATA_ACCESS_EXPIRATION_TIME)));
            refreshResult.setGraphDomain(jsonObject.optString("graph_domain", (String) null));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: refreshCurrentAccessTokenImpl$lambda-3  reason: not valid java name */
    public static final void m8858refreshCurrentAccessTokenImpl$lambda3(RefreshResult refreshResult, AccessToken accessToken, AccessToken.AccessTokenRefreshCallback accessTokenRefreshCallback, AtomicBoolean atomicBoolean, Set set, Set set2, Set set3, AccessTokenManager accessTokenManager, GraphRequestBatch graphRequestBatch) {
        AccessToken accessToken2;
        String str;
        Set<String> set4;
        Set<String> set5;
        Set<String> set6;
        Date date;
        AccessToken.AccessTokenRefreshCallback accessTokenRefreshCallback2 = accessTokenRefreshCallback;
        AccessTokenManager accessTokenManager2 = accessTokenManager;
        Intrinsics.checkNotNullParameter(refreshResult, "$refreshResult");
        Intrinsics.checkNotNullParameter(atomicBoolean, "$permissionsCallSucceeded");
        Set set7 = set;
        Intrinsics.checkNotNullParameter(set7, "$permissions");
        Set set8 = set2;
        Intrinsics.checkNotNullParameter(set8, "$declinedPermissions");
        Set set9 = set3;
        Intrinsics.checkNotNullParameter(set9, "$expiredPermissions");
        Intrinsics.checkNotNullParameter(accessTokenManager2, "this$0");
        Intrinsics.checkNotNullParameter(graphRequestBatch, "it");
        String accessToken3 = refreshResult.getAccessToken();
        int expiresAt = refreshResult.getExpiresAt();
        Long dataAccessExpirationTime = refreshResult.getDataAccessExpirationTime();
        String graphDomain = refreshResult.getGraphDomain();
        try {
            Companion companion = Companion;
            if (companion.getInstance().getCurrentAccessToken() != null) {
                AccessToken currentAccessToken = companion.getInstance().getCurrentAccessToken();
                if (currentAccessToken == null) {
                    str = null;
                } else {
                    str = currentAccessToken.getUserId();
                }
                if (str == accessToken.getUserId()) {
                    if (!atomicBoolean.get() && accessToken3 == null && expiresAt == 0) {
                        if (accessTokenRefreshCallback2 != null) {
                            accessTokenRefreshCallback2.OnTokenRefreshFailed(new FacebookException("Failed to refresh access token"));
                        }
                        accessTokenManager2.tokenRefreshInProgress.set(false);
                        return;
                    }
                    Date expires = accessToken.getExpires();
                    if (refreshResult.getExpiresAt() != 0) {
                        expires = new Date(((long) refreshResult.getExpiresAt()) * 1000);
                    } else if (refreshResult.getExpiresIn() != 0) {
                        expires = new Date((((long) refreshResult.getExpiresIn()) * 1000) + new Date().getTime());
                    }
                    Date date2 = expires;
                    if (accessToken3 == null) {
                        accessToken3 = accessToken.getToken();
                    }
                    String str2 = accessToken3;
                    String applicationId = accessToken.getApplicationId();
                    String userId = accessToken.getUserId();
                    if (atomicBoolean.get()) {
                        set4 = set7;
                    } else {
                        set4 = accessToken.getPermissions();
                    }
                    if (atomicBoolean.get()) {
                        set5 = set8;
                    } else {
                        set5 = accessToken.getDeclinedPermissions();
                    }
                    if (atomicBoolean.get()) {
                        set6 = set9;
                    } else {
                        set6 = accessToken.getExpiredPermissions();
                    }
                    AccessTokenSource source = accessToken.getSource();
                    Date date3 = new Date();
                    if (dataAccessExpirationTime != null) {
                        date = new Date(dataAccessExpirationTime.longValue() * 1000);
                    } else {
                        date = accessToken.getDataAccessExpirationTime();
                    }
                    Date date4 = date;
                    if (graphDomain == null) {
                        graphDomain = accessToken.getGraphDomain();
                    }
                    AccessToken accessToken4 = new AccessToken(str2, applicationId, userId, set4, set5, set6, source, date2, date3, date4, graphDomain);
                    try {
                        companion.getInstance().setCurrentAccessToken(accessToken4);
                        accessTokenManager2.tokenRefreshInProgress.set(false);
                        if (accessTokenRefreshCallback2 != null) {
                            accessTokenRefreshCallback2.OnTokenRefreshed(accessToken4);
                            return;
                        }
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        accessToken2 = accessToken4;
                        accessTokenManager2.tokenRefreshInProgress.set(false);
                        if (!(accessTokenRefreshCallback2 == null || accessToken2 == null)) {
                            accessTokenRefreshCallback2.OnTokenRefreshed(accessToken2);
                        }
                        throw th;
                    }
                }
            }
            if (accessTokenRefreshCallback2 != null) {
                accessTokenRefreshCallback2.OnTokenRefreshFailed(new FacebookException("No current access token to refresh"));
            }
            accessTokenManager2.tokenRefreshInProgress.set(false);
        } catch (Throwable th3) {
            th = th3;
            accessToken2 = null;
            accessTokenManager2.tokenRefreshInProgress.set(false);
            accessTokenRefreshCallback2.OnTokenRefreshed(accessToken2);
            throw th;
        }
    }

    private final void sendCurrentAccessTokenChangedBroadcastIntent(AccessToken accessToken, AccessToken accessToken2) {
        Intent intent = new Intent(FacebookSdk.getApplicationContext(), CurrentAccessTokenExpirationBroadcastReceiver.class);
        intent.setAction(ACTION_CURRENT_ACCESS_TOKEN_CHANGED);
        intent.putExtra(EXTRA_OLD_ACCESS_TOKEN, accessToken);
        intent.putExtra(EXTRA_NEW_ACCESS_TOKEN, accessToken2);
        this.localBroadcastManager.sendBroadcast(intent);
    }

    private final void setTokenExpirationBroadcastAlarm() {
        Date date;
        Context applicationContext = FacebookSdk.getApplicationContext();
        AccessToken.Companion companion = AccessToken.Companion;
        AccessToken currentAccessToken = companion.getCurrentAccessToken();
        AlarmManager alarmManager = (AlarmManager) applicationContext.getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (companion.isCurrentAccessTokenActive()) {
            if (currentAccessToken == null) {
                date = null;
            } else {
                date = currentAccessToken.getExpires();
            }
            if (date != null && alarmManager != null) {
                Intent intent = new Intent(applicationContext, CurrentAccessTokenExpirationBroadcastReceiver.class);
                intent.setAction(ACTION_CURRENT_ACCESS_TOKEN_CHANGED);
                try {
                    alarmManager.set(1, currentAccessToken.getExpires().getTime(), PendingIntent.getBroadcast(applicationContext, 0, intent, 67108864));
                } catch (Exception unused) {
                }
            }
        }
    }

    private final boolean shouldExtendAccessToken() {
        AccessToken currentAccessToken = getCurrentAccessToken();
        if (currentAccessToken == null) {
            return false;
        }
        long time = new Date().getTime();
        if (!currentAccessToken.getSource().canExtendToken() || time - this.lastAttemptedTokenExtendDate.getTime() <= DateUtils.MILLIS_PER_HOUR || time - currentAccessToken.getLastRefresh().getTime() <= 86400000) {
            return false;
        }
        return true;
    }

    public final void currentAccessTokenChanged() {
        sendCurrentAccessTokenChangedBroadcastIntent(getCurrentAccessToken(), getCurrentAccessToken());
    }

    public final void extendAccessTokenIfNeeded() {
        if (shouldExtendAccessToken()) {
            refreshCurrentAccessToken((AccessToken.AccessTokenRefreshCallback) null);
        }
    }

    @Nullable
    public final AccessToken getCurrentAccessToken() {
        return this.currentAccessTokenField;
    }

    public final boolean loadCurrentAccessToken() {
        AccessToken load = this.accessTokenCache.load();
        if (load == null) {
            return false;
        }
        setCurrentAccessToken(load, false);
        return true;
    }

    public final void refreshCurrentAccessToken(@Nullable AccessToken.AccessTokenRefreshCallback accessTokenRefreshCallback) {
        if (Intrinsics.areEqual((Object) Looper.getMainLooper(), (Object) Looper.myLooper())) {
            refreshCurrentAccessTokenImpl(accessTokenRefreshCallback);
        } else {
            new Handler(Looper.getMainLooper()).post(new a(this, accessTokenRefreshCallback));
        }
    }

    public final void setCurrentAccessToken(@Nullable AccessToken accessToken) {
        setCurrentAccessToken(accessToken, true);
    }

    private final void setCurrentAccessToken(AccessToken accessToken, boolean z11) {
        AccessToken accessToken2 = this.currentAccessTokenField;
        this.currentAccessTokenField = accessToken;
        this.tokenRefreshInProgress.set(false);
        this.lastAttemptedTokenExtendDate = new Date(0);
        if (z11) {
            if (accessToken != null) {
                this.accessTokenCache.save(accessToken);
            } else {
                this.accessTokenCache.clear();
                Utility utility = Utility.INSTANCE;
                Utility.clearFacebookCookies(FacebookSdk.getApplicationContext());
            }
        }
        if (!Utility.areObjectsEqual(accessToken2, accessToken)) {
            sendCurrentAccessTokenChangedBroadcastIntent(accessToken2, accessToken);
            setTokenExpirationBroadcastAlarm();
        }
    }
}
