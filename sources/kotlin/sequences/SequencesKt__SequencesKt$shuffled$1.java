package kotlin.sequences;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.random.Random;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H@"}, d2 = {"T", "Lkotlin/sequences/SequenceScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "kotlin.sequences.SequencesKt__SequencesKt$shuffled$1", f = "Sequences.kt", i = {0, 0}, l = {145}, m = "invokeSuspend", n = {"$this$sequence", "buffer"}, s = {"L$0", "L$1"})
public final class SequencesKt__SequencesKt$shuffled$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super T>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public Object f25007h;

    /* renamed from: i  reason: collision with root package name */
    public int f25008i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Sequence<T> f25009j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Random f25010k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SequencesKt__SequencesKt$shuffled$1(Sequence<? extends T> sequence, Random random, Continuation<? super SequencesKt__SequencesKt$shuffled$1> continuation) {
        super(2, continuation);
        this.f25009j = sequence;
        this.f25010k = random;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        SequencesKt__SequencesKt$shuffled$1 sequencesKt__SequencesKt$shuffled$1 = new SequencesKt__SequencesKt$shuffled$1(this.f25009j, this.f25010k, continuation);
        sequencesKt__SequencesKt$shuffled$1.L$0 = obj;
        return sequencesKt__SequencesKt$shuffled$1;
    }

    @Nullable
    public final Object invoke(@NotNull SequenceScope<? super T> sequenceScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SequencesKt__SequencesKt$shuffled$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        SequenceScope sequenceScope;
        List list;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f25008i;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            list = SequencesKt___SequencesKt.toMutableList(this.f25009j);
            sequenceScope = (SequenceScope) this.L$0;
        } else if (i11 == 1) {
            list = (List) this.f25007h;
            sequenceScope = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        while (!list.isEmpty()) {
            int nextInt = this.f25010k.nextInt(list.size());
            Object removeLast = CollectionsKt__MutableCollectionsKt.removeLast(list);
            if (nextInt < list.size()) {
                removeLast = list.set(nextInt, removeLast);
            }
            this.L$0 = sequenceScope;
            this.f25007h = list;
            this.f25008i = 1;
            if (sequenceScope.yield(removeLast, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
