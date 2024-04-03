package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.braze.support.BrazeLogger;
import com.braze.support.StringUtils;
import com.talabat.wallet.features.UrlConstantsKt;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0005B)\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0007R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\f¨\u0006\u0014"}, d2 = {"Lbo/app/o5;", "Lbo/app/y1;", "Lbo/app/x1;", "event", "", "a", "", "events", "close", "", "identifier", "", "()Ljava/util/Collection;", "allEvents", "Landroid/content/Context;", "context", "userId", "apiKey", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class o5 implements y1 {

    /* renamed from: c  reason: collision with root package name */
    public static final a f39103c = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private boolean f39104a;

    /* renamed from: b  reason: collision with root package name */
    private final SharedPreferences f39105b;

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lbo/app/o5$a;", "", "", "BRAZE_EVENT_STORAGE_FILENAME", "Ljava/lang/String;", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
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
        final /* synthetic */ x1 f39106b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(x1 x1Var) {
            super(0);
            this.f39106b = x1Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Storage provider is closed. Not adding event: ", this.f39106b);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x1 f39107b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(x1 x1Var) {
            super(0);
            this.f39107b = x1Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Adding event to storage with uid ", this.f39107b.r());
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class d extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final d f39108b = new d();

        public d() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Storage provider is closed. Not getting all events.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class e extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<String> f39109b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f39110c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(Ref.ObjectRef<String> objectRef, String str) {
            super(0);
            this.f39109b = objectRef;
            this.f39110c = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Could not create BrazeEvent from [serialized event string=" + ((String) this.f39109b.element) + ", unique identifier=" + this.f39110c + "] ... Deleting!";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class f extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final f f39111b = new f();

        public f() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Setting this provider to closed.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class g extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Set<x1> f39112b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(Set<? extends x1> set) {
            super(0);
            this.f39112b = set;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Storage provider is closed. Not deleting events: ", this.f39112b);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class h extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f39113b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(String str) {
            super(0);
            this.f39113b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Deleting event from storage with uid ", this.f39113b);
        }
    }

    public o5(Context context, String str, String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f39105b = context.getSharedPreferences(Intrinsics.stringPlus("com.appboy.storage.appboy_event_storage", StringUtils.getCacheFileSuffix(context, str, str2)), 0);
    }

    public Collection<x1> a() {
        if (this.f39104a) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) d.f39108b, 6, (Object) null);
            return CollectionsKt__CollectionsKt.emptyList();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Map<String, ?> all = this.f39105b.getAll();
        Intrinsics.checkNotNullExpressionValue(all, "prefs.all");
        for (Map.Entry next : all.entrySet()) {
            String str = (String) next.getKey();
            T value = next.getValue();
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = "";
            if (value != null) {
                try {
                    objectRef.element = (String) value;
                    Intrinsics.checkNotNullExpressionValue(str, UrlConstantsKt.WALLET_EVENT_ID);
                    x1 b11 = j.f38653h.b((String) value, str);
                    if (b11 != null) {
                        linkedHashSet.add(b11);
                    }
                } catch (Exception e11) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) new e(objectRef, str), 4, (Object) null);
                    a(str);
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
        }
        return linkedHashSet;
    }

    public void close() {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) f.f39111b, 6, (Object) null);
        this.f39104a = true;
    }

    public void a(x1 x1Var) {
        Intrinsics.checkNotNullParameter(x1Var, "event");
        if (this.f39104a) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new b(x1Var), 6, (Object) null);
            return;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new c(x1Var), 3, (Object) null);
        this.f39105b.edit().putString(x1Var.r(), x1Var.p()).apply();
    }

    public void a(Set<? extends x1> set) {
        Intrinsics.checkNotNullParameter(set, "events");
        if (this.f39104a) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new g(set), 6, (Object) null);
            return;
        }
        SharedPreferences.Editor edit = this.f39105b.edit();
        for (x1 r11 : set) {
            String r12 = r11.r();
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new h(r12), 3, (Object) null);
            edit.remove(r12);
        }
        edit.apply();
    }

    public final void a(String str) {
        SharedPreferences.Editor edit = this.f39105b.edit();
        edit.remove(str);
        edit.apply();
    }
}
