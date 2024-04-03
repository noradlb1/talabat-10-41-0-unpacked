package bo.app;

import com.braze.coroutine.BrazeCoroutineScope;
import com.braze.support.BrazeLogger;
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

@Metadata(bv = {}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\u0018"}, d2 = {"Lbo/app/r4;", "Lbo/app/p2;", "Lbo/app/c2;", "brazeRequest", "", "a", "Lbo/app/o2;", "request", "b", "Lbo/app/k2;", "httpConnector", "Lbo/app/j2;", "internalEventPublisher", "externalEventPublisher", "Lbo/app/j1;", "feedStorageProvider", "Lbo/app/e5;", "serverConfigStorageProvider", "Lbo/app/a0;", "contentCardsStorageProvider", "Lbo/app/b2;", "brazeManager", "<init>", "(Lbo/app/k2;Lbo/app/j2;Lbo/app/j2;Lbo/app/j1;Lbo/app/e5;Lbo/app/a0;Lbo/app/b2;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class r4 implements p2 {

    /* renamed from: a  reason: collision with root package name */
    private final k2 f39286a;

    /* renamed from: b  reason: collision with root package name */
    private final j2 f39287b;

    /* renamed from: c  reason: collision with root package name */
    private final j2 f39288c;

    /* renamed from: d  reason: collision with root package name */
    private final j1 f39289d;

    /* renamed from: e  reason: collision with root package name */
    private final e5 f39290e;

    /* renamed from: f  reason: collision with root package name */
    private final a0 f39291f;

    /* renamed from: g  reason: collision with root package name */
    private final b2 f39292g;

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class a extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final a f39293b = new a();

        public a() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Request is null. Cannot execute request.";
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "com.braze.requests.RequestExecutor$execute$2", f = "RequestExecutor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: b  reason: collision with root package name */
        int f39294b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ r4 f39295c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ c2 f39296d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(r4 r4Var, c2 c2Var, Continuation<? super b> continuation) {
            super(2, continuation);
            this.f39295c = r4Var;
            this.f39296d = c2Var;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new b(this.f39295c, this.f39296d, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f39294b == 0) {
                ResultKt.throwOnFailure(obj);
                this.f39295c.a(this.f39296d);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final c f39297b = new c();

        public c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Request is null. Cannot execute request.";
        }
    }

    public r4(k2 k2Var, j2 j2Var, j2 j2Var2, j1 j1Var, e5 e5Var, a0 a0Var, b2 b2Var) {
        Intrinsics.checkNotNullParameter(k2Var, "httpConnector");
        Intrinsics.checkNotNullParameter(j2Var, "internalEventPublisher");
        Intrinsics.checkNotNullParameter(j2Var2, "externalEventPublisher");
        Intrinsics.checkNotNullParameter(j1Var, "feedStorageProvider");
        Intrinsics.checkNotNullParameter(e5Var, "serverConfigStorageProvider");
        Intrinsics.checkNotNullParameter(a0Var, "contentCardsStorageProvider");
        Intrinsics.checkNotNullParameter(b2Var, "brazeManager");
        this.f39286a = k2Var;
        this.f39287b = j2Var;
        this.f39288c = j2Var2;
        this.f39289d = j1Var;
        this.f39290e = e5Var;
        this.f39291f = a0Var;
        this.f39292g = b2Var;
    }

    public void b(o2 o2Var) {
        c2 c2Var;
        o2 o2Var2 = o2Var;
        Intrinsics.checkNotNullParameter(o2Var2, "request");
        if (o2Var2 instanceof c2) {
            c2Var = (c2) o2Var2;
        } else {
            c2Var = null;
        }
        if (c2Var == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) a.f39293b, 6, (Object) null);
            return;
        }
        Job unused = BuildersKt__Builders_commonKt.launch$default(BrazeCoroutineScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new b(this, c2Var, (Continuation<? super b>) null), 3, (Object) null);
    }

    public void a(o2 o2Var) {
        Intrinsics.checkNotNullParameter(o2Var, "request");
        c2 c2Var = o2Var instanceof c2 ? (c2) o2Var : null;
        if (c2Var == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) c.f39297b, 6, (Object) null);
        } else {
            a(c2Var);
        }
    }

    /* access modifiers changed from: private */
    public final void a(c2 c2Var) {
        new s(c2Var, this.f39286a, this.f39287b, this.f39288c, this.f39289d, this.f39292g, this.f39290e, this.f39291f).c();
    }
}
