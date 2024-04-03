package com.facebook.appevents.suggestedevents;

import android.util.Patterns;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.huawei.location.nlp.network.OnlineLocationService;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.visa.checkout.PurchaseInfo;
import java.io.File;
import java.io.FileInputStream;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@Instrumented
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0006H\u0007J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0019\u001a\u00020\u0012H\u0002J \u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0007J\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0007J\u0010\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u0012H\u0002J\b\u0010#\u001a\u00020\u000fH\u0007J)\u0010$\u001a\u00020\u000f2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00060&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00060&H\u0002¢\u0006\u0002\u0010(J0\u0010)\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u00122\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0002J\u0010\u0010.\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u0012H\u0002J\u0018\u0010/\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u00122\u0006\u0010*\u001a\u00020+H\u0002J\u0018\u00100\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u0006H\u0002J(\u00100\u001a\u00020\u000f2\u0006\u00103\u001a\u00020\u00062\u0006\u00104\u001a\u00020\u00062\u0006\u00105\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u0006H\u0002J\u0018\u00106\u001a\u00020\u001e2\u0006\u00107\u001a\u00020\u00152\u0006\u00108\u001a\u00020\u0015H\u0002J(\u00109\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u00122\n\u0010:\u001a\u00060;j\u0002`<2\n\u0010=\u001a\u00060;j\u0002`<H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\rX.¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/facebook/appevents/suggestedevents/FeatureExtractor;", "", "()V", "NUM_OF_FEATURES", "", "REGEX_ADD_TO_CART_BUTTON_TEXT", "", "REGEX_ADD_TO_CART_PAGE_TITLE", "REGEX_CR_HAS_CONFIRM_PASSWORD_FIELD", "REGEX_CR_HAS_LOG_IN_KEYWORDS", "REGEX_CR_HAS_SIGN_ON_KEYWORDS", "REGEX_CR_PASSWORD_FIELD", "eventInfo", "", "initialized", "", "languageInfo", "rules", "Lorg/json/JSONObject;", "textTypeInfo", "getDenseFeatures", "", "viewHierarchy", "appName", "getInteractedNode", "view", "getTextFeature", "buttonText", "activityName", "initialize", "", "file", "Ljava/io/File;", "isButton", "node", "isInitialized", "matchIndicators", "indicators", "", "values", "([Ljava/lang/String;[Ljava/lang/String;)Z", "nonparseFeatures", "siblings", "Lorg/json/JSONArray;", "screenName", "formFieldsJSON", "parseFeatures", "pruneTree", "regexMatched", "pattern", "matchText", "language", "event", "textType", "sum", "a", "b", "updateHintAndTextRecursively", "textSB", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "hintSB", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@AutoHandleExceptions
public final class FeatureExtractor {
    @NotNull
    public static final FeatureExtractor INSTANCE = new FeatureExtractor();
    private static final int NUM_OF_FEATURES = 30;
    @NotNull
    private static final String REGEX_ADD_TO_CART_BUTTON_TEXT = "(?i)add to(\\s|\\Z)|update(\\s|\\Z)|cart";
    @NotNull
    private static final String REGEX_ADD_TO_CART_PAGE_TITLE = "(?i)add to(\\s|\\Z)|update(\\s|\\Z)|cart|shop|buy";
    @NotNull
    private static final String REGEX_CR_HAS_CONFIRM_PASSWORD_FIELD = "(?i)(confirm.*password)|(password.*(confirmation|confirm)|confirmation)";
    @NotNull
    private static final String REGEX_CR_HAS_LOG_IN_KEYWORDS = "(?i)(sign in)|login|signIn";
    @NotNull
    private static final String REGEX_CR_HAS_SIGN_ON_KEYWORDS = "(?i)(sign.*(up|now)|registration|register|(create|apply).*(profile|account)|open.*account|account.*(open|creation|application)|enroll|join.*now)";
    @NotNull
    private static final String REGEX_CR_PASSWORD_FIELD = "password";
    private static Map<String, String> eventInfo;
    private static boolean initialized;
    private static Map<String, String> languageInfo;
    private static JSONObject rules;
    private static Map<String, String> textTypeInfo;

    private FeatureExtractor() {
    }

    @JvmStatic
    @Nullable
    public static final float[] getDenseFeatures(@NotNull JSONObject jSONObject, @NotNull String str) {
        String str2;
        Intrinsics.checkNotNullParameter(jSONObject, "viewHierarchy");
        Intrinsics.checkNotNullParameter(str, AnalyticsAttribute.APP_NAME_ATTRIBUTE);
        if (!initialized) {
            return null;
        }
        float[] fArr = new float[30];
        for (int i11 = 0; i11 < 30; i11++) {
            fArr[i11] = 0.0f;
        }
        try {
            String lowerCase = str.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
            JSONObject optJSONObject = jSONObject.optJSONObject("view");
            if (!(optJSONObject instanceof JSONObject)) {
                str2 = optJSONObject.toString();
            } else {
                str2 = JSONObjectInstrumentation.toString(optJSONObject);
            }
            JSONObject jSONObject2 = new JSONObject(str2);
            String optString = jSONObject.optString(ViewHierarchyConstants.SCREEN_NAME_KEY);
            JSONArray jSONArray = new JSONArray();
            FeatureExtractor featureExtractor = INSTANCE;
            featureExtractor.pruneTree(jSONObject2, jSONArray);
            featureExtractor.sum(fArr, featureExtractor.parseFeatures(jSONObject2));
            JSONObject interactedNode = featureExtractor.getInteractedNode(jSONObject2);
            if (interactedNode == null) {
                return null;
            }
            Intrinsics.checkNotNullExpressionValue(optString, "screenName");
            String jSONObjectInstrumentation = JSONObjectInstrumentation.toString(jSONObject2);
            Intrinsics.checkNotNullExpressionValue(jSONObjectInstrumentation, "viewTree.toString()");
            featureExtractor.sum(fArr, featureExtractor.nonparseFeatures(interactedNode, jSONArray, optString, jSONObjectInstrumentation, lowerCase));
            return fArr;
        } catch (JSONException unused) {
        }
    }

    private final JSONObject getInteractedNode(JSONObject jSONObject) {
        int length;
        try {
            if (jSONObject.optBoolean(ViewHierarchyConstants.IS_INTERACTED_KEY)) {
                return jSONObject;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray(ViewHierarchyConstants.CHILDREN_VIEW_KEY);
            if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
                int i11 = 0;
                while (true) {
                    int i12 = i11 + 1;
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i11);
                    Intrinsics.checkNotNullExpressionValue(jSONObject2, "children.getJSONObject(i)");
                    JSONObject interactedNode = getInteractedNode(jSONObject2);
                    if (interactedNode != null) {
                        return interactedNode;
                    }
                    if (i12 >= length) {
                        break;
                    }
                    i11 = i12;
                }
            }
            return null;
        } catch (JSONException unused) {
        }
    }

    @JvmStatic
    @NotNull
    public static final String getTextFeature(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "buttonText");
        Intrinsics.checkNotNullParameter(str2, "activityName");
        Intrinsics.checkNotNullParameter(str3, AnalyticsAttribute.APP_NAME_ATTRIBUTE);
        String str4 = str3 + " | " + str2 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + str;
        if (str4 != null) {
            String lowerCase = str4.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
            return lowerCase;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    @JvmStatic
    public static final void initialize(@Nullable File file) {
        try {
            rules = new JSONObject();
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            fileInputStream.close();
            rules = new JSONObject(new String(bArr, Charsets.UTF_8));
            languageInfo = MapsKt__MapsKt.mapOf(TuplesKt.to(ViewHierarchyConstants.ENGLISH, "1"), TuplesKt.to(ViewHierarchyConstants.GERMAN, ExifInterface.GPS_MEASUREMENT_2D), TuplesKt.to(ViewHierarchyConstants.SPANISH, ExifInterface.GPS_MEASUREMENT_3D), TuplesKt.to(ViewHierarchyConstants.JAPANESE, OnlineLocationService.SRC_DEFAULT));
            eventInfo = MapsKt__MapsKt.mapOf(TuplesKt.to(ViewHierarchyConstants.VIEW_CONTENT, "0"), TuplesKt.to(ViewHierarchyConstants.SEARCH, "1"), TuplesKt.to(ViewHierarchyConstants.ADD_TO_CART, ExifInterface.GPS_MEASUREMENT_2D), TuplesKt.to(ViewHierarchyConstants.ADD_TO_WISHLIST, ExifInterface.GPS_MEASUREMENT_3D), TuplesKt.to(ViewHierarchyConstants.INITIATE_CHECKOUT, OnlineLocationService.SRC_DEFAULT), TuplesKt.to(ViewHierarchyConstants.ADD_PAYMENT_INFO, "5"), TuplesKt.to(ViewHierarchyConstants.PURCHASE, "6"), TuplesKt.to(ViewHierarchyConstants.LEAD, "7"), TuplesKt.to(ViewHierarchyConstants.COMPLETE_REGISTRATION, "8"));
            textTypeInfo = MapsKt__MapsKt.mapOf(TuplesKt.to(ViewHierarchyConstants.BUTTON_TEXT, "1"), TuplesKt.to(ViewHierarchyConstants.PAGE_TITLE, ExifInterface.GPS_MEASUREMENT_2D), TuplesKt.to(ViewHierarchyConstants.RESOLVED_DOCUMENT_LINK, ExifInterface.GPS_MEASUREMENT_3D), TuplesKt.to(ViewHierarchyConstants.BUTTON_ID, OnlineLocationService.SRC_DEFAULT));
            initialized = true;
        } catch (Exception unused) {
        }
    }

    private final boolean isButton(JSONObject jSONObject) {
        if (((jSONObject.optInt(ViewHierarchyConstants.CLASS_TYPE_BITMASK_KEY) & 1) << 5) > 0) {
            return true;
        }
        return false;
    }

    @JvmStatic
    public static final boolean isInitialized() {
        return initialized;
    }

    private final boolean matchIndicators(String[] strArr, String[] strArr2) {
        int length = strArr.length;
        int i11 = 0;
        while (i11 < length) {
            String str = strArr[i11];
            i11++;
            int length2 = strArr2.length;
            int i12 = 0;
            while (true) {
                if (i12 < length2) {
                    String str2 = strArr2[i12];
                    i12++;
                    if (StringsKt__StringsKt.contains$default((CharSequence) str2, (CharSequence) str, false, 2, (Object) null)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private final float[] nonparseFeatures(JSONObject jSONObject, JSONArray jSONArray, String str, String str2, String str3) {
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        float f17;
        float f18;
        float f19;
        float f21;
        float f22;
        float f23;
        float f24;
        float f25;
        float[] fArr = new float[30];
        int i11 = 0;
        while (true) {
            f11 = 0.0f;
            if (i11 >= 30) {
                break;
            }
            fArr[i11] = 0.0f;
            i11++;
        }
        int length = jSONArray.length();
        if (length > 1) {
            f12 = ((float) length) - 1.0f;
        } else {
            f12 = 0.0f;
        }
        fArr[3] = f12;
        try {
            int length2 = jSONArray.length();
            if (length2 > 0) {
                int i12 = 0;
                while (true) {
                    int i13 = i12 + 1;
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i12);
                    Intrinsics.checkNotNullExpressionValue(jSONObject2, "siblings.getJSONObject(i)");
                    if (isButton(jSONObject2)) {
                        fArr[9] = fArr[9] + 1.0f;
                    }
                    if (i13 >= length2) {
                        break;
                    }
                    i12 = i13;
                }
            }
        } catch (JSONException unused) {
        }
        fArr[13] = -1.0f;
        fArr[14] = -1.0f;
        String str4 = str + '|' + str3;
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        updateHintAndTextRecursively(jSONObject, sb3, sb2);
        String sb4 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb4, "hintSB.toString()");
        String sb5 = sb3.toString();
        Intrinsics.checkNotNullExpressionValue(sb5, "textSB.toString()");
        if (regexMatched(ViewHierarchyConstants.ENGLISH, ViewHierarchyConstants.COMPLETE_REGISTRATION, ViewHierarchyConstants.BUTTON_TEXT, sb5)) {
            f13 = 1.0f;
        } else {
            f13 = 0.0f;
        }
        fArr[15] = f13;
        if (regexMatched(ViewHierarchyConstants.ENGLISH, ViewHierarchyConstants.COMPLETE_REGISTRATION, ViewHierarchyConstants.PAGE_TITLE, str4)) {
            f14 = 1.0f;
        } else {
            f14 = 0.0f;
        }
        fArr[16] = f14;
        if (regexMatched(ViewHierarchyConstants.ENGLISH, ViewHierarchyConstants.COMPLETE_REGISTRATION, ViewHierarchyConstants.BUTTON_ID, sb4)) {
            f15 = 1.0f;
        } else {
            f15 = 0.0f;
        }
        fArr[17] = f15;
        if (StringsKt__StringsKt.contains$default((CharSequence) str2, (CharSequence) "password", false, 2, (Object) null)) {
            f16 = 1.0f;
        } else {
            f16 = 0.0f;
        }
        fArr[18] = f16;
        if (regexMatched(REGEX_CR_HAS_CONFIRM_PASSWORD_FIELD, str2)) {
            f17 = 1.0f;
        } else {
            f17 = 0.0f;
        }
        fArr[19] = f17;
        if (regexMatched(REGEX_CR_HAS_LOG_IN_KEYWORDS, str2)) {
            f18 = 1.0f;
        } else {
            f18 = 0.0f;
        }
        fArr[20] = f18;
        if (regexMatched(REGEX_CR_HAS_SIGN_ON_KEYWORDS, str2)) {
            f19 = 1.0f;
        } else {
            f19 = 0.0f;
        }
        fArr[21] = f19;
        if (regexMatched(ViewHierarchyConstants.ENGLISH, ViewHierarchyConstants.PURCHASE, ViewHierarchyConstants.BUTTON_TEXT, sb5)) {
            f21 = 1.0f;
        } else {
            f21 = 0.0f;
        }
        fArr[22] = f21;
        if (regexMatched(ViewHierarchyConstants.ENGLISH, ViewHierarchyConstants.PURCHASE, ViewHierarchyConstants.PAGE_TITLE, str4)) {
            f22 = 1.0f;
        } else {
            f22 = 0.0f;
        }
        fArr[24] = f22;
        if (regexMatched(REGEX_ADD_TO_CART_BUTTON_TEXT, sb5)) {
            f23 = 1.0f;
        } else {
            f23 = 0.0f;
        }
        fArr[25] = f23;
        if (regexMatched(REGEX_ADD_TO_CART_PAGE_TITLE, str4)) {
            f24 = 1.0f;
        } else {
            f24 = 0.0f;
        }
        fArr[27] = f24;
        if (regexMatched(ViewHierarchyConstants.ENGLISH, ViewHierarchyConstants.LEAD, ViewHierarchyConstants.BUTTON_TEXT, sb5)) {
            f25 = 1.0f;
        } else {
            f25 = 0.0f;
        }
        fArr[28] = f25;
        if (regexMatched(ViewHierarchyConstants.ENGLISH, ViewHierarchyConstants.LEAD, ViewHierarchyConstants.PAGE_TITLE, str4)) {
            f11 = 1.0f;
        }
        fArr[29] = f11;
        return fArr;
    }

    private final float[] parseFeatures(JSONObject jSONObject) {
        float[] fArr = new float[30];
        int i11 = 0;
        for (int i12 = 0; i12 < 30; i12++) {
            fArr[i12] = 0.0f;
        }
        String optString = jSONObject.optString("text");
        Intrinsics.checkNotNullExpressionValue(optString, "node.optString(TEXT_KEY)");
        String lowerCase = optString.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
        String optString2 = jSONObject.optString(ViewHierarchyConstants.HINT_KEY);
        Intrinsics.checkNotNullExpressionValue(optString2, "node.optString(HINT_KEY)");
        String lowerCase2 = optString2.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.String).toLowerCase()");
        String optString3 = jSONObject.optString(ViewHierarchyConstants.CLASS_NAME_KEY);
        Intrinsics.checkNotNullExpressionValue(optString3, "node.optString(CLASS_NAME_KEY)");
        String lowerCase3 = optString3.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase3, "(this as java.lang.String).toLowerCase()");
        int optInt = jSONObject.optInt(ViewHierarchyConstants.INPUT_TYPE_KEY, -1);
        String[] strArr = {lowerCase, lowerCase2};
        if (matchIndicators(new String[]{"$", "amount", FirebaseAnalytics.Param.PRICE, PurchaseInfo.TOTAL}, strArr)) {
            fArr[0] = fArr[0] + 1.0f;
        }
        if (matchIndicators(new String[]{"password", "pwd"}, strArr)) {
            fArr[1] = fArr[1] + 1.0f;
        }
        if (matchIndicators(new String[]{"tel", "phone"}, strArr)) {
            fArr[2] = fArr[2] + 1.0f;
        }
        if (matchIndicators(new String[]{"search"}, strArr)) {
            fArr[4] = fArr[4] + 1.0f;
        }
        if (optInt >= 0) {
            fArr[5] = fArr[5] + 1.0f;
        }
        if (optInt == 3 || optInt == 2) {
            fArr[6] = fArr[6] + 1.0f;
        }
        if (optInt == 32 || Patterns.EMAIL_ADDRESS.matcher(lowerCase).matches()) {
            fArr[7] = fArr[7] + 1.0f;
        }
        if (StringsKt__StringsKt.contains$default((CharSequence) lowerCase3, (CharSequence) "checkbox", false, 2, (Object) null)) {
            fArr[8] = fArr[8] + 1.0f;
        }
        if (matchIndicators(new String[]{"complete", "confirm", "done", "submit"}, new String[]{lowerCase})) {
            fArr[10] = fArr[10] + 1.0f;
        }
        if (StringsKt__StringsKt.contains$default((CharSequence) lowerCase3, (CharSequence) "radio", false, 2, (Object) null) && StringsKt__StringsKt.contains$default((CharSequence) lowerCase3, (CharSequence) "button", false, 2, (Object) null)) {
            fArr[12] = fArr[12] + 1.0f;
        }
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray(ViewHierarchyConstants.CHILDREN_VIEW_KEY);
            int length = optJSONArray.length();
            if (length > 0) {
                while (true) {
                    int i13 = i11 + 1;
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i11);
                    Intrinsics.checkNotNullExpressionValue(jSONObject2, "childViews.getJSONObject(i)");
                    sum(fArr, parseFeatures(jSONObject2));
                    if (i13 >= length) {
                        break;
                    }
                    i11 = i13;
                }
            }
        } catch (JSONException unused) {
        }
        return fArr;
    }

    private final boolean pruneTree(JSONObject jSONObject, JSONArray jSONArray) {
        boolean z11;
        try {
            if (jSONObject.optBoolean(ViewHierarchyConstants.IS_INTERACTED_KEY)) {
                return true;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray(ViewHierarchyConstants.CHILDREN_VIEW_KEY);
            int length = optJSONArray.length();
            if (length > 0) {
                int i11 = 0;
                while (true) {
                    int i12 = i11 + 1;
                    if (optJSONArray.getJSONObject(i11).optBoolean(ViewHierarchyConstants.IS_INTERACTED_KEY)) {
                        z11 = true;
                        break;
                    } else if (i12 >= length) {
                        break;
                    } else {
                        i11 = i12;
                    }
                }
            }
            z11 = false;
            boolean z12 = z11;
            JSONArray jSONArray2 = new JSONArray();
            if (z11) {
                int length2 = optJSONArray.length();
                if (length2 > 0) {
                    int i13 = 0;
                    while (true) {
                        int i14 = i13 + 1;
                        jSONArray.put((Object) optJSONArray.getJSONObject(i13));
                        if (i14 >= length2) {
                            break;
                        }
                        i13 = i14;
                    }
                }
            } else {
                int length3 = optJSONArray.length();
                if (length3 > 0) {
                    int i15 = 0;
                    while (true) {
                        int i16 = i15 + 1;
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i15);
                        Intrinsics.checkNotNullExpressionValue(jSONObject2, "child");
                        if (pruneTree(jSONObject2, jSONArray)) {
                            jSONArray2.put((Object) jSONObject2);
                            z12 = true;
                        }
                        if (i16 >= length3) {
                            break;
                        }
                        i15 = i16;
                    }
                }
                jSONObject.put(ViewHierarchyConstants.CHILDREN_VIEW_KEY, (Object) jSONArray2);
            }
            return z12;
        } catch (JSONException unused) {
            return false;
        }
    }

    private final boolean regexMatched(String str, String str2, String str3, String str4) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject jSONObject3 = rules;
        String str5 = null;
        if (jSONObject3 != null) {
            JSONObject optJSONObject3 = jSONObject3.optJSONObject("rulesForLanguage");
            if (optJSONObject3 == null) {
                jSONObject = null;
            } else {
                Map<String, String> map = languageInfo;
                if (map != null) {
                    jSONObject = optJSONObject3.optJSONObject(map.get(str));
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("languageInfo");
                    throw null;
                }
            }
            if (jSONObject == null || (optJSONObject2 = jSONObject.optJSONObject("rulesForEvent")) == null) {
                jSONObject2 = null;
            } else {
                Map<String, String> map2 = eventInfo;
                if (map2 != null) {
                    jSONObject2 = optJSONObject2.optJSONObject(map2.get(str2));
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("eventInfo");
                    throw null;
                }
            }
            if (!(jSONObject2 == null || (optJSONObject = jSONObject2.optJSONObject("positiveRules")) == null)) {
                Map<String, String> map3 = textTypeInfo;
                if (map3 != null) {
                    str5 = optJSONObject.optString(map3.get(str3));
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("textTypeInfo");
                    throw null;
                }
            }
            if (str5 == null) {
                return false;
            }
            return regexMatched(str5, str4);
        }
        Intrinsics.throwUninitializedPropertyAccessException("rules");
        throw null;
    }

    private final void sum(float[] fArr, float[] fArr2) {
        int length = fArr.length - 1;
        if (length >= 0) {
            int i11 = 0;
            while (true) {
                int i12 = i11 + 1;
                fArr[i11] = fArr[i11] + fArr2[i11];
                if (i12 <= length) {
                    i11 = i12;
                } else {
                    return;
                }
            }
        }
    }

    private final void updateHintAndTextRecursively(JSONObject jSONObject, StringBuilder sb2, StringBuilder sb3) {
        boolean z11;
        int length;
        String optString = jSONObject.optString("text", "");
        Intrinsics.checkNotNullExpressionValue(optString, "view.optString(TEXT_KEY, \"\")");
        String lowerCase = optString.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
        String optString2 = jSONObject.optString(ViewHierarchyConstants.HINT_KEY, "");
        Intrinsics.checkNotNullExpressionValue(optString2, "view.optString(HINT_KEY, \"\")");
        String lowerCase2 = optString2.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.String).toLowerCase()");
        boolean z12 = true;
        int i11 = 0;
        if (lowerCase.length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            sb2.append(lowerCase);
            sb2.append(" ");
        }
        if (lowerCase2.length() <= 0) {
            z12 = false;
        }
        if (z12) {
            sb3.append(lowerCase2);
            sb3.append(" ");
        }
        JSONArray optJSONArray = jSONObject.optJSONArray(ViewHierarchyConstants.CHILDREN_VIEW_KEY);
        if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
            while (true) {
                int i12 = i11 + 1;
                try {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i11);
                    Intrinsics.checkNotNullExpressionValue(jSONObject2, "currentChildView");
                    updateHintAndTextRecursively(jSONObject2, sb2, sb3);
                } catch (JSONException unused) {
                }
                if (i12 < length) {
                    i11 = i12;
                } else {
                    return;
                }
            }
        }
    }

    private final boolean regexMatched(String str, String str2) {
        return Pattern.compile(str).matcher(str2).find();
    }
}
