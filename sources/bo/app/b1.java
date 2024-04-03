package bo.app;

import com.braze.support.BrazeLogger;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006J\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b¨\u0006\u000e"}, d2 = {"Lbo/app/b1;", "", "Lbo/app/x1;", "event", "", "a", "", "events", "Lbo/app/h2;", "dispatchManager", "Lbo/app/y1;", "brazeEventStorageProvider", "<init>", "(Lbo/app/y1;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class b1 {

    /* renamed from: a  reason: collision with root package name */
    private final y1 f38302a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f38303b;

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class a extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x1 f38304b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(x1 x1Var) {
            super(0);
            this.f38304b = x1Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Storage manager is closed. Not adding event: ", this.f38304b);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class b extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Set<x1> f38305b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Set<? extends x1> set) {
            super(0);
            this.f38305b = set;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Storage manager is closed. Not deleting events: ", this.f38305b);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final c f38306b = new c();

        public c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Storage manager is closed. Not starting offline recovery.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class d extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final d f38307b = new d();

        public d() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Started offline event recovery task.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class e extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x1 f38308b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(x1 x1Var) {
            super(0);
            this.f38308b = x1Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Adding event to dispatch from storage: ", this.f38308b);
        }
    }

    public b1(y1 y1Var) {
        Intrinsics.checkNotNullParameter(y1Var, "brazeEventStorageProvider");
        this.f38302a = y1Var;
    }

    public final void a(x1 x1Var) {
        Intrinsics.checkNotNullParameter(x1Var, "event");
        if (this.f38303b) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new a(x1Var), 6, (Object) null);
            return;
        }
        this.f38302a.a(x1Var);
    }

    public final void a(Set<? extends x1> set) {
        Intrinsics.checkNotNullParameter(set, "events");
        if (this.f38303b) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new b(set), 6, (Object) null);
            return;
        }
        this.f38302a.a(set);
    }

    public final void a() {
        this.f38303b = true;
        this.f38302a.close();
    }

    public final void a(h2 h2Var) {
        Intrinsics.checkNotNullParameter(h2Var, "dispatchManager");
        if (this.f38303b) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) c.f38306b, 6, (Object) null);
            return;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) d.f38307b, 7, (Object) null);
        for (x1 x1Var : CollectionsKt___CollectionsKt.filterNotNull(this.f38302a.a())) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new e(x1Var), 6, (Object) null);
            h2Var.a(x1Var);
        }
    }
}
