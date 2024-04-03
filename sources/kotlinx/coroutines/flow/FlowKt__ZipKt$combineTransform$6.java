package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.internal.CombineKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u0002H@"}, d2 = {"T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$6", f = "Zip.kt", i = {}, l = {251}, m = "invokeSuspend", n = {}, s = {})
public final class FlowKt__ZipKt$combineTransform$6 extends SuspendLambda implements Function2<FlowCollector<? super R>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f26015h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Flow<T>[] f26016i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object> f26017j;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0006\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H@"}, d2 = {"T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "", "it", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$6$2", f = "Zip.kt", i = {}, l = {251}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$6$2  reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;

        /* renamed from: h  reason: collision with root package name */
        public int f26019h;

        /* renamed from: i  reason: collision with root package name */
        public /* synthetic */ Object f26020i;

        @Nullable
        public final Object invoke(@NotNull FlowCollector<? super R> flowCollector, @NotNull T[] tArr, @Nullable Continuation<? super Unit> continuation) {
            AnonymousClass2 r02 = new AnonymousClass2(r3, continuation);
            r02.L$0 = flowCollector;
            r02.f26020i = tArr;
            return r02.invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i11 = this.f26019h;
            if (i11 == 0) {
                ResultKt.throwOnFailure(obj);
                Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object> function3 = r3;
                this.L$0 = null;
                this.f26019h = 1;
                if (function3.invoke((FlowCollector) this.L$0, (Object[]) this.f26020i, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i11 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }

        @Nullable
        public final Object invokeSuspend$$forInline(@NotNull Object obj) {
            r3.invoke((FlowCollector) this.L$0, (Object[]) this.f26020i, this);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__ZipKt$combineTransform$6(Flow<? extends T>[] flowArr, Function3<? super FlowCollector<? super R>, ? super T[], ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super FlowKt__ZipKt$combineTransform$6> continuation) {
        super(2, continuation);
        this.f26016i = flowArr;
        this.f26017j = function3;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FlowKt__ZipKt$combineTransform$6 flowKt__ZipKt$combineTransform$6 = new FlowKt__ZipKt$combineTransform$6(this.f26016i, this.f26017j, continuation);
        flowKt__ZipKt$combineTransform$6.L$0 = obj;
        return flowKt__ZipKt$combineTransform$6;
    }

    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super R> flowCollector, @Nullable Continuation<? super Unit> continuation) {
        return ((FlowKt__ZipKt$combineTransform$6) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f26015h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Flow<T>[] flowArr = this.f26016i;
            Intrinsics.needClassReification();
            final Flow<T>[] flowArr2 = this.f26016i;
            AnonymousClass1 r32 = new Function0<T[]>() {
                @Nullable
                public final T[] invoke() {
                    int length = r2.length;
                    Intrinsics.reifiedOperationMarker(0, "T?");
                    return new Object[length];
                }
            };
            Intrinsics.needClassReification();
            final Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object> function3 = this.f26017j;
            AnonymousClass2 r42 = new AnonymousClass2((Continuation<? super AnonymousClass2>) null);
            this.f26015h = 1;
            if (CombineKt.combineInternal((FlowCollector) this.L$0, flowArr, r32, r42, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invokeSuspend$$forInline(@NotNull Object obj) {
        Flow<T>[] flowArr = this.f26016i;
        Intrinsics.needClassReification();
        final Flow<T>[] flowArr2 = this.f26016i;
        AnonymousClass1 r12 = new Function0<T[]>() {
            @Nullable
            public final T[] invoke() {
                int length = flowArr2.length;
                Intrinsics.reifiedOperationMarker(0, "T?");
                return new Object[length];
            }
        };
        Intrinsics.needClassReification();
        final Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object> function3 = this.f26017j;
        AnonymousClass2 r22 = new AnonymousClass2((Continuation<? super AnonymousClass2>) null);
        InlineMarker.mark(0);
        CombineKt.combineInternal((FlowCollector) this.L$0, flowArr, r12, r22, this);
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }
}
