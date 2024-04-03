package io.flutter.embedding.engine.systemchannels;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.facebook.internal.NativeProtocol;
import com.huawei.hms.push.constant.RemoteMessageConst;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.JSONMethodCodec;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.editing.TextEditingDelta;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public class TextInputChannel {
    private static final String TAG = "TextInputChannel";
    @VisibleForTesting
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final MethodChannel.MethodCallHandler f14225a;
    @NonNull
    public final MethodChannel channel;
    /* access modifiers changed from: private */
    @Nullable
    public TextInputMethodHandler textInputMethodHandler;

    public static class Configuration {
        @Nullable
        public final String actionLabel;
        public final boolean autocorrect;
        @Nullable
        public final Autofill autofill;
        @Nullable
        public final String[] contentCommitMimeTypes;
        public final boolean enableDeltaModel;
        public final boolean enableIMEPersonalizedLearning;
        public final boolean enableSuggestions;
        @Nullable
        public final Configuration[] fields;
        @Nullable
        public final Integer inputAction;
        @NonNull
        public final InputType inputType;
        public final boolean obscureText;
        @NonNull
        public final TextCapitalization textCapitalization;

        public static class Autofill {
            public final TextEditState editState;
            public final String hintText;
            public final String[] hints;
            public final String uniqueIdentifier;

            public Autofill(@NonNull String str, @NonNull String[] strArr, @Nullable String str2, @NonNull TextEditState textEditState) {
                this.uniqueIdentifier = str;
                this.hints = strArr;
                this.hintText = str2;
                this.editState = textEditState;
            }

            @NonNull
            public static Autofill fromJson(@NonNull JSONObject jSONObject) throws JSONException, NoSuchFieldException {
                String str;
                String string = jSONObject.getString("uniqueIdentifier");
                JSONArray jSONArray = jSONObject.getJSONArray("hints");
                if (jSONObject.isNull("hintText")) {
                    str = null;
                } else {
                    str = jSONObject.getString("hintText");
                }
                JSONObject jSONObject2 = jSONObject.getJSONObject("editingValue");
                String[] strArr = new String[jSONArray.length()];
                for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                    strArr[i11] = translateAutofillHint(jSONArray.getString(i11));
                }
                return new Autofill(string, strArr, str, TextEditState.fromJson(jSONObject2));
            }

            /* JADX WARNING: Can't fix incorrect switch cases order */
            /* JADX WARNING: Code restructure failed: missing block: B:34:0x00a6, code lost:
                if (r0.equals("familyName") == false) goto L_0x002f;
             */
            @androidx.annotation.NonNull
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private static java.lang.String translateAutofillHint(@androidx.annotation.NonNull java.lang.String r17) {
                /*
                    r0 = r17
                    int r1 = android.os.Build.VERSION.SDK_INT
                    r2 = 26
                    if (r1 >= r2) goto L_0x0009
                    return r0
                L_0x0009:
                    r17.hashCode()
                    int r1 = r17.hashCode()
                    java.lang.String r3 = "postalCode"
                    java.lang.String r4 = "postalAddress"
                    java.lang.String r5 = "password"
                    java.lang.String r6 = "newUsername"
                    java.lang.String r7 = "username"
                    java.lang.String r8 = "creditCardExpirationYear"
                    java.lang.String r9 = "creditCardExpirationDate"
                    java.lang.String r10 = "creditCardNumber"
                    java.lang.String r11 = "gender"
                    java.lang.String r12 = "creditCardExpirationDay"
                    java.lang.String r13 = "creditCardSecurityCode"
                    java.lang.String r14 = "newPassword"
                    java.lang.String r15 = "creditCardExpirationMonth"
                    r16 = -1
                    switch(r1) {
                        case -2058889126: goto L_0x01e6;
                        case -1917283616: goto L_0x01da;
                        case -1844815832: goto L_0x01d0;
                        case -1825589953: goto L_0x01c4;
                        case -1821235109: goto L_0x01ba;
                        case -1757573738: goto L_0x01b0;
                        case -1682373820: goto L_0x01a6;
                        case -1658955742: goto L_0x019a;
                        case -1567118045: goto L_0x018d;
                        case -1476752575: goto L_0x017f;
                        case -1413737489: goto L_0x0171;
                        case -1377792129: goto L_0x0163;
                        case -1249512767: goto L_0x0157;
                        case -1186060294: goto L_0x0149;
                        case -1151034798: goto L_0x013d;
                        case -835992323: goto L_0x012f;
                        case -818219584: goto L_0x0121;
                        case -747304516: goto L_0x0113;
                        case -613980922: goto L_0x0107;
                        case -613352043: goto L_0x00fb;
                        case -549230602: goto L_0x00ed;
                        case -265713450: goto L_0x00e1;
                        case 3373707: goto L_0x00d3;
                        case 96619420: goto L_0x00c5;
                        case 253202685: goto L_0x00b7;
                        case 588174851: goto L_0x00a9;
                        case 798554127: goto L_0x00a0;
                        case 892233837: goto L_0x0093;
                        case 991032982: goto L_0x0088;
                        case 1069376125: goto L_0x007b;
                        case 1216985755: goto L_0x0070;
                        case 1469046696: goto L_0x0063;
                        case 1662667945: goto L_0x0058;
                        case 1921869058: goto L_0x004b;
                        case 2011152728: goto L_0x0040;
                        case 2011773919: goto L_0x0033;
                        default: goto L_0x002f;
                    }
                L_0x002f:
                    r2 = r16
                    goto L_0x01f1
                L_0x0033:
                    java.lang.String r1 = "birthdayDay"
                    boolean r1 = r0.equals(r1)
                    if (r1 != 0) goto L_0x003c
                    goto L_0x002f
                L_0x003c:
                    r2 = 35
                    goto L_0x01f1
                L_0x0040:
                    boolean r1 = r0.equals(r3)
                    if (r1 != 0) goto L_0x0047
                    goto L_0x002f
                L_0x0047:
                    r2 = 34
                    goto L_0x01f1
                L_0x004b:
                    java.lang.String r1 = "postalAddressExtended"
                    boolean r1 = r0.equals(r1)
                    if (r1 != 0) goto L_0x0054
                    goto L_0x002f
                L_0x0054:
                    r2 = 33
                    goto L_0x01f1
                L_0x0058:
                    boolean r1 = r0.equals(r4)
                    if (r1 != 0) goto L_0x005f
                    goto L_0x002f
                L_0x005f:
                    r2 = 32
                    goto L_0x01f1
                L_0x0063:
                    java.lang.String r1 = "givenName"
                    boolean r1 = r0.equals(r1)
                    if (r1 != 0) goto L_0x006c
                    goto L_0x002f
                L_0x006c:
                    r2 = 31
                    goto L_0x01f1
                L_0x0070:
                    boolean r1 = r0.equals(r5)
                    if (r1 != 0) goto L_0x0077
                    goto L_0x002f
                L_0x0077:
                    r2 = 30
                    goto L_0x01f1
                L_0x007b:
                    java.lang.String r1 = "birthday"
                    boolean r1 = r0.equals(r1)
                    if (r1 != 0) goto L_0x0084
                    goto L_0x002f
                L_0x0084:
                    r2 = 29
                    goto L_0x01f1
                L_0x0088:
                    boolean r1 = r0.equals(r6)
                    if (r1 != 0) goto L_0x008f
                    goto L_0x002f
                L_0x008f:
                    r2 = 28
                    goto L_0x01f1
                L_0x0093:
                    java.lang.String r1 = "telephoneNumber"
                    boolean r1 = r0.equals(r1)
                    if (r1 != 0) goto L_0x009c
                    goto L_0x002f
                L_0x009c:
                    r2 = 27
                    goto L_0x01f1
                L_0x00a0:
                    java.lang.String r1 = "familyName"
                    boolean r1 = r0.equals(r1)
                    if (r1 != 0) goto L_0x01f1
                    goto L_0x002f
                L_0x00a9:
                    java.lang.String r1 = "birthdayMonth"
                    boolean r1 = r0.equals(r1)
                    if (r1 != 0) goto L_0x00b3
                    goto L_0x002f
                L_0x00b3:
                    r2 = 25
                    goto L_0x01f1
                L_0x00b7:
                    java.lang.String r1 = "addressState"
                    boolean r1 = r0.equals(r1)
                    if (r1 != 0) goto L_0x00c1
                    goto L_0x002f
                L_0x00c1:
                    r2 = 24
                    goto L_0x01f1
                L_0x00c5:
                    java.lang.String r1 = "email"
                    boolean r1 = r0.equals(r1)
                    if (r1 != 0) goto L_0x00cf
                    goto L_0x002f
                L_0x00cf:
                    r2 = 23
                    goto L_0x01f1
                L_0x00d3:
                    java.lang.String r1 = "name"
                    boolean r1 = r0.equals(r1)
                    if (r1 != 0) goto L_0x00dd
                    goto L_0x002f
                L_0x00dd:
                    r2 = 22
                    goto L_0x01f1
                L_0x00e1:
                    boolean r1 = r0.equals(r7)
                    if (r1 != 0) goto L_0x00e9
                    goto L_0x002f
                L_0x00e9:
                    r2 = 21
                    goto L_0x01f1
                L_0x00ed:
                    java.lang.String r1 = "telephoneNumberCountryCode"
                    boolean r1 = r0.equals(r1)
                    if (r1 != 0) goto L_0x00f7
                    goto L_0x002f
                L_0x00f7:
                    r2 = 20
                    goto L_0x01f1
                L_0x00fb:
                    boolean r1 = r0.equals(r8)
                    if (r1 != 0) goto L_0x0103
                    goto L_0x002f
                L_0x0103:
                    r2 = 19
                    goto L_0x01f1
                L_0x0107:
                    boolean r1 = r0.equals(r9)
                    if (r1 != 0) goto L_0x010f
                    goto L_0x002f
                L_0x010f:
                    r2 = 18
                    goto L_0x01f1
                L_0x0113:
                    java.lang.String r1 = "nameSuffix"
                    boolean r1 = r0.equals(r1)
                    if (r1 != 0) goto L_0x011d
                    goto L_0x002f
                L_0x011d:
                    r2 = 17
                    goto L_0x01f1
                L_0x0121:
                    java.lang.String r1 = "middleName"
                    boolean r1 = r0.equals(r1)
                    if (r1 != 0) goto L_0x012b
                    goto L_0x002f
                L_0x012b:
                    r2 = 16
                    goto L_0x01f1
                L_0x012f:
                    java.lang.String r1 = "namePrefix"
                    boolean r1 = r0.equals(r1)
                    if (r1 != 0) goto L_0x0139
                    goto L_0x002f
                L_0x0139:
                    r2 = 15
                    goto L_0x01f1
                L_0x013d:
                    boolean r1 = r0.equals(r10)
                    if (r1 != 0) goto L_0x0145
                    goto L_0x002f
                L_0x0145:
                    r2 = 14
                    goto L_0x01f1
                L_0x0149:
                    java.lang.String r1 = "postalAddressExtendedPostalCode"
                    boolean r1 = r0.equals(r1)
                    if (r1 != 0) goto L_0x0153
                    goto L_0x002f
                L_0x0153:
                    r2 = 13
                    goto L_0x01f1
                L_0x0157:
                    boolean r1 = r0.equals(r11)
                    if (r1 != 0) goto L_0x015f
                    goto L_0x002f
                L_0x015f:
                    r2 = 12
                    goto L_0x01f1
                L_0x0163:
                    java.lang.String r1 = "addressCity"
                    boolean r1 = r0.equals(r1)
                    if (r1 != 0) goto L_0x016d
                    goto L_0x002f
                L_0x016d:
                    r2 = 11
                    goto L_0x01f1
                L_0x0171:
                    java.lang.String r1 = "middleInitial"
                    boolean r1 = r0.equals(r1)
                    if (r1 != 0) goto L_0x017b
                    goto L_0x002f
                L_0x017b:
                    r2 = 10
                    goto L_0x01f1
                L_0x017f:
                    java.lang.String r1 = "countryName"
                    boolean r1 = r0.equals(r1)
                    if (r1 != 0) goto L_0x0189
                    goto L_0x002f
                L_0x0189:
                    r2 = 9
                    goto L_0x01f1
                L_0x018d:
                    java.lang.String r1 = "telephoneNumberDevice"
                    boolean r1 = r0.equals(r1)
                    if (r1 != 0) goto L_0x0197
                    goto L_0x002f
                L_0x0197:
                    r2 = 8
                    goto L_0x01f1
                L_0x019a:
                    java.lang.String r1 = "fullStreetAddress"
                    boolean r1 = r0.equals(r1)
                    if (r1 != 0) goto L_0x01a4
                    goto L_0x002f
                L_0x01a4:
                    r2 = 7
                    goto L_0x01f1
                L_0x01a6:
                    boolean r1 = r0.equals(r12)
                    if (r1 != 0) goto L_0x01ae
                    goto L_0x002f
                L_0x01ae:
                    r2 = 6
                    goto L_0x01f1
                L_0x01b0:
                    boolean r1 = r0.equals(r13)
                    if (r1 != 0) goto L_0x01b8
                    goto L_0x002f
                L_0x01b8:
                    r2 = 5
                    goto L_0x01f1
                L_0x01ba:
                    boolean r1 = r0.equals(r14)
                    if (r1 != 0) goto L_0x01c2
                    goto L_0x002f
                L_0x01c2:
                    r2 = 4
                    goto L_0x01f1
                L_0x01c4:
                    java.lang.String r1 = "telephoneNumberNational"
                    boolean r1 = r0.equals(r1)
                    if (r1 != 0) goto L_0x01ce
                    goto L_0x002f
                L_0x01ce:
                    r2 = 3
                    goto L_0x01f1
                L_0x01d0:
                    boolean r1 = r0.equals(r15)
                    if (r1 != 0) goto L_0x01d8
                    goto L_0x002f
                L_0x01d8:
                    r2 = 2
                    goto L_0x01f1
                L_0x01da:
                    java.lang.String r1 = "oneTimeCode"
                    boolean r1 = r0.equals(r1)
                    if (r1 != 0) goto L_0x01e4
                    goto L_0x002f
                L_0x01e4:
                    r2 = 1
                    goto L_0x01f1
                L_0x01e6:
                    java.lang.String r1 = "birthdayYear"
                    boolean r1 = r0.equals(r1)
                    if (r1 != 0) goto L_0x01f0
                    goto L_0x002f
                L_0x01f0:
                    r2 = 0
                L_0x01f1:
                    switch(r2) {
                        case 0: goto L_0x0244;
                        case 1: goto L_0x0241;
                        case 2: goto L_0x0240;
                        case 3: goto L_0x023d;
                        case 4: goto L_0x023c;
                        case 5: goto L_0x023b;
                        case 6: goto L_0x023a;
                        case 7: goto L_0x0237;
                        case 8: goto L_0x0234;
                        case 9: goto L_0x0231;
                        case 10: goto L_0x022e;
                        case 11: goto L_0x022b;
                        case 12: goto L_0x022a;
                        case 13: goto L_0x0227;
                        case 14: goto L_0x0226;
                        case 15: goto L_0x0223;
                        case 16: goto L_0x0220;
                        case 17: goto L_0x021d;
                        case 18: goto L_0x021c;
                        case 19: goto L_0x021b;
                        case 20: goto L_0x0218;
                        case 21: goto L_0x0217;
                        case 22: goto L_0x0214;
                        case 23: goto L_0x0211;
                        case 24: goto L_0x020e;
                        case 25: goto L_0x020b;
                        case 26: goto L_0x0208;
                        case 27: goto L_0x0205;
                        case 28: goto L_0x0204;
                        case 29: goto L_0x0201;
                        case 30: goto L_0x0200;
                        case 31: goto L_0x01fd;
                        case 32: goto L_0x01fc;
                        case 33: goto L_0x01f9;
                        case 34: goto L_0x01f8;
                        case 35: goto L_0x01f5;
                        default: goto L_0x01f4;
                    }
                L_0x01f4:
                    return r0
                L_0x01f5:
                    java.lang.String r0 = "birthDateDay"
                    return r0
                L_0x01f8:
                    return r3
                L_0x01f9:
                    java.lang.String r0 = "extendedAddress"
                    return r0
                L_0x01fc:
                    return r4
                L_0x01fd:
                    java.lang.String r0 = "personGivenName"
                    return r0
                L_0x0200:
                    return r5
                L_0x0201:
                    java.lang.String r0 = "birthDateFull"
                    return r0
                L_0x0204:
                    return r6
                L_0x0205:
                    java.lang.String r0 = "phoneNumber"
                    return r0
                L_0x0208:
                    java.lang.String r0 = "personFamilyName"
                    return r0
                L_0x020b:
                    java.lang.String r0 = "birthDateMonth"
                    return r0
                L_0x020e:
                    java.lang.String r0 = "addressRegion"
                    return r0
                L_0x0211:
                    java.lang.String r0 = "emailAddress"
                    return r0
                L_0x0214:
                    java.lang.String r0 = "personName"
                    return r0
                L_0x0217:
                    return r7
                L_0x0218:
                    java.lang.String r0 = "phoneCountryCode"
                    return r0
                L_0x021b:
                    return r8
                L_0x021c:
                    return r9
                L_0x021d:
                    java.lang.String r0 = "personNameSuffix"
                    return r0
                L_0x0220:
                    java.lang.String r0 = "personMiddleName"
                    return r0
                L_0x0223:
                    java.lang.String r0 = "personNamePrefix"
                    return r0
                L_0x0226:
                    return r10
                L_0x0227:
                    java.lang.String r0 = "extendedPostalCode"
                    return r0
                L_0x022a:
                    return r11
                L_0x022b:
                    java.lang.String r0 = "addressLocality"
                    return r0
                L_0x022e:
                    java.lang.String r0 = "personMiddleInitial"
                    return r0
                L_0x0231:
                    java.lang.String r0 = "addressCountry"
                    return r0
                L_0x0234:
                    java.lang.String r0 = "phoneNumberDevice"
                    return r0
                L_0x0237:
                    java.lang.String r0 = "streetAddress"
                    return r0
                L_0x023a:
                    return r12
                L_0x023b:
                    return r13
                L_0x023c:
                    return r14
                L_0x023d:
                    java.lang.String r0 = "phoneNational"
                    return r0
                L_0x0240:
                    return r15
                L_0x0241:
                    java.lang.String r0 = "smsOTPCode"
                    return r0
                L_0x0244:
                    java.lang.String r0 = "birthDateYear"
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.engine.systemchannels.TextInputChannel.Configuration.Autofill.translateAutofillHint(java.lang.String):java.lang.String");
            }
        }

        public Configuration(boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, @NonNull TextCapitalization textCapitalization2, @NonNull InputType inputType2, @Nullable Integer num, @Nullable String str, @Nullable Autofill autofill2, @Nullable String[] strArr, @Nullable Configuration[] configurationArr) {
            this.obscureText = z11;
            this.autocorrect = z12;
            this.enableSuggestions = z13;
            this.enableIMEPersonalizedLearning = z14;
            this.enableDeltaModel = z15;
            this.textCapitalization = textCapitalization2;
            this.inputType = inputType2;
            this.inputAction = num;
            this.actionLabel = str;
            this.autofill = autofill2;
            this.contentCommitMimeTypes = strArr;
            this.fields = configurationArr;
        }

        @NonNull
        public static Configuration fromJson(@NonNull JSONObject jSONObject) throws JSONException, NoSuchFieldException {
            Configuration[] configurationArr;
            JSONArray jSONArray;
            String str;
            JSONObject jSONObject2 = jSONObject;
            String string = jSONObject2.getString("inputAction");
            if (string != null) {
                Autofill autofill2 = null;
                if (!jSONObject2.isNull("fields")) {
                    JSONArray jSONArray2 = jSONObject2.getJSONArray("fields");
                    int length = jSONArray2.length();
                    Configuration[] configurationArr2 = new Configuration[length];
                    for (int i11 = 0; i11 < length; i11++) {
                        configurationArr2[i11] = fromJson(jSONArray2.getJSONObject(i11));
                    }
                    configurationArr = configurationArr2;
                } else {
                    configurationArr = null;
                }
                Integer inputActionFromTextInputAction = inputActionFromTextInputAction(string);
                ArrayList arrayList = new ArrayList();
                if (jSONObject2.isNull("contentCommitMimeTypes")) {
                    jSONArray = null;
                } else {
                    jSONArray = jSONObject2.getJSONArray("contentCommitMimeTypes");
                }
                if (jSONArray != null) {
                    for (int i12 = 0; i12 < jSONArray.length(); i12++) {
                        arrayList.add(jSONArray.optString(i12));
                    }
                }
                boolean optBoolean = jSONObject2.optBoolean("obscureText");
                boolean optBoolean2 = jSONObject2.optBoolean("autocorrect", true);
                boolean optBoolean3 = jSONObject2.optBoolean("enableSuggestions");
                boolean optBoolean4 = jSONObject2.optBoolean("enableIMEPersonalizedLearning");
                boolean optBoolean5 = jSONObject2.optBoolean("enableDeltaModel");
                TextCapitalization a11 = TextCapitalization.a(jSONObject2.getString("textCapitalization"));
                InputType fromJson = InputType.fromJson(jSONObject2.getJSONObject(RemoteMessageConst.INPUT_TYPE));
                if (jSONObject2.isNull("actionLabel")) {
                    str = null;
                } else {
                    str = jSONObject2.getString("actionLabel");
                }
                if (!jSONObject2.isNull("autofill")) {
                    autofill2 = Autofill.fromJson(jSONObject2.getJSONObject("autofill"));
                }
                return new Configuration(optBoolean, optBoolean2, optBoolean3, optBoolean4, optBoolean5, a11, fromJson, inputActionFromTextInputAction, str, autofill2, (String[]) arrayList.toArray(new String[arrayList.size()]), configurationArr);
            }
            throw new JSONException("Configuration JSON missing 'inputAction' property.");
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0073, code lost:
            if (r12.equals("TextInputAction.done") == false) goto L_0x001b;
         */
        @androidx.annotation.NonNull
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static java.lang.Integer inputActionFromTextInputAction(@androidx.annotation.NonNull java.lang.String r12) {
            /*
                r12.hashCode()
                int r0 = r12.hashCode()
                r1 = 7
                r2 = 6
                r3 = 5
                r4 = 4
                r5 = 3
                r6 = 2
                r7 = 1
                java.lang.Integer r8 = java.lang.Integer.valueOf(r7)
                r9 = 0
                java.lang.Integer r10 = java.lang.Integer.valueOf(r9)
                r11 = -1
                switch(r0) {
                    case -810971940: goto L_0x0076;
                    case -737377923: goto L_0x006d;
                    case -737089298: goto L_0x0062;
                    case -737080013: goto L_0x0057;
                    case -736940669: goto L_0x004c;
                    case 469250275: goto L_0x0041;
                    case 1241689507: goto L_0x0036;
                    case 1539450297: goto L_0x002b;
                    case 2110497650: goto L_0x001e;
                    default: goto L_0x001b;
                }
            L_0x001b:
                r7 = r11
                goto L_0x0080
            L_0x001e:
                java.lang.String r0 = "TextInputAction.previous"
                boolean r12 = r12.equals(r0)
                if (r12 != 0) goto L_0x0027
                goto L_0x001b
            L_0x0027:
                r7 = 8
                goto L_0x0080
            L_0x002b:
                java.lang.String r0 = "TextInputAction.newline"
                boolean r12 = r12.equals(r0)
                if (r12 != 0) goto L_0x0034
                goto L_0x001b
            L_0x0034:
                r7 = r1
                goto L_0x0080
            L_0x0036:
                java.lang.String r0 = "TextInputAction.go"
                boolean r12 = r12.equals(r0)
                if (r12 != 0) goto L_0x003f
                goto L_0x001b
            L_0x003f:
                r7 = r2
                goto L_0x0080
            L_0x0041:
                java.lang.String r0 = "TextInputAction.search"
                boolean r12 = r12.equals(r0)
                if (r12 != 0) goto L_0x004a
                goto L_0x001b
            L_0x004a:
                r7 = r3
                goto L_0x0080
            L_0x004c:
                java.lang.String r0 = "TextInputAction.send"
                boolean r12 = r12.equals(r0)
                if (r12 != 0) goto L_0x0055
                goto L_0x001b
            L_0x0055:
                r7 = r4
                goto L_0x0080
            L_0x0057:
                java.lang.String r0 = "TextInputAction.none"
                boolean r12 = r12.equals(r0)
                if (r12 != 0) goto L_0x0060
                goto L_0x001b
            L_0x0060:
                r7 = r5
                goto L_0x0080
            L_0x0062:
                java.lang.String r0 = "TextInputAction.next"
                boolean r12 = r12.equals(r0)
                if (r12 != 0) goto L_0x006b
                goto L_0x001b
            L_0x006b:
                r7 = r6
                goto L_0x0080
            L_0x006d:
                java.lang.String r0 = "TextInputAction.done"
                boolean r12 = r12.equals(r0)
                if (r12 != 0) goto L_0x0080
                goto L_0x001b
            L_0x0076:
                java.lang.String r0 = "TextInputAction.unspecified"
                boolean r12 = r12.equals(r0)
                if (r12 != 0) goto L_0x007f
                goto L_0x001b
            L_0x007f:
                r7 = r9
            L_0x0080:
                switch(r7) {
                    case 0: goto L_0x00a4;
                    case 1: goto L_0x009f;
                    case 2: goto L_0x009a;
                    case 3: goto L_0x0099;
                    case 4: goto L_0x0094;
                    case 5: goto L_0x008f;
                    case 6: goto L_0x008a;
                    case 7: goto L_0x0089;
                    case 8: goto L_0x0084;
                    default: goto L_0x0083;
                }
            L_0x0083:
                return r10
            L_0x0084:
                java.lang.Integer r12 = java.lang.Integer.valueOf(r1)
                return r12
            L_0x0089:
                return r8
            L_0x008a:
                java.lang.Integer r12 = java.lang.Integer.valueOf(r6)
                return r12
            L_0x008f:
                java.lang.Integer r12 = java.lang.Integer.valueOf(r5)
                return r12
            L_0x0094:
                java.lang.Integer r12 = java.lang.Integer.valueOf(r4)
                return r12
            L_0x0099:
                return r8
            L_0x009a:
                java.lang.Integer r12 = java.lang.Integer.valueOf(r3)
                return r12
            L_0x009f:
                java.lang.Integer r12 = java.lang.Integer.valueOf(r2)
                return r12
            L_0x00a4:
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.engine.systemchannels.TextInputChannel.Configuration.inputActionFromTextInputAction(java.lang.String):java.lang.Integer");
        }
    }

    public static class InputType {
        public final boolean isDecimal;
        public final boolean isSigned;
        @NonNull
        public final TextInputType type;

        public InputType(@NonNull TextInputType textInputType, boolean z11, boolean z12) {
            this.type = textInputType;
            this.isSigned = z11;
            this.isDecimal = z12;
        }

        @NonNull
        public static InputType fromJson(@NonNull JSONObject jSONObject) throws JSONException, NoSuchFieldException {
            return new InputType(TextInputType.a(jSONObject.getString("name")), jSONObject.optBoolean("signed", false), jSONObject.optBoolean("decimal", false));
        }
    }

    public enum TextCapitalization {
        CHARACTERS("TextCapitalization.characters"),
        WORDS("TextCapitalization.words"),
        SENTENCES("TextCapitalization.sentences"),
        NONE("TextCapitalization.none");
        
        @NonNull
        private final String encodedName;

        private TextCapitalization(@NonNull String str) {
            this.encodedName = str;
        }

        public static TextCapitalization a(@NonNull String str) throws NoSuchFieldException {
            for (TextCapitalization textCapitalization : values()) {
                if (textCapitalization.encodedName.equals(str)) {
                    return textCapitalization;
                }
            }
            throw new NoSuchFieldException("No such TextCapitalization: " + str);
        }
    }

    public static class TextEditState {
        public final int composingEnd;
        public final int composingStart;
        public final int selectionEnd;
        public final int selectionStart;
        @NonNull
        public final String text;

        public TextEditState(@NonNull String str, int i11, int i12, int i13, int i14) throws IndexOutOfBoundsException {
            if (!(i11 == -1 && i12 == -1) && (i11 < 0 || i12 < 0)) {
                throw new IndexOutOfBoundsException("invalid selection: (" + String.valueOf(i11) + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + String.valueOf(i12) + ")");
            } else if (!(i13 == -1 && i14 == -1) && (i13 < 0 || i13 > i14)) {
                throw new IndexOutOfBoundsException("invalid composing range: (" + String.valueOf(i13) + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + String.valueOf(i14) + ")");
            } else if (i14 > str.length()) {
                throw new IndexOutOfBoundsException("invalid composing start: " + String.valueOf(i13));
            } else if (i11 > str.length()) {
                throw new IndexOutOfBoundsException("invalid selection start: " + String.valueOf(i11));
            } else if (i12 <= str.length()) {
                this.text = str;
                this.selectionStart = i11;
                this.selectionEnd = i12;
                this.composingStart = i13;
                this.composingEnd = i14;
            } else {
                throw new IndexOutOfBoundsException("invalid selection end: " + String.valueOf(i12));
            }
        }

        @NonNull
        public static TextEditState fromJson(@NonNull JSONObject jSONObject) throws JSONException {
            return new TextEditState(jSONObject.getString("text"), jSONObject.getInt("selectionBase"), jSONObject.getInt("selectionExtent"), jSONObject.getInt("composingBase"), jSONObject.getInt("composingExtent"));
        }

        public boolean hasComposing() {
            int i11 = this.composingStart;
            return i11 >= 0 && this.composingEnd > i11;
        }

        public boolean hasSelection() {
            return this.selectionStart >= 0;
        }
    }

    public interface TextInputMethodHandler {
        void clearClient();

        void finishAutofillContext(boolean z11);

        void hide();

        void requestAutofill();

        void sendAppPrivateCommand(@NonNull String str, @NonNull Bundle bundle);

        void setClient(int i11, @NonNull Configuration configuration);

        void setEditableSizeAndTransform(double d11, double d12, @NonNull double[] dArr);

        void setEditingState(@NonNull TextEditState textEditState);

        void setPlatformViewClient(int i11, boolean z11);

        void show();
    }

    public enum TextInputType {
        TEXT("TextInputType.text"),
        DATETIME("TextInputType.datetime"),
        NAME("TextInputType.name"),
        POSTAL_ADDRESS("TextInputType.address"),
        NUMBER("TextInputType.number"),
        PHONE("TextInputType.phone"),
        MULTILINE("TextInputType.multiline"),
        EMAIL_ADDRESS("TextInputType.emailAddress"),
        URL("TextInputType.url"),
        VISIBLE_PASSWORD("TextInputType.visiblePassword"),
        NONE("TextInputType.none");
        
        @NonNull
        private final String encodedName;

        private TextInputType(@NonNull String str) {
            this.encodedName = str;
        }

        public static TextInputType a(@NonNull String str) throws NoSuchFieldException {
            for (TextInputType textInputType : values()) {
                if (textInputType.encodedName.equals(str)) {
                    return textInputType;
                }
            }
            throw new NoSuchFieldException("No such TextInputType: " + str);
        }
    }

    public TextInputChannel(@NonNull DartExecutor dartExecutor) {
        AnonymousClass1 r02 = new MethodChannel.MethodCallHandler() {
            public void onMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
                Bundle bundle;
                if (TextInputChannel.this.textInputMethodHandler != null) {
                    String str = methodCall.method;
                    Object obj = methodCall.arguments;
                    Log.v(TextInputChannel.TAG, "Received '" + str + "' message.");
                    str.hashCode();
                    char c11 = 65535;
                    switch (str.hashCode()) {
                        case -1779068172:
                            if (str.equals("TextInput.setPlatformViewClient")) {
                                c11 = 0;
                                break;
                            }
                            break;
                        case -1015421462:
                            if (str.equals("TextInput.setEditingState")) {
                                c11 = 1;
                                break;
                            }
                            break;
                        case -37561188:
                            if (str.equals("TextInput.setClient")) {
                                c11 = 2;
                                break;
                            }
                            break;
                        case 270476819:
                            if (str.equals("TextInput.hide")) {
                                c11 = 3;
                                break;
                            }
                            break;
                        case 270803918:
                            if (str.equals("TextInput.show")) {
                                c11 = 4;
                                break;
                            }
                            break;
                        case 649192816:
                            if (str.equals("TextInput.sendAppPrivateCommand")) {
                                c11 = 5;
                                break;
                            }
                            break;
                        case 1204752139:
                            if (str.equals("TextInput.setEditableSizeAndTransform")) {
                                c11 = 6;
                                break;
                            }
                            break;
                        case 1727570905:
                            if (str.equals("TextInput.finishAutofillContext")) {
                                c11 = 7;
                                break;
                            }
                            break;
                        case 1904427655:
                            if (str.equals("TextInput.clearClient")) {
                                c11 = 8;
                                break;
                            }
                            break;
                        case 2113369584:
                            if (str.equals("TextInput.requestAutofill")) {
                                c11 = 9;
                                break;
                            }
                            break;
                    }
                    switch (c11) {
                        case 0:
                            try {
                                JSONObject jSONObject = (JSONObject) obj;
                                TextInputChannel.this.textInputMethodHandler.setPlatformViewClient(jSONObject.getInt("platformViewId"), jSONObject.optBoolean("usesVirtualDisplay", false));
                                result.success((Object) null);
                                return;
                            } catch (JSONException e11) {
                                result.error("error", e11.getMessage(), (Object) null);
                                return;
                            }
                        case 1:
                            try {
                                TextInputChannel.this.textInputMethodHandler.setEditingState(TextEditState.fromJson((JSONObject) obj));
                                result.success((Object) null);
                                return;
                            } catch (JSONException e12) {
                                result.error("error", e12.getMessage(), (Object) null);
                                return;
                            }
                        case 2:
                            try {
                                JSONArray jSONArray = (JSONArray) obj;
                                TextInputChannel.this.textInputMethodHandler.setClient(jSONArray.getInt(0), Configuration.fromJson(jSONArray.getJSONObject(1)));
                                result.success((Object) null);
                                return;
                            } catch (NoSuchFieldException | JSONException e13) {
                                result.error("error", e13.getMessage(), (Object) null);
                                return;
                            }
                        case 3:
                            TextInputChannel.this.textInputMethodHandler.hide();
                            result.success((Object) null);
                            return;
                        case 4:
                            TextInputChannel.this.textInputMethodHandler.show();
                            result.success((Object) null);
                            return;
                        case 5:
                            try {
                                JSONObject jSONObject2 = (JSONObject) obj;
                                String string = jSONObject2.getString(NativeProtocol.WEB_DIALOG_ACTION);
                                String string2 = jSONObject2.getString("data");
                                if (string2 == null || string2.isEmpty()) {
                                    bundle = null;
                                } else {
                                    bundle = new Bundle();
                                    bundle.putString("data", string2);
                                }
                                TextInputChannel.this.textInputMethodHandler.sendAppPrivateCommand(string, bundle);
                                result.success((Object) null);
                                return;
                            } catch (JSONException e14) {
                                result.error("error", e14.getMessage(), (Object) null);
                                return;
                            }
                        case 6:
                            try {
                                JSONObject jSONObject3 = (JSONObject) obj;
                                double d11 = jSONObject3.getDouble("width");
                                double d12 = jSONObject3.getDouble("height");
                                JSONArray jSONArray2 = jSONObject3.getJSONArray("transform");
                                double[] dArr = new double[16];
                                for (int i11 = 0; i11 < 16; i11++) {
                                    dArr[i11] = jSONArray2.getDouble(i11);
                                }
                                TextInputChannel.this.textInputMethodHandler.setEditableSizeAndTransform(d11, d12, dArr);
                                result.success((Object) null);
                                return;
                            } catch (JSONException e15) {
                                result.error("error", e15.getMessage(), (Object) null);
                                return;
                            }
                        case 7:
                            TextInputChannel.this.textInputMethodHandler.finishAutofillContext(((Boolean) obj).booleanValue());
                            result.success((Object) null);
                            return;
                        case 8:
                            TextInputChannel.this.textInputMethodHandler.clearClient();
                            result.success((Object) null);
                            return;
                        case 9:
                            TextInputChannel.this.textInputMethodHandler.requestAutofill();
                            result.success((Object) null);
                            return;
                        default:
                            result.notImplemented();
                            return;
                    }
                }
            }
        };
        this.f14225a = r02;
        MethodChannel methodChannel = new MethodChannel(dartExecutor, "flutter/textinput", JSONMethodCodec.INSTANCE);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(r02);
    }

    private static HashMap<Object, Object> createEditingDeltaJSON(ArrayList<TextEditingDelta> arrayList) {
        HashMap<Object, Object> hashMap = new HashMap<>();
        JSONArray jSONArray = new JSONArray();
        Iterator<TextEditingDelta> it = arrayList.iterator();
        while (it.hasNext()) {
            jSONArray.put((Object) it.next().toJSON());
        }
        hashMap.put("deltas", jSONArray);
        return hashMap;
    }

    private static HashMap<Object, Object> createEditingStateJSON(String str, int i11, int i12, int i13, int i14) {
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("text", str);
        hashMap.put("selectionBase", Integer.valueOf(i11));
        hashMap.put("selectionExtent", Integer.valueOf(i12));
        hashMap.put("composingBase", Integer.valueOf(i13));
        hashMap.put("composingExtent", Integer.valueOf(i14));
        return hashMap;
    }

    public void commitContent(int i11, Map<String, Object> map) {
        Log.v(TAG, "Sending 'commitContent' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(new Object[]{Integer.valueOf(i11), "TextInputAction.commitContent", map}));
    }

    public void done(int i11) {
        Log.v(TAG, "Sending 'done' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(new Serializable[]{Integer.valueOf(i11), "TextInputAction.done"}));
    }

    public void go(int i11) {
        Log.v(TAG, "Sending 'go' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(new Serializable[]{Integer.valueOf(i11), "TextInputAction.go"}));
    }

    public void newline(int i11) {
        Log.v(TAG, "Sending 'newline' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(new Serializable[]{Integer.valueOf(i11), "TextInputAction.newline"}));
    }

    public void next(int i11) {
        Log.v(TAG, "Sending 'next' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(new Serializable[]{Integer.valueOf(i11), "TextInputAction.next"}));
    }

    public void performPrivateCommand(int i11, @NonNull String str, @NonNull Bundle bundle) {
        HashMap hashMap = new HashMap();
        hashMap.put(NativeProtocol.WEB_DIALOG_ACTION, str);
        if (bundle != null) {
            HashMap hashMap2 = new HashMap();
            for (String next : bundle.keySet()) {
                Object obj = bundle.get(next);
                if (obj instanceof byte[]) {
                    hashMap2.put(next, bundle.getByteArray(next));
                } else if (obj instanceof Byte) {
                    hashMap2.put(next, Byte.valueOf(bundle.getByte(next)));
                } else if (obj instanceof char[]) {
                    hashMap2.put(next, bundle.getCharArray(next));
                } else if (obj instanceof Character) {
                    hashMap2.put(next, Character.valueOf(bundle.getChar(next)));
                } else if (obj instanceof CharSequence[]) {
                    hashMap2.put(next, bundle.getCharSequenceArray(next));
                } else if (obj instanceof CharSequence) {
                    hashMap2.put(next, bundle.getCharSequence(next));
                } else if (obj instanceof float[]) {
                    hashMap2.put(next, bundle.getFloatArray(next));
                } else if (obj instanceof Float) {
                    hashMap2.put(next, Float.valueOf(bundle.getFloat(next)));
                }
            }
            hashMap.put("data", hashMap2);
        }
        this.channel.invokeMethod("TextInputClient.performPrivateCommand", Arrays.asList(new Serializable[]{Integer.valueOf(i11), hashMap}));
    }

    public void previous(int i11) {
        Log.v(TAG, "Sending 'previous' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(new Serializable[]{Integer.valueOf(i11), "TextInputAction.previous"}));
    }

    public void requestExistingInputState() {
        this.channel.invokeMethod("TextInputClient.requestExistingInputState", (Object) null);
    }

    public void search(int i11) {
        Log.v(TAG, "Sending 'search' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(new Serializable[]{Integer.valueOf(i11), "TextInputAction.search"}));
    }

    public void send(int i11) {
        Log.v(TAG, "Sending 'send' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(new Serializable[]{Integer.valueOf(i11), "TextInputAction.send"}));
    }

    public void setTextInputMethodHandler(@Nullable TextInputMethodHandler textInputMethodHandler2) {
        this.textInputMethodHandler = textInputMethodHandler2;
    }

    public void unspecifiedAction(int i11) {
        Log.v(TAG, "Sending 'unspecified' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(new Serializable[]{Integer.valueOf(i11), "TextInputAction.unspecified"}));
    }

    public void updateEditingState(int i11, @NonNull String str, int i12, int i13, int i14, int i15) {
        Log.v(TAG, "Sending message to update editing state: \nText: " + str + "\nSelection start: " + i12 + "\nSelection end: " + i13 + "\nComposing start: " + i14 + "\nComposing end: " + i15);
        HashMap<Object, Object> createEditingStateJSON = createEditingStateJSON(str, i12, i13, i14, i15);
        this.channel.invokeMethod("TextInputClient.updateEditingState", Arrays.asList(new Serializable[]{Integer.valueOf(i11), createEditingStateJSON}));
    }

    public void updateEditingStateWithDeltas(int i11, @NonNull ArrayList<TextEditingDelta> arrayList) {
        Log.v(TAG, "Sending message to update editing state with deltas: \nNumber of deltas: " + arrayList.size());
        HashMap<Object, Object> createEditingDeltaJSON = createEditingDeltaJSON(arrayList);
        this.channel.invokeMethod("TextInputClient.updateEditingStateWithDeltas", Arrays.asList(new Serializable[]{Integer.valueOf(i11), createEditingDeltaJSON}));
    }

    public void updateEditingStateWithTag(int i11, @NonNull HashMap<String, TextEditState> hashMap) {
        Log.v(TAG, "Sending message to update editing state for " + String.valueOf(hashMap.size()) + " field(s).");
        HashMap hashMap2 = new HashMap();
        for (Map.Entry next : hashMap.entrySet()) {
            TextEditState textEditState = (TextEditState) next.getValue();
            hashMap2.put((String) next.getKey(), createEditingStateJSON(textEditState.text, textEditState.selectionStart, textEditState.selectionEnd, -1, -1));
        }
        this.channel.invokeMethod("TextInputClient.updateEditingStateWithTag", Arrays.asList(new Serializable[]{Integer.valueOf(i11), hashMap2}));
    }
}
