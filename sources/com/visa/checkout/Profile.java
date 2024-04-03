package com.visa.checkout;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import com.huawei.location.lite.common.http.exception.ErrorCode;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.Map;
import kotlin.text.Typography;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.jar.asm.Opcodes;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
@TargetApi(19)
public class Profile implements Parcelable {
    public static final String ACCEPTED_BILLING_COUNTRIES = "acceptedBillingCountries";
    public static final String ACCEPTED_CARD_BRANDS = "acceptedCardBrands";
    public static final String ACCEPTED_SHIPPING_COUNTRIES = "acceptedShippingCountries";
    public static final String ACCEPT_CANADIAN_DEBIT_CARDS = "acceptCanadianDebitCards";
    public static final String ALLOW_ENROLLMENT = "allowEnrollment";
    public static final String API_KEY = "apiKey";
    public static final String CAMPAIGN_URL = "campaignUrl";
    public static final String CLIENT_ID = "clientId";
    public static final String COUNTRY_CODE = "countryCode";
    public static final Parcelable.Creator<Profile> CREATOR = new Parcelable.Creator<Profile>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new Profile(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i11) {
            return new Profile[i11];
        }
    };
    public static final String CUSTOMER_SUPPORT_URL = "customerSupportUrl";
    public static final String DATA_LEVEL = "datalevel";
    public static final String DISPLAY_NAME = "displayName";
    public static final String ENABLE_TOKENIZATION = "enableTokenization";
    public static final String ENCRYPTION_KEY = "encryptionKey";
    public static final String ENVIRONMENT = "environment";
    public static final String EXTERNAL_CLIENT_ID = "externalClientId";
    public static final String LOCALE = "locale";
    public static final String LOGO_RESOURCE_ID = "logoResourceId";
    public static final String LOGO_URL = "logoUrl";
    public static final String NEW_USER_WELCOME_MESSAGE = "welcomeMessage";
    public static final String NEW_USER_WELCOME_MESSAGE_DESCRIPTION = "welcomeMessageDescription";
    public static final String PROFILE_NAME = "profileName";
    public static final String RETURNING_USER_WELCOME_MESSAGE = "returningUserWelcomeMessage";
    public static final String WEBSITE_URL = "websiteUrl";

    /* renamed from: ˋ  reason: contains not printable characters */
    private static long f106 = 9150457019242823055L;

    /* renamed from: ˎ  reason: contains not printable characters */
    private static int f107 = 0;

    /* renamed from: ˏ  reason: contains not printable characters */
    private static int f108 = 1;

    /* renamed from: ॱ  reason: contains not printable characters */
    private static char[] f109 = {19227, 63128, 12299, 29691, 48434, 63706, 14929, 26096, 42798, 57628, 11398, 28216, 43439, 60240, 5829, 20588, 37884, 5501, 43219, 28241, 11773, 58214, 42647, 25616, 15344, 63795, 48971, 29377, 12402, 63460, 46356, 18572, 3704, 52646, 33576, 16663, 1253, 55877, 39371, 24403, 4748, 53300, 38840, 21978, 60224, 44733, 27707, 9154, 57672, 42168, 31288, 14755, 65428, 48452, 28912, 13932, 62854, 35588, 20222, 3116, 49757, 33219, 18234, 6910, 55307, 40844, 23878, 4225, 54829, 37958, 11203, 59699, 44227, 25113, 8587, 59196, 47783, 30930, 15967, 65007, 45864, 30367, 13315, 52105, 35127, 19633, 731, 49228, 34814, 17760, 6290, 56838, 40360, 21300, 4372, 42173, 6449, 57256, 39955, 21183, 6015, 54776, 35415, 18652, 3748, 49956, 33169, 17964, 1270, 'l', 48608, 31609, 14530, 63081, 46009, 28982, 32874, 15860, 64380, 47341, 30290, 13241, 8034, 41702, 25722, 10200, 59714, 44220, 28201, 12679, 62224, 46446, 30938, 14919, 64970, 47033, 2619, 52400, 36608, 16781, 1143, 50942, 39290, 23492, 7607, 53294, 21936, 59440, 11940, 27931, 41857, 58988, 9408, 31582, 4636, 44950, 26898, 10932, 58408, 41430, 25428, 15604, 65132, 'a', 48620, 31613, 14536, 63052, 46015, 28953, 11912, 60438, 43622, 26610, 9548, 58069, 41005, 23958, 6916, 55442, 38422, 21626, 4574, 53069, 36041, 18990, 1962, 'e', 48609, 31615, 14543, 63056, 45998, 28942, 11910, 60435, 43618, 26616, 9548, 58062, 40994, 23974, 6920, 55455, 38417, 47995, 1782, 49255, 33746, 19798, 2213, 51749, 38295, 22321, 4469, 56549, 40527, 23006, 6960, 59046, 40988, 25513, 11530, 61281, 43753, 29762, 14291, 61753, 48294, 32257, 'a', 48620, 31613, 14536, 63052, 46015, 28991, 11917, 60474, 43630, 26618, 9545, 58077, 41005, 23989, 6946, 55455, 38410, 21600, 4585, 53086, 36050, 18991, 1962, 22120, 60389, 11636, 28353, 41029, 58806, 10038, 30852, 47666, 64623, 12781, 29512, 46335, 63032, 3002, 19718, 36509, 49157, 'e', 48609, 31592, 14532, 63054, 45988, 28980, 11908, 60445, 43625, 26594, Advice.OffsetMapping.ForOrigin.Renderer.ForPropertyName.SYMBOL, 48637, 31601, 14539, 63061, 45991, 28991, 11943, 60441, 43626, 26611, 36181, 12487, 63066, 46584, 31614, 16021, 64523, 41909, 24843, 10075, 60111, 43120, 28650, 11527, 53419, 38453, 43639, 6122, 53618, 37582, 23635, 6566, 56127, 33956, 17949, Advice.OffsetMapping.ForOrigin.Renderer.ForTypeName.SYMBOL, 52709, 36676, 18643, 2598, 'w', 48618, 31602, 14542, 63059, 45990, 28991, 11940, 60445, 43636, 26597, 9540, 58067, 40998, 23958, 6916, 55427, 38428, 21628, 4596, 53084, 36047, 18979, 1974, 50438, 60841, 20529, 38577, 54531, 7061, 24190, 40168, 50012, 452, 18313, 35390, 51355, 3869, 19919, 45164, 63190, 13640, 31691, 47544, 64547, 8890, 24837, 42978, 60017, 10450, 28491, 44344, 'a', 48611, 31602, 14530, 63051, 45966, 28980, 11931, 60439, 43627, 26618, 9544, 58065, 41005, 23974, 42067, 6623, 57154, 40179, 21103, 6033, 'c', 48608, 31595, 14531, 63048, 46009, 28963, 11946, 60439, 43619, 26611, 'w', 48618, 31612, 14558, 63061, 46015, 28991, 11964, 60426, 43627, 5178, 43427, 28468, 11392, 57866, 43007, 25958, 15042, 63602, 48683, 29631, 12556, 63106, 46184, 18943, 3949, 52443, 33354};
    private Map<String, VisaConfigRequest> mConfigRequestMap;
    private JSONObject profileData;

    @Retention(RetentionPolicy.SOURCE)
    public @interface CardBrand {
        public static final String AMEX = "AMEX";
        public static final String DISCOVER = "DISCOVER";
        public static final String ELECTRON = "ELECTRON";
        public static final String ELO = "ELO";
        public static final String MASTERCARD = "MASTERCARD";
        public static final String VISA = "VISA";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Country {
        public static final String AE = "AE";
        public static final String AR = "AR";
        public static final String AU = "AU";
        public static final String BR = "BR";
        public static final String CA = "CA";
        public static final String CL = "CL";
        public static final String CN = "CN";
        public static final String CO = "CO";
        public static final String ES = "ES";
        public static final String FR = "FR";
        public static final String GB = "GB";
        public static final String HK = "HK";
        public static final String IE = "IE";
        public static final String IN = "IN";
        public static final String KW = "KW";
        public static final String MX = "MX";
        public static final String MY = "MY";
        public static final String NZ = "NZ";
        public static final String PE = "PE";
        public static final String PL = "PL";
        public static final String QA = "QA";
        public static final String SA = "SA";
        public static final String SG = "SG";
        public static final String UA = "UA";
        public static final String US = "US";
        public static final String ZA = "ZA";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface DataLevel {
        public static final String FULL = "FULL";
        public static final String NONE = "NONE";
        public static final String SUMMARY = "SUMMARY";
    }

    public static final class ProfileBuilder {

        /* renamed from: ˊ  reason: contains not printable characters */
        private static int f110 = 0;

        /* renamed from: ˎ  reason: contains not printable characters */
        private static int f111 = 1;

        /* renamed from: ˏ  reason: contains not printable characters */
        private static long f112 = -3217091463154850350L;

        /* renamed from: ॱ  reason: contains not printable characters */
        private static char[] f113 = {53530, 29892, 39600, Typography.doubleDagger, 17991, 60426, 13286, 22950, 65479, 1400, 43813, 61722, 5314, 47800, 49258, 26178, 35885, 29951, 53516, 16233, 34212, 58256, 18884, 38436, 64549, 23129, 41132, 3809, 21715, 45322, 8063, 26016, 50133, 10740, 30247, 56415, 14956, 32899, 61128, 13463, 37129, 65390, 17743, 41866, 2545, 22115, 48192, 6686, 24821, 52890, 5319, 28987, 57133, 9554, 33667, 59896, 13875, 39950, 64057, 16556, 44700, 62669, 20849, 49010, 1350, 25534, 51625, 6121, 31748, 55904, 8352, 36567, 54502, 12579, 40732, 58700, 17334, 43500, 63428, 23571, 47669, AbstractJsonLexerKt.END_LIST, 28316, 46321, 4398, 32519, 50504, 9144, 35307, 55242, 15413, 39526, 57417, 20122, 38079, 'a', 42402, 19405, 61757, 38701, 15715, 7109, 48668, 20594, 60095, 35994, 9941, 63778, 37747, 13653, 53164, 25056, 27844, 51477, 10091, 40369, 64434, 20951, 36407, 58489, 16973, 47288, 5887, 19659, 43321, 1894, 54260, 30245, 39003, 8833, 17541, 61168, 12568, 'e', 42428, 19399, 61700, 38705, 15722, 58008, 35031, 12031, 54284, 31359, 8291, 50593, 7368, 47384, 22387, 60840, 35737, 8654, 65073, 37960, 12873, 51383, 26345, 7579, 47172, 22056, 60665, 35547, 8324, 65386, 38159, 13070, 51696, 26542, 5031, 46714, 22537, 58071, 34018, 11946, 61793, 39710, Advice.OffsetMapping.ForOrigin.Renderer.ForDescriptor.SYMBOL, 42419, 19408, 61719, 38692, 15743, 58010, 35035, 12028, 'a', 42417, 19399, 61715, 38712, 15726, 58031, 35039, 12030, 54275, 31312, 8303, 50617, 27588, 4408, 46891, 23874, 667, 43184, 20181, 62473, 39496, 16488, 58797, 37748, 13997, 55508, 25093, 1077, 44654, 29097, 7104, 48618, 18198, 59723, 45950, 22195, 63706, 33305, 9270, 52830, 37261, 'a', 42417, 19399, 61715, 38712, 15726, 57993, 35034, 11971, 54282, 31325, 8310, 50600, 27587, 4370, 46889, 23907, 669, 43185, 20216, 62492, 39496, 16485, 58811, 35779, 24206, 64350, 5416, 45052, 51671, 25473, 48230, 54837, 28733, 35556, 9399, 32389, 39774, 13611, 20468, 59874, 928, 23656, 63045, 4109, 43765, 50364, 7814, 47938, 'a', 42417, 19399, 61715, 38712, 15726, 57993, 35034, 11987, 54275, 31302, 8290, 50586, 27608, 4381, 46880, 23876, 641, 23043, 65484, 4534, 43893, 52572, 26386, 47339, 53940, 29877, 36456, 8251, 31237, 40912, 12728, 19283, 60748, 'w', 42423, 19400, 61717, 38695, 15735, 57993, 35059, 12021, 54289, 31303, 8295, 50623, 27599, 26434, 49794, 11517, 38432, 61458, 23106, 34236, 61382, 18880, 45860, 7538, 18258, 41610, 3322, 30221, 53278, 14950, 26020, 53123, 10698, 37677, 64891, 10064, 33412, 60651, Advice.OffsetMapping.ForOrigin.Renderer.ForReturnTypeName.SYMBOL, 42423, 19408, 61699, 38714, 15732, 57989, 35024, 12023, 54327, 31303, 8291, 50602, 27645, 4377, 46882, 23875, 669, 43177, 20211, 62501, 39519, 16511, 58797, 35793, 12773, 55089, 'c', 42429, 19409, 61720, 38716, 15720, 58005, 35069, 12031, 54278, 31313, 'l', 42429, 19399, 61719, 38692, 15743, 19131, 61307, 266, 48073, 56813, 30626, 43077, 49703, 25646, 40642, 'c', 42407, 19415, 61698, 38695, 15735, 57993, 35020, 11971, 54295, 31300, 8310, 50615, 27608, 4360, 46875, 23890, 670, 'a', 42430, 19400, 61721, 38719, 15711, 57986, 35020, 12031, 54286, 31320, 8299, 50621, 27588, 4360};
        private JSONObject additionalData = new JSONObject();
        private Map<String, VisaConfigRequest> mConfigRequestMap = new HashMap();

        public ProfileBuilder(@NonNull String str, String str2) {
            put(m6103(6, 95, 0).intern(), str);
            put(m6103(11, 101, 7072).intern(), str2);
        }

        public static /* synthetic */ JSONObject access$000(ProfileBuilder profileBuilder) {
            int i11 = f111;
            int i12 = i11 + 79;
            f110 = i12 % 128;
            int i13 = i12 % 2;
            JSONObject jSONObject = profileBuilder.additionalData;
            int i14 = i11 + 13;
            f110 = i14 % 128;
            if (i14 % 2 != 0) {
                int i15 = 51 / 0;
            }
            return jSONObject;
        }

        public static /* synthetic */ Map access$100(ProfileBuilder profileBuilder) {
            int i11 = f110 + 67;
            f111 = i11 % 128;
            char c11 = i11 % 2 == 0 ? 21 : Typography.less;
            Map<String, VisaConfigRequest> map = profileBuilder.mConfigRequestMap;
            if (c11 != 21) {
                return map;
            }
            throw null;
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        private static String m6103(int i11, int i12, char c11) {
            char c12;
            char c13;
            int i13 = f111 + 35;
            f110 = i13 % 128;
            int i14 = i13 % 2;
            char[] cArr = new char[i11];
            int i15 = 0;
            while (true) {
                if (i15 < i11) {
                    c12 = '8';
                } else {
                    c12 = '(';
                }
                if (c12 != '8') {
                    return new String(cArr);
                }
                int i16 = f111 + 9;
                f110 = i16 % 128;
                if (i16 % 2 != 0) {
                    c13 = 'Z';
                } else {
                    c13 = '\"';
                }
                if (c13 != 'Z') {
                    cArr[i15] = (char) ((int) ((((long) f113[i12 + i15]) ^ (((long) i15) * f112)) ^ ((long) c11)));
                    i15++;
                } else {
                    cArr[i15] = (char) ((int) ((((long) f113[i12 - i15]) % (((long) i15) * f112)) % ((long) c11)));
                    i15 += 126;
                }
            }
        }

        public final Profile build() {
            Profile profile = new Profile(this);
            int i11 = f111 + 61;
            f110 = i11 % 128;
            if ((i11 % 2 != 0 ? 19 : 'E') != 'E') {
                int i12 = 21 / 0;
            }
            return profile;
        }

        public final ProfileBuilder put(String str, Object obj) {
            char c11;
            char c12;
            int i11 = f110 + 27;
            f111 = i11 % 128;
            if (i11 % 2 == 0) {
                c11 = '+';
            } else {
                c11 = '5';
            }
            if (c11 == '+') {
                try {
                    if (Build.VERSION.SDK_INT < 96) {
                        c12 = 'B';
                    } else {
                        c12 = '8';
                    }
                    if (c12 == 'B') {
                        m6103(17, 0, 53625).intern();
                        m6103(78, 17, 29883).intern();
                        return this;
                    }
                } catch (JSONException unused) {
                }
            }
            if (obj instanceof String[]) {
                this.additionalData.put(str, (Object) new JSONArray(obj));
                return this;
            }
            this.additionalData.put(str, obj);
            int i12 = f110 + 11;
            f111 = i12 % 128;
            int i13 = i12 % 2;
            return this;
        }

        public final ProfileBuilder setAcceptCanadianVisaDebit(boolean z11) {
            char c11;
            int i11 = f111 + 91;
            f110 = i11 % 128;
            int i12 = i11 % 2;
            put(m6103(24, Opcodes.INVOKEINTERFACE, 0).intern(), Boolean.valueOf(z11));
            int i13 = f110 + 121;
            f111 = i13 % 128;
            if (i13 % 2 == 0) {
                c11 = 28;
            } else {
                c11 = AbstractJsonLexerKt.END_LIST;
            }
            if (c11 != 28) {
                return this;
            }
            throw null;
        }

        public final ProfileBuilder setAllowEnrollment(boolean z11) {
            int i11 = f110 + 7;
            f111 = i11 % 128;
            int i12 = i11 % 2;
            put(m6103(15, 421, 0).intern(), Boolean.valueOf(z11));
            int i13 = f110 + 13;
            f111 = i13 % 128;
            int i14 = i13 % 2;
            return this;
        }

        public final ProfileBuilder setBillingCountries(String[] strArr) {
            char c11;
            int i11;
            int i12;
            char c12;
            int i13 = f111 + 55;
            f110 = i13 % 128;
            if (i13 % 2 != 0) {
                c11 = '#';
            } else {
                c11 = '(';
            }
            if (c11 != '(') {
                i11 = 96;
                i12 = 5237;
            } else {
                i11 = 24;
                i12 = 252;
            }
            put(m6103(i11, i12, 24303).intern(), strArr);
            int i14 = f111 + 53;
            f110 = i14 % 128;
            if (i14 % 2 != 0) {
                c12 = 'C';
            } else {
                c12 = 'Q';
            }
            if (c12 != 'C') {
                return this;
            }
            int i15 = 86 / 0;
            return this;
        }

        public final ProfileBuilder setCardBrands(String[] strArr) {
            char c11;
            int i11 = f110 + 91;
            f111 = i11 % 128;
            int i12 = i11 % 2;
            put(m6103(18, 276, 0).intern(), strArr);
            int i13 = f110 + 115;
            f111 = i13 % 128;
            if (i13 % 2 == 0) {
                c11 = 'G';
            } else {
                c11 = '2';
            }
            if (c11 != '2') {
                int i14 = 39 / 0;
            }
            return this;
        }

        public final ProfileBuilder setCountryCode(@NonNull String str) {
            boolean z11;
            int i11;
            int i12;
            char c11;
            int i13 = f111 + 29;
            f110 = i13 % 128;
            if (i13 % 2 != 0) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (!z11) {
                i11 = 40;
                i12 = 19017;
            } else {
                i11 = 11;
                i12 = 376;
            }
            put(m6103(i11, i12, 0).intern(), str);
            int i14 = f110 + 57;
            f111 = i14 % 128;
            if (i14 % 2 == 0) {
                c11 = '?';
            } else {
                c11 = 4;
            }
            if (c11 == 4) {
                return this;
            }
            throw null;
        }

        public final ProfileBuilder setCustomerSupportUrl(@NonNull String str) {
            char c11;
            int i11;
            int i12;
            int i13 = f111 + 17;
            f110 = i13 % 128;
            if (i13 % 2 != 0) {
                c11 = 'V';
            } else {
                c11 = 'P';
            }
            if (c11 != 'V') {
                i11 = 18;
                i12 = 403;
            } else {
                i11 = 20;
                i12 = 29401;
            }
            put(m6103(i11, i12, 0).intern(), str);
            return this;
        }

        public final ProfileBuilder setDataLevel(String str) {
            int i11 = f111 + 23;
            f110 = i11 % 128;
            int i12 = i11 % 2;
            put(m6103(9, Opcodes.ARETURN, 0).intern(), str);
            int i13 = f110 + 119;
            f111 = i13 % 128;
            int i14 = i13 % 2;
            return this;
        }

        public final ProfileBuilder setDisplayName(@NonNull String str) {
            int i11 = f111 + 99;
            f110 = i11 % 128;
            int i12 = i11 % 2;
            put(m6103(11, Opcodes.IFGT, 7679).intern(), str);
            int i13 = f111 + 19;
            f110 = i13 % 128;
            int i14 = i13 % 2;
            return this;
        }

        public final ProfileBuilder setEnableTokenization(boolean z11) {
            boolean z12;
            int i11;
            int i12;
            int i13 = f111 + 25;
            f110 = i13 % 128;
            if (i13 % 2 != 0) {
                z12 = false;
            } else {
                z12 = true;
            }
            if (z12) {
                i12 = 18;
                i11 = 209;
            } else {
                i12 = 48;
                i11 = 27114;
            }
            put(m6103(i12, i11, 37649).intern(), Boolean.valueOf(z11));
            return this;
        }

        public final ProfileBuilder setEncryptionKey(@NonNull String str) {
            char c11;
            int i11 = f111 + 9;
            f110 = i11 % 128;
            int i12 = i11 % 2;
            put(m6103(13, Opcodes.I2L, 0).intern(), str);
            int i13 = f110 + 77;
            f111 = i13 % 128;
            if (i13 % 2 == 0) {
                c11 = '*';
            } else {
                c11 = 4;
            }
            if (c11 != '*') {
                return this;
            }
            throw null;
        }

        public final ProfileBuilder setExternalClientId(@NonNull String str) {
            char c11;
            int i11;
            int i12;
            int i13 = f110 + 37;
            f111 = i13 % 128;
            if (i13 % 2 == 0) {
                c11 = 18;
            } else {
                c11 = 24;
            }
            if (c11 != 18) {
                i12 = 16;
                i11 = 294;
            } else {
                i12 = 9;
                i11 = 14527;
            }
            put(m6103(i12, i11, 23142).intern(), str);
            return this;
        }

        public final ProfileBuilder setLocale(@NonNull String str) {
            boolean z11;
            int i11;
            int i12;
            char c11;
            int i13 = f110 + 25;
            f111 = i13 % 128;
            if (i13 % 2 == 0) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                i12 = 6;
                i11 = 387;
            } else {
                i12 = 28;
                i11 = 8806;
            }
            put(m6103(i12, i11, 0).intern(), str);
            int i14 = f111 + 33;
            f110 = i14 % 128;
            if (i14 % 2 != 0) {
                c11 = '0';
            } else {
                c11 = 'P';
            }
            if (c11 != '0') {
                return this;
            }
            throw null;
        }

        @Deprecated
        public final ProfileBuilder setLogoResourceId(@DrawableRes int i11) {
            boolean z11;
            int i12 = f111 + 23;
            f110 = i12 % 128;
            int i13 = i12 % 2;
            put(m6103(14, 112, 27816).intern(), Integer.valueOf(i11));
            int i14 = f111 + 9;
            f110 = i14 % 128;
            if (i14 % 2 != 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                return this;
            }
            throw null;
        }

        public final ProfileBuilder setLogoUrl(String str) {
            char c11;
            int i11 = f110 + 81;
            f111 = i11 % 128;
            int i12 = i11 % 2;
            put(m6103(7, 126, 54168).intern(), str);
            int i13 = f110 + 21;
            f111 = i13 % 128;
            if (i13 % 2 == 0) {
                c11 = 'a';
            } else {
                c11 = 24;
            }
            if (c11 != 24) {
                int i14 = 54 / 0;
            }
            return this;
        }

        public final ProfileBuilder setMerchantId(@NonNull String str) {
            boolean z11;
            int i11 = f110 + 11;
            f111 = i11 % 128;
            int i12 = i11 % 2;
            put(m6103(8, Opcodes.JSR, 5060).intern(), str);
            int i13 = f110 + 85;
            f111 = i13 % 128;
            if (i13 % 2 == 0) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                return this;
            }
            throw null;
        }

        public final ProfileBuilder setNewUserWelcomeMessage(String str) {
            int i11 = f111 + 117;
            f110 = i11 % 128;
            int i12 = i11 % 2;
            put(m6103(14, 310, 0).intern(), str);
            int i13 = f111 + 39;
            f110 = i13 % 128;
            int i14 = i13 % 2;
            return this;
        }

        public final ProfileBuilder setNewUserWelcomeMessageDesc(String str) {
            boolean z11;
            int i11;
            int i12;
            int i13 = f110 + 87;
            f111 = i13 % 128;
            if (i13 % 2 == 0) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (!z11) {
                i11 = 113;
                i12 = 20832;
            } else {
                i11 = 25;
                i12 = 324;
            }
            put(m6103(i11, i12, 26421).intern(), str);
            return this;
        }

        public final ProfileBuilder setProfileName(@NonNull String str) {
            boolean z11;
            int i11;
            int i12;
            int i13 = f111 + 3;
            f110 = i13 % 128;
            if (i13 % 2 != 0) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                i12 = 11;
                i11 = Opcodes.I2C;
            } else {
                i12 = 15;
                i11 = 11188;
            }
            put(m6103(i12, i11, 7352).intern(), str);
            int i14 = f111 + 5;
            f110 = i14 % 128;
            int i15 = i14 % 2;
            return this;
        }

        public final ProfileBuilder setReturnUserWelcomeMessage(String str) {
            int i11 = f111 + 7;
            f110 = i11 % 128;
            int i12 = i11 % 2;
            boolean z11 = false;
            put(m6103(27, 349, 0).intern(), str);
            int i13 = f111 + 77;
            f110 = i13 % 128;
            if (i13 % 2 == 0) {
                z11 = true;
            }
            if (z11) {
                return this;
            }
            throw null;
        }

        public final ProfileBuilder setShippingCountries(String[] strArr) {
            char c11;
            int i11;
            int i12;
            int i13 = f111 + 29;
            f110 = i13 % 128;
            if (i13 % 2 != 0) {
                c11 = 'G';
            } else {
                c11 = '8';
            }
            boolean z11 = false;
            if (c11 != 'G') {
                i11 = 25;
                i12 = 227;
            } else {
                i11 = 77;
                i12 = 12194;
            }
            put(m6103(i11, i12, 0).intern(), strArr);
            int i14 = f110 + 61;
            f111 = i14 % 128;
            if (i14 % 2 == 0) {
                z11 = true;
            }
            if (!z11) {
                return this;
            }
            throw null;
        }

        public final ProfileBuilder setWebsiteUrl(@NonNull String str) {
            char c11;
            int i11 = f110 + 103;
            f111 = i11 % 128;
            int i12 = i11 % 2;
            put(m6103(10, 393, 19148).intern(), str);
            int i13 = f110 + 105;
            f111 = i13 % 128;
            if (i13 % 2 == 0) {
                c11 = '?';
            } else {
                c11 = 'I';
            }
            if (c11 != '?') {
                return this;
            }
            throw null;
        }
    }

    static {
        char c11;
        int i11 = f108 + 115;
        f107 = i11 % 128;
        if (i11 % 2 != 0) {
            c11 = 27;
        } else {
            c11 = 'Y';
        }
        if (c11 != 'Y') {
            throw null;
        }
    }

    private boolean getBool(String str) {
        int i11 = f107 + 41;
        f108 = i11 % 128;
        int i12 = i11 % 2;
        boolean optBoolean = this.profileData.optBoolean(str);
        int i13 = f108 + 85;
        f107 = i13 % 128;
        int i14 = i13 % 2;
        return optBoolean;
    }

    private int getInt(String str) {
        int i11 = f108 + 3;
        f107 = i11 % 128;
        if ((i11 % 2 != 0 ? '$' : '-') == '-') {
            int optInt = this.profileData.optInt(str);
            int i12 = f107 + 47;
            f108 = i12 % 128;
            if (i12 % 2 != 0) {
                return optInt;
            }
            throw null;
        }
        this.profileData.optInt(str);
        throw null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0029, code lost:
        if (r4 == null) goto L_0x002b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0044, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001d, code lost:
        if (r1 != false) goto L_0x002b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String getString(java.lang.String r4) {
        /*
            r3 = this;
            int r0 = f108
            int r0 = r0 + 39
            int r1 = r0 % 128
            f107 = r1
            int r0 = r0 % 2
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0010
            r0 = r2
            goto L_0x0011
        L_0x0010:
            r0 = r1
        L_0x0011:
            if (r0 == 0) goto L_0x0020
            org.json.JSONObject r0 = r3.profileData
            java.lang.String r4 = r0.optString(r4)
            if (r4 != 0) goto L_0x001c
            goto L_0x001d
        L_0x001c:
            r1 = r2
        L_0x001d:
            if (r1 == 0) goto L_0x0044
            goto L_0x002b
        L_0x0020:
            org.json.JSONObject r0 = r3.profileData
            java.lang.String r4 = r0.optString(r4)
            r0 = 40
            int r0 = r0 / r2
            if (r4 != 0) goto L_0x0044
        L_0x002b:
            int r4 = f107
            int r4 = r4 + 101
            int r0 = r4 % 128
            f108 = r0
            int r4 = r4 % 2
            r0 = 35
            if (r4 != 0) goto L_0x003c
            r4 = 85
            goto L_0x003d
        L_0x003c:
            r4 = r0
        L_0x003d:
            if (r4 != r0) goto L_0x0042
            java.lang.String r4 = ""
            return r4
        L_0x0042:
            r4 = 0
            throw r4
        L_0x0044:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.visa.checkout.Profile.getString(java.lang.String):java.lang.String");
    }

    private String[] getStringArray(String str) {
        boolean z11;
        int i11 = f108 + 95;
        f107 = i11 % 128;
        int i12 = i11 % 2;
        try {
            JSONArray jSONArray = this.profileData.getJSONArray(str);
            String[] strArr = new String[jSONArray.length()];
            int i13 = 0;
            while (true) {
                if (i13 < jSONArray.length()) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (!z11) {
                    return strArr;
                }
                int i14 = f108 + 71;
                f107 = i14 % 128;
                int i15 = i14 % 2;
                strArr[i13] = jSONArray.getString(i13);
                i13++;
                int i16 = f108 + 45;
                f107 = i16 % 128;
                int i17 = i16 % 2;
            }
        } catch (Exception unused) {
            return new String[0];
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static String m6102(int i11, int i12, char c11) {
        char c12;
        boolean z11;
        int i13 = f108 + 77;
        f107 = i13 % 128;
        int i14 = i13 % 2;
        char[] cArr = new char[i11];
        int i15 = 0;
        while (true) {
            if (i15 < i11) {
                c12 = '#';
            } else {
                c12 = 19;
            }
            if (c12 != 19) {
                int i16 = f107 + 105;
                f108 = i16 % 128;
                if (i16 % 2 == 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    cArr[i15] = (char) ((int) ((((long) f109[i12 % i15]) % (((long) i15) % f106)) % ((long) c11)));
                    i15 += 65;
                } else {
                    cArr[i15] = (char) ((int) ((((long) f109[i12 + i15]) ^ (((long) i15) * f106)) ^ ((long) c11)));
                    i15++;
                }
            } else {
                String str = new String(cArr);
                int i17 = f107 + 111;
                f108 = i17 % 128;
                int i18 = i17 % 2;
                return str;
            }
        }
    }

    public int describeContents() {
        int i11 = f108 + 125;
        int i12 = i11 % 128;
        f107 = i12;
        int i13 = i11 % 2 != 0 ? 1 : 0;
        int i14 = i12 + 91;
        f108 = i14 % 128;
        if ((i14 % 2 == 0 ? 'M' : 'c') == 'c') {
            return i13;
        }
        throw null;
    }

    public Object get(String str) {
        int i11 = f107 + 49;
        f108 = i11 % 128;
        int i12 = i11 % 2;
        Object opt = this.profileData.opt(str);
        int i13 = f107 + 69;
        f108 = i13 % 128;
        if (!(i13 % 2 == 0)) {
            return opt;
        }
        throw null;
    }

    public String[] getAcceptedBillingCountries() {
        int i11 = f107 + 19;
        f108 = i11 % 128;
        int i12 = i11 % 2;
        boolean z11 = false;
        String[] stringArray = getStringArray(m6102(24, 230, 0).intern());
        int i13 = f107 + 19;
        f108 = i13 % 128;
        if (i13 % 2 != 0) {
            z11 = true;
        }
        if (z11) {
            return stringArray;
        }
        throw null;
    }

    public String[] getAcceptedCardBrands() {
        int i11 = f107 + 31;
        f108 = i11 % 128;
        int i12 = i11 % 2;
        String[] stringArray = getStringArray(m6102(18, 254, 22025).intern());
        int i13 = f108 + 87;
        f107 = i13 % 128;
        int i14 = i13 % 2;
        return stringArray;
    }

    public String[] getAcceptedShippingCountries() {
        int i11 = f108 + 67;
        f107 = i11 % 128;
        boolean z11 = true;
        String[] stringArray = getStringArray((!(i11 % 2 == 0) ? m6102(67, 11473, 47898) : m6102(25, 205, 47898)).intern());
        int i12 = f108 + 85;
        f107 = i12 % 128;
        if (i12 % 2 != 0) {
            z11 = false;
        }
        if (z11) {
            return stringArray;
        }
        int i13 = 27 / 0;
        return stringArray;
    }

    public String getApiKey() {
        int i11 = f108 + 75;
        f107 = i11 % 128;
        int i12 = i11 % 2;
        String string = getString(m6102(6, 116, 32779).intern());
        int i13 = f108 + 99;
        f107 = i13 % 128;
        int i14 = i13 % 2;
        return string;
    }

    public String getClientId() {
        int i11;
        int i12;
        int i13 = f108 + 57;
        f107 = i13 % 128;
        if (i13 % 2 == 0) {
            i12 = 8;
            i11 = Opcodes.I2C;
        } else {
            i12 = 112;
            i11 = 995;
        }
        return getString(m6102(i12, i11, 21971).intern());
    }

    public Map<String, VisaConfigRequest> getConfigRequestMap() {
        int i11 = f108;
        int i12 = i11 + 5;
        f107 = i12 % 128;
        int i13 = i12 % 2;
        Map<String, VisaConfigRequest> map = this.mConfigRequestMap;
        int i14 = i11 + 77;
        f107 = i14 % 128;
        int i15 = i14 % 2;
        return map;
    }

    public String getCountryCode() {
        int i11;
        int i12;
        int i13 = f107 + 33;
        f108 = i13 % 128;
        if ((i13 % 2 == 0 ? 'O' : '^') != 'O') {
            i12 = 11;
            i11 = 397;
        } else {
            i12 = 22;
            i11 = 5852;
        }
        return getString(m6102(i12, i11, 0).intern());
    }

    public String getCustomerSupportUrl() {
        int i11 = f108 + 85;
        f107 = i11 % 128;
        int i12 = i11 % 2;
        String string = getString(m6102(18, 418, 5209).intern());
        int i13 = f108 + 5;
        f107 = i13 % 128;
        if (i13 % 2 == 0) {
            return string;
        }
        throw null;
    }

    public String getDataLevel() {
        int i11;
        int i12;
        int i13 = f108 + 71;
        f107 = i13 % 128;
        if ((i13 % 2 != 0 ? 10 : 'b') != 10) {
            i12 = 9;
            i11 = Opcodes.IFNE;
        } else {
            i12 = 93;
            i11 = 28060;
        }
        String string = getString(m6102(i12, i11, 4728).intern());
        int i14 = f107 + 117;
        f108 = i14 % 128;
        if ((i14 % 2 == 0 ? 18 : '<') != '<') {
            int i15 = 70 / 0;
        }
        return string;
    }

    public String getDisplayName() {
        int i11;
        int i12;
        int i13 = f107 + 51;
        f108 = i13 % 128;
        if ((i13 % 2 == 0 ? 4 : '2') != 4) {
            i12 = 11;
            i11 = 135;
        } else {
            i12 = 83;
            i11 = 6557;
        }
        String string = getString(m6102(i12, i11, 47069).intern());
        int i14 = f107 + 99;
        f108 = i14 % 128;
        int i15 = i14 % 2;
        return string;
    }

    public String getEncryptionKey() {
        int i11;
        int i12;
        int i13 = f107 + 103;
        f108 = i13 % 128;
        if ((i13 % 2 == 0 ? '7' : 5) != '7') {
            i11 = 13;
            i12 = 122;
        } else {
            i11 = 76;
            i12 = 65;
        }
        return getString(m6102(i11, i12, 7943).intern());
    }

    public String getEnvironment() {
        int i11 = f108 + 103;
        f107 = i11 % 128;
        int i12 = i11 % 2;
        boolean z11 = false;
        String string = getString(m6102(11, 272, 0).intern());
        int i13 = f108 + 119;
        f107 = i13 % 128;
        if (i13 % 2 != 0) {
            z11 = true;
        }
        if (!z11) {
            return string;
        }
        throw null;
    }

    public String getExternalClientId() {
        int i11;
        int i12;
        int i13 = f107 + 27;
        f108 = i13 % 128;
        if (i13 % 2 != 0) {
            i12 = 16;
            i11 = 294;
        } else {
            i12 = 96;
            i11 = 22104;
        }
        return getString(m6102(i12, i11, 36144).intern());
    }

    public String getLocale() {
        int i11 = f108 + 21;
        f107 = i11 % 128;
        int i12 = i11 % 2;
        String string = getString(m6102(6, 391, 42047).intern());
        int i13 = f108 + 29;
        f107 = i13 % 128;
        if ((i13 % 2 != 0 ? 7 : '\"') == '\"') {
            return string;
        }
        throw null;
    }

    @Deprecated
    @DrawableRes
    public int getLogoResourceId() {
        int i11 = f108 + 41;
        f107 = i11 % 128;
        int i12 = i11 % 2;
        int i13 = getInt(m6102(14, 95, 42193).intern());
        int i14 = f108 + 99;
        f107 = i14 % 128;
        if ((i14 % 2 != 0 ? 7 : 'X') != 7) {
            return i13;
        }
        throw null;
    }

    public String getLogoUrl() {
        int i11;
        int i12;
        int i13 = f107 + 1;
        f108 = i13 % 128;
        if ((i13 % 2 == 0 ? '2' : '&') != '&') {
            i12 = 20;
            i11 = 16;
        } else {
            i12 = 7;
            i11 = 109;
        }
        return getString(m6102(i12, i11, 0).intern());
    }

    public String getNewUserWelcomeMessage() {
        int i11;
        int i12;
        int i13 = f108 + 93;
        f107 = i13 % 128;
        if ((i13 % 2 != 0 ? 3 : 'P') != 'P') {
            i11 = 91;
            i12 = 9734;
        } else {
            i11 = 14;
            i12 = 310;
        }
        String string = getString(m6102(i11, i12, 43520).intern());
        int i14 = f107 + 119;
        f108 = i14 % 128;
        if (!(i14 % 2 == 0)) {
            return string;
        }
        throw null;
    }

    public String getNewUserWelcomeMessageDesc() {
        int i11;
        int i12;
        int i13 = f107 + 99;
        f108 = i13 % 128;
        if ((i13 % 2 == 0 ? Typography.amp : 'B') != 'B') {
            i11 = 107;
            i12 = 31866;
        } else {
            i11 = 25;
            i12 = 324;
        }
        return getString(m6102(i11, i12, 0).intern());
    }

    public String getProfileName() {
        int i11;
        int i12;
        int i13 = f107 + 101;
        f108 = i13 % 128;
        if ((i13 % 2 == 0 ? AbstractJsonLexerKt.COMMA : 1) != 1) {
            i12 = 33;
            i11 = 4636;
        } else {
            i12 = 11;
            i11 = 283;
        }
        return getString(m6102(i12, i11, 0).intern());
    }

    public String getReturnUserWelcomeMessage() {
        int i11;
        int i12;
        int i13 = f108 + 97;
        f107 = i13 % 128;
        if ((i13 % 2 != 0 ? '_' : 'c') != 'c') {
            i11 = 65;
            i12 = 15715;
        } else {
            i11 = 27;
            i12 = 349;
        }
        return getString(m6102(i11, i12, 60891).intern());
    }

    public String getWebsiteUrl() {
        int i11 = f107 + 93;
        f108 = i11 % 128;
        int i12 = i11 % 2;
        String string = getString(m6102(10, ErrorCode.HTTP_CLIENT_TIMEOUT, 0).intern());
        int i13 = f108 + 59;
        f107 = i13 % 128;
        int i14 = i13 % 2;
        return string;
    }

    public boolean isAcceptCanadianVisaDebit() {
        int i11;
        int i12;
        int i13 = f107 + 33;
        f108 = i13 % 128;
        if (i13 % 2 == 0) {
            i12 = 79;
            i11 = 27462;
        } else {
            i12 = 24;
            i11 = Opcodes.IF_ICMPGT;
        }
        boolean bool = getBool(m6102(i12, i11, 0).intern());
        int i14 = f107 + 105;
        f108 = i14 % 128;
        int i15 = i14 % 2;
        return bool;
    }

    public boolean isAllowEnrollment() {
        int i11;
        int i12;
        int i13 = f107 + 27;
        f108 = i13 % 128;
        if (i13 % 2 != 0) {
            i12 = 15;
            i11 = 376;
        } else {
            i12 = 23;
            i11 = 20883;
        }
        return getBool(m6102(i12, i11, 0).intern());
    }

    public boolean isEnableTokenization() {
        int i11 = f108 + 119;
        f107 = i11 % 128;
        boolean bool = getBool((!(i11 % 2 != 0 ? true : true) ? m6102(33, 24254, 0) : m6102(18, Opcodes.NEW, 0)).intern());
        int i12 = f107 + 9;
        f108 = i12 % 128;
        if ((i12 % 2 == 0 ? 11 : 'I') == 'I') {
            return bool;
        }
        throw null;
    }

    public JSONObject toJSON() throws JSONException {
        int i11 = f108;
        int i12 = i11 + 95;
        f107 = i12 % 128;
        if (i12 % 2 == 0) {
            JSONObject jSONObject = this.profileData;
            int i13 = i11 + 23;
            f107 = i13 % 128;
            int i14 = i13 % 2;
            return jSONObject;
        }
        throw null;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        int i12 = f108 + 53;
        f107 = i12 % 128;
        if ((i12 % 2 != 0 ? 'X' : AbstractJsonLexerKt.COMMA) != 'X') {
            JSONObject jSONObject = this.profileData;
            parcel.writeString(!(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject));
            int i13 = f107 + 27;
            f108 = i13 % 128;
            int i14 = i13 % 2;
            return;
        }
        JSONObject jSONObject2 = this.profileData;
        parcel.writeString(!(jSONObject2 instanceof JSONObject) ? jSONObject2.toString() : JSONObjectInstrumentation.toString(jSONObject2));
        throw null;
    }

    private Profile(Parcel parcel) {
        this.profileData = new JSONObject();
        this.mConfigRequestMap = new HashMap();
        try {
            this.profileData = new JSONObject(parcel.readString());
        } catch (Exception unused) {
            this.profileData = new JSONObject();
        }
    }

    public Profile(JSONObject jSONObject) {
        this.profileData = new JSONObject();
        this.mConfigRequestMap = new HashMap();
        if (jSONObject != null) {
            this.profileData = jSONObject;
        }
    }

    private Profile(ProfileBuilder profileBuilder) {
        this.profileData = new JSONObject();
        this.mConfigRequestMap = new HashMap();
        this.profileData = ProfileBuilder.access$000(profileBuilder);
        this.mConfigRequestMap = ProfileBuilder.access$100(profileBuilder);
    }
}
