package io.reactivex.rxkotlin;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.reactivestreams.Publisher;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004\"\b\b\u0001\u0010\u0002*\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "Lio/reactivex/Flowable;", "R", "T", "", "it", "apply", "(Ljava/lang/Object;)Lio/reactivex/Flowable;"}, k = 3, mv = {1, 1, 15})
public final class FlowableKt$flatMapSequence$1<T, R> implements Function<T, Publisher<? extends R>> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f23486b;

    public FlowableKt$flatMapSequence$1(Function1 function1) {
        this.f23486b = function1;
    }

    @NotNull
    public final Flowable<R> apply(@NotNull T t11) {
        Intrinsics.checkParameterIsNotNull(t11, "it");
        return FlowableKt.toFlowable((Sequence) this.f23486b.invoke(t11));
    }
}
