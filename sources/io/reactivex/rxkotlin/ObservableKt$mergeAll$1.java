package io.reactivex.rxkotlin;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lio/reactivex/Observable;", "T", "", "it", "apply"}, k = 3, mv = {1, 1, 15})
public final class ObservableKt$mergeAll$1<T, R> implements Function<T, ObservableSource<? extends R>> {
    public static final ObservableKt$mergeAll$1 INSTANCE = new ObservableKt$mergeAll$1();

    @NotNull
    public final Observable<T> apply(@NotNull Observable<T> observable) {
        Intrinsics.checkParameterIsNotNull(observable, "it");
        return observable;
    }
}
