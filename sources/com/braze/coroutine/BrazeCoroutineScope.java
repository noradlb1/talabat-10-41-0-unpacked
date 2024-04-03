package com.braze.coroutine;

import com.braze.support.BrazeLogger;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0001J>\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00042\u001c\u0010\u0010\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0011ø\u0001\u0000¢\u0006\u0002\u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Lcom/braze/coroutine/BrazeCoroutineScope;", "Lkotlinx/coroutines/CoroutineScope;", "()V", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "cancelChildren", "", "launchDelayed", "Lkotlinx/coroutines/Job;", "startDelayInMs", "", "specificContext", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Ljava/lang/Number;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/Job;", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BrazeCoroutineScope implements CoroutineScope {
    public static final BrazeCoroutineScope INSTANCE = new BrazeCoroutineScope();
    private static final CoroutineContext coroutineContext;
    private static final CoroutineExceptionHandler exceptionHandler;

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class a extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final a f43718b = new a();

        public a() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Cancelling children of BrazeCoroutineScope";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class b extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Throwable f43719g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Throwable th2) {
            super(0);
            this.f43719g = th2;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Child job of BrazeCoroutineScope got exception: ", this.f43719g);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "com.braze.coroutine.BrazeCoroutineScope$launchDelayed$1", f = "BrazeCoroutineScope.kt", i = {0}, l = {52, 55}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: c  reason: collision with root package name */
        private /* synthetic */ Object f43720c;

        /* renamed from: h  reason: collision with root package name */
        public int f43721h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Number f43722i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ Function1<Continuation<? super Unit>, Object> f43723j;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(Number number, Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super c> continuation) {
            super(2, continuation);
            this.f43722i = number;
            this.f43723j = function1;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            c cVar = new c(this.f43722i, this.f43723j, continuation);
            cVar.f43720c = obj;
            return cVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: kotlinx.coroutines.CoroutineScope} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r6.f43721h
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x0022
                if (r1 == r3) goto L_0x001a
                if (r1 != r2) goto L_0x0012
                kotlin.ResultKt.throwOnFailure(r7)
                goto L_0x004f
            L_0x0012:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L_0x001a:
                java.lang.Object r1 = r6.f43720c
                kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
                kotlin.ResultKt.throwOnFailure(r7)
                goto L_0x003b
            L_0x0022:
                kotlin.ResultKt.throwOnFailure(r7)
                java.lang.Object r7 = r6.f43720c
                r1 = r7
                kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
                java.lang.Number r7 = r6.f43722i
                long r4 = r7.longValue()
                r6.f43720c = r1
                r6.f43721h = r3
                java.lang.Object r7 = kotlinx.coroutines.DelayKt.delay(r4, r6)
                if (r7 != r0) goto L_0x003b
                return r0
            L_0x003b:
                boolean r7 = kotlinx.coroutines.CoroutineScopeKt.isActive(r1)
                if (r7 == 0) goto L_0x004f
                kotlin.jvm.functions.Function1<kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r7 = r6.f43723j
                r1 = 0
                r6.f43720c = r1
                r6.f43721h = r2
                java.lang.Object r7 = r7.invoke(r6)
                if (r7 != r0) goto L_0x004f
                return r0
            L_0x004f:
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.braze.coroutine.BrazeCoroutineScope.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "", "handleException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public static final class d extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public d(CoroutineExceptionHandler.Key key) {
            super(key);
        }

        public void handleException(CoroutineContext coroutineContext, Throwable th2) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) BrazeCoroutineScope.INSTANCE, BrazeLogger.Priority.E, th2, false, (Function0) new b(th2), 4, (Object) null);
        }
    }

    static {
        d dVar = new d(CoroutineExceptionHandler.Key);
        exceptionHandler = dVar;
        coroutineContext = Dispatchers.getIO().plus(dVar).plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null));
    }

    private BrazeCoroutineScope() {
    }

    @JvmStatic
    public static final void cancelChildren() {
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeCoroutineScope brazeCoroutineScope = INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) brazeCoroutineScope, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) a.f43718b, 6, (Object) null);
        JobKt__JobKt.cancelChildren$default(brazeCoroutineScope.getCoroutineContext(), (CancellationException) null, 1, (Object) null);
    }

    public static /* synthetic */ Job launchDelayed$default(BrazeCoroutineScope brazeCoroutineScope, Number number, CoroutineContext coroutineContext2, Function1 function1, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            coroutineContext2 = brazeCoroutineScope.getCoroutineContext();
        }
        return brazeCoroutineScope.launchDelayed(number, coroutineContext2, function1);
    }

    public CoroutineContext getCoroutineContext() {
        return coroutineContext;
    }

    public final Job launchDelayed(Number number, CoroutineContext coroutineContext2, Function1<? super Continuation<? super Unit>, ? extends Object> function1) {
        Intrinsics.checkNotNullParameter(number, "startDelayInMs");
        Intrinsics.checkNotNullParameter(coroutineContext2, "specificContext");
        Intrinsics.checkNotNullParameter(function1, "block");
        return BuildersKt__Builders_commonKt.launch$default(this, coroutineContext2, (CoroutineStart) null, new c(number, function1, (Continuation<? super c>) null), 2, (Object) null);
    }
}
