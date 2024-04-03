package com.talabat.helpers;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a[\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003\"\b\b\u0002\u0010\u0001*\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u0001H\u00022\b\u0010\u0006\u001a\u0004\u0018\u0001H\u00042\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0004\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\b¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"safeLet", "R", "T1", "", "T2", "p1", "p2", "block", "Lkotlin/Function2;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "com_talabat_talabatlib_talabatlib"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class SafeLetKt {
    @Nullable
    public static final <T1, T2, R> R safeLet(@Nullable T1 t12, @Nullable T2 t22, @NotNull Function2<? super T1, ? super T2, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(function2, "block");
        if (t12 == null || t22 == null) {
            return null;
        }
        return function2.invoke(t12, t22);
    }
}
