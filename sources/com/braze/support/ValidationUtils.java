package com.braze.support;

import bo.app.e5;
import com.braze.support.BrazeLogger;
import com.visa.checkout.Profile;
import com.visa.checkout.PurchaseInfo;
import java.math.BigDecimal;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.text.Regex;

@Metadata(bv = {}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b*\u0010'J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0007J\u0012\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0007J6\u0010\u0012\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0007J\u001a\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0007J\u001c\u0010\u0017\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0007J\u0018\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018H\u0007R\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\u001c8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0014\u0010\"\u001a\u00020!8\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u000e8\u0006XT¢\u0006\f\n\u0004\b$\u0010%\u0012\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020!8\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010#R\u0014\u0010)\u001a\u00020\u000e8\u0006XT¢\u0006\u0006\n\u0004\b)\u0010%¨\u0006+"}, d2 = {"Lcom/braze/support/ValidationUtils;", "", "", "emailAddress", "", "isValidEmailAddress", "phoneNumber", "isValidPhoneNumber", "field", "ensureBrazeFieldLength", "productId", "currencyCode", "Ljava/math/BigDecimal;", "price", "", "quantity", "Lbo/app/e5;", "serverConfigStorageProvider", "isValidLogPurchaseInput", "eventName", "isValidLogCustomEventInput", "campaignId", "pageId", "isValidPushStoryClickInput", "", "latitude", "longitude", "isValidLocation", "", "VALID_CURRENCY_CODES", "Ljava/util/Set;", "getVALID_CURRENCY_CODES", "()Ljava/util/Set;", "Lkotlin/text/Regex;", "EMAIL_ADDRESS_REGEX", "Lkotlin/text/Regex;", "EMAIL_ADDRESS_MAX_LENGTH", "I", "getEMAIL_ADDRESS_MAX_LENGTH$annotations", "()V", "PHONE_NUMBER_REGEX", "BRAZE_STRING_MAX_LENGTH", "<init>", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class ValidationUtils {
    public static final int BRAZE_STRING_MAX_LENGTH = 255;
    public static final int EMAIL_ADDRESS_MAX_LENGTH = 255;
    private static final Regex EMAIL_ADDRESS_REGEX = new Regex(".+@.+\\..+");
    public static final ValidationUtils INSTANCE = new ValidationUtils();
    private static final Regex PHONE_NUMBER_REGEX = new Regex("^[0-9 .\\(\\)\\+\\-]+$");
    private static final Set<String> VALID_CURRENCY_CODES = SetsKt__SetsKt.setOf(PurchaseInfo.Currency.AED, "AFN", "ALL", "AMD", "ANG", "AOA", PurchaseInfo.Currency.ARS, PurchaseInfo.Currency.AUD, "AWG", "AZN", "BAM", "BBD", "BDT", "BGN", "BHD", "BIF", "BMD", "BND", "BOB", PurchaseInfo.Currency.BRL, "BSD", "BTC", "BTN", "BWP", "BYR", "BZD", PurchaseInfo.Currency.CAD, "CDF", "CHF", "CLF", PurchaseInfo.Currency.CLP, PurchaseInfo.Currency.CNY, PurchaseInfo.Currency.COP, "CRC", "CUC", "CUP", "CVE", "CZK", "DJF", "DKK", "DOP", "DZD", "EEK", "EGP", "ERN", "ETB", PurchaseInfo.Currency.EUR, "FJD", "FKP", PurchaseInfo.Currency.GBP, "GEL", "GGP", "GHS", "GIP", "GMD", "GNF", "GTQ", "GYD", PurchaseInfo.Currency.HKD, "HNL", "HRK", "HTG", "HUF", "IDR", "ILS", "IMP", PurchaseInfo.Currency.INR, "IQD", "IRR", "ISK", "JEP", "JMD", "JOD", "JPY", "KES", "KGS", "KHR", "KMF", "KPW", "KRW", PurchaseInfo.Currency.KWD, "KYD", "KZT", "LAK", "LBP", "LKR", "LRD", "LSL", "LTL", "LVL", "LYD", "MAD", "MDL", "MGA", "MKD", "MMK", "MNT", "MOP", "MRO", "MTL", "MUR", "MVR", "MWK", PurchaseInfo.Currency.MXN, PurchaseInfo.Currency.MYR, "MZN", "NAD", "NGN", "NIO", "NOK", "NPR", PurchaseInfo.Currency.NZD, "OMR", "PAB", PurchaseInfo.Currency.PEN, "PGK", "PHP", "PKR", PurchaseInfo.Currency.PLN, "PYG", PurchaseInfo.Currency.QAR, "RON", "RSD", "RUB", "RWF", PurchaseInfo.Currency.SAR, "SBD", "SCR", "SDG", "SEK", PurchaseInfo.Currency.SGD, "SHP", "SLL", "SOS", "SRD", "STD", "SVC", "SYP", "SZL", "THB", "TJS", "TMT", "TND", "TOP", "TRY", "TTD", "TWD", "TZS", PurchaseInfo.Currency.UAH, "UGX", PurchaseInfo.Currency.USD, "UYU", "UZS", "VEF", "VND", "VUV", "WST", "XAF", "XAG", "XAU", "XCD", "XDR", "XOF", "XPD", "XPF", "XPT", "YER", PurchaseInfo.Currency.ZAR, "ZMK", "ZMW", "ZWL");

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class a extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef<String> f43972g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Ref.ObjectRef<String> objectRef) {
            super(0);
            this.f43972g = objectRef;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Provided string field is too long [" + ((String) this.f43972g.element).length() + "]. The max length is 255, truncating provided field.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class b extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final b f43973b = new b();

        public b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "The custom event name cannot be null or contain only whitespaces. Invalid custom event.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43974g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(String str) {
            super(0);
            this.f43974g = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "The custom event is a blocklisted custom event: " + this.f43974g + ". Invalid custom event.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class d extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final d f43975b = new d();

        public d() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "The productId is empty, not logging in-app purchase to Braze.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class e extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43976g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(String str) {
            super(0);
            this.f43976g = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("The productId is a blocklisted productId: ", this.f43976g);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class f extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final f f43977b = new f();

        public f() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("The currencyCode is empty. Expected one of ", ValidationUtils.INSTANCE.getVALID_CURRENCY_CODES());
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class g extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43978g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(String str) {
            super(0);
            this.f43978g = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "The currencyCode " + this.f43978g + " is invalid. Expected one of " + ValidationUtils.INSTANCE.getVALID_CURRENCY_CODES();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class h extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final h f43979b = new h();

        public h() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "The price is null.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class i extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f43980g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(int i11) {
            super(0);
            this.f43980g = i11;
        }

        /* renamed from: a */
        public final String invoke() {
            return "The requested purchase quantity of " + this.f43980g + " is less than one. Invalid purchase";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class j extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f43981g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(int i11) {
            super(0);
            this.f43981g = i11;
        }

        /* renamed from: a */
        public final String invoke() {
            return "The requested purchase quantity of " + this.f43981g + " is greater than the maximum of 100";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class k extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final k f43982b = new k();

        public k() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Campaign ID cannot be null or blank";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class l extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final l f43983b = new l();

        public l() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Push story page ID cannot be null or blank";
        }
    }

    private ValidationUtils() {
    }

    @JvmStatic
    public static final String ensureBrazeFieldLength(String str) {
        boolean z11;
        if (str == null || StringsKt__StringsJVMKt.isBlank(str)) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return "";
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        T obj = StringsKt__StringsKt.trim((CharSequence) str).toString();
        objectRef.element = obj;
        int length = obj.length();
        ValidationUtils validationUtils = INSTANCE;
        if (length > 255) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) validationUtils, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new a(objectRef), 6, (Object) null);
            T substring = ((String) objectRef.element).substring(0, 255);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            objectRef.element = substring;
        }
        return (String) objectRef.element;
    }

    public static /* synthetic */ void getEMAIL_ADDRESS_MAX_LENGTH$annotations() {
    }

    @JvmStatic
    public static final boolean isValidEmailAddress(String str) {
        boolean z11;
        if (str == null || str.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11 && str.length() <= 255) {
            return EMAIL_ADDRESS_REGEX.matches(str);
        }
        return false;
    }

    @JvmStatic
    public static final boolean isValidLocation(double d11, double d12) {
        return d11 < 90.0d && d11 > -90.0d && d12 < 180.0d && d12 > -180.0d;
    }

    @JvmStatic
    public static final boolean isValidLogCustomEventInput(String str, e5 e5Var) {
        boolean z11;
        Intrinsics.checkNotNullParameter(e5Var, "serverConfigStorageProvider");
        if (str == null || StringsKt__StringsJVMKt.isBlank(str)) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) b.f43973b, 6, (Object) null);
        } else if (!e5Var.c().contains(str)) {
            return true;
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new c(str), 6, (Object) null);
        }
        return false;
    }

    @JvmStatic
    public static final boolean isValidLogPurchaseInput(String str, String str2, BigDecimal bigDecimal, int i11, e5 e5Var) {
        boolean z11;
        boolean z12;
        String str3 = str;
        String str4 = str2;
        int i12 = i11;
        Intrinsics.checkNotNullParameter(e5Var, "serverConfigStorageProvider");
        if (str3 == null || StringsKt__StringsJVMKt.isBlank(str)) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) d.f43975b, 6, (Object) null);
        } else if (e5Var.d().contains(str3)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new e(str3), 6, (Object) null);
        } else {
            if (str4 == null || StringsKt__StringsJVMKt.isBlank(str2)) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z12) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) f.f43977b, 6, (Object) null);
            } else {
                ValidationUtils validationUtils = INSTANCE;
                Set<String> set = VALID_CURRENCY_CODES;
                String obj = StringsKt__StringsKt.trim((CharSequence) str2).toString();
                Locale locale = Locale.US;
                Intrinsics.checkNotNullExpressionValue(locale, Profile.Country.US);
                String upperCase = obj.toUpperCase(locale);
                Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
                if (!set.contains(upperCase)) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) validationUtils, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new g(str4), 6, (Object) null);
                } else if (bigDecimal == null) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) validationUtils, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) h.f43979b, 6, (Object) null);
                } else if (i12 <= 0) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) validationUtils, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new i(i12), 6, (Object) null);
                } else if (i12 <= 100) {
                    return true;
                } else {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) validationUtils, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new j(i12), 6, (Object) null);
                }
            }
        }
        return false;
    }

    @JvmStatic
    public static final boolean isValidPhoneNumber(String str) {
        return str != null && PHONE_NUMBER_REGEX.matches(str);
    }

    @JvmStatic
    public static final boolean isValidPushStoryClickInput(String str, String str2) {
        boolean z11;
        boolean z12;
        if (str == null || StringsKt__StringsJVMKt.isBlank(str)) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) k.f43982b, 6, (Object) null);
        } else {
            if (str2 == null || StringsKt__StringsJVMKt.isBlank(str2)) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (!z12) {
                return true;
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) l.f43983b, 6, (Object) null);
        }
        return false;
    }

    public final Set<String> getVALID_CURRENCY_CODES() {
        return VALID_CURRENCY_CODES;
    }
}
