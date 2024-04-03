package bo.app;

import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import com.visa.checkout.Profile;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u001a!\u0010\u0004\u001a\u00020\u00032\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0000\"\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0006*\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0007\u001a0\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\bj\u0002`\n*\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\t0\b¨\u0006\u000b"}, d2 = {"", "", "requestArgs", "", "a", "([Ljava/lang/Object;)Ljava/lang/String;", "", "(Ljava/lang/String;)Ljava/lang/Long;", "", "", "Lcom/braze/communication/HttpHeaders;", "android-sdk-base_release"}, k = 2, mv = {1, 6, 0})
public final class v1 {

    /* renamed from: a  reason: collision with root package name */
    private static final String f39497a = BrazeLogger.INSTANCE.getBrazeLogTag("HttpUtils");

    /* renamed from: b  reason: collision with root package name */
    private static final SimpleDateFormat f39498b = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class a extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f39499b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(String str) {
            super(0);
            this.f39499b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Could not parse http-date value: ", this.f39499b);
        }
    }

    public static final Long a(String str) {
        Long valueOf;
        if (str == null) {
            return null;
        }
        try {
            Double doubleOrNull = StringsKt__StringNumberConversionsJVMKt.toDoubleOrNull(str);
            if (doubleOrNull != null) {
                valueOf = Long.valueOf((long) (doubleOrNull.doubleValue() * ((double) 1000)));
            } else {
                Date parse = f39498b.parse(str);
                if (parse == null) {
                    return null;
                }
                valueOf = Long.valueOf(parse.getTime() - DateTimeUtils.nowInMilliseconds());
            }
            return valueOf;
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, f39497a, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) new a(str), 8, (Object) null);
            return null;
        }
    }

    public static final String a(Object... objArr) {
        Intrinsics.checkNotNullParameter(objArr, "requestArgs");
        int length = objArr.length;
        long j11 = 1;
        int i11 = 0;
        while (i11 < length) {
            Object obj = objArr[i11];
            i11++;
            j11 *= (long) obj.hashCode();
        }
        String hexString = Long.toHexString(j11);
        Intrinsics.checkNotNullExpressionValue(hexString, "toHexString(\n    request…lement.hashCode()\n    }\n)");
        return hexString;
    }

    public static final Map<String, String> a(Map<String, ? extends List<String>> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry next : map.entrySet()) {
            if (((String) next.getKey()) != null) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt__MapsJVMKt.mapCapacity(linkedHashMap.size()));
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            Object key = entry.getKey();
            Intrinsics.checkNotNull(key);
            Locale locale = Locale.US;
            Intrinsics.checkNotNullExpressionValue(locale, Profile.Country.US);
            String lowerCase = ((String) key).toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            linkedHashMap2.put(lowerCase, entry.getValue());
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(MapsKt__MapsJVMKt.mapCapacity(linkedHashMap2.size()));
        for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
            linkedHashMap3.put(entry2.getKey(), CollectionsKt___CollectionsKt.joinToString$default((Iterable) entry2.getValue(), (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null));
        }
        return linkedHashMap3;
    }
}
