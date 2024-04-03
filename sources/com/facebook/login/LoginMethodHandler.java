package com.facebook.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import com.apptimize.fb;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.AuthenticationToken;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.FacebookServiceException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.login.LoginClient;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import com.tekartik.sqflite.Constant;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b'\u0018\u0000 52\u00020\u0001:\u00015B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0014\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001c\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\b\u0010\u001a\u001a\u00020\u0016H\u0016J\u0010\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\rH\u0014J\b\u0010\u001d\u001a\u00020\rH\u0014J\u0012\u0010\u001e\u001a\u00020\u00162\b\u0010\u001f\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010 \u001a\u00020!H\u0016J\"\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0018\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020)H\u0014J\u0010\u0010-\u001a\u00020\u00162\u0006\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u00020!H\u0016J\u0010\u00101\u001a\u00020$2\u0006\u0010*\u001a\u00020+H&J\u0018\u00102\u001a\u00020\u00162\u0006\u00103\u001a\u00020\u00062\u0006\u00104\u001a\u00020$H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0004R,\u0010\u000b\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u00066"}, d2 = {"Lcom/facebook/login/LoginMethodHandler;", "Landroid/os/Parcelable;", "loginClient", "Lcom/facebook/login/LoginClient;", "(Lcom/facebook/login/LoginClient;)V", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getLoginClient", "()Lcom/facebook/login/LoginClient;", "setLoginClient", "methodLoggingExtras", "", "", "getMethodLoggingExtras", "()Ljava/util/Map;", "setMethodLoggingExtras", "(Ljava/util/Map;)V", "nameForLogging", "getNameForLogging", "()Ljava/lang/String;", "addLoggingExtra", "", "key", "value", "", "cancel", "getClientState", "authId", "getRedirectUrl", "logWebLoginCompleted", "e2e", "needsInternetPermission", "", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "processCodeExchange", "Landroid/os/Bundle;", "request", "Lcom/facebook/login/LoginClient$Request;", "values", "putChallengeParam", "param", "Lorg/json/JSONObject;", "shouldKeepTrackOfMultipleIntents", "tryAuthorize", "writeToParcel", "dest", "flags", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@VisibleForTesting(otherwise = 3)
public abstract class LoginMethodHandler implements Parcelable {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String NO_SIGNED_REQUEST_ERROR_MESSAGE = "Authorization response does not contain the signed_request";
    @NotNull
    public static final String NO_USER_ID_ERROR_MESSAGE = "Failed to retrieve user_id from signed_request";
    @NotNull
    public static final String USER_CANCELED_LOG_IN_ERROR_MESSAGE = "User canceled log in.";
    public LoginClient loginClient;
    @Nullable
    private Map<String, String> methodLoggingExtras;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u0004H\u0007J6\u0010\u000e\u001a\u0004\u0018\u00010\b2\u0010\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00102\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u0004H\u0007J\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0007J\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00122\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010\u0015\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/facebook/login/LoginMethodHandler$Companion;", "", "()V", "NO_SIGNED_REQUEST_ERROR_MESSAGE", "", "NO_USER_ID_ERROR_MESSAGE", "USER_CANCELED_LOG_IN_ERROR_MESSAGE", "createAccessTokenFromNativeLogin", "Lcom/facebook/AccessToken;", "bundle", "Landroid/os/Bundle;", "source", "Lcom/facebook/AccessTokenSource;", "applicationId", "createAccessTokenFromWebBundle", "requestedPermissions", "", "createAuthenticationTokenFromNativeLogin", "Lcom/facebook/AuthenticationToken;", "expectedNonce", "createAuthenticationTokenFromWebBundle", "getUserIDFromSignedRequest", "signedRequest", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @Nullable
        public final AccessToken createAccessTokenFromNativeLogin(@NotNull Bundle bundle, @Nullable AccessTokenSource accessTokenSource, @NotNull String str) {
            boolean z11;
            String string;
            Bundle bundle2 = bundle;
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(str, "applicationId");
            Utility utility = Utility.INSTANCE;
            Date bundleLongAsDate = Utility.getBundleLongAsDate(bundle, NativeProtocol.EXTRA_EXPIRES_SECONDS_SINCE_EPOCH, new Date(0));
            ArrayList<String> stringArrayList = bundle.getStringArrayList(NativeProtocol.EXTRA_PERMISSIONS);
            String string2 = bundle.getString(NativeProtocol.EXTRA_ACCESS_TOKEN);
            Date bundleLongAsDate2 = Utility.getBundleLongAsDate(bundle, NativeProtocol.EXTRA_DATA_ACCESS_EXPIRATION_TIME, new Date(0));
            if (string2 != null) {
                boolean z12 = true;
                if (string2.length() == 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (!z11 && (string = bundle.getString(NativeProtocol.EXTRA_USER_ID)) != null) {
                    if (string.length() != 0) {
                        z12 = false;
                    }
                    if (!z12) {
                        return new AccessToken(string2, str, string, stringArrayList, (Collection<String>) null, (Collection<String>) null, accessTokenSource, bundleLongAsDate, new Date(), bundleLongAsDate2, bundle.getString("graph_domain"));
                    }
                }
            }
            return null;
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x0080  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x00bf  */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x00fb A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x00fc  */
        @org.jetbrains.annotations.Nullable
        @kotlin.jvm.JvmStatic
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.facebook.AccessToken createAccessTokenFromWebBundle(@org.jetbrains.annotations.Nullable java.util.Collection<java.lang.String> r20, @org.jetbrains.annotations.NotNull android.os.Bundle r21, @org.jetbrains.annotations.Nullable com.facebook.AccessTokenSource r22, @org.jetbrains.annotations.NotNull java.lang.String r23) throws com.facebook.FacebookException {
            /*
                r19 = this;
                r0 = r21
                java.lang.String r1 = "bundle"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
                java.lang.String r1 = "applicationId"
                r4 = r23
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r1)
                com.facebook.internal.Utility r1 = com.facebook.internal.Utility.INSTANCE
                java.util.Date r1 = new java.util.Date
                r1.<init>()
                java.lang.String r2 = "expires_in"
                java.util.Date r10 = com.facebook.internal.Utility.getBundleLongAsDate(r0, r2, r1)
                java.lang.String r1 = "access_token"
                java.lang.String r3 = r0.getString(r1)
                r1 = 0
                if (r3 != 0) goto L_0x0025
                return r1
            L_0x0025:
                java.util.Date r2 = new java.util.Date
                r5 = 0
                r2.<init>(r5)
                java.lang.String r5 = "data_access_expiration_time"
                java.util.Date r12 = com.facebook.internal.Utility.getBundleLongAsDate(r0, r5, r2)
                java.lang.String r2 = "granted_scopes"
                java.lang.String r13 = r0.getString(r2)
                java.lang.String r2 = "null cannot be cast to non-null type kotlin.Array<T>"
                java.lang.String r5 = ","
                r6 = 1
                r7 = 0
                if (r13 == 0) goto L_0x0076
                int r8 = r13.length()
                if (r8 <= 0) goto L_0x0048
                r8 = r6
                goto L_0x0049
            L_0x0048:
                r8 = r7
            L_0x0049:
                if (r8 == 0) goto L_0x0076
                java.lang.String[] r14 = new java.lang.String[]{r5}
                r15 = 0
                r16 = 0
                r17 = 6
                r18 = 0
                java.util.List r8 = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) r13, (java.lang.String[]) r14, (boolean) r15, (int) r16, (int) r17, (java.lang.Object) r18)
                java.util.Collection r8 = (java.util.Collection) r8
                java.lang.String[] r9 = new java.lang.String[r7]
                java.lang.Object[] r8 = r8.toArray(r9)
                if (r8 == 0) goto L_0x0070
                java.lang.String[] r8 = (java.lang.String[]) r8
                int r9 = r8.length
                java.lang.Object[] r8 = java.util.Arrays.copyOf(r8, r9)
                java.util.ArrayList r8 = kotlin.collections.CollectionsKt__CollectionsKt.arrayListOf(r8)
                goto L_0x0078
            L_0x0070:
                java.lang.NullPointerException r0 = new java.lang.NullPointerException
                r0.<init>(r2)
                throw r0
            L_0x0076:
                r8 = r20
            L_0x0078:
                java.lang.String r9 = "denied_scopes"
                java.lang.String r13 = r0.getString(r9)
                if (r13 == 0) goto L_0x00b6
                int r9 = r13.length()
                if (r9 <= 0) goto L_0x0088
                r9 = r6
                goto L_0x0089
            L_0x0088:
                r9 = r7
            L_0x0089:
                if (r9 == 0) goto L_0x00b6
                java.lang.String[] r14 = new java.lang.String[]{r5}
                r15 = 0
                r16 = 0
                r17 = 6
                r18 = 0
                java.util.List r9 = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) r13, (java.lang.String[]) r14, (boolean) r15, (int) r16, (int) r17, (java.lang.Object) r18)
                java.util.Collection r9 = (java.util.Collection) r9
                java.lang.String[] r11 = new java.lang.String[r7]
                java.lang.Object[] r9 = r9.toArray(r11)
                if (r9 == 0) goto L_0x00b0
                java.lang.String[] r9 = (java.lang.String[]) r9
                int r11 = r9.length
                java.lang.Object[] r9 = java.util.Arrays.copyOf(r9, r11)
                java.util.ArrayList r9 = kotlin.collections.CollectionsKt__CollectionsKt.arrayListOf(r9)
                goto L_0x00b7
            L_0x00b0:
                java.lang.NullPointerException r0 = new java.lang.NullPointerException
                r0.<init>(r2)
                throw r0
            L_0x00b6:
                r9 = r1
            L_0x00b7:
                java.lang.String r11 = "expired_scopes"
                java.lang.String r13 = r0.getString(r11)
                if (r13 == 0) goto L_0x00f4
                int r11 = r13.length()
                if (r11 <= 0) goto L_0x00c6
                goto L_0x00c7
            L_0x00c6:
                r6 = r7
            L_0x00c7:
                if (r6 == 0) goto L_0x00f4
                java.lang.String[] r14 = new java.lang.String[]{r5}
                r15 = 0
                r16 = 0
                r17 = 6
                r18 = 0
                java.util.List r5 = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) r13, (java.lang.String[]) r14, (boolean) r15, (int) r16, (int) r17, (java.lang.Object) r18)
                java.util.Collection r5 = (java.util.Collection) r5
                java.lang.String[] r6 = new java.lang.String[r7]
                java.lang.Object[] r5 = r5.toArray(r6)
                if (r5 == 0) goto L_0x00ee
                java.lang.String[] r5 = (java.lang.String[]) r5
                int r2 = r5.length
                java.lang.Object[] r2 = java.util.Arrays.copyOf(r5, r2)
                java.util.ArrayList r2 = kotlin.collections.CollectionsKt__CollectionsKt.arrayListOf(r2)
                goto L_0x00f5
            L_0x00ee:
                java.lang.NullPointerException r0 = new java.lang.NullPointerException
                r0.<init>(r2)
                throw r0
            L_0x00f4:
                r2 = r1
            L_0x00f5:
                boolean r5 = com.facebook.internal.Utility.isNullOrEmpty((java.lang.String) r3)
                if (r5 == 0) goto L_0x00fc
                return r1
            L_0x00fc:
                java.lang.String r1 = "graph_domain"
                java.lang.String r13 = r0.getString(r1)
                java.lang.String r1 = "signed_request"
                java.lang.String r0 = r0.getString(r1)
                r1 = r19
                java.lang.String r5 = r1.getUserIDFromSignedRequest(r0)
                com.facebook.AccessToken r0 = new com.facebook.AccessToken
                r7 = r9
                java.util.Collection r7 = (java.util.Collection) r7
                r9 = r2
                java.util.Collection r9 = (java.util.Collection) r9
                java.util.Date r11 = new java.util.Date
                r11.<init>()
                r2 = r0
                r4 = r23
                r6 = r8
                r8 = r9
                r9 = r22
                r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.login.LoginMethodHandler.Companion.createAccessTokenFromWebBundle(java.util.Collection, android.os.Bundle, com.facebook.AccessTokenSource, java.lang.String):com.facebook.AccessToken");
        }

        @JvmStatic
        @Nullable
        public final AuthenticationToken createAuthenticationTokenFromNativeLogin(@NotNull Bundle bundle, @Nullable String str) throws FacebookException {
            boolean z11;
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            String string = bundle.getString(NativeProtocol.EXTRA_AUTHENTICATION_TOKEN);
            if (string != null) {
                boolean z12 = true;
                if (string.length() == 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (!z11 && str != null) {
                    if (str.length() != 0) {
                        z12 = false;
                    }
                    if (!z12) {
                        try {
                            return new AuthenticationToken(string, str);
                        } catch (Exception e11) {
                            throw new FacebookException(e11.getMessage());
                        }
                    }
                }
            }
            return null;
        }

        @JvmStatic
        @Nullable
        public final AuthenticationToken createAuthenticationTokenFromWebBundle(@NotNull Bundle bundle, @Nullable String str) throws FacebookException {
            boolean z11;
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            String string = bundle.getString("id_token");
            if (string != null) {
                boolean z12 = true;
                if (string.length() == 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (!z11 && str != null) {
                    if (str.length() != 0) {
                        z12 = false;
                    }
                    if (!z12) {
                        try {
                            return new AuthenticationToken(string, str);
                        } catch (Exception e11) {
                            throw new FacebookException(e11.getMessage(), (Throwable) e11);
                        }
                    }
                }
            }
            return null;
        }

        @JvmStatic
        @NotNull
        public final String getUserIDFromSignedRequest(@Nullable String str) throws FacebookException {
            boolean z11;
            if (str != null) {
                if (str.length() == 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (!z11) {
                    try {
                        Object[] array = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{RealDiscoveryConfigurationRepository.VERSION_DELIMETER}, false, 0, 6, (Object) null).toArray(new String[0]);
                        if (array != null) {
                            String[] strArr = (String[]) array;
                            if (strArr.length == 2) {
                                byte[] decode = Base64.decode(strArr[1], 0);
                                Intrinsics.checkNotNullExpressionValue(decode, "data");
                                String string = new JSONObject(new String(decode, Charsets.UTF_8)).getString("user_id");
                                Intrinsics.checkNotNullExpressionValue(string, "jsonObject.getString(\"user_id\")");
                                return string;
                            }
                            throw new FacebookException(LoginMethodHandler.NO_USER_ID_ERROR_MESSAGE);
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    } catch (UnsupportedEncodingException | JSONException unused) {
                    }
                }
            }
            throw new FacebookException(LoginMethodHandler.NO_SIGNED_REQUEST_ERROR_MESSAGE);
        }
    }

    public LoginMethodHandler(@NotNull LoginClient loginClient2) {
        Intrinsics.checkNotNullParameter(loginClient2, "loginClient");
        setLoginClient(loginClient2);
    }

    @JvmStatic
    @Nullable
    public static final AccessToken createAccessTokenFromNativeLogin(@NotNull Bundle bundle, @Nullable AccessTokenSource accessTokenSource, @NotNull String str) {
        return Companion.createAccessTokenFromNativeLogin(bundle, accessTokenSource, str);
    }

    @Nullable
    @JvmStatic
    public static final AccessToken createAccessTokenFromWebBundle(@Nullable Collection<String> collection, @NotNull Bundle bundle, @Nullable AccessTokenSource accessTokenSource, @NotNull String str) throws FacebookException {
        return Companion.createAccessTokenFromWebBundle(collection, bundle, accessTokenSource, str);
    }

    @JvmStatic
    @Nullable
    public static final AuthenticationToken createAuthenticationTokenFromNativeLogin(@NotNull Bundle bundle, @Nullable String str) throws FacebookException {
        return Companion.createAuthenticationTokenFromNativeLogin(bundle, str);
    }

    @JvmStatic
    @Nullable
    public static final AuthenticationToken createAuthenticationTokenFromWebBundle(@NotNull Bundle bundle, @Nullable String str) throws FacebookException {
        return Companion.createAuthenticationTokenFromWebBundle(bundle, str);
    }

    @JvmStatic
    @NotNull
    public static final String getUserIDFromSignedRequest(@Nullable String str) throws FacebookException {
        return Companion.getUserIDFromSignedRequest(str);
    }

    public void addLoggingExtra(@Nullable String str, @Nullable Object obj) {
        String str2;
        if (this.methodLoggingExtras == null) {
            this.methodLoggingExtras = new HashMap();
        }
        Map<String, String> map = this.methodLoggingExtras;
        if (map != null) {
            if (obj == null) {
                str2 = null;
            } else {
                str2 = obj.toString();
            }
            String put = map.put(str, str2);
        }
    }

    public void cancel() {
    }

    @NotNull
    public String getClientState(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "authId");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LoginLogger.EVENT_PARAM_AUTH_LOGGER_ID, (Object) str);
            jSONObject.put(LoginLogger.EVENT_PARAM_METHOD, (Object) getNameForLogging());
            putChallengeParam(jSONObject);
        } catch (JSONException e11) {
            Log.w("LoginMethodHandler", Intrinsics.stringPlus("Error creating client state json: ", e11.getMessage()));
        }
        String jSONObjectInstrumentation = JSONObjectInstrumentation.toString(jSONObject);
        Intrinsics.checkNotNullExpressionValue(jSONObjectInstrumentation, "param.toString()");
        return jSONObjectInstrumentation;
    }

    @NotNull
    public final LoginClient getLoginClient() {
        LoginClient loginClient2 = this.loginClient;
        if (loginClient2 != null) {
            return loginClient2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("loginClient");
        throw null;
    }

    @Nullable
    public final Map<String, String> getMethodLoggingExtras() {
        return this.methodLoggingExtras;
    }

    @NotNull
    public abstract String getNameForLogging();

    @NotNull
    public String getRedirectUrl() {
        return fb.f42395a + FacebookSdk.getApplicationId() + "://authorize/";
    }

    public void logWebLoginCompleted(@Nullable String str) {
        String str2;
        LoginClient.Request pendingRequest = getLoginClient().getPendingRequest();
        if (pendingRequest == null) {
            str2 = null;
        } else {
            str2 = pendingRequest.getApplicationId();
        }
        if (str2 == null) {
            str2 = FacebookSdk.getApplicationId();
        }
        InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(getLoginClient().getActivity(), str2);
        Bundle bundle = new Bundle();
        bundle.putString(AnalyticsEvents.PARAMETER_WEB_LOGIN_E2E, str);
        bundle.putLong(AnalyticsEvents.PARAMETER_WEB_LOGIN_SWITCHBACK_TIME, System.currentTimeMillis());
        bundle.putString("app_id", str2);
        internalAppEventsLogger.logEventImplicitly(AnalyticsEvents.EVENT_WEB_LOGIN_COMPLETE, (Double) null, bundle);
    }

    public boolean needsInternetPermission() {
        return false;
    }

    public boolean onActivityResult(int i11, int i12, @Nullable Intent intent) {
        return false;
    }

    @NotNull
    public Bundle processCodeExchange(@NotNull LoginClient.Request request, @NotNull Bundle bundle) throws FacebookException {
        GraphRequest graphRequest;
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(bundle, "values");
        String string = bundle.getString(Constant.PARAM_ERROR_CODE);
        if (!Utility.isNullOrEmpty(string)) {
            String str = null;
            if (string == null) {
                graphRequest = null;
            } else {
                PKCEUtil pKCEUtil = PKCEUtil.INSTANCE;
                String redirectUrl = getRedirectUrl();
                String codeVerifier = request.getCodeVerifier();
                if (codeVerifier == null) {
                    codeVerifier = "";
                }
                graphRequest = PKCEUtil.createCodeExchangeRequest(string, redirectUrl, codeVerifier);
            }
            if (graphRequest != null) {
                GraphResponse executeAndWait = graphRequest.executeAndWait();
                FacebookRequestError error = executeAndWait.getError();
                if (error == null) {
                    try {
                        JSONObject jSONObject = executeAndWait.getJSONObject();
                        if (jSONObject != null) {
                            str = jSONObject.getString("access_token");
                        }
                        if (jSONObject == null || Utility.isNullOrEmpty(str)) {
                            throw new FacebookException("No access token found from result");
                        }
                        bundle.putString("access_token", str);
                        if (jSONObject.has("id_token")) {
                            bundle.putString("id_token", jSONObject.getString("id_token"));
                        }
                        return bundle;
                    } catch (JSONException e11) {
                        throw new FacebookException(Intrinsics.stringPlus("Fail to process code exchange response: ", e11.getMessage()));
                    }
                } else {
                    throw new FacebookServiceException(error, error.getErrorMessage());
                }
            } else {
                throw new FacebookException("Failed to create code exchange request");
            }
        } else {
            throw new FacebookException("No code param found from the request");
        }
    }

    public void putChallengeParam(@NotNull JSONObject jSONObject) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, RemoteMessageConst.MessageBody.PARAM);
    }

    public final void setLoginClient(@NotNull LoginClient loginClient2) {
        Intrinsics.checkNotNullParameter(loginClient2, "<set-?>");
        this.loginClient = loginClient2;
    }

    public final void setMethodLoggingExtras(@Nullable Map<String, String> map) {
        this.methodLoggingExtras = map;
    }

    public boolean shouldKeepTrackOfMultipleIntents() {
        return false;
    }

    public abstract int tryAuthorize(@NotNull LoginClient.Request request);

    public void writeToParcel(@NotNull Parcel parcel, int i11) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        Utility utility = Utility.INSTANCE;
        Utility.writeStringMapToParcel(parcel, this.methodLoggingExtras);
    }

    public LoginMethodHandler(@NotNull Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "source");
        Map<String, String> readStringMapFromParcel = Utility.readStringMapFromParcel(parcel);
        this.methodLoggingExtras = readStringMapFromParcel == null ? null : MapsKt__MapsKt.toMutableMap(readStringMapFromParcel);
    }
}
