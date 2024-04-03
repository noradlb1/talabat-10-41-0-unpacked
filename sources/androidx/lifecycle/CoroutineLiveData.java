package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002BM\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017\u0012-\u0010\u001e\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0019¢\u0006\u0002\b\u001dø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 J!\u0010\b\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\f\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\r\u001a\u00020\tH\u0014J\b\u0010\u000e\u001a\u00020\tH\u0014R\u001e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u0002\u0004\n\u0002\b\u0019¨\u0006!"}, d2 = {"Landroidx/lifecycle/CoroutineLiveData;", "T", "Landroidx/lifecycle/MediatorLiveData;", "Landroidx/lifecycle/LiveData;", "source", "Lkotlinx/coroutines/DisposableHandle;", "emitSource$lifecycle_livedata_ktx_release", "(Landroidx/lifecycle/LiveData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitSource", "", "clearSource$lifecycle_livedata_ktx_release", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearSource", "e", "f", "Landroidx/lifecycle/BlockRunner;", "blockRunner", "Landroidx/lifecycle/BlockRunner;", "Landroidx/lifecycle/EmittedSource;", "emittedSource", "Landroidx/lifecycle/EmittedSource;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "timeoutInMs", "Lkotlin/Function2;", "Landroidx/lifecycle/LiveDataScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "block", "<init>", "(Lkotlin/coroutines/CoroutineContext;JLkotlin/jvm/functions/Function2;)V", "lifecycle-livedata-ktx_release"}, k = 1, mv = {1, 4, 1})
public final class CoroutineLiveData<T> extends MediatorLiveData<T> {
    /* access modifiers changed from: private */
    public BlockRunner<T> blockRunner;
    private EmittedSource emittedSource;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CoroutineLiveData(CoroutineContext coroutineContext, long j11, Function2 function2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? EmptyCoroutineContext.INSTANCE : coroutineContext, (i11 & 2) != 0 ? 5000 : j11, function2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object clearSource$lifecycle_livedata_ktx_release(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof androidx.lifecycle.CoroutineLiveData$clearSource$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            androidx.lifecycle.CoroutineLiveData$clearSource$1 r0 = (androidx.lifecycle.CoroutineLiveData$clearSource$1) r0
            int r1 = r0.f35991i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f35991i = r1
            goto L_0x0018
        L_0x0013:
            androidx.lifecycle.CoroutineLiveData$clearSource$1 r0 = new androidx.lifecycle.CoroutineLiveData$clearSource$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.f35990h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f35991i
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r0 = r0.f35993k
            androidx.lifecycle.CoroutineLiveData r0 = (androidx.lifecycle.CoroutineLiveData) r0
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x0048
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r5)
            androidx.lifecycle.EmittedSource r5 = r4.emittedSource
            if (r5 == 0) goto L_0x0047
            r0.f35993k = r4
            r0.f35991i = r3
            java.lang.Object r5 = r5.disposeNow(r0)
            if (r5 != r1) goto L_0x0047
            return r1
        L_0x0047:
            r0 = r4
        L_0x0048:
            r5 = 0
            r0.emittedSource = r5
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.CoroutineLiveData.clearSource$lifecycle_livedata_ktx_release(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public void e() {
        super.e();
        BlockRunner<T> blockRunner2 = this.blockRunner;
        if (blockRunner2 != null) {
            blockRunner2.maybeRun();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0065 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object emitSource$lifecycle_livedata_ktx_release(@org.jetbrains.annotations.NotNull androidx.lifecycle.LiveData<T> r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlinx.coroutines.DisposableHandle> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof androidx.lifecycle.CoroutineLiveData$emitSource$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            androidx.lifecycle.CoroutineLiveData$emitSource$1 r0 = (androidx.lifecycle.CoroutineLiveData$emitSource$1) r0
            int r1 = r0.f35995i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f35995i = r1
            goto L_0x0018
        L_0x0013:
            androidx.lifecycle.CoroutineLiveData$emitSource$1 r0 = new androidx.lifecycle.CoroutineLiveData$emitSource$1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f35994h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f35995i
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0046
            if (r2 == r4) goto L_0x0038
            if (r2 != r3) goto L_0x0030
            java.lang.Object r6 = r0.f35997k
            androidx.lifecycle.CoroutineLiveData r6 = (androidx.lifecycle.CoroutineLiveData) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0066
        L_0x0030:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0038:
            java.lang.Object r6 = r0.f35998l
            androidx.lifecycle.LiveData r6 = (androidx.lifecycle.LiveData) r6
            java.lang.Object r2 = r0.f35997k
            androidx.lifecycle.CoroutineLiveData r2 = (androidx.lifecycle.CoroutineLiveData) r2
            kotlin.ResultKt.throwOnFailure(r7)
            r7 = r6
            r6 = r2
            goto L_0x0058
        L_0x0046:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.f35997k = r5
            r0.f35998l = r6
            r0.f35995i = r4
            java.lang.Object r7 = r5.clearSource$lifecycle_livedata_ktx_release(r0)
            if (r7 != r1) goto L_0x0056
            return r1
        L_0x0056:
            r7 = r6
            r6 = r5
        L_0x0058:
            r0.f35997k = r6
            r2 = 0
            r0.f35998l = r2
            r0.f35995i = r3
            java.lang.Object r7 = androidx.lifecycle.CoroutineLiveDataKt.addDisposableSource(r6, r7, r0)
            if (r7 != r1) goto L_0x0066
            return r1
        L_0x0066:
            androidx.lifecycle.EmittedSource r7 = (androidx.lifecycle.EmittedSource) r7
            r6.emittedSource = r7
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.CoroutineLiveData.emitSource$lifecycle_livedata_ktx_release(androidx.lifecycle.LiveData, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public void f() {
        super.f();
        BlockRunner<T> blockRunner2 = this.blockRunner;
        if (blockRunner2 != null) {
            blockRunner2.cancel();
        }
    }

    public CoroutineLiveData(@NotNull CoroutineContext coroutineContext, long j11, @NotNull Function2<? super LiveDataScope<T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter(coroutineContext, "context");
        Intrinsics.checkNotNullParameter(function2, "block");
        Function2<? super LiveDataScope<T>, ? super Continuation<? super Unit>, ? extends Object> function22 = function2;
        long j12 = j11;
        this.blockRunner = new BlockRunner(this, function22, j12, CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate().plus(coroutineContext).plus(SupervisorKt.SupervisorJob((Job) coroutineContext.get(Job.Key)))), new Function0<Unit>(this) {

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ CoroutineLiveData f35989g;

            {
                this.f35989g = r1;
            }

            public final void invoke() {
                this.f35989g.blockRunner = null;
            }
        });
    }
}
