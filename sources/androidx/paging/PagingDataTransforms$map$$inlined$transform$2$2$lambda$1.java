package androidx.paging;

import androidx.paging.PagingDataTransforms$map$$inlined$transform$2;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004\"\b\b\u0001\u0010\u0002*\u00020\u0004*\u00020\u0005H@¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "Landroidx/paging/PageEvent;", "R", "T", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "androidx/paging/PagingDataTransforms$map$2$1"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.PagingDataTransforms$map$2$1", f = "PagingDataTransforms.kt", i = {}, l = {57}, m = "invokeSuspend", n = {}, s = {})
public final class PagingDataTransforms$map$$inlined$transform$2$2$lambda$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super PageEvent<R>>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f36954h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ PageEvent f36955i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ PagingDataTransforms$map$$inlined$transform$2.AnonymousClass2 f36956j;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "R", "T", "", "it", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "androidx/paging/PagingDataTransforms$map$2$1$1"}, k = 3, mv = {1, 4, 2})
    @DebugMetadata(c = "androidx.paging.PagingDataTransforms$map$2$1$1", f = "PagingDataTransforms.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.paging.PagingDataTransforms$map$$inlined$transform$2$2$lambda$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<T, Continuation<? super R>, Object> {
        private /* synthetic */ Object L$0;

        /* renamed from: h  reason: collision with root package name */
        public int f36957h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ PagingDataTransforms$map$$inlined$transform$2$2$lambda$1 f36958i;

        {
            this.f36958i = r1;
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "completion");
            AnonymousClass1 r02 = new AnonymousClass1(this.f36958i, continuation);
            r02.L$0 = obj;
            return r02;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f36957h == 0) {
                ResultKt.throwOnFailure(obj);
                return this.f36947d.invoke(this.L$0);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PagingDataTransforms$map$$inlined$transform$2$2$lambda$1(PageEvent pageEvent, Continuation continuation, PagingDataTransforms$map$$inlined$transform$2.AnonymousClass2 r32) {
        super(2, continuation);
        this.f36955i = pageEvent;
        this.f36956j = r32;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new PagingDataTransforms$map$$inlined$transform$2$2$lambda$1(this.f36955i, continuation, this.f36956j);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((PagingDataTransforms$map$$inlined$transform$2$2$lambda$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f36954h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            PageEvent pageEvent = this.f36955i;
            AnonymousClass1 r12 = new AnonymousClass1(this, (Continuation) null);
            this.f36954h = 1;
            obj = pageEvent.map(r12, this);
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
