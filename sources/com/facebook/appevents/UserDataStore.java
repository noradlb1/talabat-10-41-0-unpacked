package com.facebook.appevents;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.util.Patterns;
import androidx.annotation.RestrictTo;
import com.checkout.frames.utils.constants.ExpiryDateConstantsKt;
import com.facebook.FacebookSdk;
import com.facebook.appevents.aam.MetadataRule;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import l6.s;
import l6.t;
import l6.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\b\u0014\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bC\u0010DJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0012\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0007Jl\u0010\n\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0007J\b\u0010\u0015\u001a\u00020\u0002H\u0007J\u000f\u0010\u0018\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0019\u001a\u00020\u0004H\u0007J\b\u0010\u001a\u001a\u00020\u0002H\u0002J\u0012\u0010\u001b\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u001c\u0010\u001d\u001a\u00020\u00022\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001cH\u0007J\u0018\u0010 \u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0004H\u0002J\u0010\u0010\"\u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u0004H\u0002R\u001c\u0010$\u001a\n #*\u0004\u0018\u00010\u00040\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b&\u0010%R\u0014\u0010'\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b'\u0010%R\u0016\u0010)\u001a\u00020(8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010,\u001a\u00020+8\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0014\u0010/\u001a\u00020.8\u0002XT¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u00101\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b1\u0010%R$\u00103\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004028\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R$\u00105\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004028\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00104R\u0014\u00106\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b6\u0010%R\u0014\u00107\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b7\u0010%R\u0014\u00108\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b8\u0010%R\u0014\u00109\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b9\u0010%R\u0014\u0010:\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b:\u0010%R\u0014\u0010;\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b;\u0010%R\u0014\u0010<\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b<\u0010%R\u0014\u0010=\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b=\u0010%R\u0014\u0010>\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b>\u0010%R\u0014\u0010?\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b?\u0010%R$\u0010B\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001c8BX\u0004¢\u0006\u0006\u001a\u0004\b@\u0010A¨\u0006E"}, d2 = {"Lcom/facebook/appevents/UserDataStore;", "", "", "initStore", "", "key", "value", "writeDataIntoCache", "Landroid/os/Bundle;", "ud", "setUserDataAndHash", "email", "firstName", "lastName", "phone", "dateOfBirth", "gender", "city", "state", "zip", "country", "clear", "getHashedUserData$facebook_core_release", "()Ljava/lang/String;", "getHashedUserData", "getAllHashedUserData", "initAndWait", "updateHashUserData", "", "setInternalUd", "type", "data", "normalizeData", "", "maybeSHA256Hashed", "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "USER_DATA_KEY", "INTERNAL_USER_DATA_KEY", "Landroid/content/SharedPreferences;", "sharedPreferences", "Landroid/content/SharedPreferences;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "", "MAX_NUM", "I", "DATA_SEPARATOR", "j$/util/concurrent/ConcurrentHashMap", "externalHashedUserData", "Lj$/util/concurrent/ConcurrentHashMap;", "internalHashedUserData", "EMAIL", "FIRST_NAME", "LAST_NAME", "PHONE", "DATE_OF_BIRTH", "GENDER", "CITY", "STATE", "ZIP", "COUNTRY", "getEnabledInternalUserData", "()Ljava/util/Map;", "enabledInternalUserData", "<init>", "()V", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@AutoHandleExceptions
public final class UserDataStore {
    @NotNull
    public static final String CITY = "ct";
    @NotNull
    public static final String COUNTRY = "country";
    @NotNull
    private static final String DATA_SEPARATOR = ",";
    @NotNull
    public static final String DATE_OF_BIRTH = "db";
    @NotNull
    public static final String EMAIL = "em";
    @NotNull
    public static final String FIRST_NAME = "fn";
    @NotNull
    public static final String GENDER = "ge";
    @NotNull
    public static final UserDataStore INSTANCE = new UserDataStore();
    @NotNull
    private static final String INTERNAL_USER_DATA_KEY = "com.facebook.appevents.UserDataStore.internalUserData";
    @NotNull
    public static final String LAST_NAME = "ln";
    private static final int MAX_NUM = 5;
    @NotNull
    public static final String PHONE = "ph";
    @NotNull
    public static final String STATE = "st";
    private static final String TAG = UserDataStore.class.getSimpleName();
    @NotNull
    private static final String USER_DATA_KEY = "com.facebook.appevents.UserDataStore.userData";
    @NotNull
    public static final String ZIP = "zp";
    @NotNull
    private static final ConcurrentHashMap<String, String> externalHashedUserData = new ConcurrentHashMap<>();
    @NotNull
    private static final AtomicBoolean initialized = new AtomicBoolean(false);
    @NotNull
    private static final ConcurrentHashMap<String, String> internalHashedUserData = new ConcurrentHashMap<>();
    private static SharedPreferences sharedPreferences;

    private UserDataStore() {
    }

    @JvmStatic
    public static final void clear() {
        InternalAppEventsLogger.Companion.getAnalyticsExecutor().execute(new t());
    }

    /* access modifiers changed from: private */
    /* renamed from: clear$lambda-2  reason: not valid java name */
    public static final void m8896clear$lambda2() {
        if (!initialized.get()) {
            Log.w(TAG, "initStore should have been called before calling setUserData");
            INSTANCE.initAndWait();
        }
        externalHashedUserData.clear();
        SharedPreferences sharedPreferences2 = sharedPreferences;
        if (sharedPreferences2 != null) {
            sharedPreferences2.edit().putString(USER_DATA_KEY, (String) null).apply();
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
            throw null;
        }
    }

    @JvmStatic
    @NotNull
    public static final String getAllHashedUserData() {
        if (!initialized.get()) {
            INSTANCE.initAndWait();
        }
        HashMap hashMap = new HashMap();
        hashMap.putAll(externalHashedUserData);
        hashMap.putAll(INSTANCE.getEnabledInternalUserData());
        return Utility.mapToJsonStr(hashMap);
    }

    private final Map<String, String> getEnabledInternalUserData() {
        HashMap hashMap = new HashMap();
        Set<String> enabledRuleNames = MetadataRule.Companion.getEnabledRuleNames();
        for (String next : internalHashedUserData.keySet()) {
            if (enabledRuleNames.contains(next)) {
                hashMap.put(next, internalHashedUserData.get(next));
            }
        }
        return hashMap;
    }

    @JvmStatic
    @NotNull
    public static final String getHashedUserData$facebook_core_release() {
        if (!initialized.get()) {
            Log.w(TAG, "initStore should have been called before calling setUserID");
            INSTANCE.initAndWait();
        }
        Utility utility = Utility.INSTANCE;
        return Utility.mapToJsonStr(externalHashedUserData);
    }

    private final synchronized void initAndWait() {
        AtomicBoolean atomicBoolean = initialized;
        if (!atomicBoolean.get()) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext());
            Intrinsics.checkNotNullExpressionValue(defaultSharedPreferences, "getDefaultSharedPreferences(FacebookSdk.getApplicationContext())");
            sharedPreferences = defaultSharedPreferences;
            if (defaultSharedPreferences != null) {
                String string = defaultSharedPreferences.getString(USER_DATA_KEY, "");
                if (string == null) {
                    string = "";
                }
                SharedPreferences sharedPreferences2 = sharedPreferences;
                if (sharedPreferences2 != null) {
                    String string2 = sharedPreferences2.getString(INTERNAL_USER_DATA_KEY, "");
                    if (string2 == null) {
                        string2 = "";
                    }
                    externalHashedUserData.putAll(Utility.jsonStrToMap(string));
                    internalHashedUserData.putAll(Utility.jsonStrToMap(string2));
                    atomicBoolean.set(true);
                    return;
                }
                Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                throw null;
            }
            Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
            throw null;
        }
    }

    @JvmStatic
    public static final void initStore() {
        if (!initialized.get()) {
            INSTANCE.initAndWait();
        }
    }

    private final boolean maybeSHA256Hashed(String str) {
        return new Regex("[A-Fa-f0-9]{64}").matches(str);
    }

    private final String normalizeData(String str, String str2) {
        boolean z11;
        String str3;
        int i11;
        boolean z12;
        int length = str2.length() - 1;
        int i12 = 0;
        boolean z13 = false;
        while (i12 <= length) {
            if (!z13) {
                i11 = i12;
            } else {
                i11 = length;
            }
            if (Intrinsics.compare((int) str2.charAt(i11), 32) <= 0) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (!z13) {
                if (!z12) {
                    z13 = true;
                } else {
                    i12++;
                }
            } else if (!z12) {
                break;
            } else {
                length--;
            }
        }
        String obj = str2.subSequence(i12, length + 1).toString();
        if (obj != null) {
            String lowerCase = obj.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
            if (Intrinsics.areEqual((Object) EMAIL, (Object) str)) {
                if (Patterns.EMAIL_ADDRESS.matcher(lowerCase).matches()) {
                    return lowerCase;
                }
                Log.e(TAG, "Setting email failure: this is not a valid email address");
                return "";
            } else if (Intrinsics.areEqual((Object) PHONE, (Object) str)) {
                return new Regex(ExpiryDateConstantsKt.EXPIRY_DATE_DIGITS_PATTERN).replace((CharSequence) lowerCase, "");
            } else {
                if (!Intrinsics.areEqual((Object) GENDER, (Object) str)) {
                    return lowerCase;
                }
                if (lowerCase.length() > 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (!z11) {
                    str3 = "";
                } else if (lowerCase != null) {
                    str3 = lowerCase.substring(0, 1);
                    Intrinsics.checkNotNullExpressionValue(str3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                if (Intrinsics.areEqual((Object) "f", (Object) str3) || Intrinsics.areEqual((Object) "m", (Object) str3)) {
                    return str3;
                }
                Log.e(TAG, "Setting gender failure: the supported value for gender is f or m");
                return "";
            }
        } else {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
    }

    @JvmStatic
    public static final void setInternalUd(@NotNull Map<String, String> map) {
        boolean z11;
        List<String> split;
        int i11;
        boolean z12;
        Intrinsics.checkNotNullParameter(map, "ud");
        if (!initialized.get()) {
            INSTANCE.initAndWait();
        }
        for (Map.Entry next : map.entrySet()) {
            String str = (String) next.getKey();
            String str2 = (String) next.getValue();
            Utility utility = Utility.INSTANCE;
            UserDataStore userDataStore = INSTANCE;
            int i12 = 1;
            int length = str2.length() - 1;
            int i13 = 0;
            boolean z13 = false;
            while (i13 <= length) {
                if (!z13) {
                    i11 = i13;
                } else {
                    i11 = length;
                }
                if (Intrinsics.compare((int) str2.charAt(i11), 32) <= 0) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (!z13) {
                    if (!z12) {
                        z13 = true;
                    } else {
                        i13++;
                    }
                } else if (!z12) {
                    break;
                } else {
                    length--;
                }
            }
            String sha256hash = Utility.sha256hash(userDataStore.normalizeData(str, str2.subSequence(i13, length + 1).toString()));
            ConcurrentHashMap<String, String> concurrentHashMap = internalHashedUserData;
            if (concurrentHashMap.containsKey(str)) {
                String str3 = concurrentHashMap.get(str);
                String[] strArr = null;
                if (!(str3 == null || (split = new Regex(",").split(str3, 0)) == null)) {
                    Object[] array = split.toArray(new String[0]);
                    if (array != null) {
                        strArr = (String[]) array;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                }
                if (strArr == null) {
                    strArr = new String[0];
                }
                Set mutableSetOf = SetsKt__SetsKt.mutableSetOf(Arrays.copyOf(strArr, strArr.length));
                if (!mutableSetOf.contains(sha256hash)) {
                    StringBuilder sb2 = new StringBuilder();
                    if (strArr.length == 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (z11) {
                        sb2.append(sha256hash);
                    } else if (strArr.length < 5) {
                        sb2.append(str3);
                        sb2.append(",");
                        sb2.append(sha256hash);
                    } else {
                        while (true) {
                            int i14 = i12 + 1;
                            sb2.append(strArr[i12]);
                            sb2.append(",");
                            if (i14 >= 5) {
                                break;
                            }
                            i12 = i14;
                        }
                        sb2.append(sha256hash);
                        mutableSetOf.remove(strArr[0]);
                    }
                    internalHashedUserData.put(str, sb2.toString());
                } else {
                    return;
                }
            } else {
                concurrentHashMap.put(str, sha256hash);
            }
        }
        UserDataStore userDataStore2 = INSTANCE;
        Utility utility2 = Utility.INSTANCE;
        userDataStore2.writeDataIntoCache(INTERNAL_USER_DATA_KEY, Utility.mapToJsonStr(internalHashedUserData));
    }

    @JvmStatic
    public static final void setUserDataAndHash(@Nullable Bundle bundle) {
        InternalAppEventsLogger.Companion.getAnalyticsExecutor().execute(new s(bundle));
    }

    /* access modifiers changed from: private */
    /* renamed from: setUserDataAndHash$lambda-1  reason: not valid java name */
    public static final void m8897setUserDataAndHash$lambda1(Bundle bundle) {
        if (!initialized.get()) {
            Log.w(TAG, "initStore should have been called before calling setUserData");
            INSTANCE.initAndWait();
        }
        UserDataStore userDataStore = INSTANCE;
        userDataStore.updateHashUserData(bundle);
        Utility utility = Utility.INSTANCE;
        userDataStore.writeDataIntoCache(USER_DATA_KEY, Utility.mapToJsonStr(externalHashedUserData));
        userDataStore.writeDataIntoCache(INTERNAL_USER_DATA_KEY, Utility.mapToJsonStr(internalHashedUserData));
    }

    private final void updateHashUserData(Bundle bundle) {
        if (bundle != null) {
            for (String next : bundle.keySet()) {
                Object obj = bundle.get(next);
                if (obj != null) {
                    String obj2 = obj.toString();
                    if (maybeSHA256Hashed(obj2)) {
                        ConcurrentHashMap<String, String> concurrentHashMap = externalHashedUserData;
                        if (obj2 != null) {
                            String lowerCase = obj2.toLowerCase();
                            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                            concurrentHashMap.put(next, lowerCase);
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                        }
                    } else {
                        Utility utility = Utility.INSTANCE;
                        Intrinsics.checkNotNullExpressionValue(next, "key");
                        String sha256hash = Utility.sha256hash(normalizeData(next, obj2));
                        if (sha256hash != null) {
                            externalHashedUserData.put(next, sha256hash);
                        }
                    }
                }
            }
        }
    }

    private final void writeDataIntoCache(String str, String str2) {
        FacebookSdk.getExecutor().execute(new u(str, str2));
    }

    /* access modifiers changed from: private */
    /* renamed from: writeDataIntoCache$lambda-0  reason: not valid java name */
    public static final void m8898writeDataIntoCache$lambda0(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "$key");
        Intrinsics.checkNotNullParameter(str2, "$value");
        if (!initialized.get()) {
            INSTANCE.initAndWait();
        }
        SharedPreferences sharedPreferences2 = sharedPreferences;
        if (sharedPreferences2 != null) {
            sharedPreferences2.edit().putString(str, str2).apply();
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
            throw null;
        }
    }

    @JvmStatic
    public static final void setUserDataAndHash(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10) {
        Bundle bundle = new Bundle();
        if (str != null) {
            bundle.putString(EMAIL, str);
        }
        if (str2 != null) {
            bundle.putString(FIRST_NAME, str2);
        }
        if (str3 != null) {
            bundle.putString(LAST_NAME, str3);
        }
        if (str4 != null) {
            bundle.putString(PHONE, str4);
        }
        if (str5 != null) {
            bundle.putString(DATE_OF_BIRTH, str5);
        }
        if (str6 != null) {
            bundle.putString(GENDER, str6);
        }
        if (str7 != null) {
            bundle.putString(CITY, str7);
        }
        if (str8 != null) {
            bundle.putString(STATE, str8);
        }
        if (str9 != null) {
            bundle.putString(ZIP, str9);
        }
        if (str10 != null) {
            bundle.putString("country", str10);
        }
        setUserDataAndHash(bundle);
    }
}
