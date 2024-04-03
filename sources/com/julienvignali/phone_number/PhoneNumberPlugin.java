package com.julienvignali.phone_number;

import android.content.Context;
import android.telephony.TelephonyManager;
import androidx.annotation.NonNull;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.i18n.phonenumbers.AsYouTypeFormatter;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import com.talabat.homescreen.network.UrlConstantsKt;
import com.tekartik.sqflite.Constant;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class PhoneNumberPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {
    private MethodChannel channel;
    private Context context;

    /* renamed from: com.julienvignali.phone_number.PhoneNumberPlugin$2  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f52717a;

        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|26) */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.google.i18n.phonenumbers.PhoneNumberUtil$PhoneNumberType[] r0 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f52717a = r0
                com.google.i18n.phonenumbers.PhoneNumberUtil$PhoneNumberType r1 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType.FIXED_LINE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f52717a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.i18n.phonenumbers.PhoneNumberUtil$PhoneNumberType r1 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType.MOBILE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f52717a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.i18n.phonenumbers.PhoneNumberUtil$PhoneNumberType r1 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType.FIXED_LINE_OR_MOBILE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f52717a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.i18n.phonenumbers.PhoneNumberUtil$PhoneNumberType r1 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType.TOLL_FREE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f52717a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.i18n.phonenumbers.PhoneNumberUtil$PhoneNumberType r1 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType.PREMIUM_RATE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f52717a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.i18n.phonenumbers.PhoneNumberUtil$PhoneNumberType r1 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType.SHARED_COST     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f52717a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.i18n.phonenumbers.PhoneNumberUtil$PhoneNumberType r1 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType.VOIP     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f52717a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.google.i18n.phonenumbers.PhoneNumberUtil$PhoneNumberType r1 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType.PERSONAL_NUMBER     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f52717a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.google.i18n.phonenumbers.PhoneNumberUtil$PhoneNumberType r1 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType.PAGER     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f52717a     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.google.i18n.phonenumbers.PhoneNumberUtil$PhoneNumberType r1 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType.UAN     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f52717a     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.google.i18n.phonenumbers.PhoneNumberUtil$PhoneNumberType r1 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType.VOICEMAIL     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f52717a     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.google.i18n.phonenumbers.PhoneNumberUtil$PhoneNumberType r1 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.julienvignali.phone_number.PhoneNumberPlugin.AnonymousClass2.<clinit>():void");
        }
    }

    private void carrierRegionCode(MethodChannel.Result result) {
        result.success(((TelephonyManager) this.context.getSystemService("phone")).getNetworkCountryIso());
    }

    private void format(MethodCall methodCall, MethodChannel.Result result) {
        String str = (String) methodCall.argument("region");
        String str2 = (String) methodCall.argument(TypedValues.Custom.S_STRING);
        if (str2 == null) {
            result.error("InvalidParameters", "Invalid 'string' parameter.", (Object) null);
            return;
        }
        try {
            AsYouTypeFormatter asYouTypeFormatter = PhoneNumberUtil.getInstance().getAsYouTypeFormatter(str);
            String str3 = "";
            asYouTypeFormatter.clear();
            for (char inputDigit : str2.toCharArray()) {
                str3 = asYouTypeFormatter.inputDigit(inputDigit);
            }
            HashMap hashMap = new HashMap();
            hashMap.put("formatted", str3);
            result.success(hashMap);
        } catch (Exception unused) {
            result.error("InvalidNumber", "Number " + str2 + " is invalid", (Object) null);
        }
    }

    private void getAllSupportedRegions(MethodCall methodCall, MethodChannel.Result result) {
        Locale locale;
        ArrayList arrayList = new ArrayList();
        String str = (String) methodCall.argument("locale");
        if (str == null) {
            locale = Locale.getDefault();
        } else {
            locale = new Locale(str);
        }
        for (String next : PhoneNumberUtil.getInstance().getSupportedRegions()) {
            HashMap hashMap = new HashMap();
            hashMap.put("name", new Locale("", next).getDisplayCountry(locale));
            hashMap.put(Constant.PARAM_ERROR_CODE, next);
            hashMap.put("prefix", Integer.valueOf(PhoneNumberUtil.getInstance().getCountryCodeForRegion(next)));
            arrayList.add(hashMap);
        }
        result.success(arrayList);
    }

    /* access modifiers changed from: private */
    public String numberTypeToString(PhoneNumberUtil.PhoneNumberType phoneNumberType) {
        switch (AnonymousClass2.f52717a[phoneNumberType.ordinal()]) {
            case 1:
                return "fixedLine";
            case 2:
                return "mobile";
            case 3:
                return "fixedOrMobile";
            case 4:
                return "tollFree";
            case 5:
                return "premiumRate";
            case 6:
                return "sharedCost";
            case 7:
                return "voip";
            case 8:
                return "personalNumber";
            case 9:
                return "pager";
            case 10:
                return "uan";
            case 11:
                return "voicemail";
            case 12:
                return "unknown";
            default:
                return "notParsed";
        }
    }

    private void parse(MethodCall methodCall, MethodChannel.Result result) {
        String str = (String) methodCall.argument("region");
        String str2 = (String) methodCall.argument(TypedValues.Custom.S_STRING);
        if (str2 == null || str2.isEmpty()) {
            result.error("InvalidParameters", "Invalid 'string' parameter.", (Object) null);
            return;
        }
        HashMap<String, String> parseStringAndRegion = parseStringAndRegion(str2, str, PhoneNumberUtil.getInstance());
        if (parseStringAndRegion != null) {
            result.success(parseStringAndRegion);
            return;
        }
        result.error("InvalidNumber", "Number " + str2 + " is invalid", (Object) null);
    }

    private void parseList(MethodCall methodCall, MethodChannel.Result result) {
        String str = (String) methodCall.argument("region");
        List<String> list = (List) methodCall.argument("strings");
        if (list == null || list.isEmpty()) {
            result.error("InvalidParameters", "Invalid 'strings' parameter.", (Object) null);
            return;
        }
        PhoneNumberUtil instance = PhoneNumberUtil.getInstance();
        HashMap hashMap = new HashMap(list.size());
        for (String str2 : list) {
            hashMap.put(str2, parseStringAndRegion(str2, str, instance));
        }
        result.success(hashMap);
    }

    private HashMap<String, String> parseStringAndRegion(String str, String str2, PhoneNumberUtil phoneNumberUtil) {
        try {
            Phonenumber.PhoneNumber parse = phoneNumberUtil.parse(str, str2);
            if (!phoneNumberUtil.isValidNumber(parse)) {
                return null;
            }
            return new HashMap<String, String>(phoneNumberUtil, parse) {

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ PhoneNumberUtil f52714b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ Phonenumber.PhoneNumber f52715c;

                {
                    this.f52714b = r5;
                    this.f52715c = r6;
                    PhoneNumberUtil.PhoneNumberType numberType = r5.getNumberType(r6);
                    int countryCode = r6.getCountryCode();
                    put("type", PhoneNumberPlugin.this.numberTypeToString(numberType));
                    put("e164", r5.format(r6, PhoneNumberUtil.PhoneNumberFormat.E164));
                    put("international", r5.format(r6, PhoneNumberUtil.PhoneNumberFormat.INTERNATIONAL));
                    put("national", r5.format(r6, PhoneNumberUtil.PhoneNumberFormat.NATIONAL));
                    put(UrlConstantsKt.PATH_COUNTRY_CODE, String.valueOf(countryCode));
                    put("region_code", String.valueOf(r5.getRegionCodeForCountryCode(countryCode)));
                    put("national_number", String.valueOf(r6.getNationalNumber()));
                }
            };
        } catch (NumberParseException unused) {
            return null;
        }
    }

    private void validate(MethodCall methodCall, MethodChannel.Result result) {
        boolean z11;
        String str = (String) methodCall.argument("region");
        String str2 = (String) methodCall.argument(TypedValues.Custom.S_STRING);
        if (str2 == null) {
            result.error("InvalidParameters", "Invalid 'string' parameter.", (Object) null);
            return;
        }
        try {
            PhoneNumberUtil instance = PhoneNumberUtil.getInstance();
            Phonenumber.PhoneNumber parse = instance.parse(str2, str);
            if (str == null) {
                z11 = instance.isValidNumber(parse);
            } else {
                z11 = instance.isValidNumberForRegion(parse, str);
            }
            HashMap hashMap = new HashMap();
            hashMap.put("isValid", Boolean.valueOf(z11));
            result.success(hashMap);
        } catch (Exception unused) {
            result.error("InvalidNumber", "Number " + str2 + " is invalid", (Object) null);
        }
    }

    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.context = flutterPluginBinding.getApplicationContext();
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "com.julienvignali/phone_number");
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.channel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
    }

    public void onMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
        String str = methodCall.method;
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1421272810:
                if (str.equals("validate")) {
                    c11 = 0;
                    break;
                }
                break;
            case -1268779017:
                if (str.equals("format")) {
                    c11 = 1;
                    break;
                }
                break;
            case -980875606:
                if (str.equals("parse_list")) {
                    c11 = 2;
                    break;
                }
                break;
            case 106437299:
                if (str.equals("parse")) {
                    c11 = 3;
                    break;
                }
                break;
            case 238027153:
                if (str.equals("carrier_region_code")) {
                    c11 = 4;
                    break;
                }
                break;
            case 938692135:
                if (str.equals("get_all_supported_regions")) {
                    c11 = 5;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                validate(methodCall, result);
                return;
            case 1:
                format(methodCall, result);
                return;
            case 2:
                parseList(methodCall, result);
                return;
            case 3:
                parse(methodCall, result);
                return;
            case 4:
                carrierRegionCode(result);
                return;
            case 5:
                getAllSupportedRegions(methodCall, result);
                return;
            default:
                result.notImplemented();
                return;
        }
    }
}
