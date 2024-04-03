package io.reactivex.rxkotlin;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.reactivestreams.Publisher;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lio/reactivex/Flowable;", "T", "", "it", "apply"}, k = 3, mv = {1, 1, 15})
public final class FlowableKt$concatAll$1<T, R> implements Function<T, Publisher<? extends R>> {
    public static final FlowableKt$concatAll$1 INSTANCE = new FlowableKt$concatAll$1();

    @NotNull
    public final Flowable<T> apply(@NotNull Flowable<T> flowable) {
        Intrinsics.checkParameterIsNotNull(flowable, "it");
        return flowable;
    }
}
