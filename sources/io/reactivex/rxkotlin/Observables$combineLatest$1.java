package io.reactivex.rxkotlin;

import io.reactivex.functions.BiFunction;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0005\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003\"\b\b\u0002\u0010\u0001*\u00020\u00032\u0006\u0010\u0005\u001a\u0002H\u00022\u0006\u0010\u0006\u001a\u0002H\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "R", "T1", "", "T2", "t1", "t2", "apply", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 15})
public final class Observables$combineLatest$1<T1, T2, R> implements BiFunction<T1, T2, R> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function2 f23524b;

    public Observables$combineLatest$1(Function2 function2) {
        this.f23524b = function2;
    }

    @NotNull
    public final R apply(@NotNull T1 t12, @NotNull T2 t22) {
        Intrinsics.checkParameterIsNotNull(t12, "t1");
        Intrinsics.checkParameterIsNotNull(t22, "t2");
        return this.f23524b.invoke(t12, t22);
    }
}
