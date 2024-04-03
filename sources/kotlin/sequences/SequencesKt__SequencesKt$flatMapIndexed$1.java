package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00020\u0003H@"}, d2 = {"T", "C", "R", "Lkotlin/sequences/SequenceScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "kotlin.sequences.SequencesKt__SequencesKt$flatMapIndexed$1", f = "Sequences.kt", i = {0, 0}, l = {332}, m = "invokeSuspend", n = {"$this$sequence", "index"}, s = {"L$0", "I$0"})
public final class SequencesKt__SequencesKt$flatMapIndexed$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super R>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public Object f24996h;

    /* renamed from: i  reason: collision with root package name */
    public int f24997i;

    /* renamed from: j  reason: collision with root package name */
    public int f24998j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Sequence<T> f24999k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function2<Integer, T, C> f25000l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function1<C, Iterator<R>> f25001m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SequencesKt__SequencesKt$flatMapIndexed$1(Sequence<? extends T> sequence, Function2<? super Integer, ? super T, ? extends C> function2, Function1<? super C, ? extends Iterator<? extends R>> function1, Continuation<? super SequencesKt__SequencesKt$flatMapIndexed$1> continuation) {
        super(2, continuation);
        this.f24999k = sequence;
        this.f25000l = function2;
        this.f25001m = function1;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        SequencesKt__SequencesKt$flatMapIndexed$1 sequencesKt__SequencesKt$flatMapIndexed$1 = new SequencesKt__SequencesKt$flatMapIndexed$1(this.f24999k, this.f25000l, this.f25001m, continuation);
        sequencesKt__SequencesKt$flatMapIndexed$1.L$0 = obj;
        return sequencesKt__SequencesKt$flatMapIndexed$1;
    }

    @Nullable
    public final Object invoke(@NotNull SequenceScope<? super R> sequenceScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SequencesKt__SequencesKt$flatMapIndexed$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        int i11;
        SequenceScope sequenceScope;
        Iterator<T> it;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i12 = this.f24998j;
        if (i12 == 0) {
            ResultKt.throwOnFailure(obj);
            sequenceScope = (SequenceScope) this.L$0;
            i11 = 0;
            it = this.f24999k.iterator();
        } else if (i12 == 1) {
            int i13 = this.f24997i;
            it = (Iterator) this.f24996h;
            sequenceScope = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            i11 = i13;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        while (it.hasNext()) {
            T next = it.next();
            Function2<Integer, T, C> function2 = this.f25000l;
            int i14 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            C invoke = function2.invoke(Boxing.boxInt(i11), next);
            this.L$0 = sequenceScope;
            this.f24996h = it;
            this.f24997i = i14;
            this.f24998j = 1;
            if (sequenceScope.yieldAll(this.f25001m.invoke(invoke), (Continuation<? super Unit>) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            i11 = i14;
        }
        return Unit.INSTANCE;
    }
}
