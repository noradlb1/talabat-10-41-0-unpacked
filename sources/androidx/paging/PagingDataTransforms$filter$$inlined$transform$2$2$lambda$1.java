package androidx.paging;

import androidx.paging.PagingDataTransforms$filter$$inlined$transform$2;
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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "Landroidx/paging/PageEvent;", "T", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "androidx/paging/PagingDataTransforms$filter$2$1"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.PagingDataTransforms$filter$2$1", f = "PagingDataTransforms.kt", i = {}, l = {108}, m = "invokeSuspend", n = {}, s = {})
public final class PagingDataTransforms$filter$$inlined$transform$2$2$lambda$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super PageEvent<T>>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f36910h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ PageEvent f36911i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ PagingDataTransforms$filter$$inlined$transform$2.AnonymousClass2 f36912j;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "", "T", "", "it", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "androidx/paging/PagingDataTransforms$filter$2$1$1"}, k = 3, mv = {1, 4, 2})
    @DebugMetadata(c = "androidx.paging.PagingDataTransforms$filter$2$1$1", f = "PagingDataTransforms.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.paging.PagingDataTransforms$filter$$inlined$transform$2$2$lambda$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<T, Continuation<? super Boolean>, Object> {
        private /* synthetic */ Object L$0;

        /* renamed from: h  reason: collision with root package name */
        public int f36913h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ PagingDataTransforms$filter$$inlined$transform$2$2$lambda$1 f36914i;

        {
            this.f36914i = r1;
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "completion");
            AnonymousClass1 r02 = new AnonymousClass1(this.f36914i, continuation);
            r02.L$0 = obj;
            return r02;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f36913h == 0) {
                ResultKt.throwOnFailure(obj);
                return this.f36903d.invoke(this.L$0);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PagingDataTransforms$filter$$inlined$transform$2$2$lambda$1(PageEvent pageEvent, Continuation continuation, PagingDataTransforms$filter$$inlined$transform$2.AnonymousClass2 r32) {
        super(2, continuation);
        this.f36911i = pageEvent;
        this.f36912j = r32;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new PagingDataTransforms$filter$$inlined$transform$2$2$lambda$1(this.f36911i, continuation, this.f36912j);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((PagingDataTransforms$filter$$inlined$transform$2$2$lambda$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f36910h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            PageEvent pageEvent = this.f36911i;
            AnonymousClass1 r12 = new AnonymousClass1(this, (Continuation) null);
            this.f36910h = 1;
            obj = pageEvent.filter(r12, this);
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
