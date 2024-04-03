package com.facebook.appevents.integrity;

import android.os.Build;
import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Instrumented
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0007J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\tH\u0007J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u0012\u0010\u0014\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J&\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016j\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004H\u0007J\u001c\u0010\u0019\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000fH\u0007J\b\u0010\u001c\u001a\u00020\fH\u0002J\u001a\u0010\u001d\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\tH\u0007J\u0010\u0010\u001e\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\"\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u000fH\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u000e¢\u0006\u0004\n\u0002\u0010\n¨\u0006\""}, d2 = {"Lcom/facebook/appevents/integrity/MACARuleMatchingManager;", "", "()V", "MACARules", "Lorg/json/JSONArray;", "enabled", "", "keys", "", "", "[Ljava/lang/String;", "enable", "", "generateInfo", "params", "Landroid/os/Bundle;", "event", "getKey", "logic", "Lorg/json/JSONObject;", "getMatchPropertyIDs", "getStringArrayList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "jsonArray", "isMatchCCRule", "ruleString", "data", "loadMACARules", "processParameters", "removeGeneratedInfo", "stringComparison", "variable", "values", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@AutoHandleExceptions
public final class MACARuleMatchingManager {
    @NotNull
    public static final MACARuleMatchingManager INSTANCE = new MACARuleMatchingManager();
    @Nullable
    private static JSONArray MACARules;
    private static boolean enabled;
    @NotNull
    private static String[] keys = {"event", "_locale", "_appVersion", "_deviceOS", "_platform", "_deviceModel", "_nativeAppID", "_nativeAppShortVersion", "_timezone", "_carrier", "_deviceOSTypeName", "_deviceOSVersion", "_remainingDiskGB"};

    private MACARuleMatchingManager() {
    }

    @JvmStatic
    public static final void enable() {
        INSTANCE.loadMACARules();
        if (MACARules != null) {
            enabled = true;
        }
    }

    @JvmStatic
    public static final void generateInfo(@NotNull Bundle bundle, @NotNull String str) {
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(bundle, NativeProtocol.WEB_DIALOG_PARAMS);
        Intrinsics.checkNotNullParameter(str, "event");
        bundle.putString("event", str);
        StringBuilder sb2 = new StringBuilder();
        Utility utility = Utility.INSTANCE;
        Locale locale = utility.getLocale();
        String str4 = "";
        if (locale == null || (str2 = locale.getLanguage()) == null) {
            str2 = str4;
        }
        sb2.append(str2);
        sb2.append('_');
        Locale locale2 = utility.getLocale();
        if (locale2 == null || (str3 = locale2.getCountry()) == null) {
            str3 = str4;
        }
        sb2.append(str3);
        bundle.putString("_locale", sb2.toString());
        String versionName = utility.getVersionName();
        if (versionName == null) {
            versionName = str4;
        }
        bundle.putString("_appVersion", versionName);
        bundle.putString("_deviceOS", "ANDROID");
        bundle.putString("_platform", "mobile");
        String str5 = Build.MODEL;
        if (str5 == null) {
            str5 = str4;
        }
        bundle.putString("_deviceModel", str5);
        bundle.putString("_nativeAppID", FacebookSdk.getApplicationId());
        String versionName2 = utility.getVersionName();
        if (versionName2 != null) {
            str4 = versionName2;
        }
        bundle.putString("_nativeAppShortVersion", str4);
        bundle.putString("_timezone", utility.getDeviceTimeZoneName());
        bundle.putString("_carrier", utility.getCarrierName());
        bundle.putString("_deviceOSTypeName", "ANDROID");
        bundle.putString("_deviceOSVersion", Build.VERSION.RELEASE);
        bundle.putLong("_remainingDiskGB", utility.getAvailableExternalStorageGB());
    }

    @JvmStatic
    @Nullable
    public static final String getKey(@NotNull JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "logic");
        Iterator<String> keys2 = jSONObject.keys();
        if (keys2.hasNext()) {
            return keys2.next();
        }
        return null;
    }

    @JvmStatic
    @NotNull
    public static final String getMatchPropertyIDs(@Nullable Bundle bundle) {
        Integer num;
        String optString;
        JSONArray jSONArray = MACARules;
        if (jSONArray == null) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        if (jSONArray == null) {
            num = null;
        } else {
            num = Integer.valueOf(jSONArray.length());
        }
        if (num != null && num.intValue() == 0) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        JSONArray jSONArray2 = MACARules;
        if (jSONArray2 != null) {
            ArrayList arrayList = new ArrayList();
            int length = jSONArray2.length();
            if (length > 0) {
                int i11 = 0;
                while (true) {
                    int i12 = i11 + 1;
                    String optString2 = jSONArray2.optString(i11);
                    if (optString2 != null) {
                        JSONObject jSONObject = new JSONObject(optString2);
                        long optLong = jSONObject.optLong("id");
                        if (!(optLong == 0 || (optString = jSONObject.optString("rule")) == null || !isMatchCCRule(optString, bundle))) {
                            arrayList.add(Long.valueOf(optLong));
                        }
                    }
                    if (i12 >= length) {
                        break;
                    }
                    i11 = i12;
                }
            }
            String jSONArrayInstrumentation = JSONArrayInstrumentation.toString(new JSONArray((Collection<?>) arrayList));
            Intrinsics.checkNotNullExpressionValue(jSONArrayInstrumentation, "JSONArray(res).toString()");
            return jSONArrayInstrumentation;
        }
        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONArray");
    }

    @JvmStatic
    @Nullable
    public static final ArrayList<String> getStringArrayList(@Nullable JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        int length = jSONArray.length();
        if (length > 0) {
            int i11 = 0;
            while (true) {
                int i12 = i11 + 1;
                arrayList.add(jSONArray.get(i11).toString());
                if (i12 >= length) {
                    break;
                }
                i11 = i12;
            }
        }
        return arrayList;
    }

    @JvmStatic
    public static final boolean isMatchCCRule(@Nullable String str, @Nullable Bundle bundle) {
        JSONObject jSONObject;
        String key;
        int length;
        if (str == null || bundle == null || (key = getKey(jSONObject)) == null) {
            return false;
        }
        Object obj = (jSONObject = new JSONObject(str)).get(key);
        int hashCode = key.hashCode();
        if (hashCode != 3555) {
            if (hashCode != 96727) {
                if (hashCode == 109267 && key.equals("not")) {
                    return !isMatchCCRule(obj.toString(), bundle);
                }
            } else if (key.equals("and")) {
                JSONArray jSONArray = (JSONArray) obj;
                if (jSONArray == null) {
                    return false;
                }
                int length2 = jSONArray.length();
                if (length2 > 0) {
                    int i11 = 0;
                    while (true) {
                        int i12 = i11 + 1;
                        if (!isMatchCCRule(jSONArray.get(i11).toString(), bundle)) {
                            return false;
                        }
                        if (i12 >= length2) {
                            break;
                        }
                        i11 = i12;
                    }
                }
                return true;
            }
        } else if (key.equals("or")) {
            JSONArray jSONArray2 = (JSONArray) obj;
            if (jSONArray2 != null && (length = jSONArray2.length()) > 0) {
                int i13 = 0;
                while (true) {
                    int i14 = i13 + 1;
                    if (isMatchCCRule(jSONArray2.get(i13).toString(), bundle)) {
                        return true;
                    }
                    if (i14 >= length) {
                        break;
                    }
                    i13 = i14;
                }
            }
            return false;
        }
        JSONObject jSONObject2 = (JSONObject) obj;
        if (jSONObject2 == null) {
            return false;
        }
        return stringComparison(key, jSONObject2, bundle);
    }

    private final void loadMACARules() {
        FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
        FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
        if (queryAppSettings != null) {
            MACARules = queryAppSettings.getMACARuleMatchingSetting();
        }
    }

    @JvmStatic
    public static final void processParameters(@Nullable Bundle bundle, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "event");
        if (enabled && bundle != null) {
            try {
                generateInfo(bundle, str);
                bundle.putString("_audiencePropertyIds", getMatchPropertyIDs(bundle));
                bundle.putString("cs_maca", "1");
                removeGeneratedInfo(bundle);
            } catch (Exception unused) {
            }
        }
    }

    @JvmStatic
    public static final void removeGeneratedInfo(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, NativeProtocol.WEB_DIALOG_PARAMS);
        String[] strArr = keys;
        int length = strArr.length;
        int i11 = 0;
        while (i11 < length) {
            String str = strArr[i11];
            i11++;
            bundle.remove(str);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0238, code lost:
        if (java.lang.Double.parseDouble(r5.toString()) >= java.lang.Double.parseDouble(r2)) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0247, code lost:
        if (r9 != null) goto L_0x024a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0249, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x024e, code lost:
        if (r9.isEmpty() == false) goto L_0x0251;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0251, code lost:
        r8 = r9.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0259, code lost:
        if (r8.hasNext() == false) goto L_0x023a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x025b, code lost:
        r9 = (java.lang.String) r8.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0261, code lost:
        if (r9 == null) goto L_0x0288;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0263, code lost:
        r10 = java.util.Locale.ROOT;
        r9 = r9.toLowerCase(r10);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
        r0 = r5.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0270, code lost:
        if (r0 == null) goto L_0x0282;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0272, code lost:
        r10 = r0.toLowerCase(r10);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x027e, code lost:
        if ((!kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r10)) != false) goto L_0x0255;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0287, code lost:
        throw new java.lang.NullPointerException("null cannot be cast to non-null type java.lang.String");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x028d, code lost:
        throw new java.lang.NullPointerException("null cannot be cast to non-null type java.lang.String");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x0298, code lost:
        if (r9 != null) goto L_0x029b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x029a, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x029f, code lost:
        if (r9.isEmpty() == false) goto L_0x02a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x02a3, code lost:
        r8 = r9.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x02ab, code lost:
        if (r8.hasNext() == false) goto L_0x03be;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x02ad, code lost:
        r9 = (java.lang.String) r8.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x02b3, code lost:
        if (r9 == null) goto L_0x02d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x02b5, code lost:
        r10 = java.util.Locale.ROOT;
        r9 = r9.toLowerCase(r10);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
        r0 = r5.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x02c2, code lost:
        if (r0 == null) goto L_0x02d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x02c4, code lost:
        r10 = r0.toLowerCase(r10);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x02cf, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r10) == false) goto L_0x02a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x02d8, code lost:
        throw new java.lang.NullPointerException("null cannot be cast to non-null type java.lang.String");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x02de, code lost:
        throw new java.lang.NullPointerException("null cannot be cast to non-null type java.lang.String");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x0368, code lost:
        if (r9 != null) goto L_0x036b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x036a, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x037d, code lost:
        if (r9 != null) goto L_0x0380;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x037f, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:205:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:206:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:?, code lost:
        return kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5.toString(), (java.lang.Object) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:208:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:209:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:214:?, code lost:
        return r9.contains(r5.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:215:?, code lost:
        return r9.contains(r5.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:243:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:252:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:253:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01b3, code lost:
        if (java.lang.Double.parseDouble(r5.toString()) < java.lang.Double.parseDouble(r2)) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01d9, code lost:
        if (java.lang.Double.parseDouble(r5.toString()) > java.lang.Double.parseDouble(r2)) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01ee, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5.toString(), (java.lang.Object) r2) != false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0209, code lost:
        if (java.lang.Double.parseDouble(r5.toString()) <= java.lang.Double.parseDouble(r2)) goto L_?;
     */
    @kotlin.jvm.JvmStatic
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean stringComparison(@org.jetbrains.annotations.NotNull java.lang.String r8, @org.jetbrains.annotations.NotNull org.json.JSONObject r9, @org.jetbrains.annotations.Nullable android.os.Bundle r10) {
        /*
            java.lang.String r0 = "variable"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "values"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = getKey(r9)
            r1 = 0
            if (r0 != 0) goto L_0x0012
            return r1
        L_0x0012:
            java.lang.Object r2 = r9.get(r0)
            java.lang.String r2 = r2.toString()
            org.json.JSONArray r9 = r9.optJSONArray(r0)
            java.util.ArrayList r9 = getStringArrayList(r9)
            java.lang.String r3 = "exists"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r3)
            r4 = 0
            if (r3 == 0) goto L_0x0043
            if (r10 != 0) goto L_0x002e
            goto L_0x0036
        L_0x002e:
            boolean r8 = r10.containsKey(r8)
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r8)
        L_0x0036:
            boolean r8 = java.lang.Boolean.parseBoolean(r2)
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r8)
            return r8
        L_0x0043:
            java.lang.String r3 = "(this as java.lang.Strin….toLowerCase(Locale.ROOT)"
            if (r10 != 0) goto L_0x0049
            r5 = r4
            goto L_0x0056
        L_0x0049:
            java.util.Locale r5 = java.util.Locale.ROOT
            java.lang.String r5 = r8.toLowerCase(r5)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r3)
            java.lang.Object r5 = r10.get(r5)
        L_0x0056:
            if (r5 != 0) goto L_0x0064
            if (r10 != 0) goto L_0x005c
            r5 = r4
            goto L_0x0061
        L_0x005c:
            java.lang.Object r8 = r10.get(r8)
            r5 = r8
        L_0x0061:
            if (r5 != 0) goto L_0x0064
            return r1
        L_0x0064:
            int r8 = r0.hashCode()
            r10 = 2
            r6 = 1
            java.lang.String r7 = "null cannot be cast to non-null type java.lang.String"
            switch(r8) {
                case -1729128927: goto L_0x0389;
                case -1179774633: goto L_0x0374;
                case -1039699439: goto L_0x035f;
                case -969266188: goto L_0x034c;
                case -966353971: goto L_0x0333;
                case -665609109: goto L_0x0329;
                case -567445985: goto L_0x0315;
                case -327990090: goto L_0x02df;
                case -159812115: goto L_0x028e;
                case -92753547: goto L_0x023d;
                case 60: goto L_0x0220;
                case 61: goto L_0x020c;
                case 62: goto L_0x01f1;
                case 1084: goto L_0x01dc;
                case 1921: goto L_0x01c1;
                case 1952: goto L_0x01b7;
                case 1983: goto L_0x019b;
                case 3244: goto L_0x0191;
                case 3294: goto L_0x0187;
                case 3309: goto L_0x017d;
                case 3365: goto L_0x0173;
                case 3449: goto L_0x0169;
                case 3464: goto L_0x015f;
                case 3511: goto L_0x0155;
                case 102680: goto L_0x014b;
                case 107485: goto L_0x0141;
                case 108954: goto L_0x0137;
                case 127966736: goto L_0x0103;
                case 127966857: goto L_0x00f9;
                case 363990325: goto L_0x00c5;
                case 1091487233: goto L_0x00bb;
                case 1918401035: goto L_0x00a5;
                case 1961112862: goto L_0x0071;
                default: goto L_0x006f;
            }
        L_0x006f:
            goto L_0x03be
        L_0x0071:
            java.lang.String r8 = "i_starts_with"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x007b
            goto L_0x03be
        L_0x007b:
            java.lang.String r8 = r5.toString()
            if (r8 == 0) goto L_0x009f
            java.util.Locale r9 = java.util.Locale.ROOT
            java.lang.String r8 = r8.toLowerCase(r9)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r3)
            if (r2 == 0) goto L_0x0099
            java.lang.String r9 = r2.toLowerCase(r9)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r3)
            boolean r1 = kotlin.text.StringsKt__StringsJVMKt.startsWith$default(r8, r9, r1, r10, r4)
            goto L_0x03be
        L_0x0099:
            java.lang.NullPointerException r8 = new java.lang.NullPointerException
            r8.<init>(r7)
            throw r8
        L_0x009f:
            java.lang.NullPointerException r8 = new java.lang.NullPointerException
            r8.<init>(r7)
            throw r8
        L_0x00a5:
            java.lang.String r8 = "not_contains"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x00af
            goto L_0x03be
        L_0x00af:
            java.lang.String r8 = r5.toString()
            boolean r8 = kotlin.text.StringsKt__StringsKt.contains$default((java.lang.CharSequence) r8, (java.lang.CharSequence) r2, (boolean) r1, (int) r10, (java.lang.Object) r4)
            if (r8 != 0) goto L_0x03be
            goto L_0x023a
        L_0x00bb:
            java.lang.String r8 = "i_is_not_any"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x0247
            goto L_0x03be
        L_0x00c5:
            java.lang.String r8 = "i_contains"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x00cf
            goto L_0x03be
        L_0x00cf:
            java.lang.String r8 = r5.toString()
            if (r8 == 0) goto L_0x00f3
            java.util.Locale r9 = java.util.Locale.ROOT
            java.lang.String r8 = r8.toLowerCase(r9)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r3)
            if (r2 == 0) goto L_0x00ed
            java.lang.String r9 = r2.toLowerCase(r9)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r3)
            boolean r1 = kotlin.text.StringsKt__StringsKt.contains$default((java.lang.CharSequence) r8, (java.lang.CharSequence) r9, (boolean) r1, (int) r10, (java.lang.Object) r4)
            goto L_0x03be
        L_0x00ed:
            java.lang.NullPointerException r8 = new java.lang.NullPointerException
            r8.<init>(r7)
            throw r8
        L_0x00f3:
            java.lang.NullPointerException r8 = new java.lang.NullPointerException
            r8.<init>(r7)
            throw r8
        L_0x00f9:
            java.lang.String r8 = "i_str_in"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x0298
            goto L_0x03be
        L_0x0103:
            java.lang.String r8 = "i_str_eq"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x010d
            goto L_0x03be
        L_0x010d:
            java.lang.String r8 = r5.toString()
            if (r8 == 0) goto L_0x0131
            java.util.Locale r9 = java.util.Locale.ROOT
            java.lang.String r8 = r8.toLowerCase(r9)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r3)
            if (r2 == 0) goto L_0x012b
            java.lang.String r9 = r2.toLowerCase(r9)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r3)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r9)
            goto L_0x03be
        L_0x012b:
            java.lang.NullPointerException r8 = new java.lang.NullPointerException
            r8.<init>(r7)
            throw r8
        L_0x0131:
            java.lang.NullPointerException r8 = new java.lang.NullPointerException
            r8.<init>(r7)
            throw r8
        L_0x0137:
            java.lang.String r8 = "neq"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x01e6
            goto L_0x03be
        L_0x0141:
            java.lang.String r8 = "lte"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x01cb
            goto L_0x03be
        L_0x014b:
            java.lang.String r8 = "gte"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x01a5
            goto L_0x03be
        L_0x0155:
            java.lang.String r8 = "ne"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x01e6
            goto L_0x03be
        L_0x015f:
            java.lang.String r8 = "lt"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x022a
            goto L_0x03be
        L_0x0169:
            java.lang.String r8 = "le"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x01cb
            goto L_0x03be
        L_0x0173:
            java.lang.String r8 = "in"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x037d
            goto L_0x03be
        L_0x017d:
            java.lang.String r8 = "gt"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x01fb
            goto L_0x03be
        L_0x0187:
            java.lang.String r8 = "ge"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x01a5
            goto L_0x03be
        L_0x0191:
            java.lang.String r8 = "eq"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x0216
            goto L_0x03be
        L_0x019b:
            java.lang.String r8 = ">="
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x01a5
            goto L_0x03be
        L_0x01a5:
            java.lang.String r8 = r5.toString()
            double r8 = java.lang.Double.parseDouble(r8)
            double r2 = java.lang.Double.parseDouble(r2)
            int r8 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r8 < 0) goto L_0x03be
            goto L_0x023a
        L_0x01b7:
            java.lang.String r8 = "=="
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x0216
            goto L_0x03be
        L_0x01c1:
            java.lang.String r8 = "<="
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x01cb
            goto L_0x03be
        L_0x01cb:
            java.lang.String r8 = r5.toString()
            double r8 = java.lang.Double.parseDouble(r8)
            double r2 = java.lang.Double.parseDouble(r2)
            int r8 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r8 > 0) goto L_0x03be
            goto L_0x023a
        L_0x01dc:
            java.lang.String r8 = "!="
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x01e6
            goto L_0x03be
        L_0x01e6:
            java.lang.String r8 = r5.toString()
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r2)
            if (r8 != 0) goto L_0x03be
            goto L_0x023a
        L_0x01f1:
            java.lang.String r8 = ">"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x01fb
            goto L_0x03be
        L_0x01fb:
            java.lang.String r8 = r5.toString()
            double r8 = java.lang.Double.parseDouble(r8)
            double r2 = java.lang.Double.parseDouble(r2)
            int r8 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r8 <= 0) goto L_0x03be
            goto L_0x023a
        L_0x020c:
            java.lang.String r8 = "="
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x0216
            goto L_0x03be
        L_0x0216:
            java.lang.String r8 = r5.toString()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r2)
            goto L_0x03be
        L_0x0220:
            java.lang.String r8 = "<"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x022a
            goto L_0x03be
        L_0x022a:
            java.lang.String r8 = r5.toString()
            double r8 = java.lang.Double.parseDouble(r8)
            double r2 = java.lang.Double.parseDouble(r2)
            int r8 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r8 >= 0) goto L_0x03be
        L_0x023a:
            r1 = r6
            goto L_0x03be
        L_0x023d:
            java.lang.String r8 = "i_str_not_in"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x0247
            goto L_0x03be
        L_0x0247:
            if (r9 != 0) goto L_0x024a
            return r1
        L_0x024a:
            boolean r8 = r9.isEmpty()
            if (r8 == 0) goto L_0x0251
            goto L_0x023a
        L_0x0251:
            java.util.Iterator r8 = r9.iterator()
        L_0x0255:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x023a
            java.lang.Object r9 = r8.next()
            java.lang.String r9 = (java.lang.String) r9
            if (r9 == 0) goto L_0x0288
            java.util.Locale r10 = java.util.Locale.ROOT
            java.lang.String r9 = r9.toLowerCase(r10)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r3)
            java.lang.String r0 = r5.toString()
            if (r0 == 0) goto L_0x0282
            java.lang.String r10 = r0.toLowerCase(r10)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r3)
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r10)
            r9 = r9 ^ r6
            if (r9 != 0) goto L_0x0255
            goto L_0x03be
        L_0x0282:
            java.lang.NullPointerException r8 = new java.lang.NullPointerException
            r8.<init>(r7)
            throw r8
        L_0x0288:
            java.lang.NullPointerException r8 = new java.lang.NullPointerException
            r8.<init>(r7)
            throw r8
        L_0x028e:
            java.lang.String r8 = "i_is_any"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x0298
            goto L_0x03be
        L_0x0298:
            if (r9 != 0) goto L_0x029b
            return r1
        L_0x029b:
            boolean r8 = r9.isEmpty()
            if (r8 == 0) goto L_0x02a3
            goto L_0x03be
        L_0x02a3:
            java.util.Iterator r8 = r9.iterator()
        L_0x02a7:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x03be
            java.lang.Object r9 = r8.next()
            java.lang.String r9 = (java.lang.String) r9
            if (r9 == 0) goto L_0x02d9
            java.util.Locale r10 = java.util.Locale.ROOT
            java.lang.String r9 = r9.toLowerCase(r10)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r3)
            java.lang.String r0 = r5.toString()
            if (r0 == 0) goto L_0x02d3
            java.lang.String r10 = r0.toLowerCase(r10)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r3)
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r10)
            if (r9 == 0) goto L_0x02a7
            goto L_0x023a
        L_0x02d3:
            java.lang.NullPointerException r8 = new java.lang.NullPointerException
            r8.<init>(r7)
            throw r8
        L_0x02d9:
            java.lang.NullPointerException r8 = new java.lang.NullPointerException
            r8.<init>(r7)
            throw r8
        L_0x02df:
            java.lang.String r8 = "i_str_neq"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x02e9
            goto L_0x03be
        L_0x02e9:
            java.lang.String r8 = r5.toString()
            if (r8 == 0) goto L_0x030f
            java.util.Locale r9 = java.util.Locale.ROOT
            java.lang.String r8 = r8.toLowerCase(r9)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r3)
            if (r2 == 0) goto L_0x0309
            java.lang.String r9 = r2.toLowerCase(r9)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r3)
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r9)
            if (r8 != 0) goto L_0x03be
            goto L_0x023a
        L_0x0309:
            java.lang.NullPointerException r8 = new java.lang.NullPointerException
            r8.<init>(r7)
            throw r8
        L_0x030f:
            java.lang.NullPointerException r8 = new java.lang.NullPointerException
            r8.<init>(r7)
            throw r8
        L_0x0315:
            java.lang.String r8 = "contains"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x031f
            goto L_0x03be
        L_0x031f:
            java.lang.String r8 = r5.toString()
            boolean r1 = kotlin.text.StringsKt__StringsKt.contains$default((java.lang.CharSequence) r8, (java.lang.CharSequence) r2, (boolean) r1, (int) r10, (java.lang.Object) r4)
            goto L_0x03be
        L_0x0329:
            java.lang.String r8 = "is_not_any"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x0368
            goto L_0x03be
        L_0x0333:
            java.lang.String r8 = "regex_match"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x033d
            goto L_0x03be
        L_0x033d:
            kotlin.text.Regex r8 = new kotlin.text.Regex
            r8.<init>((java.lang.String) r2)
            java.lang.String r9 = r5.toString()
            boolean r1 = r8.matches(r9)
            goto L_0x03be
        L_0x034c:
            java.lang.String r8 = "starts_with"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x0356
            goto L_0x03be
        L_0x0356:
            java.lang.String r8 = r5.toString()
            boolean r1 = kotlin.text.StringsKt__StringsJVMKt.startsWith$default(r8, r2, r1, r10, r4)
            goto L_0x03be
        L_0x035f:
            java.lang.String r8 = "not_in"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x0368
            goto L_0x03be
        L_0x0368:
            if (r9 != 0) goto L_0x036b
            return r1
        L_0x036b:
            java.lang.String r8 = r5.toString()
            boolean r1 = r9.contains(r8)
            goto L_0x03be
        L_0x0374:
            java.lang.String r8 = "is_any"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x037d
            goto L_0x03be
        L_0x037d:
            if (r9 != 0) goto L_0x0380
            return r1
        L_0x0380:
            java.lang.String r8 = r5.toString()
            boolean r1 = r9.contains(r8)
            goto L_0x03be
        L_0x0389:
            java.lang.String r8 = "i_not_contains"
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x0392
            goto L_0x03be
        L_0x0392:
            java.lang.String r8 = r5.toString()
            if (r8 == 0) goto L_0x03b8
            java.util.Locale r9 = java.util.Locale.ROOT
            java.lang.String r8 = r8.toLowerCase(r9)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r3)
            if (r2 == 0) goto L_0x03b2
            java.lang.String r9 = r2.toLowerCase(r9)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r3)
            boolean r8 = kotlin.text.StringsKt__StringsKt.contains$default((java.lang.CharSequence) r8, (java.lang.CharSequence) r9, (boolean) r1, (int) r10, (java.lang.Object) r4)
            if (r8 != 0) goto L_0x03be
            goto L_0x023a
        L_0x03b2:
            java.lang.NullPointerException r8 = new java.lang.NullPointerException
            r8.<init>(r7)
            throw r8
        L_0x03b8:
            java.lang.NullPointerException r8 = new java.lang.NullPointerException
            r8.<init>(r7)
            throw r8
        L_0x03be:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.integrity.MACARuleMatchingManager.stringComparison(java.lang.String, org.json.JSONObject, android.os.Bundle):boolean");
    }
}
