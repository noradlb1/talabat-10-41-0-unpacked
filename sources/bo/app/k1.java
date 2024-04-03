package bo.app;

import android.content.Context;
import com.braze.support.BrazeLogger;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0006B\u0017\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\u000e"}, d2 = {"Lbo/app/k1;", "", "", "firebaseSenderId", "", "b", "a", "", "Landroid/content/Context;", "context", "Lbo/app/m2;", "registrationDataProvider", "<init>", "(Landroid/content/Context;Lbo/app/m2;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class k1 {

    /* renamed from: e  reason: collision with root package name */
    public static final a f38774e = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final Context f38775a;

    /* renamed from: b  reason: collision with root package name */
    private final m2 f38776b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f38777c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f38778d = n4.a("com.google.firebase.messaging.FirebaseMessaging", "getToken", (Class<?>[]) new Class[0]);

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\t"}, d2 = {"Lbo/app/k1$a;", "", "", "FIREBASE_INSTANCE_SCOPE", "Ljava/lang/String;", "INSTANCE_ID_CLASSPATH", "MESSAGING_INSTANCE_CLASSPATH", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
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
        public static final b f38779b = new b();

        public b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Firebase Cloud Messaging requires the Google Play Store to be installed.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Task<String> f38780b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(Task<String> task) {
            super(0);
            this.f38780b = task;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Fetching registration token failed using FirebaseMessaging instance with default Firebase installation with exception ", this.f38780b.getException());
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class d extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f38781b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(String str) {
            super(0);
            this.f38781b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Automatically obtained Firebase Cloud Messaging token: ", this.f38781b);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class e extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final e f38782b = new e();

        public e() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to register for Firebase Cloud Messaging";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class f extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f38783b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(String str) {
            super(0);
            this.f38783b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Registering for Firebase Cloud Messaging token using sender id: ", this.f38783b);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class g extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final g f38784b = new g();

        public g() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Firebase Cloud Messaging 'getInstance' method could not obtained. Not registering for Firebase Cloud Messaging.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class h extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final h f38785b = new h();

        public h() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Firebase Cloud Messaging 'InstanceId' object could not be invoked. Not registering for Firebase Cloud Messaging.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class i extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final i f38786b = new i();

        public i() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Firebase Cloud Messaging 'FirebaseInstanceId.getInstance().getToken()' method could not obtained. Not registering for Firebase Cloud Messaging.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class j extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f38787b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(Object obj) {
            super(0);
            this.f38787b = obj;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Automatically obtained Firebase Cloud Messaging token: ", this.f38787b);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class k extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final k f38788b = new k();

        public k() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to get push token via instance id";
        }
    }

    public k1(Context context, m2 m2Var) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(m2Var, "registrationDataProvider");
        this.f38775a = context;
        this.f38776b = m2Var;
        Class<String> cls = String.class;
        this.f38777c = n4.a("com.google.firebase.iid.FirebaseInstanceId", "getToken", (Class<?>[]) new Class[]{cls, cls});
    }

    private final void b(String str) {
        Class<String> cls = String.class;
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.Priority priority = BrazeLogger.Priority.V;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, false, (Function0) new f(str), 6, (Object) null);
        try {
            Method b11 = n4.b("com.google.firebase.iid.FirebaseInstanceId", "getInstance", new Class[0]);
            if (b11 == null) {
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) g.f38784b, 7, (Object) null);
                return;
            }
            Object a11 = n4.a((Object) null, b11, new Object[0]);
            if (a11 == null) {
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) h.f38785b, 7, (Object) null);
                return;
            }
            Method a12 = n4.a(a11.getClass(), "getToken", (Class<?>[]) new Class[]{cls, cls});
            if (a12 == null) {
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) i.f38786b, 7, (Object) null);
                return;
            }
            Object a13 = n4.a(a11, a12, str, FirebaseMessaging.INSTANCE_ID_SCOPE);
            if (a13 instanceof String) {
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, false, (Function0) new j(a13), 6, (Object) null);
                this.f38776b.a((String) a13);
            }
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) k.f38788b, 4, (Object) null);
        }
    }

    public final void a(String str) {
        Intrinsics.checkNotNullParameter(str, "firebaseSenderId");
        try {
            if (this.f38778d) {
                FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new x2.h(this));
            } else if (this.f38777c) {
                b(str);
            }
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) e.f38782b, 4, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public static final void a(k1 k1Var, Task task) {
        Intrinsics.checkNotNullParameter(k1Var, "this$0");
        Intrinsics.checkNotNullParameter(task, "task");
        if (!task.isSuccessful()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) k1Var, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new c(task), 6, (Object) null);
            return;
        }
        String str = (String) task.getResult();
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) k1Var, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new d(str), 6, (Object) null);
        k1Var.f38776b.a(str);
    }

    public final boolean a() {
        if (!s1.b(this.f38775a)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) b.f38779b, 6, (Object) null);
            return false;
        } else if (this.f38777c || this.f38778d) {
            return true;
        } else {
            return false;
        }
    }
}
