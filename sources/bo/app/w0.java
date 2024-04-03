package bo.app;

import com.braze.support.BrazeLogger;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u0001\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0016\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nR\u0016\u0010\r\u001a\u0004\u0018\u00010\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\f¨\u0006\u0011"}, d2 = {"Lbo/app/w0;", "Lbo/app/t2;", "Lbo/app/h5;", "session", "", "a", "", "sessionId", "Lbo/app/j2;", "eventPublisher", "", "throwable", "()Lbo/app/h5;", "storedOpenSession", "sessionStorageManager", "<init>", "(Lbo/app/t2;Lbo/app/j2;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class w0 implements t2 {

    /* renamed from: a  reason: collision with root package name */
    private final t2 f39513a;

    /* renamed from: b  reason: collision with root package name */
    private final j2 f39514b;

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class a extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final a f39515b = new a();

        public a() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to delete the sealed session from the storage.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class b extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final b f39516b = new b();

        public b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Error occured while publishing exception.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final c f39517b = new c();

        public c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to get the active session from the storage.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class d extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final d f39518b = new d();

        public d() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to upsert active session in the storage.";
        }
    }

    public w0(t2 t2Var, j2 j2Var) {
        Intrinsics.checkNotNullParameter(t2Var, "sessionStorageManager");
        Intrinsics.checkNotNullParameter(j2Var, "eventPublisher");
        this.f39513a = t2Var;
        this.f39514b = j2Var;
    }

    public h5 a() {
        try {
            return this.f39513a.a();
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) c.f39517b, 4, (Object) null);
            a(this.f39514b, e11);
            return null;
        }
    }

    public void a(h5 h5Var) {
        Intrinsics.checkNotNullParameter(h5Var, SDKCoreEvent.Session.TYPE_SESSION);
        try {
            this.f39513a.a(h5Var);
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) d.f39518b, 4, (Object) null);
            a(this.f39514b, e11);
        }
    }

    public void a(String str) {
        Intrinsics.checkNotNullParameter(str, "sessionId");
        try {
            this.f39513a.a(str);
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) a.f39515b, 4, (Object) null);
            a(this.f39514b, e11);
        }
    }

    public final void a(j2 j2Var, Throwable th2) {
        Intrinsics.checkNotNullParameter(j2Var, "eventPublisher");
        Intrinsics.checkNotNullParameter(th2, "throwable");
        try {
            j2Var.a(new r5("A storage exception has occurred. Please view the stack trace for more details.", th2), r5.class);
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) b.f39516b, 4, (Object) null);
        }
    }
}
