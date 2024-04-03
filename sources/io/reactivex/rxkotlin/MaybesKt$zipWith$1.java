package io.reactivex.rxkotlin;

import io.reactivex.functions.BiFunction;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0005\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003\"\b\b\u0002\u0010\u0001*\u00020\u00032\u0006\u0010\u0005\u001a\u0002H\u00022\u0006\u0010\u0006\u001a\u0002H\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "R", "T", "", "U", "t", "u", "apply", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 15})
public final class MaybesKt$zipWith$1<T1, T2, R> implements BiFunction<T, U, R> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function2 f23519b;

    public MaybesKt$zipWith$1(Function2 function2) {
        this.f23519b = function2;
    }

    @NotNull
    public final R apply(@NotNull T t11, @NotNull U u11) {
        Intrinsics.checkParameterIsNotNull(t11, "t");
        Intrinsics.checkParameterIsNotNull(u11, "u");
        return this.f23519b.invoke(t11, u11);
    }
}
