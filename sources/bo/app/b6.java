package bo.app;

import com.braze.enums.BrazeDateFormat;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007¢\u0006\u0004\b \u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\u0003\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u000e\u0010\u0003\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\nJ\b\u0010\f\u001a\u00020\tH\u0007R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\r8G¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R(\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u0018\n\u0004\b\u0013\u0010\u0014\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0003\u0010\u0017R*\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00028\u0006@FX\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u0003\u0010\u001f¨\u0006!"}, d2 = {"Lbo/app/b6;", "", "", "a", "", "tag", "msg", "", "tr", "", "Lbo/app/c5;", "serverConfig", "b", "", "deviceLogBuffer", "Ljava/util/List;", "d", "()Ljava/util/List;", "Lbo/app/b2;", "brazeManager", "Lbo/app/b2;", "c", "()Lbo/app/b2;", "(Lbo/app/b2;)V", "getBrazeManager$annotations", "()V", "enabled", "isTestUserLoggingEnabled", "Z", "e", "()Z", "(Z)V", "<init>", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public class b6 {

    /* renamed from: f  reason: collision with root package name */
    public static final a f38318f = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final List<String> f38319a = new ArrayList(32);

    /* renamed from: b  reason: collision with root package name */
    private long f38320b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f38321c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public b2 f38322d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f38323e;

    @Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\fJ\"\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007R\u001a\u0010\t\u001a\u00020\b8\u0006XT¢\u0006\f\n\u0004\b\t\u0010\n\u0012\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\b8\u0006XT¢\u0006\f\n\u0004\b\r\u0010\n\u0012\u0004\b\u000e\u0010\f¨\u0006\u0010"}, d2 = {"Lbo/app/b6$a;", "", "", "tag", "msg", "", "tr", "a", "", "BUFFER_MAX_LINES", "I", "getBUFFER_MAX_LINES$annotations", "()V", "MAX_LINE_LENGTH", "getMAX_LINE_LENGTH$annotations", "<init>", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(String str, String str2, Throwable th2) {
            Intrinsics.checkNotNullParameter(str, "tag");
            Intrinsics.checkNotNullParameter(str2, "msg");
            String str3 = DateTimeUtils.formatDateNow(BrazeDateFormat.ANDROID_LOGCAT) + ' ' + str + ": " + str2;
            if (th2 != null) {
                str3 = str3 + ": " + th2.getMessage();
            }
            String substring = str3.substring(0, Math.min(str3.length(), 1000));
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return substring;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class b extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final b f38324b = new b();

        public b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Test user device logging is enabled.";
        }
    }

    public final void a(b2 b2Var) {
        Intrinsics.checkNotNullParameter(b2Var, "<set-?>");
        this.f38322d = b2Var;
    }

    public final void b() {
        synchronized (this.f38321c) {
            if (this.f38322d != null) {
                c().a((List<String>) CollectionsKt___CollectionsKt.toMutableList(d()), this.f38320b);
            }
            d().clear();
            this.f38320b = 0;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final b2 c() {
        b2 b2Var = this.f38322d;
        if (b2Var != null) {
            return b2Var;
        }
        Intrinsics.throwUninitializedPropertyAccessException("brazeManager");
        return null;
    }

    public final List<String> d() {
        return this.f38319a;
    }

    public final boolean e() {
        return this.f38323e;
    }

    public final void a(boolean z11) {
        synchronized (this.f38321c) {
            if (!z11) {
                d().clear();
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) b.f38324b, 2, (Object) null);
            }
            Unit unit = Unit.INSTANCE;
        }
        this.f38323e = z11;
    }

    public void a(String str, String str2, Throwable th2) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, "msg");
        if (this.f38323e && !StringsKt__StringsKt.contains$default((CharSequence) str2, (CharSequence) "device_logs", false, 2, (Object) null) && !StringsKt__StringsKt.contains$default((CharSequence) str2, (CharSequence) "test_user_data", false, 2, (Object) null) && !a()) {
            synchronized (this.f38321c) {
                if (d().size() >= 32) {
                    b();
                }
                if ((!StringsKt__StringsJVMKt.isBlank(str)) && (!StringsKt__StringsJVMKt.isBlank(str2))) {
                    if (this.f38320b == 0) {
                        this.f38320b = DateTimeUtils.nowInSeconds();
                    }
                    d().add(f38318f.a(str, str2, th2));
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final void a(c5 c5Var) {
        Intrinsics.checkNotNullParameter(c5Var, "serverConfig");
        a(c5Var.n());
    }

    private final boolean a() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        Intrinsics.checkNotNullExpressionValue(stackTrace, "stack");
        if (stackTrace.length == 0) {
            return true;
        }
        StackTraceElement stackTraceElement = stackTrace[1];
        String methodName = stackTraceElement.getMethodName();
        String className = stackTraceElement.getClassName();
        int length = stackTrace.length;
        int i11 = 0;
        int i12 = 0;
        while (i11 < length) {
            StackTraceElement stackTraceElement2 = stackTrace[i11];
            i11++;
            if (Intrinsics.areEqual((Object) stackTraceElement2.getClassName(), (Object) className) && Intrinsics.areEqual((Object) stackTraceElement2.getMethodName(), (Object) methodName)) {
                i12++;
            }
        }
        if (i12 != 1) {
            return true;
        }
        return false;
    }
}
