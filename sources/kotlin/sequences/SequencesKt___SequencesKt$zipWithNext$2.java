package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u0002H@"}, d2 = {"T", "R", "Lkotlin/sequences/SequenceScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "kotlin.sequences.SequencesKt___SequencesKt$zipWithNext$2", f = "_Sequences.kt", i = {0, 0, 0}, l = {2864}, m = "invokeSuspend", n = {"$this$result", "iterator", "next"}, s = {"L$0", "L$1", "L$2"})
public final class SequencesKt___SequencesKt$zipWithNext$2 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super R>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public Object f25060h;

    /* renamed from: i  reason: collision with root package name */
    public Object f25061i;

    /* renamed from: j  reason: collision with root package name */
    public int f25062j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Sequence<T> f25063k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function2<T, T, R> f25064l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SequencesKt___SequencesKt$zipWithNext$2(Sequence<? extends T> sequence, Function2<? super T, ? super T, ? extends R> function2, Continuation<? super SequencesKt___SequencesKt$zipWithNext$2> continuation) {
        super(2, continuation);
        this.f25063k = sequence;
        this.f25064l = function2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        SequencesKt___SequencesKt$zipWithNext$2 sequencesKt___SequencesKt$zipWithNext$2 = new SequencesKt___SequencesKt$zipWithNext$2(this.f25063k, this.f25064l, continuation);
        sequencesKt___SequencesKt$zipWithNext$2.L$0 = obj;
        return sequencesKt___SequencesKt$zipWithNext$2;
    }

    @Nullable
    public final Object invoke(@NotNull SequenceScope<? super R> sequenceScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SequencesKt___SequencesKt$zipWithNext$2) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        T t11;
        SequenceScope sequenceScope;
        Iterator<T> it;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f25062j;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            SequenceScope sequenceScope2 = (SequenceScope) this.L$0;
            Iterator<T> it2 = this.f25063k.iterator();
            if (!it2.hasNext()) {
                return Unit.INSTANCE;
            }
            sequenceScope = sequenceScope2;
            t11 = it2.next();
            it = it2;
        } else if (i11 == 1) {
            T t12 = this.f25061i;
            it = (Iterator) this.f25060h;
            sequenceScope = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            t11 = t12;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        while (it.hasNext()) {
            T next = it.next();
            R invoke = this.f25064l.invoke(t11, next);
            this.L$0 = sequenceScope;
            this.f25060h = it;
            this.f25061i = next;
            this.f25062j = 1;
            if (sequenceScope.yield(invoke, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            t11 = next;
        }
        return Unit.INSTANCE;
    }
}
