package androidx.paging;

import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExecutorsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002\"\b\b\u0001\u0010\u0003*\u0002H\u00012\b\u0010\u0004\u001a\u0004\u0018\u0001H\u00032\b\u0010\u0005\u001a\u0004\u0018\u0001H\u0003H@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "R", "", "T", "before", "after", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.PagingDataTransforms$insertSeparators$1", f = "PagingDataTransforms.kt", i = {}, l = {261}, m = "invokeSuspend", n = {}, s = {})
public final class PagingDataTransforms$insertSeparators$1 extends SuspendLambda implements Function3<T, T, Continuation<? super R>, Object> {
    private /* synthetic */ Object L$0;
    private /* synthetic */ Object L$1;

    /* renamed from: h  reason: collision with root package name */
    public int f37040h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Executor f37041i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2 f37042j;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002\"\b\b\u0001\u0010\u0003*\u0002H\u0001*\u00020\u0004H@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "R", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
    @DebugMetadata(c = "androidx.paging.PagingDataTransforms$insertSeparators$1$1", f = "PagingDataTransforms.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.paging.PagingDataTransforms$insertSeparators$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super R>, Object> {

        /* renamed from: h  reason: collision with root package name */
        public int f37043h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ PagingDataTransforms$insertSeparators$1 f37044i;

        {
            this.f37044i = r1;
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "completion");
            return new AnonymousClass1(this.f37044i, obj2, obj3, continuation);
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f37043h == 0) {
                ResultKt.throwOnFailure(obj);
                return this.f37044i.f37042j.invoke(obj2, obj3);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PagingDataTransforms$insertSeparators$1(Executor executor, Function2 function2, Continuation continuation) {
        super(3, continuation);
        this.f37041i = executor;
        this.f37042j = function2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable T t11, @Nullable T t12, @NotNull Continuation<? super R> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        PagingDataTransforms$insertSeparators$1 pagingDataTransforms$insertSeparators$1 = new PagingDataTransforms$insertSeparators$1(this.f37041i, this.f37042j, continuation);
        pagingDataTransforms$insertSeparators$1.L$0 = t11;
        pagingDataTransforms$insertSeparators$1.L$1 = t12;
        return pagingDataTransforms$insertSeparators$1;
    }

    public final Object invoke(Object obj, Object obj2, Object obj3) {
        return ((PagingDataTransforms$insertSeparators$1) create(obj, obj2, (Continuation) obj3)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f37040h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            final Object obj2 = this.L$0;
            final Object obj3 = this.L$1;
            CoroutineDispatcher from = ExecutorsKt.from(this.f37041i);
            AnonymousClass1 r42 = new AnonymousClass1(this, (Continuation) null);
            this.L$0 = null;
            this.f37040h = 1;
            obj = BuildersKt.withContext(from, r42, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
