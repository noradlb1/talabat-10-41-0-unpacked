package com.braze.support;

import android.content.Context;
import android.content.SharedPreferences;
import com.braze.support.BrazeLogger;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0018\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001\u001a\"\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001\u001a\u001c\u0010\u0011\u001a\u00020\u00012\b\u0010\u0012\u001a\u0004\u0018\u00010\u00012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\u0010\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001\u001a\u0010\u0010\u0016\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001\u001a\u0010\u0010\u0017\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001\u001a\u0012\u0010\u0018\u001a\u00020\u0019*\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u0001\u001a\f\u0010\u001b\u001a\u0004\u0018\u00010\u0001*\u00020\u0001\u001a\n\u0010\u001c\u001a\u00020\u001d*\u00020\u0001\u001a\n\u0010\u001e\u001a\u00020\u0001*\u00020\u0001\u001a \u0010\u001f\u001a\u00020 *\u0004\u0018\u00010\u00012\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020 0\"\u001a\u0012\u0010#\u001a\u00020\u0001*\u00020\u00012\u0006\u0010$\u001a\u00020\u0019\"\u0016\u0010\u0000\u001a\u00020\u00018\u0006XT¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0004\u001a\u00020\u00018\u0006XT¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0003\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0016\u0010\u0007\u001a\u00020\u00018\u0006XT¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0003\"\u0016\u0010\t\u001a\u00020\u00018\u0006XT¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u0003\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"CACHE_SUFFIX_PREFERENCES_FILE", "", "getCACHE_SUFFIX_PREFERENCES_FILE$annotations", "()V", "MD5_HASH_OF_THE_STRING_NULL", "getMD5_HASH_OF_THE_STRING_NULL$annotations", "NULL_USER_ID_SUBSTITUTE_STRING", "SUFFIX_CACHE_USER_ID_HASH_VALUE", "getSUFFIX_CACHE_USER_ID_HASH_VALUE$annotations", "SUFFIX_CACHE_USER_ID_KEY", "getSUFFIX_CACHE_USER_ID_KEY$annotations", "TAG", "getCacheFileSuffix", "context", "Landroid/content/Context;", "userId", "apiKey", "getSuffixFromUserIdHashAndApiKey", "userIdHash", "isBlank", "", "reference", "isNullOrBlank", "isNullOrEmpty", "countOccurrences", "", "subString", "emptyToNull", "getByteSize", "", "getMd5Hash", "ifNonEmpty", "", "block", "Lkotlin/Function1;", "truncateToByteLength", "desiredByteLength", "android-sdk-base_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class StringUtils {
    public static final String CACHE_SUFFIX_PREFERENCES_FILE = "com.appboy.support.stringutils.cachefilesuffix";
    public static final String MD5_HASH_OF_THE_STRING_NULL = "37a6259cc0c1dae299a7866489dff0bd";
    private static final String NULL_USER_ID_SUBSTITUTE_STRING = "null";
    public static final String SUFFIX_CACHE_USER_ID_HASH_VALUE = "user_id_hash_value";
    public static final String SUFFIX_CACHE_USER_ID_KEY = "user_id_key";
    private static final String TAG = BrazeLogger.INSTANCE.getBrazeLogTag("StringUtils");

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class a extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final a f43969b = new a();

        public a() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "The saved user id hash was null or empty.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class b extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43970g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f43971h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(String str, String str2) {
            super(0);
            this.f43970g = str;
            this.f43971h = str2;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Generating MD5 for user id: " + this.f43970g + " apiKey: " + this.f43971h;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0057  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int countOccurrences(java.lang.String r8, java.lang.String r9) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "subString"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r0 = 1
            java.lang.String[] r2 = new java.lang.String[r0]
            r7 = 0
            r2[r7] = r9
            r3 = 0
            r4 = 0
            r5 = 6
            r6 = 0
            r1 = r8
            java.util.List r8 = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) r1, (java.lang.String[]) r2, (boolean) r3, (int) r4, (int) r5, (java.lang.Object) r6)
            boolean r9 = r8.isEmpty()
            if (r9 != 0) goto L_0x0048
            int r9 = r8.size()
            java.util.ListIterator r9 = r8.listIterator(r9)
        L_0x0027:
            boolean r1 = r9.hasPrevious()
            if (r1 == 0) goto L_0x0048
            java.lang.Object r1 = r9.previous()
            java.lang.String r1 = (java.lang.String) r1
            int r1 = r1.length()
            if (r1 != 0) goto L_0x003b
            r1 = r0
            goto L_0x003c
        L_0x003b:
            r1 = r7
        L_0x003c:
            if (r1 != 0) goto L_0x0027
            int r9 = r9.nextIndex()
            int r9 = r9 + r0
            java.util.List r8 = kotlin.collections.CollectionsKt___CollectionsKt.take(r8, r9)
            goto L_0x004c
        L_0x0048:
            java.util.List r8 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
        L_0x004c:
            java.lang.String[] r9 = new java.lang.String[r7]
            java.lang.Object[] r8 = r8.toArray(r9)
            if (r8 == 0) goto L_0x0057
            int r8 = r8.length
            int r8 = r8 - r0
            return r8
        L_0x0057:
            java.lang.NullPointerException r8 = new java.lang.NullPointerException
            java.lang.String r9 = "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>"
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.braze.support.StringUtils.countOccurrences(java.lang.String, java.lang.String):int");
    }

    public static final String emptyToNull(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (StringsKt__StringsJVMKt.isBlank(str)) {
            return null;
        }
        return str;
    }

    public static final long getByteSize(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        return (long) bytes.length;
    }

    public static /* synthetic */ void getCACHE_SUFFIX_PREFERENCES_FILE$annotations() {
    }

    public static final String getCacheFileSuffix(Context context, String str, String str2) {
        Context context2 = context;
        String str3 = str2;
        Intrinsics.checkNotNullParameter(context2, "context");
        String str4 = str == null ? "null" : str;
        if (Intrinsics.areEqual((Object) str4, (Object) "null")) {
            return getSuffixFromUserIdHashAndApiKey(MD5_HASH_OF_THE_STRING_NULL, str3);
        }
        boolean z11 = false;
        SharedPreferences sharedPreferences = context2.getSharedPreferences(CACHE_SUFFIX_PREFERENCES_FILE, 0);
        String string = sharedPreferences.getString(SUFFIX_CACHE_USER_ID_KEY, (String) null);
        if (string != null && Intrinsics.areEqual((Object) string, (Object) str4)) {
            String string2 = sharedPreferences.getString(SUFFIX_CACHE_USER_ID_HASH_VALUE, (String) null);
            if (string2 == null || string2.length() == 0) {
                z11 = true;
            }
            if (!z11) {
                return getSuffixFromUserIdHashAndApiKey(string2, str3);
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) a.f43969b, 14, (Object) null);
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new b(str4, str3), 12, (Object) null);
        String md5Hash = getMd5Hash(str4);
        sharedPreferences.edit().putString(SUFFIX_CACHE_USER_ID_KEY, str4).putString(SUFFIX_CACHE_USER_ID_HASH_VALUE, md5Hash).apply();
        return getSuffixFromUserIdHashAndApiKey(md5Hash, str3);
    }

    public static /* synthetic */ void getMD5_HASH_OF_THE_STRING_NULL$annotations() {
    }

    public static final String getMd5Hash(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        MessageDigest instance = MessageDigest.getInstance("MD5");
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        BigInteger bigInteger = new BigInteger(1, instance.digest(bytes));
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(Locale.US, "%032x", Arrays.copyOf(new Object[]{bigInteger}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(locale, format, *args)");
        return format;
    }

    public static /* synthetic */ void getSUFFIX_CACHE_USER_ID_HASH_VALUE$annotations() {
    }

    public static /* synthetic */ void getSUFFIX_CACHE_USER_ID_KEY$annotations() {
    }

    private static final String getSuffixFromUserIdHashAndApiKey(String str, String str2) {
        boolean z11;
        if (str2 == null || StringsKt__StringsJVMKt.isBlank(str2)) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return Intrinsics.stringPlus(RealDiscoveryConfigurationRepository.VERSION_DELIMETER, str);
        }
        return '.' + str + '.' + str2;
    }

    public static final void ifNonEmpty(String str, Function1<? super String, Unit> function1) {
        boolean z11;
        Intrinsics.checkNotNullParameter(function1, "block");
        if (str == null || str.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            function1.invoke(str);
        }
    }

    public static final boolean isBlank(String str) {
        if (str == null) {
            return false;
        }
        return StringsKt__StringsJVMKt.isBlank(str);
    }

    public static final boolean isNullOrBlank(String str) {
        return str == null || StringsKt__StringsJVMKt.isBlank(str);
    }

    public static final boolean isNullOrEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static final String truncateToByteLength(String str, int i11) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (getByteSize(str) <= ((long) i11)) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        char[] charArray = str.toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "this as java.lang.String).toCharArray()");
        int length = charArray.length;
        int i12 = 0;
        int i13 = 0;
        while (i12 < length) {
            char c11 = charArray[i12];
            i12++;
            i13 += (int) getByteSize(String.valueOf(c11));
            if (i13 > i11) {
                break;
            }
            sb2.append(c11);
        }
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "truncatedStringBuilder.toString()");
        return sb3;
    }

    public static final String getCacheFileSuffix(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        return getCacheFileSuffix(context, str, (String) null);
    }
}
