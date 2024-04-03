package bo.app;

import com.braze.support.BrazeLogger;
import com.braze.support.ValidationUtils;
import java.util.ArrayList;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\"\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0007J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0007J'\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\tH\u0007¢\u0006\u0004\b\u0007\u0010\u000b¨\u0006\u000e"}, d2 = {"Lbo/app/c0;", "", "", "key", "", "blocklistedAttributes", "", "a", "value", "", "values", "([Ljava/lang/String;)[Ljava/lang/String;", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class c0 {

    /* renamed from: a  reason: collision with root package name */
    public static final c0 f38325a = new c0();

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class a extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final a f38326b = new a();

        public a() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Custom attribute key cannot be null.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class b extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f38327b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(String str) {
            super(0);
            this.f38327b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Custom attribute key cannot be blocklisted attribute: " + this.f38327b + '.';
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final c f38328b = new c();

        public c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Custom attribute value cannot be null.";
        }
    }

    private c0() {
    }

    @JvmStatic
    public static final boolean a(String str, Set<String> set) {
        Intrinsics.checkNotNullParameter(set, "blocklistedAttributes");
        if (str == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) f38325a, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) a.f38326b, 6, (Object) null);
            return false;
        } else if (!set.contains(str)) {
            return true;
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) f38325a, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new b(str), 6, (Object) null);
            return false;
        }
    }

    @JvmStatic
    public static final boolean a(String str) {
        if (str != null) {
            return true;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) f38325a, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) c.f38328b, 6, (Object) null);
        return false;
    }

    @JvmStatic
    public static final String[] a(String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "values");
        ArrayList arrayList = new ArrayList(strArr.length);
        int length = strArr.length;
        int i11 = 0;
        while (i11 < length) {
            String str = strArr[i11];
            i11++;
            arrayList.add(ValidationUtils.ensureBrazeFieldLength(str));
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }
}
