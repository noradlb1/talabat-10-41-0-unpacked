package com.visa.checkout;

import android.os.Parcel;
import android.os.Parcelable;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.jar.asm.Opcodes;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public final class VisaPaymentSummary implements Parcelable {
    public static final String CALL_ID = "callid";
    public static final String CARD_BRAND = "cardBrand";
    public static final String CARD_TYPE = "cardType";
    public static final String COUNTRY_CODE = "countryCode";
    public static final Parcelable.Creator<VisaPaymentSummary> CREATOR = new Parcelable.Creator<VisaPaymentSummary>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new VisaPaymentSummary(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i11) {
            return new VisaPaymentSummary[i11];
        }
    };
    public static final String ENC_KEY = "encKey";
    public static final String ENC_PAYMENT_DATA = "encPaymentData";
    public static final String LAST_FOUR_DIGITS = "lastFourDigits";
    private static final String PARTIAL_PAYMENT_INSTRUMENT = "partialPaymentInstrument";
    public static final String PARTIAL_SHIPPING_ADDRESS = "partialShippingAddress";
    public static final String PAYMENT_CANCEL = "payment.cancel";
    public static final String PAYMENT_ERROR = "payment.error";
    public static final String PAYMENT_FAILURE = "payment.failure";
    public static final String PAYMENT_METHOD_TYPE = "paymentMethodType";
    public static final String PAYMENT_SUCCESS = "payment.success";
    private static final String PAYMENT_TYPE = "paymentType";
    public static final String POSTAL_CODE = "postalCode";
    private static final String RESULT = "result";
    private static final String RESULT_TYPE = "type";

    /* renamed from: ˊ  reason: contains not printable characters */
    private static int f133 = 0;

    /* renamed from: ˋ  reason: contains not printable characters */
    private static char[] f134 = {38428, 65527, 17893, 44015, 12786, 34806, Advice.OffsetMapping.ForOrigin.Renderer.ForTypeName.SYMBOL, 27013, 54152, 15761, Advice.OffsetMapping.ForOrigin.Renderer.ForPropertyName.SYMBOL, 27037, 54145, 15769, 42901, 4482, 31644, 58826, 20371, 47529, 9147, 36279, 63413, 25023, 52155, Advice.OffsetMapping.ForOrigin.Renderer.ForPropertyName.SYMBOL, 27037, 54145, 15769, 42901, 4482, 31644, 58826, 20357, 47534, 9130, 36283, 63394, 33167, 59490, 21118, 48230, 9834, 36989, 64099, 25653, 52860, 14402, 41545, 3144, 30282, 57439, Advice.OffsetMapping.ForOrigin.Renderer.ForPropertyName.SYMBOL, 27037, 54145, 15769, 42901, 4482, 31644, 58826, 20358, 47549, 9137, 36280, 63397, 25022, 52141, Advice.OffsetMapping.ForOrigin.Renderer.ForPropertyName.SYMBOL, 27037, 54154, 15744, 42905, 4493, 31620, 58807, 20360, 47541, 9128, 36260, 63417, 24994, 52143, 13701, 40868, 2520, 29642, 56785, 18371, 45535, 'c', 27027, 54157, 15770, 42884, 4510, 31633, 58791, 20367, 47544, 9149, 29126, 6181, 41533, 19510, 54823, 24630, 2589, 37949, 15922, 51215, 28088, 1109, 48706, 20552, 51793, 31813, 5708, 34940, 8777, 54381, 20093, 57465, 39542, 3184, 42569, 22626, 62075, 25600, 7682, 45065, 10773, 56321, 30222, 59416, 'l', 27037, 54155, 15744, 42934, 4483, 31645, 58774, 20388, 47541, 9151, 36285, 63396, 25023, Advice.OffsetMapping.ForOrigin.Renderer.ForPropertyName.SYMBOL, 27037, 54145, 15769, 42901, 4482, 31644, 58800, 20377, 47532, 9149, 'c', 27037, 54154, 15760, 42930, 4510, 31625, 58762, 20356, 12170, 18036, 64611, 4729, 34893, 15996, 21617, 51816, 20235, 9980, 40181, 29386, 59647, 24315, 13547, 43759, 224, 63174, 27890, 49883, 47306, 11971, 'e', 27026, 54171, 15807, 42901, 4501, 'c', 27037, 54164, 15768, 42905, 4488, 770, 27375, 53491, 16107, 42215, 4848, 30958, 59099, 19703, 47834, 8386, 36553, 62662, 25322, 51395, 14022, 40151};

    /* renamed from: ˎ  reason: contains not printable characters */
    private static int f135 = 1;

    /* renamed from: ˏ  reason: contains not printable characters */
    private static long f136 = -8747128153017259524L;
    private String statusName;
    private JSONObject summary = new JSONObject();

    static {
        int i11 = f133 + 97;
        f135 = i11 % 128;
        int i12 = i11 % 2;
    }

    public VisaPaymentSummary(JSONObject jSONObject) {
        try {
            this.summary = jSONObject.getJSONObject(m6108(0, 6, 38510).intern());
            this.statusName = String.valueOf(jSONObject.get(m6108(6, 4, 0).intern()));
            String obj = jSONObject.get(m6108(6, 4, 0).intern()).toString();
            if (!obj.equalsIgnoreCase(m6108(10, 15, 0).intern()) && !obj.equalsIgnoreCase(m6108(25, 13, 0).intern()) && !obj.equalsIgnoreCase(m6108(38, 14, 33279).intern())) {
                this.statusName = m6108(52, 15, 0).intern();
            }
        } catch (JSONException unused) {
            this.statusName = m6108(52, 15, 0).intern();
        }
    }

    private JSONObject getPaymentType() {
        boolean z11;
        boolean z12;
        int i11;
        int i12;
        int i13 = f133;
        int i14 = i13 + 71;
        f135 = i14 % 128;
        int i15 = i14 % 2;
        JSONObject jSONObject = this.summary;
        if (jSONObject != null) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!z11) {
            int i16 = i13 + 69;
            f135 = i16 % 128;
            int i17 = i16 % 2;
            JSONObject optJSONObject = jSONObject.optJSONObject(m6108(110, 24, 28104).intern());
            if (optJSONObject != null) {
                int i18 = f135 + 99;
                f133 = i18 % 128;
                if (i18 % 2 != 0) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (!z12) {
                    i11 = 148;
                    i12 = 11;
                } else {
                    i11 = 12277;
                    i12 = 57;
                }
                return optJSONObject.optJSONObject(m6108(i11, i12, 0).intern());
            }
        }
        return null;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static String m6108(int i11, int i12, char c11) {
        boolean z11;
        char c12;
        int i13 = f135 + 123;
        int i14 = i13 % 128;
        f133 = i14;
        int i15 = i13 % 2;
        char[] cArr = new char[i12];
        int i16 = i14 + 73;
        f135 = i16 % 128;
        int i17 = i16 % 2;
        int i18 = 0;
        while (true) {
            if (i18 < i12) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                return new String(cArr);
            }
            int i19 = f133 + 39;
            f135 = i19 % 128;
            if (i19 % 2 == 0) {
                c12 = '.';
            } else {
                c12 = '\\';
            }
            if (c12 != '.') {
                cArr[i18] = (char) ((int) ((((long) f134[i11 + i18]) ^ (((long) i18) * f136)) ^ ((long) c11)));
                i18++;
            } else {
                cArr[i18] = (char) ((int) ((((long) f134[i11 & i18]) - (((long) i18) + f136)) % ((long) c11)));
                i18 += 120;
            }
        }
    }

    public final int describeContents() {
        int i11 = f135;
        int i12 = i11 + 71;
        f133 = i12 % 128;
        int i13 = i12 % 2;
        int i14 = i11 + 81;
        f133 = i14 % 128;
        if ((i14 % 2 != 0 ? '3' : '(') != '(') {
            int i15 = 19 / 0;
        }
        return 0;
    }

    public final Object get(String str) {
        boolean z11;
        char c11;
        int i11 = f133 + 89;
        int i12 = i11 % 128;
        f135 = i12;
        if (i11 % 2 == 0) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            JSONObject jSONObject = this.summary;
            if (jSONObject == null) {
                c11 = '_';
            } else {
                c11 = 'J';
            }
            if (c11 != '_') {
                Object opt = jSONObject.opt(str);
                int i13 = f133 + 89;
                f135 = i13 % 128;
                if (i13 % 2 != 0) {
                    return opt;
                }
                throw null;
            }
            int i14 = i12 + 83;
            f133 = i14 % 128;
            int i15 = i14 % 2;
            return null;
        }
        throw null;
    }

    public final String getCallId() {
        int i11;
        int i12;
        int i13 = f133 + 69;
        f135 = i13 % 128;
        if ((i13 % 2 == 0 ? (char) 15 : 8) != 15) {
            i11 = 196;
            i12 = 6;
        } else {
            i11 = 32515;
            i12 = 118;
        }
        String valueOf = String.valueOf(get(m6108(i11, i12, 0).intern()));
        int i14 = f135 + 29;
        f133 = i14 % 128;
        int i15 = i14 % 2;
        return valueOf;
    }

    public final String getCardBrand() {
        boolean z11;
        String str;
        boolean z12;
        JSONObject paymentType = getPaymentType();
        if (paymentType != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            str = null;
        } else {
            int i11 = f135 + 23;
            f133 = i11 % 128;
            int i12 = i11 % 2;
            str = paymentType.optString(m6108(Opcodes.IF_ICMPEQ, 9, 0).intern());
        }
        int i13 = f133 + 43;
        f135 = i13 % 128;
        if (i13 % 2 == 0) {
            z12 = false;
        } else {
            z12 = true;
        }
        if (!z12) {
            int i14 = 34 / 0;
        }
        return str;
    }

    public final String getCardType() {
        char c11;
        String str;
        int i11 = f133 + 81;
        f135 = i11 % 128;
        int i12 = i11 % 2;
        JSONObject paymentType = getPaymentType();
        if (paymentType != null) {
            c11 = 18;
        } else {
            c11 = 'V';
        }
        if (c11 != 18) {
            str = null;
        } else {
            str = paymentType.optString(m6108(Opcodes.JSR, 8, 12265).intern());
        }
        int i13 = f133 + 101;
        f135 = i13 % 128;
        int i14 = i13 % 2;
        return str;
    }

    public final String getCountryCode() {
        boolean z11;
        boolean z12;
        boolean z13;
        int i11;
        int i12;
        int i13 = f133 + 115;
        f135 = i13 % 128;
        int i14 = i13 % 2;
        JSONObject jSONObject = this.summary;
        if (jSONObject != null) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!z11) {
            JSONObject optJSONObject = jSONObject.optJSONObject(m6108(67, 22, 0).intern());
            if (optJSONObject != null) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z12) {
                int i15 = f133 + 27;
                f135 = i15 % 128;
                if (i15 % 2 == 0) {
                    z13 = false;
                } else {
                    z13 = true;
                }
                if (!z13) {
                    i11 = 108;
                    i12 = 83;
                } else {
                    i11 = 89;
                    i12 = 11;
                }
                return optJSONObject.optString(m6108(i11, i12, 0).intern());
            }
        }
        return null;
    }

    public final String getEncKey() {
        int i11;
        int i12;
        int i13 = f135 + 5;
        f133 = i13 % 128;
        boolean z11 = false;
        if ((i13 % 2 != 0 ? 'G' : 'M') != 'M') {
            i11 = 22415;
            i12 = 22;
        } else {
            i11 = 190;
            i12 = 6;
        }
        String valueOf = String.valueOf(get(m6108(i11, i12, 0).intern()));
        int i14 = f133 + 89;
        f135 = i14 % 128;
        if (i14 % 2 == 0) {
            z11 = true;
        }
        if (!z11) {
            return valueOf;
        }
        throw null;
    }

    public final String getEncPaymentData() {
        int i11;
        int i12;
        int i13 = f133 + 49;
        f135 = i13 % 128;
        if (i13 % 2 != 0) {
            i12 = Opcodes.ARETURN;
            i11 = 14;
        } else {
            i12 = 11117;
            i11 = 50;
        }
        String valueOf = String.valueOf(get(m6108(i12, i11, 20334).intern()));
        int i14 = f133 + 11;
        f135 = i14 % 128;
        int i15 = i14 % 2;
        return valueOf;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0052 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0053  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getLastFourDigits() {
        /*
            r7 = this;
            org.json.JSONObject r0 = r7.summary
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0008
            r3 = r2
            goto L_0x0009
        L_0x0008:
            r3 = r1
        L_0x0009:
            r4 = 0
            if (r3 == 0) goto L_0x0041
            int r3 = f135
            int r3 = r3 + 81
            int r5 = r3 % 128
            f133 = r5
            int r3 = r3 % 2
            r3 = 24
            r5 = 28104(0x6dc8, float:3.9382E-41)
            r6 = 110(0x6e, float:1.54E-43)
            java.lang.String r3 = m6108(r6, r3, r5)
            java.lang.String r3 = r3.intern()
            org.json.JSONObject r0 = r0.optJSONObject(r3)
            if (r0 == 0) goto L_0x002c
            r3 = r2
            goto L_0x002d
        L_0x002c:
            r3 = r1
        L_0x002d:
            if (r3 == r2) goto L_0x0030
            goto L_0x0041
        L_0x0030:
            r3 = 134(0x86, float:1.88E-43)
            r5 = 14
            java.lang.String r3 = m6108(r3, r5, r1)
            java.lang.String r3 = r3.intern()
            java.lang.String r0 = r0.optString(r3)
            goto L_0x0042
        L_0x0041:
            r0 = r4
        L_0x0042:
            int r3 = f133
            int r3 = r3 + 85
            int r5 = r3 % 128
            f135 = r5
            int r3 = r3 % 2
            if (r3 != 0) goto L_0x004f
            goto L_0x0050
        L_0x004f:
            r1 = r2
        L_0x0050:
            if (r1 != r2) goto L_0x0053
            return r0
        L_0x0053:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.visa.checkout.VisaPaymentSummary.getLastFourDigits():java.lang.String");
    }

    public final String getPaymentMethodType() {
        int i11;
        int i12;
        int i13 = f135 + 81;
        f133 = i13 % 128;
        if (i13 % 2 == 0) {
            i12 = 202;
            i11 = 17;
        } else {
            i12 = 5221;
            i11 = 55;
        }
        String valueOf = String.valueOf(get(m6108(i12, i11, 882).intern()));
        int i14 = f135 + 39;
        f133 = i14 % 128;
        int i15 = i14 % 2;
        return valueOf;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003b, code lost:
        if (r2 != 25) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0051, code lost:
        if (r2 != false) goto L_0x0067;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getPostalCode() {
        /*
            r6 = this;
            int r0 = f135
            int r1 = r0 + 95
            int r2 = r1 % 128
            f133 = r2
            int r1 = r1 % 2
            org.json.JSONObject r1 = r6.summary
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0012
            r4 = r2
            goto L_0x0013
        L_0x0012:
            r4 = r3
        L_0x0013:
            if (r4 == 0) goto L_0x0067
            r4 = 91
            int r0 = r0 + r4
            int r5 = r0 % 128
            f133 = r5
            int r0 = r0 % 2
            if (r0 == 0) goto L_0x0022
            r0 = r3
            goto L_0x0023
        L_0x0022:
            r0 = r2
        L_0x0023:
            if (r0 == r2) goto L_0x003e
            r0 = 55
            java.lang.String r0 = m6108(r0, r4, r3)
            java.lang.String r0 = r0.intern()
            org.json.JSONObject r0 = r1.optJSONObject(r0)
            r1 = 25
            if (r0 == 0) goto L_0x003a
            r2 = 58
            goto L_0x003b
        L_0x003a:
            r2 = r1
        L_0x003b:
            if (r2 == r1) goto L_0x0067
            goto L_0x0054
        L_0x003e:
            r0 = 67
            r4 = 22
            java.lang.String r0 = m6108(r0, r4, r3)
            java.lang.String r0 = r0.intern()
            org.json.JSONObject r0 = r1.optJSONObject(r0)
            if (r0 == 0) goto L_0x0051
            r2 = r3
        L_0x0051:
            if (r2 == 0) goto L_0x0054
            goto L_0x0067
        L_0x0054:
            r1 = 10
            r2 = 29110(0x71b6, float:4.0792E-41)
            r3 = 100
            java.lang.String r1 = m6108(r3, r1, r2)
            java.lang.String r1 = r1.intern()
            java.lang.String r0 = r0.optString(r1)
            goto L_0x0068
        L_0x0067:
            r0 = 0
        L_0x0068:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.visa.checkout.VisaPaymentSummary.getPostalCode():java.lang.String");
    }

    public final String getStatusName() {
        String str;
        int i11 = f135 + 65;
        int i12 = i11 % 128;
        f133 = i12;
        boolean z11 = false;
        if ((i11 % 2 != 0 ? 'E' : 8) != 'E') {
            str = this.statusName;
        } else {
            str = this.statusName;
            int i13 = 85 / 0;
        }
        int i14 = i12 + 71;
        f135 = i14 % 128;
        if (i14 % 2 != 0) {
            z11 = true;
        }
        if (z11) {
            return str;
        }
        throw null;
    }

    public final String toString() {
        char c11;
        boolean z11;
        int i11 = f135 + 115;
        f133 = i11 % 128;
        if (i11 % 2 != 0) {
            c11 = '^';
        } else {
            c11 = 30;
        }
        if (c11 == 30) {
            JSONObject jSONObject = this.summary;
            if (jSONObject == null) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (!z11) {
                String obj = super.toString();
                int i12 = f135 + 69;
                f133 = i12 % 128;
                int i13 = i12 % 2;
                return obj;
            } else if (!(jSONObject instanceof JSONObject)) {
                return jSONObject.toString();
            } else {
                return JSONObjectInstrumentation.toString(jSONObject);
            }
        } else {
            throw null;
        }
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        char c11;
        char c12;
        String str;
        String str2;
        parcel.writeString(this.statusName);
        JSONObject jSONObject = this.summary;
        if (jSONObject != null) {
            c11 = 15;
        } else {
            c11 = '9';
        }
        if (c11 != 15) {
            parcel.writeString(JSONObjectInstrumentation.toString(new JSONObject()));
            return;
        }
        int i12 = f135 + 33;
        f133 = i12 % 128;
        if (i12 % 2 != 0) {
            c12 = 'F';
        } else {
            c12 = 5;
        }
        if (c12 != 5) {
            if (!(jSONObject instanceof JSONObject)) {
                str2 = jSONObject.toString();
            } else {
                str2 = JSONObjectInstrumentation.toString(jSONObject);
            }
            parcel.writeString(str2);
            int i13 = 59 / 0;
        } else {
            if (!(jSONObject instanceof JSONObject)) {
                str = jSONObject.toString();
            } else {
                str = JSONObjectInstrumentation.toString(jSONObject);
            }
            parcel.writeString(str);
        }
        int i14 = f133 + 63;
        f135 = i14 % 128;
        int i15 = i14 % 2;
    }

    public VisaPaymentSummary(String str) {
        this.statusName = str;
    }

    public VisaPaymentSummary(Parcel parcel) {
        this.statusName = parcel.readString();
        try {
            this.summary = new JSONObject(parcel.readString());
        } catch (JSONException unused) {
            this.summary = new JSONObject();
        }
    }
}
