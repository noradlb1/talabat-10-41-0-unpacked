package bo.app;

import com.braze.support.BrazeLogger;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0003\u0010\u0004R$\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\u0003\u0010\nR\u001a\u0010\f\u001a\u00020\u000b8\u0016X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lbo/app/b5;", "Lkotlinx/coroutines/CoroutineScope;", "", "a", "()V", "Lbo/app/z0;", "eventPublisher", "Lbo/app/z0;", "b", "()Lbo/app/z0;", "(Lbo/app/z0;)V", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "<init>", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class b5 implements CoroutineScope {

    /* renamed from: a  reason: collision with root package name */
    public static final b5 f38311a = new b5();

    /* renamed from: b  reason: collision with root package name */
    private static z0 f38312b;

    /* renamed from: c  reason: collision with root package name */
    private static final CoroutineExceptionHandler f38313c;

    /* renamed from: d  reason: collision with root package name */
    private static final ExecutorCoroutineDispatcher f38314d;

    /* renamed from: e  reason: collision with root package name */
    private static final CoroutineContext f38315e;

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class a extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final a f38316b = new a();

        public a() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Cancelling children of SerialCoroutineScope";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class b extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Throwable f38317b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Throwable th2) {
            super(0);
            this.f38317b = th2;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Child job of SerialCoroutineScope got exception: ", this.f38317b);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "", "handleException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public static final class c extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public c(CoroutineExceptionHandler.Key key) {
            super(key);
        }

        public void handleException(CoroutineContext coroutineContext, Throwable th2) {
            try {
                BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
                b5 b5Var = b5.f38311a;
                BrazeLogger.brazelog$default(brazeLogger, (Object) b5Var, BrazeLogger.Priority.E, th2, false, (Function0) new b(th2), 4, (Object) null);
                z0 b11 = b5Var.b();
                if (b11 != null) {
                    b11.a(th2, Throwable.class);
                }
            } catch (Exception unused) {
            }
        }
    }

    static {
        c cVar = new c(CoroutineExceptionHandler.Key);
        f38313c = cVar;
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(newSingleThreadExecutor, "newSingleThreadExecutor()");
        ExecutorCoroutineDispatcher from = ExecutorsKt.from(newSingleThreadExecutor);
        f38314d = from;
        f38315e = from.plus(cVar).plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null));
    }

    private b5() {
    }

    public final void a(z0 z0Var) {
        f38312b = z0Var;
    }

    public final z0 b() {
        return f38312b;
    }

    public CoroutineContext getCoroutineContext() {
        return f38315e;
    }

    public final void a() {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) a.f38316b, 6, (Object) null);
        JobKt__JobKt.cancelChildren$default(getCoroutineContext(), (CancellationException) null, 1, (Object) null);
    }
}
