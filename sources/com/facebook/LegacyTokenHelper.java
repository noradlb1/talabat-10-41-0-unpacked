package com.facebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.facebook.internal.Logger;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u000e\u0010\u0010\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eJ \u0010\u0011\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/facebook/LegacyTokenHelper;", "", "context", "Landroid/content/Context;", "cacheKey", "", "(Landroid/content/Context;Ljava/lang/String;)V", "cache", "Landroid/content/SharedPreferences;", "clear", "", "deserializeKey", "key", "bundle", "Landroid/os/Bundle;", "load", "save", "serializeKey", "editor", "Landroid/content/SharedPreferences$Editor;", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class LegacyTokenHelper {
    @NotNull
    public static final String APPLICATION_ID_KEY = "com.facebook.TokenCachingStrategy.ApplicationId";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String DECLINED_PERMISSIONS_KEY = "com.facebook.TokenCachingStrategy.DeclinedPermissions";
    @NotNull
    public static final String DEFAULT_CACHE_KEY = "com.facebook.SharedPreferencesTokenCachingStrategy.DEFAULT_KEY";
    @NotNull
    public static final String EXPIRATION_DATE_KEY = "com.facebook.TokenCachingStrategy.ExpirationDate";
    @NotNull
    public static final String EXPIRED_PERMISSIONS_KEY = "com.facebook.TokenCachingStrategy.ExpiredPermissions";
    private static final long INVALID_BUNDLE_MILLISECONDS = Long.MIN_VALUE;
    @NotNull
    private static final String IS_SSO_KEY = "com.facebook.TokenCachingStrategy.IsSSO";
    @NotNull
    private static final String JSON_VALUE = "value";
    @NotNull
    private static final String JSON_VALUE_ENUM_TYPE = "enumType";
    @NotNull
    private static final String JSON_VALUE_TYPE = "valueType";
    @NotNull
    public static final String LAST_REFRESH_DATE_KEY = "com.facebook.TokenCachingStrategy.LastRefreshDate";
    @NotNull
    public static final String PERMISSIONS_KEY = "com.facebook.TokenCachingStrategy.Permissions";
    private static final String TAG = LegacyTokenHelper.class.getSimpleName();
    @NotNull
    public static final String TOKEN_KEY = "com.facebook.TokenCachingStrategy.Token";
    @NotNull
    public static final String TOKEN_SOURCE_KEY = "com.facebook.TokenCachingStrategy.AccessTokenSource";
    @NotNull
    private static final String TYPE_BOOLEAN = "bool";
    @NotNull
    private static final String TYPE_BOOLEAN_ARRAY = "bool[]";
    @NotNull
    private static final String TYPE_BYTE = "byte";
    @NotNull
    private static final String TYPE_BYTE_ARRAY = "byte[]";
    @NotNull
    private static final String TYPE_CHAR = "char";
    @NotNull
    private static final String TYPE_CHAR_ARRAY = "char[]";
    @NotNull
    private static final String TYPE_DOUBLE = "double";
    @NotNull
    private static final String TYPE_DOUBLE_ARRAY = "double[]";
    @NotNull
    private static final String TYPE_ENUM = "enum";
    @NotNull
    private static final String TYPE_FLOAT = "float";
    @NotNull
    private static final String TYPE_FLOAT_ARRAY = "float[]";
    @NotNull
    private static final String TYPE_INTEGER = "int";
    @NotNull
    private static final String TYPE_INTEGER_ARRAY = "int[]";
    @NotNull
    private static final String TYPE_LONG = "long";
    @NotNull
    private static final String TYPE_LONG_ARRAY = "long[]";
    @NotNull
    private static final String TYPE_SHORT = "short";
    @NotNull
    private static final String TYPE_SHORT_ARRAY = "short[]";
    @NotNull
    private static final String TYPE_STRING = "string";
    @NotNull
    private static final String TYPE_STRING_LIST = "stringList";
    @NotNull
    private final SharedPreferences cache;
    @NotNull
    private final String cacheKey;

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010(\u001a\u0004\u0018\u00010\u00042\u0006\u0010)\u001a\u00020*H\u0007J\u001e\u0010+\u001a\u0004\u0018\u00010,2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010-\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010.\u001a\u0004\u0018\u00010,2\u0006\u0010)\u001a\u00020*H\u0007J\u0010\u0010/\u001a\u00020\n2\u0006\u0010)\u001a\u00020*H\u0007J\u0012\u00100\u001a\u0004\u0018\u00010,2\u0006\u0010)\u001a\u00020*H\u0007J\u0010\u00101\u001a\u00020\n2\u0006\u0010)\u001a\u00020*H\u0007J\u0018\u00102\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001032\u0006\u0010)\u001a\u00020*H\u0007J\u0012\u00104\u001a\u0004\u0018\u0001052\u0006\u0010)\u001a\u00020*H\u0007J\u0012\u00106\u001a\u0004\u0018\u00010\u00042\u0006\u0010)\u001a\u00020*H\u0007J\u0012\u00107\u001a\u0002082\b\u0010)\u001a\u0004\u0018\u00010*H\u0007J\u001a\u00109\u001a\u00020:2\u0006\u0010)\u001a\u00020*2\b\u0010;\u001a\u0004\u0018\u00010\u0004H\u0007J\"\u0010<\u001a\u00020:2\u0006\u0010)\u001a\u00020*2\b\u0010-\u001a\u0004\u0018\u00010\u00042\u0006\u0010=\u001a\u00020,H\u0002J\u001e\u0010>\u001a\u00020:2\u0006\u0010)\u001a\u00020*2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00040?H\u0007J\u0018\u0010@\u001a\u00020:2\u0006\u0010)\u001a\u00020*2\u0006\u0010;\u001a\u00020,H\u0007J\u0018\u0010A\u001a\u00020:2\u0006\u0010)\u001a\u00020*2\u0006\u0010;\u001a\u00020\nH\u0007J\u001e\u0010B\u001a\u00020:2\u0006\u0010)\u001a\u00020*2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00040?H\u0007J\u0018\u0010C\u001a\u00020:2\u0006\u0010)\u001a\u00020*2\u0006\u0010;\u001a\u00020,H\u0007J\u0018\u0010D\u001a\u00020:2\u0006\u0010)\u001a\u00020*2\u0006\u0010;\u001a\u00020\nH\u0007J\u001e\u0010E\u001a\u00020:2\u0006\u0010)\u001a\u00020*2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00040?H\u0007J\u0018\u0010F\u001a\u00020:2\u0006\u0010)\u001a\u00020*2\u0006\u0010;\u001a\u000205H\u0007J\u0018\u0010G\u001a\u00020:2\u0006\u0010)\u001a\u00020*2\u0006\u0010;\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n \u0012*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lcom/facebook/LegacyTokenHelper$Companion;", "", "()V", "APPLICATION_ID_KEY", "", "DECLINED_PERMISSIONS_KEY", "DEFAULT_CACHE_KEY", "EXPIRATION_DATE_KEY", "EXPIRED_PERMISSIONS_KEY", "INVALID_BUNDLE_MILLISECONDS", "", "IS_SSO_KEY", "JSON_VALUE", "JSON_VALUE_ENUM_TYPE", "JSON_VALUE_TYPE", "LAST_REFRESH_DATE_KEY", "PERMISSIONS_KEY", "TAG", "kotlin.jvm.PlatformType", "TOKEN_KEY", "TOKEN_SOURCE_KEY", "TYPE_BOOLEAN", "TYPE_BOOLEAN_ARRAY", "TYPE_BYTE", "TYPE_BYTE_ARRAY", "TYPE_CHAR", "TYPE_CHAR_ARRAY", "TYPE_DOUBLE", "TYPE_DOUBLE_ARRAY", "TYPE_ENUM", "TYPE_FLOAT", "TYPE_FLOAT_ARRAY", "TYPE_INTEGER", "TYPE_INTEGER_ARRAY", "TYPE_LONG", "TYPE_LONG_ARRAY", "TYPE_SHORT", "TYPE_SHORT_ARRAY", "TYPE_STRING", "TYPE_STRING_LIST", "getApplicationId", "bundle", "Landroid/os/Bundle;", "getDate", "Ljava/util/Date;", "key", "getExpirationDate", "getExpirationMilliseconds", "getLastRefreshDate", "getLastRefreshMilliseconds", "getPermissions", "", "getSource", "Lcom/facebook/AccessTokenSource;", "getToken", "hasTokenInformation", "", "putApplicationId", "", "value", "putDate", "date", "putDeclinedPermissions", "", "putExpirationDate", "putExpirationMilliseconds", "putExpiredPermissions", "putLastRefreshDate", "putLastRefreshMilliseconds", "putPermissions", "putSource", "putToken", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Date getDate(Bundle bundle, String str) {
            if (bundle == null) {
                return null;
            }
            long j11 = bundle.getLong(str, Long.MIN_VALUE);
            if (j11 == Long.MIN_VALUE) {
                return null;
            }
            return new Date(j11);
        }

        private final void putDate(Bundle bundle, String str, Date date) {
            bundle.putLong(str, date.getTime());
        }

        @JvmStatic
        @Nullable
        public final String getApplicationId(@NotNull Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            return bundle.getString(LegacyTokenHelper.APPLICATION_ID_KEY);
        }

        @JvmStatic
        @Nullable
        public final Date getExpirationDate(@NotNull Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            return getDate(bundle, LegacyTokenHelper.EXPIRATION_DATE_KEY);
        }

        @JvmStatic
        public final long getExpirationMilliseconds(@NotNull Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            return bundle.getLong(LegacyTokenHelper.EXPIRATION_DATE_KEY);
        }

        @JvmStatic
        @Nullable
        public final Date getLastRefreshDate(@NotNull Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            return getDate(bundle, LegacyTokenHelper.LAST_REFRESH_DATE_KEY);
        }

        @JvmStatic
        public final long getLastRefreshMilliseconds(@NotNull Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            return bundle.getLong(LegacyTokenHelper.LAST_REFRESH_DATE_KEY);
        }

        @JvmStatic
        @Nullable
        public final Set<String> getPermissions(@NotNull Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            ArrayList<String> stringArrayList = bundle.getStringArrayList(LegacyTokenHelper.PERMISSIONS_KEY);
            if (stringArrayList == null) {
                return null;
            }
            return new HashSet(stringArrayList);
        }

        @JvmStatic
        @Nullable
        public final AccessTokenSource getSource(@NotNull Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            if (bundle.containsKey(LegacyTokenHelper.TOKEN_SOURCE_KEY)) {
                return (AccessTokenSource) bundle.getSerializable(LegacyTokenHelper.TOKEN_SOURCE_KEY);
            }
            if (bundle.getBoolean(LegacyTokenHelper.IS_SSO_KEY)) {
                return AccessTokenSource.FACEBOOK_APPLICATION_WEB;
            }
            return AccessTokenSource.WEB_VIEW;
        }

        @JvmStatic
        @Nullable
        public final String getToken(@NotNull Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            return bundle.getString(LegacyTokenHelper.TOKEN_KEY);
        }

        @JvmStatic
        public final boolean hasTokenInformation(@Nullable Bundle bundle) {
            String string;
            boolean z11;
            if (bundle == null || (string = bundle.getString(LegacyTokenHelper.TOKEN_KEY)) == null) {
                return false;
            }
            if (string.length() == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11 && bundle.getLong(LegacyTokenHelper.EXPIRATION_DATE_KEY, 0) != 0) {
                return true;
            }
            return false;
        }

        @JvmStatic
        public final void putApplicationId(@NotNull Bundle bundle, @Nullable String str) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            bundle.putString(LegacyTokenHelper.APPLICATION_ID_KEY, str);
        }

        @JvmStatic
        public final void putDeclinedPermissions(@NotNull Bundle bundle, @NotNull Collection<String> collection) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(collection, "value");
            bundle.putStringArrayList(LegacyTokenHelper.DECLINED_PERMISSIONS_KEY, new ArrayList(collection));
        }

        @JvmStatic
        public final void putExpirationDate(@NotNull Bundle bundle, @NotNull Date date) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(date, "value");
            putDate(bundle, LegacyTokenHelper.EXPIRATION_DATE_KEY, date);
        }

        @JvmStatic
        public final void putExpirationMilliseconds(@NotNull Bundle bundle, long j11) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            bundle.putLong(LegacyTokenHelper.EXPIRATION_DATE_KEY, j11);
        }

        @JvmStatic
        public final void putExpiredPermissions(@NotNull Bundle bundle, @NotNull Collection<String> collection) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(collection, "value");
            bundle.putStringArrayList(LegacyTokenHelper.EXPIRED_PERMISSIONS_KEY, new ArrayList(collection));
        }

        @JvmStatic
        public final void putLastRefreshDate(@NotNull Bundle bundle, @NotNull Date date) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(date, "value");
            putDate(bundle, LegacyTokenHelper.LAST_REFRESH_DATE_KEY, date);
        }

        @JvmStatic
        public final void putLastRefreshMilliseconds(@NotNull Bundle bundle, long j11) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            bundle.putLong(LegacyTokenHelper.LAST_REFRESH_DATE_KEY, j11);
        }

        @JvmStatic
        public final void putPermissions(@NotNull Bundle bundle, @NotNull Collection<String> collection) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(collection, "value");
            bundle.putStringArrayList(LegacyTokenHelper.PERMISSIONS_KEY, new ArrayList(collection));
        }

        @JvmStatic
        public final void putSource(@NotNull Bundle bundle, @NotNull AccessTokenSource accessTokenSource) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(accessTokenSource, "value");
            bundle.putSerializable(LegacyTokenHelper.TOKEN_SOURCE_KEY, accessTokenSource);
        }

        @JvmStatic
        public final void putToken(@NotNull Bundle bundle, @NotNull String str) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(str, "value");
            bundle.putString(LegacyTokenHelper.TOKEN_KEY, str);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LegacyTokenHelper(@NotNull Context context) {
        this(context, (String) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0014, code lost:
        if ((r4.length() == 0) != false) goto L_0x0016;
     */
    @kotlin.jvm.JvmOverloads
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public LegacyTokenHelper(@org.jetbrains.annotations.NotNull android.content.Context r3, @org.jetbrains.annotations.Nullable java.lang.String r4) {
        /*
            r2 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r2.<init>()
            r0 = 0
            if (r4 == 0) goto L_0x0016
            int r1 = r4.length()
            if (r1 != 0) goto L_0x0013
            r1 = 1
            goto L_0x0014
        L_0x0013:
            r1 = r0
        L_0x0014:
            if (r1 == 0) goto L_0x0018
        L_0x0016:
            java.lang.String r4 = "com.facebook.SharedPreferencesTokenCachingStrategy.DEFAULT_KEY"
        L_0x0018:
            r2.cacheKey = r4
            android.content.Context r1 = r3.getApplicationContext()
            if (r1 != 0) goto L_0x0021
            goto L_0x0022
        L_0x0021:
            r3 = r1
        L_0x0022:
            android.content.SharedPreferences r3 = r3.getSharedPreferences(r4, r0)
            java.lang.String r4 = "context.getSharedPreferences(this.cacheKey, Context.MODE_PRIVATE)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            r2.cache = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.LegacyTokenHelper.<init>(android.content.Context, java.lang.String):void");
    }

    private final void deserializeKey(String str, Bundle bundle) throws JSONException {
        String str2;
        String string;
        String string2 = this.cache.getString(str, "{}");
        if (string2 != null) {
            JSONObject jSONObject = new JSONObject(string2);
            String string3 = jSONObject.getString(JSON_VALUE_TYPE);
            if (string3 != null) {
                int i11 = 0;
                switch (string3.hashCode()) {
                    case -1573317553:
                        if (string3.equals(TYPE_STRING_LIST)) {
                            JSONArray jSONArray = jSONObject.getJSONArray("value");
                            int length = jSONArray.length();
                            ArrayList arrayList = new ArrayList(length);
                            if (length > 0) {
                                while (true) {
                                    int i12 = i11 + 1;
                                    Object obj = jSONArray.get(i11);
                                    if (obj == JSONObject.NULL) {
                                        str2 = null;
                                    } else if (obj != null) {
                                        str2 = (String) obj;
                                    } else {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                    }
                                    arrayList.add(i11, str2);
                                    if (i12 < length) {
                                        i11 = i12;
                                    }
                                }
                            }
                            bundle.putStringArrayList(str, arrayList);
                            return;
                        }
                        return;
                    case -1383386164:
                        if (string3.equals(TYPE_BOOLEAN_ARRAY)) {
                            JSONArray jSONArray2 = jSONObject.getJSONArray("value");
                            int length2 = jSONArray2.length();
                            boolean[] zArr = new boolean[length2];
                            int i13 = length2 - 1;
                            if (i13 >= 0) {
                                while (true) {
                                    int i14 = i11 + 1;
                                    zArr[i11] = jSONArray2.getBoolean(i11);
                                    if (i14 <= i13) {
                                        i11 = i14;
                                    }
                                }
                            }
                            bundle.putBooleanArray(str, zArr);
                            return;
                        }
                        return;
                    case -1374008726:
                        if (string3.equals(TYPE_BYTE_ARRAY)) {
                            JSONArray jSONArray3 = jSONObject.getJSONArray("value");
                            int length3 = jSONArray3.length();
                            byte[] bArr = new byte[length3];
                            int i15 = length3 - 1;
                            if (i15 >= 0) {
                                while (true) {
                                    int i16 = i11 + 1;
                                    bArr[i11] = (byte) jSONArray3.getInt(i11);
                                    if (i16 <= i15) {
                                        i11 = i16;
                                    }
                                }
                            }
                            bundle.putByteArray(str, bArr);
                            return;
                        }
                        return;
                    case -1361632968:
                        if (string3.equals(TYPE_CHAR_ARRAY)) {
                            JSONArray jSONArray4 = jSONObject.getJSONArray("value");
                            int length4 = jSONArray4.length();
                            char[] cArr = new char[length4];
                            int i17 = length4 - 1;
                            if (i17 >= 0) {
                                int i18 = 0;
                                while (true) {
                                    int i19 = i18 + 1;
                                    String string4 = jSONArray4.getString(i18);
                                    if (string4 != null && string4.length() == 1) {
                                        cArr[i18] = string4.charAt(0);
                                    }
                                    if (i19 <= i17) {
                                        i18 = i19;
                                    }
                                }
                            }
                            bundle.putCharArray(str, cArr);
                            return;
                        }
                        return;
                    case -1325958191:
                        if (string3.equals(TYPE_DOUBLE)) {
                            bundle.putDouble(str, jSONObject.getDouble("value"));
                            return;
                        }
                        return;
                    case -1097129250:
                        if (string3.equals(TYPE_LONG_ARRAY)) {
                            JSONArray jSONArray5 = jSONObject.getJSONArray("value");
                            int length5 = jSONArray5.length();
                            long[] jArr = new long[length5];
                            int i21 = length5 - 1;
                            if (i21 >= 0) {
                                while (true) {
                                    int i22 = i11 + 1;
                                    jArr[i11] = jSONArray5.getLong(i11);
                                    if (i22 <= i21) {
                                        i11 = i22;
                                    }
                                }
                            }
                            bundle.putLongArray(str, jArr);
                            return;
                        }
                        return;
                    case -891985903:
                        if (string3.equals("string")) {
                            bundle.putString(str, jSONObject.getString("value"));
                            return;
                        }
                        return;
                    case -766441794:
                        if (string3.equals(TYPE_FLOAT_ARRAY)) {
                            JSONArray jSONArray6 = jSONObject.getJSONArray("value");
                            int length6 = jSONArray6.length();
                            float[] fArr = new float[length6];
                            int i23 = length6 - 1;
                            if (i23 >= 0) {
                                while (true) {
                                    int i24 = i11 + 1;
                                    fArr[i11] = (float) jSONArray6.getDouble(i11);
                                    if (i24 <= i23) {
                                        i11 = i24;
                                    }
                                }
                            }
                            bundle.putFloatArray(str, fArr);
                            return;
                        }
                        return;
                    case 104431:
                        if (string3.equals(TYPE_INTEGER)) {
                            bundle.putInt(str, jSONObject.getInt("value"));
                            return;
                        }
                        return;
                    case 3029738:
                        if (string3.equals(TYPE_BOOLEAN)) {
                            bundle.putBoolean(str, jSONObject.getBoolean("value"));
                            return;
                        }
                        return;
                    case 3039496:
                        if (string3.equals(TYPE_BYTE)) {
                            bundle.putByte(str, (byte) jSONObject.getInt("value"));
                            return;
                        }
                        return;
                    case 3052374:
                        if (string3.equals(TYPE_CHAR) && (string = jSONObject.getString("value")) != null && string.length() == 1) {
                            bundle.putChar(str, string.charAt(0));
                            return;
                        }
                        return;
                    case 3118337:
                        if (string3.equals(TYPE_ENUM)) {
                            try {
                                bundle.putSerializable(str, Enum.valueOf(Class.forName(jSONObject.getString(JSON_VALUE_ENUM_TYPE)), jSONObject.getString("value")));
                                return;
                            } catch (ClassNotFoundException | IllegalArgumentException unused) {
                                return;
                            }
                        } else {
                            return;
                        }
                    case 3327612:
                        if (string3.equals("long")) {
                            bundle.putLong(str, jSONObject.getLong("value"));
                            return;
                        }
                        return;
                    case 97526364:
                        if (string3.equals("float")) {
                            bundle.putFloat(str, (float) jSONObject.getDouble("value"));
                            return;
                        }
                        return;
                    case 100361105:
                        if (string3.equals(TYPE_INTEGER_ARRAY)) {
                            JSONArray jSONArray7 = jSONObject.getJSONArray("value");
                            int length7 = jSONArray7.length();
                            int[] iArr = new int[length7];
                            int i25 = length7 - 1;
                            if (i25 >= 0) {
                                while (true) {
                                    int i26 = i11 + 1;
                                    iArr[i11] = jSONArray7.getInt(i11);
                                    if (i26 <= i25) {
                                        i11 = i26;
                                    }
                                }
                            }
                            bundle.putIntArray(str, iArr);
                            return;
                        }
                        return;
                    case 109413500:
                        if (string3.equals(TYPE_SHORT)) {
                            bundle.putShort(str, (short) jSONObject.getInt("value"));
                            return;
                        }
                        return;
                    case 1359468275:
                        if (string3.equals(TYPE_DOUBLE_ARRAY)) {
                            JSONArray jSONArray8 = jSONObject.getJSONArray("value");
                            int length8 = jSONArray8.length();
                            double[] dArr = new double[length8];
                            int i27 = length8 - 1;
                            if (i27 >= 0) {
                                while (true) {
                                    int i28 = i11 + 1;
                                    dArr[i11] = jSONArray8.getDouble(i11);
                                    if (i28 <= i27) {
                                        i11 = i28;
                                    }
                                }
                            }
                            bundle.putDoubleArray(str, dArr);
                            return;
                        }
                        return;
                    case 2067161310:
                        if (string3.equals(TYPE_SHORT_ARRAY)) {
                            JSONArray jSONArray9 = jSONObject.getJSONArray("value");
                            int length9 = jSONArray9.length();
                            short[] sArr = new short[length9];
                            int i29 = length9 - 1;
                            if (i29 >= 0) {
                                while (true) {
                                    int i31 = i11 + 1;
                                    sArr[i11] = (short) jSONArray9.getInt(i11);
                                    if (i31 <= i29) {
                                        i11 = i31;
                                    }
                                }
                            }
                            bundle.putShortArray(str, sArr);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        } else {
            throw new IllegalStateException("Required value was null.".toString());
        }
    }

    @JvmStatic
    @Nullable
    public static final String getApplicationId(@NotNull Bundle bundle) {
        return Companion.getApplicationId(bundle);
    }

    @JvmStatic
    @Nullable
    public static final Date getExpirationDate(@NotNull Bundle bundle) {
        return Companion.getExpirationDate(bundle);
    }

    @JvmStatic
    public static final long getExpirationMilliseconds(@NotNull Bundle bundle) {
        return Companion.getExpirationMilliseconds(bundle);
    }

    @JvmStatic
    @Nullable
    public static final Date getLastRefreshDate(@NotNull Bundle bundle) {
        return Companion.getLastRefreshDate(bundle);
    }

    @JvmStatic
    public static final long getLastRefreshMilliseconds(@NotNull Bundle bundle) {
        return Companion.getLastRefreshMilliseconds(bundle);
    }

    @JvmStatic
    @Nullable
    public static final Set<String> getPermissions(@NotNull Bundle bundle) {
        return Companion.getPermissions(bundle);
    }

    @JvmStatic
    @Nullable
    public static final AccessTokenSource getSource(@NotNull Bundle bundle) {
        return Companion.getSource(bundle);
    }

    @JvmStatic
    @Nullable
    public static final String getToken(@NotNull Bundle bundle) {
        return Companion.getToken(bundle);
    }

    @JvmStatic
    public static final boolean hasTokenInformation(@Nullable Bundle bundle) {
        return Companion.hasTokenInformation(bundle);
    }

    @JvmStatic
    public static final void putApplicationId(@NotNull Bundle bundle, @Nullable String str) {
        Companion.putApplicationId(bundle, str);
    }

    @JvmStatic
    public static final void putDeclinedPermissions(@NotNull Bundle bundle, @NotNull Collection<String> collection) {
        Companion.putDeclinedPermissions(bundle, collection);
    }

    @JvmStatic
    public static final void putExpirationDate(@NotNull Bundle bundle, @NotNull Date date) {
        Companion.putExpirationDate(bundle, date);
    }

    @JvmStatic
    public static final void putExpirationMilliseconds(@NotNull Bundle bundle, long j11) {
        Companion.putExpirationMilliseconds(bundle, j11);
    }

    @JvmStatic
    public static final void putExpiredPermissions(@NotNull Bundle bundle, @NotNull Collection<String> collection) {
        Companion.putExpiredPermissions(bundle, collection);
    }

    @JvmStatic
    public static final void putLastRefreshDate(@NotNull Bundle bundle, @NotNull Date date) {
        Companion.putLastRefreshDate(bundle, date);
    }

    @JvmStatic
    public static final void putLastRefreshMilliseconds(@NotNull Bundle bundle, long j11) {
        Companion.putLastRefreshMilliseconds(bundle, j11);
    }

    @JvmStatic
    public static final void putPermissions(@NotNull Bundle bundle, @NotNull Collection<String> collection) {
        Companion.putPermissions(bundle, collection);
    }

    @JvmStatic
    public static final void putSource(@NotNull Bundle bundle, @NotNull AccessTokenSource accessTokenSource) {
        Companion.putSource(bundle, accessTokenSource);
    }

    @JvmStatic
    public static final void putToken(@NotNull Bundle bundle, @NotNull String str) {
        Companion.putToken(bundle, str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:110:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x018b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void serializeKey(java.lang.String r9, android.os.Bundle r10, android.content.SharedPreferences.Editor r11) throws org.json.JSONException {
        /*
            r8 = this;
            java.lang.Object r10 = r10.get(r9)
            if (r10 != 0) goto L_0x0007
            return
        L_0x0007:
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            boolean r1 = r10 instanceof java.lang.Byte
            r2 = 0
            java.lang.String r3 = "value"
            if (r1 == 0) goto L_0x0022
            java.lang.Number r10 = (java.lang.Number) r10
            byte r10 = r10.byteValue()
            r0.put((java.lang.String) r3, (int) r10)
            java.lang.String r10 = "byte"
        L_0x001e:
            r1 = r2
            r2 = r10
            goto L_0x0189
        L_0x0022:
            boolean r1 = r10 instanceof java.lang.Short
            if (r1 == 0) goto L_0x0032
            java.lang.Number r10 = (java.lang.Number) r10
            short r10 = r10.shortValue()
            r0.put((java.lang.String) r3, (int) r10)
            java.lang.String r10 = "short"
            goto L_0x001e
        L_0x0032:
            boolean r1 = r10 instanceof java.lang.Integer
            if (r1 == 0) goto L_0x0042
            java.lang.Number r10 = (java.lang.Number) r10
            int r10 = r10.intValue()
            r0.put((java.lang.String) r3, (int) r10)
            java.lang.String r10 = "int"
            goto L_0x001e
        L_0x0042:
            boolean r1 = r10 instanceof java.lang.Long
            if (r1 == 0) goto L_0x0052
            java.lang.Number r10 = (java.lang.Number) r10
            long r4 = r10.longValue()
            r0.put((java.lang.String) r3, (long) r4)
            java.lang.String r10 = "long"
            goto L_0x001e
        L_0x0052:
            boolean r1 = r10 instanceof java.lang.Float
            if (r1 == 0) goto L_0x0063
            java.lang.Number r10 = (java.lang.Number) r10
            float r10 = r10.floatValue()
            double r4 = (double) r10
            r0.put((java.lang.String) r3, (double) r4)
            java.lang.String r10 = "float"
            goto L_0x001e
        L_0x0063:
            boolean r1 = r10 instanceof java.lang.Double
            if (r1 == 0) goto L_0x0073
            java.lang.Number r10 = (java.lang.Number) r10
            double r4 = r10.doubleValue()
            r0.put((java.lang.String) r3, (double) r4)
            java.lang.String r10 = "double"
            goto L_0x001e
        L_0x0073:
            boolean r1 = r10 instanceof java.lang.Boolean
            if (r1 == 0) goto L_0x0083
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            r0.put((java.lang.String) r3, (boolean) r10)
            java.lang.String r10 = "bool"
            goto L_0x001e
        L_0x0083:
            boolean r1 = r10 instanceof java.lang.Character
            if (r1 == 0) goto L_0x0091
            java.lang.String r10 = r10.toString()
            r0.put((java.lang.String) r3, (java.lang.Object) r10)
            java.lang.String r10 = "char"
            goto L_0x001e
        L_0x0091:
            boolean r1 = r10 instanceof java.lang.String
            if (r1 == 0) goto L_0x009b
            r0.put((java.lang.String) r3, (java.lang.Object) r10)
            java.lang.String r10 = "string"
            goto L_0x001e
        L_0x009b:
            boolean r1 = r10 instanceof java.lang.Enum
            if (r1 == 0) goto L_0x00b7
            java.lang.String r1 = r10.toString()
            r0.put((java.lang.String) r3, (java.lang.Object) r1)
            java.lang.Class r10 = r10.getClass()
            java.lang.String r10 = r10.getName()
            java.lang.String r1 = "enumType"
            r0.put((java.lang.String) r1, (java.lang.Object) r10)
            java.lang.String r10 = "enum"
            goto L_0x001e
        L_0x00b7:
            org.json.JSONArray r1 = new org.json.JSONArray
            r1.<init>()
            boolean r4 = r10 instanceof byte[]
            r5 = 0
            if (r4 == 0) goto L_0x00d2
            byte[] r10 = (byte[]) r10
            int r2 = r10.length
        L_0x00c4:
            if (r5 >= r2) goto L_0x00ce
            byte r4 = r10[r5]
            int r5 = r5 + 1
            r1.put((int) r4)
            goto L_0x00c4
        L_0x00ce:
            java.lang.String r2 = "byte[]"
            goto L_0x0189
        L_0x00d2:
            boolean r4 = r10 instanceof short[]
            if (r4 == 0) goto L_0x00e7
            short[] r10 = (short[]) r10
            int r2 = r10.length
        L_0x00d9:
            if (r5 >= r2) goto L_0x00e3
            short r4 = r10[r5]
            int r5 = r5 + 1
            r1.put((int) r4)
            goto L_0x00d9
        L_0x00e3:
            java.lang.String r2 = "short[]"
            goto L_0x0189
        L_0x00e7:
            boolean r4 = r10 instanceof int[]
            if (r4 == 0) goto L_0x00fc
            int[] r10 = (int[]) r10
            int r2 = r10.length
        L_0x00ee:
            if (r5 >= r2) goto L_0x00f8
            r4 = r10[r5]
            int r5 = r5 + 1
            r1.put((int) r4)
            goto L_0x00ee
        L_0x00f8:
            java.lang.String r2 = "int[]"
            goto L_0x0189
        L_0x00fc:
            boolean r4 = r10 instanceof long[]
            if (r4 == 0) goto L_0x0111
            long[] r10 = (long[]) r10
            int r2 = r10.length
        L_0x0103:
            if (r5 >= r2) goto L_0x010d
            r6 = r10[r5]
            int r5 = r5 + 1
            r1.put((long) r6)
            goto L_0x0103
        L_0x010d:
            java.lang.String r2 = "long[]"
            goto L_0x0189
        L_0x0111:
            boolean r4 = r10 instanceof float[]
            if (r4 == 0) goto L_0x0127
            float[] r10 = (float[]) r10
            int r2 = r10.length
        L_0x0118:
            if (r5 >= r2) goto L_0x0123
            r4 = r10[r5]
            int r5 = r5 + 1
            double r6 = (double) r4
            r1.put((double) r6)
            goto L_0x0118
        L_0x0123:
            java.lang.String r2 = "float[]"
            goto L_0x0189
        L_0x0127:
            boolean r4 = r10 instanceof double[]
            if (r4 == 0) goto L_0x013b
            double[] r10 = (double[]) r10
            int r2 = r10.length
        L_0x012e:
            if (r5 >= r2) goto L_0x0138
            r6 = r10[r5]
            int r5 = r5 + 1
            r1.put((double) r6)
            goto L_0x012e
        L_0x0138:
            java.lang.String r2 = "double[]"
            goto L_0x0189
        L_0x013b:
            boolean r4 = r10 instanceof boolean[]
            if (r4 == 0) goto L_0x014f
            boolean[] r10 = (boolean[]) r10
            int r2 = r10.length
        L_0x0142:
            if (r5 >= r2) goto L_0x014c
            boolean r4 = r10[r5]
            int r5 = r5 + 1
            r1.put((boolean) r4)
            goto L_0x0142
        L_0x014c:
            java.lang.String r2 = "bool[]"
            goto L_0x0189
        L_0x014f:
            boolean r4 = r10 instanceof char[]
            if (r4 == 0) goto L_0x0167
            char[] r10 = (char[]) r10
            int r2 = r10.length
        L_0x0156:
            if (r5 >= r2) goto L_0x0164
            char r4 = r10[r5]
            int r5 = r5 + 1
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r1.put((java.lang.Object) r4)
            goto L_0x0156
        L_0x0164:
            java.lang.String r2 = "char[]"
            goto L_0x0189
        L_0x0167:
            boolean r4 = r10 instanceof java.util.List
            if (r4 == 0) goto L_0x0188
            java.util.List r10 = (java.util.List) r10
            java.util.Iterator r10 = r10.iterator()
        L_0x0171:
            boolean r2 = r10.hasNext()
            if (r2 == 0) goto L_0x0185
            java.lang.Object r2 = r10.next()
            java.lang.String r2 = (java.lang.String) r2
            if (r2 != 0) goto L_0x0181
            java.lang.Object r2 = org.json.JSONObject.NULL
        L_0x0181:
            r1.put((java.lang.Object) r2)
            goto L_0x0171
        L_0x0185:
            java.lang.String r2 = "stringList"
            goto L_0x0189
        L_0x0188:
            r1 = r2
        L_0x0189:
            if (r2 == 0) goto L_0x01a1
            java.lang.String r10 = "valueType"
            r0.put((java.lang.String) r10, (java.lang.Object) r2)
            if (r1 == 0) goto L_0x0195
            r0.putOpt(r3, r1)
        L_0x0195:
            java.lang.String r10 = com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation.toString(r0)
            java.lang.String r0 = "json.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r0)
            r11.putString(r9, r10)
        L_0x01a1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.LegacyTokenHelper.serializeKey(java.lang.String, android.os.Bundle, android.content.SharedPreferences$Editor):void");
    }

    public final void clear() {
        this.cache.edit().clear().apply();
    }

    @Nullable
    public final Bundle load() {
        Bundle bundle = new Bundle();
        for (String next : this.cache.getAll().keySet()) {
            try {
                Intrinsics.checkNotNullExpressionValue(next, "key");
                deserializeKey(next, bundle);
            } catch (JSONException e11) {
                Logger.Companion companion = Logger.Companion;
                LoggingBehavior loggingBehavior = LoggingBehavior.CACHE;
                String str = TAG;
                Intrinsics.checkNotNullExpressionValue(str, "TAG");
                companion.log(loggingBehavior, 5, str, "Error reading cached value for key: '" + next + "' -- " + e11);
                return null;
            }
        }
        return bundle;
    }

    public final void save(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        SharedPreferences.Editor edit = this.cache.edit();
        for (String next : bundle.keySet()) {
            try {
                Intrinsics.checkNotNullExpressionValue(next, "key");
                Intrinsics.checkNotNullExpressionValue(edit, "editor");
                serializeKey(next, bundle, edit);
            } catch (JSONException e11) {
                Logger.Companion companion = Logger.Companion;
                LoggingBehavior loggingBehavior = LoggingBehavior.CACHE;
                String str = TAG;
                Intrinsics.checkNotNullExpressionValue(str, "TAG");
                companion.log(loggingBehavior, 5, str, "Error processing value for key: '" + next + "' -- " + e11);
                return;
            }
        }
        edit.apply();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LegacyTokenHelper(Context context, String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : str);
    }
}
