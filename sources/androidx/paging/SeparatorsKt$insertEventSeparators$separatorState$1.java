package androidx.paging;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0002*\u0002H\u0001\"\b\b\u0001\u0010\u0001*\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u0001H\u00022\b\u0010\u0005\u001a\u0004\u0018\u0001H\u0002H@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "R", "T", "", "before", "after", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.SeparatorsKt$insertEventSeparators$separatorState$1", f = "Separators.kt", i = {}, l = {575}, m = "invokeSuspend", n = {}, s = {})
public final class SeparatorsKt$insertEventSeparators$separatorState$1 extends SuspendLambda implements Function3<T, T, Continuation<? super R>, Object> {
    private /* synthetic */ Object L$0;
    private /* synthetic */ Object L$1;

    /* renamed from: h  reason: collision with root package name */
    public int f37119h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function3 f37120i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SeparatorsKt$insertEventSeparators$separatorState$1(Function3 function3, Continuation continuation) {
        super(3, continuation);
        this.f37120i = function3;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable T t11, @Nullable T t12, @NotNull Continuation<? super R> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        SeparatorsKt$insertEventSeparators$separatorState$1 separatorsKt$insertEventSeparators$separatorState$1 = new SeparatorsKt$insertEventSeparators$separatorState$1(this.f37120i, continuation);
        separatorsKt$insertEventSeparators$separatorState$1.L$0 = t11;
        separatorsKt$insertEventSeparators$separatorState$1.L$1 = t12;
        return separatorsKt$insertEventSeparators$separatorState$1;
    }

    public final Object invoke(Object obj, Object obj2, Object obj3) {
        return ((SeparatorsKt$insertEventSeparators$separatorState$1) create(obj, obj2, (Continuation) obj3)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f37119h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Object obj2 = this.L$0;
            Object obj3 = this.L$1;
            Function3 function3 = this.f37120i;
            this.L$0 = null;
            this.f37119h = 1;
            obj = function3.invoke(obj2, obj3, this);
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
