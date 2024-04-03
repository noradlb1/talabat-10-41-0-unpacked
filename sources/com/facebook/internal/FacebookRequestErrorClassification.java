package com.facebook.internal;

import com.facebook.FacebookRequestError;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tekartik.sqflite.Constant;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\b\u0000\u0012\u001c\u0010\u0002\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0005\u0018\u00010\u0003\u0012\u001c\u0010\u0006\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0005\u0018\u00010\u0003\u0012\u001c\u0010\u0007\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0005\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\fJ\u001e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0012R'\u0010\u0007\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0005\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000R'\u0010\u0002\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0005\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000R'\u0010\u0006\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0005\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/facebook/internal/FacebookRequestErrorClassification;", "", "otherErrors", "", "", "", "transientErrors", "loginRecoverableErrors", "otherRecoveryMessage", "", "transientRecoveryMessage", "loginRecoverableRecoveryMessage", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLoginRecoverableErrors", "()Ljava/util/Map;", "getOtherErrors", "getTransientErrors", "classify", "Lcom/facebook/FacebookRequestError$Category;", "errorCode", "errorSubCode", "isTransient", "", "getRecoveryMessage", "category", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class FacebookRequestErrorClassification {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int EC_APP_NOT_INSTALLED = 412;
    public static final int EC_APP_TOO_MANY_CALLS = 4;
    public static final int EC_INVALID_SESSION = 102;
    public static final int EC_INVALID_TOKEN = 190;
    public static final int EC_RATE = 9;
    public static final int EC_SERVICE_UNAVAILABLE = 2;
    public static final int EC_TOO_MANY_USER_ACTION_CALLS = 341;
    public static final int EC_USER_TOO_MANY_CALLS = 17;
    public static final int ESC_APP_INACTIVE = 493;
    public static final int ESC_APP_NOT_INSTALLED = 458;
    @NotNull
    public static final String KEY_LOGIN_RECOVERABLE = "login_recoverable";
    @NotNull
    public static final String KEY_NAME = "name";
    @NotNull
    public static final String KEY_OTHER = "other";
    @NotNull
    public static final String KEY_RECOVERY_MESSAGE = "recovery_message";
    @NotNull
    public static final String KEY_TRANSIENT = "transient";
    /* access modifiers changed from: private */
    @Nullable
    public static FacebookRequestErrorClassification defaultInstance;
    @Nullable
    private final Map<Integer, Set<Integer>> loginRecoverableErrors;
    @Nullable
    private final String loginRecoverableRecoveryMessage;
    @Nullable
    private final Map<Integer, Set<Integer>> otherErrors;
    @Nullable
    private final String otherRecoveryMessage;
    @Nullable
    private final Map<Integer, Set<Integer>> transientErrors;
    @Nullable
    private final String transientRecoveryMessage;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u00152\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0007J&\u0010\u001f\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010!\u0018\u00010 2\u0006\u0010\"\u001a\u00020#H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u00158FX\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0002\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00158BX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0018R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/facebook/internal/FacebookRequestErrorClassification$Companion;", "", "()V", "EC_APP_NOT_INSTALLED", "", "EC_APP_TOO_MANY_CALLS", "EC_INVALID_SESSION", "EC_INVALID_TOKEN", "EC_RATE", "EC_SERVICE_UNAVAILABLE", "EC_TOO_MANY_USER_ACTION_CALLS", "EC_USER_TOO_MANY_CALLS", "ESC_APP_INACTIVE", "ESC_APP_NOT_INSTALLED", "KEY_LOGIN_RECOVERABLE", "", "KEY_NAME", "KEY_OTHER", "KEY_RECOVERY_MESSAGE", "KEY_TRANSIENT", "defaultErrorClassification", "Lcom/facebook/internal/FacebookRequestErrorClassification;", "getDefaultErrorClassification$annotations", "getDefaultErrorClassification", "()Lcom/facebook/internal/FacebookRequestErrorClassification;", "defaultErrorClassificationImpl", "getDefaultErrorClassificationImpl", "defaultInstance", "createFromJSON", "jsonArray", "Lorg/json/JSONArray;", "parseJSONDefinition", "", "", "definition", "Lorg/json/JSONObject;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getDefaultErrorClassification$annotations() {
        }

        private final FacebookRequestErrorClassification getDefaultErrorClassificationImpl() {
            return new FacebookRequestErrorClassification((Map<Integer, ? extends Set<Integer>>) null, MapsKt__MapsKt.hashMapOf(TuplesKt.to(2, null), TuplesKt.to(4, null), TuplesKt.to(9, null), TuplesKt.to(17, null), TuplesKt.to(Integer.valueOf(FacebookRequestErrorClassification.EC_TOO_MANY_USER_ACTION_CALLS), null)), MapsKt__MapsKt.hashMapOf(TuplesKt.to(102, null), TuplesKt.to(190, null), TuplesKt.to(412, null)), (String) null, (String) null, (String) null);
        }

        private final Map<Integer, Set<Integer>> parseJSONDefinition(JSONObject jSONObject) {
            int optInt;
            HashSet hashSet;
            JSONArray optJSONArray = jSONObject.optJSONArray(FirebaseAnalytics.Param.ITEMS);
            if (optJSONArray == null || optJSONArray.length() == 0) {
                return null;
            }
            HashMap hashMap = new HashMap();
            int length = optJSONArray.length();
            if (length > 0) {
                int i11 = 0;
                while (true) {
                    int i12 = i11 + 1;
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i11);
                    if (!(optJSONObject == null || (optInt = optJSONObject.optInt(Constant.PARAM_ERROR_CODE)) == 0)) {
                        JSONArray optJSONArray2 = optJSONObject.optJSONArray("subcodes");
                        if (optJSONArray2 == null || optJSONArray2.length() <= 0) {
                            hashSet = null;
                        } else {
                            hashSet = new HashSet();
                            int length2 = optJSONArray2.length();
                            if (length2 > 0) {
                                int i13 = 0;
                                while (true) {
                                    int i14 = i13 + 1;
                                    int optInt2 = optJSONArray2.optInt(i13);
                                    if (optInt2 != 0) {
                                        hashSet.add(Integer.valueOf(optInt2));
                                    }
                                    if (i14 >= length2) {
                                        break;
                                    }
                                    i13 = i14;
                                }
                            }
                        }
                        hashMap.put(Integer.valueOf(optInt), hashSet);
                    }
                    if (i12 >= length) {
                        break;
                    }
                    i11 = i12;
                }
            }
            return hashMap;
        }

        @JvmStatic
        @Nullable
        public final FacebookRequestErrorClassification createFromJSON(@Nullable JSONArray jSONArray) {
            String str;
            String str2;
            String str3;
            Map<Integer, Set<Integer>> map;
            Map<Integer, Set<Integer>> map2;
            Map<Integer, Set<Integer>> map3;
            String optString;
            JSONArray jSONArray2 = jSONArray;
            if (jSONArray2 == null) {
                return null;
            }
            int length = jSONArray.length();
            if (length > 0) {
                int i11 = 0;
                Map<Integer, Set<Integer>> map4 = null;
                Map<Integer, Set<Integer>> map5 = null;
                Map<Integer, Set<Integer>> map6 = null;
                String str4 = null;
                String str5 = null;
                String str6 = null;
                while (true) {
                    int i12 = i11 + 1;
                    JSONObject optJSONObject = jSONArray2.optJSONObject(i11);
                    if (!(optJSONObject == null || (optString = optJSONObject.optString("name")) == null)) {
                        if (StringsKt__StringsJVMKt.equals(optString, "other", true)) {
                            str4 = optJSONObject.optString(FacebookRequestErrorClassification.KEY_RECOVERY_MESSAGE, (String) null);
                            map4 = parseJSONDefinition(optJSONObject);
                        } else if (StringsKt__StringsJVMKt.equals(optString, FacebookRequestErrorClassification.KEY_TRANSIENT, true)) {
                            str5 = optJSONObject.optString(FacebookRequestErrorClassification.KEY_RECOVERY_MESSAGE, (String) null);
                            map5 = parseJSONDefinition(optJSONObject);
                        } else if (StringsKt__StringsJVMKt.equals(optString, FacebookRequestErrorClassification.KEY_LOGIN_RECOVERABLE, true)) {
                            str6 = optJSONObject.optString(FacebookRequestErrorClassification.KEY_RECOVERY_MESSAGE, (String) null);
                            map6 = parseJSONDefinition(optJSONObject);
                        }
                    }
                    if (i12 >= length) {
                        break;
                    }
                    i11 = i12;
                }
                map3 = map4;
                map2 = map5;
                map = map6;
                str3 = str4;
                str2 = str5;
                str = str6;
            } else {
                map3 = null;
                map2 = null;
                map = null;
                str3 = null;
                str2 = null;
                str = null;
            }
            return new FacebookRequestErrorClassification(map3, map2, map, str3, str2, str);
        }

        @NotNull
        public final synchronized FacebookRequestErrorClassification getDefaultErrorClassification() {
            FacebookRequestErrorClassification access$getDefaultInstance$cp;
            if (FacebookRequestErrorClassification.defaultInstance == null) {
                FacebookRequestErrorClassification.defaultInstance = getDefaultErrorClassificationImpl();
            }
            access$getDefaultInstance$cp = FacebookRequestErrorClassification.defaultInstance;
            if (access$getDefaultInstance$cp == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.facebook.internal.FacebookRequestErrorClassification");
            }
            return access$getDefaultInstance$cp;
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FacebookRequestError.Category.values().length];
            iArr[FacebookRequestError.Category.OTHER.ordinal()] = 1;
            iArr[FacebookRequestError.Category.LOGIN_RECOVERABLE.ordinal()] = 2;
            iArr[FacebookRequestError.Category.TRANSIENT.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public FacebookRequestErrorClassification(@Nullable Map<Integer, ? extends Set<Integer>> map, @Nullable Map<Integer, ? extends Set<Integer>> map2, @Nullable Map<Integer, ? extends Set<Integer>> map3, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        this.otherErrors = map;
        this.transientErrors = map2;
        this.loginRecoverableErrors = map3;
        this.otherRecoveryMessage = str;
        this.transientRecoveryMessage = str2;
        this.loginRecoverableRecoveryMessage = str3;
    }

    @JvmStatic
    @Nullable
    public static final FacebookRequestErrorClassification createFromJSON(@Nullable JSONArray jSONArray) {
        return Companion.createFromJSON(jSONArray);
    }

    @NotNull
    public static final synchronized FacebookRequestErrorClassification getDefaultErrorClassification() {
        FacebookRequestErrorClassification defaultErrorClassification;
        synchronized (FacebookRequestErrorClassification.class) {
            defaultErrorClassification = Companion.getDefaultErrorClassification();
        }
        return defaultErrorClassification;
    }

    @NotNull
    public final FacebookRequestError.Category classify(int i11, int i12, boolean z11) {
        Set set;
        Set set2;
        Set set3;
        if (z11) {
            return FacebookRequestError.Category.TRANSIENT;
        }
        Map<Integer, Set<Integer>> map = this.otherErrors;
        if (map != null && map.containsKey(Integer.valueOf(i11)) && ((set3 = this.otherErrors.get(Integer.valueOf(i11))) == null || set3.contains(Integer.valueOf(i12)))) {
            return FacebookRequestError.Category.OTHER;
        }
        Map<Integer, Set<Integer>> map2 = this.loginRecoverableErrors;
        if (map2 != null && map2.containsKey(Integer.valueOf(i11)) && ((set2 = this.loginRecoverableErrors.get(Integer.valueOf(i11))) == null || set2.contains(Integer.valueOf(i12)))) {
            return FacebookRequestError.Category.LOGIN_RECOVERABLE;
        }
        Map<Integer, Set<Integer>> map3 = this.transientErrors;
        if (map3 == null || !map3.containsKey(Integer.valueOf(i11)) || ((set = this.transientErrors.get(Integer.valueOf(i11))) != null && !set.contains(Integer.valueOf(i12)))) {
            return FacebookRequestError.Category.OTHER;
        }
        return FacebookRequestError.Category.TRANSIENT;
    }

    @Nullable
    public final Map<Integer, Set<Integer>> getLoginRecoverableErrors() {
        return this.loginRecoverableErrors;
    }

    @Nullable
    public final Map<Integer, Set<Integer>> getOtherErrors() {
        return this.otherErrors;
    }

    @Nullable
    public final String getRecoveryMessage(@Nullable FacebookRequestError.Category category) {
        int i11;
        if (category == null) {
            i11 = -1;
        } else {
            i11 = WhenMappings.$EnumSwitchMapping$0[category.ordinal()];
        }
        if (i11 == 1) {
            return this.otherRecoveryMessage;
        }
        if (i11 == 2) {
            return this.loginRecoverableRecoveryMessage;
        }
        if (i11 != 3) {
            return null;
        }
        return this.transientRecoveryMessage;
    }

    @Nullable
    public final Map<Integer, Set<Integer>> getTransientErrors() {
        return this.transientErrors;
    }
}
