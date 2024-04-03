package bo.app;

import android.content.Context;
import com.amazon.device.messaging.ADM;
import com.amazon.device.messaging.development.ADMManifest;
import com.braze.support.BrazeLogger;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0003B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\n"}, d2 = {"Lbo/app/b;", "", "", "a", "Landroid/content/Context;", "context", "Lbo/app/m2;", "admRegistrationDataProvider", "<init>", "(Landroid/content/Context;Lbo/app/m2;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class b {

    /* renamed from: c  reason: collision with root package name */
    public static final a f38286c = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final Context f38287a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final m2 f38288b;

    @Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007R\u0014\u0010\b\u001a\u00020\u00078\u0002XT¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lbo/app/b$a;", "", "", "a", "Landroid/content/Context;", "context", "b", "", "ADM_INSTANCE_CLASSPATH", "Ljava/lang/String;", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
    public static final class a {

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        /* renamed from: bo.app.b$a$a  reason: collision with other inner class name */
        public static final class C0015a extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final C0015a f38289b = new C0015a();

            public C0015a() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "com.amazon.device.messaging.ADM not found";
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        /* renamed from: bo.app.b$a$b  reason: collision with other inner class name */
        public static final class C0016b extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Exception f38290b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0016b(Exception exc) {
                super(0);
                this.f38290b = exc;
            }

            /* renamed from: a */
            public final String invoke() {
                return Intrinsics.stringPlus("Manifest not authored properly to support ADM. ADM manifest exception: ", this.f38290b);
            }
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final boolean b(Context context) {
            try {
                ADMManifest.checkManifestAuthoredProperly(context);
                return true;
            } catch (Exception e11) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) new C0016b(e11), 6, (Object) null);
                return false;
            }
        }

        @JvmStatic
        public final boolean a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return a() && b(context);
        }

        private final boolean a() {
            try {
                Class.forName("com.amazon.device.messaging.ADM");
                return true;
            } catch (Exception unused) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) C0015a.f38289b, 6, (Object) null);
                return false;
            }
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    /* renamed from: bo.app.b$b  reason: collision with other inner class name */
    public static final class C0017b extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b f38291b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0017b(b bVar) {
            super(0);
            this.f38291b = bVar;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("The device is already registered with the ADM server and is eligible to receive ADM messages.ADM registration id: ", this.f38291b.f38288b.a());
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final c f38292b = new c();

        public c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Registering with ADM server...";
        }
    }

    public b(Context context, m2 m2Var) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(m2Var, "admRegistrationDataProvider");
        this.f38287a = context;
        this.f38288b = m2Var;
    }

    public final void a() {
        if (this.f38288b.a() != null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) new C0017b(this), 6, (Object) null);
            m2 m2Var = this.f38288b;
            m2Var.a(m2Var.a());
            return;
        }
        ADM adm = new ADM(this.f38287a);
        if (adm.isSupported()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) c.f38292b, 6, (Object) null);
            adm.startRegister();
        }
    }
}
