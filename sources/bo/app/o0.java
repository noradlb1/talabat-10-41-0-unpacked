package bo.app;

import com.braze.support.BrazeLogger;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001:\u0002\u0005\u0007B5\b\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010\r\u001a\u00020\fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¨\u0006\u0017"}, d2 = {"Lbo/app/o0;", "", "", "toString", "Lbo/app/o0$b;", "a", "Lbo/app/x1;", "b", "Lbo/app/j5;", "c", "Lbo/app/c2;", "d", "", "hashCode", "other", "", "equals", "commandType", "brazeEvent", "sessionId", "brazeRequest", "<init>", "(Lbo/app/o0$b;Lbo/app/x1;Lbo/app/j5;Lbo/app/c2;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class o0 {

    /* renamed from: e  reason: collision with root package name */
    public static final a f39083e = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final b f39084a;

    /* renamed from: b  reason: collision with root package name */
    public final x1 f39085b;

    /* renamed from: c  reason: collision with root package name */
    public final j5 f39086c;

    /* renamed from: d  reason: collision with root package name */
    public final c2 f39087d;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lbo/app/o0$b;", "", "<init>", "(Ljava/lang/String;I)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
    public enum b {
        ADD_PENDING_BRAZE_EVENT,
        ADD_BRAZE_EVENT,
        FLUSH_PENDING_BRAZE_EVENTS,
        ADD_REQUEST
    }

    private o0(b bVar, x1 x1Var, j5 j5Var, c2 c2Var) {
        this.f39084a = bVar;
        this.f39085b = x1Var;
        this.f39086c = j5Var;
        this.f39087d = c2Var;
    }

    public final b a() {
        return this.f39084a;
    }

    public final x1 b() {
        return this.f39085b;
    }

    public final j5 c() {
        return this.f39086c;
    }

    public final c2 d() {
        return this.f39087d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o0)) {
            return false;
        }
        o0 o0Var = (o0) obj;
        return this.f39084a == o0Var.f39084a && Intrinsics.areEqual((Object) this.f39085b, (Object) o0Var.f39085b) && Intrinsics.areEqual((Object) this.f39086c, (Object) o0Var.f39086c) && Intrinsics.areEqual((Object) this.f39087d, (Object) o0Var.f39087d);
    }

    public int hashCode() {
        int hashCode = this.f39084a.hashCode() * 31;
        x1 x1Var = this.f39085b;
        int i11 = 0;
        int hashCode2 = (hashCode + (x1Var == null ? 0 : x1Var.hashCode())) * 31;
        j5 j5Var = this.f39086c;
        int hashCode3 = (hashCode2 + (j5Var == null ? 0 : j5Var.hashCode())) * 31;
        c2 c2Var = this.f39087d;
        if (c2Var != null) {
            i11 = c2Var.hashCode();
        }
        return hashCode3 + i11;
    }

    public String toString() {
        return StringsKt__IndentKt.trimIndent("\n            commandType = " + this.f39084a + "\n            brazeEvent = " + this.f39085b + "\n            sessionId = " + this.f39086c + "\n            brazeRequest = " + this.f39087d + "\n        ");
    }

    @Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0007¨\u0006\r"}, d2 = {"Lbo/app/o0$a;", "", "Lbo/app/x1;", "event", "Lbo/app/o0;", "a", "b", "Lbo/app/j5;", "sessionId", "Lbo/app/c2;", "request", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
    public static final class a {

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        /* renamed from: bo.app.o0$a$a  reason: collision with other inner class name */
        public static final class C0030a extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final C0030a f39088b = new C0030a();

            public C0030a() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "There should be a session ID here";
            }
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final o0 a(x1 x1Var) {
            Intrinsics.checkNotNullParameter(x1Var, "event");
            return new o0(b.ADD_BRAZE_EVENT, x1Var, (j5) null, (c2) null, 12, (DefaultConstructorMarker) null);
        }

        @JvmStatic
        public final o0 b(x1 x1Var) {
            Intrinsics.checkNotNullParameter(x1Var, "event");
            return new o0(b.ADD_PENDING_BRAZE_EVENT, x1Var, (j5) null, (c2) null, 12, (DefaultConstructorMarker) null);
        }

        @JvmStatic
        public final o0 a(j5 j5Var) {
            if (j5Var == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) C0030a.f39088b, 7, (Object) null);
            }
            return new o0(b.FLUSH_PENDING_BRAZE_EVENTS, (x1) null, j5Var, (c2) null, 10, (DefaultConstructorMarker) null);
        }

        @JvmStatic
        public final o0 a(c2 c2Var) {
            Intrinsics.checkNotNullParameter(c2Var, "request");
            return new o0(b.ADD_REQUEST, (x1) null, (j5) null, c2Var, 6, (DefaultConstructorMarker) null);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ o0(b bVar, x1 x1Var, j5 j5Var, c2 c2Var, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(bVar, (i11 & 2) != 0 ? null : x1Var, (i11 & 4) != 0 ? null : j5Var, (i11 & 8) != 0 ? null : c2Var);
    }
}
