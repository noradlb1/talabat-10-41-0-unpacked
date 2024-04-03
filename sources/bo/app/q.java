package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0006B\u001f\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\u0011\u0010\b\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lbo/app/q;", "", "", "b", "c", "", "a", "()Z", "isNewMessagingSessionCriteriaMet", "Landroid/content/Context;", "applicationContext", "Lbo/app/j2;", "eventPublisher", "Lbo/app/e5;", "serverConfigStorageProvider", "<init>", "(Landroid/content/Context;Lbo/app/j2;Lbo/app/e5;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class q {

    /* renamed from: e  reason: collision with root package name */
    public static final a f39190e = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final j2 f39191a;

    /* renamed from: b  reason: collision with root package name */
    private final e5 f39192b;

    /* renamed from: c  reason: collision with root package name */
    public final SharedPreferences f39193c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f39194d;

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lbo/app/q$a;", "", "", "MESSAGING_SESSION_END_TIMESTAMP_KEY", "Ljava/lang/String;", "MESSAGING_SESSION_PREFS_FILE", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class b extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f39195b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ long f39196c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ long f39197d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(long j11, long j12, long j13) {
            super(0);
            this.f39195b = j11;
            this.f39196c = j12;
            this.f39197d = j13;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Messaging session timeout: " + this.f39195b + ", current diff: " + (this.f39196c - this.f39197d);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final c f39198b = new c();

        public c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Publishing new messaging session event.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class d extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final d f39199b = new d();

        public d() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Messaging session not started.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class e extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f39200b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(long j11) {
            super(0);
            this.f39200b = j11;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Messaging session stopped. Adding new messaging session timestamp: ", Long.valueOf(this.f39200b));
        }
    }

    public q(Context context, j2 j2Var, e5 e5Var) {
        Intrinsics.checkNotNullParameter(context, "applicationContext");
        Intrinsics.checkNotNullParameter(j2Var, "eventPublisher");
        Intrinsics.checkNotNullParameter(e5Var, "serverConfigStorageProvider");
        this.f39191a = j2Var;
        this.f39192b = e5Var;
        this.f39193c = context.getSharedPreferences("com.appboy.storage.sessions.messaging_session", 0);
    }

    public final boolean a() {
        long h11 = this.f39192b.h();
        if (h11 == -1 || this.f39194d) {
            return false;
        }
        long j11 = this.f39193c.getLong("messaging_session_timestamp", -1);
        long nowInSeconds = DateTimeUtils.nowInSeconds();
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new b(h11, nowInSeconds, j11), 7, (Object) null);
        if (j11 + h11 < nowInSeconds) {
            return true;
        }
        return false;
    }

    public final void b() {
        if (a()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) c.f39198b, 7, (Object) null);
            this.f39191a.a(p3.f39178b, p3.class);
            this.f39194d = true;
            return;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) d.f39199b, 7, (Object) null);
    }

    public final void c() {
        long nowInSeconds = DateTimeUtils.nowInSeconds();
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new e(nowInSeconds), 7, (Object) null);
        this.f39193c.edit().putLong("messaging_session_timestamp", nowInSeconds).apply();
        this.f39194d = false;
    }
}
