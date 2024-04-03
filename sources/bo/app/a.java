package bo.app;

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
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;

@Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u0004H'¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\t\u001a\u0004\u0018\u00018\u0000H'¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u000b\u0010\nJ\u001d\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\r\u001a\u00020\u0006R\u0011\u0010\u000f\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u000e¨\u0006\u0012"}, d2 = {"Lbo/app/a;", "T", "", "outboundObject", "", "isSuccessful", "", "b", "(Ljava/lang/Object;Z)V", "d", "()Ljava/lang/Object;", "a", "(Ljava/lang/Object;Z)Z", "c", "()Z", "isLocked", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public abstract class a<T> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Semaphore f38213a = SemaphoreKt.Semaphore$default(1, 0, 2, (Object) null);

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"T", "", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    /* renamed from: bo.app.a$a  reason: collision with other inner class name */
    public static final class C0014a extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ T f38214b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f38215c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0014a(T t11, boolean z11) {
            super(0);
            this.f38214b = t11;
            this.f38215c = z11;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Tried to confirm outboundObject [" + this.f38214b + "] with success [" + this.f38215c + "], but the cache wasn't locked, so not doing anything.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"T", "", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class b extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a<T> f38216b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(a<T> aVar) {
            super(0);
            this.f38216b = aVar;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Notifying confirmAndUnlock listeners for cache: ", this.f38216b);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"T", "", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a<T> f38217b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(a<T> aVar) {
            super(0);
            this.f38217b = aVar;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Cache locked successfully for export: ", this.f38217b);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"T", "", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class d extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final d f38218b = new d();

        public d() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Received call to export dirty object, but the cache was already locked.";
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H@"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "com.braze.storage.AbstractLockedCache$lockAndUnlock$1", f = "AbstractLockedCache.kt", i = {0}, l = {90}, m = "invokeSuspend", n = {"$this$withPermit$iv"}, s = {"L$0"})
    public static final class e extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: b  reason: collision with root package name */
        Object f38219b;

        /* renamed from: c  reason: collision with root package name */
        int f38220c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ a<T> f38221d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(a<T> aVar, Continuation<? super e> continuation) {
            super(2, continuation);
            this.f38221d = aVar;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((e) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new e(this.f38221d, continuation);
        }

        /* JADX INFO: finally extract failed */
        public final Object invokeSuspend(Object obj) {
            Semaphore semaphore;
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i11 = this.f38220c;
            if (i11 == 0) {
                ResultKt.throwOnFailure(obj);
                Semaphore a11 = this.f38221d.f38213a;
                this.f38219b = a11;
                this.f38220c = 1;
                if (a11.acquire(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                semaphore = a11;
            } else if (i11 == 1) {
                semaphore = (Semaphore) this.f38219b;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            try {
                Unit unit = Unit.INSTANCE;
                semaphore.release();
                return Unit.INSTANCE;
            } catch (Throwable th2) {
                semaphore.release();
                throw th2;
            }
        }
    }

    public abstract void b(T t11, boolean z11);

    public final boolean b() {
        return this.f38213a.getAvailablePermits() == 0;
    }

    public final void c() {
        Object unused = BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new e(this, (Continuation<? super e>) null), 1, (Object) null);
    }

    public abstract T d();

    public final synchronized T a() {
        T t11;
        if (this.f38213a.tryAcquire()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new c(this), 7, (Object) null);
            t11 = d();
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) d.f38218b, 7, (Object) null);
            t11 = null;
        }
        return t11;
    }

    public final synchronized boolean a(T t11, boolean z11) {
        if (this.f38213a.getAvailablePermits() != 0) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new C0014a(t11, z11), 6, (Object) null);
            return false;
        }
        b(t11, z11);
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new b(this), 6, (Object) null);
        this.f38213a.release();
        return true;
    }
}
