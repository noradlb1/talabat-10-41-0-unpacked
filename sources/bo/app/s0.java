package bo.app;

import com.braze.support.BrazeLogger;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u000e"}, d2 = {"Lbo/app/s0;", "Lbo/app/p2;", "Lbo/app/o2;", "request", "", "c", "b", "a", "Lbo/app/j2;", "internalEventPublisher", "", "shouldStoreMockedHistory", "<init>", "(Lbo/app/j2;Z)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class s0 implements p2 {

    /* renamed from: a  reason: collision with root package name */
    private final j2 f39340a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f39341b;

    /* renamed from: c  reason: collision with root package name */
    private final List<c2> f39342c = new ArrayList();

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class a extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final a f39343b = new a();

        public a() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Short circuiting execution of network request and immediately marking it as succeeded.";
        }
    }

    public s0(j2 j2Var, boolean z11) {
        Intrinsics.checkNotNullParameter(j2Var, "internalEventPublisher");
        this.f39340a = j2Var;
        this.f39341b = z11;
    }

    private final void c(o2 o2Var) {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) a.f39343b, 3, (Object) null);
        j2 j2Var = this.f39340a;
        o2Var.a(j2Var, j2Var, (d) null);
        o2Var.b(this.f39340a);
        if (o2Var instanceof c2) {
            this.f39340a.a(new r0((c2) o2Var), r0.class);
        }
    }

    public void a(o2 o2Var) {
        Intrinsics.checkNotNullParameter(o2Var, "request");
        c(o2Var);
    }

    public void b(o2 o2Var) {
        Intrinsics.checkNotNullParameter(o2Var, "request");
        c(o2Var);
    }
}
