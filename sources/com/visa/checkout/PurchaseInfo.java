package com.visa.checkout;

import android.annotation.TargetApi;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.jar.asm.Opcodes;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
@TargetApi(19)
public class PurchaseInfo implements Parcelable {
    public static final Parcelable.Creator<PurchaseInfo> CREATOR = new Parcelable.Creator<PurchaseInfo>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new PurchaseInfo(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i11) {
            return new PurchaseInfo[0];
        }
    };
    public static final String CURRENCY = "currency";
    public static final String CURRENCY_FORMAT = "currencyFormat";
    public static final String CUSTOM_DATA = "customData";
    public static final String CUSTOM_DESCRIPTION = "customDescription";
    public static final String DISCOUNT = "discount";
    public static final String ENABLE_USER_DATA_PREFILL = "enableUserDataPrefill";
    public static final String GIFT_WRAP_CHARGES = "giftWrapCharges";
    public static final String MISCELLANEOUS_CHARGES = "miscellaneousCharges";
    public static final String ORDER_ID = "orderId";
    public static final String PROMO_CODE = "promoCode";
    public static final String REFERENCE_CALL_ID = "referenceCallId";
    public static final String REQUEST_ID = "requestId";
    public static final String REVIEW_ACTION = "reviewAction";
    public static final String REVIEW_MESSAGE = "reviewMessage";
    public static final String SHIPPING_AND_HANDLING_CHARGES = "shippingAndHandlingCharges";
    public static final String SHIPPING_REQUIRED = "shippingRequired";
    public static final String SOURCE_ID = "sourceId";
    public static final String SUB_TOTAL = "subtotal";
    public static final String TAX = "tax";
    public static final String THREE_DS_ACTIVE = "threeDSActive";
    public static final String THREE_DS_SUPPRESS_CHALLENGE = "threeDSSuppressChallenge";
    public static final String TOTAL = "total";

    /* renamed from: ˊ  reason: contains not printable characters */
    private static char[] f114 = {52216, 26670, 35906, 8251, 17541, 63664, 7412, 45324, 54629, 2386, 44407, 49568, 26048, 39394, 15896, 21032, 63055, 19088, 59755, 3350, 41267, 50655, 31219, 40379, 12290, 21622, 34827, 11326, 16612, 58501, 6312, 48991, 54066, 30491, 43968, 53152, 25531, 34700, 14975, 24136, 61998, 5825, 19176, 61077, 3398, 41260, 50519, 31073, 40338, 12789, 21920, 34884, 11322, 16413, 58420, 6375, 48276, 53409, 30494, 43891, 53035, 25538, 34726, 15245, 24481, 62033, 5710, 18966, 61139, 751, 42647, 50440, 31041, 40204, 12603, 21971, 35201, 11683, 16467, 58476, 6226, 48178, 53499, 29838, 43193, 53064, 25471, 34599, 15308, 24549, 62354, 6073, 19070, 60949, 616, Advice.OffsetMapping.ForOrigin.Renderer.ForTypeName.SYMBOL, 41909, 18368, 60399, 36612, 'c', 41903, 18374, 60412, 36621, 13100, 55167, 31375, 12520, 37684, 30541, 56161, 49052, 941, 59366, 18945, Advice.OffsetMapping.ForOrigin.Renderer.ForJavaSignature.SYMBOL, 41906, 18397, 60414, 36632, 13099, 55154, 31377, 7825, 49860, 26336, 2582, 44633, 21116, 62856, 39338, 15817, 57620, 34099, 10605, 52576, 28803, 5326, 47345, 23573, '9', Advice.OffsetMapping.ForOrigin.Renderer.ForTypeName.SYMBOL, 41906, 18374, 60395, 36621, 13062, 55119, 31415, 7859, 49886, 26349, 2600, 44637, 6688, 47590, 23954, 61887, 38233, 10578, 52507, 24817, 1265, 55438, 31904, 4216, 46089, 18485, 61387, 33745, 10140, 64335, 40812, 13078, 55097, 27352, 3727, 41639, Advice.OffsetMapping.ForOrigin.Renderer.ForTypeName.SYMBOL, 41915, 18380, Advice.OffsetMapping.ForOrigin.Renderer.ForDescriptor.SYMBOL, 41907, 18375, 60397, 36615, 13111, 55154, 31362, 56485, 32625, 39696, 14136, 21501, 61426, 3007, 42564, 49745, 7680, 47655, 55022, 29341, 36533, 10589, 18062, 58704, 292, 44302, 51694, 30157, 37267, 15476, 22621, 33836, 8200, 19656, 59560, 5298, 45927, 57156, 31537, 43006, 50130, 28606, 39542, 14778, 56786, 29167, 5394, 43322, 19789, 57478, 33974, 22748, 64739, 36898, 13405, 51315, 28560, 956, 42971, 10909, 35162, 27938, 49433, 42472, 6649, 64906, Advice.OffsetMapping.ForOrigin.Renderer.ForReturnTypeName.SYMBOL, 41919, 18370, 60391, 36621, 13109, 55121, 31379, 7843, 49881, 26341, 2617, 44637, Advice.OffsetMapping.ForOrigin.Renderer.ForReturnTypeName.SYMBOL, 41919, 18373, 60411, 36621, 13105, 55144, 31423, 7860, Advice.OffsetMapping.ForOrigin.Renderer.ForJavaSignature.SYMBOL, 41909, 18369, 60412, 36619, 13095, 55125, 31378, 24856, 49856, 9907, 35467, 61039, 21097, 46619, 7162, 32733, Advice.OffsetMapping.ForOrigin.Renderer.ForJavaSignature.SYMBOL, 41906, 18397, 60414, 36632, 13099, 55154, 31377, 7810, 49871, 26357, 2603, 44625, 21088, 62857, 39330, 35135, 10994, 52879, 25258, 1600, 47736, 24080, 62424, 38889, 19342, 61350, 33661, 'c', 41903, 18375, 60410, 36615, 13103, 55128, 31383, 7844, 49867, 'n', 41900, 18404, 60399, 36609, 13104, 14077, 38184, 29002, 56696, 'v', 41915, 18392, 60411, 36621, 16577, 58124, 1889, 43864, 53161, 29588, 38849, 14886, 24070, 33370, 9814, 19073, 61159, 4840, 46395, 'e', 41908, 18389, 60396, 36612, 13095, 55113, 31365, 7861, 49880, 26304, 2623, 44620, 21107, 62908, 39348, 15813, 57628, 34109, 10562, 52580, 25744, 51036, 9013, 36623, 60414, 22495, 45964, 7804, 31333, 42550, 517, 28352, 51882, 13973};

    /* renamed from: ˋ  reason: contains not printable characters */
    private static long f115 = -612558258936962086L;

    /* renamed from: ˏ  reason: contains not printable characters */
    private static int f116 = 0;

    /* renamed from: ॱ  reason: contains not printable characters */
    private static int f117 = 1;
    private Map<String, VisaConfigRequest> mConfigRequestMap;
    private JSONObject purchaseData;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Currency {
        public static final String AED = "AED";
        public static final String ARS = "ARS";
        public static final String AUD = "AUD";
        public static final String BRL = "BRL";
        public static final String CAD = "CAD";
        public static final String CLP = "CLP";
        public static final String CNY = "CNY";
        public static final String COP = "COP";
        public static final String EUR = "EUR";
        public static final String GBP = "GBP";
        public static final String HKD = "HKD";
        public static final String INR = "INR";
        public static final String KWD = "KWD";
        public static final String MXN = "MXN";
        public static final String MYR = "MYR";
        public static final String NZD = "NZD";
        public static final String PEN = "PEN";
        public static final String PLN = "PLN";
        public static final String QAR = "QAR";
        public static final String SAR = "SAR";
        public static final String SGD = "SGD";
        public static final String UAH = "UAH";
        public static final String USD = "USD";
        public static final String ZAR = "ZAR";
    }

    public static final class PurchaseInfoBuilder {

        /* renamed from: ˋ  reason: contains not printable characters */
        private static int f118 = 0;

        /* renamed from: ˎ  reason: contains not printable characters */
        private static long f119 = 5267873025619688270L;

        /* renamed from: ˏ  reason: contains not printable characters */
        private static char[] f120 = {'c', 31521, 63217, 29124, 60750, 26863, 58279, 24387, 55902, 21981, 53604, 19519, 51147, 17053, 48683, 14823, 46228, 17966, 15681, 45184, 14313, 43825, 11913, 42445, 6504, 40040, 5025, 38664, 2654, 33195, 1266, 63561, 32728, 62181, 30250, 60726, 24801, 58402, 23365, 57086, 20996, 51551, 19586, 50147, 18236, 15042, 45453, 13687, 43064, 12235, 41738, 9810, 40416, 4339, 37966, 2961, 36606, 575, 63796, 31941, 61457, 30572, 60156, 28187, 58699, 22703, 57252, 21248, 54921, 19905, 49453, 17470, 15339, 48914, 12881, 43429, 11515, 41037, 10121, 39674, 7800, 38284, 2257, 35864, 867, 34470, 31237, 61777, 29862, 60411, 28472, 57999, 22980, 56635, 20530, 27331, 4502, 40031, 6972, 34787, 34273, 65209, 29548, 62490, 26847, 60778, 26165, 56025, 22466, 11402, 41295, 9775, 47846, 16195, 46084, 2303, Advice.OffsetMapping.ForOrigin.Renderer.ForJavaSignature.SYMBOL, 31526, 63221, 29082, 60744, 26863, 58298, 24389, 55857, 21968, 53608, 19474, 51145, 17048, 48672, 14846, 46217, 12352, 43803, 9865, 41584, 7431, 39110, 5221, 36661, 2797, Advice.OffsetMapping.ForOrigin.Renderer.ForTypeName.SYMBOL, 31535, 63204, 7176, 26443, 60035, 28133, 61755, 29855, 65494, 17210, 16098, 17826, 51327, 20251, 54250, 22129, 56624, 25047, 58550, 27475, 61416, 29357, 63818, 31766, 32946, Advice.OffsetMapping.ForOrigin.Renderer.ForMethodName.SYMBOL, 31527, 63215, 29065, 60765, 26858, 58296, 24387, 55838, 21979, 53603, 19503, 51163, 17077, 48684, 14835, 46226, 12361, 43801, 9913, 60022, 37166, 7418, 39819, 1858, 33534, 2437, 46418, 12310, 49096, 15211, 42534, 11725, 43159, 21560, 54248, 24219, 'o', 31548, 63224, 29071, 60746, 26831, 58288, Advice.OffsetMapping.ForOrigin.Renderer.ForReturnTypeName.SYMBOL, 31531, 63210, 29059, 60765, 26865, 58265, 24391, 55811, 21965, 53613, 19517, 51149, Advice.OffsetMapping.ForOrigin.Renderer.ForReturnTypeName.SYMBOL, 31531, 63213, 29087, 60765, 26869, 58272, 24427, 55828, 8272, 23298, 54986, 20923, 52600, 18624, 50110, 32613, Advice.OffsetMapping.ForOrigin.Renderer.ForPropertyName.SYMBOL, 31548, 63219, 29063, 60759, 26821, 58299, 24390, 55829, Advice.OffsetMapping.ForOrigin.Renderer.ForJavaSignature.SYMBOL, 31526, 63221, 29082, 60744, 26863, 58298, 24389, 55842, 21979, 53629, 19503, 51137, 17028, 48673, 14838, Advice.OffsetMapping.ForOrigin.Renderer.ForReturnTypeName.SYMBOL, 31531, 63210, 29059, 60765, 26865, 58261, 24385, 55812, 21975, 53603, 19508, 'n', 31535, 63217, 29071, 'v', 31535, 63216, 29087, 60765, 15725, 17979, 52175, 19592, 53330, 22007, 54093, 43029, 9665, 41648, 15993, 48069, 12478, 35949, 2346, 34545, 50147, 47290, 13675, 45598, 11995, 43890, 8235, 40144, 6532, 38508, 4860, 36775, 1109, 33070, 32177, 57730, 39632, 5912, 36985, 3243, 35124, 625, 48789, 15333, 46140, 12435, 44506, 9787, Advice.OffsetMapping.ForOrigin.Renderer.ForTypeName.SYMBOL, 31526, 63214, 29071, 60765, 26818, 58247, 24433, 55813, 21966, 53628, 19496, 51149, 17029, 48695, 14801, 46216, 12367, 43792, 9894, 41597, 7432, 39123, 5223, 35275, 62094, 32595, 63526, 25850, 57677, 27183, 55039, 21435, 56418, 22758, 50581, 20082, 52025, 14266, 45134, 15659, 47590, 8891, 44808, 11226, 'c', 31547, 63214, 29080, 60765, 26856, 58295, 24411, 55862, 21969, 53630, 19511, 51145, 17026, 39649, 57773, 27752, 60189, 30656, 62075, 31017};

        /* renamed from: ॱ  reason: contains not printable characters */
        private static int f121 = 1;
        private Map<String, VisaConfigRequest> mConfigRequestMap = new HashMap();
        private JSONObject purchaseData = new JSONObject();

        public PurchaseInfoBuilder(@NonNull BigDecimal bigDecimal, String str) {
            put(m6105(5, 95, 27319).intern(), bigDecimal);
            put(m6105(8, 100, 34178).intern(), str);
        }

        public static /* synthetic */ JSONObject access$000(PurchaseInfoBuilder purchaseInfoBuilder) {
            int i11 = f121 + 109;
            f118 = i11 % 128;
            boolean z11 = i11 % 2 == 0;
            JSONObject jSONObject = purchaseInfoBuilder.purchaseData;
            if (z11) {
                return jSONObject;
            }
            throw null;
        }

        public static /* synthetic */ Map access$100(PurchaseInfoBuilder purchaseInfoBuilder) {
            int i11 = f121;
            int i12 = i11 + 107;
            f118 = i12 % 128;
            int i13 = i12 % 2;
            Map<String, VisaConfigRequest> map = purchaseInfoBuilder.mConfigRequestMap;
            int i14 = i11 + 39;
            f118 = i14 % 128;
            int i15 = i14 % 2;
            return map;
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        private static String m6105(int i11, int i12, char c11) {
            boolean z11;
            char[] cArr = new char[i11];
            int i13 = f118 + 99;
            f121 = i13 % 128;
            int i14 = i13 % 2;
            int i15 = 0;
            while (true) {
                if (i15 < i11) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (!z11) {
                    return new String(cArr);
                }
                int i16 = f118 + 15;
                f121 = i16 % 128;
                int i17 = i16 % 2;
                cArr[i15] = (char) ((int) ((((long) f120[i12 + i15]) ^ (((long) i15) * f119)) ^ ((long) c11)));
                i15++;
            }
        }

        public final PurchaseInfo build() {
            PurchaseInfo purchaseInfo = new PurchaseInfo(this);
            int i11 = f118 + 67;
            f121 = i11 % 128;
            int i12 = i11 % 2;
            return purchaseInfo;
        }

        public final PurchaseInfoBuilder put(String str, Object obj) {
            int i11 = f121 + 87;
            f118 = i11 % 128;
            int i12 = i11 % 2;
            try {
                this.purchaseData.put(str, obj);
            } catch (JSONException unused) {
            }
            return this;
        }

        public final PurchaseInfoBuilder setCurrencyFormat(@NonNull String str) {
            char c11;
            int i11 = f118 + 7;
            f121 = i11 % 128;
            int i12 = i11 % 2;
            put(m6105(14, 377, 0).intern(), str);
            int i13 = f118 + 111;
            f121 = i13 % 128;
            if (i13 % 2 == 0) {
                c11 = 'N';
            } else {
                c11 = ':';
            }
            if (c11 == ':') {
                return this;
            }
            throw null;
        }

        public final PurchaseInfoBuilder setCustomData(@NonNull HashMap<String, String> hashMap) {
            int i11 = f121 + 109;
            f118 = i11 % 128;
            int i12 = i11 % 2;
            if (hashMap != null) {
                try {
                    Set<String> keySet = hashMap.keySet();
                    JSONObject jSONObject = new JSONObject();
                    JSONArray jSONArray = new JSONArray();
                    for (String next : keySet) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(m6105(4, 279, 0).intern(), (Object) next);
                        jSONObject2.put(m6105(5, 283, 0).intern(), (Object) hashMap.get(next));
                        int i13 = f121 + 11;
                        f118 = i13 % 128;
                        int i14 = i13 % 2;
                    }
                    jSONObject.put(m6105(6, 288, 15619).intern(), (Object) jSONArray);
                    put(m6105(10, 294, 54062).intern(), jSONObject);
                } catch (Exception unused) {
                }
            }
            return this;
        }

        public final PurchaseInfoBuilder setDescription(@NonNull String str) {
            int i11 = f121 + 35;
            f118 = i11 % 128;
            int i12 = i11 % 2;
            put(m6105(17, 188, 59925).intern(), str);
            int i13 = f118 + 107;
            f121 = i13 % 128;
            int i14 = i13 % 2;
            return this;
        }

        public final PurchaseInfoBuilder setDiscount(@NonNull BigDecimal bigDecimal) {
            char c11;
            int i11;
            int i12;
            int i13 = f121 + 41;
            f118 = i13 % 128;
            if (i13 % 2 != 0) {
                c11 = 16;
            } else {
                c11 = '#';
            }
            if (c11 != '#') {
                i11 = 61;
                i12 = 3278;
            } else {
                i11 = 8;
                i12 = Opcodes.I2B;
            }
            put(m6105(i11, i12, 7276).intern(), bigDecimal);
            int i14 = f118 + 19;
            f121 = i14 % 128;
            int i15 = i14 % 2;
            return this;
        }

        public final PurchaseInfoBuilder setEnableUserDataPrefill(boolean z11) {
            char c11;
            int i11;
            int i12;
            boolean z12;
            int i13 = f121 + 13;
            f118 = i13 % 128;
            if (i13 % 2 != 0) {
                c11 = 15;
            } else {
                c11 = 23;
            }
            if (c11 != 23) {
                i11 = 98;
                i12 = 15888;
            } else {
                i11 = 21;
                i12 = 356;
            }
            put(m6105(i11, i12, 35246).intern(), Boolean.valueOf(z11));
            int i14 = f121 + 33;
            f118 = i14 % 128;
            if (i14 % 2 != 0) {
                z12 = false;
            } else {
                z12 = true;
            }
            if (z12) {
                return this;
            }
            throw null;
        }

        public final PurchaseInfoBuilder setGiftWrap(@NonNull BigDecimal bigDecimal) {
            char c11;
            int i11;
            int i12;
            boolean z11;
            int i13 = f118 + 85;
            f121 = i13 % 128;
            if (i13 % 2 == 0) {
                c11 = 6;
            } else {
                c11 = '%';
            }
            if (c11 != '%') {
                i11 = 4;
                i12 = 9855;
            } else {
                i11 = 15;
                i12 = Opcodes.IFEQ;
            }
            put(m6105(i11, i12, 16005).intern(), bigDecimal);
            int i14 = f121 + 39;
            f118 = i14 % 128;
            if (i14 % 2 != 0) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                return this;
            }
            throw null;
        }

        public final PurchaseInfoBuilder setMerchantRequestId(@NonNull String str) {
            boolean z11;
            int i11;
            int i12;
            int i13 = f118 + 77;
            f121 = i13 % 128;
            if (i13 % 2 == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                i11 = 9;
                i12 = 225;
            } else {
                i11 = 35;
                i12 = 3060;
            }
            put(m6105(i11, i12, 0).intern(), str);
            int i14 = f121 + 85;
            f118 = i14 % 128;
            int i15 = i14 % 2;
            return this;
        }

        public final PurchaseInfoBuilder setMisc(@NonNull BigDecimal bigDecimal) {
            int i11 = f121 + 61;
            f118 = i11 % 128;
            int i12 = i11 % 2;
            boolean z11 = false;
            put(m6105(20, Opcodes.JSR, 0).intern(), bigDecimal);
            int i13 = f118 + 77;
            f121 = i13 % 128;
            if (i13 % 2 != 0) {
                z11 = true;
            }
            if (z11) {
                return this;
            }
            throw null;
        }

        public final PurchaseInfoBuilder setOrderId(@NonNull String str) {
            int i11 = f118 + 99;
            f121 = i11 % 128;
            int i12 = i11 % 2;
            put(m6105(7, 205, 0).intern(), str);
            int i13 = f121 + 103;
            f118 = i13 % 128;
            int i14 = i13 % 2;
            return this;
        }

        public final PurchaseInfoBuilder setPrefillRequest(VisaConfigRequest visaConfigRequest) {
            char c11;
            int i11 = f121 + 11;
            f118 = i11 % 128;
            if (i11 % 2 != 0) {
                c11 = 23;
            } else {
                c11 = 6;
            }
            if (c11 != 23) {
                if (visaConfigRequest != null) {
                    this.mConfigRequestMap.put(m6105(7, 391, 39569).intern(), visaConfigRequest);
                    int i12 = f121 + 43;
                    f118 = i12 % 128;
                    int i13 = i12 % 2;
                }
                return this;
            }
            throw null;
        }

        public final PurchaseInfoBuilder setPromoCode(@NonNull String str) {
            boolean z11;
            int i11;
            int i12;
            int i13 = f118 + 65;
            f121 = i13 % 128;
            if (i13 % 2 == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                i12 = 31;
                i11 = 5431;
            } else {
                i12 = 9;
                i11 = 242;
            }
            put(m6105(i12, i11, 0).intern(), str);
            return this;
        }

        public final PurchaseInfoBuilder setReferenceCallId(String str) {
            boolean z11;
            int i11;
            int i12;
            int i13 = f118 + 87;
            f121 = i13 % 128;
            boolean z12 = true;
            if (i13 % 2 == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                i12 = 13;
                i11 = 24758;
            } else {
                i12 = 15;
                i11 = 304;
            }
            put(m6105(i12, i11, 50065).intern(), str);
            int i14 = f118 + 7;
            f121 = i14 % 128;
            if (i14 % 2 == 0) {
                z12 = false;
            }
            if (z12) {
                return this;
            }
            throw null;
        }

        public final PurchaseInfoBuilder setReviewMessage(@NonNull String str) {
            boolean z11;
            int i11;
            int i12 = f121 + 7;
            f118 = i12 % 128;
            if (i12 % 2 != 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                i11 = 24479;
            } else {
                i11 = 212;
            }
            put(m6105(13, i11, 0).intern(), str);
            int i13 = f118 + 123;
            f121 = i13 % 128;
            int i14 = i13 % 2;
            return this;
        }

        public final PurchaseInfoBuilder setShippingAddressRequired(boolean z11) {
            char c11;
            int i11 = f118 + 101;
            f121 = i11 % 128;
            int i12 = i11 % 2;
            put(m6105(16, 251, 0).intern(), Boolean.valueOf(z11));
            int i13 = f121 + 49;
            f118 = i13 % 128;
            if (i13 % 2 != 0) {
                c11 = 'X';
            } else {
                c11 = '5';
            }
            if (c11 != 'X') {
                return this;
            }
            int i14 = 28 / 0;
            return this;
        }

        public final PurchaseInfoBuilder setShippingHandling(@NonNull BigDecimal bigDecimal) {
            boolean z11;
            int i11;
            int i12;
            int i13 = f121 + 113;
            f118 = i13 % 128;
            if (i13 % 2 != 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                i11 = 26;
                i12 = 116;
            } else {
                i11 = 6;
                i12 = 61;
            }
            put(m6105(i11, i12, 0).intern(), bigDecimal);
            return this;
        }

        public final PurchaseInfoBuilder setSourceId(@NonNull String str) {
            boolean z11;
            int i11;
            int i12;
            int i13 = f121 + 71;
            f118 = i13 % 128;
            if (i13 % 2 != 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                i12 = 16;
                i11 = 15756;
            } else {
                i12 = 8;
                i11 = 234;
            }
            put(m6105(i12, i11, 8227).intern(), str);
            return this;
        }

        public final PurchaseInfoBuilder setSubTotal(@NonNull BigDecimal bigDecimal) {
            int i11 = f121 + 75;
            f118 = i11 % 128;
            int i12 = i11 % 2;
            put(m6105(8, 108, 22449).intern(), bigDecimal);
            int i13 = f118 + 29;
            f121 = i13 % 128;
            int i14 = i13 % 2;
            return this;
        }

        public final PurchaseInfoBuilder setTax(@NonNull BigDecimal bigDecimal) {
            char c11;
            String str;
            int i11 = f121 + 55;
            f118 = i11 % 128;
            if (i11 % 2 != 0) {
                c11 = '#';
            } else {
                c11 = 4;
            }
            boolean z11 = false;
            if (c11 != 4) {
                str = m6105(4, 30456, 0);
            } else {
                str = m6105(3, Opcodes.D2I, 0);
            }
            put(str.intern(), bigDecimal);
            int i12 = f118 + 25;
            f121 = i12 % 128;
            if (i12 % 2 != 0) {
                z11 = true;
            }
            if (z11) {
                return this;
            }
            throw null;
        }

        public final PurchaseInfoBuilder setThreeDSSetup(boolean z11, boolean z12) {
            boolean z13;
            int i11;
            int i12;
            int i13 = f118 + 39;
            f121 = i13 % 128;
            if (i13 % 2 == 0) {
                z13 = false;
            } else {
                z13 = true;
            }
            if (z13) {
                put(m6105(13, 319, 57846).intern(), Boolean.valueOf(z11));
                i11 = 24;
                i12 = 332;
            } else {
                put(m6105(117, 25581, 57846).intern(), Boolean.valueOf(z11));
                i11 = 115;
                i12 = 23028;
            }
            put(m6105(i11, i12, 0).intern(), Boolean.valueOf(z12));
            return this;
        }

        public final PurchaseInfoBuilder setUserReviewAction(String str) {
            boolean z11;
            int i11;
            int i12;
            int i13 = f118 + 119;
            f121 = i13 % 128;
            if (i13 % 2 == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                i11 = 12;
                i12 = 267;
            } else {
                i11 = 27;
                i12 = 20644;
            }
            put(m6105(i11, i12, 0).intern(), str);
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface UserReviewAction {
        public static final String ADD_CARD_TO_MERCHANT = "Add Card to Merchant";
        public static final String CONTINUE = "Continue";
        public static final String PAY = "Pay";
    }

    static {
        char c11;
        int i11 = f117 + 67;
        f116 = i11 % 128;
        if (i11 % 2 != 0) {
            c11 = 31;
        } else {
            c11 = 'L';
        }
        if (c11 != 'L') {
            throw null;
        }
    }

    private boolean getBool(String str) {
        int i11 = f116 + 23;
        f117 = i11 % 128;
        if ((i11 % 2 == 0 ? ')' : 'V') != ')') {
            return this.purchaseData.optBoolean(str);
        }
        this.purchaseData.optBoolean(str);
        throw null;
    }

    private BigDecimal getDecimal(String str) {
        boolean z11;
        try {
            BigDecimal bigDecimal = new BigDecimal(String.valueOf(this.purchaseData.getDouble(str)));
            int i11 = f117 + 17;
            f116 = i11 % 128;
            if (i11 % 2 != 0) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                return bigDecimal;
            }
            throw null;
        } catch (JSONException unused) {
            return null;
        }
    }

    private String getString(String str) {
        boolean z11;
        String optString = this.purchaseData.optString(str);
        boolean z12 = false;
        if (optString == null) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            int i11 = f116 + 59;
            f117 = i11 % 128;
            if (i11 % 2 != 0) {
                z12 = true;
            }
            if (z12) {
                return optString;
            }
            throw null;
        }
        int i12 = f117 + 39;
        f116 = i12 % 128;
        if (i12 % 2 != 0) {
            int i13 = 44 / 0;
        }
        return "";
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static String m6104(int i11, int i12, char c11) {
        boolean z11;
        char c12;
        int i13 = f116 + 51;
        f117 = i13 % 128;
        int i14 = i13 % 2;
        char[] cArr = new char[i11];
        int i15 = 0;
        while (true) {
            if (i15 < i11) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                return new String(cArr);
            }
            int i16 = f117 + 5;
            f116 = i16 % 128;
            if (i16 % 2 != 0) {
                c12 = 'U';
            } else {
                c12 = 20;
            }
            if (c12 != 'U') {
                cArr[i15] = (char) ((int) ((((long) f114[i12 + i15]) ^ (((long) i15) * f115)) ^ ((long) c11)));
                i15++;
            } else {
                cArr[i15] = (char) ((int) ((((long) f114[i12 >>> i15]) & (((long) i15) - f115)) | ((long) c11)));
                i15 += 65;
            }
        }
    }

    public int describeContents() {
        int i11 = f117 + 43;
        int i12 = i11 % 128;
        f116 = i12;
        int i13 = i11 % 2;
        int i14 = i12 + 97;
        f117 = i14 % 128;
        int i15 = i14 % 2;
        return 0;
    }

    public Object get(String str) {
        int i11 = f116 + 91;
        f117 = i11 % 128;
        if ((i11 % 2 == 0 ? '%' : 'B') != '%') {
            Object opt = this.purchaseData.opt(str);
            int i12 = f117 + 61;
            f116 = i12 % 128;
            int i13 = i12 % 2;
            return opt;
        }
        this.purchaseData.opt(str);
        throw null;
    }

    public Map<String, VisaConfigRequest> getConfigRequestMap() {
        int i11 = f117 + 31;
        f116 = i11 % 128;
        if (i11 % 2 == 0) {
            return this.mConfigRequestMap;
        }
        throw null;
    }

    public String getCurrency() {
        int i11;
        int i12;
        int i13 = f116 + 121;
        f117 = i13 % 128;
        if (!(i13 % 2 == 0 ? true : true)) {
            i11 = 69;
            i12 = 43;
        } else {
            i11 = 8;
            i12 = 100;
        }
        String string = getString(m6104(i11, i12, 0).intern());
        int i14 = f117 + 11;
        f116 = i14 % 128;
        int i15 = i14 % 2;
        return string;
    }

    public String getCurrencyFormat() {
        int i11 = f117 + 99;
        f116 = i11 % 128;
        int i12 = i11 % 2;
        String string = getString(m6104(14, 377, 25843).intern());
        int i13 = f117 + 93;
        f116 = i13 % 128;
        int i14 = i13 % 2;
        return string;
    }

    public HashMap<String, String> getCustomData() {
        char c11;
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            JSONArray jSONArray = this.purchaseData.getJSONObject(m6104(10, TypedValues.AttributesType.TYPE_PATH_ROTATE, 0).intern()).getJSONArray(m6104(6, 326, 0).intern());
            int i11 = 0;
            while (true) {
                if (i11 < jSONArray.length()) {
                    c11 = '3';
                } else {
                    c11 = 29;
                }
                if (c11 != '3') {
                    break;
                }
                int i12 = f117 + 117;
                f116 = i12 % 128;
                int i13 = i12 % 2;
                JSONObject jSONObject = jSONArray.getJSONObject(i11);
                hashMap.put(jSONObject.getString(m6104(4, 332, 13971).intern()), jSONObject.getString(m6104(5, 336, 0).intern()));
                i11++;
                int i14 = f117 + 115;
                f116 = i14 % 128;
                int i15 = i14 % 2;
            }
        } catch (Exception unused) {
        }
        return hashMap;
    }

    public String getDescription() {
        int i11;
        int i12;
        int i13 = f116 + 71;
        f117 = i13 % 128;
        if (i13 % 2 == 0) {
            i12 = 38;
            i11 = 29822;
        } else {
            i12 = 17;
            i11 = 225;
        }
        return getString(m6104(i12, i11, 39445).intern());
    }

    public BigDecimal getDiscount() {
        int i11;
        int i12;
        int i13 = f117 + 93;
        f116 = i13 % 128;
        if ((i13 % 2 != 0 ? '5' : 'R') != '5') {
            i12 = 8;
            i11 = Opcodes.INVOKEVIRTUAL;
        } else {
            i12 = 122;
            i11 = 911;
        }
        return getDecimal(m6104(i12, i11, 0).intern());
    }

    public BigDecimal getGiftWrap() {
        int i11 = f117 + 39;
        f116 = i11 % 128;
        int i12 = i11 % 2;
        BigDecimal decimal = getDecimal(m6104(15, 190, 56514).intern());
        int i13 = f116 + 27;
        f117 = i13 % 128;
        if (i13 % 2 != 0) {
            return decimal;
        }
        throw null;
    }

    public String getMerchantRequestId() {
        int i11 = f117 + 37;
        f116 = i11 % 128;
        int i12 = i11 % 2;
        String string = getString(m6104(9, 262, 0).intern());
        int i13 = f117 + 65;
        f116 = i13 % 128;
        int i14 = i13 % 2;
        return string;
    }

    public BigDecimal getMisc() {
        int i11 = f116 + 75;
        f117 = i11 % 128;
        int i12 = i11 % 2;
        BigDecimal decimal = getDecimal(m6104(20, 205, 18147).intern());
        int i13 = f116 + 111;
        f117 = i13 % 128;
        int i14 = i13 % 2;
        return decimal;
    }

    public String getOrderId() {
        int i11;
        int i12;
        int i13 = f117 + 97;
        f116 = i13 % 128;
        if ((i13 % 2 != 0 ? 6 : '9') != 6) {
            i12 = 7;
            i11 = 242;
        } else {
            i12 = 109;
            i11 = 31497;
        }
        String string = getString(m6104(i12, i11, 10994).intern());
        int i14 = f116 + 65;
        f117 = i14 % 128;
        int i15 = i14 % 2;
        return string;
    }

    public String getPromoCode() {
        int i11 = f117 + 59;
        f116 = i11 % 128;
        int i12 = i11 % 2;
        String string = getString(m6104(9, 279, 24936).intern());
        int i13 = f117 + 7;
        f116 = i13 % 128;
        int i14 = i13 % 2;
        return string;
    }

    public String getReferenceCallId() {
        int i11 = f116 + 101;
        f117 = i11 % 128;
        int i12 = i11 % 2;
        String string = getString(m6104(15, FacebookRequestErrorClassification.EC_TOO_MANY_USER_ACTION_CALLS, 16563).intern());
        int i13 = f117 + 99;
        f116 = i13 % 128;
        if ((i13 % 2 != 0 ? 'I' : 'J') != 'I') {
            return string;
        }
        int i14 = 52 / 0;
        return string;
    }

    public String getReviewMessage() {
        int i11 = f117 + 47;
        f116 = i11 % 128;
        int i12 = i11 % 2;
        String string = getString(m6104(13, 249, 0).intern());
        int i13 = f117 + 101;
        f116 = i13 % 128;
        if (!(i13 % 2 == 0)) {
            int i14 = 10 / 0;
        }
        return string;
    }

    public BigDecimal getShippingHandling() {
        int i11;
        int i12;
        int i13 = f116 + 45;
        f117 = i13 % 128;
        if ((i13 % 2 == 0 ? '?' : ';') != ';') {
            i12 = 91;
            i11 = 19;
        } else {
            i12 = 26;
            i11 = 116;
        }
        return getDecimal(m6104(i12, i11, 0).intern());
    }

    public String getSourceId() {
        int i11 = f117 + 87;
        f116 = i11 % 128;
        int i12 = i11 % 2;
        String string = getString(m6104(8, 271, 0).intern());
        int i13 = f116 + 85;
        f117 = i13 % 128;
        int i14 = i13 % 2;
        return string;
    }

    public BigDecimal getSubTotal() {
        int i11 = f117 + 103;
        f116 = i11 % 128;
        int i12 = i11 % 2;
        BigDecimal decimal = getDecimal(m6104(8, 108, 12443).intern());
        int i13 = f117 + 31;
        f116 = i13 % 128;
        if ((i13 % 2 != 0 ? '$' : '3') != '$') {
            return decimal;
        }
        int i14 = 41 / 0;
        return decimal;
    }

    public BigDecimal getTax() {
        int i11 = f116 + 95;
        f117 = i11 % 128;
        int i12 = i11 % 2;
        BigDecimal decimal = getDecimal(m6104(3, Opcodes.PUTSTATIC, 0).intern());
        int i13 = f117 + 35;
        f116 = i13 % 128;
        int i14 = i13 % 2;
        return decimal;
    }

    public ThreeDSSetup getThreeDSSetup() {
        ThreeDSSetup threeDSSetup = new ThreeDSSetup();
        boolean z11 = false;
        threeDSSetup.setThreeDSActive(Boolean.valueOf(String.valueOf(get(m6104(13, Opcodes.D2I, 0).intern()))).booleanValue());
        threeDSSetup.setSuppressThreeDSChallenge(Boolean.valueOf(String.valueOf(get(m6104(24, 155, 6740).intern()))).booleanValue());
        int i11 = f117 + 63;
        f116 = i11 % 128;
        if (i11 % 2 != 0) {
            z11 = true;
        }
        if (!z11) {
            return threeDSSetup;
        }
        throw null;
    }

    public BigDecimal getTotal() {
        int i11 = f117 + 91;
        f116 = i11 % 128;
        int i12 = i11 % 2;
        BigDecimal decimal = getDecimal(m6104(5, 95, 0).intern());
        int i13 = f116 + 79;
        f117 = i13 % 128;
        if ((i13 % 2 == 0 ? (char) 26 : 7) == 7) {
            return decimal;
        }
        throw null;
    }

    public String getUserReviewAction() {
        int i11 = f117 + 77;
        f116 = i11 % 128;
        int i12 = i11 % 2;
        String string = getString(m6104(12, 304, 35149).intern());
        int i13 = f117 + 17;
        f116 = i13 % 128;
        int i14 = i13 % 2;
        return string;
    }

    public boolean isEnableUserDataPrefill() {
        int i11 = f117 + 45;
        f116 = i11 % 128;
        int i12 = i11 % 2;
        boolean bool = getBool(m6104(21, 356, 0).intern());
        int i13 = f117 + 115;
        f116 = i13 % 128;
        int i14 = i13 % 2;
        return bool;
    }

    public boolean isShippingAddressRequired() {
        int i11 = f117 + 27;
        f116 = i11 % 128;
        int i12 = i11 % 2;
        boolean bool = getBool(m6104(16, 288, 0).intern());
        int i13 = f117 + 73;
        f116 = i13 % 128;
        if ((i13 % 2 != 0 ? 3 : ' ') == ' ') {
            return bool;
        }
        throw null;
    }

    public JSONObject toJSON() throws JSONException {
        int i11 = f117 + 67;
        int i12 = i11 % 128;
        f116 = i12;
        int i13 = i11 % 2;
        JSONObject jSONObject = this.purchaseData;
        int i14 = i12 + 13;
        f117 = i14 % 128;
        int i15 = i14 % 2;
        return jSONObject;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        int i12 = f116 + 87;
        f117 = i12 % 128;
        if (!(i12 % 2 != 0)) {
            JSONObject jSONObject = this.purchaseData;
            parcel.writeString(!(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject));
            int i13 = 33 / 0;
        } else {
            JSONObject jSONObject2 = this.purchaseData;
            parcel.writeString(!(jSONObject2 instanceof JSONObject) ? jSONObject2.toString() : JSONObjectInstrumentation.toString(jSONObject2));
        }
        int i14 = f117 + 45;
        f116 = i14 % 128;
        if ((i14 % 2 != 0 ? '4' : 'X') != 'X') {
            throw null;
        }
    }

    private PurchaseInfo(Parcel parcel) {
        this.mConfigRequestMap = new HashMap();
        this.purchaseData = new JSONObject();
        try {
            this.purchaseData = new JSONObject(parcel.readString());
        } catch (Exception unused) {
            this.purchaseData = new JSONObject();
        }
    }

    private PurchaseInfo(PurchaseInfoBuilder purchaseInfoBuilder) {
        this.mConfigRequestMap = new HashMap();
        this.purchaseData = new JSONObject();
        this.purchaseData = PurchaseInfoBuilder.access$000(purchaseInfoBuilder);
        this.mConfigRequestMap = PurchaseInfoBuilder.access$100(purchaseInfoBuilder);
    }

    public PurchaseInfo(JSONObject jSONObject) {
        this.mConfigRequestMap = new HashMap();
        this.purchaseData = new JSONObject();
        if (jSONObject != null) {
            this.purchaseData = jSONObject;
        }
    }
}
