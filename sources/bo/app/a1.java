package bo.app;

import com.braze.coroutine.BrazeCoroutineScope;
import com.braze.support.BrazeLogger;
import java.util.Collection;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(bv = {}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u0001\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\bH\u0002J\b\u0010\n\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0016\u0010\u0005\u001a\u00020\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\rH\u0016R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0010¨\u0006\u0017"}, d2 = {"Lbo/app/a1;", "Lbo/app/y1;", "", "throwable", "", "a", "", "id", "Lkotlin/Function0;", "block", "close", "Lbo/app/x1;", "event", "", "events", "", "()Ljava/util/Collection;", "allEvents", "storage", "Lbo/app/j2;", "eventPublisher", "<init>", "(Lbo/app/y1;Lbo/app/j2;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class a1 implements y1 {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final y1 f38251a;

    /* renamed from: b  reason: collision with root package name */
    private final j2 f38252b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f38253c;

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 6, 0})
    public static final class a extends Lambda implements Function0<Unit> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a1 f38254b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ x1 f38255c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(a1 a1Var, x1 x1Var) {
            super(0);
            this.f38254b = a1Var;
            this.f38255c = x1Var;
        }

        public final void a() {
            this.f38254b.f38251a.a(this.f38255c);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class b extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final b f38256b = new b();

        public b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Storage provider is closed. Not getting all events.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final c f38257b = new c();

        public c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to get all events from storage.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 6, 0})
    public static final class d extends Lambda implements Function0<Unit> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a1 f38258b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Set<x1> f38259c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(a1 a1Var, Set<? extends x1> set) {
            super(0);
            this.f38258b = a1Var;
            this.f38259c = set;
        }

        public final void a() {
            this.f38258b.f38251a.a((Set<? extends x1>) this.f38259c);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class e extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f38260b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(String str) {
            super(0);
            this.f38260b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Storage provider is closed. Failed to ", this.f38260b);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "com.braze.storage.EventStorageDecorator$doCall$2", f = "EventStorageDecorator.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class f extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: b  reason: collision with root package name */
        int f38261b;

        /* renamed from: c  reason: collision with root package name */
        private /* synthetic */ Object f38262c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f38263d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ a1 f38264e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ String f38265f;

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class a extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f38266b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(0);
                this.f38266b = str;
            }

            /* renamed from: a */
            public final String invoke() {
                return Intrinsics.stringPlus("Failed to ", this.f38266b);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(Function0<Unit> function0, a1 a1Var, String str, Continuation<? super f> continuation) {
            super(2, continuation);
            this.f38263d = function0;
            this.f38264e = a1Var;
            this.f38265f = str;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((f) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            f fVar = new f(this.f38263d, this.f38264e, this.f38265f, continuation);
            fVar.f38262c = obj;
            return fVar;
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f38261b == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.f38262c;
                try {
                    this.f38263d.invoke();
                } catch (Exception e11) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) coroutineScope, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) new a(this.f38265f), 4, (Object) null);
                    this.f38264e.a((Throwable) e11);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class g extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final g f38267b = new g();

        public g() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to log storage exception";
        }
    }

    public a1(y1 y1Var, j2 j2Var) {
        Intrinsics.checkNotNullParameter(y1Var, "storage");
        Intrinsics.checkNotNullParameter(j2Var, "eventPublisher");
        this.f38251a = y1Var;
        this.f38252b = j2Var;
    }

    public void close() {
        this.f38253c = true;
    }

    public Collection<x1> a() {
        if (this.f38253c) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) b.f38256b, 6, (Object) null);
            return SetsKt__SetsKt.emptySet();
        }
        try {
            return this.f38251a.a();
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) c.f38257b, 4, (Object) null);
            a((Throwable) e11);
            return SetsKt__SetsKt.emptySet();
        }
    }

    public void a(x1 x1Var) {
        Intrinsics.checkNotNullParameter(x1Var, "event");
        a(Intrinsics.stringPlus("add event ", x1Var), (Function0<Unit>) new a(this, x1Var));
    }

    public void a(Set<? extends x1> set) {
        Intrinsics.checkNotNullParameter(set, "events");
        a(Intrinsics.stringPlus("delete events ", set), (Function0<Unit>) new d(this, set));
    }

    /* access modifiers changed from: private */
    public final void a(Throwable th2) {
        try {
            this.f38252b.a(new r5("A storage exception has occurred!", th2), r5.class);
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) g.f38267b, 4, (Object) null);
        }
    }

    private final void a(String str, Function0<Unit> function0) {
        String str2 = str;
        if (this.f38253c) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new e(str2), 6, (Object) null);
            return;
        }
        Job unused = BuildersKt__Builders_commonKt.launch$default(BrazeCoroutineScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new f(function0, this, str2, (Continuation<? super f>) null), 3, (Object) null);
    }
}
