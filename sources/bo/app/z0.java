package bo.app;

import com.braze.events.ContentCardsUpdatedEvent;
import com.braze.events.IEventSubscriber;
import com.braze.support.BrazeLogger;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

@Metadata(bv = {}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJL\u0010\u000b\u001a\u00020\n\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052 \u0010\t\u001a\u001c\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\b0\u0007H\u0002J\u001c\u0010\u000b\u001a\u00020\f\"\u0004\b\u0000\u0010\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0002J.\u0010\u000b\u001a\u00020\n\"\u0004\b\u0000\u0010\u00022\u0010\u0010\r\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002J:\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\b\"\u0004\b\u0000\u0010\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0010\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\bH\u0002J*\u0010\u000f\u001a\u00020\f\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0016J*\u0010\u000b\u001a\u00020\n\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0016J*\u0010\u0010\u001a\u00020\n\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0016J+\u0010\u000b\u001a\u00020\f\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0011\u001a\u00028\u00002\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\u0012J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\fH\u0016R*\u0010\u0014\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0004\u0012\u00020\u00130\u00078\u0000X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u000f\u0010\u0016¨\u0006\u001b"}, d2 = {"Lbo/app/z0;", "Lbo/app/j2;", "T", "Lcom/braze/events/IEventSubscriber;", "subscriber", "Ljava/lang/Class;", "eventClass", "Ljava/util/concurrent/ConcurrentMap;", "Ljava/util/concurrent/CopyOnWriteArraySet;", "subscriptionMap", "", "a", "", "subscribers", "subscriberList", "c", "b", "message", "(Ljava/lang/Object;Ljava/lang/Class;)V", "", "publishReplayCache", "Ljava/util/concurrent/ConcurrentMap;", "()Ljava/util/concurrent/ConcurrentMap;", "Lbo/app/z4;", "sdkEnablementProvider", "<init>", "(Lbo/app/z4;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class z0 implements j2 {

    /* renamed from: a  reason: collision with root package name */
    private final z4 f39611a;

    /* renamed from: b  reason: collision with root package name */
    private final ConcurrentMap<Class<?>, CopyOnWriteArraySet<IEventSubscriber<?>>> f39612b = new ConcurrentHashMap();

    /* renamed from: c  reason: collision with root package name */
    private final ConcurrentMap<Class<?>, CopyOnWriteArraySet<IEventSubscriber<?>>> f39613c = new ConcurrentHashMap();

    /* renamed from: d  reason: collision with root package name */
    private final ConcurrentMap<Class<?>, Object> f39614d = new ConcurrentHashMap();

    /* renamed from: e  reason: collision with root package name */
    private final ReentrantLock f39615e = new ReentrantLock();

    /* renamed from: f  reason: collision with root package name */
    private final ReentrantLock f39616f = new ReentrantLock();

    /* renamed from: g  reason: collision with root package name */
    private final ReentrantLock f39617g = new ReentrantLock();

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"T", "", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class a extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Class<T> f39618b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Class<T> cls) {
            super(0);
            this.f39618b = cls;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Publishing cached event for class: ", this.f39618b);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"T", "", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class b extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Class<T> f39619b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ CopyOnWriteArraySet<IEventSubscriber<?>> f39620c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Class<T> cls, CopyOnWriteArraySet<IEventSubscriber<?>> copyOnWriteArraySet) {
            super(0);
            this.f39619b = cls;
            this.f39620c = copyOnWriteArraySet;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Triggering " + this.f39619b.getName() + " on " + this.f39620c.size() + " subscribers.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"T", "", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Class<T> f39621b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ T f39622c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(Class<T> cls, T t11) {
            super(0);
            this.f39621b = cls;
            this.f39622c = t11;
        }

        /* renamed from: a */
        public final String invoke() {
            return "SDK is disabled. Not publishing event class: " + this.f39621b.getName() + " and message: " + this.f39622c;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"T", "", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class d extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Class<T> f39623b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ T f39624c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(Class<T> cls, T t11) {
            super(0);
            this.f39623b = cls;
            this.f39624c = t11;
        }

        /* renamed from: a */
        public final String invoke() {
            return this.f39623b.getName() + " fired: " + this.f39624c;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H@"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "com.braze.events.EventManager$publish$3", f = "EventManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class e extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: b  reason: collision with root package name */
        int f39625b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ IEventSubscriber<T> f39626c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ T f39627d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(IEventSubscriber<T> iEventSubscriber, T t11, Continuation<? super e> continuation) {
            super(2, continuation);
            this.f39626c = iEventSubscriber;
            this.f39627d = t11;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((e) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new e(this.f39626c, this.f39627d, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f39625b == 0) {
                ResultKt.throwOnFailure(obj);
                this.f39626c.trigger(this.f39627d);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"T", "", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class f extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Class<T> f39628b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(Class<T> cls) {
            super(0);
            this.f39628b = cls;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Event was published, but no subscribers were found. But not saving event for publishing later. Event class: ", this.f39628b);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"T", "", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class g extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Class<T> f39629b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(Class<T> cls) {
            super(0);
            this.f39629b = cls;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Event was published, but no subscribers were found. Saving event for later publishing to a matching subscriber. Event class: ", this.f39629b);
        }
    }

    public z0(z4 z4Var) {
        Intrinsics.checkNotNullParameter(z4Var, "sdkEnablementProvider");
        this.f39611a = z4Var;
    }

    public <T> boolean a(IEventSubscriber<T> iEventSubscriber, Class<T> cls) {
        Intrinsics.checkNotNullParameter(iEventSubscriber, "subscriber");
        Intrinsics.checkNotNullParameter(cls, "eventClass");
        ReentrantLock reentrantLock = this.f39616f;
        reentrantLock.lock();
        try {
            return a(iEventSubscriber, cls, this.f39613c);
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: finally extract failed */
    public <T> boolean b(IEventSubscriber<T> iEventSubscriber, Class<T> cls) {
        Intrinsics.checkNotNullParameter(iEventSubscriber, "subscriber");
        Intrinsics.checkNotNullParameter(cls, "eventClass");
        ReentrantLock reentrantLock = this.f39615e;
        reentrantLock.lock();
        try {
            CopyOnWriteArraySet copyOnWriteArraySet = this.f39612b.get(cls);
            if (copyOnWriteArraySet == null) {
                reentrantLock.unlock();
                return false;
            }
            boolean a11 = a((CopyOnWriteArraySet<IEventSubscriber<?>>) copyOnWriteArraySet, iEventSubscriber);
            reentrantLock.unlock();
            return a11;
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
    }

    public final ConcurrentMap<Class<?>, Object> c() {
        return this.f39614d;
    }

    public <T> void c(IEventSubscriber<T> iEventSubscriber, Class<T> cls) {
        Intrinsics.checkNotNullParameter(iEventSubscriber, "subscriber");
        Intrinsics.checkNotNullParameter(cls, "eventClass");
        ReentrantLock reentrantLock = this.f39615e;
        reentrantLock.lock();
        try {
            a(iEventSubscriber, cls, this.f39612b);
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0095, code lost:
        if (r3.isEmpty() == false) goto L_0x0099;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0079  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> void a(T r18, java.lang.Class<T> r19) {
        /*
            r17 = this;
            r9 = r17
            r0 = r18
            r10 = r19
            java.lang.String r1 = "eventClass"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r1)
            bo.app.z4 r1 = r9.f39611a
            boolean r1 = r1.a()
            if (r1 == 0) goto L_0x0025
            com.braze.support.BrazeLogger r1 = com.braze.support.BrazeLogger.INSTANCE
            bo.app.z0$c r6 = new bo.app.z0$c
            r6.<init>(r10, r0)
            r3 = 0
            r4 = 0
            r5 = 0
            r7 = 7
            r8 = 0
            r2 = r17
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r1, (java.lang.Object) r2, (com.braze.support.BrazeLogger.Priority) r3, (java.lang.Throwable) r4, (boolean) r5, (kotlin.jvm.functions.Function0) r6, (int) r7, (java.lang.Object) r8)
            return
        L_0x0025:
            com.braze.support.BrazeLogger r1 = com.braze.support.BrazeLogger.INSTANCE
            bo.app.z0$d r6 = new bo.app.z0$d
            r6.<init>(r10, r0)
            r3 = 0
            r4 = 0
            r5 = 0
            r7 = 7
            r8 = 0
            r2 = r17
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r1, (java.lang.Object) r2, (com.braze.support.BrazeLogger.Priority) r3, (java.lang.Throwable) r4, (boolean) r5, (kotlin.jvm.functions.Function0) r6, (int) r7, (java.lang.Object) r8)
            java.util.concurrent.ConcurrentMap<java.lang.Class<?>, java.util.concurrent.CopyOnWriteArraySet<com.braze.events.IEventSubscriber<?>>> r1 = r9.f39612b
            java.lang.Object r1 = r1.get(r10)
            java.util.concurrent.CopyOnWriteArraySet r1 = (java.util.concurrent.CopyOnWriteArraySet) r1
            r2 = 1
            if (r1 == 0) goto L_0x006e
            java.util.concurrent.CopyOnWriteArraySet r3 = r9.a(r10, (java.util.concurrent.CopyOnWriteArraySet<com.braze.events.IEventSubscriber<?>>) r1)
            java.util.Iterator r3 = r3.iterator()
        L_0x0049:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0066
            java.lang.Object r4 = r3.next()
            com.braze.events.IEventSubscriber r4 = (com.braze.events.IEventSubscriber) r4
            com.braze.coroutine.BrazeCoroutineScope r11 = com.braze.coroutine.BrazeCoroutineScope.INSTANCE
            bo.app.z0$e r14 = new bo.app.z0$e
            r5 = 0
            r14.<init>(r4, r0, r5)
            r12 = 0
            r13 = 0
            r15 = 3
            r16 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r11, r12, r13, r14, r15, r16)
            goto L_0x0049
        L_0x0066:
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x006e
            r1 = r2
            goto L_0x006f
        L_0x006e:
            r1 = 0
        L_0x006f:
            java.util.concurrent.ConcurrentMap<java.lang.Class<?>, java.util.concurrent.CopyOnWriteArraySet<com.braze.events.IEventSubscriber<?>>> r3 = r9.f39613c
            java.lang.Object r3 = r3.get(r10)
            java.util.concurrent.CopyOnWriteArraySet r3 = (java.util.concurrent.CopyOnWriteArraySet) r3
            if (r3 == 0) goto L_0x0098
            java.util.concurrent.CopyOnWriteArraySet r4 = r9.a(r10, (java.util.concurrent.CopyOnWriteArraySet<com.braze.events.IEventSubscriber<?>>) r3)
            java.util.Iterator r4 = r4.iterator()
        L_0x0081:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0091
            java.lang.Object r5 = r4.next()
            com.braze.events.IEventSubscriber r5 = (com.braze.events.IEventSubscriber) r5
            r5.trigger(r0)
            goto L_0x0081
        L_0x0091:
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L_0x0098
            goto L_0x0099
        L_0x0098:
            r2 = r1
        L_0x0099:
            if (r2 != 0) goto L_0x00df
            if (r0 == 0) goto L_0x00df
            java.lang.Class<com.braze.events.NoMatchingTriggerEvent> r1 = com.braze.events.NoMatchingTriggerEvent.class
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r1)
            if (r1 == 0) goto L_0x00b8
            com.braze.support.BrazeLogger r1 = com.braze.support.BrazeLogger.INSTANCE
            com.braze.support.BrazeLogger$Priority r3 = com.braze.support.BrazeLogger.Priority.I
            bo.app.z0$f r6 = new bo.app.z0$f
            r6.<init>(r10)
            r4 = 0
            r5 = 0
            r7 = 6
            r8 = 0
            r2 = r17
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r1, (java.lang.Object) r2, (com.braze.support.BrazeLogger.Priority) r3, (java.lang.Throwable) r4, (boolean) r5, (kotlin.jvm.functions.Function0) r6, (int) r7, (java.lang.Object) r8)
            goto L_0x00df
        L_0x00b8:
            com.braze.support.BrazeLogger r1 = com.braze.support.BrazeLogger.INSTANCE
            com.braze.support.BrazeLogger$Priority r3 = com.braze.support.BrazeLogger.Priority.I
            bo.app.z0$g r6 = new bo.app.z0$g
            r6.<init>(r10)
            r4 = 0
            r5 = 0
            r7 = 6
            r8 = 0
            r2 = r17
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r1, (java.lang.Object) r2, (com.braze.support.BrazeLogger.Priority) r3, (java.lang.Throwable) r4, (boolean) r5, (kotlin.jvm.functions.Function0) r6, (int) r7, (java.lang.Object) r8)
            java.util.concurrent.locks.ReentrantLock r1 = r9.f39617g
            r1.lock()
            java.util.concurrent.ConcurrentMap r2 = r17.c()     // Catch:{ all -> 0x00da }
            r2.put(r10, r0)     // Catch:{ all -> 0x00da }
            r1.unlock()
            goto L_0x00df
        L_0x00da:
            r0 = move-exception
            r1.unlock()
            throw r0
        L_0x00df:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.z0.a(java.lang.Object, java.lang.Class):void");
    }

    public void b() {
        ReentrantLock reentrantLock = this.f39617g;
        reentrantLock.lock();
        try {
            c().remove(ContentCardsUpdatedEvent.class);
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: finally extract failed */
    public void a() {
        ReentrantLock reentrantLock = this.f39615e;
        reentrantLock.lock();
        try {
            this.f39612b.clear();
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            ReentrantLock reentrantLock2 = this.f39616f;
            reentrantLock2.lock();
            try {
                this.f39613c.clear();
            } finally {
                reentrantLock2.unlock();
            }
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = new java.util.concurrent.CopyOnWriteArraySet();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final <T> boolean a(com.braze.events.IEventSubscriber<T> r2, java.lang.Class<T> r3, java.util.concurrent.ConcurrentMap<java.lang.Class<?>, java.util.concurrent.CopyOnWriteArraySet<com.braze.events.IEventSubscriber<?>>> r4) {
        /*
            r1 = this;
            java.lang.Object r0 = r4.get(r3)
            java.util.concurrent.CopyOnWriteArraySet r0 = (java.util.concurrent.CopyOnWriteArraySet) r0
            if (r0 != 0) goto L_0x0017
            java.util.concurrent.CopyOnWriteArraySet r0 = new java.util.concurrent.CopyOnWriteArraySet
            r0.<init>()
            java.lang.Object r4 = r4.putIfAbsent(r3, r0)
            java.util.concurrent.CopyOnWriteArraySet r4 = (java.util.concurrent.CopyOnWriteArraySet) r4
            if (r4 != 0) goto L_0x0016
            goto L_0x0017
        L_0x0016:
            r0 = r4
        L_0x0017:
            boolean r2 = r0.add(r2)
            r1.a(r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.z0.a(com.braze.events.IEventSubscriber, java.lang.Class, java.util.concurrent.ConcurrentMap):boolean");
    }

    private final <T> void a(Class<T> cls) {
        ReentrantLock reentrantLock = this.f39617g;
        reentrantLock.lock();
        try {
            if (c().containsKey(cls)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new a(cls), 6, (Object) null);
                Object remove = c().remove(cls);
                if (remove != null) {
                    a(remove, cls);
                }
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    private final <T> boolean a(CopyOnWriteArraySet<IEventSubscriber<?>> copyOnWriteArraySet, IEventSubscriber<T> iEventSubscriber) {
        return copyOnWriteArraySet.remove(iEventSubscriber);
    }

    private final <T> CopyOnWriteArraySet<IEventSubscriber<T>> a(Class<T> cls, CopyOnWriteArraySet<IEventSubscriber<?>> copyOnWriteArraySet) {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new b(cls, copyOnWriteArraySet), 7, (Object) null);
        return copyOnWriteArraySet;
    }
}
