package io.reactivex.rxkotlin;

import io.reactivex.functions.Function9;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0013\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003\"\b\b\u0002\u0010\u0005*\u00020\u0003\"\b\b\u0003\u0010\u0006*\u00020\u0003\"\b\b\u0004\u0010\u0007*\u00020\u0003\"\b\b\u0005\u0010\b*\u00020\u0003\"\b\b\u0006\u0010\t*\u00020\u0003\"\b\b\u0007\u0010\n*\u00020\u0003\"\b\b\b\u0010\u000b*\u00020\u0003\"\b\b\t\u0010\u0001*\u00020\u00032\u0006\u0010\f\u001a\u0002H\u00022\u0006\u0010\r\u001a\u0002H\u00042\u0006\u0010\u000e\u001a\u0002H\u00052\u0006\u0010\u000f\u001a\u0002H\u00062\u0006\u0010\u0010\u001a\u0002H\u00072\u0006\u0010\u0011\u001a\u0002H\b2\u0006\u0010\u0012\u001a\u0002H\t2\u0006\u0010\u0013\u001a\u0002H\n2\u0006\u0010\u0014\u001a\u0002H\u000bH\n¢\u0006\u0004\b\u0015\u0010\u0016"}, d2 = {"<anonymous>", "R", "T1", "", "T2", "T3", "T4", "T5", "T6", "T7", "T8", "T9", "t1", "t2", "t3", "t4", "t5", "t6", "t7", "t8", "t9", "apply", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 15})
public final class Singles$zip$10<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> implements Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.functions.Function9 f23546a;

    public Singles$zip$10(kotlin.jvm.functions.Function9 function9) {
        this.f23546a = function9;
    }

    @NotNull
    public final R apply(@NotNull T1 t12, @NotNull T2 t22, @NotNull T3 t32, @NotNull T4 t42, @NotNull T5 t52, @NotNull T6 t62, @NotNull T7 t72, @NotNull T8 t82, @NotNull T9 t92) {
        Intrinsics.checkParameterIsNotNull(t12, "t1");
        Intrinsics.checkParameterIsNotNull(t22, "t2");
        Intrinsics.checkParameterIsNotNull(t32, "t3");
        Intrinsics.checkParameterIsNotNull(t42, "t4");
        T5 t53 = t52;
        Intrinsics.checkParameterIsNotNull(t53, "t5");
        T6 t63 = t62;
        Intrinsics.checkParameterIsNotNull(t63, "t6");
        T7 t73 = t72;
        Intrinsics.checkParameterIsNotNull(t73, "t7");
        T8 t83 = t82;
        Intrinsics.checkParameterIsNotNull(t83, "t8");
        T9 t93 = t92;
        Intrinsics.checkParameterIsNotNull(t93, "t9");
        return this.f23546a.invoke(t12, t22, t32, t42, t53, t63, t73, t83, t93);
    }
}
